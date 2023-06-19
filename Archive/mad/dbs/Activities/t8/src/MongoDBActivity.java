import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;

public class MongoDBActivity {

	private static final String TEST_PATH = "C:\\Users\\daw1\\Documents\\DAW-PRG-BBDD\\bbdd\\t8\\test\\";

	public static void main(String[] args){
		MongoClient client = MongoClients.create(MongoDBCredentials.createUri());
		MongoDatabase database = client.getDatabase("videoclub");
		Scanner in = new Scanner(System.in);
		System.out.print("¿Restaurar base de datos? (Y/N): ");
		String line = in.nextLine();
		if (line.toLowerCase().charAt(0) == 'y'){
			cleanUp(database);
			deploy(database);
		}
		System.out.print("\n");
		ArrayList<Document> recentRents = threeMonthRents(database);
		recentRents.forEach(res -> {
			String clientId = res.getString("socio_id");
			String clientName = getClientName(database, clientId);
			String movieName = getMovieName(database, res.getString("pelicula_id"));
			System.out.println(String.format("%s, %s, %s", clientId, clientName, movieName));
		});
		Document[] mostViewedActors = getMostViewedActors(database, recentRents);
		for (Document doc : mostViewedActors){
			System.out.println(doc.getString("nombre"));
		}
		in.close();
	}

	private static String[] getMostUsedDisks(MongoDatabase database){
		String[] mostUsedDisks = new String[20];
		MongoCollection<Document> collection = database.getCollection("alquileres");
		FindIterable<Document> result = collection.find();
		HashMap<String, Integer> disks = new HashMap<>();
		int maxUsages = 0;
		for (Document doc : result){
			String disk = doc.getString("dvd_id");
			if (disks.containsKey(disk)) disks.put(disk, disks.get(disk) + 1);
			else disks.put(disk, 1);
			int usages = disks.get(disk);
			if (usages > maxUsages) maxUsages = usages;
		}
		for (int i = 0; i < mostUsedDisks.length; i++){
			if (disks.size() <= 0) break;
			Set<String> keys = disks.keySet();
			int max = 0;
			String maxKey = "";
			for (String key : keys){
				int value = disks.get(key);
				if (value > max){
					max = value;
					maxKey =  key;
				}
			}
			disks.remove(maxKey);
			mostUsedDisks[i] = maxKey;
		}
		return mostUsedDisks;
	}

	private static Document[] getMostViewedActors(MongoDatabase database, List<Document> rents){
		Document[] mostViewed = new Document[5];
		ArrayList<String> movies = new ArrayList<>();
		rents.forEach(rent -> { movies.add(rent.getString("pelicula_id")); });
		MongoCollection<Document> actors = database.getCollection("ACTORES");
		FindIterable<Document> result = actors.find();
		MongoCollection<Document> acting = database.getCollection("actuaciones");
		Bson filter = in("movie_id", movies);
		ActorParticipationComparator comparator = new ActorParticipationComparator(acting, filter);
		PriorityQueue<Document> queue = new PriorityQueue<>(comparator);
		for (Document actor : result) queue.add(actor);
		int size = queue.size() >= 5 ? 5 : queue.size();
		for (int i = 0; i < size; i++){
			mostViewed[i] = queue.poll();
		}
		return mostViewed;
	}

	private static String getClientName(MongoDatabase database, String clientId){
		MongoCollection<Document> collection = database.getCollection("SOCIOS");
		Bson filter = eq("socio_id", clientId);
		FindIterable<Document> result = collection.find(filter);
		Document doc = result.first();
		if (doc == null) return null;
		return doc.getString("nombre");
	}

	private static String getMovieName(MongoDatabase database, String movieId){
		MongoCollection<Document> collection = database.getCollection("PELICULAS");
		Bson filter = eq("pelicula_id", movieId);
		FindIterable<Document> result = collection.find(filter);
		Document doc = result.first();
		if (doc == null) return null;
		return doc.getString("nombre");
	}

	private static ArrayList<Document> threeMonthRents(MongoDatabase database){
		MongoCollection<Document> collection = database.getCollection("alquileres");
		FindIterable<Document> result = collection.find();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate recentDate = LocalDate.now().minusDays(90l);
		ArrayList<Document> validResults = new ArrayList<>();
		for (Document doc : result){
			String dateField = doc.getString("f_alquiler");
			LocalDate date = LocalDate.parse(dateField, format);
			int comparison = date.compareTo(recentDate);
			if (comparison >= 0){
				validResults.add(doc);
			}
		}
		return validResults;
	}

	private static void deploy(MongoDatabase database){
		try{
			database.createCollection("PELICULAS");
			database.createCollection("ACTORES");
			database.createCollection("actuaciones");
			database.createCollection("SOCIOS");
			database.createCollection("alquileres");
			addTestData(database);
			System.out.println("La base de datos se ha desplegado correctamente.");
		}
		catch (Exception e){
			System.out.println("Se ha producido un error al desplegar la base de datos:");
			e.printStackTrace();
		}
	}

	private static void cleanUp(MongoDatabase database){
		try{
			database.getCollection("PELICULAS").drop();
			database.getCollection("ACTORES").drop();
			database.getCollection("actuaciones").drop();
			database.getCollection("SOCIOS").drop();
			database.getCollection("alquileres").drop();
			System.out.println("La base de datos se ha limpiado correctamente.");
		}
		catch (Exception e){
			System.out.println("Se ha producido un error al limpiar la base de datos:");
			e.printStackTrace();
		}
	}

	private static void addTestData(MongoDatabase database){
		File movies = new File(TEST_PATH + "PELICULAS.json");
		File actors = new File(TEST_PATH + "ACTORES.json");
		File actings = new File(TEST_PATH + "actuaciones.json");
		File members = new File(TEST_PATH + "SOCIOS.json");
		File renting = new File(TEST_PATH + "alquileres.json");

		importJson(database, movies, "PELICULAS");
		importJson(database, actors, "ACTORES");
		importJson(database, actings, "actuaciones");
		importJson(database, members, "SOCIOS");
		importJson(database, renting, "alquileres");
	}

	private static void importJson(MongoDatabase database, File file, String collection){
		if (!file.exists()){
			System.out.println("Error al importar archivo: el archivo de prueba " + file.toString() + " no existe.");
			return;
		}
		try{
			List<String> fileDocs = Files.readAllLines(file.toPath());
			for (String doc : fileDocs){
				Document json = Document.parse(doc);
				database.getCollection(collection).insertOne(json);
			}
		}
		catch (Exception e){
			System.out.println("Error al importar archivo:");
			e.printStackTrace();
		}
	}
}

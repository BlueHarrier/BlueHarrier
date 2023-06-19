import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

//import org.bson.Document;

public class MongoDBConnection {
	private MongoClient client;

	public MongoDBConnection(String user, String pass, String ip, String port){
		this.client = MongoClients.create (MongoDBCredentials.createUri(ip, port, user, pass) );
		this.client.startSession();
	}

	public MongoDBConnection(String user, String pass){
		this.client = MongoClients.create( MongoDBCredentials.createUri(user, pass) );
		this.client.startSession();
	}

	public MongoDBConnection(){
		this.client = MongoClients.create( MongoDBCredentials.createUri() );
		this.client.startSession();
	}

	public MongoIterable<String> getDatabases(){
		return this.client.listDatabaseNames();
	}

	public MongoDatabase getDatabase(String db){
		return this.client.getDatabase(db);
	}
}

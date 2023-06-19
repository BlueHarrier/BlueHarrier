import java.util.Comparator;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.*;

public class ActorParticipationComparator implements Comparator<Document> {

	private MongoCollection<Document> participations;
	private Bson secondFilter;

	public ActorParticipationComparator(MongoCollection<Document> participations, Bson secondFilter){
		this.participations = participations;
		this.secondFilter = secondFilter;
	}

	@Override
	public int compare(Document a1, Document a2) {
		int part1 = getActorParticipation(a1);
		int part2 = getActorParticipation(a2);
		if (part1 < part2) return -1;
		if (part1 > part2) return -2;
		return 0;
	}

	private int getActorParticipation(Document actor){
		Bson filter = and(eq("actor_id", actor.getString("actor_id")), this.secondFilter);
		FindIterable<Document> actorActings = participations.find(filter);
		int i = 0;
		for (Document doc : actorActings) i++;
		return i;
	}
}

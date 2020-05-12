package gr.hua.dit.oopii.lec11.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class CollaborativeFiltering {

public static void main(String args[]) {
	ArrayList<Traveller> collectionTravellers=new ArrayList<>();
	Random r = new Random();
	for (int i=0; i<100; i++) {
		Traveller curTraveller = new Traveller("Traveller_"+Integer.toString(i),r.nextInt(90),r.nextInt(2),r.nextInt(2),r.nextInt(2),r.nextInt(2),r.nextInt(2),r.nextInt(2),r.nextInt(2),r.nextInt(2));  		
		curTraveller.setVisit("City_"+Integer.toString(i));
		collectionTravellers.add(curTraveller);		
	}	
	System.out.println(collectionTravellers);
	
	
	Traveller candidateTraveller = new Traveller("Traveller_Candidate",r.nextInt(90),r.nextInt(2),r.nextInt(2),r.nextInt(2),r.nextInt(2),r.nextInt(2),r.nextInt(2),r.nextInt(2),r.nextInt(2));  		
	int[] candidateTravellerCriteria=candidateTraveller.getCriteria();
	
	Map <String,Integer> cityToRank=collectionTravellers.stream().collect(Collectors.toMap(i->i.getVisit(),i->innerDot(i.getCriteria(),candidateTravellerCriteria)));
	cityToRank.forEach((k,v)->System.out.println("city:"+k+" rank: "+v));
		
	Optional<RecommendedCity> recommendedCity=
			collectionTravellers.stream().map(i-> new RecommendedCity(i.getVisit(),innerDot(i.getCriteria(),candidateTravellerCriteria))).max(Comparator.comparingInt(RecommendedCity::getRank));
			
	System.out.println("The Recommended City:"+recommendedCity.get().getCity());
	

}
	private static int innerDot(int[] currentTraveller, int[] candidateTraveller) {
		int sum=0;
		for (int i=0; i<currentTraveller.length;i++)
			sum+=currentTraveller[i]*candidateTraveller[i];
		return sum;
			
	}
	

}




/**
 * @author ${hisham_maged10}
 *https://github.com/hisham-maged10
 * ${DesktopApps}
 */
import java.util.ArrayList;
public class TestQuakeParser
{
	public static void main(String[] args)
	{
		testing();
	}
	public static void testing()
	{
		/*EarthQuakesParser parser=new EarthQuakesParser();
		ArrayList<QuakeEntry> list=parser.getQuakesInfo();
		System.out.println("Loaded quakes");
		for(QuakeEntry e:list)
			System.out.println(e);
		System.out.println("#"+list.size()+" loaded");
		list=parser.getBigQuakes(5.0);
		System.out.println();
		System.out.println("Loaded quakes with magnitude larger than 5.0");
		for(QuakeEntry e:list)
			System.out.println(e);
		System.out.println("Number of items that match the criteria is "+list.size());
		list=parser.getClosest(new Location(-6.211,106.845),3);
		System.out.println();
		System.out.println("Closest earthquake to jakarta is");
		for(QuakeEntry e:list)
			System.out.println(e);
		list=parser.filterByDistanceFrom(1000,new Location(38.17, -118.82));
		System.out.println();
		System.out.println("earthquakes read under 1000 km from kza are");
		for(QuakeEntry e:list)
			System.out.println(e);
		System.out.println("Number of items that match the criteria is "+list.size());
		list=parser.filterByDepth(-8000.0,-5000.0);
		System.out.println();
		System.out.println("earthquakes read of depth between -8k and -5k are");
		for(QuakeEntry e:list)
			System.out.println(e);
		System.out.println("Number of items that match the criteria is "+list.size());
		list=parser.filterByPhrase("any","Creek");
		System.out.println();
		System.out.println("earthquakes read of need");
		for(QuakeEntry e:list)
			System.out.println(e);
		System.out.println("Number of items that match the criteria is "+list.size());
		list=parser.findLargestQuakes(5);
		System.out.println();
		System.out.println("Largest earhquakes are");
		for(QuakeEntry e:list)
			System.out.println(e);
		System.out.println("Number of items that match the criteria is "+list.size());*/
		EarthQuakesParser parser=new EarthQuakesParser();
		//ArrayList<QuakeEntry> list=parser.filter(new MagnitudeFilter(4.0,5.0), new DepthFilter(-35000.0,-12000.0));
		ArrayList<QuakeEntry> list=parser.getQuakesInfo();
		System.out.println("#"+list.size()+" loaded");
		//list=parser.filter(new DistanceFilter(10000,new Location(35.42,139.43)), new PhraseFilter("end","Japan"));
		//list=parser.filter(new MagnitudeFilter(0.0,2.0),new DepthFilter(-100000.0,-10000.0),new PhraseFilter("any","a"));
		//list=parser.filter(new MagnitudeFilter(0.0,3.0),new DistanceFilter(10000,new Location(36.1314,-95.9372)),new PhraseFilter("any","Ca"));
		//list=parser.filter(new DistanceFilter(3000,new Location(35.42, 139.43)),new PhraseFilter("end","Japan"));
		//list=parser.filter(new MagnitudeFilter(0.0,2.0),new DepthFilter(-100000.0,-10000.0),new PhraseFilter("any","a"));
		//list=parser.filter(new PhraseFilter("any","Can"));
		//list=parser.findLargestQuakes(50);
		//list=parser.filter(new MagnitudeFilter(0.0,5.0),new DistanceFilter(3000,new Location(55.7308, 9.1153)),new PhraseFilter("any","e"));
		//list=parser.sortByMagnitudeDestructiveSelection();
		//list=parser.sortByMagnitudeInPlaceSelection();
		//list=parser.sortByMagnitudeInPlaceBubble();
		//list=parser.sortByMagnitudeInPlaceBubbleChecked();
		//list=parser.sortByLargestDepthSelection();
		//list=parser.sortByMagnitudeInPlaceSelectionChecked();
		//list=parser.sort();
		list=parser.sortComparator(new TitleDepthComparator());
		System.out.println("Sorted QuakeEntries:-");
		for(QuakeEntry e:list)
			System.out.println(e);
		System.out.println("Number of items Loaded #"+list.size());
		System.out.println("quake at position 500 is");
		System.out.println(list.get(500));
		System.out.println();
		
	}

	
}
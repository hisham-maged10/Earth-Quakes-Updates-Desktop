/**
 * @author ${hisham_maged10}
 *https://github.com/hisham-maged10
 * ${DesktopApps}
 */
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
public class EarthQuakesParser
{
	ArrayList<QuakeEntry> quakesInfo;
	HashMap<String,ArrayList<String>> parsedXml;
	File source;
	public EarthQuakesParser()
	{
		this(null);
	}
	public EarthQuakesParser(File source)
	{
		this.source=source==null?getFile():source;
		quakesInfo=read(this.source);
	}
	public ArrayList<QuakeEntry> getQuakesInfo()
	{
		return quakesInfo;
	}
	public ArrayList<QuakeEntry> sortComparator(Comparator<QuakeEntry> comparator)
	{
		Collections.sort(quakesInfo,comparator);
		return quakesInfo;
	}
	public ArrayList<QuakeEntry> sort()
	{
		Collections.sort(quakesInfo);
		return quakesInfo;
	}
	private boolean checkInSortedOrder(ArrayList<QuakeEntry> arr)
	{
		for(int i=0,n=arr.size()-1;i<n;i++)
		{
			if(arr.get(i).getMagnitude()>arr.get(i+1).getMagnitude())
				return false;
		}	
		return true;
	}
	//bubble sort in place
	public ArrayList<QuakeEntry> sortByMagnitudeInPlaceBubble()
	{
		QuakeEntry temp=null;
		boolean swapped;
		/*System.out.println("Elements before sort:-");
		for(QuakeEntry qe:quakesInfo)
			System.out.println(qe);*/
		//int passNum=0;
		do
		{	
			swapped=false;
			for(int i=0,n=quakesInfo.size()-1;i<n;i++)
			{
				if(quakesInfo.get(i+1).getMagnitude()<quakesInfo.get(i).getMagnitude())
				{
					temp=quakesInfo.get(i+1);
					quakesInfo.set(i+1,quakesInfo.get(i));
					quakesInfo.set(i,temp);
					swapped=true;
				}
			}
			
		/*System.out.println("Elements after pass#"+(passNum++));
		for(QuakeEntry qe:quakesInfo)
			System.out.println(qe);
			*/	
		
		}while(swapped);
		return quakesInfo;
	}
	//checked bubblesort (not recommended)
	public ArrayList<QuakeEntry> sortByMagnitudeInPlaceBubbleChecked()
	{
		QuakeEntry temp=null;
		boolean swapped;
		System.out.println("Elements before sort:-");
		for(QuakeEntry qe:quakesInfo)
			System.out.println(qe);
		int passNum=1;
		do
		{	
			swapped=false;
			for(int i=0,n=quakesInfo.size()-1;i<n;i++)
			{
				if(quakesInfo.get(i+1).getMagnitude()<quakesInfo.get(i).getMagnitude())
				{
					temp=quakesInfo.get(i+1);
					quakesInfo.set(i+1,quakesInfo.get(i));
					quakesInfo.set(i,temp);
					swapped=true;
				}
			}
			
		System.out.println("Elements after pass#"+(passNum++));
		//for(QuakeEntry qe:quakesInfo)
			//System.out.println(qe);
				
		}while(swapped && !checkInSortedOrder(quakesInfo));
		return quakesInfo;
	}
	//sort by descending depth using selection sort
	public ArrayList<QuakeEntry> sortByLargestDepthSelection()
	{
		int maxIndex;
		QuakeEntry temp=null;
		for(int i=0,n=quakesInfo.size();i<n;i++)
		{
			maxIndex=i;
			for(int j=i;j<n;j++)
			{
				if(quakesInfo.get(j).getDepth()>quakesInfo.get(maxIndex).getDepth())
				{
					maxIndex=j;		
				}
			}
			temp=quakesInfo.get(maxIndex);
			quakesInfo.set(maxIndex,quakesInfo.get(i));
			quakesInfo.set(i,temp);
		}	
		return quakesInfo;
	}
	//selection sort in place
	public ArrayList<QuakeEntry> sortByMagnitudeInPlaceSelection()
	{
		QuakeEntry temp=null;
		int tempIndex;
		int minIndex;
		//selection sort in-place in one method
		/*for(int i=0,n=quakesInfo.size();i<n;i++)
		{
			minIndex=i;
			for(int j=i;j<n;j++)
				if(quakesInfo.get(j).getMagnitude()<quakesInfo.get(minIndex).getMagnitude())
					minIndex=j;
			temp=quakesInfo.get(minIndex);
			quakesInfo.set(minIndex,quakesInfo.get(i));
			quakesInfo.set(i,temp);
		}*/
		//selection sort in-place with helper method
		long start=System.currentTimeMillis();
		for(int i=0,n=quakesInfo.size();i<n;i++)
		{	
			
			temp=quakesInfo.get((tempIndex=findMinMagnitudeIndexInPlace(quakesInfo,i)));
			quakesInfo.set(tempIndex,quakesInfo.get(i));
			quakesInfo.set(i,temp);
		}
		long end=System.currentTimeMillis();
		double time=(end-(double)start)/1e3;
		System.out.printf("took %3.2f seconds to sort%n",time);
		return quakesInfo;
	}
	//checked selection sort (not recommended)
	public ArrayList<QuakeEntry> sortByMagnitudeInPlaceSelectionChecked()
	{
		QuakeEntry temp=null;
		int tempIndex;
		int minIndex;
		int passNum=1;
		//selection sort in-place in one method
		for(int i=0,n=quakesInfo.size();i<n &&!checkInSortedOrder(quakesInfo);i++)
		{
			System.out.println("Entering pass#"+passNum++);
			minIndex=i;
			for(int j=i;j<n;j++)
				if(quakesInfo.get(j).getMagnitude()<quakesInfo.get(minIndex).getMagnitude())
					minIndex=j;
			temp=quakesInfo.get(minIndex);
			quakesInfo.set(minIndex,quakesInfo.get(i));
			quakesInfo.set(i,temp);
		}
		return quakesInfo;
	}
	private int findMinMagnitudeIndexInPlace(ArrayList<QuakeEntry> arr,int from)
	{
		int minIndex=from;
		for(int i=from,n=arr.size();i<n;i++)
			if(arr.get(i).getMagnitude()<arr.get(minIndex).getMagnitude())
				minIndex=i;
		return minIndex;
	}
	public ArrayList<QuakeEntry> sortByMagnitudeDestructiveSelection()
	{
		ArrayList<QuakeEntry> out=new ArrayList<>();
		ArrayList<QuakeEntry> copiedInfo=new ArrayList<>(quakesInfo);
		int tempIndex;
		while(!copiedInfo.isEmpty())
		{
			out.add(copiedInfo.get((tempIndex=findMinMagnitudeIndexDestructive(copiedInfo))));
			copiedInfo.remove(tempIndex);
		}
		return out;
	}
	private int findMinMagnitudeIndexDestructive(ArrayList<QuakeEntry> arr)
	{
		int minIndex=0;
		for(int i=0,n=arr.size();i<n;i++)
			if(arr.get(i).getMagnitude()<arr.get(minIndex).getMagnitude())
				minIndex=i;
		return minIndex;
	}
	public ArrayList<QuakeEntry> getClosest(Location current, int howMany)
	{
		ArrayList<QuakeEntry> ret=new ArrayList<>();
		ArrayList<QuakeEntry> copiedInfo=new ArrayList<>(quakesInfo);
		int minIndex=0;
		for(int j=0;j<howMany;j++)
		{
			for(int i=0,n=copiedInfo.size();i<n;i++)
			{
				if(copiedInfo.get(i).getLocation().distanceTo(current)
				<
				copiedInfo.get(minIndex).getLocation().distanceTo(current))	
			  //   {System.out.println(copiedInfo.get(i).getLocation().distanceTo(current)+" "+copiedInfo.get(i));
				minIndex=i;
			  //   }	
			}
			ret.add(copiedInfo.get(minIndex));
			copiedInfo.remove(minIndex);
		}
		return ret;
	}
	public ArrayList<QuakeEntry> findLargestQuakes(int howMany)
	{
		ArrayList<QuakeEntry> ret=new ArrayList<>();
		ArrayList<QuakeEntry> copiedInfo=new ArrayList<>(quakesInfo);
		int index=0;
		for(int j=0;j<howMany;j++)
		{
			
			ret.add(copiedInfo.get((index=indexOfLargestQuake(copiedInfo))));
			copiedInfo.remove(index);
		}
		return ret;
	}
	private int indexOfLargestQuake(ArrayList<QuakeEntry> quakesInfo)
	{
		double max=-10.0;
		int index=-1;
		for(int i=0,n=quakesInfo.size();i<n;i++)
		{
			if(quakesInfo.get(i).getMagnitude()>max)
				{ max=quakesInfo.get(i).getMagnitude(); index=i;}
		}
		return index;
	}
	public ArrayList<QuakeEntry> filter(Filter... filters)
	{
		ArrayList<QuakeEntry> ret=new ArrayList<>();
		Filter f=new MatchAllFilter(new ArrayList<>(Arrays.asList(filters)));
		for(QuakeEntry qe:quakesInfo)
		{
			if(f.satisfies(qe))
				ret.add(qe);
		}
		System.out.println("Used Filters Are: "+f.getName());
		return ret;
	}
	private ArrayList<QuakeEntry> read(File source)
	{
		XmlParser xmlParser=new XmlParser(source);
		ArrayList<QuakeEntry> list=new ArrayList<>();
		parsedXml=xmlParser.getParsedInfo();
		ArrayList<String> location=parsedXml.get("georss:point");
		ArrayList<String> magTitle=parsedXml.get("title");
		ArrayList<String> depth=parsedXml.get("georss:elev");
		for(int i=0,n=location.size();i<n;i++)
		{
			String[] loc=location.get(i).split(" ");
			String mag=(mag=magTitle.get(i)).substring(1,6).trim();
			if(mag.contains("?"))continue;
			String title=(title=magTitle.get(i)).substring((title.indexOf("-",5)+1)>8?title.indexOf(mag)+mag.length():(title.indexOf("-",5)+1)).trim();
			list.add(new QuakeEntry(Double.parseDouble(loc[0]),Double.parseDouble(loc[1]),
				title,Double.parseDouble(depth.get(i)),Double.parseDouble(mag)));
		}
		return list;
	}
	private File getFile()
	{
		JFileChooser chooser=new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		FileNameExtensionFilter filter=new FileNameExtensionFilter("Atom Files","atom","ATOM");
		File file=null;
		chooser.setFileFilter(filter);
		try{
		do{
			System.out.println("Choose an XML File to parse");
			chooser.showOpenDialog(null);
		}while((file=chooser.getSelectedFile())==null || !file.isFile());
		}catch(NullPointerException ex){System.out.println("Incorrect response"); return getFile();}
		return file;
	}
}
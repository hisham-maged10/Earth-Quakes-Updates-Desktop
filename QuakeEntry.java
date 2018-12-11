/**
 * @author ${hisham_maged10}
 *https://github.com/hisham-maged10
 * ${DesktopApps}
 */
public class QuakeEntry implements Comparable<QuakeEntry>
{
	private Location myLocation;
	private String title;
	private double depth;
	private double magnitude;
	public QuakeEntry(double latitude,double longitude,String title,double depth, double magnitude)
	{
		this.myLocation=new Location(latitude,longitude);
		this.title=title;
		this.depth=depth;
		this.magnitude=magnitude;
	}
	public double getMagnitude()
	{
		return this.magnitude;
	}
	public Location getLocation()
	{
		return this.myLocation;
	}
	public double getDepth()
	{
		return depth;
	}
	public String getInfo()
	{
		return title;
	}
	@Override
	public String toString()
	{
		return "("+myLocation.getLatitude()+","+" "+myLocation.getLongitude()+")" + ", " +"mag= "+ magnitude+ ", " +"depth= " +depth + ", " +"title= "+title  ;
	}
	/* compareTo sorts by magnitude, so when collections.sort() is used on this, it will sort by magnitude as collections.sort uses the compareTo of the type
		and if not used comparable interface .sort will give you a compilation error that your type is not applicable for the .sort method */
	@Override
	public int compareTo(QuakeEntry qe)
	{
		if(this.magnitude < qe.getMagnitude())
			return -1;
		else if(this.magnitude > qe.getMagnitude())
			return 1;
		//when magnitudes are equal sort by depth.
		else 
			return new DepthComparator().compare(this,qe);
		
	}
	
}
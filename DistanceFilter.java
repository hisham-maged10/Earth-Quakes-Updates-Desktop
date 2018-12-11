/**
 * @author ${hisham_maged10}
 *https://github.com/hisham-maged10
 * ${DesktopApps}
 */
public class DistanceFilter implements Filter
{
	private double distMax;
	private Location myLocation;
	public DistanceFilter(double distMax,Location myLocation)
	{
		this.distMax=distMax;
		this.myLocation=myLocation;
	}
	public boolean satisfies(QuakeEntry qe)
	{
		return qe.getLocation().distanceTo(myLocation) < distMax;
	}
	public String getName()
	{
		return "Distance";
	}
}
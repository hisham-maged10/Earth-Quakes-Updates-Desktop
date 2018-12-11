/**
 * @author ${hisham_maged10}
 *https://github.com/hisham-maged10
 * ${DesktopApps}
 */
import java.util.Comparator;
public class DistanceComparator implements Comparator<QuakeEntry>
{
	private Location givenLocation;
	public DistanceComparator(Location givenLocation)
	{
		this.givenLocation=givenLocation;
	}
	public int compare(QuakeEntry qe1,QuakeEntry qe2)
	{
		double dist1,dist2;
		if((dist1=qe1.getLocation().distanceTo(givenLocation)) < (dist2=qe2.getLocation().distanceTo(givenLocation)) )
			return -1;
		else if(dist1 > dist2)
			return 1;
		else
			return 0;
	}
}
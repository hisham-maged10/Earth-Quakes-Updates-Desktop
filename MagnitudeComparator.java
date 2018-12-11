/**
 * @author ${hisham_maged10}
 *https://github.com/hisham-maged10
 * ${DesktopApps}
 */
import java.util.Comparator;
public class MagnitudeComparator implements Comparator<QuakeEntry>
{
	public int compare(QuakeEntry qe1,QuakeEntry qe2)
	{
		if(qe1.getMagnitude() < qe2.getMagnitude())
			return -1;
		else if(qe1.getMagnitude() > qe2.getMagnitude())
			return 1;
		else
			return 0;
	}
}
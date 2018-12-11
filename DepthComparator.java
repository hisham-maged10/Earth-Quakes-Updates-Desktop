/**
 * @author ${hisham_maged10}
 *https://github.com/hisham-maged10
 * ${DesktopApps}
 */
import java.util.Comparator;
public class DepthComparator implements Comparator<QuakeEntry>
{
	public int compare(QuakeEntry qe1,QuakeEntry qe2)
	{
		if(qe1.getDepth()<qe2.getDepth())
			return -1;
		else if(qe1.getDepth()>qe2.getDepth())
			return 1;
		else
			return 0;
	}
}
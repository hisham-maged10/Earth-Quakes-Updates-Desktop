/**
 * @author ${hisham_maged10}
 *https://github.com/hisham-maged10
 * ${DesktopApps}
 */
import java.util.Comparator;
public class TitleDepthComparator implements Comparator<QuakeEntry>
{
	public int compare(QuakeEntry qe1,QuakeEntry qe2)
	{
		int compResult;
		if((compResult=new TitleComparator().compare(qe1,qe2)) ==0)
			return new DepthComparator().compare(qe1,qe2);
		else
			return compResult;
	}
}
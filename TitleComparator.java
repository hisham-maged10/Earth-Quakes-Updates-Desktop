/**
 * @author ${hisham_maged10}
 *https://github.com/hisham-maged10
 * ${DesktopApps}
 */
import java.util.Comparator;
public class TitleComparator implements Comparator<QuakeEntry>
{
	public int compare(QuakeEntry qe1,QuakeEntry qe2)
	{
		//you can normally use the .compareTo method as the concept it alright if -ve number,0,+ve number (doesn't have to be -1,0,1)
		return qe1.getInfo().compareTo(qe2.getInfo());
	}
}
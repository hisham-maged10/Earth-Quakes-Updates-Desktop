/**
 * @author ${hisham_maged10}
 *https://github.com/hisham-maged10
 * ${DesktopApps}
 */
import java.util.Comparator;
public class LastWordMagnitudeComparator implements Comparator<QuakeEntry>
{
	public int compare(QuakeEntry qe1,QuakeEntry qe2)
	{
		String[] arr;
		String word1=(arr=qe1.getInfo().split("\\W+"))[arr.length-1];
		String word2=(arr=qe2.getInfo().split("\\W+"))[arr.length-1];
		int compResult;
		if((compResult=word1.compareTo(word2)) == 0)
			return new MagnitudeComparator().compare(qe1,qe2);
		else
			return compResult;
			
	}
}
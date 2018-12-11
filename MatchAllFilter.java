/**
 * @author ${hisham_maged10}
 *https://github.com/hisham-maged10
 * ${DesktopApps}
 */
import java.util.ArrayList;
public class MatchAllFilter implements Filter
{
	private ArrayList<Filter> filtersArr;
	public MatchAllFilter(ArrayList<Filter> filtersArr)
	{
		this.filtersArr=filtersArr==null?new ArrayList<Filter>():filtersArr;
	}	
	public MatchAllFilter()
	{
		this(null);
	}
	public void addFilter(Filter f)
	{
		filtersArr.add(f);
	}
	public boolean satisfies(QuakeEntry qe)
	{
		for(Filter f:filtersArr)
			if(!f.satisfies(qe))
				return false;
		return true;
	}
	public String getName()
	{
		String s="";
		for(Filter f:filtersArr)
			s+=f.getName()+" ";
		return s;
	}
}
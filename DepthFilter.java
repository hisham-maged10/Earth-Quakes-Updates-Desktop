/**
 * @author ${hisham_maged10}
 *https://github.com/hisham-maged10
 * ${DesktopApps}
 */
public class DepthFilter implements Filter
{
	private double minDepth;
	private double maxDepth;
	public DepthFilter(double minDepth,double maxDepth)
	{
		this.minDepth=minDepth;
		this.maxDepth=maxDepth;	
	}
	public boolean satisfies(QuakeEntry qe)
	{
		return qe.getDepth()>=minDepth && qe.getDepth()<=maxDepth;
	}
	public String getName()
	{
		return "Depth";
	}
}
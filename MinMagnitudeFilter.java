/**
 * @author ${hisham_maged10}
 *https://github.com/hisham-maged10
 * ${DesktopApps}
 */
public class MinMagnitudeFilter implements Filter
{
	private double minMag;
	public MinMagnitudeFilter(double minMag)
	{
		this.minMag=minMag;
	}
	public boolean satisfies(QuakeEntry qe)
	{
		return qe.getMagnitude() >= minMag;
	}
	public String getName()
	{
		return "Min Magnitude";
	}
}
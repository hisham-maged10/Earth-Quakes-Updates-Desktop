/**
 * @author ${hisham_maged10}
 *https://github.com/hisham-maged10
 * ${DesktopApps}
 */
public class MaxMagnitudeFilter implements Filter
{
	private double maxMag;
	public MaxMagnitudeFilter(double maxMag)
	{
		this.maxMag=maxMag;
	}
	public boolean satisfies(QuakeEntry qe)
	{
		return qe.getMagnitude() < maxMag;
	}
	public String getName()
	{
		return "Max Magnitude";
	}
}
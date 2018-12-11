/**
 * @author ${hisham_maged10}
 *https://github.com/hisham-maged10
 * ${DesktopApps}
 */
public class MagnitudeFilter implements Filter
{
	private double minMag;
	private double maxMag;
	public MagnitudeFilter(double minMag,double maxMag)
	{
		this.minMag=minMag;
		this.maxMag=maxMag;
	}
	public boolean satisfies(QuakeEntry qe)
	{
		return qe.getMagnitude()>= minMag && qe.getMagnitude()<= maxMag;
	}
	public String getName()
	{
		return "Magnitude";
	}
}
/**
 * @author ${hisham_maged10}
 *https://github.com/hisham-maged10
 * ${DesktopApps}
 */
public class Location
{
	private double latitude;
	private double longitude;
	public Location(double latitude,double longitude)
	{
		this.latitude=latitude;
		this.longitude=longitude;
	}
	public double getLatitude()
	{
		return this.latitude;
	}
	public double getLongitude()
	{
		return this.longitude;
	}
	/*
		
	Haversine
	formula:	a = sin^2(deltaAlpha/2) + cos alpha1 * cos alpha2 *sin²(deltaLambda/2)
	c = 2 * atan2( sqrt(a), sqrt(1-a) )
	d = R * c
	where	alpha is latitude, lambda is longitude, R is earth’s radius (mean radius = 6,371km);
	note that angles need to be in radians to pass to trig functions!
	*/
	public double distanceTo(Location location)
	{
		double earthRadius=6371;
		double alpha1=Math.toRadians(this.latitude);
		double alpha2=Math.toRadians(location.getLatitude());
		double deltaAlpha=Math.toRadians(location.getLatitude()-this.latitude);
		double deltaLambda=Math.toRadians(location.getLongitude()-longitude);
		double a=Math.pow(Math.sin(deltaAlpha/2),2)+Math.cos(alpha1)*Math.cos(alpha2)*Math.pow(Math.sin(deltaLambda/2),2);
		double c=2*Math.atan2(Math.sqrt(a),Math.sqrt(1-a));
		double d=earthRadius*c;
		return d;
	}
}
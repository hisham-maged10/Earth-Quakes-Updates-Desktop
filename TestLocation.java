/**
 * @author ${hisham_maged10}
 *https://github.com/hisham-maged10
 * ${DesktopApps}
 */
public class TestLocation
{
	public static void main(String[] args)
	{
		testing();
	}
	public static void testing()
	{
		Location loc=new Location(-6.211,106.845);
		System.out.println(loc.distanceTo(new Location(-7.44,105.24)));
	}
}
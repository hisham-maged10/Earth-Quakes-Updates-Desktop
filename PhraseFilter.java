/**
 * @author ${hisham_maged10}
 *https://github.com/hisham-maged10
 * ${DesktopApps}
 */
public class PhraseFilter implements Filter
{
	private String where;
	private String phrase;
	public PhraseFilter(String where,String phrase)
	{
		this.where=where;
		this.phrase=phrase;
	}
	public boolean satisfies(QuakeEntry qe)
	{
		switch(where.toLowerCase())
		{
			case "start":return qe.getInfo().startsWith(phrase);
			case "end":return qe.getInfo().endsWith(phrase);
			case "any":return qe.getInfo().contains(phrase);
			default:return false;
		}
	}
	public String getName()
	{
		return "Phrase";
	}
}
class Printlinelist implements Token
{
	Printlist plist;
	
	public Printlinelist(Printlist p)
	{
		plist = p;
	}
	
	public String toString(int t)
	{
		return plist.toString(t);
	}
	
	public void typeCheck(int s) throws Exception
	{
		plist.typeCheck(s);
	}
}
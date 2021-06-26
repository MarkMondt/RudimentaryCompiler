class Type implements Token
{
	String tString;
	
	public Type(String t)
	{
		tString = t;
	}
	
	public String toString(int t)
	{
		return tString;
	}
}
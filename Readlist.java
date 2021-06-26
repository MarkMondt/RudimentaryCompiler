class Readlist implements Token
{
	Name name;
	Readlist list;
	
	public Readlist(Name n, Readlist r)
	{
		name = n;
		list = r;
	}
	
	public Readlist(Name n)
	{
		name = n;
		list = null;
	}
	
	public String toString(int t)
	{
		if (list != null)
			return name.toString(t) + ", " + list.toString(t);
		else
			return name.toString(t);
	}
	
	public void typeCheck(int s) throws Exception
	{
		if (name.isFinal(s))
			throw new Exception("Error: cannot read into a final variable");
		
		String nameType = name.typeCheck(s);
		
		if (nameType.equals("int[]") || nameType.equals("float[]") || nameType.equals("char[]")
				|| nameType.equals("bool[]"))
			throw new Exception("Error: must read into a singleton variable");
		
		if (list != null)
			list.typeCheck(s);
	}
}
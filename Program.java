class Program implements Token
{
	String id;
	Memberdecls memdecls;
	
	public Program(String i, Memberdecls m)
	{
		id = i;
		memdecls = m;
	}
	
	public String toString(int t)
	{
		String returnString = "";
		for (int i = 0; i < t; i++)
		{
			returnString += "\t";
		}
		String tabs = returnString;
		
		returnString += "class " + id + "\n" + returnString
				+ "{\n" + returnString;
		if (memdecls != null)
			returnString += memdecls.toString(t+1);
		returnString += "}";
		return returnString;
	}
	
	public void typeCheck(int s) throws Exception
	{
		memdecls.typeCheck(s);
	}
}
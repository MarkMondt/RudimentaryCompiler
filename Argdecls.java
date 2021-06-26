class Argdecls implements Token
{
	ArgdeclList list;
	
	public Argdecls(ArgdeclList a)
	{
		list = a;
	}
	
	public String toString(int t)
	{
		return list.toString(t);
	}
	
	public String[] getIDList()
	{
		return list.getIDList();
	}
	
	public String[] getTypeList()
	{
		return list.getTypeList();
	}
	
	public void addToTable(int s)
	{
		list.addToTable(s);
	}
}
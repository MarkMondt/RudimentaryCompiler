class Argdecl extends Checkable implements Token
{
	Type type;
	String id;
	
	int mode;
	
	public Argdecl(Type t, String i, int m)
	{
		type = t;
		id = i;
		mode = m;
	}
	
	public String toString(int t)
	{
		if (mode == 0)
			return type.toString(t) + " " + id;
		else if (mode == 1)
			return type.toString(t) + " " + id + "[]";
		else
			return "";
	}
	
	public String[] getIDList()
	{
		String[] newArr = {id};
		return newArr;
	}
	
	public String[] getTypeList()
	{
		String[] newArr = new String[1];
		if (mode == 0)
			newArr[0] = type.toString(0);
		else if (mode == 1)
			newArr[0] = type.toString(0) + "[]";
		else
			newArr[0] = "Error in Argdecl";
		
		return newArr;
			
	}
	
	public void addToTable(int s) throws Exception
	{
		String tableType;
		if (mode == 0)
			tableType = type.toString(0);
		else if (mode == 1)
			tableType = type.toString(0) + "[]";
		else
			tableType = "";
		
		boolean redeclare = !variableTable.add(id, tableType, false, s);
			
		if (redeclare)
			throw new Exception("Error: argument " + id + 
					" must have a unique identifier.");
	}
}
class Name extends Checkable implements Token
{
	String id;
	Expr expr;
	
	int mode;
	
	public Name(String i)
	{
		id = i;
		
		mode = 0;
	}
	
	public Name(String i, Expr e)
	{
		id = i;
		expr = e;
		
		mode = 1;
	}
	
	public String toString(int t)
	{
		String returnString = id;
		
		if (mode == 1)
		{
			returnString += "[" + expr.toString(t) + "]";
		}
		
		return returnString;
	}
	
	public boolean isFinal(int s)
	{
		varEntry var = variableTable.getEntry(id, s);
		if (var != null)
		{
			return var.isFinal();
		}
		
		return false;
	}
	
	public String typeCheck(int s) throws Exception
	{
		String nameType = variableTable.getType(id, s);
		String tableID = id;
		
		if (nameType.equals(""))
			throw new Exception("Error: " + id + " is not a variable or is not declared.");
		
		if (nameType.equals("int[]") || nameType.equals("float[]") || nameType.equals("char[]")
				|| nameType.equals("bool[]"))
		{
			if (mode == 0)
				throw new Exception("Error: " + id + " must be dereferenced to be treated as a singleton.");
			if (!expr.typeCheck(s).equals("int"))
				throw new Exception("Error: array subscript must be an int.");
			else
			{
				if (nameType.equals("int[]"))
					return "int";
				else if (nameType.equals("float[]"))
					return "float";
				else if (nameType.equals("char[]"))
					return "char";
				else if (nameType.equals("bool[]"))
					return "bool";
			}
			
		}
		
		return nameType;
			
		
	}
}
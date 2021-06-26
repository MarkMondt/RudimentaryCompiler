class Methodcall extends Stmt implements Token
{
	String id;
	Args args;
	
	public Methodcall(String i)
	{
		id = i;
		args = null;
	}
	
	public Methodcall(String i, Args a)
	{
		id = i;
		args = a;
	}
	
	public String toString(int t)
	{
		String returnString = "";
		for (int i = 0; i < t; i++)
		{
			returnString += "\t";
		}
		
		returnString += id + "(";
		if (args != null)
			returnString += args.toString(t);
		returnString += ");" + super.toString(t);
		return returnString;
	}
	
	public boolean validReturn(String t, int s)
	{
		return true;
	}
	
	public boolean hasReturn()
	{
		return false;
	}
	
	public void typeCheck(int s) throws Exception
	{
		methodEntry e = methodTable.getEntry(id,s);
		if (e == null)
			throw new Exception("Error: method " + id + " has not been defined.");
		
		String[] argTypes = e.getArgTypes();
		if (args == null)
		{
			if (argTypes != null)
				throw new Exception("Error: method " + id + " must be called with arguments.");
		}
		else
		{
			if (!args.correctArgs(argTypes, 0, s))
				throw new Exception("Error: method " + id + " called with incorrect arguments.");
		}
	}
}
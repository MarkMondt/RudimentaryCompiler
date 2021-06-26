class Struct extends Stmt implements Token
{
	Fielddecls fields;
	Stmts statements;
	Optionalsemi maybe;
	
	public Struct(Fielddecls f, Stmts s, Optionalsemi os)
	{
		fields = f;
		statements = s;
		maybe = os;
	}
	
	public Struct(Stmts s, Optionalsemi os)
	{
		fields = null;
		statements = s;
		maybe = os;
	}
	
	public String toString(int t)
	{
		String returnString = "";
		for (int i = 0; i < t; i++)
		{
			returnString += "\t";
		}
		String tabs = returnString;
		
		returnString += "{\n";
		if (fields != null)
			returnString += fields.toString(t+1);
		if (statements != null)
			returnString += statements.toString(t+1);
		returnString += tabs + "}";
		if (maybe != null)
			returnString += maybe.toString(t);
		returnString += super.toString(t);
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
		if (fields != null)
			fields.typeCheck(s+1);
		
		statements.typeCheck(s+1);
		
		variableTable.removeScope(s+1);
	}
}
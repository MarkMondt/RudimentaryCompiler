class Methoddecl extends Checkable implements Token
{
	Type rtype;
	String id;
	Argdecls args;
	Fielddecls fields;
	Stmts statements;
	Optionalsemi maybe;
	
	public Methoddecl(Type rt, String i, Argdecls as, Fielddecls fs,
			Stmts ss, Optionalsemi os)
	{
		rtype = rt;
		id = i;
		args = as;
		fields = fs;
		statements = ss;
		maybe = os;
	}
	
	public Methoddecl(Type rt, String i, Argdecls as, Stmts ss, Optionalsemi os)
	{
		rtype = rt;
		id = i;
		args = as;
		fields = null;
		statements = ss;
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
		
		returnString += rtype.toString(t) + " " + id + "(";
		if (args != null)
			returnString += args.toString(t);
		returnString += ")\n" + tabs + "{\n";
		if (fields != null)
			returnString += fields.toString(t+1);
		if (statements != null)
			returnString += statements.toString(t+1);
		returnString += tabs + "}";
		if (maybe != null)
			returnString += maybe.toString(t);
		returnString += "\n";
		return returnString;
	}
	
	public void typeCheck(int s) throws Exception
	{
		boolean redeclare;
		if (args == null)
			redeclare = methodTable.add(id, rtype.toString(0), s, null, null);
		else
			redeclare = methodTable.add(id, rtype.toString(0), s,
					args.getTypeList(), args.getIDList());
		
		if (!redeclare)
			throw new Exception("Error: method " + id + 
					" cannot be redeclared in the same scope.");
		
		args.addToTable(s+1);
		
		if (fields != null)
			fields.typeCheck(s+1);
		
		if (statements != null)
		{
			statements.typeCheck(s+1);
			
			if (!statements.validReturn(rtype.toString(0), s))
				throw new Exception("Error: invalid return type in method " + id);
		}
		else
		{
			if (!rtype.equals("void"))
				throw new Exception("Error: invalid return type in method " + id);
		}
		
		methodTable.removeScope(s+1);
		variableTable.removeScope(s+1);
			
	}
}
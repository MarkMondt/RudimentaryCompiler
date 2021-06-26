class Returnstmt extends Stmt implements Token
{
	Expr expr;
	
	int mode;
	
	public Returnstmt()
	{
		mode = 0;
	}
	
	public Returnstmt(Expr e)
	{
		expr = e;
		
		mode = 1;
	}
	
	public String toString(int t)
	{
		String returnString = "";
		for (int i = 0; i < t; i++)
		{
			returnString += "\t";
		}
		
		returnString += "return";
		if (mode == 1)
		{
			returnString += " " + expr.toString(t);
		}
		
		returnString += ";" + super.toString(t);
		return returnString;
	}
	
	public boolean validReturn(String t, int s) throws Exception
	{
		if(mode == 0 && t.equals("void"))
			return true;
		else if (mode == 0)
			return false;
		
		String actualReturn = expr.typeCheck(s);
		if (t.equals("int") && actualReturn.equals("int"))
			return true;
		if (t.equals("char") && actualReturn.equals("char"))
			return true;
		if (t.equals("float") && (actualReturn.equals("int") || actualReturn.equals("float")))
			return true;
		if (t.equals("bool") && (actualReturn.equals("int") || actualReturn.equals("bool")))
			return true;
		
		return false;
	}
	
	public boolean hasReturn()
	{
		return true;
	}
	
	public void typeCheck(int s) throws Exception
	{
		expr.typeCheck(s);
	}
}
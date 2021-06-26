class Whilestmt extends Stmt implements Token
{
	Expr expr;
	Stmt statement;
	
	public Whilestmt(Expr e, Stmt s)
	{
		expr = e;
		statement = s;
	}
	
	public String toString(int t)
	{
		String returnString = "";
		for (int i = 0; i < t; i++)
		{
			returnString += "\t";
		}
		
		returnString += "while (" + expr.toString(t) + ")\n" + statement.toString(t+1) + super.toString(t);
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
		if (!expr.typeCheck(s).equals("bool") && !expr.typeCheck(s).equals("int"))
			throw new Exception("Error: while expression must be coercible to bool");
	}
}
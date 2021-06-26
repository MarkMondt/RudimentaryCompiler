class Ifstmt extends Stmt implements Token
{
	Expr expr;
	Stmt statement;
	IfEnd end;
	
	public Ifstmt(Expr e, Stmt s, IfEnd ie)
	{
		expr = e;
		statement = s;
		end = ie;
	}
	
	public String toString (int t)
	{
		String returnString = "";
		for (int i = 0; i < t; i++)
		{
			returnString += "\t";
		}
		
		return returnString += "if (" + expr.toString(t) + ")\n" + statement.toString(t+1)
			+ end.toString(t) + super.toString(t);
	}
	
	public boolean validReturn(String s)
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
			throw new Exception("Error: if expression must be coercible to bool");
	}
}
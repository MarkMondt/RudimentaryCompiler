class Stmts implements Token
{
	Stmt statement;
	Stmts statements;
	
	public Stmts(Stmt s, Stmts ss)
	{
		statement = s;
		statements = ss;
	}
	
	public String toString(int t)
	{
		if (statements == null)
			return statement.toString(t);
		else
			return statement.toString(t) + statements.toString(t);
	}
	
	public void typeCheck(int s) throws Exception
	{
		statement.typeCheck(s);
		statements.typeCheck(s);
	}
	
	public boolean hasReturn()
	{
		if (statement.hasReturn() || (statements != null && statements.hasReturn()))
			return true;
		else
			return false;
	}
	
	public boolean validReturn(String s, int sc)
	{
		if (s.equals("void"))
			return statement.validReturn(s, sc) && statements.validReturn(s, sc);
		else
			return this.hasReturn() && statement.validReturn(s, sc) && statements.validReturn(s, sc);
	}
}
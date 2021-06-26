class Optionalexpr implements Token
{
	Expr expr;
	
	public Optionalexpr(Expr e)
	{
		expr = e;
	}
	
	public String toString(int t)
	{
		return " = " + expr.toString(t);
	}
	
	public String typeCheck(int s) throws Exception
	{
		return expr.typeCheck(s);
	}
}
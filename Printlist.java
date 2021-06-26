class Printlist implements Token
{
	Expr expr;
	Printlist list;
	
	public Printlist(Expr e, Printlist p)
	{
		expr = e;
		list = p;
	}
	
	public Printlist(Expr e)
	{
		expr = e;
		list = null;
	}
	
	public String toString(int t)
	{
		if (list != null)
			return expr.toString(t) + ", " + list.toString(t);
		else
			return expr.toString(t);
	}
	
	public void typeCheck(int s) throws Exception
	{
		String exprType = expr.typeCheck(s);
		if (exprType.equals("void"))
			throw new Exception("Error: print items must not be void.");
		
		if (exprType.equals("int[]") || exprType.equals("float[]") || exprType.equals("char[]")
				|| exprType.equals("bool[]"))
			throw new Exception("Error: must print singleton variables");
		
		if (list != null)
			list.typeCheck(s);
	}
}
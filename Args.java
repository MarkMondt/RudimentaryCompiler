class Args implements Token
{
	Expr expr;
	Args args;
	
	int mode;
	
	public Args(Expr e)
	{
		expr = e;
		
		mode = 0;
	}
	
	public Args(Expr e, Args a)
	{
		expr = e;
		args = a;
		
		mode = 1;
	}
	
	public String toString(int t)
	{
		String returnString = expr.toString(t);
		
		if (mode == 1)
		{
			returnString += ", " + args.toString(t);
		}
		
		return returnString;
	}
	
	public void typeCheck(int s) throws Exception
	{
		expr.typeCheck(s);
		if (mode == 1)
			args.typeCheck(s);
	}
	
	public boolean correctArgs(String[] types, int count, int s) throws Exception
	{
		boolean argCorrect = true;
		
		if (types == null || count >= types.length)
			argCorrect = false;
		
		String eType = expr.typeCheck(s);
		if (types[count].equals("int") && !eType.equals("int"))
		{
			argCorrect = false;
		}
		if (types[count].equals("char") && !eType.equals("char"))
		{
			argCorrect = false;
		}
		if (types[count].equals("float") && !(eType.equals("int") || eType.equals("float")))
		{
			argCorrect = false;
		}
		if (types[count].equals("bool") && !(eType.equals("int") || eType.equals("bool")))
		{
			argCorrect = false;
		}
		
		if (mode == 1)
		{
			return argCorrect && args.correctArgs(types, count + 1, s);
		}
		if (mode == 0)
		{
			if (count < (types.length - 1))
				return false;
			else
				return argCorrect;
		}
		
		return false;
	}
}
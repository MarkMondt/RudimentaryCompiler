class Assign extends Stmt implements Token
{
	Name name;
	Expr expr;
	
	public Assign(Name n, Expr e)
	{
		name = n;
		expr = e;
	}
	
	public String toString(int t)
	{
		String returnString = "";
		for (int i = 0; i < t; i++)
		{
			returnString += "\t";
		}
		
		returnString += "(" + name.toString(t) + " = " + expr.toString(t) + ");" + super.toString(t);
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
		String leftType = name.typeCheck(s);
		
		if (name.isFinal(s))
			throw new Exception("Error: cannot assign to a final variable");
		
		if (expr != null)
		{
			String eType = expr.typeCheck(s);
			if (leftType.equals("int") && !eType.equals("int"))
			{
				throw new Exception("Error: " + name.toString(0) + " must be assigned a value of type int.");
			}
			if (leftType.equals("char") && !eType.equals("char"))
			{
				throw new Exception("Error: " + name.toString(0) + " must be assigned a value of type char.");
			}
			if (leftType.equals("float") && !(eType.equals("int") || eType.equals("float")))
			{
				throw new Exception("Error: " + name.toString(0) + " must be assigned a value of type float.");
			}
			if (leftType.equals("bool") && !(eType.equals("int") || eType.equals("bool")))
			{
				throw new Exception("Error: " + name.toString(0) + " must be assigned a value of type bool.");
			}
		}
		else
			throw new Exception("Error: righthand side cannot be evaluated.");
	}
}
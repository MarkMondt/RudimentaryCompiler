class Postfix extends Stmt implements Token
{
	Name name;
	String arg;
	
	public Postfix(Name n, String a)
	{
		name = n;
		arg = a;
	}
	
	public String toString(int t)
	{
		String returnString = "";
		for (int i = 0; i < t; i++)
		{
			returnString += "\t";
		}
		
		returnString += name.toString(t) + arg + ";" + super.toString(t);
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
		String nameType = name.typeCheck(s);
		
		if (name.isFinal(s))
			throw new Exception("Error: cannot use postfix on a final variable");
		
		if(!nameType.equals("int") && !nameType.equals("float"))
			throw new Exception("Error: postfix expression must be a number.");
	}
}
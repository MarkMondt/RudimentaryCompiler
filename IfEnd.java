class IfEnd implements Token
{
	Stmt statement;
	
	int mode;
	
	public IfEnd()
	{
		mode = 0;
	}
	
	public IfEnd(Stmt s)
	{
		statement = s;
		mode = 1;
	}
	
	public String toString(int t)
	{
		String returnString = "";
		for (int i = 0; i < t; i++)
		{
			returnString += "\t";
		}
		
		if (mode == 1)
		{
			returnString += "else\n" + statement.toString(t+1) + returnString;
		}
		
		returnString += "fi";
		return returnString;
	}
}
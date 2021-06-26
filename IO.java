class IO extends Stmt implements Token
{
	Readlist read;
	Printlist print;
	Printlinelist printline;
	
	int mode;
	
	public IO(Readlist r)
	{
		read = r;
		mode = 0;
	}
	
	public IO(Printlist p)
	{
		print = p;
		mode = 1;
	}
	
	public IO(Printlinelist p)
	{
		printline = p;
		mode = 2;
	}
	
	public String toString(int t)
	{
		String returnString = "";
		for (int i = 0; i < t; i++)
		{
			returnString += "\t";
		}
		
		if (mode == 0)
		{
			returnString += "read(" + read.toString(t);
		}
		else if (mode == 1)
		{
			returnString += "print(" + print.toString(t);
		}
		else if (mode == 2)
		{
			returnString += "printline(";
			if (printline != null)
				returnString += printline.toString(t);
		}
		
		returnString += ");" + super.toString(t);
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
		if (mode == 0)
			read.typeCheck(s);
		if (mode == 1)
			print.typeCheck(s);
		if (mode == 2 && printline != null)
			printline.typeCheck(s);
	}
}
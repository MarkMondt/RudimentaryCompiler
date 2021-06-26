class ArgdeclList implements Token
{
	Argdecl arg;
	ArgdeclList args;
	
	int mode;
	
	public ArgdeclList(Argdecl a, ArgdeclList as)
	{
		arg = a;
		args = as;
		
		mode = 0;
	}
	
	public ArgdeclList(Argdecl a)
	{
		arg = a;
		
		mode = 1;
	}
	
	public String toString(int t)
	{
		if (mode == 0)
		{
			return arg.toString(t) + ", " + args.toString(t);
		}
		else if (mode == 1)
		{
			return arg.toString(t);
		}
		else
			return "";
	}
	
	public String[] getIDList()
	{
		if (mode == 1)
		{
			return arg.getIDList();
		}
		else
		{
			String[] prev = args.getIDList();
			String[] cur = new String[prev.length + 1];
			cur[0] = arg.getIDList()[0];
			for (int i = 1; i < cur.length; i++)
			{
				cur[i] = prev[i-1];
			}
			return cur;
		}
	}
	
	public String[] getTypeList()
	{
		if (mode == 1)
		{
			return arg.getTypeList();
		}
		else
		{
			String[] prev = args.getTypeList();
			String[] cur = new String[prev.length + 1];
			cur[0] = arg.getTypeList()[0];
			for (int i = 1; i < cur.length; i++)
			{
				cur[i] = prev[i-1];
			}
			return cur;
		}
	}
	
	public void addToTable(int s)
	{
		arg.addToTable(s);
		if (args != null)
		{
			args.addToTable(s);
		}
	}
}
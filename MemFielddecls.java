class MemFielddecls implements Token
{
	Fielddecl field;
	MemFielddecls fields;
	Methoddecls methods;
	
	int mode;
	
	public MemFielddecls(Fielddecl f, MemFielddecls fs)
	{
		field = f;
		fields = fs;
		
		mode = 0;
	}
	
	public MemFielddecls(Fielddecl f, Methoddecls ms)
	{
		field = f;
		methods = ms;
		
		mode = 1;
	}
	
	public MemFielddecls(Fielddecl f)
	{
		field = f;
		
		mode = 2;
	}
	
	public String toString(int t)
	{
		if (mode == 0)
			return field.toString(t) + fields.toString(t);
		else if (mode == 1)
			return field.toString(t) + methods.toString(t);
		else if (mode == 2)
			return field.toString(t);
		else
			return "";
	}
	
	public void typeCheck(int s) throws Exception
	{
		field.typeCheck(s);
		if (mode == 0)
			fields.typeCheck(s);
		else if (mode == 1)
			methods.typeCheck(s);
	}
}
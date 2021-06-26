class Memberdecls implements Token
{
	MemFielddecls fields;
	Methoddecls methods;
	
	public Memberdecls(MemFielddecls f)
	{
		fields = f;
		methods = null;
	}
	
	public Memberdecls(Methoddecls m)
	{
		methods = m;
		fields = null;
	}
	
	public String toString(int t)
	{
		if (methods == null)
			return fields.toString(t);
		else
			return methods.toString(t);
	}
	
	public void typeCheck(int s) throws Exception
	{
		if (fields != null)
			fields.typeCheck(s);
		else if (methods != null)
			methods.typeCheck(s);
	}
}
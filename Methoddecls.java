class Methoddecls implements Token
{
	Methoddecl method;
	Methoddecls methods;
	
	public Methoddecls(Methoddecl m, Methoddecls ms)
	{
		method = m;
		methods = ms;
	}
	
	public Methoddecls(Methoddecl m)
	{
		method = m;
		methods = null;
	}
	
	public String toString(int t)
	{
		if (methods != null)
			return method.toString(t) + methods.toString(t);
		else
			return method.toString(t);
	}
	
	public void typeCheck(int s) throws Exception
	{
		method.typeCheck(s);
		if (methods != null)
			methods.typeCheck(s);
	}
}
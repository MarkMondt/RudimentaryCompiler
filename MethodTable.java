import java.util.Vector;

class MethodTable
{
	Vector<methodEntry> methodTable;
	public MethodTable()
	{
		methodTable = new Vector<methodEntry>();
	}
	
	public String getType(String s, int sc)
	{
		while (sc >= 0)
		{
			for (methodEntry e : methodTable)
			{
				if (e.getID().equals(s) && e.getScope() == sc)
					return e.getType();
			}
			sc--;
		}
		return "";
	}
	
	public methodEntry getEntry(String s, int sc)
	{
		while (sc >= 0)
		{
			for (methodEntry e : methodTable)
			{
				if (e.getID().equals(s) && e.getScope() == sc)
					return e;
			}
			sc--;
		}
		return null;
	}
	
	public boolean add(String i, String t, int s, String[] ts, String[] as)
	{
		int sc = s;
		while (sc >= 0)
		{
			for (methodEntry e : methodTable)
			{
				if (e.getID().equals(i) && e.getScope() == sc)
					return false;
			}
			sc--;
		}
		methodTable.add(new methodEntry(i,t,s,ts,as));
		return true;
	}
	
	public void removeScope(int s)
	{
		for (methodEntry e : methodTable)
		{
			if (e.getScope() == s)
				methodTable.remove(e);
		}
	}
}
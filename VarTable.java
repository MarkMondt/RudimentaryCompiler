import java.util.Vector;

class VarTable
{
	Vector<varEntry> variableTable;
	public VarTable()
	{
		variableTable = new Vector<varEntry>();
	}
	
	public varEntry getEntry(String s, int sc)
	{
		while (sc >= 0)
		{
			for (varEntry e : variableTable)
			{
				if (e.getID().equals(s) && sc == e.getScope())
					return e;
			}
			sc--;
		}
		return null;
	}
	
	public String getType(String s, int sc)
	{
		while (sc >= 0)
		{
			for (varEntry e : variableTable)
			{
				if (e.getID().equals(s) && sc == e.getScope())
					return e.getType();
			}
			sc--;
		}
		return "";
	}
	
	public boolean add(String i, String t, boolean f, int s)
	{
		for (varEntry e : variableTable)
		{
			if (e.getID().equals(i) && e.getScope() == s)
				return false;
		}
		variableTable.add(new varEntry(i,t,f,s));
		return true;
	}
	
	public void removeScope(int s)
	{
		for (varEntry e : variableTable)
		{
			if (e.getScope() == s)
				variableTable.remove(e);
		}
	}
}
abstract class Stmt extends Checkable implements Token
{
	public String toString(int t)
	{
		return "\n";
	}
	
	public boolean validReturn(String t, int s) throws Exception
	{
		return true;
	}
	
	public void typeCheck(int s) throws Exception
	{
		
	}
	
	public boolean hasReturn()
	{
		return true;
	}
}
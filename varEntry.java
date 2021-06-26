class varEntry
	{
		int scope;
		String id;
		String type;
		boolean opFinal;
		
		public varEntry(String i, String t, boolean f, int s)
		{
			id = i;
			type = t;
			opFinal = f;
			scope = s;
		}
		
		public String getID()
		{
			return id;
		}
		
		public String getType()
		{
			return type;
		}
		
		public int getScope()
		{
			return scope;
		}
		
		public boolean isFinal()
		{
			return opFinal;
		}
	}
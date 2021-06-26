class methodEntry
	{
		int scope;
		String id;
		String type;
		String[] types;
		String[] args;
		int noArgs;
		
		public methodEntry(String i, String t, int s, String[] ts, String[] as)
		{
			id = i;
			type = t;
			scope = s;
			types = ts;
			args = as;
			if (types == null)
				noArgs = 0;
			else
				noArgs = types.length;
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
		
		public String getArg(int n)
		{
			return args[n];
		}
		
		public String getArgType(int n)
		{
			return types[n];
		}
		
		public String[] getArgTypes()
		{
			return types;
		}
	}
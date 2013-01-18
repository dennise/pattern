package cn.dennise.pattern;


abstract class Logger {
    public static int ERR = 0x3;
    public static int INFO = 0x5;
    public static int DEBUG = 0x7;
    
    protected Logger next = null;
    protected int mask = 0;
    public Logger setNext( Logger i )
    {
    	next = i;
    	return i;
    }
    
    protected abstract void writeMessag(String msg);
    
    public void message(String msg, int priority)
    {
    	if (priority <= mask)
    	{
    		writeMessag(msg);
    	}
    	if (next != null)
    	{
    		next.message(msg, priority);
    	}
    }
}

class ErrLogger extends Logger 
{
	public ErrLogger(int mask)
	{
		this.mask = mask;
	}
	
	protected void writeMessag(String msg)
	{
		System.out.println("ERROR:" + msg);
	}
}

class InfoLogger extends Logger 
{
	public InfoLogger(int mask)
	{
		this.mask = mask;
	}
	
	@Override
	protected void writeMessag(String msg)
	{
		System.out.println("INFO:" + msg);
	}
}

class DebugLogger extends Logger 
{
	public DebugLogger(int mask)
	{
		this.mask = mask;
	}
	
	@Override
	protected void writeMessag(String msg)
	{
		System.out.println("DEBUG:" + msg);
	}
}
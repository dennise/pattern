package cn.dennise.pattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Observee {
	
    private List<IObserver> list = new ArrayList<IObserver>();
    
    public boolean registerListerner(IObserver listerner)
    {
    	return list.add(listerner);
    }
    public int countObserver()
    {
    	return list.size();
    }
    public void update(Object data)
    {
    	Iterator<IObserver> it = list.iterator();
    	while(it.hasNext())
    	{
    		IObserver obs = it.next();
    		obs.notifyObserver(data);
    	}
    }
    
}

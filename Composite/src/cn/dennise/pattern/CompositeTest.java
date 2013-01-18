package cn.dennise.pattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



interface IBox
{
	public void process();
}

class SingleBox implements IBox
{

	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("this is singleBOx " + this.toString());
	}
		
}

@SuppressWarnings("unchecked")
class CompositeBox implements IBox
{
	List<IBox> mBoxList = new ArrayList(); 
	
	public boolean addBox(IBox box){return mBoxList.add(box);}
	public boolean removeBox(IBox box){return mBoxList.remove(box);}
	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("this is CompositeBOx " + this.toString());
		final Iterator it = mBoxList.iterator();
		while(it.hasNext())
		{
			IBox box = (IBox)it.next();
			box.process();
		}
	}
}

class BoxFactory
{
	public final static int SINGLEBOX = 1;
	public final static int COMPOSITEBOX = 2;
	private static  BoxFactory factory = new BoxFactory();
	public IBox getBox(int type)
	{
		if (type == this.SINGLEBOX)
			return new SingleBox();
		else if (type == this.COMPOSITEBOX)
			return new CompositeBox();
		System.out.println("there are no " + new Integer(type).toString() + "box");
		return null;
	}
	public static BoxFactory asInst(){return factory;}
}

public class CompositeTest {	
	public static void main(String[] argc)
	{
	    BoxFactory factory = BoxFactory.asInst();
		SingleBox s1 = (SingleBox) factory.getBox(BoxFactory.SINGLEBOX);
		SingleBox s2 = (SingleBox) factory.getBox(BoxFactory.SINGLEBOX);
	    CompositeBox c1 = (CompositeBox) factory.getBox(BoxFactory.COMPOSITEBOX);
	    CompositeBox c2 = (CompositeBox) factory.getBox(BoxFactory.COMPOSITEBOX);
	    c1.addBox(s1);
	    c2.addBox(s2);
	    c1.addBox(c2);
	    c1.process();
	    
	}
}

package cn.dennise.pattern;
	abstract class Stock extends Observee
	{
		int price = 0;
		public int getPrice()
		{
			return price;
		}
		public void setPrice(int price)
		{
			if (price != this.price)
				update(this);
			this.price = price;
		}
		public Stock(int price)
		{
			this.price = price;
			update(this);
		}
		public Stock()
		{
			this.price = 0;
			update(this);
		}
		
		abstract public String getName();
	}
	
	class Xiaomi extends Stock
	{
		private final String name = "xiaomi";
		@Override
		public String getName(){return name;}
		public Xiaomi(int price){setPrice(price);}
	}
	abstract class Stocker implements IObserver
	{
		@Override
		 public void notifyObserver(Object data)
		{
			Stock stock = (Stock)data;
			System.out.println(getName() + ": the stock " + stock.getName() + " price is " + new StringBuilder().append(stock.getPrice()).toString());
	
		}
		public boolean buy(Stock stock)
		{
			return stock.registerListerner(this);
		}
		abstract public String getName();
	}
	class Peoper extends Stocker
	{
		private String name = null;
		public Peoper(String name){ this.name = name;}
		public String getName(){return name;}
	}
	/**
	 * @param args
	 */
public class ObserverTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Xiaomi stock = new Xiaomi(20);
       Peoper a = new Peoper("dennise");
       a.buy(stock);
       Peoper b = new Peoper("haha");
       b.buy(stock);
       Peoper c = new Peoper("Bob");
       c.buy(stock);
       
       stock.setPrice(10);
       stock.setPrice(100);
       stock.setPrice(1000);
	}

}

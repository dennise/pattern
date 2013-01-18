package cn.dennise.pattern;

import cn.dennise.pattern.DebugLogger;
import cn.dennise.pattern.ErrLogger;
import cn.dennise.pattern.InfoLogger;
import cn.dennise.pattern.Logger;

public class LoggerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger l = new DebugLogger(Logger.DEBUG);
		Logger l1 = l;
		l1 = l1.setNext(new InfoLogger(Logger.INFO));
		l1 = l1.setNext(new ErrLogger(Logger.ERR));
		
		l.message("error message", Logger.ERR);
		l.message("info message",  Logger.INFO);
		l.message("debug message", Logger.DEBUG);

	}

}

package com.club.tools;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log {
	Logger log;
	
	public Log() {}
	public Log(String className) {
		log=Logger.getLogger(className);
		PropertyConfigurator.configure("D:/project/eclipse/club-mangement/conf.properties");
	}
	
	public void fatal(String fatal) {
		log.fatal(fatal);
	}
	
	public void error(String error) {
		log.error(error);
	}
	
	public void warn(String warn) {
		log.warn(warn);
	}
	
	public void info(String info) {
		log.info(info);
	}
	
	public void debug(String debug) {
		log.debug(debug);
	}
	
	public void trace(String trace) {
		log.trace(trace);
	}
}

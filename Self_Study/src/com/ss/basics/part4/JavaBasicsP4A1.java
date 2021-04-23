package com.ss.basics.part4;

/*
 * The purpose is to create a double lock with a singleton class
 */
public class JavaBasicsP4A1 {
	private static volatile JavaBasicsP4A1 instance;		
	
	private JavaBasicsP4A1() {}					//private constructor

	//this will lock critical section of code that creates instances of the class
	public static JavaBasicsP4A1 getInstance()	
	{
		if(instance == null)
		{
			synchronized (JavaBasicsP4A1.class)				//this will create a monitor on the part where we create an instance 
			{
				if(instance == null){
					instance = new JavaBasicsP4A1();
				}
			}
		}
		return instance;
	}
}

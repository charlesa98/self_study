package com.ss.basics.part4;

	/**
	 * @author Charles
	 *
	 */
public class JavaBasicsP4A2 {
	//create our test objects
	public static Object o1 = new Object();
	public static Object o2 = new Object();
	
	/**
	 * @param Show a deadlock example by locking the two objects in different threads and having the 
	 * oppoiste thread try to use it
	 */
	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();

		t1.start();
		t2.start();
	}
	
	private static class Thread1 extends Thread{
		public void run()
		{
			synchronized (o1)
			{
				System.out.println("Thread 1 is holding object 1");
				
				//required for the thread sleep
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("Thread 1 is waiting for object 2");
				synchronized (o2)
				{
					System.out.println("Thread 1 is holding object 1 and 2");
				}
			}
		}
	}
	
	private static class Thread2 extends Thread{
		public void run()
		{
			synchronized (o2)
			{
				System.out.println("Thread 2 is holding object 2");
				
				//required for the thread sleep
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("Thread 2 is waiting for object 1");
				synchronized (o1)
				{
					System.out.println("Thread 2 is holding object 2 and 1");
				}
			}
		}
	}
}
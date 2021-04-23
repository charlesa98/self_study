package com.ss.basics.part4;

import java.util.LinkedList;
import java.util.Random;

public class JavaBasicsP4A3 {
	 /* @param args
	 * @throws InterruptedException -needed by compiler
	 * The producer and consumer problem
	 */
	public static void main(String[] args) throws InterruptedException {	
		ProCon pc = new ProCon();					//first we create our producer consumer object
		
		Thread t1 = new Thread(new Runnable() {		//I tried to create a thread with Runnable unlike Assignment2
            @Override								//I was also having some trouble with doing it the other way 
            public void run()
            {
                try {								//needs try/catch
					pc.producer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
            }
            });
  
        Thread t2 = new Thread(new Runnable() {
        	@Override
        	public void run()
            {
                try {
					pc.consumer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
            }
            });
        
        t1.start();					//starts the threads
        t2.start();
	}
        
	public static class ProCon{
		LinkedList<Integer> buff = new LinkedList<>();		
		int size = 7;
		
		public void producer() throws InterruptedException
		{			
			while(true)
			{
				synchronized (this)
				{
					//if the buff is full, wait till the consumer removes them
					while (buff.size() == size)
					{
	                    wait();
					}
					//create a random number to add to the buff
					Random r = new Random();
					int low = 0;
					int high = 100;
					int num = r.nextInt(high-low) + low;
					
                    buff.add(num);
                    System.out.println("Producer made "+num);
                    
                    //notify tells the compiler the thread is done 
                    //used to tell the consumer method it can continue
                    //without this, program fills till the buff is full, then stops. 
                    notify();
                    
                    Thread.sleep(100);
				}
			}
		}
		
		public void consumer() throws InterruptedException
		{
			while(true)
			{
				synchronized (this)
				{
					//if the buff is empty, wait till it gets filled with something
					while(buff.size() == 0)
					{
						wait();
					}
					
					//remove the item from the buffer to divide it by 2.
					double newNum = buff.removeFirst();
					
					System.out.println("Consumer divided and now has "+newNum/2);
					
					//notify tells the compiler the thread is done 
                    //used to tell the producer method it can continue adding
                    //without this, program removes till the buff is empty, then stops. 
					notify();
					
					Thread.sleep(100);
				}
			}
		}
	}
}
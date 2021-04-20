package com.ss.basics.part3;
import java.io.File;
/**
 * @author Charles Alms
 *
 */
public class JavaBasicsP3A1 {
	/**
	 * The purpose of this is to read all the files from the path given through the command line.
	 * This will handle many paths.
	 */
	public static void main(String[] args) {
		String[] path;
		File f = null;
		for(int i =0; i<args.length; i++)
		{
			try {
				f = new File(args[i]);			//gets the path locations
				path = f.list();
		
				for(String n : path)				//prints the paths
				{
					System.out.println(n);
				}
			}
			catch (Exception e)
			{
				System.out.println("Path not found");
			}
			finally {
				if(i!=args.length-1)				//this is just to make it look nicer and easier to read
				{
					System.out.println("-------------------------");
					System.out.println("Next path:");
					System.out.println("-------------------------");
				}
			}
		}
	}
}
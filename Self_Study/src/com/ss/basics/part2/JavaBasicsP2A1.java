package com.ss.basics.part2;

public class JavaBasicsP2A1 {

	/**
	 * find the max of the array an the position it is at (first instance)
	 */
	public static void main(String[] args) {
		//3,5 sized array
		int[][] array = {{1, 2, 4, 6, 9}, {5, 3, 6, 7, 8}, {4, 2, 5, 6, 7}};
		int max = array[0][0];		//set the max to the first value of the array
		int c=0, r=0;
		
		for(int i =0; i<3; i++)
		{
			for(int j=0; j<5; j++)
			{
				if(array[i][j] > max)
				{
					max = array[i][j];			//sets the max equal to the value in the array
					c=i;						//sets the column and row of it 
					r=j;
				}
			}
		}
		System.out.println("The max value in the array is "+ max+" at position "+ c +","+ r);
	}

}

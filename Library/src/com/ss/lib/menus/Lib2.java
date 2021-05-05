package com.ss.lib.menus;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ss.lib.entity.LibraryBranch;
import com.ss.lib.service.LibrarianService;

public class Lib2 {
	LibrarianService ls = new LibrarianService();
	
	private void message()
	{
		System.out.println("Select your branch Name or quit to quit to previous menu");
	}
	
	public void run() throws SQLException
	{
		try {
			ls.readLibraryBranchNames();
		}
		catch (Exception e)
		{
			e.printStackTrace();	
		}
	}
	public void run2(List<LibraryBranch> branchList) throws SQLException
	{
		message();
		Scanner input = new Scanner(System.in);
				
		int choice = Integer.parseInt(input.nextLine());
		Boolean quit = false;
		
		while(choice-1 <= branchList.size() && choice-1 >= 0 && quit != true)
		{	
			if(choice-1 == branchList.size())
			{
				System.out.println("Returning to previous menu\n\n");
				Lib1 l1 = new Lib1();
				l1.run();
			}
			else
			{
				choice -= 1;		//this makes the choice = to the index of array since the array starts at index 0 but choice starts at 1
				//create an array to convert the list so we can get the index (choice+1) of the branch we want
				LibraryBranch[] branchArray = new LibraryBranch[branchList.size()];
				branchArray = branchList.toArray(branchArray);
				
				LibraryBranch branch = new LibraryBranch();
				
				branch.setBranchID(branchArray[choice].getBranchID());
				branch.setBranchName(branchArray[choice].getBranchName());
				branch.setBranchAddress(branchArray[choice].getBranchAddress());
			
				quit = true;
				Lib3 l3 = new Lib3();
				l3.run(branch);
			}
		}
		input.close();
	}
}

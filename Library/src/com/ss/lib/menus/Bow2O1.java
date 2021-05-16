package com.ss.lib.menus;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ss.lib.entity.LibraryBranch;
import com.ss.lib.service.BorrowerService;

public class Bow2O1 {
	BorrowerService bs = new BorrowerService();
	
	private void message()
	{
		System.out.println("Select your branch Name or quit to quit to previous menu");
	}
	
	public void run(int cardNum) throws SQLException
	{
		try {
			bs.readLibraryBranchNamesCheckOut(cardNum);
		}
		catch (Exception e)
		{
			e.printStackTrace();	
		}
	}
	public void run2(List<LibraryBranch> branchList, int cardNum) throws SQLException
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
				Bow1 b1 = new Bow1();
				b1.run();
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
				
				System.out.println("You have entered branch "+branch.getBranchID()+" "+branch.getBranchName());
				CheckOut cout = new CheckOut();
				cout.run(branch, cardNum);
			}
		}
		input.close();
	}
}

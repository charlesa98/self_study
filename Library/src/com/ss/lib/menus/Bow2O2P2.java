package com.ss.lib.menus;

import com.ss.lib.entity.LibraryBranch;
import com.ss.lib.service.BorrowerService;

public class Bow2O2P2 {
	BorrowerService bs = new BorrowerService();

	private void header1()
	{
		System.out.println("\nHere are all the books available for your selected branch");
	}
	
	public void run(LibraryBranch lb, int cardNum)
	{
		header1();
		try {
			bs.readLibraryBranchBooksAvaialbe(lb);
		}
		catch (Exception e)
		{
			e.printStackTrace();	
		}
	}
	
}

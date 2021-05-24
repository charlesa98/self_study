package com.ss.utop.menu;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ss.utop.entity.Route;
import com.ss.utop.service.EmployeeService;

public class Employee2 {
	EmployeeService es = new EmployeeService();
	
	private void message()
	{
		System.out.println("Select your Flight or quit to quit to previous menu");
	}
	
	public void run() throws SQLException
	{
		try {
			es.readRoutes();
		}
		catch (Exception e)
		{
			e.printStackTrace();	
		}
	}
	public void run2(List<Route> routeList) throws SQLException
	{
		message();
		Scanner input = new Scanner(System.in);
				
		int choice = Integer.parseInt(input.nextLine());
		Boolean quit = false;
		
		while(choice-1 <= routeList.size() && choice-1 >= 0 && quit != true)
		{	
			if(choice-1 == routeList.size())
			{
				System.out.println("Returning to previous menu\n\n");
				Employee1 e1 = new Employee1();
				e1.run();
			}
			else
			{
				choice -= 1;		//this makes the choice = to the index of array since the array starts at index 0 but choice starts at 1
				//create an array to convert the list so we can get the index (choice+1) of the branch we want
				Route[] routeArray = new Route[routeList.size()];
				routeArray = routeList.toArray(routeArray);
				
				Route route = new Route();
				
				route.setId(routeArray[choice].getId());
				route.setOrgAirport(routeArray[choice].getOrgAirport());
				route.setDesAirport(routeArray[choice].getDesAirport());
				
				quit = true;
				Employee3 e3 = new Employee3();
				e3.run(route);
			}
		}
		input.close();
	}
}

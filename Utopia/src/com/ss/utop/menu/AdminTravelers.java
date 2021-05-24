package com.ss.utop.menu;

import java.sql.SQLException;
import java.util.Scanner;

import com.ss.utop.entity.User;
import com.ss.utop.service.AdminService;

public class AdminTravelers {
	private AdminService service = new AdminService();
	User user = new User();
	Boolean flag = false;			//used to see if anything was updated
	
	public void performNext() throws SQLException 
	{
		Scanner input = new Scanner(System.in);
		String choice = input.nextLine();
		
		//uses if else statements instead of switch because it allows the user to type single letters and ignore case
		if(choice.equalsIgnoreCase("add") || choice.equalsIgnoreCase("a"))
		{
			addNewEmployee();
		}
		else if(choice.equalsIgnoreCase("update") || choice.equalsIgnoreCase("u"))
		{
			updateUser();
		}
		else if(choice.equalsIgnoreCase("delete") || choice.equalsIgnoreCase("d"))
		{
			deleteUser();
		}
		else if(choice.equalsIgnoreCase("read") || choice.equalsIgnoreCase("r"))
		{
			readAllEmployees();
		}
		else if(choice.equalsIgnoreCase("quit") || choice.equalsIgnoreCase("q"))
		{
			System.out.println("Quitting");
		}
		else
		{
				System.out.println("That is not a valid option. \nPlease enter \"add\", \"update\", \"delete\", \"read\", or \"quit\"");
				performNext();
		}
		input.close();
	}
	
	private void addNewEmployee() throws SQLException
	{
		Scanner input = new Scanner(System.in);		
		System.out.println("\nADD to Employees\n");
		
		user.getUserRole().setId(3); 		//UserRole 3 is a traveler		
		System.out.println("First Name?");
		String fName = input.nextLine();
		
		user.setfName(fName);
		
		System.out.println("Last Name?");
		String lName = input.nextLine();
		
		user.setlName(lName);
		
		System.out.println("User Name?");
		String uName = input.nextLine();
		
		user.setUserName(uName);
		
		System.out.println("Email?");
		String email = input.nextLine();
		
		user.setEmail(email);
		
		System.out.println("Password?");
		String pw = input.nextLine();
		
		user.setPassword(pw);
		
		System.out.println("Phone?");
		String phone = input.nextLine();
		
		user.setPhone(phone);
		
		service.addNewUser(user);
		
		input.close();
	}
	
	private void updateUser() throws SQLException
	{
		Scanner input = new Scanner(System.in);
		
		service.readAllUsers();
		
		System.out.println("First Name?");
		String fName = input.nextLine();
		
		if(fName.isEmpty() == false)
		{	
			flag = true;
			user.setfName(fName);
			service.updateUserFName(user);
		}
		
		System.out.println("Last Name?");
		String lName = input.nextLine();
		
		
		if(lName.isEmpty() == false)
		{	
			flag = true;
			user.setlName(lName);
			service.updateUserLName(user);
		}
		
		System.out.println("User Name?");
		String uName = input.nextLine();
		
		if(uName.isEmpty() == false)
		{
			flag = true;
			user.setUserName(uName);
			service.updateUserUName(user);
		}
		
		System.out.println("Email?");
		String email = input.nextLine();
		
		if(email.isEmpty() == false)
		{	
			flag = true;
			user.setEmail(email);
			service.updateUserEmail(user);
		}
		
		System.out.println("Password?");
		String pw = input.nextLine();
		
		if(pw.isEmpty() == false)
		{	
			flag = true;
			user.setPassword(pw);
			service.updateUserPw(user);
		}
		
		System.out.println("Phone?");
		String phone = input.nextLine();
		
		if(phone.isEmpty() == false)
		{	
			flag = true;
			user.setPhone(phone);
			service.updateUserPhone(user);
		}
		
		if(flag == false)
		{
			System.out.println("Nothing was changed. Returning");
			Main.run();
		}
		
		input.close();
		Main.run();
	}
	
	private void deleteUser() throws SQLException
	{
		Scanner input = new Scanner(System.in);
		
		service.readAllUsers();
		
		System.out.println("DELETE Employees");
		System.out.println("ID of Employee to delete?");
		int id = Integer.parseInt(input.nextLine());
		
		service.deleteUser(id);
		
		input.close();
	}
	
	private void readAllEmployees() throws SQLException
	{
		service.readAllUsers();
	}
}

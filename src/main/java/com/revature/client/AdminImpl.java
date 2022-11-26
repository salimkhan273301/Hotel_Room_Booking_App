package com.revature.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import com.revature.db.DataBaseConnection;
import com.revature.model.Cab;
import com.revature.model.Employee;
import com.revature.service.BookingSystem;
import com.revature.service.BookingSystemImpl;

public class AdminImpl {

	public int start() {
		System.out.println("===Welcome to Admin Page=====");
		while (true) {
			System.out.println("====select Opration====");
			System.out.println("1.add New Employee");
			System.out.println("2.add Cab");
			System.out.println("3.Check Request");
			System.out.println("press antthing else to logout");
			Scanner sc = new Scanner(System.in);
			Integer choice = sc.nextInt();
			AdminImpl a = new AdminImpl();
			switch (choice) {
			case 1: {
				try {
					a.addEmp();
				} catch (Exception e) {
					System.out.println("An Exception is Generated" + e);
				}
				break;
			}
			case 2: {
				a.addCab();
				break;
			}
			case 3: {
				BookingSystem bs=new BookingSystemImpl();
				 bs.checkRequest();
				break;
			}
			default: {
				System.out.println("=======logging_out======");
				return 0;
			}
			} // switch closer
		} // while closer

	} // start closer

	void addCab() {

		System.out.println("Enter Cab Number:");
		Scanner sc = new Scanner(System.in);
		Integer CNo = sc.nextInt();
		LocalDate demo1=LocalDate.now();
		LocalTime lt=LocalTime.now();
		Cab newCab = new Cab(CNo,demo1,lt,0);
		BookingSystemImpl bs = new BookingSystemImpl();
		try {
			bs.addCab(newCab);
		} catch (Exception e) {
			System.out.println("got an exception here..." + e);
		}

	}

	private void addEmp() throws Exception {
		Connection con = DataBaseConnection.getConnection();
		PreparedStatement pst1 = con
				.prepareStatement("insert into employee(name,email,dept,manager,active,password,admin) values(?,?,?,?,?,?,?)");
		Employee emp = this.getNewEmployee();
		pst1.setString(1, emp.getName());
		pst1.setString(2, emp.getEmail());
		pst1.setString(3, emp.getDept());
		if (emp.getManager() == true)
			pst1.setInt(4, 1);
		else
			pst1.setInt(4, 0);
		pst1.setInt(5, 1);
		
		pst1.setString(6, emp.getName() + "123");
		pst1.setInt(7, 0);
		pst1.execute();

	}

	Employee getNewEmployee() {
		Employee a;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Employee Name:");
		String n = sc.nextLine();
		System.out.println("Enter Employee Email ID:");
		String e = sc.nextLine();
		System.out.println("Enter his Department:");
		String d = sc.nextLine();
		System.out.println("Is he a Manager? y/n");
		char m = sc.next().charAt(0);
		if (m == 'y' || m == 'Y')
			a = new Employee(1, n, e, true, d);
		else
			a = new Employee(1, n, e, d);
		return a;

	}
}
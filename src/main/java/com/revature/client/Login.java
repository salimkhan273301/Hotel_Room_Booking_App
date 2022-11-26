package com.revature.client;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.logging.Logger;

import com.revature.db.DataBaseConnection;

import com.revature.model.Employee;

public class Login {
	String email;
	String password;
	private static final Logger logger = Logger.getLogger("login.class");

	public static void main(String[] args) throws Exception {
		Connection con = DataBaseConnection.getConnection();
		Scanner sc = new Scanner(System.in);
		int choice;
		logger.info("Excecution is startion from here........");
		while (true) {
			System.out.println("=====MENU=======");
			System.out.println("select option");
			System.out.println("1.Employee");
			System.out.println("2.Manager");
			System.out.println("3.Admin");
			choice = sc.nextInt();
			if (sc.hasNextLine()) {
				String strunfh = sc.nextLine();
				//sc.close();
			}
			switch (choice) {
			case 1: {
				Login emp = new Login();
				logger.info("login is start from here........");
				emp.getEmailPass();
				PreparedStatement pst = con
						.prepareStatement("select * from employee where email=? and password=? and manager=0");
				pst.setString(1, emp.email);
				pst.setString(2, emp.password);
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					Integer id = rs.getInt("eid");
					String name = rs.getString("name");
					String email = rs.getString("email");
					String dept = rs.getString("dept");
					EmployeeImpl empi = new EmployeeImpl(id, name, email, dept);
					logger.info("Going to Employee Implimentarion .java file");
					empi.request();
				} else {
					logger.info(" Wrong email and Password Entered by Employee");
					System.out.println("you have Entered  Wrong Email and password");
					System.out.println("Please Try again with right Information");
				}
				break;
			}

			case 2: {
				Login manager = new Login();
				logger.info(" Manager login is start from here........");
				manager.getEmailPass();
				PreparedStatement pst1 = con
						.prepareStatement("select * from employee where email=? and password=? and manager=1");
				pst1.setString(1, manager.email);
				pst1.setString(2, manager.password);
				ResultSet rs1 = pst1.executeQuery();
				if (rs1.next()) {
					Integer id = rs1.getInt("eid");
					String name = rs1.getString("name");
					String email = rs1.getString("email");
					String dept = rs1.getString("dept");
					ManagerImpl manager1 = new ManagerImpl(id, name, email, true, dept);
					logger.info("Going to Employee Implimentarion .java file");
					try {
						logger.info("Going to mannagerImpl.Java File...");
						manager1.accept();
					} catch (Exception e) {
						System.out.println("Got an Exception here" + e);
					}
				} else {
					logger.info(" Wrong email and Password Entered by Manager");
					System.out.println("you have Entered  Wrong Email and password");
					System.out.println("Please Try again with right Information");
				}
				break;
			}

			case 3: {

				Login admin = new Login();
				logger.info("login is start from here........");
				admin.getEmailPass();
				PreparedStatement pst2 = con
						.prepareStatement("select * from employee where email=? and password=? and admin=1");
				pst2.setString(1, admin.email);
				pst2.setString(2, admin.password);
				ResultSet rs2 = pst2.executeQuery();
				if (rs2.next()) {
					// Integer id=rs2.getInt("id");
					//// String name=rs2.getString("name");
					// String email=rs2.getString("name");
					// String dept=rs2.getString("name");
					AdminImpl admini = new AdminImpl();
					logger.info("Going to Admin Implimentarion .java file");
					int a = admini.start();
				} else {
					logger.info(" Wrong email and Password Entered by Employee");
					System.out.println("you have Entered  Wrong Email and password");
					System.out.println("Please Try again with right Information");
				}
				break;

			}
			default: {
				logger.info("closing the Application");
				System.out.println("you have Entered  Wrong choice");
				System.out.println("===Quit====");
				System.exit(0);
			}

			}
		}
	}

	private void getEmailPass() {
		logger.info("Getting  iemail pass  from here........");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Email here:");
		this.email = sc.nextLine();
		System.out.println("Enter your Password :");
		this.password = sc.nextLine();
		//sc.close();
		logger.info("Email and password Got Now Valigating Details........");

	}

}


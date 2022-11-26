package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;

import com.revature.db.DataBaseConnection;
import com.revature.model.Cab;

public class BookingImpl implements Booking {

	public Set<Cab> copycabs()
	{
		Set<Cab> cabs=new LinkedHashSet<Cab>();
		try {
			Connection con = DataBaseConnection.getConnection();
			PreparedStatement pt = con.prepareStatement("select cid,freeorbooked from cab_details");
			ResultSet rs = pt.executeQuery();
			while(rs.next()) {
				Integer cabNo = rs.getInt(1);
				Integer fOB = rs.getInt(2);
				Cab a = new Cab(cabNo,fOB);
				cabs.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cabs;
	}


}

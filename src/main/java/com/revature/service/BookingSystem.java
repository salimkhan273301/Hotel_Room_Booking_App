package com.revature.service;

import com.revature.model.Cab;

public interface BookingSystem {
	
	Integer requestCab() throws Exception;;

	Integer getNoOfAvailableCabs() throws Exception;;

	void addCab(Cab newCab) throws Exception;

	void checkRequest();

}

package com.airtable.perfect.one.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airtable.perfect.one.beans.Jewellery;
import com.airtable.perfect.one.service.IJewelleryService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class JewelleryRESTController

{
	@Autowired
	private IJewelleryService jewelleryService;

	@GetMapping(path = "/JewelleriesOrdersInProgress")
	public List<Jewellery> listJewelleriesInprogress() throws IOException {
		/* • Number of orders in progress */

		return jewelleryService.findBylistJewelleriesInProgress();
	}

	@GetMapping(path = "/JewelleriesMostRecentOrders")
	public List<Jewellery> listJewelleriesMostRecentOrders() throws IOException {
		/* • • A list of the most recent few orders */

		return jewelleryService.findByMostRecentOrderss();
	}

	@GetMapping(path = "/JewelleriesMonth")
	public List<Jewellery> listJewelleriesOftheMonth() throws IOException {
		/* • Total Orders this month */

		return jewelleryService.findByOrderOftheMonth();
	}

	@GetMapping(path = "/Jewelleries")
	public List<Jewellery> listOfJewelleries() throws IOException {
		/* • Total Orders */

		return jewelleryService.findAll();
	}

	@GetMapping(path = "/JewelleriesRevenue")
	public Double revenue() throws IOException {
		/* •Revenue */

		return jewelleryService.calculateRevenue();
	}

}

package com.airtable.perfect.one.service;

import java.io.IOException;
import java.util.List;

import com.airtable.perfect.one.beans.Jewellery;

public interface IJewelleryService {

	public double calculateRevenue() throws IOException;

	public List<Jewellery> findAll() throws IOException;

	public List<Jewellery> findBylistJewelleriesInProgress() throws IOException;

	public List<Jewellery> findByMostRecentOrderss() throws IOException;

	public List<Jewellery> findByOrderOftheMonth() throws IOException;

}

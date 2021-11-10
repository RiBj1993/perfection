package com.airtable.perfect.one.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.airtable.perfect.one.beans.Jewellery;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

@Service
public class JewelleryService implements IJewelleryService {
	List<Jewellery> list_Jewellery;
	CSVReader reader;
	DateFormat format;
	DateTimeFormatter format2;
	Date date;
	SimpleDateFormat sdf;

	public JewelleryService() throws IOException {

		InputStream in = getClass().getResourceAsStream("/Orders-Gridview.csv");
		InputStreamReader readers = new InputStreamReader(in, StandardCharsets.UTF_8);

		reader = new CSVReaderBuilder(readers).withSkipLines(1).build();
		format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
		sdf = new SimpleDateFormat("yyyy-MM");

		list_Jewellery = reader.readAll().stream().map(this::returnListJewelleryFromData).collect(Collectors.toList());
	}

	@Override
	public double calculateRevenue() throws IOException {

		return list_Jewellery.stream().mapToDouble(m -> Double.parseDouble(m.getPrice().replace("£", ""))).sum();
	}

	@Override
	public List<Jewellery> findAll() throws IOException {
		return list_Jewellery;
	}

	@Override
	public List<Jewellery> findBylistJewelleriesInProgress() throws IOException {
		return list_Jewellery.stream().filter(x -> x.getOrderStatus().contains("in_progress"))
				.collect(Collectors.toList());
	}

	@Override
	public List<Jewellery> findByMostRecentOrderss() throws IOException {
		List<Jewellery> jewelleryList = list_Jewellery.stream().collect(Collectors.toList());

		List<Jewellery> jewelleryLists = new ArrayList<Jewellery>(jewelleryList);

		List<Jewellery> result = jewelleryLists.stream()
				.sorted((o1, o2) -> o1.getOrderPlaced().compareTo(o2.getOrderPlaced())).collect(Collectors.toList());

		return result.subList(result.size() - 3, result.size());
	}

	@Override
	public List<Jewellery> findByOrderOftheMonth() throws IOException {
		return list_Jewellery.stream()
				.filter(x -> sdf.format(x.getOrderPlaced()).compareTo(sdf.format(new Date())) == 0)
				.collect(Collectors.toList());

	}

	Jewellery returnListJewelleryFromData(String[] data) {
		Jewellery jewellerycsvObject = new Jewellery();

		jewellerycsvObject.setOrderId(data[0]);
		try {
			jewellerycsvObject.setOrderPlaced(format.parse(data[1]));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		jewellerycsvObject.setProductName(data[2]);
		jewellerycsvObject.setPrice(data[3]);
		jewellerycsvObject.setFirstName(data[4]);
		jewellerycsvObject.setLastName(data[5]);
		jewellerycsvObject.setAddress(data[6]);
		jewellerycsvObject.setEmail(data[7]);
		jewellerycsvObject.setOrderStatus(data[8]);

		return jewellerycsvObject;
	}

}
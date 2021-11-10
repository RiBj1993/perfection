package com.airtable.perfect.one.beans;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Jewellery {
	private String orderId;
	private Date orderPlaced;
	private String productName;
	private String price;
	private String firstName;
	private String lastName;
	private String address;
	private String email;
	private String orderStatus;
}
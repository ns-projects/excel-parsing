package com.haud.bitfrost.importfiles.model;

import java.util.List;

public class PriceDTO {
	
	private String country;
	
	private String network;
	
	private double mcc;
	
	private double mnc;
	
	private String route;

	private double price;

	public PriceDTO(String country, String network, int mcc, int mnc, String route, float price) {
		super();
		this.country = country;
		this.network = network;
		this.mcc = mcc;
		this.mnc = mnc;
		this.route = route;
		this.price = price;
	}

	public PriceDTO(List<PriceDTO> list) {
		// TODO Auto-generated constructor stub
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public double getMcc() {
		return mcc;
	}

	public void setMcc(double d) {
		this.mcc = d;
	}

	public double getMnc() {
		return mnc;
	}

	public void setMnc(double d) {
		this.mnc = d;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double d) {
		this.price = d;
	}

	
}

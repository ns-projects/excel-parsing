package com.haud.bitfrost.importfiles.model;

import java.util.ArrayList;
import java.util.List;

public class PriceDTO {

	private String country;

	private String network;

	private double mcc;

	private double mnc;

	private String route;

	private double price;

	public PriceDTO() {

	}

	public PriceDTO(String country, String network, double mcc, double mnc, String route, double price) {
		super();
		this.country = country;
		this.network = network;
		this.mcc = mcc;
		this.mnc = mnc;
		this.route = route;
		this.price = price;
	}

	public PriceDTO(ArrayList<PriceDTO> list) {
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

	public void setMcc(double mcc) {
		this.mcc = mcc;
	}

	public double getMnc() {
		return mnc;
	}

	public void setMnc(double mnc) {
		this.mnc = mnc;
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

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "PriceDTO [country=" + country + ", network=" + network + ", mcc=" + mcc + ", mnc=" + mnc + ", route="
				+ route + ", price=" + price + "]";
	}

}

package prs.dto;

import prs.entity.Doctor;

public class DoctorDTO {
	private int doctorID;
    private String name;
    private String surname;
    private String prefix;
    private String street;
    private String postcode;
    private String city;
    private String country;
    private String phoneNumber;
    public DoctorDTO(Doctor doctor) {
		this.doctorID = doctor.getDoctorID();
		this.name = doctor.getName();
		this.surname = doctor.getSurname();
		this.prefix = doctor.getPrefix();
		this.street = doctor.getStreet();
		this.postcode = doctor.getPostcode();
		this.city = doctor.getCity();
		this.country = doctor.getCountry();
		this.phoneNumber = doctor.getPhoneNumber();
	}
	public final int getDoctorID() {
		return doctorID;
	}
	public final void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final String getSurname() {
		return surname;
	}
	public final void setSurname(String surname) {
		this.surname = surname;
	}
	public final String getPrefix() {
		return prefix;
	}
	public final void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public final String getStreet() {
		return street;
	}
	public final void setStreet(String street) {
		this.street = street;
	}
	public final String getPostcode() {
		return postcode;
	}
	public final void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public final String getCity() {
		return city;
	}
	public final void setCity(String city) {
		this.city = city;
	}
	public final String getCountry() {
		return country;
	}
	public final void setCountry(String country) {
		this.country = country;
	}
	public final String getPhoneNumber() {
		return phoneNumber;
	}
	public final void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}

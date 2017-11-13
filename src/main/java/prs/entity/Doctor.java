package prs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="doctors")
public class Doctor {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="doctor_id")
	private int doctorID;
	@Column(name="name")
    private String name;
	@Column(name="surname")
    private String surname;
	@Column(name="prefix")
    private String prefix;
	@Column(name="street")
    private String street;
	@Column(name="postcode")
    private String postcode;
	@Column(name="city")
    private String city;
	@Column(name="country")
    private String country;
	@Column(name="phone_number")
    private String phoneNumber;
	@OneToOne
	@JoinColumn(name = "account_id")
	private Account account;
	
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

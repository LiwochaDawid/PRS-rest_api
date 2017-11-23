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
@Table(name="patients")
public class Patient {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="patient_id")
	private int patientID;
	@Column(name="name")
    private String name;
	@Column(name="surname")
    private String surname;
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
	
	public final int getPatientID() {
		return patientID;
	}
	public final void setPatientID(int patientID) {
		this.patientID = patientID;
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
	public final void setAccount(Account account) {
		this.account = account;
	}
	public final Account getAccount() {
		return account;
	}
}

package prs.model;

import prs.entity.Account;
import prs.entity.Patient;

public class PatientWrapper {
	private Patient patient;
	private Account account;
	public final Patient getPatient() {
		return patient;
	}
	public final void setPatient(Patient patient) {
		this.patient = patient;
	}
	public final Account getAccount() {
		return account;
	}
	public final void setAccount(Account account) {
		this.account = account;
	}
}
package prs.model;

import prs.entity.Account;
import prs.entity.Doctor;

public class DoctorWrapper {
	private Doctor doctor;
	private Account account;
	public final Doctor getDoctor() {
		return doctor;
	}
	public final void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public final Account getAccount() {
		return account;
	}
	public final void setAccount(Account account) {
		this.account = account;
	}
}

package prs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="accounts")
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="account_id")
	private int accountID;
	@Column(name="email")
    private String email;
	@Column(name="login")
    private String login;
	@Column(name="password")
    private String password;
	@Column(name="salt")
    private String salt;
	public final int getAccountID() {
		return accountID;
	}
	public final void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public final String getEmail() {
		return email;
	}
	public final void setEmail(String email) {
		this.email = email;
	}
	public final String getLogin() {
		return login;
	}
	public final void setLogin(String login) {
		this.login = login;
	}
	public final String getPassword() {
		return password;
	}
	public final void setPassword(String password) {
		this.password = password;
	}
	public final String getSalt() {
		return salt;
	}
	public final void setSalt(String salt) {
		this.salt = salt;
	}
}

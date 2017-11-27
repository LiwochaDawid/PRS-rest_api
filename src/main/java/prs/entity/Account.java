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
	@Column(name="username")
    private String username;
	@Column(name="password")
    private String password;
	@Column(name="role")
    private String role;
	@Column(name="enabled")
    private boolean enabled;
	public final int getAccountID() {
		return accountID;
	}
	public final void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public final String getUsername() {
		return username;
	}
	public final void setUsername(String username) {
		this.username = username;
	}
	public final String getPassword() {
		return password;
	}
	public final void setPassword(String password) {
		this.password = password;
	}
	public final String getRole() {
		return role;
	}
	public final void setRole(String role) {
		this.role = role;
	}
	public final boolean getEnabled() {
		return this.enabled;
	}
	public final void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}

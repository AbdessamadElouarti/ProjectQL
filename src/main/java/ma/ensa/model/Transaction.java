package ma.ensa.model;

// Generated 2 janv. 2016 00:44:40 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Transaction generated by hbm2java
 */
@Entity
@Table(name = "transaction", catalog = "ql")
public class Transaction implements java.io.Serializable {

	private Integer id;
	private String userLogin;
	private int montant;

	public Transaction() {
	}

	public Transaction(String userLogin, int montant) {
		this.userLogin = userLogin;
		this.montant = montant;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "user_login", nullable = false, length = 40)
	public String getUserLogin() {
		return this.userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	@Column(name = "montant", nullable = false)
	public int getMontant() {
		return this.montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}

}
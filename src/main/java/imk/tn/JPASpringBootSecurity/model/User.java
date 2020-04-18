package imk.tn.JPASpringBootSecurity.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long id;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "password")
	private String password;

	
	/*
	 * @ManyToMany(fetch = FetchType.LAZY , cascade = { CascadeType.PERSIST,
	 * CascadeType.MERGE, })
	 * 
	 * 
	 * @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"),
	 * inverseJoinColumns = @JoinColumn(name = "user_role_id") )
	 */
	
	@OneToMany(mappedBy="user", cascade={CascadeType.ALL})
	private Collection<Role> roles;

	public Long getId() {
		return id;
	}

	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}

}
package egzaminas.egzaminas;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "applications")
public class Application {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long id;
	protected String name;
	@ManyToOne(fetch = FetchType.EAGER)
	protected School school;
	@ManyToOne(fetch = FetchType.EAGER)
	protected User user;

	public Application() {}

	public Application(School school, User user, String name) {
		this.name = name;
		this.school = school;
		this.user = user;
	}

	public String getName() {
		return name;
	}
	
	public School getSchool() {
		return school;
	}
	
	public User getUser() {
		return user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}

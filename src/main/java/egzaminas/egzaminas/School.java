package egzaminas.egzaminas;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "schools")
public class School {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long id;
	protected String name;
	protected String address;
	protected int code;

	public School() {}

	public School(String name, String address, int code) {
		this.name = name;
		this.address = address;
		this.code = code;
	}

	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public int getCode() {
		return code;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}

package lt.ktu.client.first.model;

public class Person {
	private Long id;
	private String firstName;
	private String lastName;
	private Integer age;
	private String personalCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPersonalCode() {
		return personalCode;
	}

	public void setPersonalCode(String personalCode) {
		this.personalCode = personalCode;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", age=" + age + ", personalCode=" + personalCode
				+ "]";
	}

}

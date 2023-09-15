package in.bhushansirgur.springrestapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	private String name;
	private Long age;
	private String location;
	private String email;
	private String department;
	
	public Long getAge() {
		return age;
	}
	
	public void setAge(Long age) {
		this.age = age;
	}
}

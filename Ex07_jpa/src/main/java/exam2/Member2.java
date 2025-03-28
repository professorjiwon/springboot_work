package exam2;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="JpaMember2")
public class Member2 {
	@Id
	@SequenceGenerator (
		name="mySequence", // 시퀀스의 별칭
		sequenceName ="JpaMember2_seq",	// 실제 DB에 생성되는 시퀀스 이름
		initialValue = 1,		// 초기값
		allocationSize = 1		// 1씩증가
	)
	@GeneratedValue(generator = "mySequence") // 시퀀스의 별칭
	private Long id;
	
	@Access(AccessType.FIELD)  // 필드를 통해서 데이터 접근(기본값)
	private String username;
	
	@Access(AccessType.PROPERTY)	// get/set메소드를 통해 데이터에 접근
	private String password;
	
	@Transient
	private long timestamp1;  // 어노테이션을 이용하여 영속대상(db)에서 제외
	transient private long timestamp2;  // 키워드를 이용하여 영속대상(db)에서 제외
	
	public Member2() {
	}

	public Member2(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
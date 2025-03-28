package exam3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class SelectTest {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaEx01");
		EntityManager em = emf.createEntityManager();
		
		/*
		 * 검색시 find() 메소드 사용
		   - test@test.com를 찾아서 Member3에 담아서 가지고 오려고 함
		     > find뒤에 아무것도 붙이지 않으면 @Id가 붙은 필드에서 검색
		 */
		Member3 user = em.find(Member3.class, "test@test123.com");
		System.out.println(user);
		
		if(user != null) {
			System.out.println("이름 : " + user.getName());
			System.out.println("email : " + user.getEmail());
			System.out.println("날짜 : " + user.getCreateDate());
		} else {
			System.out.println("존재하지 않는 아이디 입니다");
		}
		em.close();
		emf.close();
	}
}

package exam3;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class InsertTest {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaEx01");
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			
			Member3 user = new Member3("test@test.com", "홍길동", LocalDate.now());
			System.out.println("1 : ");
			
			em.persist(user);
			System.out.println("2 : ");
			
			em.getTransaction().commit();
			System.out.println("3 : ");
			System.out.println("가입 요청을 처리 했습니다");
			
		} catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		em.close();
		emf.close();
	}
}

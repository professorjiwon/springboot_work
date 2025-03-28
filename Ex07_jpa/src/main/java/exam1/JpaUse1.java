package exam1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaUse1 {

	public static void main(String[] args) {
		// JPA환경 설정
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaEx01");
		// 실제 DB와 연결하여 CRUD
		EntityManager em = emf.createEntityManager();
		// 트랜잭션 관리
		EntityTransaction ts = em.getTransaction();
		
		try {
			ts.begin();   // 트랜잭션 시작
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}

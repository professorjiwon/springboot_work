package exam4;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class TypedQueryLikeParameter {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaEx01");
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			
			TypedQuery<Member4> query =
					em.createQuery("select m from Member4 m"
							+ " where m.email like :email"
							+ " order by m.name"
							  , Member4.class)
					  .setParameter("email", "%test%");
			
			List<Member4> list = query.getResultList();
			
			em.getTransaction().commit();
			
			if(list.isEmpty()) {
				System.out.println("사용자 없습니다");
			} else {
				list.forEach(user -> 
					System.out.println(user.getName() + " / " + user.getEmail()));
			}

		} catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		em.close();
		emf.close();

	}
}

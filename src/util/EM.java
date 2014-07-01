package util;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class EM {

	@Inject
	private EntityManagerFactory emf;

	@Produces
	@RequestScoped
	public EntityManager createEntityManager() {
		return emf.createEntityManager();
	}

	public void closeEM(@Disposes EntityManager em) {
		em.close();
	}
}
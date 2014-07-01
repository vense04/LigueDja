package util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMF {

	@Produces
	@ApplicationScoped
	public EntityManagerFactory emf() {
		return Persistence.createEntityManagerFactory("meujpa");
	}

	public void closeEMF(@Disposes EntityManagerFactory emf) {
		emf.close();
	}
}
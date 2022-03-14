package be.pxl.paj;

import be.pxl.paj.domain.Superhero;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateJPA {

	private static final Logger LOGGER = LogManager.getLogger(UpdateJPA.class);

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("musicdb_pu");
		EntityManager entityManager = emf.createEntityManager();
		Long superHeroId = 2L;
		Superhero savedSuperhero = entityManager.find(Superhero.class, superHeroId);

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		savedSuperhero.setDescription("Some description here...");
		transaction.commit();

		entityManager.close();
		emf.close();
	}
}

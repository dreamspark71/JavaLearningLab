package JPAHibernateORMCodeTableMapping;

import java.util.List;

/**
 * Interface for the CRUD methods.
 */
public interface BikeTypeEntityDaoInterface {


	public int persist(BikeTypeEntity bike);

	public List findAll();

	public void update(BikeTypeEntity bike);

	public void delete(BikeTypeEntity bike);

	public BikeTypeEntity findById(int id);

	public void deleteAll();


}
package HibernateORMCode;

import java.util.List;

/**
 * Interface for the CRUD methods.
 */
public interface BikeEntityDaoInterface {


	public int persist(BikeEntity bike);

	public List findAll();

	public void update(BikeEntity bike);

	public void delete(BikeEntity bike);

	public BikeEntity findById(int id);

	public void deleteAll();


}
package HibernateORMCode;

import java.util.List;

public interface BikeManagerInterface {

	public void createBike(BikeEntity bike);

	public List retrieveBikes();

	public void updateBike(BikeEntity bike);

	public void deleteBike(BikeEntity bike);

	public BikeEntity retrieveBikeById(int id);

	public void deleteAllBikes();

}
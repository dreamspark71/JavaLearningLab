package JPAHibernateORMCodeTableMapping;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;

import java.util.Set;

@Entity

@Table(name = "bike_type", uniqueConstraints = {
	@UniqueConstraint( columnNames = "id" )
})
class BikeTypeEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@Column(name = "bike_type", nullable = false, length = 20)
	private String bikeType;


	/* NOTES ON mappedBy="" ATTRIBUTE
	the attribute mappedBy indicates that the entity in this side is the inverse of the relationship, and the owner resides in the "other" entity. 
	This also means that you can access the other table from the class which you've annotated with "mappedBy" (fully bidirectional relationship).
	http://stackoverflow.com/questions/11938253/jpa-joincolumn-vs-mappedby
	*/
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "bikeType")  // , mappedBy="bikeType"
	//@JoinColumn(name = "bike_type_id")
	private Set<BikeEntity> bikeEntities;


	// Setters

	public void setId( int id ) {
		this.id = id;
	}

	public void setBikeType( String name ) {
		this.bikeType = name;
	}

	public void setBikeEntities( Set<BikeEntity> bikeEntities ) {
		this.bikeEntities = bikeEntities;
	}

	// Getters

	public int getId() {
		return this.id;
	}

	public String getBikeType() {
		return this.bikeType;
	}

	public Set<BikeEntity> getBikeEntities() {
		return this.bikeEntities;
	}
}



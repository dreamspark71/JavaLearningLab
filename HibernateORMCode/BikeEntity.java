package HibernateORMCode;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.*;

import javax.persistence.Version;



@Entity
// *** NOTE *** THE COMMENT LINE IS DEPRECATED, REPLACED WITH THE LINE UNDERNEARTH AS OF HIBERNATE 5
/*
   Entity in org.hibernate.annotations has been deprecated @org.hibernate.annotations.Entity
*/
//@org.hibernate.annotations.Entity(optimisticLock = OptimisticLockType.ALL)  // DEPRECATED 
@org.hibernate.annotations.DynamicUpdate


// Example of how to declare Optimmistic Locking...
@org.hibernate.annotations.OptimisticLocking( type = OptimisticLockType.VERSION )
// NOTE: Version is the default, could set ALL and this would use the locking on all fields so the Hibernate
// SQL would have all the fields in the Where clause in an update to check nothing has changed.


@Table(name = "bike", uniqueConstraints = {
	@UniqueConstraint( columnNames = "id" )
})
class BikeEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	//@org.hibernate.annotations.OptimisticLock(excluded = true) // Example of where this can be called
	// Whether or not a change of the property will trigger an entity version increment. 
	@Column(name = "name", nullable = false, length = 30)
	private String name;

	@Column(name = "price", nullable = false)
	private float price;


	@Column(name = "description", nullable = false, columnDefinition = "LONGTEXT")
	private String description;


	@Version
	private long version;	// Version field for this object, managed by Hibernate through Optimistic Locking


	// Setters

	public void setId( int id ) {
		this.id = id;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public void setPrice( float price ) {
		this.price = price;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// Getters
	
	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public float getPrice() {
		return this.price;
	}

	public String getDescription() {
		return this.description;
	}

}





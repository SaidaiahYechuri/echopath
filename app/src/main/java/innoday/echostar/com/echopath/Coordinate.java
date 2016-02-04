package innoday.echostar.com.echopath;


/**
 * Class to represent location coordinate
 * 
 * @author Saidaiah Yechuri
 * @since 1.0
 */
public class Coordinate {

	private int id;

	private float longitude;

	private float latitude;

	private Location location;

	/**
	 * Constructor
	 */
	public Coordinate(float longitude, float latitude, Location location) {
		super();
		this.setLongitude(longitude);
		this.latitude = latitude;
		this.location = location;
	}

	/**
	 * Empty Constructor
	 */
	public Coordinate() {
	}

	/**
	 * Get the value of id of this Coordinate
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set value of id
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Get the value of latitude of this Coordinate
	 * 
	 * @return the latitude
	 */
	public float getLatitude() {
		return latitude;
	}

	/**
	 * Set value of latitude
	 * 
	 * @param latitude
	 *            the latitude to set
	 */
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	/**
	 * Get the value of location of this Coordinate
	 * 
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * Set value of location
	 * 
	 * @param location
	 *            the location to set
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * Get the value of longitude of this Coordinate
	 * 
	 * @return the longitude
	 */
	public float getLongitude() {
		return longitude;
	}

	/**
	 * Set value of longitude
	 * 
	 * @param longitude
	 *            the longitude to set
	 */
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	/*
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(latitude);
		result = prime * result + Float.floatToIntBits(longitude);
		return result;
	}

	/*
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (Float.floatToIntBits(latitude) != Float
				.floatToIntBits(other.latitude))
			return false;
		if (Float.floatToIntBits(longitude) != Float
				.floatToIntBits(other.longitude))
			return false;
		return true;
	}

	/*
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Coordinate [longitude=" + longitude + ", latitude=" + latitude
				+ ", location=" + location.getId() + "]";
	}
}

package innoday.echostar.com.echopath;

import java.util.ArrayList;
import java.util.List;

/**
 * /** Data transfer object representing {@link Location}s information.
 * 
 * @author Saidaiah Yechuri
 * @since 1.0
 */
public class LocationsDTO {

	List<Location> locations = new ArrayList<Location>();

	/**
	 * Constructor
	 */
	public LocationsDTO(List<Location> locations) {
		this.locations = locations;
	}

	/**
	 * Constructor
	 */
	public LocationsDTO() {
	}

	/**
	 * Get the value of locations of this LocationsDTO
	 * 
	 * @return the locations
	 */
	public List<Location> getLocations() {
		return locations;
	}

	/**
	 * Set value of locations
	 * 
	 * @param locations
	 *            the locations to set
	 */
	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}
}

package innoday.echostar.com.echopath;

public class LocationsDTO
{
	private Location[] locations;

	public Location[] getLocations ()
	{
		return locations;
	}

	public void setLocations (Location[] locations)
	{
		this.locations = locations;
	}

	@Override
	public String toString()
	{
		return "ClassPojo [locations = "+locations+"]";
	}
}
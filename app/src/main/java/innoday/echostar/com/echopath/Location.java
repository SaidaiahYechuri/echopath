package innoday.echostar.com.echopath;

public class Location

{
	private String id;

	private double minDistance;

	private String created;

	private String name;

	private double longitude;

	private double latitude;

	private String[] cLocations;

	private String modified;

	private ConnectedLocations[] connectedLocations;

	public String getId ()
	{
		return id;
	}

	public void setId (String id)
	{
		this.id = id;
	}

	public double getMinDistance ()
	{
		return minDistance;
	}

	public void setMinDistance (double minDistance)
	{
		this.minDistance = minDistance;
	}

	public String getCreated ()
	{
		return created;
	}

	public void setCreated (String created)
	{
		this.created = created;
	}

	public String getName ()
	{
		return name;
	}

	public void setName (String name)
	{
		this.name = name;
	}

	public double getLongitude ()
	{
		return longitude;
	}

	public void setLongitude (double longitude)
	{
		this.longitude = longitude;
	}

	public double getLatitude ()
	{
		return latitude;
	}

	public void setLatitude (double latitude)
	{
		this.latitude = latitude;
	}

	public String[] getCLocations ()
	{
		return cLocations;
	}

	public void setCLocations (String[] cLocations)
	{
		this.cLocations = cLocations;
	}

	public String getModified ()
	{
		return modified;
	}

	public void setModified (String modified)
	{
		this.modified = modified;
	}

	public ConnectedLocations[] getConnectedLocations ()
	{
		return connectedLocations;
	}

	public void setConnectedLocations (ConnectedLocations[] connectedLocations)
	{
		this.connectedLocations = connectedLocations;
	}

	@Override
	public String toString()
	{
		return name;
	}
}
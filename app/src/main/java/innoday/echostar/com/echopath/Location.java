package innoday.echostar.com.echopath;

public class Location
{
	private String id;

	private String face;

	private String intersection;

	private String minDistance;

	private String created;

	private String name;

	private String longitude;

	private String latitude;

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

	public String getFace ()
{
	return face;
}

	public void setFace (String face)
	{
		this.face = face;
	}

	public String getIntersection ()
	{
		return intersection;
	}

	public void setIntersection (String intersection)
	{
		this.intersection = intersection;
	}

	public String getMinDistance ()
	{
		return minDistance;
	}

	public void setMinDistance (String minDistance)
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

	public String getLongitude ()
	{
		return longitude;
	}

	public void setLongitude (String longitude)
	{
		this.longitude = longitude;
	}

	public String getLatitude ()
	{
		return latitude;
	}

	public void setLatitude (String latitude)
	{
		this.latitude = latitude;
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
	public String  toString()
	{
		return name;
	}
}
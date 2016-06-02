package innoday.echostar.com.echopath;

/**
 * Created by sheshank.kodam on 5/26/2016.
 */
public class ConnectedLocations {
    private String id;

    private String created;

    private Direction direction;

    private String locationId2;

    private String locationId1;

    private String modified;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getCreated ()
    {
        return created;
    }

    public void setCreated (String created)
    {
        this.created = created;
    }

    public Direction getDirection ()
    {
        return direction;
    }

    public void setDirection (Direction direction)
    {
        this.direction = direction;
    }

    public String getLocationId2 ()
    {
        return locationId2;
    }

    public void setLocationId2 (String locationId2)
    {
        this.locationId2 = locationId2;
    }

    public String getLocationId1 ()
    {
        return locationId1;
    }

    public void setLocationId1 (String locationId1)
    {
        this.locationId1 = locationId1;
    }

    public String getModified ()
    {
        return modified;
    }

    public void setModified (String modified)
    {
        this.modified = modified;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", created = "+created+", direction = "+direction+", locationId2 = "+locationId2+", locationId1 = "+locationId1+", modified = "+modified+"]";
    }
}

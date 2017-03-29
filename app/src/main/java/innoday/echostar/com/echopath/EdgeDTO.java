package innoday.echostar.com.echopath;

import android.os.Parcel;
import android.os.Parcelable;

public class EdgeDTO implements Parcelable
{
	public EdgeDTO(double fromLatitude, String to, double distance, String face, double fromLongitude, String from, double toLongitude, double toLatitude, String toFace) {
		super();
		this.fromLatitude = fromLatitude;
		this.to = to;
		this.distance = distance;
		this.face = face;
		this.fromLongitude = fromLongitude;
		this.from = from;
		this.toLongitude = toLongitude;
		this.toLatitude = toLatitude;
		this.toFace = toFace;
	}

	public EdgeDTO(){
		super();
	}


	double fromLatitude;

	private String to;

	private String face;

	private double distance;

	double fromLongitude;

	private String from;

	double toLongitude;

	double toLatitude;

	private String toFace;

	public double getFromLatitude ()
	{
		return fromLatitude;
	}

	public void setFromLatitude (Double fromLatitude)
	{
		this.fromLatitude = fromLatitude;
	}

	public String getTo ()
	{
		return to;
	}

	public void setTo (String to)
	{
		this.to = to;
	}

	public String getFace ()
	{
		return face;
	}

	public void setFace (String face)
	{
		this.face = face;
	}

	public double getDistance ()
	{
		return distance;
	}

	public void setDistance (double distance)
	{
		this.distance = distance;
	}

	public Double getFromLongitude ()
	{
		return fromLongitude;
	}

	public void setFromLongitude (Double fromLongitude)
	{
		this.fromLongitude = fromLongitude;
	}

	public String getFrom ()
	{
		return from;
	}

	public void setFrom (String from)
	{
		this.from = from;
	}

	public Double getToLongitude ()
	{
		return toLongitude;
	}

	public void setToLongitude (Double toLongitude)
	{
		this.toLongitude = toLongitude;
	}

	public Double getToLatitude ()
	{
		return toLatitude;
	}

	public void setToLatitude (Double toLatitude)
	{
		this.toLatitude = toLatitude;
	}

	public String getToFace ()
	{
		return toFace;
	}

	public void setToFace (String toFace)
	{
		this.toFace = toFace;
	}

	public EdgeDTO(Parcel in) {
		fromLatitude = in.readDouble();
		to = in.readString();
		face = in.readString();
		distance = in.readDouble();
		fromLongitude = in.readDouble();
		from = in.readString();
		toLongitude = in.readDouble();
		toLatitude = in.readDouble();
		toFace = in.readString();
	}

	public static final Parcelable.Creator<EdgeDTO> CREATOR = new Parcelable.Creator<EdgeDTO>() {
		public EdgeDTO createFromParcel(Parcel in) {
			return new EdgeDTO(in);
		}

		@Override
		public EdgeDTO[] newArray(int size) {
			return new EdgeDTO[size];
		}
	};
	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeDouble(fromLatitude);
		dest.writeString(to);
		dest.writeString(face);
		dest.writeDouble(distance);
		dest.writeDouble(fromLongitude);
		dest.writeString(from);
		dest.writeDouble(toLongitude);
		dest.writeDouble(toLatitude);
		dest.writeString(toFace);
	}
}
package kont2019;

public class GeoLocation {

	private final double latitude;
	private final double longitude;
	// Da kan man ikke endre lokasjonen til en geolocation etter den er opprettet
	// Objekter som ikke kan endres, kan deles/brukes i flere datastrukturer uten
	// fare for kluss. Hvis delte objekter kan endres, så må en være mer nøye på hva
	// en gjør.

	public GeoLocation(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	/**
	 * Computes distance to other Location
	 * 
	 * @param other
	 * @return distance to other Location
	 */
	public double distance(GeoLocation other) {
		return distance(this.latitude, this.longitude, other.latitude, other.longitude);
	}

	/**
	 * calculates the distance between two points, given the latitude/longitude of
	 * those points).
	 *
	 */
	public static double distance(double lat1, double lon1, double lat2, double lon2) {
		final double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		// convert to degrees
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		// convert to meters
		dist = dist * 1609.344;
		return dist;
	}

	private static double deg2rad(final double deg) {
		return (deg * Math.PI / 180.0);
	}

	private static double rad2deg(final double rad) {
		return (rad * 180 / Math.PI);
	}

}

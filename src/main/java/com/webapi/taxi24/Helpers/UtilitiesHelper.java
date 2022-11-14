package com.webapi.taxi24.Helpers;

/**
 *
 * @author ADISON
 */
public class UtilitiesHelper {

    public static double distanciaCoord(String coordenada1, String coordenada2) {
        //double radioTierra = 3958.75;//en millas 
        double lat1, lng1, lat2, lng2;

        if (coordenada1.isEmpty() || coordenada2.isEmpty() || coordenada1.equals(coordenada2)) {
            return 0;
        }
        String[] coord = coordenada1.split(",");
        lat1 = Double.parseDouble(coord[0]);
        lng1 = Double.parseDouble(coord[1]);
        coord = coordenada2.split(",");
        lat2 = Double.parseDouble(coord[0]);
        lng2 = Double.parseDouble(coord[1]);
        double theta = lng1 - lng2;
        double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
        dist = Math.acos(dist);
        dist = Math.toDegrees(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1.609344; // Return in KM

        return dist;

    }

    public static CoordenadasHelper ObtenerCoordenada(String coordenada) {
        CoordenadasHelper coord = null;

        if (coordenada.isEmpty()) {
            return coord;
        }

        String[] coordDiv = coordenada.replace(" ", "").split(",");
        coord.Latitud = Double.parseDouble(coordDiv[0]);
        coord.Longitud = Double.parseDouble(coordDiv[1]);

        return coord;
    }
}

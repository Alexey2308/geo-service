package ru.netology.geo;

import ru.netology.entity.Country;
import ru.netology.entity.Location;

public interface GeoService {

    Location byIp(String ip);

    Location byCoordinates(double latitude, double longitude);


}

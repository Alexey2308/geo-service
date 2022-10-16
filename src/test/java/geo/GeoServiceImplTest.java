package geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

import static ru.netology.entity.Country.RUSSIA;
import static ru.netology.entity.Country.USA;

class GeoServiceImplTest {

    @Mock
    private Location location;

    @Test
    void TestlocationRus() {
        String ip = "172.12.14.1";
        location = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp(ip)).thenReturn(location);
        Country assertCountry = location.getCountry();

        Assertions.assertSame(assertCountry, RUSSIA);
    }

    @Test
    void TestlocationUsa() {
        String ip = "96.15.14.1";
        location = new Location("New York", Country.USA, " 10th Avenue", 32);
        GeoServiceImpl geoservice = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoservice.byIp(ip)).thenReturn(location);
        Country assertCountry = location.getCountry();

        Assertions.assertSame(assertCountry, USA);
    }

}
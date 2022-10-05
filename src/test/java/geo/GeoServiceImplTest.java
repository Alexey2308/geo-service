package geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;


class GeoServiceImplTest {
    @Mock
    private Location geoService;


    @Test
    void TestlocationRus() {
        String ip = "172.12.14.1";
        geoService = new GeoServiceImpl().byIp(ip);
        Assertions.assertSame(geoService.getCountry(), Country.RUSSIA);
    }

    @Test
    void TestlocationUsa() {
        String ip = "96.14.12.1";
        geoService = new GeoServiceImpl().byIp(ip);
        Assertions.assertSame(geoService.getCountry(), Country.USA);
    }

    @Test
    void TestlocationRuss() {
        String ip = "172.";
        geoService = new GeoServiceImpl().byIp(ip);
        Assertions.assertSame(geoService.getCountry(), Country.RUSSIA);
    }

    @Test
    void TestlocUsa() {
        String ip = "96.";
        geoService = new GeoServiceImpl().byIp(ip);
        Assertions.assertSame(geoService.getCountry(), Country.USA);


    }
}
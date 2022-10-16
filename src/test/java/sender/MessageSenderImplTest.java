package sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSenderImpl;

import java.util.Map;


class MessageSenderImplTest {
    GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
    LocalizationService localizationService = Mockito.mock(LocalizationServiceImpl.class);

    Location location = Mockito.mock(Location.class);


    @Test
    void sendRus() {
        String rusIp = "172.16.12.4";
        Map<String, String> adress = Map.of("x-real-ip", "172.16.12.4");
        location = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        Mockito.when(geoService.byIp(rusIp)).thenReturn(location);
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");
        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        String assertion = messageSender.send(adress);
        String actual = "Добро пожаловать";
        Assertions.assertEquals(assertion, actual);

    }

    @Test
    void sendEng() {
        String engIp = "96.15.14.1";
        Map<String, String> adress = Map.of("x-real-ip", "96.15.14.1");
        location = new Location("New York", Country.USA, " 10th Avenue", 32);
        Mockito.when(geoService.byIp(engIp)).thenReturn(location);
        Mockito.when(localizationService.locale(Country.USA)).thenReturn("Welcome");
        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        String assertion = messageSender.send(adress);
        String actual = "Welcome";
        Assertions.assertEquals(assertion, actual);

    }

}

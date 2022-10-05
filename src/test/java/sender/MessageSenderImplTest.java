package sender;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

class MessageSenderImplTest {

    @Mock
    private GeoServiceImpl geoService;

    @Mock
    private LocalizationService localizationService;

    @BeforeEach
    void setUp() {
        geoService = new GeoServiceImpl();
        localizationService = new LocalizationServiceImpl();

    }

    @Test
    void sendUsa() {
        String ipAddress = String.valueOf("96.45.35.12");
        if (ipAddress != null && !ipAddress.isEmpty()) {
            Location location = geoService.byIp(ipAddress);
            System.out.printf("Отправлено сообщение:  %s", localizationService.locale(location.getCountry()));
        }
    }

    @Test
    void sendRus() {
        String ipAddress = String.valueOf("172.31.20.1");
        if (ipAddress != null && !ipAddress.isEmpty()) {
            Location location = geoService.byIp(ipAddress);
            System.out.printf("Отправлено сообщение: %s", localizationService.locale(location.getCountry()));

        }

    }
}
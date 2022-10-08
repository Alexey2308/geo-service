package i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;


class LocalizationServiceImplTest {

    @Mock
    private LocalizationServiceImpl localizationService;

    @BeforeEach
    void setUp() {
        localizationService = new LocalizationServiceImpl();
    }

    @Test
    void localeRus() {
        String expected = localizationService.locale(Country.RUSSIA);
        String actual = "Добро пожаловать";
        Assertions.assertEquals(expected, actual);

    }

    @Test
    void localeEng() {
        String expected = localizationService.locale(Country.USA);
        String actual = "Welcome";
        Assertions.assertEquals(expected, actual);

    }
}
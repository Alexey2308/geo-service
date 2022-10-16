package i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;


class LocalizationServiceImplTest {

    @Test
    void localeRus() {

        LocalizationServiceImpl localizationService = Mockito.spy(LocalizationServiceImpl.class);
        String expected = localizationService.locale(Country.RUSSIA);
        String actual = "Добро пожаловать";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void localeEng() {

        LocalizationServiceImpl localizationService = Mockito.spy(LocalizationServiceImpl.class);
        String expected = localizationService.locale(Country.USA);
        String actual = "Welcome";
        Assertions.assertEquals(expected, actual);
    }
}
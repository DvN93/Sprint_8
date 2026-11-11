import org.example.Account;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @ParameterizedTest
    @DisplayName("Проверка что метод принимает корректные значения")
    @ValueSource(strings = {"Тимофей Шаламеев", "Иван Петров", "И Б", "Александр Васильчук"})
    public void checkNameToEmbossSuccessfully(String name) {
        Account account = new Account(name);
        boolean result = account.checkNameToEmboss();
        assertTrue(result);
    }

    @ParameterizedTest
    @DisplayName("Проверка что метод обрабатывает некорректные значения верно")
    @ValueSource(strings = {" Тимофей Шаламеев", "Иван ", " Иван", "Иван  Иванов", "ИТ", "И", "Константин Григорьев", "ТимотейШевроле", ""})
    public void checkNameToEmbossReturnFalse(String name) {
        Account account = new Account(name);
        boolean result = account.checkNameToEmboss();
        assertFalse(result);
    }

    @Test
    @DisplayName("Метод выбрасывает исключение в случае передачи null")
    public void checkNameToEmbossNullNameThrowsException() {
        Account account = new Account(null);
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> account.checkNameToEmboss()
        );
        assertEquals("Имя не может быть null", e.getMessage());
    }
}

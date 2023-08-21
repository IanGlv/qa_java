import com.example.Feline;
import com.example.Lion;
import java.util.List;
import org.junit.Test;
import org.junit.Rule;
import org.mockito.Mock;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.junit.rules.ExpectedException;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    private static final String validGender = "Самец";
    private static final String invalidGender = "invalidGender";
    private static final String exceptionMessage = "Используйте допустимые значения пола животного - самец или самка";
    @Mock
    private Feline feline;
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void getKittens() throws Exception {
        Lion lion = new Lion(validGender, feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actual = lion.getKittens();
        int expected = 1;

        assertEquals(expected, actual);
    }

    @Test
    public void doesHaveMane() throws Exception {
        Lion lion = new Lion(validGender, feline);
        boolean actual = lion.doesHaveMane();

        assertTrue(actual);
    }

    @Test
    public void getFood() throws Exception {
        Lion lion = new Lion(validGender, feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = lion.getFood();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");

        assertEquals(expected, actual);
    }

    @Test
    public void checkExceptionByCreateLion() throws Exception {
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage(exceptionMessage);
        Lion lion = new Lion(invalidGender, feline);
    }
}

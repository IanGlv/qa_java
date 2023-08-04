import org.junit.Assert;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)

public class FelineTest {

    @Spy
    Feline feline;

    @Test
    // тест, проверяет вызов метода getKittens() с аргументом 100
    public void checkCountKittens () {
        feline.getKittens(100);
        Mockito.verify(feline).getKittens(100);
    }

    @Test
    // тест, проверяет вызов метода getFamily() с аргументом Кошачьи
    public void checkFamilyName () {
        String FamilyName = "Кошачьи";
        Assert.assertEquals(FamilyName, feline.getFamily());

    }

    @Test
    // тест, проверяет вызов сколько раз вызвали метод getKittens()
    public void checkGetKittens () {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }


}
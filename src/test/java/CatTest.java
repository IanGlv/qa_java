import org.junit.Assert;
import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)

public class CatTest {

    @Spy
    Feline feline;

    @Test
    // тест, проверяет что Кот мяукает
    public void checkCatSound () {
        Cat cat = new Cat(feline);
        Cat catSpy = Mockito.spy(cat);
        String Sound = "Мяу";
        Assert.assertEquals(Sound, catSpy.getSound());
    }

    @Test
    // тест, проверяет что при вызове getFood() вызывается eatMeat()
    public void checkCatGetFood () throws Exception {
        Cat cat = new Cat(feline);
        Cat catSpy = Mockito.spy(cat);
        catSpy.getFood();
        Mockito.verify(feline).eatMeat();
    }


}

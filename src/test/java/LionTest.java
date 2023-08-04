import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)

public class LionTest {
    private final String Sex;
    private final boolean mane;

    public LionTest (
            String Sex,
            boolean mane
    )

    {
        this.Sex = Sex;
        this.mane = mane;
    }

    @Parameterized.Parameters
    public static Object[][] enterData() {
        return new Object[][] {
                { "Самец", true},
                { "Самка", false},
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Spy
    Feline feline;

    // добавил параметризацию в тестах:
    @Test
    // тест, проверяет пол
    public void checkSex () throws Exception {
        Lion lion = new Lion(Sex, feline);
        Lion lionSpy = Mockito.spy(lion);
        Assert.assertEquals(mane, lionSpy.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void checkOtherSex () throws Exception {
        Lion lion = new Lion("Оно", feline);
        Lion lionSpy = Mockito.spy(lion);
        lionSpy.doesHaveMane();
    }

    @Test
    // тест, проверяет вызов сколько раз вызвали метод getKittens()
    public void checkLionGetKitten () throws Exception {
        Lion lion = new Lion(Sex, feline);
        Lion lionSpy = Mockito.spy(lion);
        lionSpy.getKittens();
        Mockito.verify(lionSpy, Mockito.times(1)).getKittens();
    }

    @Test
    // тест, проверяет что при вызове getFood() вызывается eatMeat()
    public void checkLionGetFood () throws Exception {
        Lion lion = new Lion(Sex, feline);
        Lion lionSpy = Mockito.spy(lion);
        lionSpy.getFood();
        Mockito.verify(feline).getFood("Хищник");
    }
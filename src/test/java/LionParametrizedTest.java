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

public class LionParametrizedTest {
    private final String sex;
    private final boolean mane;

    public LionParametrizedTest(
            String sex,
            boolean mane
    ) {
        this.sex = sex;
        this.mane = mane;
    }

    @Parameterized.Parameters
    public static Object[][] enterData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Spy
    Feline feline;

    @Test
    // тест, проверяет пол
    public void checkSex() throws Exception {
        Lion lion = new Lion(sex, feline);
        Lion lionSpy = Mockito.spy(lion);
        Assert.assertEquals(mane, lionSpy.doesHaveMane());
    }


}


import com.example.Cat;
import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Test;
import org.hamcrest.MatcherAssert;

import java.util.List;

@RunWith(Parameterized.class)
public class LionParameterizedTest {
    private final String sex;
    private final boolean expectedResult;

    public LionParameterizedTest(String sex, boolean expectedResult) {
        this.sex = sex;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Object [][] getCorrectHasManeValue() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }
    @Test
    public void hasManeTest() throws Exception {
        Lion lion = new Lion(sex, new Feline());
        boolean actualResult = lion.doesHaveMane();
        Assert.assertEquals("Lion has mane", expectedResult, actualResult);
    }

    @Test
    public void foodTest() throws Exception {
        Lion lion = new Lion(sex, new Feline());
        List<String> actualResult = lion.getFood();
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals("Lion eats ", expectedResult, actualResult);
    }

    @Test
    public void kittenTest() throws Exception {
        Lion lion = new Lion(sex, new Feline());
        int actualResult = lion.getKittens();
        int expectedResult = 1;
        Assert.assertEquals("Есть 1 львенок", expectedResult, actualResult);
    }
}


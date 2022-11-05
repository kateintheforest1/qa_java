import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void soundTest() {
        Cat cat = new Cat(new Feline());
        String actualResult = cat.getSound();
        String expectedResult = "Мяу";
        Assert.assertEquals("Cat says Мяу", expectedResult, actualResult);
    }

    @Test
    public void foodTest() throws Exception {
        Cat cat = new Cat(new Feline());
        List<String> actualResult = cat.getFood();
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals("Cat eats ", expectedResult, actualResult);
    }
}

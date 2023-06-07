import ru.daniil.framework.After;
import ru.daniil.framework.Before;
import ru.daniil.framework.Test;

import static ru.daniil.framework.Assertions.assertEquals;

public class TestClass {
    private int a;
    private int b;


    @Before
    public void before() {
        a = 10;
        b = 5;
    }

    @After
    public void after(){
        a = 0;
        b = 0;
    }

    @Test
    public void testSum(){
        int x = a + b;
        assertEquals(15, x);
    }

    @Test
    public void testDifference(){
        int x = a - b;
        assertEquals(5, x);
    }

    @Test
    public void testError(){
        throw new RuntimeException("An error has occurred");
    }
}

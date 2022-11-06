import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class AreaOfTriangleTest {
    private AreaOfTriangle areaOfTriangle;

    @Before
    public void setUp() {
        areaOfTriangle = new AreaOfTriangle();
        System.out.println("Before");
    }

    @After
    public void tearDown() {
        areaOfTriangle = null;
        System.out.println("After");
    }

    @Test
    public void testAreaOfTriangle1() {
        double result = areaOfTriangle.AreaOfTriangle(3, 4, 5);
        assertEquals(6, result, 0.001);
    }
    @Test
    public void testAreaOfTriangle2() {
        double result = areaOfTriangle.AreaOfTriangle(1, 1, 1);
        assertEquals(0.4330127018922193, result, 0.001);
    }

    @Test
    public void testAreaOfTriangle3() {
        double result = areaOfTriangle.AreaOfTriangle(Double.MAX_VALUE +3 , Double.MAX_VALUE +4, Double.MAX_VALUE +5);
        assertEquals(Double.POSITIVE_INFINITY, result, 0.001);
    }

    @Test
    public void testAreaOfTriangle4() {
        double result = areaOfTriangle.AreaOfTriangle(1, 2, 3);
        assertEquals(0, result, 0.001);
    }

    @Test
    public void testAreaOfTriangle5() {
        double result = areaOfTriangle.AreaOfTriangle(6, 9, 3);
        assertEquals(0, result, 0.001);
    }

    @Test
    public void testAreaOfTriangle6() {
        double result = areaOfTriangle.AreaOfTriangle(10, 7, 3);
        assertEquals(0, result, 0.001);
    }

    @Test
    public void testAreaOfTriangle7() {
        assertThrows(IllegalArgumentException.class, () -> areaOfTriangle.AreaOfTriangle(0, 4, 5));
    }

    @Test
    public void testAreaOfTriangle8() {
        assertThrows(IllegalArgumentException.class, () -> areaOfTriangle.AreaOfTriangle(4, -1, 5));
    }

    @Test
    public void testAreaOfTriangle9() {
        assertThrows(IllegalArgumentException.class, () -> areaOfTriangle.AreaOfTriangle(4, 5, -5));
    }

}

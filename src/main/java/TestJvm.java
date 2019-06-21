import static org.junit.Assert.*;

import org.junit.Test;
import reference.weak.Apple;
import reference.weak.Salad;

/**
 * created by Jay on 2019/6/21
 */
public class TestJvm
{
    @Test
    public void testWeakReference()
    {
        String saladName = "super salad";
        Salad salad = new Salad(new Apple("红富士"), saladName);
        //通过WeakReference的get()方法获取Apple
        System.out.println("Apple:" + salad.get());
        //执行GC
        System.gc();
        //如果为空，代表被回收了
        assertNull(salad.get());
        // saladName未被回收
        assertEquals(saladName, salad.getValue());
    }
}

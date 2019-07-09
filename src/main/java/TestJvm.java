import org.junit.Test;
import org.springframework.context.ApplicationContext;
import reference.weak.Apple;
import reference.weak.Salad;

import java.util.WeakHashMap;

import static org.junit.Assert.*;

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

    @Test
public void testWeakHashMap() throws Exception
{
    WeakHashMap<Object, String> map = new WeakHashMap();
    Object o = new Object();
    String value = new String("aa");
    map.put(o, value);
    assertFalse(map.isEmpty());
    o = null;
    System.gc();
    assertTrue(map.isEmpty()); ////测试结果有时正常，有时异常
}

    @Test
    public void testWeakHashMap01() throws Exception
    {
        WeakHashMap<String, String> map = new WeakHashMap<String, String>();
        for (int i = 0; i < 5; i++)
        {
            map.put(new String("字符串" + i), new String("串串" + i));
        }
        assertEquals(map.size(),    5);
        System.gc();
        assertEquals(map.size(), 0); //测试结果有时正常，有时异常
    }

    public static void main(String[] args)
    {
        WeakHashMap<Object, String> map = new WeakHashMap();
        Object o = new Object();
        String value = new String("aa");
        map.put(o, value);
        assertFalse(map.isEmpty());
        o = null;
        map.size();
        System.gc();
        assertTrue(map.isEmpty()); //测试结果有时正常，有时异常
    }
}

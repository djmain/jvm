
import com.sun.crypto.provider.AESKeyGenerator;
import org.junit.Test;
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
        assertEquals(map.size(), 5);
        System.gc();
        assertEquals(map.size(), 0); //测试结果有时正常，有时异常
    }

    public static void main(String[] args)
    {
//        WeakHashMap<Object, String> map = new WeakHashMap();
//        Object o = new Object();
//        String value = new String("aa");
//        map.put(o, value);
//        assertFalse(map.isEmpty());
//        o = null;
//        map.size();
//        System.gc();
//        assertTrue(map.isEmpty()); //测试结果有时正常，有时异常
        System.out.println("first");
        new TestJvm();
        System.out.println("second");
        new TestJvm();
        System.out.println("end");
    }


    /**
     * 类加载测试
     * sun.misc.Launcher$ExtClassLoader@38af3868
     * sun.misc.Launcher$AppClassLoader@18b4aac2
     * sun.misc.Launcher$ExtClassLoader@38af3868
     */
    @Test
    public void testClassLoader()
    {
//        /**
//         * Bootstrap ClassLoader
//         */
//        ClassLoader classLoader = Object.class.getClassLoader();
//        assertNull(classLoader);
//        /**
//         * Extension ClassLoader，由sun.misc.Launcher$ExtClassLoader实现
//         * ExtClassLoader加载ext/*下面的class, 如sun*.jar（例如:sunjce_provider.jar）
//         */
//        classLoader = AESKeyGenerator.class.getClassLoader();
//        System.out.println(classLoader);
//
//        //Extension ClassLoader的parent是Bootstrap ClassLoader
//        classLoader = AESKeyGenerator.class.getClassLoader().getParent();
//        assertNull(classLoader);
//
//
//        //Application ClassLoader, 由sun.misc.Launcher$AppClassLoader实现
//        classLoader = TestJvm.class.getClassLoader();
//        System.out.println(classLoader);
//
//        //Application ClassLoader的parent是Extension ClassLoader
//        classLoader = TestJvm.class.getClassLoader().getParent();
//        System.out.println(classLoader);
    }


    static
    {
        System.out.println("static block");
    }

    {
        System.out.println("normal block");
    }

    public TestJvm()
    {
        System.out.println("creating a new instance of TestJVM");
    }


    @Test
    public void testClassInit()
    {
        /**
         * 测试之前，已经生成了一个实例
         */
        System.out.println("first");
        new TestJvm();
        System.out.println("second");
        new TestJvm();
    }
}

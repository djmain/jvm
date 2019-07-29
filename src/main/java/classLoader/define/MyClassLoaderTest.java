package classLoader.define;

import java.io.IOException;
import java.io.InputStream;

/**
 * created by Jay on 2019/7/12
 */
public class MyClassLoaderTest
{
    public static void main(String[] args) throws Exception
    {
        ClassLoader myClassLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException
            {
//                try
//                {
                    return super.loadClass(name);
//                    String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
//                    InputStream in = getClass().getResourceAsStream(fileName);
//                    if(in == null)
//                    {
//                        return super.loadClass(name);
//                    }
//                    byte[] bytes = new byte[in.available()];
//                    in.read(bytes);
//                    return defineClass(name, bytes, 0, bytes.length);
//                }
//                catch (IOException e)
//                {
//                    throw new  ClassNotFoundException(name);
//                }
            }
        };
        Object myClassLoaderTest =myClassLoader.loadClass("classLoader.define.MyClassLoaderTest").newInstance();
        Object myClassLoaderTest1 =myClassLoader.loadClass("classLoader.define.MyClassLoaderTest").newInstance();
        System.out.println(myClassLoaderTest.getClass().getClassLoader());
        System.out.println(myClassLoaderTest instanceof  MyClassLoaderTest);
        System.out.println(myClassLoader);
    }
    
}

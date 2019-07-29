package classLoader.init;

import java.io.File;
import java.io.OutputStreamWriter;

/**
 * created by Jay on 2019/7/9
 */
public class Son extends Father
{
    static
    {
        System.out.println("son static block");
    }

    {
        System.out.println("son normal block");
    }

    public Son()
    {
        System.out.println("creating a son instance");
    }
}

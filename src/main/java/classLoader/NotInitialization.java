package classLoader;

import classLoader.array.Person;

import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;

/**
 * created by Jay on 2019/7/25
 * 通过数组定义来引用类，不会触发类的初始化
 */
public class NotInitialization
{
    public static void main(String[] args)
    {
        //不会触发类的初始化
        Person[] personArray = new Person[1];
        // 会触发类的初始化
        // Person person = new Person();
    }
}

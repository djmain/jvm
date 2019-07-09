package classLoader.init;

/**
 * created by Jay on 2019/7/9
 */
public class Father
{
    static
    {
        System.out.println("Father static block");
    }

    {
        System.out.println("Father normal block.");
    }

    public Father()
    {
        System.out.println("Creating a new father instance.");
    }
}

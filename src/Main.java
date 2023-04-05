import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {
        Second varSecond = new Second();
        Fourth varThird = new Fourth();
        varSecond.whoRules();
        varThird.whoRules();

    }

}
class First
{
    public static String name()
    {
        return "First";
    }
}
class Second extends First
{
    public void whoRules()
    {
        try {
            System.out.print(getClass().getSuperclass().getMethod("name").invoke(null) + " rules");
            System.out.println(" but "+ getClass().getMethod("name").invoke(null) + " is even better");
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
    public static String name()
    {
        return "Second";
    }
}
class Third extends Second
{
    public static String name()
    {
        return "Third";
    }
}

class Fourth extends Third {

    public static String name()
    {
        return "Fourth";
    }
}

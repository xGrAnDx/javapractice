public class Main {
    public static void main(String[] args)
    {
        String string = "string";
        int integer = 1;
        short st = 32767;
        long lng = 1337;
        float ft = 1.98f;
        double db = 1.97;
        boolean bool = false;
        char ch = 'a';
        byte binary = 127;


        System.out.println(CalcEquation(3, 3, 4, 2));

        System.out.println(CompareSum(12,8));

        CheckIfPositive(10);

        CheckIfPositive(-10);

        System.out.println(CheckIfNegative(10));

        System.out.println(CheckIfNegative(-10));

        GreetPerson("указанное_имя");

        System.out.println("1900 is Leap:" + CheckIfLearYear(1900));
        System.out.println("1904 is Leap:" + CheckIfLearYear(1904));
        System.out.println("2000 is Leap:" + CheckIfLearYear(2000));

    }

    public static int CalcEquation(int p1, int p2, int p3, int p4)
    {
        return p1 * (p2 + p3 / p4);
    }

    public static boolean CompareSum(int p1, int p2)
    {
        var sum = p1 + p2;
        return sum >= 10 && sum <= 20;
    }

    public static boolean CheckIfNegative(int in)
    {
        return in < 0;
    }

    public static void CheckIfPositive(int in)
    {
        var res = in >= 0 ? "Positive" : "Negative";

        System.out.println(res);
    }

    public static void GreetPerson(String personName)
    {
        var res = String.format("Привет, %s!", personName);
        System.out.println(res);
    }

    public static boolean CheckIfLearYear(int yearNum)
    {
        if (yearNum % 400 == 0)
            return true;
        if (yearNum % 100 != 0 && yearNum % 4 == 0)
            return true;
        return false;
    }
}

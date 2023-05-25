package ru.grand.lesson4;

import java.text.NumberFormat;
import java.util.Locale;
public class Lesson4 {
    public static void main(String[] args) {

        // Task 1: Alphanumeric
        System.out.format("Is [%s] Alphanumeric: [%s]\n", "abc_def", RegexpWrapper.isAlphaNumeric("abc_def"));
        System.out.format("Is [%s] Alphanumeric: [%s]\n", "abc$_def", RegexpWrapper.isAlphaNumeric("abc$_def"));
        System.out.format("Is [%s] Alphanumeric: [%s]\n", "$abc_def", RegexpWrapper.isAlphaNumeric("$abc_def"));
        System.out.format("Is [%s] Alphanumeric: [%s]\n", "abc_def%", RegexpWrapper.isAlphaNumeric("$abc_def%"));
        System.out.format("Is [%s] Alphanumeric: [%s]\n", "", RegexpWrapper.isAlphaNumeric(""));

        // Task 2: Underscore check
        System.out.format("Is [%s] underscored: [%s]\n", "java_exercises", RegexpWrapper.hasUnderscore("java_exercises"));
        System.out.format("Is [%s] underscored: [%s]\n", "privet_", RegexpWrapper.hasUnderscore("privet_"));
        System.out.format("Is [%s] underscored: [%s]\n", "test", RegexpWrapper.hasUnderscore("test"));
        System.out.format("Is [%s] underscored: [%s]\n", "_", RegexpWrapper.hasUnderscore("_"));
        System.out.format("Is [%s] underscored: [%s]\n", "", RegexpWrapper.hasUnderscore(""));
        System.out.format("Is [%s] underscored: [%s]\n", "Privet_drug", RegexpWrapper.hasUnderscore("Privet_drug"));

        // Task 3: Search for special g-letter

        // Task 4: Tag extractor

        String content = "<p>Hello <code>Everybody</code> nice to meet u " +
                "Hope to see u soon.</p>";
        RegexpWrapper.extractTags(content);

        // Task 5: Mail checker
        System.out.format("Is [%s] a valid mail: [%s]\n", "zlaya@gmail.com", RegexpWrapper.isMailAddress("zlaya@gmail.com"));
        System.out.format("Is [%s] a valid mail: [%s]\n", "-@gmail.com", RegexpWrapper.isMailAddress("-@gmail.com"));
        System.out.format("Is [%s] a valid mail: [%s]\n", "zlaya@gmail.coma", RegexpWrapper.isMailAddress("zlaya@gmail.coma"));
        System.out.format("Is [%s] a valid mail: [%s]\n", "zlaya@gma#il.com", RegexpWrapper.isMailAddress("zlaya@gma#il.com"));
        System.out.format("Is [%s] a valid mail: [%s]\n", "@gmail.com", RegexpWrapper.isMailAddress("@gmail.com"));
        System.out.format("Is [%s] a valid mail: [%s]\n", "zlaya@.com", RegexpWrapper.isMailAddress("zlaya@.com"));
        System.out.format("Is [%s] a valid mail: [%s]\n", "zl[a]ya@.com", RegexpWrapper.isMailAddress("zl[a]ya@gmail.com"));
        System.out.format("Is [%s] a valid mail: [%s]\n", "zla-ya@gmail.com", RegexpWrapper.isMailAddress("zla-ya@gmail.com"));
        System.out.format("Is [%s] a valid mail: [%s]\n", "zla.ya@gmail.com", RegexpWrapper.isMailAddress("zla.ya@gmail.com"));
        System.out.format("Is [%s] a valid mail: [%s]\n", "zla.ya@gmail_.com", RegexpWrapper.isMailAddress("zla.ya@gmail_.com"));

        // Task 6: Currency formatter
        double money = 1234567.89;
        NumberFormat usFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat ruFormatter = NumberFormat.getCurrencyInstance();
        System.out.println(usFormatter.format(money));
        System.out.println(ruFormatter.format(money));

        //Task 7: Inner class demo

        var user = new User("u1", "Pass");
        user.createQuery();

        var q = new User("u2", "newPass").new Query();
        q.printToLog();

        // Task 8: Local class demo
        var u3 = new LocalUser("u3", "newPass3");
        u3.createQuery();

        // Task 9: Nested static class demo

        var u4 = new StaticUser("u4", "newPass4");
        u4.createQuery();

        // Task 10: Anonymous class demo

        var printableExt = new Printable()
        {
            @Override
            public void print(String s)
            {
                System.out.format("Anonymous demo Print call: [%s].\n", s);
            }
        };

        printableExt.print("TestString");

        // Task 11: Anonymous class demo 2

        var microWave = new Cookable()
        {
            public void cook(String s)
            {
                System.out.format("Hey! It's microwave, i'm cooking %s \n", s);
            }
        };

        var food = new Food();
        food.prepare(microWave, "Meat");
    }
}

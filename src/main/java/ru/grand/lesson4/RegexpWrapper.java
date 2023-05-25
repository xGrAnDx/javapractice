package ru.grand.lesson4;

import java.util.regex.Pattern;

public class RegexpWrapper {
    private static Pattern alphaNumeric;
    private static Pattern underscore;

    private static Pattern gLetter;

    private static Pattern tagExtractor;

    private static Pattern mailChecker;
    static
    {
        alphaNumeric = Pattern.compile("^[\\w]+$", Pattern.CASE_INSENSITIVE);
        underscore = Pattern.compile("^[a-z]+_[a-z]+$");
        gLetter = Pattern.compile("\\Bg\\B");
        tagExtractor = Pattern.compile("<[/]*[a-z]+>");
        mailChecker = Pattern.compile("^[\\w]+([.-]*[\\w]+)*@([A-Za-z0-9-])+\\.([A-Za-z0-9]{2,3})+$");
    }

    public static boolean isAlphaNumeric(String s)
    {
        var matcher = alphaNumeric.matcher(s);

        return matcher.find();
    }

    public static boolean hasUnderscore(String s)
    {
        var matcher = underscore.matcher(s);

        return matcher.find();
    }

    public static boolean hasSpecialG(String s)
    {
        var matcher = gLetter.matcher(s);

        return matcher.find();
    }
    public static void extractTags(String s) {
        var matcher = tagExtractor.matcher(s);

        System.out.println("Found tags:");
        while(matcher.find())
        {
            System.out.println(matcher.group());
        }
    }

    public static boolean isMailAddress(String s)
    {
        var matcher = mailChecker.matcher(s);

        return matcher.find();
    }


}

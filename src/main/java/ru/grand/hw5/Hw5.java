package ru.grand.hw5;

public class Hw5 {
    public static void main(String[] args)
    {
        /*task 1*/
        var tmp1 = new JdkClass(2);
        var tmp2 = new JdkClass(2);
        var tmp3 = new JdkClass(3);

        var lmb1 = new LombokClass(3);
        var lmb2 = new LombokClass(3);
        var lmb3 = new LombokClass(4);

        System.out.println(String.format("tmp1 = tmp2 ?: [%s]", tmp1.equals(tmp2)));
        System.out.println(String.format("tmp1 = tmp3 ?: [%s]", tmp1.equals(tmp3)));

        System.out.println(String.format("lmb1 = lmb2 ?: [%s]", lmb1.equals(lmb2)));
        System.out.println(String.format("lmb1 = lmb3 ?: [%s]", lmb1.equals(lmb3)));

        /*task 2*/
        var child = new Child();

        /*task 3*/

        var morpher = new StringMorpher(6);
        System.out.println(morpher.applyMask(0));
        System.out.println(morpher.applyMask(1));
        System.out.println(morpher.applyMask(12));
        System.out.println(morpher.applyMask(123));
        System.out.println(morpher.applyMask(1234));
        System.out.println(morpher.applyMask(1234567));
    }
}

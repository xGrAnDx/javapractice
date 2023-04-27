package ru.grand.HW2;
import java.util.Arrays;

public class HW2 {
    public static void main(String[] args) {
        InvertArray();
        FillArray();
        MorphArray();
        FillMatrix();
        FindMinMax();
        byte[] balanceArray = {2, 2, 2, 1, 2, 2, 10, 1};
        CheckBalance(balanceArray);
        byte[] shiftArray = {1,2,3,4,5,6,7,8,9,0};
        ShiftArray(shiftArray, 3);
        ShiftArray(shiftArray, -2);
        ShiftArray(shiftArray, 0);
        ShiftArray(shiftArray, -51);
    }

    public static void InvertArray() {
        byte[] bArray = {0, 1, 0, 0, 1, 0, 1};
        System.out.println("Original:" + Arrays.toString(bArray));
        for (int i = 0; i < bArray.length; i++) {
            bArray[i] = (byte) ((bArray[i] + 1) % 2);
        }

        System.out.println("Inverted:" + Arrays.toString(bArray));
    }

    public static void FillArray() {
        byte[] bArray = new byte[8];

        for (byte i = 0; i < 8; i++) {
            bArray[i] = (byte) (i * 3);
        }

        System.out.println("Filled array:" + Arrays.toString(bArray));
    }

    public static void MorphArray() {
        byte[] bArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (byte i = 0; i < bArray.length; i++) {
            if (bArray[i] < 6) {
                bArray[i] *= 2;
            }
        }

        System.out.println("Morphed array:" + Arrays.toString(bArray));
    }

    public static void FillMatrix() {
        byte length = (byte) 5;
        byte[][] bArray = new byte[length][length];

        for (int i = 0; i < length; i++) {
            bArray[i][i] = (byte) 1;
            bArray[i][length - i - 1] = (byte) 1;
        }

        System.out.println("Matrix array:");
        for (int i = 0; i < length; i++) {
            System.out.println(Arrays.toString(bArray[i]));
        }
    }

    public static void FindMinMax() {
        byte[] bArray = {6, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        var min = bArray[0];
        var max = bArray[0];

        for (int i = 1; i < bArray.length; i++) {
            if (bArray[i] < min) {
                min = bArray[i];
                continue;
            }

            if (bArray[i] > max) {
                max = bArray[i];
            }
        }

        System.out.println(String.format("Target array: %s. Min:[%s]. Max:[%s]", Arrays.toString(bArray), min, max));
    }

    public static void CheckBalance(byte[] bArray)
    {
        var left = 0;
        var right = 0;

        for(int i=0; i<bArray.length; i++)
        {
            right+= bArray[i];
        }

        System.out.println("Balance array:" + Arrays.toString(bArray));
        for(int i=0; i<bArray.length - 1; i++)
        {
            left += bArray[i];
            right -= bArray[i];

            if (left == right)
            {
                System.out.println("True");
                return;
            }
        }

        System.out.println("False");
    }

    public static void ShiftArray(byte[] bArray, int step)
    {
        var l = bArray.length;
        var shift = Math.floorMod(step, l);

        byte[] dest = new byte[bArray.length];

        System.arraycopy(bArray, l - shift, dest, 0, shift);
        System.arraycopy(bArray, 0, dest, shift, l - shift);

        System.out.println("PreShift array:" + Arrays.toString(bArray));
        System.out.println("PostShift array:" + Arrays.toString(dest));
    }
}

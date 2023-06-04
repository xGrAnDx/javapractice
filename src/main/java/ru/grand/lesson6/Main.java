package ru.grand.lesson6;

import java.io.*;

public class Main {
    private static final int matrixSize = 4;

    private static final String original = "out.txt";
    private static final String copyTo = "copyTo.txt";
    private static final String picOriginal = "original.png";
    private static final String picCopy = "copy.png";
    public static void main(String[] args) {
        // Task 1

        CopyDemo();

        // Task 2:

        var printer = new DirectoryPrinter(".");
        printer.printFolders();
        printer.printFoldersStream();

        // Task 3-5
        MatrixDemo();

    }

    public static void CopyDemo()
    {
        CreateFile(copyTo);
        CreateFile(picCopy);

        System.out.println("Executing CopyFileReaderWriter");
        CalcTime(() -> CopyFileReaderWriter());

        System.out.println("Executing CopyBufferedFileReaderWriter");
        CalcTime(() -> CopyBufferedFileReaderWriter());

        System.out.println("Executing CopyFileInputOutputStream");
        CalcTime(() -> CopyFileInputOutputStream());

        System.out.println("Executing CopyBufferedFileInputOutputStream");
        CalcTime(() -> CopyBufferedFileInputOutputStream());
    }

    public static void MatrixDemo()
    {
        String[][] inputMatrix =
                {
                        { "1","2","3","4"},
                        { "1","2","3","4"},
                        { "1","2","3","4"},
                        { "1","2","3","4"}
                };

        String[][] wrongSize =
                {
                        { "1","2","3","4"},
                        { "1","2","3","4"},
                        { "1","2","3","4"},
                        { "1","2","3"}
                };

        String[][] badData =
                {
                        { "1","2","3","4"},
                        { "1","2","3","4"},
                        { "1","2","3","4"},
                        { "1","2","3", "a"}
                };

        ProcessMatrixWithExceptions(inputMatrix);
        ProcessMatrixWithExceptions(wrongSize);
        ProcessMatrixWithExceptions(badData);

    }

    public static void ProcessMatrixWithExceptions(String[][] inputMatrix)
    {
        try {
            ProcessMatrix(inputMatrix);
        }
        catch (SizeArrayException ex)
        {
            System.out.println(ex.getMessage());
        }
        catch (ArrayDataException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public static void ProcessMatrix(String[][] input) throws SizeArrayException, ArrayDataException {
        var total = 0;
        if (input.length != 4)
        {
            throw new SizeArrayException(input.length);
        }

        for(int i=0; i<4;i++)
        {
            if (input[i].length != 4)
            {
                throw new SizeArrayException(input[i].length);
            }
            for (int j=0;j<4;j++) {
                try {
                    var value = Integer.parseInt(input[i][j]);
                    total += value;
                } catch (NumberFormatException ex) {
                    throw new ArrayDataException(input[i][j], i, j);
                }
            }
        }

        System.out.format("Total value provided: [%s]\n", total);
    }

    public static void CalcTime(Runnable r)
    {
        var start = System.nanoTime();
        r.run();
        var end = System.nanoTime();

        System.out.format("Execution time: %s \n", (end-start) / 1000000);
    }

    public static void CopyPic()
    {
        try(var reader = new FileInputStream(picOriginal)) {
            try (var writer = new FileOutputStream(picCopy)){
                var buf = new byte[1024];
                while(reader.read(buf) != -1)
                {
                    writer.write(buf);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void CopyFileInputOutputStream()
    {
        try(var reader = new FileInputStream(original)) {
            try (var writer = new FileOutputStream(copyTo)){
                var buf = new byte[1024];
                while(reader.read(buf) != -1)
                {
                    writer.write(buf);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void CopyBufferedFileInputOutputStream()
    {
        try(var reader = new FileInputStream(original)) {
            try (var writer = new FileOutputStream(copyTo)) {
                try (var bReader = new BufferedInputStream(reader)) {
                    try (var bWriter = new BufferedOutputStream(writer)) {
                        var buf = new byte[1024];
                        while (bReader.read(buf) != -1) {
                            bWriter.write(buf);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void CopyBufferedFileReaderWriter()
    {
        try(var reader = new FileReader(original)) {
            try (var writer = new FileWriter(copyTo)){
                try (var bReader = new BufferedReader(reader)) {
                    try (var bWriter = new BufferedWriter(writer)) {
                        var cbuf = new char[1024];
                        while (bReader.read(cbuf) != -1) {
                            bWriter.write(cbuf);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void CopyFileReaderWriter()
    {
        try(var reader = new FileReader(original)) {
            try (var writer = new FileWriter(copyTo)){
                var cbuf = new char[1024];
                while(reader.read(cbuf) != -1)
                {
                    writer.write(cbuf);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void CreateFile(String fileName)
    {
        try {
            File myObj = new File(fileName);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

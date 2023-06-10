package ru.grand.lesson6;

import java.io.*;

public class Main {

    private static final int buffSize = 4096;

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
        createFile(copyTo);
        createFile(picCopy);

        //Buff size: 1024
        //Executing CopyFileReaderWriter
        //Execution time: 705ms
        //Executing CopyBufferedFileReaderWriter
        //Execution time: 418ms
        //Executing CopyFileInputOutputStream
        //Execution time: 1018ms
        //Executing CopyBufferedFileInputOutputStream
        //Execution time: 351ms

        //Buff size: 4096
        //Executing CopyFileReaderWriter
        //Execution time: 444ms
        //Executing CopyBufferedFileReaderWriter
        //Execution time: 420ms
        //Executing CopyFileInputOutputStream
        //Execution time: 476ms
        //Executing CopyBufferedFileInputOutputStream
        //Execution time: 330ms

        System.out.println("Executing CopyFileReaderWriter");
        calcTime(() -> copyFileReaderWriter());

        System.out.println("Executing CopyBufferedFileReaderWriter");
        calcTime(() -> copyBufferedFileReaderWriter());

        System.out.println("Executing CopyFileInputOutputStream");
        calcTime(() -> copyFileInputOutputStream());

        System.out.println("Executing CopyBufferedFileInputOutputStream");
        calcTime(() -> copyBufferedFileInputOutputStream());
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

        processMatrixWithExceptions(inputMatrix);
        processMatrixWithExceptions(wrongSize);
        processMatrixWithExceptions(badData);

    }

    public static void processMatrixWithExceptions(String[][] inputMatrix)
    {
        try {
            processMatrix(inputMatrix);
        }
        catch (SizeArrayException | ArrayDataException ex )
        {
            System.out.println(ex.getMessage());
        }
    }

    public static void processMatrix(String[][] input) throws SizeArrayException, ArrayDataException {
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

    public static void calcTime(Runnable r)
    {
        var start = System.nanoTime();
        r.run();
        var end = System.nanoTime();

        System.out.format("Execution time: %s \n", (end-start) / 1000000);
    }

    public static void copyPic()
    {
        try(var reader = new FileInputStream(picOriginal)) {
            try (var writer = new FileOutputStream(picCopy)){
                var buf = new byte[buffSize];
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

    public static void copyFileInputOutputStream()
    {
        try(var reader = new FileInputStream(original)) {
            try (var writer = new FileOutputStream(copyTo)){
                var buf = new byte[buffSize];
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

    public static void copyBufferedFileInputOutputStream()
    {
        try(var reader = new FileInputStream(original)) {
            try (var writer = new FileOutputStream(copyTo)) {
                try (var bReader = new BufferedInputStream(reader)) {
                    try (var bWriter = new BufferedOutputStream(writer)) {
                        var buf = new byte[buffSize];
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

    public static void copyBufferedFileReaderWriter()
    {
        try(var reader = new FileReader(original)) {
            try (var writer = new FileWriter(copyTo)){
                try (var bReader = new BufferedReader(reader)) {
                    try (var bWriter = new BufferedWriter(writer)) {
                        var cbuf = new char[buffSize];
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

    public static void copyFileReaderWriter()
    {
        try(var reader = new FileReader(original)) {
            try (var writer = new FileWriter(copyTo)){
                var cbuf = new char[buffSize];
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

    public static void createFile(String fileName)
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

package ru.grand.lesson6;

import lombok.AllArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@AllArgsConstructor
public class DirectoryPrinter {
    private String baseFolder;


    public void printFolders()
    {
        var file = new File(this.baseFolder);
        System.out.format("%s\n",file.getName());
        this.printFolderRecursive(file, "-");
    }

    public void printFoldersStream()
    {
        try (Stream<Path> paths = Files.walk(Paths.get(baseFolder))) {
            paths
                    .filter(Files::isDirectory)
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void printFolderRecursive(File file, String prefix)
    {
        for(var f:file.listFiles())
        {
            if (f.isDirectory())
            {
                System.out.format("%s%s\n", prefix,f.getName());
                printFolderRecursive(f, prefix + "-");
            }
            else {
                System.out.format("%s%s\n", prefix,f.getName());
            }
        }
    }
}

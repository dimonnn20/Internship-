package com.fileSystem.zip.workWithZipArchive;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileOutputStream zipFile = new FileOutputStream("C:/my/archive.zip");
        ZipOutputStream zipOutputStream = new ZipOutputStream(zipFile);

        zipOutputStream.putNextEntry(new ZipEntry("fileForArchive.txt"));

        File file = new File("C:/my/fileForArchive.txt");

        Files.copy(file.toPath(),zipOutputStream);
        zipOutputStream.close();
    }
}

import java.io.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandlingActivity {
    public static void main(String[] args) {


        // a. Create main directory
        File directory = new File("JavaFileSystem");
        directory.mkdir();

        try {
            File file1 = new File(directory, "notes.txt");
            file1.createNewFile();
            listFiles(directory.getPath());
            File file2 = new File(directory, "data.txt");
            file2.createNewFile();
            File file3 = new File(directory, "log.txt");
            file3.createNewFile();
            BufferedWriter bufferedWriter1 = new BufferedWriter(new FileWriter(file1));
            bufferedWriter1.write("I have notes stored in me");

            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file2));
            bufferedWriter2.write("I have data stored in me");

            BufferedWriter bufferedWriter3 = new BufferedWriter(new FileWriter(file3));
            bufferedWriter3.write("I have logs stored in me");

            BufferedReader bufferedReader1 = new BufferedReader(new FileReader(file1));
            while (bufferedReader1.ready()) {
                System.out.println(bufferedReader1.readLine());
            }

            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file2));
            while (bufferedReader2.ready()) {
                System.out.println(bufferedReader2.readLine());
            }

            BufferedReader bufferedReader3 = new BufferedReader(new FileReader(file3));
            while (bufferedReader3.ready()) {
                System.out.println(bufferedReader3.readLine());
            }
            bufferedWriter1.close();
            bufferedWriter2.close();
            bufferedWriter3.close();
            bufferedReader1.close();
            bufferedReader2.close();
            bufferedReader3.close();


            BufferedReader bufferedReader4 = new BufferedReader(new FileReader(file1));

            BufferedReader bufferedReader5 = new BufferedReader(new FileReader(file2));

            BufferedReader bufferedReader6 = new BufferedReader(new FileReader(file3));

            File backupDir = new File(directory, "Backup");
            backupDir.mkdir();
            File backup = new File(backupDir, "backup.txt");
            backup.createNewFile();

            BufferedWriter backupWriter1 = new BufferedWriter(new FileWriter(backup, true));

            while (bufferedReader4.ready()) {
                backupWriter1.write(bufferedReader4.readLine());
                backupWriter1.newLine();
            }
            backupWriter1.close();

            BufferedWriter backupWriter2 = new BufferedWriter(new FileWriter(backup, true));
            while (bufferedReader5.ready()) {
                backupWriter2.write(bufferedReader5.readLine());
                backupWriter2.newLine();
            }
            backupWriter2.close();

            BufferedWriter backupWriter3 = new BufferedWriter(new FileWriter(backup, true));
            while (bufferedReader6.ready()) {
                backupWriter3.write(bufferedReader6.readLine());
                backupWriter3.newLine();
            }
            backupWriter3.close();

            bufferedReader4.close();
            bufferedReader5.close();
            bufferedReader6.close();



            listFiles(".");

        } catch (Exception e) {
            System.out.println(e);
        }


        // g. List all files in both directories
    }

    public static void listFiles(String path) {
        File[] files = new File(path).listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                listFiles(file.getPath());
            } else {
                System.out.println(file.getName());
            }
        }
    }


    public static void debugFileOperation() {
        try {
            // Creating a file with an invalid name (forward slash is invalid for file names on many
            // OS)
            File file = new File("/fileName.txt");

            // Attempting to write to the invalid file
            FileWriter writer = new FileWriter(file);
            writer.write("Will this fail?");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

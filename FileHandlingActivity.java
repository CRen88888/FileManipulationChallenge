import java.io.*;

public class FileHandlingActivity {
    public static void main(String[] args) {


        // a. Create main directory
        File directory = new File("main");
        directory.mkdir();

        try {
            File file1 = new File("first.txt");
            file1.createNewFile();
            listFiles(directory.getPath());
            File file2 = new File("second.txt");
            file2.createNewFile();
            File file3 = new File("third.txt");
            file3.createNewFile();
            BufferedWriter bufferedWriter1 = new BufferedWriter(new FileWriter(file1));
            bufferedWriter1.write("Hello World");

            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file2));
            bufferedWriter2.write("Hello World");

            BufferedWriter bufferedWriter3 = new BufferedWriter(new FileWriter(file3));
            bufferedWriter3.write("Hello World");

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

            File backupDir = new File("backup");
            backupDir.mkdir();
            BufferedWriter backupWriter1 =
                    new BufferedWriter(new FileWriter(new File("backup/backup1")));
            while (bufferedReader4.ready()) {
                backupWriter1.write(bufferedReader4.readLine());
            }

            BufferedWriter backupWriter2 =
                    new BufferedWriter(new FileWriter(new File("backup/backup2")));
            while (bufferedReader5.ready()) {
                backupWriter2.write(bufferedReader5.readLine());
            }

            BufferedWriter backupWriter3 =
                    new BufferedWriter(new FileWriter(new File("backup/backup3")));
            while (bufferedReader6.ready()) {
                backupWriter3.write(bufferedReader6.readLine());
            }

            bufferedReader4.close();
            bufferedReader5.close();
            bufferedReader6.close();
            backupWriter1.close();
            backupWriter2.close();
            backupWriter3.close();

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
}

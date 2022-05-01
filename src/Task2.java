import java.io.*;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Task2 {

    public static void main(String[] args) {

//ЗАДАЧА 2
        //SAVE
        GameProgress gp1 = new GameProgress(1, 1, 1, 100);
        GameProgress gp2 = new GameProgress(2, 2, 2, 200);
        GameProgress gp3 = new GameProgress(3, 3, 3, 300);
        saveGame("D://03_ОБУЧЕНИЕ//01_Нетология_Java//Games//savegames//save1.dat", gp1);
        saveGame("D://03_ОБУЧЕНИЕ//01_Нетология_Java//Games//savegames//save2.dat", gp2);
        saveGame("D://03_ОБУЧЕНИЕ//01_Нетология_Java//Games//savegames//save3.dat", gp3);

        //ZIP
        ArrayList<String> files = new ArrayList<>();
        files.add("D://03_ОБУЧЕНИЕ//01_Нетология_Java//Games//savegames//save1.dat");
        files.add("D://03_ОБУЧЕНИЕ//01_Нетология_Java//Games//savegames//save2.dat");
        files.add("D://03_ОБУЧЕНИЕ//01_Нетология_Java//Games//savegames//save3.dat");

        zipFiles("D://03_ОБУЧЕНИЕ//01_Нетология_Java//Games//savegames//zip.zip", files);
        //del
        for (int i = 0; i < files.size(); i++) {
            File dir = new File(files.get(i));
            dir.delete();
        }
    }


    public static void saveGame(String directory, GameProgress gp) {
        try (FileOutputStream fos = new FileOutputStream(directory);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(gp);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void zipFiles(String directory, ArrayList<String> files) {

        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(directory))) {
            for (int i = 0; i < files.size(); i++) {
                try (FileInputStream fis = new FileInputStream(files.get(i))) {
                    ZipEntry entry = new ZipEntry("packed_save" + (i + 1));
                    zout.putNextEntry(entry);

                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);
                    zout.write(buffer);
                    zout.closeEntry();


                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }


            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


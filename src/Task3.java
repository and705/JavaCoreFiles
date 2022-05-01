import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Task3 {

    public static void main(String[] args) {
        openZip("D://03_ОБУЧЕНИЕ//01_Нетология_Java//Games//savegames//zip.zip", "D://03_ОБУЧЕНИЕ//01_Нетология_Java//Games//savegames//");
        openProgress("D://03_ОБУЧЕНИЕ//01_Нетология_Java//Games//savegames//packed_save1");

    }
    public static void openZip(String file, String target){
        try (ZipInputStream zin = new ZipInputStream(new FileInputStream(file))){
            ZipEntry entry;
            String name;
            while ((entry = zin.getNextEntry()) != null){
                name = entry.getName();
                //распаковка
                FileOutputStream fout = new FileOutputStream(target+name);
                for (int c = zin.read(); c != -1; c = zin.read()){
                    fout.write(c);
                }
                fout.flush();
                zin.closeEntry();
                fout.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void openProgress(String file){
        GameProgress gameProgress = null;
        try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis)){
            gameProgress = (GameProgress) ois.readObject();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(gameProgress);
    }

}

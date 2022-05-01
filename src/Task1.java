import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task1 {
    //ЗАДАЧА 1
    public static void main(String[] args) {
        File src = new File("D://03_ОБУЧЕНИЕ//01_Нетология_Java//Games//src");
        File res = new File("D://03_ОБУЧЕНИЕ//01_Нетология_Java//Games//res");
        File savegames = new File("D://03_ОБУЧЕНИЕ//01_Нетология_Java//Games//savegames");
        File temp = new File("D://03_ОБУЧЕНИЕ//01_Нетология_Java//Games//temp");

        StringBuilder sb = new StringBuilder();

        //В папке Games создайте несколько директорий: src, res, savegames, temp.
        if (src.mkdir()) {
            System.out.println("Создан каталог " + src.getAbsolutePath());
            sb.append("Создан каталог " + src.getAbsolutePath() + "\n");
        }
        if (res.mkdir()) {
            System.out.println("Создан каталог " + res.getAbsolutePath());
            sb.append("Создан каталог " + res.getAbsolutePath() + "\n");
        }
        if (savegames.mkdir()) {
            System.out.println("Создан каталог " + savegames.getAbsolutePath());
            sb.append("Создан каталог " + savegames.getAbsolutePath() + "\n");
        }
        if (temp.mkdir()) {
            System.out.println("Создан каталог " + temp.getAbsolutePath());
        }
        //В каталоге src создайте две директории: main, test.
        File main = new File("D://03_ОБУЧЕНИЕ//01_Нетология_Java//Games//src//main");
        File test = new File("D://03_ОБУЧЕНИЕ//01_Нетология_Java//Games//res//test");
        if (main.mkdir()) {
            System.out.println("Создан каталог " + main.getAbsolutePath());
            sb.append("Создан каталог " + main.getAbsolutePath() + "\n");
        }
        if (test.mkdir()) {
            System.out.println("Создан каталог " + test.getAbsolutePath());
            sb.append("Создан каталог " + test.getAbsolutePath() + "\n");
        }

        //В подкаталоге main создайте два файла: Main.java, Utils.java.
        File fileMain = new File("D://03_ОБУЧЕНИЕ//01_Нетология_Java//Games//src//main//Main.java");
        File fileUtils = new File("D://03_ОБУЧЕНИЕ//01_Нетология_Java//Games//src//main//Utils.java");

        try {
            if (fileMain.createNewFile())
                System.out.println("Файл " + fileMain.getName() + " создан");
            sb.append("Файл " + fileMain.getName() + " создан" + "\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            if (fileUtils.createNewFile())
                System.out.println("Файл " + fileUtils.getName() + " создан");
            sb.append("Файл " + fileUtils.getName() + " создан" + "\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        //В каталог res создайте три директории: drawables, vectors, icons.
        File drawables = new File("D://03_ОБУЧЕНИЕ//01_Нетология_Java//Games//res//drawables");
        File vectors = new File("D://03_ОБУЧЕНИЕ//01_Нетология_Java//Games//res//vectors");
        File icons = new File("D://03_ОБУЧЕНИЕ//01_Нетология_Java//Games//res//icons");
        if (drawables.mkdir()) {
            System.out.println("Создан каталог " + drawables.getAbsolutePath());
            sb.append("Создан каталог " + drawables.getAbsolutePath() + "\n");
        }
        if (vectors.mkdir()) {
            System.out.println("Создан каталог " + vectors.getAbsolutePath());
            sb.append("Создан каталог " + vectors.getAbsolutePath() + "\n");
        }
        if (icons.mkdir()) {
            System.out.println("Создан каталог " + icons.getAbsolutePath());
            sb.append("Создан каталог " + icons.getAbsolutePath() + "\n");
        }

        //В директории temp создайте файл temp.txt.
        try (FileOutputStream fos = new FileOutputStream("D://03_ОБУЧЕНИЕ//01_Нетология_Java//Games//temp//temp.txt")) {
            sb.append("Создан файл yemp.txt \n");
            byte[] bytes = sb.toString().getBytes();
            fos.write(bytes, 0, bytes.length);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}


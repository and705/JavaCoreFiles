import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task1 {
    //������ 1
    public static void main(String[] args) {
        File src = new File("D://03_��������//01_���������_Java//Games//src");
        File res = new File("D://03_��������//01_���������_Java//Games//res");
        File savegames = new File("D://03_��������//01_���������_Java//Games//savegames");
        File temp = new File("D://03_��������//01_���������_Java//Games//temp");

        StringBuilder sb = new StringBuilder();

        //� ����� Games �������� ��������� ����������: src, res, savegames, temp.
        if (src.mkdir()) {
            System.out.println("������ ������� " + src.getAbsolutePath());
            sb.append("������ ������� " + src.getAbsolutePath() + "\n");
        }
        if (res.mkdir()) {
            System.out.println("������ ������� " + res.getAbsolutePath());
            sb.append("������ ������� " + res.getAbsolutePath() + "\n");
        }
        if (savegames.mkdir()) {
            System.out.println("������ ������� " + savegames.getAbsolutePath());
            sb.append("������ ������� " + savegames.getAbsolutePath() + "\n");
        }
        if (temp.mkdir()) {
            System.out.println("������ ������� " + temp.getAbsolutePath());
        }
        //� �������� src �������� ��� ����������: main, test.
        File main = new File("D://03_��������//01_���������_Java//Games//src//main");
        File test = new File("D://03_��������//01_���������_Java//Games//res//test");
        if (main.mkdir()) {
            System.out.println("������ ������� " + main.getAbsolutePath());
            sb.append("������ ������� " + main.getAbsolutePath() + "\n");
        }
        if (test.mkdir()) {
            System.out.println("������ ������� " + test.getAbsolutePath());
            sb.append("������ ������� " + test.getAbsolutePath() + "\n");
        }

        //� ����������� main �������� ��� �����: Main.java, Utils.java.
        File fileMain = new File("D://03_��������//01_���������_Java//Games//src//main//Main.java");
        File fileUtils = new File("D://03_��������//01_���������_Java//Games//src//main//Utils.java");

        try {
            if (fileMain.createNewFile())
                System.out.println("���� " + fileMain.getName() + " ������");
            sb.append("���� " + fileMain.getName() + " ������" + "\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            if (fileUtils.createNewFile())
                System.out.println("���� " + fileUtils.getName() + " ������");
            sb.append("���� " + fileUtils.getName() + " ������" + "\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        //� ������� res �������� ��� ����������: drawables, vectors, icons.
        File drawables = new File("D://03_��������//01_���������_Java//Games//res//drawables");
        File vectors = new File("D://03_��������//01_���������_Java//Games//res//vectors");
        File icons = new File("D://03_��������//01_���������_Java//Games//res//icons");
        if (drawables.mkdir()) {
            System.out.println("������ ������� " + drawables.getAbsolutePath());
            sb.append("������ ������� " + drawables.getAbsolutePath() + "\n");
        }
        if (vectors.mkdir()) {
            System.out.println("������ ������� " + vectors.getAbsolutePath());
            sb.append("������ ������� " + vectors.getAbsolutePath() + "\n");
        }
        if (icons.mkdir()) {
            System.out.println("������ ������� " + icons.getAbsolutePath());
            sb.append("������ ������� " + icons.getAbsolutePath() + "\n");
        }

        //� ���������� temp �������� ���� temp.txt.
        try (FileOutputStream fos = new FileOutputStream("D://03_��������//01_���������_Java//Games//temp//temp.txt")) {
            sb.append("������ ���� yemp.txt \n");
            byte[] bytes = sb.toString().getBytes();
            fos.write(bytes, 0, bytes.length);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}


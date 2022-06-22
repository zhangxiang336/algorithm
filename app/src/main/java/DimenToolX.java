import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 根据values/mipay_dimens.xml, 自动计算比例并生成不同分辨率的dimens.xml
 * 注意用dp和sp，不要用dip，否则生成可能会出错；xml值不要有空格
 * Created by zhangxitao on 15/9/22.
 */
public class DimenToolX {

    public static void gen() {

        File file = new File("./app/src/main/res/values/themes.xml");
        BufferedReader reader = null;
        StringBuilder sw440 = new StringBuilder();
        StringBuilder swx = new StringBuilder();
        StringBuilder swxx = new StringBuilder();
        StringBuilder swxxx = new StringBuilder();

        try {

            System.out.println("生成不同分辨率：");
            reader = new BufferedReader(new FileReader(file));
            String tempString;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束

            while ((tempString = reader.readLine()) != null) {

                if (tempString.contains("</dimen>")) {
                    //tempString = tempString.replaceAll(" ", "");
                    String start = tempString.substring(0, tempString.indexOf(">") + 1);
                    String end = tempString.substring(tempString.lastIndexOf("<") - 2);
                    float aDouble = Float.valueOf(tempString.substring(tempString.indexOf(">") + 1, tempString.indexOf("</dimen>") - 2));

                    sw440.append(start).append( (float)(Math.round( aDouble * 60))/100).append(end).append("\r\n");
                    swx.append(start).append( (float)(Math.round( aDouble * 109))/100).append(end).append("\r\n");
                    swxx.append(tempString).append("\r\n");
                    swxxx.append(start).append( (float)(Math.round( aDouble * 109))/100).append(end).append("\r\n");

                } else {
                    sw440.append(tempString).append("\r\n");
                    swx.append(tempString).append("\r\n");
                    swxx.append(tempString).append("\r\n");
                    swxxx.append(tempString).append("\r\n");
                }
                line++;
            }
            reader.close();

            String sw440file = "./app/src/main/res/values-440dpi-v4/mipay_dimens.xml";
            String swxfile = "./app/src/main/res/values-xhdpi-v4/mipay_dimens.xml";
            String swxxfile = "./app/src/main/res/values-xxhdpi-v4/mipay_dimens.xml";
            String swxxxfile = "./app/src/main/res/values-xxxhdpi-v4/mipay_dimens.xml";

            writeFile(sw440file, sw440.toString());
            writeFile(swxfile, swx.toString());
            writeFile(swxxfile, swxx.toString());
            writeFile(swxxxfile, swxxx.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    public static void writeFile(String file, String text) {
        PrintWriter out = null;
        try {
            File file1=new File(file);
            if(file1.exists()){
                file1.delete();
            }

            //创建目录后生成dimens.xml文件
            out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            out.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }

        out.close();
    }

    public static void main(String[] args) {
        gen();
    }
}
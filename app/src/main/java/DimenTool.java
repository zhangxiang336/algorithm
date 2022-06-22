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
public class DimenTool {

    public static void gen() {

        File file = new File("./app/src/main/res/values/themes.xml");
        BufferedReader reader = null;
        StringBuilder sw440 = new StringBuilder();
        StringBuilder sw480 = new StringBuilder();
        StringBuilder sw560 = new StringBuilder();
        StringBuilder sw420 = new StringBuilder();
        StringBuilder sw360 = new StringBuilder();

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
                    sw480.append(tempString).append("\r\n");
                    sw560.append(start).append( (float)(Math.round( aDouble * 114))/100).append(end).append("\r\n");
                    sw420.append(start).append( (float)(Math.round( aDouble * 114))/100).append(end).append("\r\n");
                    sw360.append(start).append( (float)(Math.round( aDouble * 133))/100).append(end).append("\r\n");

                } else {
                    sw440.append(tempString).append("\r\n");
                    sw480.append(tempString).append("\r\n");
                    sw560.append(tempString).append("\r\n");
                    sw420.append(tempString).append("\r\n");
                    sw360.append(tempString).append("\r\n");
                }
                line++;
            }
            reader.close();

            String sw440file = "./app/src/main/res/values-440dpi/mipay_dimens.xml";
            String sw480file = "./app/src/main/res/values-480dpi/mipay_dimens.xml";
            String sw560file = "./app/src/main/res/values-560dpi/mipay_dimens.xml";
            String sw420file = "./app/src/main/res/values-420dpi/mipay_dimens.xml";
            String sw360file = "./app/src/main/res/values-360dpi/mipay_dimens.xml";

            writeFile(sw440file, sw440.toString());
            writeFile(sw480file, sw480.toString());
            writeFile(sw560file, sw560.toString());
            writeFile(sw420file, sw420.toString());
            writeFile(sw360file, sw360.toString());
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
            createFile(file);
            //创建目录后生成dimens.xml文件
            out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            out.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }

        out.close();
    }

    public static boolean createFile(String destFileName) {
        File file = new File(destFileName);
        if(file.exists()) {
            System.out.println("创建单个文件" + destFileName + "失败，目标文件已存在！");
            return false;
        }
        if (destFileName.endsWith(File.separator)) {
            System.out.println("创建单个文件" + destFileName + "失败，目标文件不能为目录！");
            return false;
        }
        //判断目标文件所在的目录是否存在
        if(!file.getParentFile().exists()) {
            //如果目标文件所在的目录不存在，则创建父目录
            System.out.println("目标文件所在目录不存在，准备创建它！");
            if(!file.getParentFile().mkdirs()) {
                System.out.println("创建目标文件所在目录失败！");
                return false;
            }
        }
        //创建目标文件
        try {
            if (file.createNewFile()) {
                System.out.println("创建单个文件" + destFileName + "成功！");
                return true;
            } else {
                System.out.println("创建单个文件" + destFileName + "失败！");
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("创建单个文件" + destFileName + "失败！" + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        gen();
    }
}
/**
 * @author:wanght
 * @version: 1.0.0
 */

package properties操作;

import java.util.*;
import java.io.*;

public class TestProperties {
    /**根据key读取value*/
    public static String GetValue(String filePath, String pKey) throws IOException{
        Properties pps = new Properties();
        try {
            InputStream in = new FileInputStream(filePath);
            pps.load(in);
            String Value = pps.getProperty(pKey);
            return Value;
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    /**读取Properties的全部信息*/
    public static HashMap ProMap(String filePath) throws IOException{
        HashMap m = new HashMap();
        Properties pps = new Properties();
        try {
            InputStream in =new FileInputStream(filePath);
            pps.load(in);
            Enumeration en = pps.propertyNames();
            /**properties 专用迭代器*/
            while (en.hasMoreElements()){
                String tmpk = en.nextElement().toString();
                String tmpv = pps.getProperty(tmpk);
                m.put(tmpk,tmpv);
            }
            return m;

        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
    /** 往配置文件里写数据*/
    public static void WriteProperties(String filePath, String pKey,String pValue) throws IOException{
        Properties pps = new Properties();
        /**从输入流中读取属性列表（键和元素对）*/
        InputStream in = new FileInputStream(filePath);
        /**load ( InputStream)，从输入流中读取属性列表（键和元素对）装载来获取该文件中的所有键 - 值对， 以供 getProperty ( String key) 来搜索。*/
        pps.load(in);
        /**定义输出流*/
        OutputStream out = new FileOutputStream(filePath);
        /**键值对存储入properties*/
        pps.setProperty(pKey, pValue);
        /**将此 Properties 表中的属性列表（键和元素对）写入输出流*/
        pps.store(out, "Update: " +pKey + " name");
    }

    public static void main(String[] args) throws IOException {
        String filePath = "./src/properties操作/赋值Test.properties";

        WriteProperties(filePath, "long", "213");

        String a = GetValue(filePath, "long");
        System.out.println(a);

        HashMap m = ProMap(filePath);
        System.out.println(m);
    }
}

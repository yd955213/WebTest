package comm.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoadFile {
    private FileReader fileReader = null;
    private BufferedReader bufferedReader = null;
    private static MySqlLoginInfo mySqlLoginInfo = null;

    /**
     * 读取文件内容
     * @param fileName
     */
    public void loadFile(String fileName) {
        try {
            System.out.println(fileName);
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);

            Properties properties = new Properties();
            properties.load(fileReader);
            System.out.println(properties.size());

            mySqlLoginInfo = new MySqlLoginInfo();
            mySqlLoginInfo.driverClass = properties.getProperty("driverClass");
            mySqlLoginInfo.jdbcUrl = properties.getProperty("jdbcUrl");
            mySqlLoginInfo.mysqlPassWord = properties.getProperty("mysqlPassWord");
            mySqlLoginInfo.mysqlUser = properties.getProperty("mysqlUser");
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null != bufferedReader) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != fileReader) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 获取properties.txt内容
     * @return
     */
    public static MySqlLoginInfo getMySqlLoginInfo() {
        return mySqlLoginInfo;
    }
    public static class MySqlLoginInfo {
        public String driverClass=null;
        public String jdbcUrl=null;
        public String mysqlUser=null;
        public String mysqlPassWord=null;

    }


}

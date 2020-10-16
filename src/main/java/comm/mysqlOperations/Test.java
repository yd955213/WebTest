package comm.mysqlOperations;

import comm.Utils.PropertiesLoadFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static comm.Utils.PropertiesLoadFile.*;

public class Test {
    public static void main(String[] args) {
//        MySqlConnection mySqlConnection = MySqlConnection.getInstance();
//        System.out.println(mySqlConnection.listUsers().get(0).get(0));
        long a = System.currentTimeMillis();
        System.out.println(a);
//        Properties properties = new Properties();
//        try {
//            FileReader fileReader = new FileReader("src/main/resources/properties.txt");
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            properties.load(bufferedReader);
//            fileReader.close();
//            bufferedReader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(properties.getProperty("driverClass"));
//        System.out.println(properties.getProperty("jdbcUrl"));
//        System.out.println(properties.getProperty("mysqlUser"));
//        System.out.println(properties.getProperty("mysqlPassWord"));

        PropertiesLoadFile propertiesLoadFile = new PropertiesLoadFile();
        propertiesLoadFile.loadFile("src/main/resources/properties.txt");
        System.out.println(PropertiesLoadFile.getMySqlLoginInfo().driverClass);
        System.out.println(getMySqlLoginInfo().jdbcUrl);
        System.out.println(getMySqlLoginInfo().mysqlUser);
        System.out.println(getMySqlLoginInfo().mysqlPassWord);
        long b = System.currentTimeMillis();

        System.out.println(b);
        System.out.println(b - a);
    }
}

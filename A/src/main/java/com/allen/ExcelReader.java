package com.allen;

import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

/**
 * @author huanghw
 * @Description TODO
 * @create 2020-10-12 18:10
 */
public class ExcelReader {

    public static void main(String[] args) throws IOException, SQLException {

        String url = "jdbc:mysql://10.117.156.94:3306/ictdb?characterEncoding=utf8&useSSL=false&allowMultiQueries=true";
        String username = "root";
        String password ="4tm$U5J^$mPK";

        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        InputStream inputStream = new FileInputStream("C:\\Users\\70790\\Desktop\\busiType\\存量商机信息-汇总-待修订 -V3.xlsx");
        ZipSecureFile.setMinInflateRatio(-1.0d);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheet("商机行业优化表");
        for (Row r : sheet) {
            //不读取第一行表头
            if (r.getRowNum() < 1) {
                continue;
            }
            String oldBusiType = r.getCell(19).toString();
            String oldSubBusiType = r.getCell(20).toString();
            String newBusiType = r.getCell(21).toString();
            String newSubBusiType = r.getCell(22).toString();
            ResultSet resultSet = statement.executeQuery("SELECT type_code FROM busi_oppty_type WHERE type_name = '" + oldBusiType+"'");

            if (resultSet.next()) {
                System.out.println("123");
                resultSet.first();
            }
        }
        connection.close();
    }

}

package utilis;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelReading {
    static Workbook workbook;
    static Sheet sheet;

    public static void openexcel(String path){
        try {
            FileInputStream fileInputStream=new FileInputStream(path);
             workbook=new XSSFWorkbook(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void getsheet(String sheetname){
         sheet=workbook.getSheet(sheetname);
    }

    public static int getnumberofrows(){
        return  sheet.getPhysicalNumberOfRows();

    }

    public static  int  getcolumn(int rowindex){
        return sheet.getRow(rowindex).getPhysicalNumberOfCells();
    }

    public static String getdata(int rowindex,int columnindex){
        return sheet.getRow(rowindex).getCell(columnindex).toString();
}


   public static List<Map<String,String>> excelintomap(String path, String sheetname){

        openexcel(path);
        getsheet(sheetname);

       List<Map<String,String>> listdata=new ArrayList<>();

       for (int row = 1; row <getnumberofrows() ; row++) {
       Map<String ,String> map=new LinkedHashMap<>();

           for (int col = 0; col <getcolumn(row) ; col++) {
            map.put(getdata(0,col),getdata(row,col));
           }
           listdata.add(map);
       }

       return listdata;

    }

}

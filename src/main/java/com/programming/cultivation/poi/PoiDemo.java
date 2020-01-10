package com.programming.cultivation.poi;

import com.programming.cultivation.base.Book;
import com.programming.cultivation.poi.common.ClassTypeEnum;
import com.programming.cultivation.poi.common.reflect.Reflector;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author biyue
 * @since 2020/01/10
 */
public class PoiDemo {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List<Object> books = new ArrayList<>();
        for (int i = 0; i < 500000; i++) {
            books.add(new Book(i, i + 1, "小板凳"));
        }
        try {
            latest(books);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(System.currentTimeMillis() - start);
    }


    /**
     * 97-2007  .xls
     *
     * @throws Exception
     */
    public static void latest(List<Object> data) throws Exception {
        List<MetaData> analysis = Reflector.analysis(data.get(0).getClass());
        FileOutputStream fos = new FileOutputStream("E:\\poi\\" + System.currentTimeMillis() + ".xlsx");
        Workbook wb = new XSSFWorkbook();//
        Sheet sheet = wb.createSheet("我是新的");
        int rowNum = 0;
        Row row = sheet.createRow(rowNum++);
        int columnNum = 0;
        for (MetaData metaData : analysis) {
            row.createCell(columnNum++).setCellValue(metaData.getColumnName());
        }
        for (Object obj : data) {
            row = sheet.createRow(rowNum++);
            columnNum = 0;
            for (MetaData metaData : analysis) {
                Cell cell = row.createCell(columnNum++);
                if (metaData.getClazzType() == ClassTypeEnum.INTEGER) {
                    Integer invoke = (Integer) metaData.getMethod().invoke(obj);
                    if (invoke == null) {
                        continue;
                    }
                    cell.setCellValue(invoke);
                }
                if (metaData.getClazzType() == ClassTypeEnum.STRING) {
                    Object o = metaData.getField().get(obj);
                    cell.setCellValue(o.toString());
                }
            }
        }
        wb.write(fos);
        wb.close();
        fos.close();
    }

    public static CellStyle createDateCellStyle(Workbook wb) {
        CellStyle cellStyle = wb.createCellStyle();
        CreationHelper createHelper = wb.getCreationHelper();
        cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy/MM/dd HH:mm:ss"));
        return cellStyle;
    }


}

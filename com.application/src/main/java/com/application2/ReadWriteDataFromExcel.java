package com.application2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadWriteDataFromExcel {

	FileInputStream fis=null;
	Workbook wb=null;
	Sheet sh=null;
	FileOutputStream fos=null;
	Row row=null;
	Cell currentcell=null;
	@Test
	public void readFromExcel() throws IOException
	{
		
		File file=new File("E:\\sts examples\\application2\\Book1.xlsx");
		try {
			fis=new FileInputStream(file);
			wb=new XSSFWorkbook(fis);
			sh=wb.getSheet("Sheet1");
			int rows=sh.getPhysicalNumberOfRows();
			for(int i=0;i<sh.getPhysicalNumberOfRows();i++)
			{
					row=sh.getRow(i);
					if(row==null)
					{
						continue;
					}
					else
					{
				for(int j=0;j<row.getPhysicalNumberOfCells();j++)
				{
					currentcell=row.getCell(j);
					int type=currentcell.getCellType();
					if(type == 0)
					{
						System.out.println(currentcell.getNumericCellValue());
					}
					else 
						if(type == 1)
						{
							System.out.println(currentcell.getStringCellValue());
						}
				}
					}
			}
			
			
					
			fis.close();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void writetoexcel()
	{
		
		
		File file=new File("E:\\sts examples\\application2\\Book1.xlsx");
		try {
			fis=new FileInputStream(file);
			wb=new XSSFWorkbook(fis);
			Sheet sh=wb.getSheet("Sheet1");
			int rows=5;
			int cols=2;
			Row row=sh.getRow(rows);
			if(row==null)
			{
				row=sh.createRow(rows);
			}
			Cell cell=row.getCell(cols);
			
			if(cell == null)
			{
				row.createCell(cols).setCellValue("Textvalue");
			}
			else
			{
				row.createCell(cols).setCellValue("Textvalue");
			}
			fos=new FileOutputStream("E:\\sts examples\\application2\\Book1.xlsx");
			wb.write(fos);
			fos.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

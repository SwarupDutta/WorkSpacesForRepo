package extra;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
//import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateAndWriteAndRead 
{
	//static SXSSFWorkbook  wb ;
	//static XSSFWorkbook  wb;
	static Workbook  wb;
	static Sheet sh ;
	private static CellStyle getNormalStyle()
	{
		CellStyle style = wb.createCellStyle();

		style.setBorderBottom(CellStyle.BORDER_THIN);
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderLeft(CellStyle.BORDER_THIN);
		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderRight(CellStyle.BORDER_THIN);
		style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderTop(CellStyle.BORDER_THIN);
		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
		style.setAlignment(CellStyle.ALIGN_CENTER);

		return style;
	}
	private static CellStyle getHeaderStyle()
	{
		CellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);

		style.setBorderBottom(CellStyle.BORDER_THIN);
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderLeft(CellStyle.BORDER_THIN);
		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderRight(CellStyle.BORDER_THIN);
		style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderTop(CellStyle.BORDER_THIN);
		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
		style.setAlignment(CellStyle.ALIGN_CENTER);

		return style;
	}
	public static void createExcel()
	{
		//wb =  new SXSSFWorkbook(100);
		wb =  new XSSFWorkbook();
		CellStyle headerStle= getHeaderStyle();
		CellStyle normalStyle = getNormalStyle();
		for(int sheet=0;sheet<2;sheet++)
		{
			sh = wb.createSheet("Sample sheet"+sheet);
			for(int rownum = 0; rownum < 10; rownum++)
			{
				Row row = sh.createRow(rownum);
				for(int cellnum = 0; cellnum < 10; cellnum++)
				{
					Cell cell = row.createCell(cellnum);
					String address = new CellReference(cell).formatAsString();
					cell.setCellValue(address+"sheet"+(sheet+1));
					if(rownum == 0)
					{

						cell.setCellStyle(headerStle);
					}
					else
					{
						cell.setCellStyle(normalStyle);
					}

				}
			}

		}
		try 
		{
			FileOutputStream out =  new FileOutputStream(new File(System.getProperty("user.dir")+"/new.xlsx"),true);
			wb.write(out);
			out.close();
			System.out.println("Excel written successfully..");

		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void read()
	{
		FileInputStream fis;
		try 
		{
			fis = new FileInputStream(System.getProperty("user.dir")+"/new.xlsx");
			XSSFWorkbook wb= new XSSFWorkbook(fis);
			int numberOfSheets = wb.getNumberOfSheets();


			for(int i=0; i < numberOfSheets; i++)
			{

				Sheet sheet = wb.getSheetAt(i);


				int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
				if(rowCount!=0)
				{

					for(int j=0;j<rowCount+1;j++)
					{

						Row row=sheet.getRow(j);
						int colCount=row.getLastCellNum()-row.getFirstCellNum();
						if(colCount!=0)
						{

							String []data=new String[colCount];
							for (int k=0;k<colCount;k++)
							{

								Cell cell=row.getCell(k);

								try
								{
									data[k]=cell.getStringCellValue();
								}
								catch(Exception e)
								{
									data[k]=new Integer((int)cell.getNumericCellValue()).toString();
								}





							}
							if(data!=null)
							{


								for(String str:data)
								{
									System.out.print(str +" ");
								}
								System.out.println();
							}
						}

					}

				}


			}
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}





		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void readUsingIterator()
	{ 

		FileInputStream fis;
		try 
		{
			fis = new FileInputStream(System.getProperty("user.dir")+"/new.xlsx");
			XSSFWorkbook wb= new XSSFWorkbook(fis);
			int numberOfSheets = wb.getNumberOfSheets();


			for(int i=0; i < numberOfSheets; i++)
			{

				Sheet sheet = wb.getSheetAt(i);
				Iterator<Row> rowIterator = sheet.iterator();
				while (rowIterator.hasNext()) 
				{
					Row row = rowIterator.next();

					// For each row, iterate through each columns
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) 
					{

						Cell cell = cellIterator.next();

						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							System.out.print(cell.getStringCellValue() + "\t");
							break;
						case Cell.CELL_TYPE_NUMERIC:
							System.out.print(cell.getNumericCellValue() + "\t");
							break;
						case Cell.CELL_TYPE_BOOLEAN:
							System.out.print(cell.getBooleanCellValue() + "\t");
							break;
						default :

						}
					}
					System.out.println();
				}
			}
		}
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}





		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}


	public static void main(String argv[])
	{
		CreateAndWriteAndRead.createExcel();
		//CreateAndWriteAndRead.read();
		CreateAndWriteAndRead.readUsingIterator();
	}
}
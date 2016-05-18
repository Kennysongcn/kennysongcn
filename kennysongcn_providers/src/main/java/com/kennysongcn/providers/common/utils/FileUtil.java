package com.kennysongcn.providers.common.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.kennysongcn.providers.common.model.Temporary;


/**
 * 文件读取
 * @author wangyulong
 *
 */
public class FileUtil<T> {
		
		/**
		 * exl文件内容读取并且转换成对象
		 * @return
		 */
		public static ArrayList<Temporary> exlToObj(FileInputStream fin,String type)
		{
			//读取数据的集合
			ArrayList<Temporary> list = new ArrayList<Temporary>();
			try {
		            XSSFWorkbook workbook = new XSSFWorkbook(fin);// 创建工作薄
		            XSSFSheet sheet = workbook.getSheetAt(0);// 得到工作表
//		            XSSFRow row = null;// 对应excel的行
		            XSSFCell cell = null;// 对应excel的列
		            int totalRow = sheet.getLastRowNum();// 得到excel的总记录条数
		            int coloumNum=sheet.getRow(0).getPhysicalNumberOfCells();//获得总列数
//		            System.out.println(totalRow+":"+coloumNum);
		            DecimalFormat df = new DecimalFormat("#");
		            for (int i = 1; i <= totalRow; i++) {
		            	Temporary vo = new Temporary();
		            	//xls类型
		            	vo.setType(type);
		            	for(int j = 0; j <= coloumNum; j++)
		            	{
		            		cell = sheet.getRow(i).getCell(j);
		            		Field field = vo.getClass().getDeclaredField("column"+j);
		            		field.setAccessible(true);
		            		String value = null;
		            		
		            		if(cell == null)
		            		{
		            			continue;
		            		}
		            		//判定是数字
		            		else if(HSSFCell.CELL_TYPE_NUMERIC == cell.getCellType())
		            		{
		            				//是否日期类型
			            			if(HSSFDateUtil.isCellDateFormatted(cell)){
			            				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			            				value = sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue())).toString();
			            			}
			            			else{
			            				value = df.format(cell.getNumericCellValue());
				            		}
		            		}
		            			
		            		else{
		            			if(StringUtils.isEmpty(cell.toString()))
		            			{
		            				continue;
		            			}
		            			value = cell.toString();
		            		}
		            		field.set(vo, value);

		            	}
		            	list.add(vo);
		            }
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally{
				try {
					fin.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			return list;
		}
		
		
		//生成xls文件
		@SuppressWarnings("unused")
		public  String createExcelFile(String[] tile,String[] column,List<T> list) {
					 String excelPath = "D:/"+System.currentTimeMillis()+".xlsx";
			         boolean isCreateSuccess = false;
			         Workbook workbook = null;
			         FileOutputStream outputStream = null;
			         try {
			             workbook = new XSSFWorkbook();
			         
			         if(workbook != null) {
			             Sheet sheet = workbook.createSheet("testdata");
			             Row row0 = sheet.createRow(0);
			             for(int i = 0; i < tile.length; i++) {
			                 Cell cell_1 = row0.createCell(i, Cell.CELL_TYPE_STRING);
			                 CellStyle style = getStyle(workbook);
			                 cell_1.setCellStyle(style);
			                 cell_1.setCellValue(tile[i]);
			                 //sheet.setColumnWidth(i, (short)tile[i].length()*256);
			                 sheet.autoSizeColumn(i);
			                 
			             }
			             for (int rowNum = 0; rowNum < list.size(); rowNum++) {
			            	 T vo = list.get(rowNum);
			                 Row row = sheet.createRow(rowNum+1);
			                 for(int i = 0; i < column.length; i++) {
			                     Cell cell = row.createCell(i, Cell.CELL_TYPE_STRING);
			                     Method m = (Method) vo.getClass().getMethod("get" + captureName(column[i]));
			                     //设置值
			                     if(m.invoke(vo) != null)
			                     {
			                    	 cell.setCellValue(m.invoke(vo).toString());
			                     }
			                     else {
			                    	 cell.setCellValue("");
			                     }
			                    
			                 }
			             }
			            
		                 outputStream = new FileOutputStream(excelPath);
		                 workbook.write(outputStream);
		                 outputStream.flush();
		                 outputStream.close();
		                 isCreateSuccess = true;
			        }
			       }
			         catch(Exception e) {
			             System.out.println("It cause Error on CREATING excel workbook: ");
			             e.printStackTrace();
			       }
			        finally{
			        	try {
							outputStream.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			        }
			         return excelPath;
//			         File sss = new File(excelPath);
//			         System.out.println(sss.getAbsolutePath());
			        
			     }
			     private static CellStyle getStyle(Workbook workbook){
			         CellStyle style = workbook.createCellStyle();
			         style.setAlignment(CellStyle.ALIGN_CENTER); 
			         style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
			         // 设置单元格字体
			         Font headerFont = workbook.createFont(); // 字体
			         headerFont.setFontHeightInPoints((short)14);
			         headerFont.setBoldweight((short)60);
			         //headerFont.setColor(HSSFColor.RED.index);
			         headerFont.setFontName("宋体");
			         style.setFont(headerFont);
			         
			         // 设置单元格边框及颜色
			         style.setBorderBottom((short)1);
			         style.setBorderLeft((short)1);
			         style.setBorderRight((short)1);
			         style.setBorderTop((short)1);
			         style.setWrapText(true);
			         return style;
			     }
			     
		/**
		 * 首字母大写	     
		 * @param name
		 * @return
		 */
		public  String captureName(String name) {
			   char[] cs=name.toCharArray();
			   cs[0]-=32;
			   return String.valueOf(cs);
		}	     
		
		@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
		public static void main(String[] args) {
			FileInputStream fie;
			try {
//				fie = new FileInputStream("C:/Users/Administrator/Desktop/xxxxxx.xlsx");
//				fie = new FileInputStream("D:/test.xlsx");
//				ArrayList<Temporary> list = FileUtil.exlToObj(fie,"报关保险");
//				System.out.println(list.size());
				
				Temporary obj1 = new Temporary();
				obj1.setColumn0("1111111");
				obj1.setColumn1("2015-06-12");
				Temporary obj2 = new Temporary();
				obj2.setColumn0("1111111");
				obj2.setColumn1("2015-06-12");
				ArrayList<Temporary> list =  new ArrayList<Temporary>();
				list.add(obj1);
				list.add(obj2);
				String[] tile = {"编号","日期"};
				String[] column = {"column0","column1"};
				
				FileUtil util = new FileUtil<Temporary>();
				util.createExcelFile(tile,column,list);
//				System.out.println(System.currentTimeMillis());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
}

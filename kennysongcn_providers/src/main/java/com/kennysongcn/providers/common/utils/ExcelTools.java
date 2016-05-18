package com.kennysongcn.providers.common.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ExcelTools
{

	// 创建头信息样式
	private static HSSFCellStyle headerstyle;

	// 创建标题样式
	private static HSSFCellStyle titlestyle;

	private static Logger logger = LoggerFactory.getLogger(ExcelTools.class);

	/**
	 * 
	 * @param <T>
	 * @param c
	 * @param sheetName
	 * @param titlename
	 * @param maps
	 * @return
	 * @throws IOException
	 *             返回类型： HSSFWorkbook
	 */
	public static <T> HSSFWorkbook ObjectToWorkBook(Class<T> c,
			String sheetName, String titlename, List<Map<String, Object>> maps) throws IOException
	{
		try
		{
			String className = c.getSimpleName();
			Properties properties = PropertiesUtil.getProperties("/Column_"
					+ className + ".properties");
			HSSFWorkbook workBook = new HSSFWorkbook();
			HSSFCellStyle cellstyle = getTitleStyle(workBook, "cellstyle");

			Sheet sheet = workBook.createSheet(sheetName);
			sheet.setDefaultRowHeightInPoints(20);
			// 创建头信息样式
			headerstyle = getTitleStyle(workBook, "headerstyle");

			// 创建标题样式
			titlestyle = getTitleStyle(workBook, "titlestyle");

			List<String> keys = new ArrayList<String>(Arrays.asList(maps.get(0)
					.keySet().toArray(new String[] {})));
			List<String> propertieskeys = new ArrayList<String>(
					Arrays.asList(properties.keySet().toArray(new String[] {})));
			keys.retainAll(propertieskeys);

			// 创建标题
			Row headerRow = sheet.createRow(0);
			headerRow.setHeightInPoints(30);
			Cell headerCell = headerRow.createCell(0);
			headerCell.setCellStyle(headerstyle);
			headerCell.setCellValue(titlename);
			sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, keys.size() - 1));

			// 创建表头
			Row rowTitle = sheet.createRow(1);
			int keyscount = keys.size();
			for (int j = 0; j < keyscount; j++)
			{
				String titleName = (String) properties.getProperty(keys.get(j),
						keys.get(j));
				rowTitle.setHeightInPoints(20);
				Cell cell = rowTitle.createCell(j);
				cell.setCellStyle(titlestyle);
				cell.setCellValue(new String(titleName.getBytes("iso8859-1"),"utf-8"));
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			}
			Row row = null;
			int rowTotalNum = maps.size() + 2;

			// 创建Excel内容
			for (int i = 2, p = 0; i < rowTotalNum; i++)
			{
				Map<String, Object> tempMap = maps.get(p);
				row = sheet.createRow(i);
				row.setHeightInPoints(row.getHeightInPoints());
				

				
					for (int j = 0; j < keyscount; j++)
					{
						Cell cell = row.createCell(j);
						Object cellV = tempMap.get(keys.get(j));
						if (cellV instanceof Number)
						{
							cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
							cellV = cellV == null ? 0d : cellV;
							cell.setCellValue(((Number) cellV).doubleValue());
						} else
						{
							cell.setCellType(HSSFCell.CELL_TYPE_STRING);
							cellV = cellV == null ? "" : cellV;
							cell.setCellValue(cellV + "");
						}
						cell.setCellStyle(cellstyle);
					}

				p++;
			}
			// 自动调整列宽
			row = sheet.createRow(rowTotalNum);
			for (int j = 0; j < keyscount; j++)
			{
				Cell cell = row.createCell(j);
				sheet.autoSizeColumn(cell.getColumnIndex());
				if (sheet.getColumnWidth(cell.getColumnIndex()) < 20 * 256)
				{
					sheet.setColumnWidth(cell.getColumnIndex(), 20 * 256);
				}else{
					sheet.setColumnWidth(cell.getColumnIndex(), 20 * 512);
				}
			}
			return workBook;
		} catch (Exception ex)
		{
			ex.printStackTrace();
			logger.error("导出报表发生异常", ex);
			return null;
		}
	}

	public static void writeWorkBook(String fileName,
			HttpServletRequest request, HttpServletResponse response,
			HSSFWorkbook workBook) throws UnsupportedEncodingException,
			IOException
	{
		// 最后输出Excel
		String userAgent = request.getHeader("user-agent");
		// 把生成的excel文件进行转码
		if (userAgent.toLowerCase().indexOf("firefox") != -1)
		{
			fileName = new String(fileName.getBytes(), "iso8859-1");
		} else
		{
			fileName = URLEncoder.encode(fileName, "utf-8");
		}
		// 设置响应头信息
		response.setContentType("application/vnd.ms-excel");
		// "contentDisposition">attachment;filename="${downName}"
		response.setHeader("content-Disposition", "attachment;filename="
				+ fileName + ".xls");
		workBook.write(response.getOutputStream());
	}

	
	
	/**
	 * 
	 * @param cls
	 * @param filename
	 * @param sheetName
	 * @param titleName
	 * @param maps
	 * @param request
	 * @param response
	 * @throws IOException
	 *             返回类型： void
	 */
	public static void ObjectToExcel(Class<?> cls, String filename,
			String sheetName, String titleName, List<Map<String, Object>> maps,
			HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		HSSFWorkbook workbook = ObjectToWorkBook(cls, sheetName, titleName,maps);
		writeWorkBook(filename, request, response, workbook);
	}

	public static HSSFCellStyle getTitleStyle(HSSFWorkbook workBook,
			String styleType)
	{
		HSSFPalette palette = workBook.getCustomPalette();
		palette.setColorAtIndex((short) 60, (byte) (204), (byte) (255),
				(byte) (255));
		palette.setColorAtIndex((short) 61, (byte) (255), (byte) (255),
				(byte) (153));
		palette.setColorAtIndex((short) 62, (byte) (255), (byte) (204),
				(byte) (153));

		HSSFCellStyle style = workBook.createCellStyle();
		style.setWrapText(true);
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		if ("headerstyle".equalsIgnoreCase(styleType))
		{
			HSSFFont headFont = workBook.createFont();
			headFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
			headFont.setFontHeightInPoints((short) 12);
			style.setFont(headFont);
			//style.setFillPattern(HSSFCellStyle.THICK_FORWARD_DIAG);
			
			style.setBottomBorderColor(HSSFColor.BLACK.index);
			style.setBorderLeft(HSSFCellStyle.BORDER_NONE);
			style.setBorderRight(HSSFCellStyle.BORDER_THIN);
			style.setBorderTop(HSSFCellStyle.BORDER_NONE);
			style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		} else if ("titlestyle".equalsIgnoreCase(styleType))
		{
			HSSFFont titlefont = workBook.createFont();
			titlefont.setBoldweight(Font.BOLDWEIGHT_BOLD);
			titlefont.setFontHeightInPoints((short) 10);

			style.setFont(titlefont);
			style.setFillForegroundColor((short) 60);
			style.setFillBackgroundColor((short) 60);
			style.setFillPattern(HSSFCellStyle.THICK_FORWARD_DIAG);

			style.setBottomBorderColor(HSSFColor.BLACK.index);
			style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			style.setBorderRight(HSSFCellStyle.BORDER_THIN);
			style.setBorderTop(HSSFCellStyle.BORDER_THIN);
			style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		} else if ("cellstyle".equalsIgnoreCase(styleType))
		{
			HSSFFont titlefont = workBook.createFont();
//			titlefont.setBoldweight(Font.BOLDWEIGHT_BOLD);
			titlefont.setFontHeightInPoints((short) 10);
			style.setFont(titlefont);
			style.setBottomBorderColor(HSSFColor.BLACK.index);
			style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			style.setBorderRight(HSSFCellStyle.BORDER_THIN);
			style.setBorderTop(HSSFCellStyle.BORDER_THIN);
			style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		}/* else if("cellargsstyle".equalsIgnoreCase(styleType)){
			style.setAlignment(CellStyle.ALIGN_LEFT);
			HSSFFont titlefont = workBook.createFont();
			titlefont.setFontHeightInPoints((short) 10);
			style.setFont(titlefont);
			style.setBottomBorderColor(HSSFColor.BLACK.index);
			style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			style.setBorderRight(HSSFCellStyle.BORDER_THIN);
			style.setBorderTop(HSSFCellStyle.BORDER_THIN);
			style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		}*/
		return style;
	}

}
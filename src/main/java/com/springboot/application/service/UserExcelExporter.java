package com.springboot.application.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.springboot.application.model.Usuario;

public class UserExcelExporter {
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private List<Usuario> listUsuarios;
	
	public UserExcelExporter(List<Usuario> listUsuarios) {
		this.listUsuarios = listUsuarios;
		workbook = new XSSFWorkbook();
	}
	
	private void writeHeaderLine() {
		sheet = workbook.createSheet("Usuarios");
		
		Row row = sheet.createRow(0);
		
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);
		
		createCell(row, 0, "Usuário ID", style);
		createCell(row, 1, "Nome", style);
		createCell(row, 2, "E-mail", style);
		createCell(row, 3, "Nome De Usuário", style);
		createCell(row, 4, "Filial", style);
		createCell(row, 5, "Setor", style);
		createCell(row, 6, "Função", style);		
				
	}
	
	private void createCell(Row row, int columnCount, Object value, CellStyle style) {
		sheet.autoSizeColumn(columnCount);
		Cell cell = row.createCell(columnCount);
		if(value instanceof Integer) {
			cell.setCellValue((Integer) value);
		}else if(value instanceof Boolean) {
			cell.setCellValue((Boolean) value);
		}else {
			cell.setCellValue((String) value);
		}
		cell.setCellStyle(style);
	}
	
	private void writeDataLines() {
		int rowCount = 1;
		
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);
		
		for (Usuario usuario : listUsuarios) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;
			
			createCell(row, columnCount++, usuario.getId().toString(), style);
			createCell(row, columnCount++, usuario.getNome(), style);
			createCell(row, columnCount++, usuario.getEmail(), style);
			createCell(row, columnCount++, usuario.getNomeUsuario(), style);
			createCell(row, columnCount++, usuario.getFilial(), style);
			createCell(row, columnCount++, usuario.getSetor(), style);
			createCell(row, columnCount++, usuario.getFuncao(), style);
		}
	}
	
	public void export(HttpServletResponse response) throws IOException {
		writeHeaderLine();
		writeDataLines();
		
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		//workbook.c();
		
		outputStream.close();
	}
	
}

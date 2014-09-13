package uow.ia.report.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import uow.ia.action.BaseAction;
import uow.ia.bean.AccommodationTypes;
import uow.ia.bean.Contacts;

public class ReportAction extends BaseAction{
	
	private List<AccommodationTypes> list;
	private List<Contacts> contact;
	
	/**
	 * @return the contact
	 */
	public List<Contacts> getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(List<Contacts> contact) {
		this.contact = contact;
	}

	/**
	 * @return the list
	 */
	public List<AccommodationTypes> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<AccommodationTypes> list) {
		this.list = list;
	}

	public String report(){
		contact = services.findContacts();
		return SUCCESS;
	}
	
	public String downloadExcel() {
		
		list = services.findAccommodationTypes();
		
		System.out.println(list.size());
		
		try{
			String filename = "/Users/Kimto/data.xls";
			HSSFWorkbook hwb = new HSSFWorkbook();
			HSSFSheet sheet =  hwb.createSheet("new sheet");

			HSSFRow rowhead=   sheet.createRow((short)0);
			rowhead.createCell(0).setCellValue("Id");
			rowhead.createCell(1).setCellValue("Accommodation Name");
			rowhead.createCell(2).setCellValue("Accommodation Description");
			
			int index = 1;
			for (AccommodationTypes c : list) {
				HSSFRow row=   sheet.createRow(index);
				row.createCell(0).setCellValue(c.getId().toString());
				row.createCell(1).setCellValue(c.getAccommodationName());
				row.createCell(2).setCellValue(c.getAccommodationDescription());
				index++;
			}
			FileOutputStream fileOut =  new FileOutputStream(filename);
			hwb.write(fileOut);
			fileOut.close();
			System.out.println("Your excel file has been generated!");

		} catch ( Exception ex ) {
		    System.out.println(ex);

		}
		
		return SUCCESS;
	}

}

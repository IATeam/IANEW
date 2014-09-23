package uow.ia.test.hibernate;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ManagedSessionContext;
import org.hibernate.metamodel.Metadata;
import org.hibernate.metamodel.source.annotations.entity.EntityClass;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import java.lang.reflect.*;

import javax.persistence.EntityManager;

import uow.ia.bean.*;

/*
 * Testing apache poi
 * 
 * @author Kim To
 * @version 1.0.0, 06/09/2014
 */
public class createExcelFileTest {
	private Logger logger = Logger.getLogger(AccommodationTypesTest.class);
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private static ServiceRegistry serviceRegistry;
	
	@Test
	public void f() {
		try{
			String filename = "data.xls";
			HSSFWorkbook hwb=new HSSFWorkbook();
			HSSFSheet sheet =  hwb.createSheet("new sheet");

			HSSFRow rowhead=   sheet.createRow((short)0);
			rowhead.createCell(0).setCellValue("Id");
			rowhead.createCell(1).setCellValue("First Name");
			rowhead.createCell(2).setCellValue("Lastname");
			rowhead.createCell(3).setCellValue("Email");
			rowhead.createCell(4).setCellValue("Accommocation");
			
			int index = 1;
			List<Contacts> contactList = session.createQuery("from Contacts").list();
			for (Contacts c : contactList) {
				HSSFRow row=   sheet.createRow(index);
				row.createCell(0).setCellValue(c.getId().toString());
				row.createCell(1).setCellValue(c.getFirstname());
				row.createCell(2).setCellValue(c.getLastname());
				row.createCell(3).setCellValue(c.getEmail());
				if (c.getAccommodation() != null) {
					row.createCell(4).setCellValue(c.getAccommodation().getAccommodationName());
				} else {
					row.createCell(4).setCellValue("");
				}
				index++;
			}
		FileOutputStream fileOut =  new FileOutputStream(filename);
		hwb.write(fileOut);
		fileOut.close();
			
//			Method[] list = Contacts.class.getDeclaredMethods();
//			Contacts contact = (Contacts)session.get(Contacts.class, 1);
//			//Field[] field = Contacts.class.getDeclaredFields();
//			for (Class c : Configuration.class.getClasses()) {
//				System.out.println(c.getName());
//			}
			
//			for (Field f : field) {
//				System.out.println(f.getName());
//				Object object = f.get(contact);
//			}
//			for (Method m : list) {
//				System.out.println(m.getName());
//				Class type = (Class) m.getReturnType();
//				if (m.toString().equals("public java.lang.String uow.ia.bean.Contacts.getLastname()")) {
//						Object object = m.invoke(contact, null);
//						
//						System.out.println(type.toString());
//						System.out.println(object.toString());
//				}
//			}
			System.out.println("Your excel file has been generated!");

		} catch ( Exception ex ) {
		    System.out.println(ex);

		}
	}
	
	@AfterMethod
	public void afterMethod() {
		logger.debug("destroy session facotry");
		session.close();
		ManagedSessionContext.unbind(sessionFactory);
	}

	@BeforeMethod
	public void beforeMethod() {
		logger.debug("init session facotry");
		Configuration configuration = new Configuration().configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		session = sessionFactory.openSession();
		ManagedSessionContext.bind(session);
	}
}

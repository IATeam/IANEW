package uow.ia.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

/**
 * @author Kim To
 */
@Indexed
public class DangerTypes implements java.io.Serializable {

	@DocumentId
	private Integer id;
	
	@Field
	private String dangerName;
	
	private String dangerDescription;
	
	private String symbol;
	
	private Integer displayOrder;
	
	private List<Contacts> contactsList = new ArrayList<Contacts>();

	public DangerTypes() {
	}

	public DangerTypes(String dangerName, String dangerDescription,
			String symbol, Integer displayOrder) {
		this.dangerName = dangerName;
		this.dangerDescription = dangerDescription;
		this.symbol = symbol;
		this.displayOrder = displayOrder;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDangerName() {
		return this.dangerName;
	}

	public void setDangerName(String dangerName) {
		this.dangerName = dangerName;
	}

	public String getDangerDescription() {
		return this.dangerDescription;
	}

	public void setDangerDescription(String dangerDescription) {
		this.dangerDescription = dangerDescription;
	}

	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Integer getDisplayOrder() {
		return this.displayOrder;
	}

	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}

	/**
	 * @return the contactsList
	 */
	public List<Contacts> getContactsList() {
		return this.contactsList;
	}

	/**
	 * @param contactsList the contactsList to set
	 */
	public void setContactsList(List<Contacts> contactsList) {
		this.contactsList = contactsList;
	}

}

package uow.ia.bean;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

/**
 * DocumentLinks generated by hbm2java
 * 
 * @author KimTo
 */
//@Indexed
public class DocumentLinks implements java.io.Serializable {

	//@DocumentId
	private Integer id;
	
	//@Field
	private String link;
	
	//@Field
	private String name;

	public DocumentLinks() {
	}

	public DocumentLinks(String link, String name) {
		this.link = link;
		this.name = name;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

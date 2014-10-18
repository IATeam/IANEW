package uow.ia.search;

public class SearchNode {
	private String ref;
	private String value;
	
	public SearchNode(String ref, String value) {
		super();
		this.ref = ref;
		this.value = value;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	public String toString(){
		return ref + ":" + value;
	}
	
}

package uow.ia.service;

import java.util.Map;

import org.hibernate.metadata.ClassMetadata;
import org.hibernate.search.FullTextSession;

public interface UtilService {
	public static final String SERVICENAME = "UtilService";
	
	public Map<String, ClassMetadata> getAllClassMetadata();
	
	public FullTextSession getFullTextSession();
}

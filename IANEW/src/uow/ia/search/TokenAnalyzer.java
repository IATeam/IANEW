package uow.ia.search;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.springframework.context.ApplicationContext;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.opensymphony.xwork2.ActionContext;
import com.sun.research.ws.wadl.Request;

public class TokenAnalyzer {
	private String searchString;
	private Class<?> entity;
	private Set<String> fullPathSet = new HashSet<String>();
	

	public TokenAnalyzer(Class<?> entity, String searchString) {
		this.entity = entity;
		this.searchString = lowerCasing(searchString);
	}

	public String xpathing(Document doc) throws Exception {
//		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//		factory.setNamespaceAware(true);
//		DocumentBuilder builder = factory.newDocumentBuilder();
//		
//		String path = "ianewPathDictionary.xml";
//		
//		//ApplicationContext appContext;
//		//appContext.getResource("classpath:uow/ia/search/ianewPathDictionary.xml");
//		//InputStream is = 
//		
//		
//		
//		Document doc = builder.parse(getClass().getResourceAsStream(path));

		XPathFactory xpathfactory = XPathFactory.newInstance();
		XPath xpath = xpathfactory.newXPath();
		try {
			dddd(doc, xpath);
			return this.searchString;
		} catch (NullPointerException e) {
		}
		return this.searchString;
	}

	private String lowerCasing(String string) {
		if ((string.length() < 1) || (string.contains("[^a-zA-Z/d]")))
			return this.searchString;
		String[] split = string.split(" ");
		String returnString = "";
		for (String s : split) {
			if (!isReservedWord(s))
				returnString += s.toLowerCase() + " ";
			else {
				returnString += s + " ";
			}
		}
		return returnString;
	}

	private ArrayList<String> getAsterizedSearchStringAsList() {
		ArrayList<String> modifiedSearchStringList = new ArrayList<String>();
		String[] colonSplit = this.searchString.trim().split(":");
		int colonSize = colonSplit.length;

		if (colonSize > 1) {
			for (int i = 0; i < colonSize; i++) {
				if (i < colonSize - 1)
					modifiedSearchStringList.add(assignAsterixes(colonSplit[i],true));
				else
					modifiedSearchStringList.add(assignAsterixes(colonSplit[i],false));
			}
		} else {
			modifiedSearchStringList.add(assignAsterixes(colonSplit[0], false));
		}

		return modifiedSearchStringList;
	}

	private void updateSearchString(ArrayList<String> searchStringList) {
		System.out.println(searchString);
		searchString = "";
		for (int i = 0; i < searchStringList.size(); i++)
			searchString += searchStringList.get(i) + " ";
		
		System.out.println(searchString);
	}

	private Map<String, ArrayList<String>> getMappedQuery() {
		Map<String, ArrayList<String>> mappedQuery = new HashMap<String, ArrayList<String>>();
		String[] whiteSplit = null;

		ArrayList<String> asterizedList = getAsterizedSearchStringAsList();
		updateSearchString(asterizedList);

		if (asterizedList.size() > 1) {
			for (int i = 0; i < asterizedList.size(); i++) {
				whiteSplit = ((String) asterizedList.get(i)).split(" ");
				int end = whiteSplit.length - 1;
				if (i < asterizedList.size() - 1) {
					String key = whiteSplit[end];
					String value = null;

					int grpIndex = getGroupTokenPosition(asterizedList.get(i + 1).trim());

					if (grpIndex > 0)
						value = asterizedList.get(i + 1).trim().substring(0, grpIndex);
					else {
						value = asterizedList.get(i + 1).trim().split(" ")[0];
					}

					if (!mappedQuery.containsKey(key))
						mappedQuery.put(key, new ArrayList<String>());
					mappedQuery.get(key).add(value);
				}

			}

			return mappedQuery;
		}
		return null;
	}

	public String assignAsterixes(String string, boolean ignore)
	{
		String[] whiteSplit = string.trim().split(" ");
		int lastSplitIndex = whiteSplit.length - 1;
		String returnString = "";

		for (int i = 0; i < whiteSplit.length; i++)
		{
			if (!whiteSplit[i].contains("*") && ((i == lastSplitIndex && !ignore) || i != lastSplitIndex)){
				
				int lastIndex = whiteSplit[i].length() - 1;
				char lastChar = whiteSplit[i].charAt(lastIndex);
				
				switch (lastChar) {
				case '"':
				case '\'':
				case '(':
				case ')':
				case '/':
				case '[':
				case ']':
				case '{':
				case '}':
					if (whiteSplit[i].length() > 1) {
						String substring = whiteSplit[i].substring(0, lastIndex);

						if (!isReservedWord(substring))
							whiteSplit[i] = whiteSplit[i].replace(substring, substring + "*");
						returnString = returnString + whiteSplit[i] + " ";
					}
					break;
				default:
					if (!isReservedWord(whiteSplit[i])) {
						returnString += whiteSplit[i] + "* ";
					} else {
						returnString += whiteSplit[i] + " "; 
					}
				} 
				
			}else {
				returnString = returnString + whiteSplit[i];
			}
			
		}
		return returnString;
	}

	private void dddd(Document doc, XPath xpath) { 
		String[] whiteSplit = null;

		int indexPtr = 0;
		ArrayList<String> asterizedList = getAsterizedSearchStringAsList();
		updateSearchString(asterizedList);

		Map<String, ArrayList<SearchNode>> pathList = null;

		if (asterizedList.size() > 1) {
			for (int i = 0; i < asterizedList.size(); i++) {
				whiteSplit = asterizedList.get(i).split(" ");
				int end = whiteSplit.length - 1;
				String transformedString = "";

				if (i < asterizedList.size() - 1) {
					String key = whiteSplit[end];
					String queryValue = asterizedList.get(i + 1).trim();
					String originalValue = null;
					int grpIndex = getGroupTokenPosition(asterizedList.get(i + 1).trim());
					String newValue = null;
					if (grpIndex > 0) {
						newValue = queryValue.substring(0, grpIndex);
						originalValue = newValue;
					} else {
						newValue = originalValue = queryValue.split(" ")[0];
					}

					pathList = getAliasName(doc, xpath, key, newValue);

					for (String operator : pathList.keySet()) {
						if (pathList.get(operator).size() > 0) {
							for (SearchNode snode : pathList.get(operator)) {
								ArrayList<String> paths = getPathWithRef(doc, xpath, snode.getRef(), operator);

								if (paths.size() == 1)
									transformedString = (String) paths.get(0) + ":" + snode.getValue() + " ";
								else {
									for (int k = 0; k < paths.size(); k++) {
										if (k == 0)
											transformedString = transformedString
													+ " ("
													+ (String) paths.get(k)
													+ ":"
													+ snode.getValue()
													+ " OR ";
										else if (k == paths.size() - 1)
											transformedString = transformedString
													+ (String) paths.get(k)
													+ ":"
													+ snode.getValue()
													+ ") ";
										else
											transformedString = transformedString
													+ (String) paths.get(k)
													+ ":"
													+ snode.getValue()
													+ " OR ";
									}
								}

								SearchNode lastNode =  pathList.get(operator).get(pathList.get(operator).size() - 1);

								if (!isEqualNode(snode, lastNode)) {
									
									switch (operator) {
									
									case "AND": transformedString = transformedString + " AND "; break;
									case "OR":
									default: transformedString = transformedString + " OR "; break; /*includes null*/
									}
								}
							}
						}
					}
					int beginIndex = this.searchString.indexOf(key, indexPtr);
					int endIndex = this.searchString.indexOf(originalValue, beginIndex) + originalValue.length();
					this.searchString = this.searchString.replace(this.searchString.substring(beginIndex, endIndex), transformedString);
					indexPtr = beginIndex + transformedString.length();
				}
			}
		}
	}

	private boolean isEqualNode(SearchNode n1, SearchNode n2) {
		if (n1 == n2) {
			return true;
		}
		return false;
	}

	private int getGroupTokenPosition(String string) {
		char grpToken = string.charAt(0);
		switch (grpToken) {
		case '"':
			return string.indexOf('"', 1) + 1;
		case '\'':
			return string.indexOf('\'', 1) + 1;
		case '[':
			return string.indexOf(']', 1) + 1;
		case '(':
			return string.indexOf(')', 1) + 1;
		case '{':
			return string.indexOf('}', 1) + 1;
		case '/':
			return string.indexOf('/', 1) + 1;
		}
		return 0;
	}

	private boolean isReservedWord(String word) {
		if ((word.equals("TO")) || (word.equals("AND")) || (word.equals("OR")) || (word.equals("NOT"))) {
			return true;
		}
		return false;
	}

	private Map<String, ArrayList<SearchNode>> getAliasName(Document doc, XPath xpath, String key, String value) {
		Map<String, ArrayList<SearchNode>> aliasNames = new HashMap<String, ArrayList<SearchNode>>();
		aliasNames.put("AND", new ArrayList<SearchNode>());
		aliasNames.put("OR", new ArrayList<SearchNode>());
		aliasNames.put("NULL", new ArrayList<SearchNode>());
		XPathExpression expr = null;
		NodeList nodes = null;
		try {
			expr = xpath.compile("//afield[@alias='" + key + "']");
			nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

			if (nodes.getLength() > 0) {
				expr = xpath.compile("//afield[@alias='" + key + "']/grp[@operator='AND']/ref");
				nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
				if (nodes.getLength() > 0) {
					mapOperator("AND", nodes, aliasNames, value);
				}
				expr = xpath.compile("//afield[@alias='" + key + "']/grp[@operator='OR']/ref");
				nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
				if (nodes.getLength() > 0) {
					mapOperator("OR", nodes, aliasNames, value);
				}
			} else {
				aliasNames.get("NULL").add(new SearchNode(key, value));
			}
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}

		return aliasNames;
	}

	private void mapOperator(String operator, NodeList nodes,
			Map<String, ArrayList<SearchNode>> pathList, String value) {
		for (int i = 0; i < nodes.getLength(); i++) {
			SearchNode snode = null;
			try {
				snode = new SearchNode(nodes.item(i).getFirstChild()
						.getNodeValue(), nodes.item(i).getAttributes()
						.getNamedItem("value").getTextContent());
			} catch (NullPointerException np) {
				snode = new SearchNode(nodes.item(i).getFirstChild()
						.getNodeValue(), value);
			}
			pathList.get(operator).add(snode);
		}
	}

	private ArrayList<String> getPathWithRef(Document doc, XPath xpath,
			String ref, String operator) {
		ArrayList<String> pathList = new ArrayList<String>();
		XPathExpression expr = null;
		try {
			String entityName = "";
			if (this.entity != null) {
				entityName = "='" + this.entity.getSimpleName() + "'";
			}
			expr = xpath.compile("//field[@id='" + ref + "']/entity[@name" + entityName + "]/path/text() | //entity[@name" + entityName + "]/path[@id='" + ref + "']/text()");

			NodeList nodes = (NodeList) expr.evaluate(doc,
					XPathConstants.NODESET);
			if (nodes.getLength() > 0) {
				for (int i = 0; i < nodes.getLength(); i++)
					if (!this.fullPathSet.contains(nodes.item(i).getNodeValue()
							.toString())) {
						this.fullPathSet.add(nodes.item(i).getNodeValue()
								.toString());
						pathList.add(nodes.item(i).getNodeValue().toString());
					}
			} else
				pathList.add(ref);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}

		return pathList;
	}
}
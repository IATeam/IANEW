package uow.ia.reflection;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field; 
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import uow.ia.bean.Contacts;
import uow.ia.bean.Enquiries;

/** ---------------------------------------------------------------------------------------------
 * @author: Quang Nhan
 * Created Date: 11/09/2014
 * ==============================================
 * Updates:
 * ==============================================
 * Description: This class is used to update an instance from another instance 
 * of an Entity class using reflection. This reflection guarantees that all fields will be
 * visited and assessed and if necessary is updated.
 * 
 * Example: Therea are two instances of an Enquiry Class, one contains the old data whilst the 
 * instance 2 contains the updated data. Some fields have been deleted, some have been
 * set to null, some have been set to empty, and in cases of lists, items have been 
 * added/removed/updated.
 * Calling reflection with instance1 and instance2 as parameters will assessed each fields as
 * either a List field, a field that has the type belonging to Entity Class with substring "Type",
 * a field that has a type belonging to the Entity Class but not containing substring "Type" and
 * fields other fields not in the project's Entity class.
 *
 *----------------------------------------------------------------------------------------------*/
public class Reflection{
	
	private List<String> classNameList = new ArrayList<String>();
	private Object o1 = null;
	private Object o2 = null;
	
	/**
	 * The reflection is called from here
	 * @param o1
	 * @param o2
	 */
	public void updateObject(Object o1, Object o2){
		this.o1 = o1;
		this.o2 = o2;
		
		//TODO: FOR TESTING delete later
		if(o1 instanceof Enquiries){
			System.out.println("Entry o1 " + ((Enquiries)o1).getInquisitor());
		}else if(o1 instanceof Contacts){
			System.out.println("Entry o1 " + ((Contacts)o1).getLastname());
		}
		
		
		System.out.println("Entry Field size: " + o1.getClass().getDeclaredFields().length + " class is: YANG YANG YANG HERE LOOK" + o1.getClass().getSimpleName());
		
		
		//TODO: FOR TESTING delete later
		try {
			classNameList = getClassNameList(this.o1.getClass().getPackage().getName());
			updateMachine(getCategorizedFieldList(o1.getClass()));
		} catch (IOException | URISyntaxException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		
		
		
		if(o1 instanceof Enquiries){
			System.out.println("Exit o1 " + ((Enquiries)o1).getInquisitor());
		}else if(o1 instanceof Contacts){
			System.out.println("Exit o1 " + ((Contacts)o1).getLastname());
		}
	}
	
	/**
	 * Runs the machinery required to update the object
	 * 
	 * @param fList
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 */
	private void updateMachine(List<List<Field>> fList) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException, SecurityException{
		level0Machinery(fList.get(0));
		level1Machinery(fList.get(1));
		level2Machinery(fList.get(2));
		level3Machinery(fList.get(3));
	}
	
	/**
	 * Level 0 Machinery involves handling lower java object fields that are not a project bean entity
	 * types or Lists. 
	 * @param fList
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	private void level0Machinery(List<Field> fList) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		if(fList.size() == 0)
			return;
		
		
		for(Field f: fList){ System.out.println("assessing field: " + f.getName());
			Method[] getterSetters = this.getGetterSetterMethod(f, o2.getClass());
			//System.out.println(getterSetters[0].getName());
			//if ob1 and obj2 equal ignore
			//if ob1 not equal ob2, and obj2 not equal null, then update
			try {
				Object o1Result = invokeGetterMethod(getterSetters[0], o1);
				Object o2Result = invokeGetterMethod(getterSetters[0], o2);
				
				if(!o1Result.equals(o2Result) && o2Result != null){
					System.out.println("changing field " + f.getName());
					invokeSetterMethod(getterSetters[1], o1, (invokeGetterMethod(getterSetters[0], o2)));
				}
			} catch(NullPointerException npe){
				//null is okay
			}
		}
	}
	
	/**
	 * Level 1 Machinery involves handling fields that has substring "Type" in field name.
	 * These are fields that are of Type Entity classes. The algorithm assumes that the
	 * relationship between the parent Entity and the child entity is such that child Entity
	 * is an existing entity and therefore the fields in the child entity between object 1
	 * and object 2 are the same if sharing the same id thus does not require comparison.
	 * 
	 * 
	 * @param fList
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	private void level1Machinery(List<Field> fList) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException, SecurityException{
		if(fList.size() == 0)
			return;
		
		for(Field f: fList){
			runSubClassAssignment(f);
		}
	}
	
	/**
	 * Level 2 Machinery involves handling fields that are project beans (aside from beans that have
	 * "Type" substring). 
	 * 
	 * If Parent and Child has the same entity class, the algorithm works like Entity class having substring
	 * "Type" see {@link #level1Machinery} and {@link #runSubClassAssignment}. Otherwise call the updateMachinery 
	 * again and pass the invoked getter method for the fields of both original objects to reiterate the updateMachine
	 * algorithm.
	 * 
	 * @see #level1Machinery
	 * @param fList List
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	private void level2Machinery(List<Field> fList) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException, SecurityException{
		if(fList.size() == 0)
			return;
		
		//iterate over the fields, invoke the getter for the field and
		//if parent and child entity class is the same, check id.
		//else call updateMachine method again to compute the sub bean fields
		
		for(Field f: fList){
			//System.out.println("In level 2 machinery for " + f.getType().getSimpleName() + " running mother object: " + o1.getClass().getSimpleName());
			runSubClassAssignment(f);
		}
					
	}
	
	/**
	 * Level 3 machinery list fields
	 * The assumption is that there is no list in a list
	 * 
	 * @param fList List
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	private void level3Machinery(List<Field> fList) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException, SecurityException{
		if(fList.size() == 0)
			return;
		
		for(Field f:fList){
			//List<k> this will give the class k
			Class<?> ptClass = getParamClassOfList(f);
			
			Method[] getterSetters = this.getGetterSetterMethod(f, o1.getClass());
			List<List<?>> filteredList = null;
			
			filteredList = getFilteredList(f);
			
			if(ptClass.equals(o1.getClass())){	
				invokeSetterMethod(getterSetters[1], o1, (invokeGetterMethod(getterSetters[0], o2)));
				
			}else{
				//example address list of contact
				//filteredList[0] is o1SameList , filteredList[1] is 02SomeList
				List<Object> o1SList = (List<Object>) filteredList.get(0);
				List<?> o2SList = filteredList.get(1);
				for(int index = 0; index < filteredList.get(0).size(); ++index){
					Reflection ref = new Reflection();
					ref.updateObject(o1SList.get(index), o2SList.get(index));
				}
				
				//add filteredList[2] (o2UpdateList) into o1 list
				List<?> o2UList = filteredList.get(2);
			    List<Object> list = (List<Object>) invokeGetterMethod(getterSetters[0], o1);
			    
				for(Object ob: o2UList){
					
					list.add(ob);
				}	
			}
		}
	}
	
	/**
	 * Returns a list of list of objects containing
	 * 1. o1 list of objects that shares the same id in o2
	 * 2. o2 list of objects that shares the same id in o1
	 * 3. list of objects in o2 that does not exists in o1
	 * called by level3Machinery {@link #level3Machinery(List)}
	 * 
	 * @param f Field
	 * @return List
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	private List<List<?>> getFilteredList(Field f) throws NoSuchFieldException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		List<List<?>> organizedList = new ArrayList<List<?>>();
		List<Object> o1SameObjectList = new ArrayList<Object>();
		List<?> o1DiscardObjectList = new ArrayList<Object>();
		List<Object> o2SameObjectList = new ArrayList<Object>();
		List<?> o2UpdatedObjectList = new ArrayList<Object>();
		
		//lists of idobjects used to compare o1DiscardObjectList and o2UpdateObjectList
		List<Object> o1IdList = new ArrayList<Object>();
		List<Object> o2IdList = new ArrayList<Object>();
		
		//fill o1DiscardedObjects with o1, o2UpdatedObjectList with o2 
		//field Objects invoked by getter method
		Method fGetter = getGetterMethod(f, o1.getClass());
		o1DiscardObjectList = (List<?>)invokeGetterMethod(fGetter, o1);
		o2UpdatedObjectList = (List<?>)invokeGetterMethod(fGetter, o2);
		
			//if the o2UpdatedObjectList is empty then there is no need to update the input field f
		if(o2UpdatedObjectList.isEmpty())
			return null;
		
		//List<k> this will give the class k
		Class<?> ptClass = getParamClassOfList(f);
		
		Field idField = ptClass.getDeclaredField("id");
		Method getterMethod = getGetterMethod(idField, o2UpdatedObjectList.get(0).getClass());
		
		//fill the o2IDList with o2UpdatedObjectList
		for(Object ob: o2UpdatedObjectList){
			Object obID = invokeGetterMethod(getterMethod, ob);
			o2IdList.add(obID);
		}
		
		for(Object ob: o1DiscardObjectList){
			Object obID = invokeGetterMethod(getterMethod, ob);
			o1IdList.add(obID);
		}
		
		System.out.println("Class: " + ptClass.getSimpleName() + " List Size 1: " + o1IdList.size() + " list 2: " + o2IdList.size());
		//System.out.println("DiscardList size: " + o1DiscardObjectList.size());
		//System.out.println("index 1: " + o1DiscardObjectList.get(1));
		for(int o1Index = 0; o1Index < o1IdList.size(); o1Index++){
			//TODO: delete sysout
//			System.out.println("o2 object: " + o2UpdatedObjectList.get(o1Index));
//			System.out.println("o1 object: " + o1DiscardObjectList.get(o1Index));
			int o2Index = o2IdList.indexOf(o1IdList.get(o1Index));
			if(o2Index != -1){
				
				
				o1SameObjectList.add(o1DiscardObjectList.get(o1Index));

				o2IdList.remove(o2Index);
				o2SameObjectList.add(o2UpdatedObjectList.get(o2Index));
				o2UpdatedObjectList.remove(o2Index);
				
			}
		}
		
		organizedList.add(o1SameObjectList);
		organizedList.add(o2SameObjectList);
		organizedList.add(o2UpdatedObjectList);
		
		return organizedList;
	}

	/**
	 * Return a parameter Class of a list object given a Field
	 * http://stackoverflow.com/questions/1942644/get-generic-type-of-java-util-list
	 * @param f Field
	 * @return Class
	 */
	private Class<?> getParamClassOfList(Field f){
		ParameterizedType pt = (ParameterizedType)f.getGenericType();
		return (Class<?>) pt.getActualTypeArguments()[0];
	}
	
	
	/**
	 * Submachine invoked by level machines for checking subFields or invoke subUpdates
	 * 
	 * @param f Field
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	private void runSubClassAssignment(Field f) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException, SecurityException{
		Method[] getterSetters = this.getGetterSetterMethod(f, o1.getClass());
		
		Field subField = f.getType().getDeclaredField("id");
		Method subGetterMethod = getGetterMethod(subField, f.getType());
		
		try {
			Object o1Sub = invokeGetterMethod(getterSetters[0], o1);
			Object o2Sub = invokeGetterMethod(getterSetters[0], o2);
			
			//Similar to Object.getSubObject().getId()
			Object o1TypeID = invokeGetterMethod(subGetterMethod , o1Sub);
			Object o2TypeID = invokeGetterMethod(subGetterMethod , o2Sub);
			
			if(!o1TypeID.equals(o2TypeID)){
				invokeSetterMethod(getterSetters[1], o1, (invokeGetterMethod(getterSetters[0], o2)));
				
			}//if field is of type belonging to entity beans
			else if(classNameList.contains(f.getType().getSimpleName()) && !f.getType().getSimpleName().contains("Type")){
				System.out.println("nesting field is " + f.getName());
				Reflection ref = new Reflection();
				ref.updateObject(o1Sub, o2Sub);
				System.out.println("contact lastname " + ((Contacts)o1Sub).getLastname());
			}
		}catch(NullPointerException npe){
			//null is okay
		}
	}
	/**
	 * Returns a list of field list of a class categorized into 
	 * 
	 * - attributes that contains the string "Type" (List[1])
	 * - attributes that contains type belonging to bean class (List[2]) 
	 * - attributes that has a type List (List[3])
	 * - rest of attributes (List[0])
	 * 
	 * @param Class<?>
	 * @return a list of list of fields
	 */
	private  List<List<Field>> getCategorizedFieldList(Class<?> className){
		List<List<Field>> fieldList = new ArrayList<List<Field>>();
		List<Field> attributeList = new ArrayList<Field>();
		List<Field> typeList = new ArrayList<Field>();
		List<Field> beanList = new ArrayList<Field>();
		List<Field> listList = new ArrayList<Field>();
		
		Field field[] = className.getDeclaredFields();
		
		for(Field f: field){
			
			if(f.getType().equals(List.class))
				
				listList.add(f);
			else {
				if(f.getType().getName().contains("Type"))
					typeList.add(f);
				else if(classNameList.contains(f.getType().getSimpleName()))
					beanList.add(f);
				else
					attributeList.add(f);
			}
		}
		fieldList.add(attributeList);
		fieldList.add(typeList);
		fieldList.add(beanList);
		fieldList.add(listList);
		
		return fieldList;
	}
	
	/**
	 * Returns an Array of Methods of size 2 containing a setter and getter for 
	 * a field of a specified class
	 * Method[0] is the getter, Method[1] is the setter
	 * 
	 * @param Field f
	 * @param Class<?> c
	 * @return Method[] 
	 */
	public  Method[] getGetterSetterMethod(Field f, Class<?> c){
		Method setterGetterMethods[] = {null, null};
		
		Method methods[] = c.getDeclaredMethods();
		String setterMethodName = null;
		String getterMethodName = null;
	
		String firstChar = f.getName().substring(0, 1);
		
		String upper = firstChar.toUpperCase();
		String replacedFieldName = f.getName().replaceFirst(firstChar, upper);
		
		setterMethodName = "set" + replacedFieldName;
		getterMethodName = "get" + replacedFieldName;
		
		for(Method m: methods){
			if(setterGetterMethods[0] == null || setterGetterMethods[1] == null){
				if(m.getName().equals(getterMethodName)){
					//System.out.println("Same: method returned type: " + m.getReturnType() + " field: " + f.getName());
					setterGetterMethods[0] = m;
				}
				if(m.getName().equals(setterMethodName))
					setterGetterMethods[1] = m;
			}
		}
		return setterGetterMethods;
	}
	
	/**
	 * Return a setter method a field of a specified class
	 * 
	 * @param Field f
	 * @param Class<?> c
	 * @return Method
	 */
	public  Method getSetterMethod(Field f, Class<?> c){
		Method methods[] = c.getDeclaredMethods();
	
		String firstChar = f.getName().substring(0, 1);
		String replacedFieldName = f.getName().replaceFirst(firstChar, firstChar.toUpperCase());
		String setterMethodName = "set" + replacedFieldName;
		
		for(Method m: methods){
			if(m.getName().equals(setterMethodName)){
				return m;
			}
		}
		return null;
	}
	
	/**
	 * Return a setter method for a field of a specified class
	 * 
	 * @param Field f
	 * @param Class<?> c
	 * @return Method 
	 */
	public  Method getGetterMethod(Field f, Class<?> c){
		Method methods[] = c.getDeclaredMethods();
	
		String firstChar = f.getName().substring(0, 1);
		String replacedFieldName = f.getName().replaceFirst(firstChar, firstChar.toUpperCase());
		String getterMethodName = "get" + replacedFieldName;
		
		for(Method m: methods){
			if(m.getName().equals(getterMethodName)) 
				return m;
		}
		return null;
	}
	
	/**
	 * Invokes a method
	 * 
	 * @param Method m
	 * @param Object object
	 * @param Object parameters
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public  Object invokeGetterMethod(Method m, Object object) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Object o = new Object();
		o = m.invoke(object, new Object[]{});
		return o;
	}
	
	public  void invokeSetterMethod(Method m, Object object, Object parameter) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		m.invoke(object, parameter);
	}
	
	/**
	 * return a List of String of package names that contains String s
	 * Example project packages are alpha.bean and alpha.util, parameter is "bean", the
	 * method will return a List with containing [alpha.bean].
	 * 
	 * @param String s
	 * @return List<String>
	 */
	public  List<String> getPackageContains(String s){
		List<String> packageList = new ArrayList<String>();
		for(Package p: Package.getPackages())
			if(p.getName().contains(s))
				packageList.add(p.getName());
		return packageList;
	}
	
	/**
	 * return a List of String of class names that is within a package name
	 * 
	 * @param String packageName
	 * @return List<String>
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public List<String> getClassNameList(String packageName) throws IOException, URISyntaxException{
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		URL packageURL; 
		
		packageName = packageName.replace(".", "/");
		packageURL = classLoader.getResource(packageName);
		
		ArrayList<String> names = new ArrayList<String>();
		//System.out.println("package URL: " + packageURL);
		URI uri = new URI(packageURL.toString());
	    File folder = new File(uri.getPath());
        File[] files = folder.listFiles();
        String entryName;
        for(File actual: files){
            entryName = actual.getName();
            if(entryName.contains(".class")){
            	entryName = entryName.substring(0, entryName.lastIndexOf('.'));
            	names.add(entryName);
            }
        }
        return names;
	}
	
	/**
	 * Used to print out the id of a list of Entity objects Used for printing
	 * @param list
	 * @param getter
	 */
	private void printID(List<?> list, Method getter){
		for(Object ob: list){
			try {
				System.out.println("ID: " + invokeGetterMethod(getter, ob));
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}
}
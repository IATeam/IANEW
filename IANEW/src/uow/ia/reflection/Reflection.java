package uow.ia.reflection;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field; 
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import uow.ia.bean.Enquiries;


/** ---------------------------------------------------------------------------------------------
 * @author: Quang Nhan
 * Created Date: 11/09/2014
 * ==============================================
 * Updates:
 * 		12/09/2014 -	Quang Nhan
 * 						Fixed a bug relating to List<?> analysis where it return null from the 
 * 						function call filteredList - added if(filteredList != null)
 * 		13/09/2014 -	Quang Nhan
 * 						Fixed bugs related to condition of checking of field type containing "Type" substring
 * 						in function called runSubClassAssignment(Field) - added f.getType().getSimpleName().contains("Type")
 * 				   -	Added initialization methods for initializing project's Entity class
 * 						and its sub classes.
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
	
	public Object initializeNewModel(Object o1){ System.out.println("Dealing with " + Enquiries.class.getSimpleName());
		this.o1 = o1;
		try {
			this.classNameList = getClassNameList(Enquiries.class.getPackage().getName());
			initializeAllFields(getCategorizedFieldList(Enquiries.class));
		} catch (IOException | URISyntaxException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			
			e.printStackTrace();
		}
		return this.o1;
	}
	
	/**
	 * 
	 * @param fList
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	private void initializeAllFields(List<List<Field>> fList) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		level0Initialization(fList.get(0));
		level1Initialization(fList.get(1));
		level2Initialization(fList.get(2));
		level3Initialization(fList.get(3));
	}
	

	/**
	 * Initialize fields that are not a list, or the project's entity class and not of Integer or SQL date types
	 * 
	 * @param list
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	private void level0Initialization(List<Field> list) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if(list.size() == 0)
			return;
		
		//for each fields instantiate a new instance besides Integers and SQL date
		for(Field f: list){
			System.out.println("uow.ia.Reflecton: Evoking initialization on nested class: " + f.getType().getSimpleName());
			if(!f.getType().isAssignableFrom(Integer.class) && !f.getType().isAssignableFrom(java.sql.Date.class)){
				Method setter = getSetterMethod(f, Enquiries.class);
				invokeSetterMethod(setter, o1, f.getType().newInstance());
			}
		}
	}

	/**
	 * Initialize all fields that are of project's Entity bean class containing substring "Type"
	 * 
	 * @param list
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	private void level1Initialization(List<Field> list) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		if(list.size() == 0)
			return;
		
		for(Field f: list){
			System.out.println("uow.ia.Reflecton: Evoking initialization on nested class: " + f.getType().getSimpleName());
			
			Method setter = getSetterMethod(f, Enquiries.class);
			invokeSetterMethod(setter, o1, f.getType().newInstance());
		}
	}

	/**
	 * Initializes all fields that are of project's Entity Bean class not containing substring "Type"
	 * 
	 * @param list
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	private void level2Initialization(List<Field> list) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		//bean class that does not have "Type" substring
		if(list.size() == 0)
			return;
		
		for(Field f: list){
			System.out.println(f.getName());
				
			if(f.getType() != Enquiries.class){ 
				System.out.println("uow.ia.Reflecton: Evoking initialization on nested class: " + f.getType().getSimpleName());
				Method setter = getSetterMethod(f, Enquiries.class);
				invokeSetterMethod(setter, o1, f.getType().newInstance());
				
				Method getter = getGetterMethod(f, Enquiries.class);
				
				Reflection ref = new Reflection();
				ref.initializeNewModel(invokeGetterMethod(getter, o1));
			}
		}
	}

	/**
	 * Initialization of fields that are of type List<?>
	 * 
	 * @param list
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 */
	private void level3Initialization(List<Field> list) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if(list.size() == 0)
			return;
		for(Field f: list){
			System.out.println("uow.ia.Reflecton: initializing field: " + f.getName());
			
			Method[] getterSetter = getGetterSetterMethod(f, Enquiries.class);
			
			//Object param =  Array.newInstance(f.getType(), 1);
			
			invokeSetterMethod(getterSetter[1], o1, new ArrayList<Object>());
			//Class<?> class1 = getParamClassOfList(f);
			//Reflection ref = new Reflection();
			//ref.initializeNewModel(invokeGetterMethod(getterSetter[0], o1));
		}
	}

	/**
	 * The reflection to assign values of o2 to o1 object called from here
	 * @param o1
	 * @param o2
	 */
	public void updateObject(Object o1, Object o2){
		this.o1 = o1;
		this.o2 = o2;
		try {
			this.classNameList = getClassNameList(Enquiries.class.getPackage().getName());
			updateMachine(getCategorizedFieldList(Enquiries.class));
		} catch (IOException | URISyntaxException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
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
		System.out.println("level0machine List " + fList);
		
		for(Field f: fList){ 
			Method[] getterSetters = this.getGetterSetterMethod(f, o2.getClass());
			//if ob1 and obj2 equal ignore
			//if ob1 not equal ob2, and obj2 not equal null, then update
			System.out.println(fList.size());
			//System.out.println("Methods " + getterSetters[0].toString());
			System.out.println(fList.size());
			Object o1Result = null; 
			Object o2Result = null;
			
			try { o1Result = invokeGetterMethod(getterSetters[0], o1); } 
			catch(NullPointerException npe){ /*null is okay*/}
			
			try { o2Result = invokeGetterMethod(getterSetters[0], o2); } 
			catch(NullPointerException npe){ /*null is okay*/ }
			
			if(o1Result != o2Result && o2Result != null){
				System.out.println("changing field " + f.getName() + " old value: " + o1Result +  ", to value: " + o2Result);
				invokeSetterMethod(getterSetters[1], o1, (invokeGetterMethod(getterSetters[0], o2)));
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
			runSubClassAssignment(f);
		}
					
	}
	
	/**
	 * Level 3 machinery list fields
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
		System.out.println(Enquiries.class.getSimpleName() + " list list size: " + fList.size() + " and " + fList.toString());
		
		for(Field f:fList){ 
			
			System.out.println("Parent object: " + Enquiries.class.getSimpleName() + " ListField level3Machinery: " + f.getName());
			
			//List<k> this will give the class k
			Class<?> ptClass = getParamClassOfList(f);
			
			Method[] getterSetters = this.getGetterSetterMethod(f, Enquiries.class);
			List<List<?>> filteredList = null;
			
			filteredList = getFilteredList(f);
			if(filteredList != null){
				System.out.println("PTCLASS: " + ptClass);
				if(ptClass.equals(Enquiries.class)){	
					invokeSetterMethod(getterSetters[1], o1, (invokeGetterMethod(getterSetters[0], o2)));
					
				}else{
					//example address list of contact
					//filteredList[0] is o1SameList , filteredList[1] is 02SomeList
					
					List<Object> o1SList = (List<Object>) filteredList.get(0);
					List<Object> o2SList = (List<Object>) filteredList.get(1);
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
		Method fGetter = getGetterMethod(f, Enquiries.class);
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

		for(int o1Index = 0; o1Index < o1IdList.size(); o1Index++){

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
		Method[] getterSetters = this.getGetterSetterMethod(f, Enquiries.class);
		
		Field subIDField = f.getType().getDeclaredField("id");
		Method subIDGetterMethod = getGetterMethod(subIDField, f.getType());
		
		Object o1Sub = null;
		Object o2Sub = null;
		Object o1TypeID = null;
		Object o2TypeID = null;
		
		//get the value of the bean field
		try { 
			System.out.println(getterSetters[0].getName());
			o1Sub = invokeGetterMethod(getterSetters[0], o1); 
			
		}
		catch(NullPointerException npe){ /*null is okay*/ }
		
		try { o2Sub = invokeGetterMethod(getterSetters[0], o2); }
		catch(NullPointerException npe){ /*null is okay*/ }
		
		//Similar to Object.getSubObject().getId()
		try { o1TypeID = invokeGetterMethod(subIDGetterMethod , o1Sub); }
		catch(NullPointerException npe){ /*null is okay*/ }
		
		try { o2TypeID = invokeGetterMethod(subIDGetterMethod , o2Sub); }
		catch(NullPointerException npe){ /*null is okay*/ }
		
		System.out.println(o1TypeID + ":" + o2TypeID);
		
		
		//o2 is assigned to the o1 if id of ob1 is not equal to ob2 or 
		//if field type is the same as the class type eg Enquiry and its parentEnquiry or 
		//field type containing substring "Type"
		if(o1TypeID != o2TypeID || f.getType().getName().equals(Enquiries.class.getName()) || f.getType().getSimpleName().contains("Type")){
			invokeSetterMethod(getterSetters[1], o1, (invokeGetterMethod(getterSetters[0], o2)));
			
		}//if field is of type belonging to entity beans
		else if(classNameList.contains(f.getType().getSimpleName())){
			System.out.println("nesting field is " + f.getName());
			
			if(o1Sub == null){
				//evoke the object's constructor
				Class<?> c = f.getType();
				try {
					//sets the field of o1 to new instance
					invokeSetterMethod(getterSetters[1], o1, c.newInstance());
					o1Sub = invokeGetterMethod(getterSetters[0], o1);
				} catch (InstantiationException e) {
					e.printStackTrace();
				}
			}
			Reflection ref = new Reflection();
			ref.updateObject(o1Sub, o2Sub);
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
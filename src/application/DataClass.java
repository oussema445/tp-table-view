package application;

import java.util.ArrayList;
import java.util.List;

public class DataClass {
	List<Person>importList;
	 List<Person>exportList;
	
	
	
	public DataClass() {
		
		importList=new ArrayList<Person>();
		importList.add(new Person("sali" ,"benali","admin@admin"));
		importList.add(new Person("sali" ,"benali","admin@admin"));
		importList.add(new Person("sali" ,"benali","admin@admin"));
		exportList=new ArrayList<Person>();
	}
	public List<Person>getImportList(){
		return importList;
		
	}
	
	public List<Person>getExportList(){
	return exportList;}
	
	
	
	
	public void setImportList(List<Person> importList) {
		this.importList = importList;
	}
	public void setExportList(List<Person> exportList) {
		this.exportList = exportList;
	}
	public void SetExportList(List<Person>exportList) {
		this.exportList.addAll(exportList);
		for(Person p :this.exportList)
			System.out.println(p);
	}
	
	

}

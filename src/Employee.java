
public class Employee {
	String name;
	String adress;
	int id;

	String type;

	public Employee (String name_in, String adress_in, int id_ref, String type_ref){
		this.name = name_in;
		this.adress = adress_in;
		this.id = id_ref;
		this.type = type_ref;
	}

	public int getId() {
		return id;
	}

}

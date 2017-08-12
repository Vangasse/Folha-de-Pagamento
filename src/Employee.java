
public abstract class Employee {
	String name;
	String adress;
	int id;

	String type;

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	public Employee (String name_in, String adress_in, int id_ref, String type_ref){
		this.name = name_in;
		this.adress = adress_in;
		this.id = id_ref;
		this.type = type_ref;
	}

	public int getId() {
		return id;
	}
	
	public abstract void tax(double tax);

}

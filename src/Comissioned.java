
public class Comissioned extends Employee{
	double comission;

	public Comissioned(String name_in, String adress_in, int id_ref, double comission_in){
		super(name_in, adress_in, id_ref, "Comissioned");
		this.comission = comission_in;
	}
}

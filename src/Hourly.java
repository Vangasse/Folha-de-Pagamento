
public class Hourly extends Employee{
	double hour_price;

	public Hourly(String name_in, String adress_in, int id_ref, double hour_price_in){
		super(name_in, adress_in, id_ref, "Hourly");
		this.hour_price = hour_price_in;
	}
}

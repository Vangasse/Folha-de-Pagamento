
public class Salaried extends Employee{
	double month_price;
	double tax;

	public double getMonth_price() {
		return month_price - tax;
	}

	public void tax(double tax) {
		this.tax = tax;
	}

	public Salaried(String name_in, String adress_in, int id_ref, double month_price_in){
		super(name_in, adress_in, id_ref, "Salaried");
		this.month_price = month_price_in;
		this.tax = 0;
	}
}

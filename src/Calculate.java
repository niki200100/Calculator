
public class Calculate {

	private double first;
	private double second;
	
	public Calculate(double first, double second){
		this.first= first;
		this.second= second;
	}
	
	public double addition(){
		return first+second;
	}
	public double subtract(){
		return first-second;
	}
	public double multiply(){
		return first*second;
	}
	public double divide(){
		return first/second;
	}
}

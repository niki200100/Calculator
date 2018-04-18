
public class Control {

	public Gui gui;
	
	public Control(){
		
		gui= new Gui(this);
	}
	public double addition(double first, double second){
		return new Calculate(first, second).addition();
	}
	public double Subtract(double first, double second){
		return new Calculate(first, second).subtract();
	}
	public double Multiply(double first, double second){
		return new Calculate(first, second).multiply();
	}
	public double Divide(double first, double second){
		return new Calculate(first, second).divide();
	}
}

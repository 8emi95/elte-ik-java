public class Termek{
	
	private int id;
	private String product;
	private double procurementPrice;
	private double consumerPrice;
	
	private Termek(int id,String product,double procurementPrice,double consumerPrice){
		this.id = id;
		this.product = product;
		this.procurementPrice = procurementPrice;
		this.consumerPrice = procurementPrice;
	}
	
	public int getId(){
		return this.id;
	}
	
	public String getProduct(){
		return this.product;
	}
	
	public int getProcurementPrice(){
		return this.procurementPrice;
	}
	
	public int getConsumerPrice(){
		return this.consumerPrice;
	}
	
	public setArres(double percent){
		this.consumerPrice = this.procurementPrice * (100 + percent) / 100;
	}
	
	public String toString(){
		return id + ":" + product + "Besz. ar:" + procurementPrice + ", Fogy.ar.:" + consumerPrice + ")";
	}
	
}
package com.creditcardclassification;

public interface CreditCard {
    public void outputToFile();
}
class Visa implements CreditCard{
	public void outputToFile(){
		System.out.println("Visa Card object created");
	}
}
 class Master implements CreditCard{
	public void outputToFile(){
		System.out.println("Master Card object created");
	}
}
 class AmEx implements CreditCard{
	public void outputToFile(){
		System.out.println("American Express Card object created");
	}
}
 class Discover implements CreditCard{
	public void outputToFile(){
		System.out.println("Discover Card object created");
	}
}
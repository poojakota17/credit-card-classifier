package com.creditcardclassification;

public interface CreditCard {
    public void outputToFile();
}
class Visa implements CreditCard{
	public void outputToFile(){
		System.out.println("hello from visa");
	}
}
 class Master implements CreditCard{
	public void outputToFile(){
		System.out.println("hello world");
	}
}
 class AmEx implements CreditCard{
	public void outputToFile(){
		System.out.println("hello world");
	}
}
 class Discover implements CreditCard{
	public void outputToFile(){
		System.out.println("hello world");
	}
}
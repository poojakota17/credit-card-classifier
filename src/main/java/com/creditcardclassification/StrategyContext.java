package com.creditcardclassification;



public class StrategyContext {
    
    FileFormatStrategy strategy;
    public void setStrategy(FileFormatStrategy Strategy){
        this.strategy=Strategy;
    }

    public void executeStrategy(String filename){
        strategy.readfile(filename);
    }
}

package com.creditcardclassification;



public class StrategyContext {
    
    FileFormatStrategy strategy;
    public void setStrategy(FileFormatStrategy Strategy){
        this.strategy=Strategy;
    }

    public void executeStrategy(String inputfilename, String outputfilename){
        strategy.readfile(inputfilename,outputfilename);
    }
}

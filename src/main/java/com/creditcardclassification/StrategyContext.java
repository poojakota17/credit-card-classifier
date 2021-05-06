package com.creditcardclassification;



public class StrategyContext {
    
    FileFormatStrategy strategy;
    public FileFormatStrategy setStrategy(FileFormatStrategy Strategy){

        this.strategy=Strategy;
        return strategy;
    }

    public void executeStrategy(String inputfilename, String outputfilename){
        strategy.readfile(inputfilename,outputfilename);
    }
}

package com.stackextend.websocketbackendexample.model;

import java.util.ArrayList;
import java.util.List;

public class Notifications {

    private int count;
    private List<Stocks>  listofStocks = new ArrayList<Stocks>();
    private String symbol;

    public List<Stocks> getListofStocks() {
    	return listofStocks;
	}
    public void setListofStocks(Stocks listofStocks2) {
		// TODO Auto-generated method stub
    	
    	this.listofStocks.add(listofStocks2);
		
	}
    
    public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Notifications(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void increment() {
        this.count++;
    }

	
}

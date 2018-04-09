package com.stackextend.websocketbackendexample.model;

import java.util.ArrayList;
import java.util.List;

public class Stocks {
	private String symbol;
	private String high;
	private String low;
	private String ltP;
	private String trdVol;
	private String trdVolM;
	private String mVal;
	private String xDt;
	private String dayEndClose;
	private String iislPtsChange;
	
	private List<Stocks>  listofStocks = new ArrayList<Stocks>();

	

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public String getLtP() {
		return ltP;
	}

	public void setLtP(String ltP) {
		this.ltP = ltP;
	}

	public String getTrdVol() {
		return trdVol;
	}

	public void setTrdVol(String trdVol) {
		this.trdVol = trdVol;
	}

	public String getTrdVolM() {
		return trdVolM;
	}

	public void setTrdVolM(String trdVolM) {
		this.trdVolM = trdVolM;
	}

	public String getmVal() {
		return mVal;
	}

	public void setmVal(String mVal) {
		this.mVal = mVal;
	}

	public String getxDt() {
		return xDt;
	}

	public void setxDt(String xDt) {
		this.xDt = xDt;
	}

	public String getDayEndClose() {
		return dayEndClose;
	}

	public void setDayEndClose(String dayEndClose) {
		this.dayEndClose = dayEndClose;
	}

	public String getIislPtsChange() {
		return iislPtsChange;
	}

	public void setIislPtsChange(String iislPtsChange) {
		this.iislPtsChange = iislPtsChange;
	}

	public List<Stocks> getListofStocks() {
		return listofStocks;
	}

	public void setListofStocks(Stocks Stock) {
		this.listofStocks.add(Stock);
	}
	
	
}

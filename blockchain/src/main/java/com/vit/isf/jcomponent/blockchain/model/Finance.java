package com.vit.isf.jcomponent.blockchain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "values")
public class Finance {
	@Id
	String id;
	String exchange;
	String stockSymbol;
	String date;
	Float open;
	Float high;
	Float low;
	Float close;
	Long volume;
	String adjClose;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the exchange
	 */
	public String getExchange() {
		return exchange;
	}
	/**
	 * @param exchange the exchange to set
	 */
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}
	/**
	 * @return the stockSymbol
	 */
	public String getStockSymbol() {
		return stockSymbol;
	}
	/**
	 * @param stockSymbol the stockSymbol to set
	 */
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the open
	 */
	public Float getOpen() {
		return open;
	}
	/**
	 * @param open the open to set
	 */
	public void setOpen(Float open) {
		this.open = open;
	}
	/**
	 * @return the high
	 */
	public Float getHigh() {
		return high;
	}
	/**
	 * @param high the high to set
	 */
	public void setHigh(Float high) {
		this.high = high;
	}
	/**
	 * @return the low
	 */
	public Float getLow() {
		return low;
	}
	/**
	 * @param low the low to set
	 */
	public void setLow(Float low) {
		this.low = low;
	}
	/**
	 * @return the close
	 */
	public Float getClose() {
		return close;
	}
	/**
	 * @param close the close to set
	 */
	public void setClose(Float close) {
		this.close = close;
	}
	/**
	 * @return the volume
	 */
	public Long getVolume() {
		return volume;
	}
	/**
	 * @param volume the volume to set
	 */
	public void setVolume(Long volume) {
		this.volume = volume;
	}
	/**
	 * @return the adjClose
	 */
	public String getAdjClose() {
		return adjClose;
	}
	/**
	 * @param adjClose the adjClose to set
	 */
	public void setAdjClose(String adjClose) {
		this.adjClose = adjClose;
	}
	/**
	 * @param id
	 * @param exchange
	 * @param stockSymbol
	 * @param date
	 * @param open
	 * @param high
	 * @param low
	 * @param close
	 * @param volume
	 * @param adjClose
	 */
	public Finance(String id, String exchange, String stockSymbol, String date, Float open, Float high, Float low,
			Float close, Long volume, String adjClose) {
		super();
		this.id = id;
		this.exchange = exchange;
		this.stockSymbol = stockSymbol;
		this.date = date;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
		this.adjClose = adjClose;
	}
	
	/**
	 * 
	 */
	public Finance() {
		super();
	}
	@Override
	public String toString() {
		return "Finance [id=" + id + ", exchange=" + exchange + ", stockSymbol=" + stockSymbol + ", date=" + date
				+ ", open=" + open + ", high=" + high + ", low=" + low + ", close=" + close + ", volume=" + volume
				+ ", adjClose=" + adjClose + "]";
	}
	

}

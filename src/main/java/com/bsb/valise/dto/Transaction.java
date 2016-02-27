package com.bsb.valise.dto;

import java.util.Date;

public class Transaction {

	String pid;
	String uid;
	String transactionId;
	String orderId;
	Date orderDate;
	long totalOrder;
	long actualPrize;
	long vat;

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public long getTotalOrder() {
		return totalOrder;
	}

	public void setTotalOrder(long totalOrder) {
		this.totalOrder = totalOrder;
	}

	public long getActualPrize() {
		return actualPrize;
	}

	public void setActualPrize(long actualPrize) {
		this.actualPrize = actualPrize;
	}

	public long getVat() {
		return vat;
	}

	public void setVat(long vat) {
		this.vat = vat;
	}

	@Override
	public String toString() {
		return "Transaction [pid=" + pid + ", uid=" + uid + ", transactionId=" + transactionId + ", orderId=" + orderId
				+ ", orderDate=" + orderDate + ", totalOrder=" + totalOrder + ", actualPrize=" + actualPrize + ", vat="
				+ vat + "]";
	}

}

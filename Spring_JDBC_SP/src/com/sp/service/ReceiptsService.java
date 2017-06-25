package com.sp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.dao.Receipt;
import com.sp.dao.ReceiptDAO;

@Service("receiptsService")
public class ReceiptsService {

	private ReceiptDAO receiptDao;

	@Autowired
	public void setReceiptsDao(ReceiptDAO receiptDao) {
		this.receiptDao = receiptDao;
	}

	public List<Receipt> getCurrent() {
		return receiptDao.getReceipts();
	}

	public void addCurrent(Receipt receipt) {
		receiptDao.create(receipt);
	}

}

package pl.sp.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.sp.spring.web.dao.Receipt;
import pl.sp.spring.web.dao.ReceiptsDAO;

@Service("receiptsService")
public class ReceiptsService {

	private ReceiptsDAO receiptsDAO;

	@Autowired
	public void setReceiptsDAO(ReceiptsDAO receiptsDAO) {
		this.receiptsDAO = receiptsDAO;
	}

	public List<Receipt> getCurrent() {
		return receiptsDAO.getReceipts();
	}

}

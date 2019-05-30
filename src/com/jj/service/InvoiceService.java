package com.jj.service;


import com.jj.domain.Invoice;
import com.jj.domain.InvoiceItem;

import java.sql.SQLException;
import java.util.List;

/**
 * @author JYM
 * @create 2019-05-16 23:19
 */
public interface InvoiceService {
    void addInvoice(Invoice invoice) throws SQLException;

    List<Invoice> findAllInvoiceByCid(String cid) throws Exception;

}

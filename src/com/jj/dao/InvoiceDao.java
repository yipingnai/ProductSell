package com.jj.dao;


import com.jj.domain.Invoice;
import com.jj.domain.InvoiceItem;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author JYM
 * @create 2019-05-16 23:22
 */
public interface InvoiceDao {
    void addInvoice(Connection connection, Invoice invoice) throws SQLException;

    void addInvoiceItem(Connection connection, InvoiceItem invoiceItem) throws SQLException;

    List<Invoice> findAllInvoiceByCid(String cid) throws Exception;

    List<InvoiceItem> findAllInvoiceItemByIid(String iid) throws SQLException;
}

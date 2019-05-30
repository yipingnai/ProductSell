package com.jj.service.impl;

import com.jj.dao.InvoiceDao;
import com.jj.dao.ProductDao;
import com.jj.dao.impl.InvoiceDaoImpl;
import com.jj.dao.impl.ProductDaoImpl;
import com.jj.domain.Invoice;
import com.jj.domain.InvoiceItem;
import com.jj.domain.Product;
import com.jj.service.InvoiceService;
import com.jj.service.ProductService;
import com.jj.util.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author JYM
 * @create 2019-05-16 23:21
 */
public class InvoiceServiceImpl implements InvoiceService {

    @Override
    public void addInvoice(Invoice invoice) throws SQLException {
        Connection connection = null;
        InvoiceDao invoiceDao = new InvoiceDaoImpl();
        try{
            connection = JDBCUtils.getConnection();//获取连接
            connection.setAutoCommit(false);//取消事务自动连接
            invoiceDao.addInvoice(connection , invoice);//添加发票到数据库
            for(InvoiceItem invoiceItem : invoice.getList()){
                invoiceDao.addInvoiceItem(connection, invoiceItem);
            }
            connection.commit();
        }catch (Exception e){
            connection.rollback();
        }

    }

    @Override
    public List<Invoice> findAllInvoiceByCid(String cid) throws Exception {
        InvoiceDao invoiceDao = new InvoiceDaoImpl();
        //ProductDao productDao = new ProductDaoImpl();
        List<Invoice> list = invoiceDao.findAllInvoiceByCid(cid);//查询所有发票，返回发票集合
        /*for(Invoice invoice : list){ //遍历发票集合
            List<InvoiceItem> invoiceItems = invoiceDao.findAllInvoiceItemByIid(invoice.getIid());//通过发票id查找所有发票项,返回发票项集合
            *//*for(InvoiceItem invoiceItem : invoiceItems){    //遍历所有发票项
                Product product = productDao.findProductByPid(invoiceItem.getProduct().getPid());//通过发票项id查找
                //System.out.println(product);
                //invoiceItem.setProduct(product);
            }*//*
            for(InvoiceItem invoiceItem : invoiceItems){
                System.out.println(invoiceItem);
            }
            System.out.println(invoiceItems);
            invoice.setList(invoiceItems);
        }*/
        return list;
    }

}

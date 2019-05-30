package com.jj.dao.impl;

import com.jj.dao.InvoiceDao;
import com.jj.domain.Invoice;
import com.jj.domain.InvoiceItem;
import com.jj.domain.Product;
import com.jj.util.JDBCUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author JYM
 * @create 2019-05-16 23:22
 */
public class InvoiceDaoImpl implements InvoiceDao {

    @Override
    public void addInvoice(Connection connection, Invoice invoice) throws SQLException {
        String sql = "insert into invoice values(?, ?, ?, ?)";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        queryRunner.update(connection, sql,invoice.getIid(), invoice.getDate(), invoice.getTotal(), invoice.getCustomer().getCid());
    }

    @Override
    public void addInvoiceItem(Connection connection, InvoiceItem invoiceItem) throws SQLException {
        String sql = "insert into invoiceitem values(?, ?, ?, ?, ?)";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        queryRunner.update(connection, sql,invoiceItem.getItemid(),invoiceItem.getQuantity(),invoiceItem.getSubTotal(),invoiceItem.getProduct().getPid(),invoiceItem.getInvoice().getIid());
    }

    @Override
    public List<Invoice> findAllInvoiceByCid(String cid) throws Exception {
        String sql = "select * from invoice where cid = ?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        List<Invoice> query = queryRunner.query(sql, new BeanListHandler<Invoice>(Invoice.class), cid);
        for(Invoice invoice : query) {
            System.out.println(invoice);
        }
        for(Invoice invoice : query) {
            String iid = invoice.getIid();
            sql = "select * from invoiceitem i,product p where i.iid = ? and p.pid = i.pid";
            List<Map<String, Object>> list = queryRunner.query(sql, new MapListHandler(), iid);
            //遍历map
            for(Map<String, Object> map : list) {
                InvoiceItem invoiceItem = new InvoiceItem();
                Product product = new Product();

                // 1_创建时间类型的转换器
                DateConverter dt = new DateConverter();
                // 2_设置转换的格式
                dt.setPattern("yyyy-mm-dd");
                // 3_注册转换器
                ConvertUtils.register(dt, java.util.Date.class);

                BeanUtils.populate(invoiceItem,map);
                BeanUtils.populate(product,map);

                invoiceItem.setProduct(product);
                invoice.getList().add(invoiceItem);
            }
        }
        return query;
    }

    @Override
    public List<InvoiceItem> findAllInvoiceItemByIid(String iid) throws SQLException {
        String sql = "select * from invoiceitem where Iid = ?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        List<InvoiceItem> query = queryRunner.query(sql, new BeanListHandler<InvoiceItem>(InvoiceItem.class), iid);
        return query;
    }
}

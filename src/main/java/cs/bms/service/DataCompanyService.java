package cs.bms.service;

import cs.bms.dao.interfac.IDataCompanyDao;
import cs.bms.model.DataCompany;
import cs.bms.service.interfac.IDataCompanyService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DataCompanyService extends GenericService<DataCompany, Integer> implements IDataCompanyService {

    @Autowired
    @Qualifier("dataCompanyDao")
    private IDataCompanyDao dao;

    @Override
    protected IGenericDao<DataCompany, Integer> getBasicDao() {
        return this.dao;
    }

    @Override
    public String getStringValue(String propertyName) throws IOException, ClassNotFoundException {
        return (String) getValue(propertyName);
    }

    @Override
    public String getStringValue(String propertyName, String defaultValue) throws IOException, ClassNotFoundException {
        String data = (String) getValue(propertyName);
        return data == null ? defaultValue : data;
    }

    @Override
    public Integer getIntValue(String propertyName) throws IOException, ClassNotFoundException {
        return (Integer) getValue(propertyName);
    }

    @Override
    public Integer getIntValue(String propertyName, Integer defaultValue) throws IOException, ClassNotFoundException {
        Integer data = (Integer) getValue(propertyName);
        return data == null ? defaultValue : data;
    }

    @Override
    public Double getDoubleValue(String propertyName) throws IOException, ClassNotFoundException {
        return (Double) getValue(propertyName);
    } 
    
    @Override
    public Double getDoubleValue(String propertyName, Double defaultValue) throws IOException, ClassNotFoundException {
        Double data = (Double) getValue(propertyName);
        return data == null ? defaultValue : data;
    }


    @Override
    public BigDecimal getBigDecimalValue(String propertyName) throws IOException, ClassNotFoundException {
        return (BigDecimal) getValue(propertyName);
    } 
    
    @Override
    public BigDecimal getBigDecimalValue(String propertyName, BigDecimal defaultValue) throws IOException, ClassNotFoundException {
        BigDecimal data = (BigDecimal) getValue(propertyName);
        return data == null ? defaultValue : data;
    }


    @Override
    public Date getDateValue(String propertyName) throws IOException, ClassNotFoundException {
        return (Date) getValue(propertyName);
    }
    
    @Override
    public Date getDateValue(String propertyName, Date defaultValue) throws IOException, ClassNotFoundException {
        Date data = (Date) getValue(propertyName);
        return data == null ? defaultValue : data;
    }


    @Override
    public void saveOrUpdate(String propertyName, Object value) throws IOException, ClassNotFoundException {
        Integer id = (Integer) dao.getByHQL("SELECT dc.id FROM DataCompany dc  WHERE dc.propertyName LIKE ? ", propertyName);

        DataCompany dc = new DataCompany();
        dc.setId(id);
        dc.setPropertyName(propertyName);
        if (value != null) {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(out);
            os.writeObject(value);
            dc.setValue_(out.toByteArray());
        }
        dao.saveOrUpdate(dc);
    }

    @Override
    public Object getValue(String propertyName) throws IOException, ClassNotFoundException {
        byte[] data = (byte[]) dao.getByHQL("SELECT dc.value_ FROM DataCompany dc WHERE dc.propertyName LIKE ?", propertyName);
        if (data == null) {
            return null;
        }
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        ObjectInputStream is = new ObjectInputStream(in);
        return is.readObject();
    }

    @Override
    public Long getLongValue(String propertyName) throws IOException, ClassNotFoundException {
        return (Long) getValue(propertyName);
    }
    @Override
    public Long getLongValue(String propertyName, Long defaultValue) throws IOException, ClassNotFoundException {
        Long data = (Long) getValue(propertyName);
        return data == null ? defaultValue : data;
    }

    @Override
    public Boolean getBooleanValue(String propertyName) throws IOException, ClassNotFoundException {
        return (Boolean) getValue(propertyName);
    }

    @Override
    public Boolean getBooleanValue(String propertyName, Boolean defaultValue) throws IOException, ClassNotFoundException {
        Boolean data = (Boolean) getValue(propertyName);
        return data == null ? defaultValue : data;
    }

}

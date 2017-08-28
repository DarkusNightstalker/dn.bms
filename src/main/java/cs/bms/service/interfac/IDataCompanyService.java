package cs.bms.service.interfac;

import cs.bms.model.DataCompany;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

public interface IDataCompanyService extends IGenericService<DataCompany, Integer> {

    public String getStringValue(String propertyName) throws IOException, ClassNotFoundException;

    public String getStringValue(String propertyName, String defaultValue) throws IOException, ClassNotFoundException;

    public Integer getIntValue(String propertyName) throws IOException, ClassNotFoundException;

    public Integer getIntValue(String propertyName, Integer defaultValue) throws IOException, ClassNotFoundException;

    public Long getLongValue(String propertyName) throws IOException, ClassNotFoundException;

    public Long getLongValue(String propertyName, Long defaultValue) throws IOException, ClassNotFoundException;

    public Double getDoubleValue(String propertyName) throws IOException, ClassNotFoundException;

    public Double getDoubleValue(String propertyName, Double defaultValue) throws IOException, ClassNotFoundException;

    public BigDecimal getBigDecimalValue(String propertyName) throws IOException, ClassNotFoundException;

    public BigDecimal getBigDecimalValue(String propertyName, BigDecimal defaultValue) throws IOException, ClassNotFoundException;

    public Date getDateValue(String propertyName) throws IOException, ClassNotFoundException;

    public Date getDateValue(String propertyName, Date defaultValue) throws IOException, ClassNotFoundException;

    public Object getValue(String propertyName) throws IOException, ClassNotFoundException;

    public void saveOrUpdate(String propertyName, Object value) throws IOException, ClassNotFoundException;

    public Boolean getBooleanValue(String propertyName) throws IOException, ClassNotFoundException;
    public Boolean getBooleanValue(String propertyName,Boolean default_) throws IOException, ClassNotFoundException;
}

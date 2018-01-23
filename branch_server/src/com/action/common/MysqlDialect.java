package com.action.common;

import org.hibernate.Hibernate;
import org.hibernate.dialect.MySQL5Dialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;

public class MysqlDialect extends MySQL5Dialect {
	public MysqlDialect() {  
        super();  
        registerFunction("date_add_interval", new SQLFunctionTemplate(Hibernate.DATE,
        		"date_add(?1, INTERVAL ?2 ?3)"));
    }
}

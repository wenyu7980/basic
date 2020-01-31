package com.wenyu7980.basic.config.database.generator;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.UUIDHexGenerator;

import java.io.Serializable;

/**
 *
 * @author wenyu
 * @date 2020-01-30 
 */
public class UUIDGenerator extends UUIDHexGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session,
            Object object) throws HibernateException {
        return format(getHiTime()) + format(getLoTime()) + format(getJVM())
                + format(getIP()) + format(getCount());
    }
}

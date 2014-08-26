package org.sandag.abm.report.persistence;

import java.io.Serializable;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class BaseDao<T, PK extends Serializable>
        implements Converter<String, T>
{
    @Autowired
    protected SessionFactory sessionFactory;

    private Class<T>         type;
    private Class<PK>        pkType;

    public BaseDao(Class<T> type, Class<PK> pkType)
    {
        this.type = type;
        this.pkType = pkType;
    }

    @SuppressWarnings("unchecked")
    public T read(PK id)
    {
        return (T) getSession().get(type, id);
    }

    protected Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }

    protected Criteria startQuery()
    {
        return this.getSession().createCriteria(type);
    }

    @SuppressWarnings("unchecked")
    public T convert(String id)
    {
        if (pkType.equals(Short.class))
        {
            return read((PK) Short.valueOf(id));
        }

        throw new NotYetImplementedException(String.format(
                "Primary keys of type '%s' are not supported for conversion", pkType.getName()));

    }
}

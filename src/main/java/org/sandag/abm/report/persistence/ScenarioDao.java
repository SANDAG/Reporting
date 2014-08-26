package org.sandag.abm.report.persistence;

import java.util.List;
import org.hibernate.criterion.Order;
import org.sandag.abm.report.model.Scenario;
import org.springframework.stereotype.Repository;

@Repository
public class ScenarioDao
        extends BaseDao<Scenario, Short>
{
    public ScenarioDao()
    {
        super(Scenario.class, Short.class);
    }

    @SuppressWarnings("unchecked")
    public List<Scenario> readAll()
    {
        return startQuery().addOrder(Order.desc("id")).list();
    }
}

package org.sandag.abm.report.persistence;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.sandag.abm.report.model.TransitRoute;
import org.sandag.abm.report.model.TransitRouteId;
import org.sandag.abm.report.statistics.RouteSummary;
import org.springframework.stereotype.Repository;

@Repository
public class TransitRouteDao
extends BaseDao<TransitRoute, TransitRouteId>
{
    public TransitRouteDao()
    {
        super(TransitRoute.class, TransitRouteId.class);
    }
}

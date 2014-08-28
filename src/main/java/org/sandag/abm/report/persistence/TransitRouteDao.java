package org.sandag.abm.report.persistence;

import org.sandag.abm.report.model.TransitRoute;
import org.sandag.abm.report.model.TransitRouteId;
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

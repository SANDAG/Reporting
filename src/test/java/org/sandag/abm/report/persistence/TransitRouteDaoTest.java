package org.sandag.abm.report.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sandag.abm.report.model.TransitRoute;
import org.sandag.abm.report.model.TransitRouteId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/db.xml", "classpath:/autowire.xml"})
@TransactionConfiguration(transactionManager = "transactionManager")
@Transactional
public class TransitRouteDaoTest
{
    @Autowired
    private TransitRouteDao transitRouteDao;

    private Short           scenarioId = new Short((short) 249);

    @Test
    public void testRead()
    {
        Short r = new Short((short) 32);

        TransitRouteId routeId = new TransitRouteId(scenarioId, r);
        TransitRoute route = transitRouteDao.read(routeId);

        assertNotNull(route);

        assertEquals("50102", route.getRouteName());
        assertEquals(9, route.getTransitModeId());
        assertEquals(15, route.getAmHeadway(), 0.000001);
        assertEquals(30.0, route.getPmHeadway(), 0.000001);
        assertEquals(60.0, route.getOpHeadway(), 0.000001);
        assertEquals(50102, route.getConfig());
        assertEquals(2.5, route.getFare(), 0.00001);
    }

}

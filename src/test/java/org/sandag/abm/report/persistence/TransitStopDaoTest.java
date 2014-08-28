package org.sandag.abm.report.persistence;

import static org.junit.Assert.*;
import java.util.HashMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sandag.abm.report.model.TransitRoute;
import org.sandag.abm.report.model.TransitStop;
import org.sandag.abm.report.model.TransitStopId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/db.xml", "classpath:/autowire.xml"})
@TransactionConfiguration(transactionManager = "transactionManager")
@Transactional
public class TransitStopDaoTest
{
    @Autowired
    private TransitStopDao transitStopDao;

    private Short          scenarioId = new Short((short) 249);

    @Test
    public void testManyToOneMappingTransitRoute()
    {
        TransitStopId transitStopId = new TransitStopId(scenarioId, new Short((short)7), new Byte((byte)4),
                new Byte((byte)1), new Byte((byte)2), new Short((short)93));
        
        TransitStop transitStop = transitStopDao.read(transitStopId);
        assertNotNull(transitStop);
        
        TransitRoute transitRoute = transitStop.getTransitRoute();
        assertNotNull(transitRoute);
        
        assertEquals("510210", transitRoute.getRouteName());
        assertEquals((byte)5, transitRoute.getTransitModeId());
        assertEquals(12.0, transitRoute.getAmHeadway(),0.00001);
        assertEquals(12.0, transitRoute.getPmHeadway(),0.00001);
        assertEquals(15.0, transitRoute.getOpHeadway(),0.00001);
        assertEquals(510210, transitRoute.getConfig());
        assertEquals(2.5, transitRoute.getFare(),0.00001);
    }

    @Test
    public void testGetTotalBoardings()
    {
        double boardings = transitStopDao.getTotalBoardings(scenarioId);
        assertEquals(78392, boardings, 1);
    }

    @Test
    public void testGetTotalAlightings()
    {
        double alightings = transitStopDao.getTotalAlightings(scenarioId);
        assertEquals(78586, alightings, 1);
    }

    @Test
    public void testGetBoardingsByMainMode()
    {
        HashMap<String, Double> boardingsByMode = transitStopDao.getBoardingsByMainMode(scenarioId);
        assertEquals(2716, boardingsByMode.get(TransitStopDao.COMMUTER_RAIL_KEY).doubleValue(), 1);
        assertEquals(41055, boardingsByMode.get(TransitStopDao.LIGHT_RAIL_KEY).doubleValue(), 1);
        assertEquals(0, boardingsByMode.get(TransitStopDao.REGIONAL_BRT_KEY).doubleValue(), 1);
        assertEquals(9971, boardingsByMode.get(TransitStopDao.EXPRESS_BUS_KEY).doubleValue(), 1);
        assertEquals(24650, boardingsByMode.get(TransitStopDao.LOCAL_BUS_KEY).doubleValue(), 1);
    }
}

package org.sandag.abm.report.persistence;
import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/db.xml", "classpath:/autowire.xml" })
@TransactionConfiguration(transactionManager = "transactionManager")
@Transactional
public class TransitStopDaoTest
{
    @Autowired
    private TransitStopDao transitStopDao;

    @Test
    public void testGetTotalBoardings()
    {
        double boardings = transitStopDao.getTotalBoardings(new Short((short)249));
        assertEquals(18, boardings, 1);
    }
    
    @Test
    public void testGetTotalAlightings()
    {
        double alightings = transitStopDao.getTotalAlightings(new Short((short)236));
        assertEquals(50.4, alightings, 1);
    }

    @Test
    public void testGetBoardingsByMainMode()
    {
        HashMap<String, Double> boardingsByMode = transitStopDao.getBoardingsByMainMode((short)249);
        assertEquals(18, boardingsByMode.get(TransitStopDao.COMMUTER_RAIL_KEY).doubleValue(), 0.0001);
        //assertEquals(192317.999949, boardingsByMode.get(TransitStopDao.LIGHT_RAIL_KEY).doubleValue(), 0.0001);
        //assertEquals(0, boardingsByMode.get(TransitStopDao.REGIONAL_BRT_KEY).doubleValue(), 0.0001);
        //assertEquals(35799.000023, boardingsByMode.get(TransitStopDao.EXPRESS_BUS_KEY).doubleValue(), 0.0001);
        //assertEquals(120949.000054, boardingsByMode.get(TransitStopDao.LOCAL_BUS_KEY).doubleValue(), 0.0001);
    }
}

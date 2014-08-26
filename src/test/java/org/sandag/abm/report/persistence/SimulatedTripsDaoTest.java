package org.sandag.abm.report.persistence;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sandag.abm.report.statistics.ModeShare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/db.xml", "classpath:/autowire.xml"})
@TransactionConfiguration(transactionManager = "transactionManager")
@Transactional
public class SimulatedTripsDaoTest
{
    @Autowired
    private SimulatedTripDao simulatedTripDao;

    @Test
    public void testGetResidentModeShare()
    {
        ModeShare modeShare = simulatedTripDao.getResidentModeShare(new Short((short) 238));

        assertEquals(3, modeShare.getDriveAloneTrips(), 1);
        assertEquals(9, modeShare.getCarpoolTrips(), 1);
        assertEquals(7, modeShare.getWalkTrips(), 1);
        assertEquals(6, modeShare.getBikeTrips(), 1);
        assertEquals(5, modeShare.getTransitTrips(), 1);
        assertEquals(4, modeShare.getOtherTrips(), 1);

        assertEquals(0.088235294, modeShare.getDriveAloneModeShare(), 0.0001);
        assertEquals(0.264705882, modeShare.getCarpoolModeShare(), 0.0001);
        assertEquals(0.205882352, modeShare.getWalkModeShare(), 0.0001);
        assertEquals(0.176470588, modeShare.getBikeModeShare(), 0.0001);
        assertEquals(0.147058823, modeShare.getTransitModeShare(), 0.0001);
        assertEquals(0.117647058, modeShare.getOtherModeShare(), 0.0001);
    }

}

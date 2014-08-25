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
@ContextConfiguration(locations = {"classpath:/db.xml", "classpath:/autowire.xml" })
@TransactionConfiguration(transactionManager = "transactionManager")
@Transactional
public class SimulatedTripsDaoTest
{
    @Autowired
    private SimulatedTripDao simulatedTripDao;

    @Test
    public void testGetResidentModeShare()
    {
        ModeShare modeShare = simulatedTripDao.getResidentModeShare(new Short((short)238));
        
        assertEquals(4792705,modeShare.getDriveAloneTrips(),1);
        assertEquals(5223979,modeShare.getCarpoolTrips(),1);
        assertEquals(1064907,modeShare.getWalkTrips(),1);
        assertEquals(429037,modeShare.getBikeTrips(),1);
        assertEquals(266715,modeShare.getTransitTrips(),1);
        assertEquals(118560,modeShare.getOtherTrips(),1);
        
        assertEquals(0.402887028,modeShare.getDriveAloneModeShare(),0.0001);
        assertEquals(0.439141022,modeShare.getCarpoolModeShare(),0.0001);
        assertEquals(0.089518803,modeShare.getWalkModeShare(),0.0001);
        assertEquals(0.036065946,modeShare.getBikeModeShare(),0.0001);
        assertEquals(0.022420744,modeShare.getTransitModeShare(),0.0001);
        assertEquals(0.009966457,modeShare.getOtherModeShare(),0.0001);   
    }

}

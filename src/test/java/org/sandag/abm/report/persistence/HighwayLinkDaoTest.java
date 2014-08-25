package org.sandag.abm.report.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.HashMap;
import org.hibernate.cfg.NotYetImplementedException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sandag.abm.report.model.HighwayLink;
import org.sandag.abm.report.statistics.VmtFacilityProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/db.xml", "classpath:/autowire.xml"})
@TransactionConfiguration(transactionManager = "transactionManager")
@Transactional
public class HighwayLinkDaoTest
{
    @Autowired
    private HighwayLinkDao hwyLinkDao;

    @Test
    public void testGetTotalVMT()
    {
        double totalVmt = hwyLinkDao.getTotalVMT(new Short((short) 253));
        assertEquals(79916446.598, totalVmt, 0.1);
    }

    @Test
    public void testGetTotalVHT()
    {
        double totalVht = hwyLinkDao.getTotalVHT(new Short((short) 249));
        assertEquals(2073892.491, totalVht, 0.1);
    }

    @Test
    public void testGetDriveAloneVMT()
    {
        double totalVmt = hwyLinkDao.getDriveAloneVMT(new Short((short) 249));
        assertEquals(58892526.38, totalVmt, 0.1);
    }

    @Test
    public void testGetCarpoolVMT()
    {
        double totalVmt = hwyLinkDao.getCarpoolVMT(new Short((short) 249));
        assertEquals(17661852.23, totalVmt, 0.1);
    }

    @Test
    public void testGetLhdtVMT()
    {
        double totalVmt = hwyLinkDao.getLhdtVMT(new Short((short) 249));
        assertEquals(1478489.809, totalVmt, 0.1);
    }

    @Test
    public void testGetMhdtVMT()
    {
        double totalVmt = hwyLinkDao.getMhdtVMT(new Short((short) 249));
        assertEquals(1095885.237, totalVmt, 0.1);
    }

    @Test
    public void testGetHhdtVMT()
    {
        double totalVmt = hwyLinkDao.getHhdtVMT(new Short((short) 249));
        assertEquals(858211.918, totalVmt, 0.1);
    }

    @Test
    public void testGetVmtProfiles()
    {
        Short scenarioId = new Short((short)249);
        
        HashMap<String, VmtFacilityProfile> profiles = hwyLinkDao.getVmtProfilesByIFC(scenarioId);
        VmtFacilityProfile driveAloneProfile = profiles.get("driveAlone");
        VmtFacilityProfile carpoolProfile = profiles.get("carpool");
        VmtFacilityProfile lhdtProfile = profiles.get("lhdt");
        VmtFacilityProfile mhdtProfile = profiles.get("mhdt");
        VmtFacilityProfile hhdtProfile = profiles.get("hhdt");
        VmtFacilityProfile transitProfile = profiles.get("transit");
        VmtFacilityProfile totalProfile = profiles.get("total");

        assertNotNull(driveAloneProfile);
        assertNotNull(carpoolProfile);
        assertNotNull(lhdtProfile);
        assertNotNull(mhdtProfile);
        assertNotNull(hhdtProfile);
        assertNotNull(transitProfile);
        assertNotNull(totalProfile);

        assertEquals(52.7, driveAloneProfile.getFreewaySpeed(), 0.1);
        assertEquals(29608291.0483797, driveAloneProfile.getFreewayVmt(), 0.1);
        assertEquals(561780.3348, driveAloneProfile.getFreewayVht(), 0.1);
        assertEquals(5236206.40359698, driveAloneProfile.getPrimeVmt(), 0.1);
        assertEquals(157740.1893, driveAloneProfile.getPrimeVht(), 0.1);
        
        assertEquals(hwyLinkDao.getTotalVMT(scenarioId), totalProfile.getTotalVmt(), 10);
        assertEquals(hwyLinkDao.getTotalVHT(scenarioId), totalProfile.getTotalVht(), 10);
        
    }

    @Test(expected = NotYetImplementedException.class)
    public void testConvert()
    {
        @SuppressWarnings("unused")
        HighwayLink hwyLink = hwyLinkDao.convert("35302");
    }
}

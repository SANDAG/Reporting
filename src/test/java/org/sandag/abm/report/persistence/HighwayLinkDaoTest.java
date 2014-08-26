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
    private static final Short scenarioId = new Short((short) 257);

    @Autowired
    private HighwayLinkDao     hwyLinkDao;

    @Test
    public void testGetTotalVMT()
    {
        double totalVmt = hwyLinkDao.getTotalVMT(scenarioId);
        assertEquals(6518788.531949234, totalVmt, 0.1);
    }

    @Test
    public void testGetTotalVHT()
    {
        double totalVht = hwyLinkDao.getTotalVHT(scenarioId);
        assertEquals(150536.58169, totalVht, 0.1);
    }

    @Test
    public void testGetDriveAloneVMT()
    {
        double totalVmt = hwyLinkDao.getDriveAloneVMT(scenarioId);
        assertEquals(4627930.6278, totalVmt, 0.1);
    }

    @Test
    public void testGetCarpoolVMT()
    {
        double totalVmt = hwyLinkDao.getCarpoolVMT(scenarioId);
        assertEquals(1387547.11742, totalVmt, 0.1);
    }

    @Test
    public void testGetLhdtVMT()
    {
        double totalVmt = hwyLinkDao.getLhdtVMT(scenarioId);
        assertEquals(203303.74702289896, totalVmt, 0.1);
    }

    @Test
    public void testGetMhdtVMT()
    {
        double totalVmt = hwyLinkDao.getMhdtVMT(scenarioId);
        assertEquals(141259.9103, totalVmt, 0.1);
    }

    @Test
    public void testGetHhdtVMT()
    {
        double totalVmt = hwyLinkDao.getHhdtVMT(scenarioId);
        assertEquals(150681.02207684467, totalVmt, 0.1);
    }

    @Test
    public void testGetVmtProfiles()
    {
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

        assertEquals(47.5486, driveAloneProfile.getFreewaySpeed(), 0.1);
        assertEquals(3829209.83164116, driveAloneProfile.getFreewayVmt(), 0.1);
        assertEquals(80532.3942674527, driveAloneProfile.getFreewayVht(), 0.1);
        assertEquals(186104.96007994, driveAloneProfile.getPrimeVmt(), 0.1);
        assertEquals(5656.09131847118, driveAloneProfile.getPrimeVht(), 0.1);

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

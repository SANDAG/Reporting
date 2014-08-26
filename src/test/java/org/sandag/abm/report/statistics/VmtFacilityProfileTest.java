package org.sandag.abm.report.statistics;

import static org.junit.Assert.*;
import org.junit.Test;

public class VmtFacilityProfileTest
{

    @Test
    public void testVmtFacilityProfileClass()
    {
        double vmtFreeway = 11.5;
        double vmtPrime = 12.5;
        double vmtMajor = 13.5;
        double vmtCollector = 14.5;
        double vmtLocalCollector = 15.5;
        double vmtRuralCollector = 16.5;
        double vmtLocal = 17.5;
        double vmtConnectorRamp = 18.5;
        double vmtRamp = 19.5;
        double vmtAccess = 110.5;

        double vhtFreeway = 1.0;
        double vhtPrime = 2.0;
        double vhtMajor = 3.0;
        double vhtCollector = 4.0;
        double vhtLocalCollector = 5.0;
        double vhtRuralCollector = 6.0;
        double vhtLocal = 7.0;
        double vhtConnectorRamp = 8.0;
        double vhtRamp = 9.0;
        double vhtAccess = 10.0;

        VmtFacilityProfile vmtProfile = new VmtFacilityProfile();

        vmtProfile.addFreewayTravel(vmtFreeway, vhtFreeway);
        vmtProfile.addPrimeTravel(vmtPrime, vhtPrime);
        vmtProfile.addMajorTravel(vmtMajor, vhtMajor);
        vmtProfile.addCollectorTravel(vmtCollector, vhtCollector);
        vmtProfile.addLocalCollectorTravel(vmtLocalCollector, vhtLocalCollector);
        vmtProfile.addRuralCollectorTravel(vmtRuralCollector, vhtRuralCollector);
        vmtProfile.addLocalTravel(vmtLocal, vhtLocal);
        vmtProfile.addConnectorRampTravel(vmtConnectorRamp, vhtConnectorRamp);
        vmtProfile.addRampTravel(vmtRamp, vhtRamp);
        vmtProfile.addAccessTravel(vmtAccess, vhtAccess);

        assertEquals(vmtFreeway, vmtProfile.getFreewayVmt(), 0.0001);
        assertEquals(vmtPrime, vmtProfile.getPrimeVmt(), 0.0001);
        assertEquals(vmtMajor, vmtProfile.getMajorVmt(), 0.0001);
        assertEquals(vmtCollector, vmtProfile.getCollectorVmt(), 0.0001);
        assertEquals(vmtLocalCollector, vmtProfile.getLocalCollectorVmt(), 0.0001);
        assertEquals(vmtRuralCollector, vmtProfile.getRuralCollectorVmt(), 0.0001);
        assertEquals(vmtLocal, vmtProfile.getLocalVmt(), 0.0001);
        assertEquals(vmtConnectorRamp, vmtProfile.getConnectorRampVmt(), 0.0001);
        assertEquals(vmtRamp, vmtProfile.getRampVmt(), 0.0001);
        assertEquals(vmtAccess, vmtProfile.getAccessVmt(), 0.0001);

        assertEquals(vhtFreeway, vmtProfile.getFreewayVht(), 0.0001);
        assertEquals(vhtPrime, vmtProfile.getPrimeVht(), 0.0001);
        assertEquals(vhtMajor, vmtProfile.getMajorVht(), 0.0001);
        assertEquals(vhtCollector, vmtProfile.getCollectorVht(), 0.0001);
        assertEquals(vhtLocalCollector, vmtProfile.getLocalCollectorVht(), 0.0001);
        assertEquals(vhtRuralCollector, vmtProfile.getRuralCollectorVht(), 0.0001);
        assertEquals(vhtLocal, vmtProfile.getLocalVht(), 0.0001);
        assertEquals(vhtConnectorRamp, vmtProfile.getConnectorRampVht(), 0.0001);
        assertEquals(vhtRamp, vmtProfile.getRampVht(), 0.0001);
        assertEquals(vhtAccess, vmtProfile.getAccessVht(), 0.0001);

        assertEquals(vmtFreeway / vhtFreeway, vmtProfile.getFreewaySpeed(), 0.0001);
        assertEquals(vmtPrime / vhtPrime, vmtProfile.getPrimeSpeed(), 0.0001);
        assertEquals(vmtMajor / vhtMajor, vmtProfile.getMajorSpeed(), 0.0001);
        assertEquals(vmtCollector / vhtCollector, vmtProfile.getCollectorSpeed(), 0.0001);
        assertEquals(vmtLocalCollector / vhtLocalCollector, vmtProfile.getLocalCollectorSpeed(),
                0.0001);
        assertEquals(vmtRuralCollector / vhtRuralCollector, vmtProfile.getRuralCollectorSpeed(),
                0.0001);
        assertEquals(vmtLocal / vhtLocal, vmtProfile.getLocalSpeed(), 0.0001);
        assertEquals(vmtConnectorRamp / vhtConnectorRamp, vmtProfile.getConnectorRampSpeed(),
                0.0001);
        assertEquals(vmtRamp / vhtRamp, vmtProfile.getRampSpeed(), 0.0001);
        assertEquals(vmtAccess / vhtAccess, vmtProfile.getAccessSpeed(), 0.0001);

        assertEquals((vmtFreeway + vmtPrime + vmtMajor + vmtCollector + vmtLocalCollector
                + vmtRuralCollector + vmtLocal + vmtConnectorRamp + vmtRamp + vmtAccess),
                vmtProfile.getTotalVmt(), 0.00001);
        assertEquals((vhtFreeway + vhtPrime + vhtMajor + vhtCollector + vhtLocalCollector
                + vhtRuralCollector + vhtLocal + vhtConnectorRamp + vhtRamp + vhtAccess),
                vmtProfile.getTotalVht(), 0.000001);
        assertEquals((vmtFreeway + vmtPrime + vmtMajor + vmtCollector + vmtLocalCollector
                + vmtRuralCollector + vmtLocal + vmtConnectorRamp + vmtRamp + vmtAccess)
                / (vhtFreeway + vhtPrime + vhtMajor + vhtCollector + vhtLocalCollector
                        + vhtRuralCollector + vhtLocal + vhtConnectorRamp + vhtRamp + vhtAccess),
                vmtProfile.getTotalSpeed(),0.0001);
    }
}

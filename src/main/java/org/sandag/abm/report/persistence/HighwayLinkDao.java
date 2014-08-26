package org.sandag.abm.report.persistence;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.sandag.abm.report.model.HighwayLink;
import org.sandag.abm.report.model.HighwayLinkId;
import org.sandag.abm.report.statistics.VmtFacilityProfile;
import org.springframework.stereotype.Repository;

@Repository
public class HighwayLinkDao
        extends BaseDao<HighwayLink, HighwayLinkId>
{
    public HighwayLinkDao()
    {
        super(HighwayLink.class, HighwayLinkId.class);
    }

    public double getTotalVMT(Short aScenarioId)
    {
        Criteria criteria = startQuery().add(Restrictions.eq("id.scenarioId", aScenarioId));
        criteria.setProjection(Projections.sum("vmt"));

        return ((Double) criteria.list().get(0)).doubleValue();
    }

    public double getDriveAloneVMT(Short aScenarioId)
    {
        Criteria criteria = startQuery().add(Restrictions.eq("id.scenarioId", aScenarioId));
        criteria.setProjection(Projections.sum("driveAloneVmt"));

        return (Double) criteria.list().get(0);
    }

    public double getCarpoolVMT(Short aScenarioId)
    {
        Criteria criteria = startQuery().add(Restrictions.eq("id.scenarioId", aScenarioId));
        criteria.setProjection(Projections.sum("carpoolVmt"));

        return (Double) criteria.list().get(0);
    }

    public double getLhdtVMT(Short aScenarioId)
    {
        Criteria criteria = startQuery().add(Restrictions.eq("id.scenarioId", aScenarioId));
        criteria.setProjection(Projections.sum("lhdtVmt"));

        return (Double) criteria.list().get(0);
    }

    public double getMhdtVMT(Short aScenarioId)
    {
        Criteria criteria = startQuery().add(Restrictions.eq("id.scenarioId", aScenarioId));
        criteria.setProjection(Projections.sum("mhdtVmt"));

        return (Double) criteria.list().get(0);
    }

    public double getHhdtVMT(Short aScenarioId)
    {
        Criteria criteria = startQuery().add(Restrictions.eq("id.scenarioId", aScenarioId));
        criteria.setProjection(Projections.sum("hhdtVmt"));

        return (Double) criteria.list().get(0);
    }

    public double getTotalVHT(Short aScenarioId)
    {
        Criteria criteria = startQuery().add(Restrictions.eq("id.scenarioId", aScenarioId));
        criteria.setProjection(Projections.sum("vht"));

        return ((BigDecimal) criteria.list().get(0)).doubleValue();
    }

    public HashMap<String, VmtFacilityProfile> getVmtProfilesByIFC(Short aScenarioId)
    {
        VmtFacilityProfile driveAloneProfile = new VmtFacilityProfile();
        VmtFacilityProfile carpoolProfile = new VmtFacilityProfile();
        VmtFacilityProfile lhdtProfile = new VmtFacilityProfile();
        VmtFacilityProfile mhdtProfile = new VmtFacilityProfile();
        VmtFacilityProfile hhdtProfile = new VmtFacilityProfile();
        VmtFacilityProfile transitProfile = new VmtFacilityProfile();
        VmtFacilityProfile totalProfile = new VmtFacilityProfile();

        HashMap<String, VmtFacilityProfile> profiles = new HashMap<String, VmtFacilityProfile>();
        profiles.put("driveAlone", driveAloneProfile);
        profiles.put("carpool", carpoolProfile);
        profiles.put("lhdt", lhdtProfile);
        profiles.put("mhdt", mhdtProfile);
        profiles.put("hhdt", hhdtProfile);
        profiles.put("transit", transitProfile);
        profiles.put("total", totalProfile);

        Criteria criteria = startQuery().add(Restrictions.eq("id.scenarioId", aScenarioId));
        criteria.setProjection(Projections.projectionList().add(Projections.sum("driveAloneVmt"))
                .add(Projections.sum("carpoolVmt")).add(Projections.sum("lhdtVmt"))
                .add(Projections.sum("mhdtVmt")).add(Projections.sum("hhdtVmt"))
                .add(Projections.sum("driveAloneVht")).add(Projections.sum("carpoolVht"))
                .add(Projections.sum("lhdtVht")).add(Projections.sum("mhdtVht"))
                .add(Projections.sum("hhdtVht")).add(Projections.groupProperty("ifc"))
                .add(Projections.sum("transitVmt")).add(Projections.sum("transitVht")));

        @SuppressWarnings("unchecked")
        List<Object[]> list = criteria.list();

        for (Object[] record : list)
        {
            // [0] = Drive Alone VMT [5] = Drive Alone VHT
            // [1] = Carpool VMT [6] = Carpool VHT
            // [2] = LHDT VMT [7] = LHDT VHT
            // [3] = MHDT VMT [8] = MHDT VHT
            // [4] = HHDT VMT [9] = HHDT VHT
            // [10] = IFC
            // [11] = TRANSIT VMT [12] = TRANSIT VHT
            switch (((Byte) record[10]).intValue())
            {
                case 1: // Freeway
                    driveAloneProfile.addFreewayTravel((Double) record[0], (Double) record[5]);
                    carpoolProfile.addFreewayTravel((Double) record[1], (Double) record[6]);
                    lhdtProfile.addFreewayTravel((Double) record[2], (Double) record[7]);
                    mhdtProfile.addFreewayTravel((Double) record[3], (Double) record[8]);
                    hhdtProfile.addFreewayTravel((Double) record[4], (Double) record[9]);
                    transitProfile.addFreewayTravel((Double) record[11], (Double) record[12]);
                    totalProfile.addFreewayTravel((Double) record[0] + (Double) record[1]
                            + (Double) record[2] + (Double) record[3] + (Double) record[4]
                            + (Double) record[11], (Double) record[5] + (Double) record[6]
                            + (Double) record[7] + (Double) record[8] + (Double) record[9]
                            + (Double) record[12]);
                    break;
                case 2: // Prime
                    driveAloneProfile.addPrimeTravel((Double) record[0], (Double) record[5]);
                    carpoolProfile.addPrimeTravel((Double) record[1], (Double) record[6]);
                    lhdtProfile.addPrimeTravel((Double) record[2], (Double) record[7]);
                    mhdtProfile.addPrimeTravel((Double) record[3], (Double) record[8]);
                    hhdtProfile.addPrimeTravel((Double) record[4], (Double) record[9]);
                    transitProfile.addPrimeTravel((Double) record[11], (Double) record[12]);
                    totalProfile.addPrimeTravel((Double) record[0] + (Double) record[1]
                            + (Double) record[2] + (Double) record[3] + (Double) record[4]
                            + (Double) record[11], (Double) record[5] + (Double) record[6]
                            + (Double) record[7] + (Double) record[8] + (Double) record[9]
                            + (Double) record[12]);
                    break;
                case 3: // Major
                    driveAloneProfile.addMajorTravel((Double) record[0], (Double) record[5]);
                    carpoolProfile.addMajorTravel((Double) record[1], (Double) record[6]);
                    lhdtProfile.addMajorTravel((Double) record[2], (Double) record[7]);
                    mhdtProfile.addMajorTravel((Double) record[3], (Double) record[8]);
                    hhdtProfile.addMajorTravel((Double) record[4], (Double) record[9]);
                    transitProfile.addMajorTravel((Double) record[11], (Double) record[12]);
                    totalProfile.addMajorTravel((Double) record[0] + (Double) record[1]
                            + (Double) record[2] + (Double) record[3] + (Double) record[4]
                            + (Double) record[11], (Double) record[5] + (Double) record[6]
                            + (Double) record[7] + (Double) record[8] + (Double) record[9]
                            + (Double) record[12]);
                    break;
                case 4: // Collector
                    driveAloneProfile.addCollectorTravel((Double) record[0], (Double) record[5]);
                    carpoolProfile.addCollectorTravel((Double) record[1], (Double) record[6]);
                    lhdtProfile.addCollectorTravel((Double) record[2], (Double) record[7]);
                    mhdtProfile.addCollectorTravel((Double) record[3], (Double) record[8]);
                    hhdtProfile.addCollectorTravel((Double) record[4], (Double) record[9]);
                    transitProfile.addCollectorTravel((Double) record[11], (Double) record[12]);
                    totalProfile.addCollectorTravel((Double) record[0] + (Double) record[1]
                            + (Double) record[2] + (Double) record[3] + (Double) record[4]
                            + (Double) record[11], (Double) record[5] + (Double) record[6]
                            + (Double) record[7] + (Double) record[8] + (Double) record[9]
                            + (Double) record[12]);
                    break;
                case 5: // Local Collector
                    driveAloneProfile.addLocalCollectorTravel((Double) record[0],
                            (Double) record[5]);
                    carpoolProfile.addLocalCollectorTravel((Double) record[1], (Double) record[6]);
                    lhdtProfile.addLocalCollectorTravel((Double) record[2], (Double) record[7]);
                    mhdtProfile.addLocalCollectorTravel((Double) record[3], (Double) record[8]);
                    hhdtProfile.addLocalCollectorTravel((Double) record[4], (Double) record[9]);
                    transitProfile
                            .addLocalCollectorTravel((Double) record[11], (Double) record[12]);
                    totalProfile.addLocalCollectorTravel((Double) record[0] + (Double) record[1]
                            + (Double) record[2] + (Double) record[3] + (Double) record[4]
                            + (Double) record[11], (Double) record[5] + (Double) record[6]
                            + (Double) record[7] + (Double) record[8] + (Double) record[9]
                            + (Double) record[12]);
                    break;
                case 6: // Rural Collector
                    driveAloneProfile.addRuralCollectorTravel((Double) record[0],
                            (Double) record[5]);
                    carpoolProfile.addRuralCollectorTravel((Double) record[1], (Double) record[6]);
                    lhdtProfile.addRuralCollectorTravel((Double) record[2], (Double) record[7]);
                    mhdtProfile.addRuralCollectorTravel((Double) record[3], (Double) record[8]);
                    hhdtProfile.addRuralCollectorTravel((Double) record[4], (Double) record[9]);
                    transitProfile
                            .addRuralCollectorTravel((Double) record[11], (Double) record[12]);
                    totalProfile.addRuralCollectorTravel((Double) record[0] + (Double) record[1]
                            + (Double) record[2] + (Double) record[3] + (Double) record[4]
                            + (Double) record[11], (Double) record[5] + (Double) record[6]
                            + (Double) record[7] + (Double) record[8] + (Double) record[9]
                            + (Double) record[12]);
                    break;
                case 7:// Local
                    driveAloneProfile.addLocalTravel((Double) record[0], (Double) record[5]);
                    carpoolProfile.addLocalTravel((Double) record[1], (Double) record[6]);
                    lhdtProfile.addLocalTravel((Double) record[2], (Double) record[7]);
                    mhdtProfile.addLocalTravel((Double) record[3], (Double) record[8]);
                    hhdtProfile.addLocalTravel((Double) record[4], (Double) record[9]);
                    transitProfile.addLocalTravel((Double) record[11], (Double) record[12]);
                    totalProfile.addLocalTravel((Double) record[0] + (Double) record[1]
                            + (Double) record[2] + (Double) record[3] + (Double) record[4]
                            + (Double) record[11], (Double) record[5] + (Double) record[6]
                            + (Double) record[7] + (Double) record[8] + (Double) record[9]
                            + (Double) record[12]);
                    break;
                case 8: // Connector Ramp
                    driveAloneProfile
                            .addConnectorRampTravel((Double) record[0], (Double) record[5]);
                    carpoolProfile.addConnectorRampTravel((Double) record[1], (Double) record[6]);
                    lhdtProfile.addConnectorRampTravel((Double) record[2], (Double) record[7]);
                    mhdtProfile.addConnectorRampTravel((Double) record[3], (Double) record[8]);
                    hhdtProfile.addConnectorRampTravel((Double) record[4], (Double) record[9]);
                    transitProfile.addConnectorRampTravel((Double) record[11], (Double) record[12]);
                    totalProfile.addConnectorRampTravel((Double) record[0] + (Double) record[1]
                            + (Double) record[2] + (Double) record[3] + (Double) record[4]
                            + (Double) record[11], (Double) record[5] + (Double) record[6]
                            + (Double) record[7] + (Double) record[8] + (Double) record[9]
                            + (Double) record[12]);
                    break;
                case 9: // Ramp
                    driveAloneProfile.addRampTravel((Double) record[0], (Double) record[5]);
                    carpoolProfile.addRampTravel((Double) record[1], (Double) record[6]);
                    lhdtProfile.addRampTravel((Double) record[2], (Double) record[7]);
                    mhdtProfile.addRampTravel((Double) record[3], (Double) record[8]);
                    hhdtProfile.addRampTravel((Double) record[4], (Double) record[9]);
                    transitProfile.addRampTravel((Double) record[11], (Double) record[12]);
                    totalProfile.addRampTravel((Double) record[0] + (Double) record[1]
                            + (Double) record[2] + (Double) record[3] + (Double) record[4]
                            + (Double) record[11], (Double) record[5] + (Double) record[6]
                            + (Double) record[7] + (Double) record[8] + (Double) record[9]
                            + (Double) record[12]);
                    break;
                case 10: // Access
                    driveAloneProfile.addAccessTravel((Double) record[0], (Double) record[5]);
                    carpoolProfile.addAccessTravel((Double) record[1], (Double) record[6]);
                    lhdtProfile.addAccessTravel((Double) record[2], (Double) record[7]);
                    mhdtProfile.addAccessTravel((Double) record[3], (Double) record[8]);
                    hhdtProfile.addAccessTravel((Double) record[4], (Double) record[9]);
                    transitProfile.addAccessTravel((Double) record[11], (Double) record[12]);
                    totalProfile.addAccessTravel((Double) record[0] + (Double) record[1]
                            + (Double) record[2] + (Double) record[3] + (Double) record[4]
                            + (Double) record[11], (Double) record[5] + (Double) record[6]
                            + (Double) record[7] + (Double) record[8] + (Double) record[9]
                            + (Double) record[12]);
                    break;
            }
        }

        return profiles;
    }
}

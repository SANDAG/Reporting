package org.sandag.abm.report.persistence;

import java.util.Arrays;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.sandag.abm.report.model.SimulatedTrip;
import org.sandag.abm.report.model.SimulatedTripId;
import org.sandag.abm.report.statistics.ModeShare;
import org.springframework.stereotype.Repository;

@Repository
public class SimulatedTripDao
        extends BaseDao<SimulatedTrip, SimulatedTripId>
{
    public SimulatedTripDao()
    {
        super(SimulatedTrip.class, SimulatedTripId.class);
    }

    public ModeShare getResidentModeShare(Short scenarioId)
    {
        Byte[] modelTypes = new Byte[] {new Byte((byte) 0), new Byte((byte) 1), new Byte((byte) 3)};
        ModeShare modeShare = new ModeShare();

        Criteria criteria = startQuery().add(Restrictions.eq("id.scenarioId", scenarioId)).add(
                Restrictions.in("id.modelType", modelTypes));
        criteria.setProjection(Projections.projectionList().add(Projections.sum("partySize"))
                .add(Projections.groupProperty("mode")));

        @SuppressWarnings("unchecked")
        List<Object[]> list = criteria.list();

        for (Object[] record : list)
        {
            // [0] = Total Trips
            // [1] = Mode
            if (Arrays.asList((byte) 1, (byte) 2).contains(record[1])) // Drive
                                                                       // Alone
            {
                modeShare.addDriveAloneTrips((Long) record[0]);
            } else if (Arrays.asList((byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8)
                    .contains(record[1])) // Carpool
            {
                modeShare.addCarpoolTrips((Long) record[0]);
            } else if (Arrays.asList((byte) 9).contains(record[1])) // Walk
            {
                modeShare.addWalkTrips((Long) record[0]);
            } else if (Arrays.asList((byte) 10).contains(record[1])) // Bike
            {
                modeShare.addBikeTrips((Long) record[0]);
            } else if (Arrays.asList((byte) 11, (byte) 12, (byte) 13, (byte) 14, (byte) 15,
                    (byte) 16, (byte) 17, (byte) 18, (byte) 19, (byte) 20, (byte) 21, (byte) 22,
                    (byte) 23, (byte) 24, (byte) 25).contains(record[1])) // Transit
            {
                modeShare.addTransitTrips((Long) record[0]);
            } else
            {
                modeShare.addOtherTrips((Long) record[0]);
            }
        }

        return modeShare;
    }
}

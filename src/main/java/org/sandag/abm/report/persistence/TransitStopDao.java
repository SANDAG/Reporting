package org.sandag.abm.report.persistence;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.sandag.abm.report.model.TransitStop;
import org.sandag.abm.report.model.TransitStopId;
import org.springframework.stereotype.Repository;

@Repository
public class TransitStopDao
        extends BaseDao<TransitStop, TransitStopId>
{
    private static final byte  COMMUTER_RAIL     = (byte) 4;
    private static final byte  LIGHT_RAIL        = (byte) 5;
    private static final byte  REGIONAL_BRT      = (byte) 6;
    private static final byte  EXPRESS_BUS       = (byte) 8;
    private static final byte  LOCAL_BUS         = (byte) 10;

    public static final String COMMUTER_RAIL_KEY = "commuterRail";
    public static final String LIGHT_RAIL_KEY    = "lightRail";
    public static final String REGIONAL_BRT_KEY  = "regionalBrt";
    public static final String EXPRESS_BUS_KEY   = "expressBus";
    public static final String LOCAL_BUS_KEY     = "localBus";

    public TransitStopDao()
    {
        super(TransitStop.class, TransitStopId.class);
    }

    public double getTotalBoardings(Short aScenarioId)
    {
        Criteria criteria = startQuery().add(Restrictions.eq("id.scenarioId", aScenarioId));
        criteria.setProjection(Projections.sum("boardings"));

        return ((BigDecimal) criteria.list().get(0)).doubleValue();
    }

    public double getTotalAlightings(Short aScenarioId)
    {
        Criteria criteria = startQuery().add(Restrictions.eq("id.scenarioId", aScenarioId));
        criteria.setProjection(Projections.sum("alightings"));

        return ((BigDecimal) criteria.list().get(0)).doubleValue();
    }

    public HashMap<String, Double> getBoardingsByMainMode(Short scenarioId)
    {
        HashMap<String, Double> mainModeBoardings = new HashMap<String, Double>();
        mainModeBoardings.put(COMMUTER_RAIL_KEY, new Double(0));
        mainModeBoardings.put(LIGHT_RAIL_KEY, new Double(0));
        mainModeBoardings.put(REGIONAL_BRT_KEY, new Double(0));
        mainModeBoardings.put(EXPRESS_BUS_KEY, new Double(0));
        mainModeBoardings.put(LOCAL_BUS_KEY, new Double(0));

        Criteria criteria = startQuery().add(Restrictions.eq("id.scenarioId", scenarioId));
        criteria.setProjection(Projections.projectionList().add(Projections.sum("boardings"))
                .add(Projections.groupProperty("id.mainModeId")));

        @SuppressWarnings("unchecked")
        List<Object[]> list = criteria.list();

        for (Object[] record : list)
        {
            // [0] = Boardings
            // [1] = Main Mode
            switch (((Byte) record[1]).byteValue())
            {
                case COMMUTER_RAIL:
                    mainModeBoardings.put(COMMUTER_RAIL_KEY,
                            new Double(((BigDecimal) record[0]).doubleValue()));
                    break;
                case LIGHT_RAIL:
                    mainModeBoardings.put(LIGHT_RAIL_KEY,
                            new Double(((BigDecimal) record[0]).doubleValue()));
                    break;
                case REGIONAL_BRT:
                    mainModeBoardings.put(REGIONAL_BRT_KEY,
                            new Double(((BigDecimal) record[0]).doubleValue()));
                    break;
                case EXPRESS_BUS:
                    mainModeBoardings.put(EXPRESS_BUS_KEY,
                            new Double(((BigDecimal) record[0]).doubleValue()));
                    break;
                case LOCAL_BUS:
                    mainModeBoardings.put(LOCAL_BUS_KEY,
                            new Double(((BigDecimal) record[0]).doubleValue()));
                    break;
            }
        }

        return mainModeBoardings;
    }
}

package org.sandag.abm.report.statistics;

import java.util.HashMap;

public class ModeShare
{
    private static final String   DRIVE_ALONE = "drive_alone";
    private static final String   CARPOOL     = "carpool";
    private static final String   WALK        = "walk";
    private static final String   BIKE        = "bike";
    private static final String   TRANSIT     = "transit";
    private static final String   OTHER       = "other";

    private HashMap<String, Long> modeTrips;

    public ModeShare()
    {
        modeTrips = new HashMap<String, Long>();

        modeTrips.put(DRIVE_ALONE, new Long(0));
        modeTrips.put(CARPOOL, new Long(0));
        modeTrips.put(WALK, new Long(0));
        modeTrips.put(BIKE, new Long(0));
        modeTrips.put(TRANSIT, new Long(0));
        modeTrips.put(OTHER, new Long(0));
    }

    public long getTotalTrips()
    {
        long trips = 0;
        for (Long tripByMode : modeTrips.values())
            trips += tripByMode.longValue();

        return trips;
    }

    public long addDriveAloneTrips(long trips)
    {
        return addTrips(DRIVE_ALONE, trips);
    }

    public long subtractDriveAloneTrips(long trips)
    {
        return substractTrips(DRIVE_ALONE, trips);
    }

    public long getDriveAloneTrips()
    {
        return modeTrips.get(DRIVE_ALONE).longValue();
    }

    public double getDriveAloneModeShare()
    {
        return getModeShare(DRIVE_ALONE);
    }

    public long addCarpoolTrips(long trips)
    {
        return addTrips(CARPOOL, trips);
    }

    public long subtractCarpoolTrips(long trips)
    {
        return substractTrips(CARPOOL, trips);
    }

    public long getCarpoolTrips()
    {
        return modeTrips.get(CARPOOL).longValue();
    }

    public double getCarpoolModeShare()
    {
        return getModeShare(CARPOOL);
    }

    public long addWalkTrips(long trips)
    {
        return addTrips(WALK, trips);
    }

    public long subtractWalkTrips(long trips)
    {
        return substractTrips(WALK, trips);
    }

    public long getWalkTrips()
    {
        return modeTrips.get(WALK).longValue();
    }

    public double getWalkModeShare()
    {
        return getModeShare(WALK);
    }

    public long addBikeTrips(long trips)
    {
        return addTrips(BIKE, trips);
    }

    public long subtractBikeTrips(long trips)
    {
        return substractTrips(BIKE, trips);
    }

    public long getBikeTrips()
    {
        return modeTrips.get(BIKE).longValue();
    }

    public double getBikeModeShare()
    {
        return getModeShare(BIKE);
    }

    public long addTransitTrips(long trips)
    {
        return addTrips(TRANSIT, trips);
    }

    public long subtractTransitTrips(long trips)
    {
        return substractTrips(TRANSIT, trips);
    }

    public long getTransitTrips()
    {
        return modeTrips.get(TRANSIT).longValue();
    }

    public double getTransitModeShare()
    {
        return getModeShare(TRANSIT);
    }

    public long addOtherTrips(long trips)
    {
        return addTrips(OTHER, trips);
    }

    public long subtractOtherTrips(long trips)
    {
        return substractTrips(OTHER, trips);
    }

    public long getOtherTrips()
    {
        return modeTrips.get(OTHER).longValue();
    }

    public double getOtherModeShare()
    {
        return getModeShare(OTHER);
    }

    private long addTrips(String mode, long newTrips)
    {
        long trips = modeTrips.get(mode).longValue() + newTrips;
        modeTrips.put(mode, new Long(trips));

        return trips;
    }

    private long substractTrips(String mode, long newTrips)
    {
        long trips = modeTrips.get(mode).longValue() - newTrips;
        if (trips < 0) trips = 0;

        modeTrips.put(mode, new Long(trips));

        return trips;
    }

    private double getModeShare(String mode)
    {
        double trips = modeTrips.get(mode).doubleValue();

        return trips / getTotalTrips();
    }

}

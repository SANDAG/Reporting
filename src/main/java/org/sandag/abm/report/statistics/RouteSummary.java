package org.sandag.abm.report.statistics;

public class RouteSummary
{
    private int    routeNumber;
    private byte   modeId;
    private double boardings;
    private double alightings;

    public RouteSummary(int aRouteNumber, byte aModeId, double theBoardings, double theAlightings)
    {
        this.routeNumber = aRouteNumber;
        this.modeId = aModeId;
        this.boardings = theBoardings;
        this.alightings = theAlightings;
    }

    public int getRouteNumber()
    {
        return routeNumber;
    }

    public byte getModeId()
    {
        return modeId;
    }

    public double getBoardings()
    {
        return boardings;
    }

    public double getAlightings()
    {
        return alightings;
    }

}

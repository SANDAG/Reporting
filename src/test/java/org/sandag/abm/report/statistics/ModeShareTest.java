package org.sandag.abm.report.statistics;

import static org.junit.Assert.*;
import org.junit.Test;

public class ModeShareTest
{
    private long firstAddition     = 25;
    private long secondAddition    = 600;

    private long firstSubstraction = 50;
    private long bigSubtraction    = 1000000;

    private long altModeAddition   = 1000;

    @Test
    public void testDriveAloneTrips()
    {
        ModeShare modeShare = new ModeShare();
        modeShare.addDriveAloneTrips(firstAddition);

        assertEquals(firstAddition, modeShare.getDriveAloneTrips());

        modeShare.addDriveAloneTrips(secondAddition);

        assertEquals(firstAddition + secondAddition, modeShare.getDriveAloneTrips());

        modeShare.addOtherTrips(altModeAddition);

        assertEquals(firstAddition + secondAddition + altModeAddition, modeShare.getTotalTrips());

        assertEquals((double) (firstAddition + secondAddition)
                / (firstAddition + secondAddition + altModeAddition),
                modeShare.getDriveAloneModeShare(), 0.000001);

        modeShare.subtractDriveAloneTrips(firstSubstraction);

        assertEquals((firstAddition + secondAddition - firstSubstraction),
                modeShare.getDriveAloneTrips());

        assertEquals(firstAddition + secondAddition + altModeAddition - firstSubstraction,
                modeShare.getTotalTrips());

        modeShare.subtractDriveAloneTrips(bigSubtraction);
        assertEquals(0, modeShare.getDriveAloneTrips());
    }

    @Test
    public void testCarpoolTrips()
    {
        ModeShare modeShare = new ModeShare();
        modeShare.addCarpoolTrips(firstAddition);

        assertEquals(firstAddition, modeShare.getCarpoolTrips());

        modeShare.addCarpoolTrips(secondAddition);

        assertEquals(firstAddition + secondAddition, modeShare.getCarpoolTrips());

        modeShare.addOtherTrips(altModeAddition);

        assertEquals(firstAddition + secondAddition + altModeAddition, modeShare.getTotalTrips());

        assertEquals((double) (firstAddition + secondAddition)
                / (firstAddition + secondAddition + altModeAddition),
                modeShare.getCarpoolModeShare(), 0.000001);

        modeShare.subtractCarpoolTrips(firstSubstraction);

        assertEquals((firstAddition + secondAddition - firstSubstraction),
                modeShare.getCarpoolTrips());

        assertEquals(firstAddition + secondAddition + altModeAddition - firstSubstraction,
                modeShare.getTotalTrips());

        modeShare.subtractCarpoolTrips(bigSubtraction);
        assertEquals(0, modeShare.getCarpoolTrips());
    }

    @Test
    public void testWalkTrips()
    {
        ModeShare modeShare = new ModeShare();
        modeShare.addWalkTrips(firstAddition);

        assertEquals(firstAddition, modeShare.getWalkTrips());

        modeShare.addWalkTrips(secondAddition);

        assertEquals(firstAddition + secondAddition, modeShare.getWalkTrips());

        modeShare.addOtherTrips(altModeAddition);

        assertEquals(firstAddition + secondAddition + altModeAddition, modeShare.getTotalTrips());

        assertEquals((double) (firstAddition + secondAddition)
                / (firstAddition + secondAddition + altModeAddition), modeShare.getWalkModeShare(),
                0.000001);

        modeShare.subtractWalkTrips(firstSubstraction);

        assertEquals((firstAddition + secondAddition - firstSubstraction), modeShare.getWalkTrips());

        assertEquals(firstAddition + secondAddition + altModeAddition - firstSubstraction,
                modeShare.getTotalTrips());

        modeShare.subtractWalkTrips(bigSubtraction);
        assertEquals(0, modeShare.getWalkTrips());
    }

    @Test
    public void testBikeTrips()
    {
        ModeShare modeShare = new ModeShare();
        modeShare.addBikeTrips(firstAddition);

        assertEquals(firstAddition, modeShare.getBikeTrips());

        modeShare.addBikeTrips(secondAddition);

        assertEquals(firstAddition + secondAddition, modeShare.getBikeTrips());

        modeShare.addOtherTrips(altModeAddition);

        assertEquals(firstAddition + secondAddition + altModeAddition, modeShare.getTotalTrips());

        assertEquals((double) (firstAddition + secondAddition)
                / (firstAddition + secondAddition + altModeAddition), modeShare.getBikeModeShare(),
                0.000001);

        modeShare.subtractBikeTrips(firstSubstraction);

        assertEquals((firstAddition + secondAddition - firstSubstraction), modeShare.getBikeTrips());

        assertEquals(firstAddition + secondAddition + altModeAddition - firstSubstraction,
                modeShare.getTotalTrips());

        modeShare.subtractBikeTrips(bigSubtraction);
        assertEquals(0, modeShare.getBikeTrips());
    }

    @Test
    public void testTransitTrips()
    {
        ModeShare modeShare = new ModeShare();
        modeShare.addTransitTrips(firstAddition);

        assertEquals(firstAddition, modeShare.getTransitTrips());

        modeShare.addTransitTrips(secondAddition);

        assertEquals(firstAddition + secondAddition, modeShare.getTransitTrips());

        modeShare.addOtherTrips(altModeAddition);

        assertEquals(firstAddition + secondAddition + altModeAddition, modeShare.getTotalTrips());

        assertEquals((double) (firstAddition + secondAddition)
                / (firstAddition + secondAddition + altModeAddition),
                modeShare.getTransitModeShare(), 0.000001);

        modeShare.subtractTransitTrips(firstSubstraction);

        assertEquals((firstAddition + secondAddition - firstSubstraction),
                modeShare.getTransitTrips());

        assertEquals(firstAddition + secondAddition + altModeAddition - firstSubstraction,
                modeShare.getTotalTrips());

        modeShare.subtractTransitTrips(bigSubtraction);
        assertEquals(0, modeShare.getTransitTrips());
    }

    @Test
    public void testOtherTrips()
    {
        ModeShare modeShare = new ModeShare();
        modeShare.addOtherTrips(firstAddition);

        assertEquals(firstAddition, modeShare.getOtherTrips());

        modeShare.addOtherTrips(secondAddition);

        assertEquals(firstAddition + secondAddition, modeShare.getOtherTrips());

        modeShare.addDriveAloneTrips(altModeAddition);

        assertEquals(firstAddition + secondAddition + altModeAddition, modeShare.getTotalTrips());

        assertEquals((double) (firstAddition + secondAddition)
                / (firstAddition + secondAddition + altModeAddition),
                modeShare.getOtherModeShare(), 0.000001);

        modeShare.subtractOtherTrips(firstSubstraction);

        assertEquals((firstAddition + secondAddition - firstSubstraction),
                modeShare.getOtherTrips());

        assertEquals(firstAddition + secondAddition + altModeAddition - firstSubstraction,
                modeShare.getTotalTrips());

        modeShare.subtractOtherTrips(bigSubtraction);
        assertEquals(0, modeShare.getOtherTrips());
    }

}

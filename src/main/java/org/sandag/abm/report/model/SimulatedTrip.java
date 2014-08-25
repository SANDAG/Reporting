package org.sandag.abm.report.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TRIP_MICRO_SIMUL")
public class SimulatedTrip implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    private SimulatedTripId id;
    
    @Column(name="PARTYSIZE")
    private byte partySize;
    
    @Column(name="ORIG_MGRA")
    private short originMgra;
    
    @Column(name="DEST_MGRA")
    private short destinationMgra;
    
    @Column(name="PERIOD_ID")
    private byte period;
    
    @Column(name="INBOUND")
    private boolean inbound;
    
    @Column(name="TRIP_BOARD_TAP")
    private short boardingTap;
    
    @Column(name="TRIP_ALIGHT_TAP")
    private short alightingTap;
    
    @Column(name="TRIP_TIME", columnDefinition="real")
    private float tavelTime;
    
    @Column(name="OUT_VEHICLE_TIME", columnDefinition="real")
    private double outVehicleTime;
    
    @Column(name="TRIP_DISTANCE", columnDefinition="real")
    private double tripDistance;
    
    @Column(name="TRIP_COST", columnDefinition="real")
    private double tripCost;
    
    @Column(name="MODE_ID")
    private byte mode;
    
    @Column(name="PURPOSE_ID")
    private byte purposeId;
    
    @Column(name="PARKING_MGRA")
    private short parkingMGRA;
}

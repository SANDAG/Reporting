package org.sandag.abm.report.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class TransitStopId implements Serializable
{
    private static final long serialVersionUID = 1L;

    @NotNull
    @Column(name= "SCENARIO_ID")
    private Short scenarioId;
    
    @NotNull
    @Column(name= "ROUTE_ID")
    private Short routeId;
    
    @NotNull
    @Column(name= "MAIN_MODE_ID")
    private Byte mainModeId;
    
    @NotNull
    @Column(name= "ACCESS_MODE_ID")
    private Byte accessModeId;
    
    @NotNull
    @Column(name= "TOD_ID")
    private Byte timeOfDay;
    
    @NotNull
    @Column(name= "STOP_ID")
    private Short stopId;

    public TransitStopId(Short scenarioId, Short routeId, Byte mainModeId, Byte accessModeId,
            Byte timeOfDay, Short stopId)
    {
        this.scenarioId = scenarioId;
        this.routeId = routeId;
        this.mainModeId = mainModeId;
        this.accessModeId = accessModeId;
        this.timeOfDay = timeOfDay;
        this.stopId = stopId;
    }

    public Short getScenarioId()
    {
        return scenarioId;
    }

    public void setScenarioId(Short scenarioId)
    {
        this.scenarioId = scenarioId;
    }

    public Short getRouteId()
    {
        return routeId;
    }

    public void setRouteId(Short routeId)
    {
        this.routeId = routeId;
    }

    public Byte getMainModeId()
    {
        return mainModeId;
    }

    public void setMainModeId(Byte mainModeId)
    {
        this.mainModeId = mainModeId;
    }

    public Byte getAccessModeId()
    {
        return accessModeId;
    }

    public void setAccessModeId(Byte accessModeId)
    {
        this.accessModeId = accessModeId;
    }

    public Byte getTimeOfDay()
    {
        return timeOfDay;
    }

    public void setTimeOfDay(Byte timeOfDay)
    {
        this.timeOfDay = timeOfDay;
    }

    public Short getStopId()
    {
        return stopId;
    }

    public void setStopId(Short stopId)
    {
        this.stopId = stopId;
    }
}

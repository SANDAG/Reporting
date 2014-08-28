package org.sandag.abm.report.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class TransitRouteId
        implements Serializable
{
    private static final long serialVersionUID = 1L;

    @NotNull
    @Column(name = "SCENARIO_ID")
    private Short             scenarioId;

    @NotNull
    @Column(name = "ROUTE_ID")
    private Short             routeId;

    public TransitRouteId()
    {
        
    }
    
    public TransitRouteId(Short aScenarioId, Short aRouteId)
    {
        this.scenarioId = aScenarioId;
        this.routeId = aRouteId;
    }

    public Short getScenarioId()
    {
        return scenarioId;
    }

    public void setScenarioId(Short aScenarioId)
    {
        this.scenarioId = aScenarioId;
    }

    public Short getRouteId()
    {
        return routeId;
    }

    public void setRouteId(Short routeId)
    {
        this.routeId = routeId;
    }
}

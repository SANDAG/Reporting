package org.sandag.abm.report.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class SimulatedTripId implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @NotNull
    @Column(name = "SCENARIO_ID")
    private Short   scenarioId;

    @NotNull
    @Column(name = "MODEL_TYPE_ID")
    private Byte    modelType;

    @NotNull
    @Column(name = "TOUR_ID")
    private Integer tourId;

    @NotNull
    @Column(name = "TRIP_ID")
    private Integer tripId;

    public SimulatedTripId(Short aScenarioId, Byte aModelType, Integer aTourId, Integer aTripId)
    {
        this.scenarioId = aScenarioId;
        this.modelType = aModelType;
        this.tourId = aTourId;
        this.tripId = aTripId;
    }

    public Short getScenarioId()
    {
        return scenarioId;
    }

    public void setScenarioId(Short scenarioId)
    {
        this.scenarioId = scenarioId;
    }

    public Byte getModelType()
    {
        return modelType;
    }

    public void setModelType(Byte modelType)
    {
        this.modelType = modelType;
    }

    public Integer getTourId()
    {
        return tourId;
    }

    public void setTourId(Integer tourId)
    {
        this.tourId = tourId;
    }

    public Integer getTripId()
    {
        return tripId;
    }

    public void setTripId(Integer tripId)
    {
        this.tripId = tripId;
    }
}

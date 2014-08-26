package org.sandag.abm.report.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class HighwayLinkId implements Serializable
{
    static final long serialVersionUID = 1L;

    @NotNull
    @Column(name = "SCENARIO_ID")
    private Short   scenarioId;

    @NotNull
    @Column(name = "HWYCOV_ID")
    private Integer hwyCovId;

    @NotNull
    @Column(name = "TOD_ID")
    private Byte   timeOfDay;

    @NotNull
    @Column(name = "AB")
    private Boolean direction;

    public HighwayLinkId(Short aScenarioId, Integer aHwyCovId, Byte aTimeOfDay, Boolean aDirection)
    {
        this.scenarioId = aScenarioId;
        this.hwyCovId = aHwyCovId;
        this.timeOfDay = aTimeOfDay;
        this.direction = aDirection;
    }

    public Short getScenarioId()
    {
        return scenarioId;
    }

    public void setScenarioId(Short scenarioId)
    {
        this.scenarioId = scenarioId;
    }

    public Integer getHwyCovId()
    {
        return hwyCovId;
    }

    public void setHwyCovId(Integer hwyCovId)
    {
        this.hwyCovId = hwyCovId;
    }

    public Byte getTimeOfDay()
    {
        return timeOfDay;
    }

    public void setTimeOfDay(Byte timeOfDay)
    {
        this.timeOfDay = timeOfDay;
    }

    public Boolean getDirection()
    {
        return direction;
    }

    public void setDirection(Boolean direction)
    {
        this.direction = direction;
    }
}

package org.sandag.abm.report.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSIT_ONOFF")
public class TransitStop
        implements Serializable
{
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private TransitStopId     id;

    @Column(name = "BOARDINGS", columnDefinition = "decimal", precision = 11, scale = 6)
    private double            boardings;

    @Column(name = "ALIGHTINGS", columnDefinition = "decimal", precision = 11, scale = 6)
    private double            alightings;

    @ManyToOne
    @JoinColumns(value = {@JoinColumn(name = "ROUTE_ID", insertable = false, updatable = false),
            @JoinColumn(name = "SCENARIO_ID", insertable = false, updatable = false)})
    private TransitRoute      transitRoute;

    public TransitStopId getId()
    {
        return id;
    }

    public void setId(TransitStopId id)
    {
        this.id = id;
    }

    public double getBoardings()
    {
        return boardings;
    }

    public void setBoardings(double boardings)
    {
        this.boardings = boardings;
    }

    public double getAlightings()
    {
        return alightings;
    }

    public void setAlightings(double alightings)
    {
        this.alightings = alightings;
    }

    public TransitRoute getTransitRoute()
    {
        return this.transitRoute;
    }

    public void setTransitRoute(TransitRoute aTransitRoute)
    {
        this.transitRoute = aTransitRoute;
    }
}

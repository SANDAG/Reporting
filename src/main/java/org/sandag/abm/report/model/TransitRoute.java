package org.sandag.abm.report.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSIT_ROUTE")
public class TransitRoute
        implements Serializable
{
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private TransitRouteId    id;

    @Column(name = "ROUTE_NAME")
    private String            routeName;

    @Column(name = "TRANSIT_MODE_ID")
    private byte              transitModeId;

    @Column(name = "AM_HEADWAY", columnDefinition = "decimal", precision = 5, scale = 2)
    private double            amHeadway;

    @Column(name = "PM_HEADWAY", columnDefinition = "decimal", precision = 5, scale = 2)
    private double            pmHeadway;

    @Column(name = "OP_HEADWAY", columnDefinition = "decimal", precision = 5, scale = 2)
    private double            opHeadway;

    @Column(name = "CONFIG")
    private int               config;

    @Column(name = "FARE", columnDefinition = "decimal", precision = 11, scale = 6)
    private double            fare;

    public TransitRouteId getId()
    {
        return id;
    }

    public void setId(TransitRouteId id)
    {
        this.id = id;
    }

    public String getRouteName()
    {
        return routeName;
    }

    public void setRouteName(String routeName)
    {
        this.routeName = routeName;
    }

    public byte getTransitModeId()
    {
        return transitModeId;
    }

    public void setTransitModeId(byte transitModeId)
    {
        this.transitModeId = transitModeId;
    }

    public double getAmHeadway()
    {
        return amHeadway;
    }

    public void setAmHeadway(double amHeadway)
    {
        this.amHeadway = amHeadway;
    }

    public double getPmHeadway()
    {
        return pmHeadway;
    }

    public void setPmHeadway(double pmHeadway)
    {
        this.pmHeadway = pmHeadway;
    }

    public double getOpHeadway()
    {
        return opHeadway;
    }

    public void setOpHeadway(double opHeadway)
    {
        this.opHeadway = opHeadway;
    }

    public int getConfig()
    {
        return config;
    }

    public void setConfig(int config)
    {
        this.config = config;
    }

    public double getFare()
    {
        return fare;
    }

    public void setFare(double fare)
    {
        this.fare = fare;
    }
}

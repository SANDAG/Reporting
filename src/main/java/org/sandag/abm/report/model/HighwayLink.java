package org.sandag.abm.report.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.Formula;

@Entity
@Table(name = "VI_HWYCOV")
public class HighwayLink
        implements Serializable
{
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private HighwayLinkId     id;

    @Column(name = "TOTAL_FLOW")
    private BigDecimal        flow;

    @Column(name = "LENGTH_MILE", columnDefinition = "float")
    private double            length;

    @Column(name = "VMT")
    private double            vmt;

    @Column(name = "VHT", columnDefinition = "decimal", precision = 31, scale = 18)
    private BigDecimal        vht;

    @Column(name = "IFC")
    private byte              ifc;

    @Formula("(FLOW_SOV_GP + FLOW_SOV_PAY) * LENGTH_MILE")
    private Double            driveAloneVmt;

    @Formula("(FLOW_SR2_GP + FLOW_SR2_HOV + FLOW_SR2_PAY + FLOW_SR3_GP + FLOW_SR3_HOV + FLOW_SR3_PAY) * LENGTH_MILE")
    private Double            carpoolVmt;

    @Formula("(FLOW_LHDN + FLOW_LHDT) * LENGTH_MILE")
    private Double            lhdtVmt;

    @Formula("(FLOW_MHDN + FLOW_MHDT) * LENGTH_MILE")
    private Double            mhdtVmt;

    @Formula("(FLOW_HHDN + FLOW_HHDT) * LENGTH_MILE")
    private Double            hhdtVmt;

    @Formula("FLOW_TRANSIT * LENGTH_MILE")
    private Double            transitVmt;

    @Formula("(FLOW_SOV_GP + FLOW_SOV_PAY) * (TIME / 60)")
    private Double            driveAloneVht;

    @Formula("(FLOW_SR2_GP + FLOW_SR2_HOV + FLOW_SR2_PAY + FLOW_SR3_GP + FLOW_SR3_HOV + FLOW_SR3_PAY) * (TIME / 60)")
    private Double            carpoolVht;

    @Formula("(FLOW_LHDN + FLOW_LHDT) * (TIME / 60)")
    private Double            lhdtVht;

    @Formula("(FLOW_MHDN + FLOW_MHDT) * (TIME / 60)")
    private Double            mhdtVht;

    @Formula("(FLOW_HHDN + FLOW_HHDT) * (TIME / 60)")
    private Double            hhdtVht;

    @Formula("FLOW_TRANSIT * (TIME / 60)")
    private Double            transitVht;

    public HighwayLinkId getId()
    {
        return id;
    }

    public void setId(HighwayLinkId id)
    {
        this.id = id;
    }

    public BigDecimal getFlow()
    {
        return flow;
    }

    public void setFlow(BigDecimal flow)
    {
        this.flow = flow;
    }

    public double getLength()
    {
        return length;
    }

    public void setLength(double length)
    {
        this.length = length;
    }

    public double getVmt()
    {
        return vmt;
    }

    public void setVmt(double vmt)
    {
        this.vmt = vmt;
    }

    public BigDecimal getVht()
    {
        return vht;
    }

    public void setVht(BigDecimal vht)
    {
        this.vht = vht;
    }

    public byte getIfc()
    {
        return ifc;
    }

    public void setIfc(byte ifc)
    {
        this.ifc = ifc;
    }

    public Double getDriveAloneVmt()
    {
        return driveAloneVmt;
    }

    public void setDriveAloneVmt(Double driveAloneVmt)
    {
        this.driveAloneVmt = driveAloneVmt;
    }

    public Double getCarpoolVmt()
    {
        return carpoolVmt;
    }

    public void setCarpoolVmt(Double carpoolVmt)
    {
        this.carpoolVmt = carpoolVmt;
    }

    public Double getLhdtVmt()
    {
        return lhdtVmt;
    }

    public void setLhdtVmt(Double lhdtVmt)
    {
        this.lhdtVmt = lhdtVmt;
    }

    public Double getMhdtVmt()
    {
        return mhdtVmt;
    }

    public void setMhdtVmt(Double mhdtVmt)
    {
        this.mhdtVmt = mhdtVmt;
    }

    public Double getHhdtVmt()
    {
        return hhdtVmt;
    }

    public void setHhdtVmt(Double hhdtVmt)
    {
        this.hhdtVmt = hhdtVmt;
    }

    public Double getTransitVmt()
    {
        return transitVmt;
    }

    public void setTransitVmt(Double transitVmt)
    {
        this.transitVmt = transitVmt;
    }

    public Double getDriveAloneVht()
    {
        return driveAloneVht;
    }

    public void setDriveAloneVht(Double driveAloneVht)
    {
        this.driveAloneVht = driveAloneVht;
    }

    public Double getCarpoolVht()
    {
        return carpoolVht;
    }

    public void setCarpoolVht(Double carpoolVht)
    {
        this.carpoolVht = carpoolVht;
    }

    public Double getLhdtVht()
    {
        return lhdtVht;
    }

    public void setLhdtVht(Double lhdtVht)
    {
        this.lhdtVht = lhdtVht;
    }

    public Double getMhdtVht()
    {
        return mhdtVht;
    }

    public void setMhdtVht(Double mhdtVht)
    {
        this.mhdtVht = mhdtVht;
    }

    public Double getHhdtVht()
    {
        return hhdtVht;
    }

    public void setHhdtVht(Double hhdtVht)
    {
        this.hhdtVht = hhdtVht;
    }

    public Double getTransitVht()
    {
        return transitVht;
    }

    public void setTransitVht(Double transitVht)
    {
        this.transitVht = transitVht;
    }
}

package org.sandag.abm.report.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
    private BigDecimal        boardings;

    @Column(name = "ALIGHTINGS", columnDefinition = "decimal", precision = 11, scale = 6)
    private BigDecimal        alightings;

    public TransitStopId getId()
    {
        return id;
    }

    public void setId(TransitStopId id)
    {
        this.id = id;
    }

    public BigDecimal getBoardings()
    {
        return boardings;
    }

    public void setBoardings(BigDecimal boardings)
    {
        this.boardings = boardings;
    }

    public BigDecimal getAlightings()
    {
        return alightings;
    }

    public void setAlightings(BigDecimal alightings)
    {
        this.alightings = alightings;
    }
}

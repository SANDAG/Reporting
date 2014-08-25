package org.sandag.abm.report.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SCENARIO")
public class Scenario
{
    @Id
    @Column(name = "SCENARIO_ID")
    private Short   id;

    @Column(name = "SCENARIO_YEAR")
    private Short year;

    @Column(name = "SCENARIO_DESC")
    private String  description;

    @Column(name = "PATH")
    private String  path;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_LOADED")
    private Date    loaded;

    @Column(name = "COMPLETE")
    private boolean complete;

    @Column(name = "[USER]")
    private String  user;

    public Short getId()
    {
        return id;
    }

    public void setId(Short id)
    {
        this.id = id;
    }

    public Short getYear()
    {
        return year;
    }

    public void setYear(Short year)
    {
        this.year = year;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getPath()
    {
        return path;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public Date getLoaded()
    {
        return loaded;
    }

    public void setLoaded(Date loaded)
    {
        this.loaded = loaded;
    }

    public boolean isComplete()
    {
        return complete;
    }

    public void setComplete(boolean complete)
    {
        this.complete = complete;
    }

    public String getUser()
    {
        return user;
    }

    public void setUser(String user)
    {
        this.user = user;
    }
}

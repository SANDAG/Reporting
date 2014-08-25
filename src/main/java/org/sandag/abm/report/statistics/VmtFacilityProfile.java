package org.sandag.abm.report.statistics;

import java.util.HashMap;

public class VmtFacilityProfile
{
    private static final Integer FREEWAY_IFC = new Integer(1);
    private static final Integer PRIME_IFC = new Integer(2);
    private static final Integer MAJOR_IFC = new Integer(3);
    private static final Integer COLLECTOR_IFC = new Integer(4);
    private static final Integer LOCAL_COLLECTOR_IFC = new Integer(5);
    private static final Integer RURAL_COLLECTOR_IFC = new Integer(6);
    private static final Integer LOCAL_IFC = new Integer(7);
    private static final Integer CONNECTOR_RAMP_IFC = new Integer(8);
    private static final Integer RAMP_IFC = new Integer(9);
    private static final Integer ACCESS_IFC = new Integer(10);
    
    private final HashMap<Integer, Double> vmtHash;
    private final HashMap<Integer, Double> vhtHash;
    
    public VmtFacilityProfile()
    {
        vmtHash = new HashMap<Integer, Double>();
        vhtHash = new HashMap<Integer, Double>();
        
        vmtHash.put(FREEWAY_IFC, new Double(0));
        vmtHash.put(PRIME_IFC, new Double(0));
        vmtHash.put(MAJOR_IFC, new Double(0));
        vmtHash.put(COLLECTOR_IFC, new Double(0));
        vmtHash.put(LOCAL_COLLECTOR_IFC, new Double(0));
        vmtHash.put(RURAL_COLLECTOR_IFC, new Double(0));
        vmtHash.put(LOCAL_IFC, new Double(0));
        vmtHash.put(CONNECTOR_RAMP_IFC, new Double(0));
        vmtHash.put(RAMP_IFC, new Double(0));
        vmtHash.put(ACCESS_IFC, new Double(0));
        
        vhtHash.put(FREEWAY_IFC, new Double(0));
        vhtHash.put(PRIME_IFC, new Double(0));
        vhtHash.put(MAJOR_IFC, new Double(0));
        vhtHash.put(COLLECTOR_IFC, new Double(0));
        vhtHash.put(LOCAL_COLLECTOR_IFC, new Double(0));
        vhtHash.put(RURAL_COLLECTOR_IFC, new Double(0));
        vhtHash.put(LOCAL_IFC, new Double(0));
        vhtHash.put(CONNECTOR_RAMP_IFC, new Double(0));
        vhtHash.put(RAMP_IFC, new Double(0));
        vhtHash.put(ACCESS_IFC, new Double(0));
    }
    
    private double[] addTravel(Integer ifc, double vmt, double vht)
    {
        double newVMT = vmtHash.get(ifc).doubleValue() + vmt;
        vmtHash.put(ifc, new Double(newVMT));
        
        double newVHT = vhtHash.get(ifc).doubleValue() + vht;
        vhtHash.put(ifc, new Double(newVHT));
        
        return new double[]{vmtHash.get(ifc).doubleValue(), vhtHash.get(ifc).doubleValue()};
    }
    
    public double[] addFreewayTravel(double vmt, double vht)
    {
        return addTravel(FREEWAY_IFC, vmt, vht);
    }
    
    public double[] addPrimeTravel(double vmt, double vht)
    {
        return addTravel(PRIME_IFC, vmt, vht);
    }
    
    public double[] addMajorTravel(double vmt, double vht)
    {
        return addTravel(MAJOR_IFC, vmt, vht);
    }
    
    public double[] addCollectorTravel(double vmt, double vht)
    {
        return addTravel(COLLECTOR_IFC, vmt, vht);
    }
    
    public double[] addLocalCollectorTravel(double vmt, double vht)
    {
        return addTravel(LOCAL_COLLECTOR_IFC, vmt, vht);
    }
    
    public double[] addRuralCollectorTravel(double vmt, double vht)
    {
        return addTravel(RURAL_COLLECTOR_IFC, vmt, vht);
    }
    
    public double[] addLocalTravel(double vmt, double vht)
    {
        return addTravel(LOCAL_IFC, vmt, vht);
    }
    
    public double[] addConnectorRampTravel(double vmt, double vht)
    {
        return addTravel(CONNECTOR_RAMP_IFC, vmt, vht);
    }
    
    public double[] addRampTravel(double vmt, double vht)
    {
        return addTravel(RAMP_IFC, vmt, vht);
    }
    
    public double[] addAccessTravel(double vmt, double vht)
    {
        return addTravel(ACCESS_IFC, vmt, vht);
    }
    
    public double getFreewayVmt()
    {
        return vmtHash.get(FREEWAY_IFC).doubleValue();
    }
    
    public double getPrimeVmt()
    {
        return vmtHash.get(PRIME_IFC).doubleValue();
    }
    
    public double getMajorVmt()
    {
        return vmtHash.get(MAJOR_IFC).doubleValue();
    }
    
    public double getCollectorVmt()
    {
        return vmtHash.get(COLLECTOR_IFC).doubleValue();   
    }
    
    public double getLocalCollectorVmt()
    {
        return vmtHash.get(LOCAL_COLLECTOR_IFC).doubleValue();
    }
    
    public double getRuralCollectorVmt()
    {
        return vmtHash.get(RURAL_COLLECTOR_IFC).doubleValue();
    }
    
    public double getLocalVmt()
    {
        return vmtHash.get(LOCAL_IFC).doubleValue();
    }
    
    public double getConnectorRampVmt()
    {
        return vmtHash.get(CONNECTOR_RAMP_IFC).doubleValue();
    }
    
    public double getRampVmt()
    {
        return vmtHash.get(RAMP_IFC).doubleValue();
    }
    
    public double getAccessVmt()
    {
        return vmtHash.get(ACCESS_IFC).doubleValue();
    }
    
    public double getTotalVmt()
    {
        double totalVMT = 0.0;
        for(Double facilityVMT : vmtHash.values())
            totalVMT += facilityVMT.doubleValue();
        
        return totalVMT;
    }
    
    public double getFreewayVht()
    {
        return vhtHash.get(FREEWAY_IFC).doubleValue();
    }
    
    public double getPrimeVht()
    {
        return vhtHash.get(PRIME_IFC).doubleValue();
    }
    
    public double getMajorVht()
    {
        return vhtHash.get(MAJOR_IFC).doubleValue();
    }
    
    public double getCollectorVht()
    {
        return vhtHash.get(COLLECTOR_IFC).doubleValue();
    }
    
    public double getLocalCollectorVht()
    {
        return vhtHash.get(LOCAL_COLLECTOR_IFC).doubleValue();
    }
    
    public double getRuralCollectorVht()
    {
        return vhtHash.get(RURAL_COLLECTOR_IFC).doubleValue();
    }
    
    public double getLocalVht()
    {
        return vhtHash.get(LOCAL_IFC).doubleValue();
    }
    
    public double getConnectorRampVht()
    {
        return vhtHash.get(CONNECTOR_RAMP_IFC).doubleValue();
    }
    
    public double getRampVht()
    {
        return vhtHash.get(RAMP_IFC).doubleValue();
    }
    
    public double getAccessVht()
    {
        return vhtHash.get(ACCESS_IFC).doubleValue();
    }
    
    public double getTotalVht()
    {
        double totalVHT = 0.0;
        for(Double facilityVHT : vhtHash.values())
            totalVHT += facilityVHT.doubleValue();
        
        return totalVHT;
    }
    
    public double getFreewaySpeed()
    {
        return getFreewayVmt() / getFreewayVht();
    }
    
    public double getPrimeSpeed()
    {
        return getPrimeVmt() / getPrimeVht();
    }
    
    public double getMajorSpeed()
    {
        return getMajorVmt() / getMajorVht();
    }
    
    public double getCollectorSpeed()
    {
        return getCollectorVmt() / getCollectorVht();
    }
    
    public double getLocalCollectorSpeed()
    {
        return getLocalCollectorVmt() / getLocalCollectorVht();
    }
    
    public double getRuralCollectorSpeed()
    {
        return getRuralCollectorVmt() / getRuralCollectorVht();
    }
    
    public double getLocalSpeed()
    {
        return getLocalVmt() / getLocalVht();
    }
    
    public double getConnectorRampSpeed()
    {
        return getConnectorRampVmt() / getConnectorRampVht();
    }
    
    public double getRampSpeed()
    {
        return getRampVmt() / getRampVht();
    }
    
    public double getAccessSpeed()
    {
        return getAccessVmt() / getAccessVht();
    }
    
    public double getTotalSpeed()
    {
        return getTotalVmt() / getTotalVht();
    }
}

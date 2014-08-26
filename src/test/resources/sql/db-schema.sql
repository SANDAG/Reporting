CREATE SCHEMA IF NOT EXISTS abm AUTHORIZATION SA;

DROP TABLE IF EXISTS abm.SCENARIO;
DROP TABLE IF EXISTS abm.TRANSIT_ONOFF;
DROP TABLE IF EXISTS abm.TRIP_MICRO_SIMUL;
DROP VIEW IF EXISTS ABM.VI_HWYCOV;
DROP TABLE IF EXISTS abm.HWY_LOAD;
DROP TABLE IF EXISTS abm.HWY_TCAD;

CREATE TABLE IF NOT EXISTS abm.SCENARIO(
    SCENARIO_ID smallint,
    SCENARIO_YEAR smallint,
    SCENARIO_DESC varchar(50),
    PATH varchar(200),
    DATE_LOADED timestamp,
    COMPLETE bit,
    USER varchar(50),
    PRIMARY KEY (SCENARIO_ID)
);

CREATE TABLE IF NOT EXISTS abm.TRANSIT_ONOFF(
    SCENARIO_ID smallint,
    ROUTE_ID smallint,
    MAIN_MODE_ID tinyint,
    ACCESS_MODE_ID tinyint,
    TOD_ID tinyint,
    STOP_ID smallint,
    BOARDINGS decimal(11,6),
    ALIGHTINGS decimal(11,6),
    PRIMARY KEY (SCENARIO_ID, ROUTE_ID, MAIN_MODE_ID, ACCESS_MODE_ID, TOD_ID, STOP_ID)
);

CREATE TABLE IF NOT EXISTS abm.TRIP_MICRO_SIMUL(
    SCENARIO_ID smallint,
    MODEL_TYPE_ID tinyint,
    TOUR_ID int,
    TRIP_ID int,
    PARTYSIZE tinyint,
    ORIG_MGRA smallint,
    DEST_MGRA smallint,
    PERIOD_ID tinyint,
    INBOUND bit,
    TRIP_BOARD_TAP smallint,
    TRIP_ALIGHT_TAP smallint,
    TRIP_TIME real,
    OUT_VEHICLE_TIME real,
    TRIP_DISTANCE real,
    TRIP_COST real,
    MODE_ID tinyint,
    PURPOSE_ID tinyint,
    PARKING_MGRA smallint,
    PRIMARY KEY (SCENARIO_ID, MODEL_TYPE_ID, TOUR_ID, TRIP_ID)
);

CREATE TABLE IF NOT EXISTS abm.HWY_LOAD(
    SCENARIO_ID smallint,
    HWYCOV_ID int,
    TOD_ID tinyint,
    AB bit,
    FLOW_PCE decimal(12,6),
    TIME decimal(10,6),
    VOC decimal(8,6),
    DIST_T decimal(12,6),
    VHT decimal(11,6),
    SPEED decimal(9,6),
    VDF decimal(10, 6),
    MSA_FLOW decimal(12,6),
    MSA_TIME decimal(10,6),
    FLOW_SOV_GP decimal(12,6),
    FLOW_SOV_PAY decimal(12,6),
    FLOW_SR2_GP decimal(12,6),
    FLOW_SR2_HOV decimal(12,6),
    FLOW_SR2_PAY decimal(12,6),
    FLOW_SR3_GP decimal(12,6),
    FLOW_SR3_HOV decimal(12,6),
    FLOW_SR3_PAY decimal(12,6),
    FLOW_LHDN decimal(12,6),
    FLOW_MHDN decimal(12,6),
    FLOW_HHDN decimal(12,6),
    FLOW_LHDT decimal(12,6),
    FLOW_MHDT decimal(12,6),
    FLOW_HHDT decimal(12,6),
    FLOW decimal(12,6),
    PRIMARY KEY(SCENARIO_ID, HWYCOV_ID, TOD_ID, AB)
) AS SELECT * FROM CSVREAD('classpath:sql/hwy_load_sample_data.csv');

CREATE TABLE IF NOT EXISTS abm.HWY_TCAD(
    SCENARIO_ID smallint,
    HWYCOV_ID int,
    TOD_ID tinyint,
    AB bit,
    LENGTH_MILE float,
    SPHERE smallint,
    NM varchar(50),
    FXNM varchar(50),
    TXNM varchar(50),
    ANODE smallint,
    BNODE smallint,
    COJUR tinyint,
    COSTAT smallint,
    COLOC bit,
    RLOOP smallint,
    ADTLK smallint,
    ADTVL smallint,
    ASPD tinyint,
    IYR smallint,
    IPROJ smallint,
    IJUR tinyint,
    IFC tinyint,
    IHOV tinyint,
    ITRUCK tinyint,
    ISPD tinyint,
    IWAY tinyint,
    IMED tinyint,
    AU tinyint,
    PCT tinyint,
    CNT tinyint,
    ITOLL2 decimal(12, 6),
    ITOLL3 decimal(12, 6),
    ITOLL4 decimal(12, 6),
    ITOLL5 decimal(12, 6),
    ITOLL decimal(12, 6),
    CP decimal(12, 6),
    CX decimal(12, 6),
    TM decimal(12, 6),
    TX decimal(12, 6),
    LN decimal(12, 6),
    STM decimal(12, 6),
    HTM decimal(12, 6),
    PRELOAD decimal(12, 6),
    PRIMARY KEY (SCENARIO_ID, HWYCOV_ID, TOD_ID, AB)
) AS SELECT * FROM CSVREAD('classpath:sql/hwy_tcad_sample_data.csv');

CREATE OR REPLACE VIEW ABM.VI_HWYCOV(SCENARIO_ID, HWYCOV_ID, TOD_ID, AB, FLOW_PCE, TIME, VOC, VMT, VHT, SPEED, VDF, MSA_FLOW, MSA_TIME, FLOW_SOV_GP, FLOW_SOV_PAY, FLOW_SR2_GP, FLOW_SR2_HOV, FLOW_SR2_PAY, FLOW_SR3_GP, FLOW_SR3_HOV, FLOW_SR3_PAY, FLOW_LHDN, FLOW_MHDN, FLOW_HHDN, FLOW_LHDT, FLOW_MHDT, FLOW_HHDT, FLOW_TRANSIT, TOTAL_FLOW, LENGTH_MILE, SPHERE, NM, FXNM, TXNM, ANODE, BNODE, COJUR, COSTAT, COLOC, RLOOP, ADTLK, ADTVL, ASPD, IYR, IPROJ, IJUR, IFC, IHOV, ITRUCK, ISPD, IWAY, IMED, AU, PCT, CNT, ITOLL2, ITOLL3, ITOLL4, ITOLL5, ITOLL, CP, CX, TM, TX, LN, STM, HTM, PRELOAD) AS 
SELECT 
    L.SCENARIO_ID, 
    L.HWYCOV_ID, 
    L.TOD_ID, 
    L.AB, 
    L.FLOW_PCE, 
    L.TIME, 
    L.VOC, 
    (T.LENGTH_MILE * (L.FLOW + (T.PRELOAD / 3.0))) AS VMT, 
    ((L.FLOW + (T.PRELOAD / 3.0)) * (L.TIME / 60)) AS VHT, 
    L.SPEED, 
    L.VDF, 
    L.MSA_FLOW, 
    L.MSA_TIME, 
    L.FLOW_SOV_GP, 
    L.FLOW_SOV_PAY, 
    L.FLOW_SR2_GP, 
    L.FLOW_SR2_HOV, 
    L.FLOW_SR2_PAY, 
    L.FLOW_SR3_GP, 
    L.FLOW_SR3_HOV, 
    L.FLOW_SR3_PAY, 
    L.FLOW_LHDN, 
    L.FLOW_MHDN, 
    L.FLOW_HHDN, 
    L.FLOW_LHDT, 
    L.FLOW_MHDT, 
    L.FLOW_HHDT, 
    (T.PRELOAD / 3.0) AS FLOW_TRANSIT, 
    (L.FLOW + (T.PRELOAD / 3.0)) AS TOTAL_FLOW, 
    T.LENGTH_MILE, 
    T.SPHERE, 
    T.NM, 
    T.FXNM, 
    T.TXNM, 
    T.ANODE, 
    T.BNODE, 
    T.COJUR, 
    T.COSTAT, 
    T.COLOC, 
    T.RLOOP, 
    T.ADTLK, 
    T.ADTVL, 
    T.ASPD, 
    T.IYR, 
    T.IPROJ, 
    T.IJUR, 
    T.IFC, 
    T.IHOV, 
    T.ITRUCK, 
    T.ISPD, 
    T.IWAY, 
    T.IMED, 
    T.AU, 
    T.PCT, 
    T.CNT, 
    T.ITOLL2, 
    T.ITOLL3, 
    T.ITOLL4, 
    T.ITOLL5, 
    T.ITOLL, 
    T.CP, 
    T.CX, 
    T.TM, 
    T.TX, 
    T.LN, 
    T.STM, 
    T.HTM, 
    T.PRELOAD 
FROM ABM.HWY_TCAD T 
    /* ABM.HWY_TCAD.tableScan */ 
INNER JOIN ABM.HWY_LOAD L 
    /* ABM.PRIMARY_KEY_C: AB = T.AB 
        AND TOD_ID = T.TOD_ID 
        AND SCENARIO_ID = T.SCENARIO_ID 
        AND HWYCOV_ID = T.HWYCOV_ID 
     */ 
    ON 1=1 
WHERE (L.AB = T.AB) 
    AND ((L.TOD_ID = T.TOD_ID) 
    AND ((L.SCENARIO_ID = T.SCENARIO_ID) 
    AND (L.HWYCOV_ID = T.HWYCOV_ID)));
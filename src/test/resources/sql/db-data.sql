INSERT INTO abm.SCENARIO (SCENARIO_ID, SCENARIO_YEAR,SCENARIO_DESC,PATH,DATE_LOADED,COMPLETE,USER) 
    VALUES (249,2012,'2012_aztec', 'T:\projects\sr13\sdf_scenevl_r3\2012_aztec','2014-08-18 08:17:00', 1, 'SANDAGNET\zou');
    
INSERT INTO abm.SCENARIO (SCENARIO_ID, SCENARIO_YEAR,SCENARIO_DESC,PATH,DATE_LOADED,COMPLETE,USER) 
    VALUES (254,2050,'2050nb_aztec', 'T:\projects\sr13\sdf_scenevl_r3\2050nb_aztec','2014-08-24 22:20:00', 1, 'SANDAGNET\zou');
 
--DRIVE ALONE TRIP ADDITIONS
INSERT INTO abm.TRIP_MICRO_SIMUL(SCENARIO_ID,MODEL_TYPE_ID,TOUR_ID,TRIP_ID,PARTYSIZE,ORIG_MGRA,DEST_MGRA,PERIOD_ID,
                                INBOUND,TRIP_BOARD_TAP,TRIP_ALIGHT_TAP,TRIP_TIME,OUT_VEHICLE_TIME,TRIP_DISTANCE,
                                TRIP_COST,MODE_ID,PURPOSE_ID,PARKING_MGRA)
    VALUES (238, 0, 1, 1, 1, 2434, 351, 3, 1, null, null, 24.21, null, 13.352, 2.3525, 1, 5, null);

INSERT INTO abm.TRIP_MICRO_SIMUL(SCENARIO_ID,MODEL_TYPE_ID,TOUR_ID,TRIP_ID,PARTYSIZE,ORIG_MGRA,DEST_MGRA,PERIOD_ID,
                                INBOUND,TRIP_BOARD_TAP,TRIP_ALIGHT_TAP,TRIP_TIME,OUT_VEHICLE_TIME,TRIP_DISTANCE,
                                TRIP_COST,MODE_ID,PURPOSE_ID,PARKING_MGRA)
    VALUES (238, 1, 2, 1, 1, 2434, 351, 3, 1, null, null, 12.0566, null, 3.046, 0.5463, 2, 5, null);
    
INSERT INTO abm.TRIP_MICRO_SIMUL(SCENARIO_ID,MODEL_TYPE_ID,TOUR_ID,TRIP_ID,PARTYSIZE,ORIG_MGRA,DEST_MGRA,PERIOD_ID,
                                INBOUND,TRIP_BOARD_TAP,TRIP_ALIGHT_TAP,TRIP_TIME,OUT_VEHICLE_TIME,TRIP_DISTANCE,
                                TRIP_COST,MODE_ID,PURPOSE_ID,PARKING_MGRA)
    VALUES (238, 3, 3, 1, 1, 2434, 351, 3, 1, null, null, 8.21, null, 4.648, 2.3525, 1, 5, null);
    
INSERT INTO abm.TRIP_MICRO_SIMUL(SCENARIO_ID,MODEL_TYPE_ID,TOUR_ID,TRIP_ID,PARTYSIZE,ORIG_MGRA,DEST_MGRA,PERIOD_ID,
                                INBOUND,TRIP_BOARD_TAP,TRIP_ALIGHT_TAP,TRIP_TIME,OUT_VEHICLE_TIME,TRIP_DISTANCE,
                                TRIP_COST,MODE_ID,PURPOSE_ID,PARKING_MGRA)
    VALUES (238, 4, 4, 1, 1, 2434, 351, 3, 1, null, null, 24.21, null, 13.352, 2.3525, 1, 5, null);
    
--CARPOOL TRIP ADDITIONS
INSERT INTO abm.TRIP_MICRO_SIMUL(SCENARIO_ID,MODEL_TYPE_ID,TOUR_ID,TRIP_ID,PARTYSIZE,ORIG_MGRA,DEST_MGRA,PERIOD_ID,
                                INBOUND,TRIP_BOARD_TAP,TRIP_ALIGHT_TAP,TRIP_TIME,OUT_VEHICLE_TIME,TRIP_DISTANCE,
                                TRIP_COST,MODE_ID,PURPOSE_ID,PARKING_MGRA)
    VALUES (238, 1, 5, 1, 3, 2434, 351, 3, 1, null, null, 24.21, null, 13.352, 2.3525, 3, 5, null);
    
INSERT INTO abm.TRIP_MICRO_SIMUL(SCENARIO_ID,MODEL_TYPE_ID,TOUR_ID,TRIP_ID,PARTYSIZE,ORIG_MGRA,DEST_MGRA,PERIOD_ID,
                                INBOUND,TRIP_BOARD_TAP,TRIP_ALIGHT_TAP,TRIP_TIME,OUT_VEHICLE_TIME,TRIP_DISTANCE,
                                TRIP_COST,MODE_ID,PURPOSE_ID,PARKING_MGRA)
    VALUES (238, 1, 6, 1, 4, 2434, 351, 3, 1, null, null, 12.0566, null, 3.046, 0.5463, 5, 5, null);
    
INSERT INTO abm.TRIP_MICRO_SIMUL(SCENARIO_ID,MODEL_TYPE_ID,TOUR_ID,TRIP_ID,PARTYSIZE,ORIG_MGRA,DEST_MGRA,PERIOD_ID,
                                INBOUND,TRIP_BOARD_TAP,TRIP_ALIGHT_TAP,TRIP_TIME,OUT_VEHICLE_TIME,TRIP_DISTANCE,
                                TRIP_COST,MODE_ID,PURPOSE_ID,PARKING_MGRA)
    VALUES (238, 1, 7, 1, 2, 2434, 351, 3, 1, null, null, 8.21, null, 4.648, 2.3525, 6, 5, null);
    
INSERT INTO abm.TRIP_MICRO_SIMUL(SCENARIO_ID,MODEL_TYPE_ID,TOUR_ID,TRIP_ID,PARTYSIZE,ORIG_MGRA,DEST_MGRA,PERIOD_ID,
                                INBOUND,TRIP_BOARD_TAP,TRIP_ALIGHT_TAP,TRIP_TIME,OUT_VEHICLE_TIME,TRIP_DISTANCE,
                                TRIP_COST,MODE_ID,PURPOSE_ID,PARKING_MGRA)
    VALUES (238, 4, 8, 1, 3, 2434, 351, 3, 1, null, null, 24.21, null, 13.352, 2.3525, 7, 5, null);
    
--WALK TRIP ADDITIONS
INSERT INTO abm.TRIP_MICRO_SIMUL(SCENARIO_ID,MODEL_TYPE_ID,TOUR_ID,TRIP_ID,PARTYSIZE,ORIG_MGRA,DEST_MGRA,PERIOD_ID,
                                INBOUND,TRIP_BOARD_TAP,TRIP_ALIGHT_TAP,TRIP_TIME,OUT_VEHICLE_TIME,TRIP_DISTANCE,
                                TRIP_COST,MODE_ID,PURPOSE_ID,PARKING_MGRA)
    VALUES (238, 1, 9, 1, 1, 2434, 351, 3, 1, null, null, 24.21, null, 1.352, 0, 9, 5, null);
    
INSERT INTO abm.TRIP_MICRO_SIMUL(SCENARIO_ID,MODEL_TYPE_ID,TOUR_ID,TRIP_ID,PARTYSIZE,ORIG_MGRA,DEST_MGRA,PERIOD_ID,
                                INBOUND,TRIP_BOARD_TAP,TRIP_ALIGHT_TAP,TRIP_TIME,OUT_VEHICLE_TIME,TRIP_DISTANCE,
                                TRIP_COST,MODE_ID,PURPOSE_ID,PARKING_MGRA)
    VALUES (238, 1, 10, 1, 4, 2434, 351, 3, 1, null, null, 12.0566, null, .46, 0, 9, 5, null);
    
INSERT INTO abm.TRIP_MICRO_SIMUL(SCENARIO_ID,MODEL_TYPE_ID,TOUR_ID,TRIP_ID,PARTYSIZE,ORIG_MGRA,DEST_MGRA,PERIOD_ID,
                                INBOUND,TRIP_BOARD_TAP,TRIP_ALIGHT_TAP,TRIP_TIME,OUT_VEHICLE_TIME,TRIP_DISTANCE,
                                TRIP_COST,MODE_ID,PURPOSE_ID,PARKING_MGRA)
    VALUES (238, 1, 11, 1, 2, 2434, 351, 3, 1, null, null, 8.21, null, 0.648, 0, 9, 9, null);
    
INSERT INTO abm.TRIP_MICRO_SIMUL(SCENARIO_ID,MODEL_TYPE_ID,TOUR_ID,TRIP_ID,PARTYSIZE,ORIG_MGRA,DEST_MGRA,PERIOD_ID,
                                INBOUND,TRIP_BOARD_TAP,TRIP_ALIGHT_TAP,TRIP_TIME,OUT_VEHICLE_TIME,TRIP_DISTANCE,
                                TRIP_COST,MODE_ID,PURPOSE_ID,PARKING_MGRA)
    VALUES (238, 4, 12, 1, 3, 2434, 351, 3, 1, null, null, 24.21, null, 1.352, 0, 9, 5, null);
    
--BIKE TRIP ADDITIONS
INSERT INTO abm.TRIP_MICRO_SIMUL(SCENARIO_ID,MODEL_TYPE_ID,TOUR_ID,TRIP_ID,PARTYSIZE,ORIG_MGRA,DEST_MGRA,PERIOD_ID,
                                INBOUND,TRIP_BOARD_TAP,TRIP_ALIGHT_TAP,TRIP_TIME,OUT_VEHICLE_TIME,TRIP_DISTANCE,
                                TRIP_COST,MODE_ID,PURPOSE_ID,PARKING_MGRA)
    VALUES (238, 1, 13, 1, 1, 2434, 351, 3, 1, null, null, 24.21, null, 4.352, 0, 10, 5, null);
    
INSERT INTO abm.TRIP_MICRO_SIMUL(SCENARIO_ID,MODEL_TYPE_ID,TOUR_ID,TRIP_ID,PARTYSIZE,ORIG_MGRA,DEST_MGRA,PERIOD_ID,
                                INBOUND,TRIP_BOARD_TAP,TRIP_ALIGHT_TAP,TRIP_TIME,OUT_VEHICLE_TIME,TRIP_DISTANCE,
                                TRIP_COST,MODE_ID,PURPOSE_ID,PARKING_MGRA)
    VALUES (238, 1, 14, 1, 3, 2434, 351, 3, 1, null, null, 12.0566, null, 2.46, 0, 10, 5, null);
    
INSERT INTO abm.TRIP_MICRO_SIMUL(SCENARIO_ID,MODEL_TYPE_ID,TOUR_ID,TRIP_ID,PARTYSIZE,ORIG_MGRA,DEST_MGRA,PERIOD_ID,
                                INBOUND,TRIP_BOARD_TAP,TRIP_ALIGHT_TAP,TRIP_TIME,OUT_VEHICLE_TIME,TRIP_DISTANCE,
                                TRIP_COST,MODE_ID,PURPOSE_ID,PARKING_MGRA)
    VALUES (238, 1, 15, 1, 2, 2434, 351, 3, 1, null, null, 8.21, null, 1.648, 0, 10, 9, null);
    
INSERT INTO abm.TRIP_MICRO_SIMUL(SCENARIO_ID,MODEL_TYPE_ID,TOUR_ID,TRIP_ID,PARTYSIZE,ORIG_MGRA,DEST_MGRA,PERIOD_ID,
                                INBOUND,TRIP_BOARD_TAP,TRIP_ALIGHT_TAP,TRIP_TIME,OUT_VEHICLE_TIME,TRIP_DISTANCE,
                                TRIP_COST,MODE_ID,PURPOSE_ID,PARKING_MGRA)
    VALUES (238, 4, 16, 1, 3, 2434, 351, 3, 1, null, null, 24.21, null, 2.352, 0, 10, 5, null);
    
    
--BIKE TRIP ADDITIONS
INSERT INTO abm.TRIP_MICRO_SIMUL(SCENARIO_ID,MODEL_TYPE_ID,TOUR_ID,TRIP_ID,PARTYSIZE,ORIG_MGRA,DEST_MGRA,PERIOD_ID,
                                INBOUND,TRIP_BOARD_TAP,TRIP_ALIGHT_TAP,TRIP_TIME,OUT_VEHICLE_TIME,TRIP_DISTANCE,
                                TRIP_COST,MODE_ID,PURPOSE_ID,PARKING_MGRA)
    VALUES (238, 1, 17, 1, 2, 2434, 351, 3, 1, null, null, 24.21, null, 4.352, 0, 11, 5, null);
    
INSERT INTO abm.TRIP_MICRO_SIMUL(SCENARIO_ID,MODEL_TYPE_ID,TOUR_ID,TRIP_ID,PARTYSIZE,ORIG_MGRA,DEST_MGRA,PERIOD_ID,
                                INBOUND,TRIP_BOARD_TAP,TRIP_ALIGHT_TAP,TRIP_TIME,OUT_VEHICLE_TIME,TRIP_DISTANCE,
                                TRIP_COST,MODE_ID,PURPOSE_ID,PARKING_MGRA)
    VALUES (238, 1, 18, 1, 2, 2434, 351, 3, 1, null, null, 12.0566, null, 2.46, 0, 14, 5, null);
    
INSERT INTO abm.TRIP_MICRO_SIMUL(SCENARIO_ID,MODEL_TYPE_ID,TOUR_ID,TRIP_ID,PARTYSIZE,ORIG_MGRA,DEST_MGRA,PERIOD_ID,
                                INBOUND,TRIP_BOARD_TAP,TRIP_ALIGHT_TAP,TRIP_TIME,OUT_VEHICLE_TIME,TRIP_DISTANCE,
                                TRIP_COST,MODE_ID,PURPOSE_ID,PARKING_MGRA)
    VALUES (238, 1, 19, 1, 1, 2434, 351, 3, 1, null, null, 8.21, null, 1.648, 0, 19, 9, null);
    
INSERT INTO abm.TRIP_MICRO_SIMUL(SCENARIO_ID,MODEL_TYPE_ID,TOUR_ID,TRIP_ID,PARTYSIZE,ORIG_MGRA,DEST_MGRA,PERIOD_ID,
                                INBOUND,TRIP_BOARD_TAP,TRIP_ALIGHT_TAP,TRIP_TIME,OUT_VEHICLE_TIME,TRIP_DISTANCE,
                                TRIP_COST,MODE_ID,PURPOSE_ID,PARKING_MGRA)
    VALUES (238, 4, 20, 1, 3, 2434, 351, 3, 1, null, null, 24.21, null, 2.352, 0, 18, 5, null);
    
--BIKE TRIP ADDITIONS
INSERT INTO abm.TRIP_MICRO_SIMUL(SCENARIO_ID,MODEL_TYPE_ID,TOUR_ID,TRIP_ID,PARTYSIZE,ORIG_MGRA,DEST_MGRA,PERIOD_ID,
                                INBOUND,TRIP_BOARD_TAP,TRIP_ALIGHT_TAP,TRIP_TIME,OUT_VEHICLE_TIME,TRIP_DISTANCE,
                                TRIP_COST,MODE_ID,PURPOSE_ID,PARKING_MGRA)
    VALUES (238, 1, 21, 1, 2, 2434, 351, 3, 1, null, null, 24.21, null, 4.352, 0, 26, 5, null);
    
INSERT INTO abm.TRIP_MICRO_SIMUL(SCENARIO_ID,MODEL_TYPE_ID,TOUR_ID,TRIP_ID,PARTYSIZE,ORIG_MGRA,DEST_MGRA,PERIOD_ID,
                                INBOUND,TRIP_BOARD_TAP,TRIP_ALIGHT_TAP,TRIP_TIME,OUT_VEHICLE_TIME,TRIP_DISTANCE,
                                TRIP_COST,MODE_ID,PURPOSE_ID,PARKING_MGRA)
    VALUES (238, 1, 22, 1, 1, 2434, 351, 3, 1, null, null, 12.0566, null, 2.46, 0, 26, 5, null);
    
INSERT INTO abm.TRIP_MICRO_SIMUL(SCENARIO_ID,MODEL_TYPE_ID,TOUR_ID,TRIP_ID,PARTYSIZE,ORIG_MGRA,DEST_MGRA,PERIOD_ID,
                                INBOUND,TRIP_BOARD_TAP,TRIP_ALIGHT_TAP,TRIP_TIME,OUT_VEHICLE_TIME,TRIP_DISTANCE,
                                TRIP_COST,MODE_ID,PURPOSE_ID,PARKING_MGRA)
    VALUES (238, 1, 23, 1, 1, 2434, 351, 3, 1, null, null, 8.21, null, 1.648, 0, 27, 9, null);
    
INSERT INTO abm.TRIP_MICRO_SIMUL(SCENARIO_ID,MODEL_TYPE_ID,TOUR_ID,TRIP_ID,PARTYSIZE,ORIG_MGRA,DEST_MGRA,PERIOD_ID,
                                INBOUND,TRIP_BOARD_TAP,TRIP_ALIGHT_TAP,TRIP_TIME,OUT_VEHICLE_TIME,TRIP_DISTANCE,
                                TRIP_COST,MODE_ID,PURPOSE_ID,PARKING_MGRA)
    VALUES (238, 4, 24, 1, 3, 2434, 351, 3, 1, null, null, 24.21, null, 2.352, 0, 26, 5, null);
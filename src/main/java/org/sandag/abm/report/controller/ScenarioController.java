package org.sandag.abm.report.controller;

import java.util.HashMap;
import org.sandag.abm.report.model.Scenario;
import org.sandag.abm.report.persistence.HighwayLinkDao;
import org.sandag.abm.report.persistence.ScenarioDao;
import org.sandag.abm.report.persistence.SimulatedTripDao;
import org.sandag.abm.report.persistence.TransitStopDao;
import org.sandag.abm.report.statistics.ModeShare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/scenario")
public class ScenarioController
{
    @Autowired
    protected ScenarioDao      scenarioDao;

    @Autowired
    protected HighwayLinkDao   hwyLinkDao;

    @Autowired
    protected TransitStopDao   transitStopDao;

    @Autowired
    protected SimulatedTripDao simulatedTripDao;

    @RequestMapping(value = "/{scenarioId}", method = RequestMethod.GET)
    public String display(@PathVariable Short scenarioId, Model model)
    {
        model.addAttribute("activeMenuItem", "overviewMenuItem");

        double vmt = hwyLinkDao.getTotalVMT(scenarioId);
        model.addAttribute("vmt", vmt);

        double vht = hwyLinkDao.getTotalVHT(scenarioId);
        model.addAttribute("vht", vht);

        double networkSpeed = vmt / vht;
        model.addAttribute("networkSpeed", networkSpeed);

        double boardings = transitStopDao.getTotalBoardings(scenarioId);
        model.addAttribute("boardings", boardings);

        Scenario scenario = scenarioDao.read(scenarioId);
        model.addAttribute("scenario", scenario);

        ModeShare modeShare = simulatedTripDao.getResidentModeShare(scenarioId);
        model.addAttribute("modeshare", modeShare);

        HashMap<String, Double> boardingsByMainMode = transitStopDao
                .getBoardingsByMainMode(scenarioId);
        model.addAttribute("boardingsByMode", boardingsByMainMode);

        return "scenario";
    }

}

package org.sandag.abm.report.controller;

import java.util.List;
import org.sandag.abm.report.model.Scenario;
import org.sandag.abm.report.persistence.ScenarioDao;
import org.sandag.abm.report.persistence.TransitStopDao;
import org.sandag.abm.report.statistics.RouteSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/scenario")
public class ScenarioTransitController
{
    @Autowired
    protected ScenarioDao    scenarioDao;

    @Autowired
    protected TransitStopDao transitStopDao;

    @RequestMapping(value = "/{scenarioId}/transit", method = RequestMethod.GET)
    public String display(@PathVariable Short scenarioId, Model model)
    {
        model.addAttribute("activeMenuItem", "transitMenuItem");

        Scenario scenario = scenarioDao.read(scenarioId);
        model.addAttribute("scenario", scenario);

        List<RouteSummary> routeSummaries = transitStopDao.getRouteSummary(scenarioId);
        model.addAttribute("routes", routeSummaries);

        return "transit";
    }

}

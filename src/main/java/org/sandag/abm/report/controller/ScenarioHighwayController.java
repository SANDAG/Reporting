package org.sandag.abm.report.controller;

import java.util.HashMap;
import org.sandag.abm.report.model.Scenario;
import org.sandag.abm.report.persistence.HighwayLinkDao;
import org.sandag.abm.report.persistence.ScenarioDao;
import org.sandag.abm.report.statistics.VmtFacilityProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/scenario")
public class ScenarioHighwayController
{
    @Autowired
    protected ScenarioDao    scenarioDao;

    @Autowired
    protected HighwayLinkDao hwyLinkDao;

    @RequestMapping(value = "/{scenarioId}/highway", method = RequestMethod.GET)
    public String display(@PathVariable Short scenarioId, Model model)
    {
        model.addAttribute("activeMenuItem", "highwayMenuItem");

        Scenario scenario = scenarioDao.read(scenarioId);
        model.addAttribute("scenario", scenario);

        HashMap<String, VmtFacilityProfile> ifcVmtProfiles = hwyLinkDao
                .getVmtProfilesByIFC(scenarioId);
        model.addAttribute("ifcVmtProfiles", ifcVmtProfiles);

        return "highway";
    }

}

package org.sandag.abm.report.controller;

import java.util.List;
import org.sandag.abm.report.model.Scenario;
import org.sandag.abm.report.persistence.ScenarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/scenarios")
public class ScenariosController
{
    @Autowired
    protected ScenarioDao scenarioDao;

    @RequestMapping(method = RequestMethod.GET)
    public String display(Model model)
    {
        model.addAttribute("activeMenuItem", "scenariosMenuItem");

        List<Scenario> scenarios = scenarioDao.readAll();
        model.addAttribute("scenarios", scenarios);
        return "scenarios";
    }
}

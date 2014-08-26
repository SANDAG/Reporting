package org.sandag.abm.report.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sandag.abm.report.model.Scenario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/db.xml", "classpath:/autowire.xml"})
@TransactionConfiguration(transactionManager = "transactionManager")
@Transactional
public class ScenarioDaoTest
{
    @Autowired
    protected ScenarioDao scenarioDao;

    @Test
    public void testRead()
    {
        Scenario scenario = scenarioDao.read(new Short((short) 249));

        assertEquals(249, scenario.getId().shortValue());
        assertEquals(2012, scenario.getYear().shortValue());
        assertEquals("2012_aztec", scenario.getDescription());
        assertEquals("T:\\projects\\sr13\\sdf_scenevl_r3\\2012_aztec", scenario.getPath());
        assertNotNull(scenario.getLoaded().getTime());
        assertTrue(scenario.getLoaded().getTime() > 0);

        assertEquals("SANDAGNET\\zou", scenario.getUser());
    }

    @Test
    public void testReadAll()
    {
        List<Scenario> scenarios = scenarioDao.readAll();
        assertNotNull(scenarios);
        assertEquals(2, scenarios.size());

        Scenario scenario = scenarios.get(1);
        assertNotNull(scenario);

        assertTrue(scenario.getId() > 0);
        assertTrue(scenario.getDescription().length() > 0);
        assertTrue(scenario.getPath().length() > 0);
        assertTrue(scenario.getUser().length() > 0);
        assertTrue(scenario.getYear() > 0);
        assertNotNull(scenario.getLoaded());
    }

    @Test
    public void testConvert()
    {
        Scenario scenario = scenarioDao.convert("249");

        assertEquals(249, scenario.getId().shortValue());
        assertEquals(2012, scenario.getYear().shortValue());
        assertEquals("2012_aztec", scenario.getDescription());
        assertEquals("T:\\projects\\sr13\\sdf_scenevl_r3\\2012_aztec", scenario.getPath());
        assertNotNull(scenario.getLoaded().getTime());
        assertTrue(scenario.getLoaded().getTime() > 0);

        assertEquals("SANDAGNET\\zou", scenario.getUser());
    }
}

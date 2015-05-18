package com.redhat.brms;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.redhat.brms.service.api.StatelessDecisionService;

@ContextConfiguration(locations = { "classpath:kie-context.xml" })
public class LocalPremiumDecisionServiceTest extends AbstractJUnit4SpringContextTests {

	@Resource( name = "localDecisionService")
	private StatelessDecisionService decisionService;

	@Test
	public void shouldAutowireDecisionService() {
		Assert.assertNotNull(decisionService);
	}

	@Test
	public void shouldLoadWorkshopRulesAndExecuteLocally() {
		Collection<Object> facts = new ArrayList<Object>();

		Driver driver = new Driver();
		driver.setAge(30);
		facts.add(driver);

		Vehicle vehicle = new Vehicle();
		vehicle.setMake("BMW");
		facts.add(vehicle);

		decisionService.createOrUpgradeRulesWithVersion("com.redhat.workshops", "business-rules", "2.1");
		PremiumResponse response = decisionService.execute(facts, "InsurancePremiumRuleFlow", PremiumResponse.class);

		Assert.assertEquals(1, response.getPremiums().size());
		Assert.assertEquals(new BigDecimal(1000),response.getPremium().getAmount());
	}

}

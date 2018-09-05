package com.formation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import com.formation.service.AbstractFeedback;
import com.formation.service.MessageServiceImpl;
//import static org.junit.Asset.*;

public class AbstractFeedbackTest {

	@Test
	public void test1() {
		AbstractFeedback oui = new MessageServiceImpl();
		int test1 = oui.giveMeTheCaptainAge(10, 3);
		int test2 = oui.giveMeTheCaptainAge(0, 0);
		assertEquals(58, test1);
		assertNotEquals(580, test1);
		assertEquals(42, test2);

	}

}

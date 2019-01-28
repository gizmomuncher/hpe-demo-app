package com.hp.devops.demoapp;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.security.InvalidParameterException;


public class JohnTEST {
	//private String NON_RELATED;
	private JSONObject test;

	@Before
	public void beforeEach() {
		test = new JSONObject();
		test.put("id", 1);
		test.put("name", "Name");
		test.put("logo", "Logo");
		test.put("song", "Song");
		test.put("votes", 10);
	}

		@Test
	public void JohnTESTA() {
		try {
			Band band = new Band(null);
			Assert.fail("the flow MUST have been fallen before");
		} catch (Exception e) {
			Assert.assertEquals(e.getClass(), NullPointerException.class);
		}
	}

	@Test
	public void JohnTESTB() {
		try {
			Band band = new Band(new JSONObject());
			Assert.fail("the flow MUST have been fallen before");
		} catch (Exception e) {
			Assert.assertEquals(e.getClass(), InvalidParameterException.class);
			Assert.assertEquals(e.getMessage(), "json must have an id property");
		}
	}

	@Test
	public void JohnTESTC() {
		test.remove("name");
		test.remove("logo");
		Band band = new Band(test);
		Assert.assertEquals(band.id, 1);
		Assert.assertEquals(band.name, "");
		Assert.assertEquals(band.logo, "");
		Assert.assertEquals(band.song, "Song");
		Assert.assertEquals(band.votes, 10);
	}

	@Test
	@Ignore
	public void JohnTESTD() {
		Band band = new Band(test);
		Assert.assertEquals(test.toString(), band.toJSON().toString());
	}

	@Test
	public void JohnTESTE() {
		Band band = new Band(test);
		JSONObject tmp = new JSONObject();
		tmp.put("id", test.get("id"));
		tmp.put("votes", test.get("votes"));
		Assert.assertEquals(tmp.toString(), band.toJSONVotes().toString());
	}
}
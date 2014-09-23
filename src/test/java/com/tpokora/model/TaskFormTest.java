package com.tpokora.model;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.validation.constraints.AssertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import scala.annotation.meta.param;

public class TaskFormTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetFormatedDate() {
		TaskForm taskForm = new TaskForm();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2014);
		cal.set(Calendar.MONTH, 9);
		cal.set(Calendar.DAY_OF_MONTH, 22);
		Date date = cal.getTime();
		taskForm.setDueDate(date);
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		assertTrue("Data sformatowana 22/09/2014", taskForm.getFormatedDate().equals(df.format(date)));
	}

}

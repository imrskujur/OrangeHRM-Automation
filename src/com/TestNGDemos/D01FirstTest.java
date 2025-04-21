package com.TestNGDemos;

import org.testng.Assert;
import org.testng.annotations.Test;

public class D01FirstTest {
  @Test
  public void firstTest() {
	  System.out.println("First Test");
	  
	  Assert.assertEquals(false, false);
  }
  
  public void trial()
  {
	  System.out.println("trial method");
  }
}

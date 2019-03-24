import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Andrew Letterle
 *
 */


public class ServiceTest {

 Service service;
 Service service2;
 Service service3;
 Service service4;
 
 @Before
 public void setUp() throws Exception {
  service = new Service(123456789, "Dental Inspection", (float) 75.00);
  
 }

 @Test 
/**
 * Tests success of the Get Functions
 */
 public void testGetId() {
  assertEquals(123456789, service.getId());
 }
 @Test
 public void testGetCost() {
  assertTrue(75.00 == service.getCost());
 }
 @Test
 public void testGetName() {
  assertEquals("Dental Inspection", service.getName());
 }
 
 /**
  * Tests Success of set functions
  */
 @Test
 public void testSetId() {
  service.setCode(111111111);
  assertEquals(111111111, service.getId());
 }
 @Test
 public void testSetCost() {
  service.setCost((float)225.89);
  assertTrue((float)225.89 == service.getCost());
 }
 @Test
 public void testSetName() {
  service.setName("Nutritional Advice");
  assertEquals("Nutritional Advice", service.getName());
 }
 
 /**
  * Test for failure of setting names and numbers
  */
 @Test (expected = Error.class)
 public void FailSetId() {
  service2 = new Service("Hello", "Dental Inspection", (float) 75.00);
 }
 @Test (expected = Error.class)
 public void FailSetCost() {
  service3 = new Service(123456789, "Dental Inspection", -75.00);
 }
 @Test (expected = Error.class)
 public void FailSetName() {
  service4 = new Service(123456789, 123, (float) 75.00);
 }
}

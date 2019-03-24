import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProviderTest {
 String name;
 Address addr;
 int code;
 int cost;
 public Provider provider = new Provider(name, code, cost, addr);
 int ID = 123456789;
 @Test 
 void testGetNumber() {
  
  assertEquals("0", provider.getNumber());
  }
 @Test
 void testGetNumber2()
 {
  int dasCode = 123456789;
  provider.setNumber(dasCode);
  assertEquals(123456789, provider.getNumber());
 }
 @Test
 void testGetNumberPass()
 {
  int setCode = 0;
  assertEquals(setCode, provider.getNumber());
 }

}

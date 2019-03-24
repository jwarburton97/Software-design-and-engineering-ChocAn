import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MemberTest {
 String name;
 Address addr;
 int code;
 public Member member = new Member(name, code, addr);
 int ID = 123456789;
 
 @Test 
 void testGetNumber() {
  
  assertEquals("0", member.getNum());
  }
 @Test
 void testGetNumber2()
 {
  int code = ID;
  member.setNum(code);
  assertEquals(123456789, member.getNum());
 }
 @Test
 void testGetNumberPass()
 {
  int setCode = 0;
  assertEquals(setCode, member.getNum());
 }

}

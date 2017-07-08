import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MemberTest {
    @Test
    public void Member_instantiatesCorrectly_true() {
        Member newMember = new Member("Ivan", "Ivanov");
        assertEquals(true, newMember instanceof Member);
    }
    @Test
    public void Member_instantiatesWithFirstAndLastName_String() {
        Member newMember = new Member("Ivan", "Ivanov");
        assertEquals("Ivan", newMember.getFirstName());
    }

}

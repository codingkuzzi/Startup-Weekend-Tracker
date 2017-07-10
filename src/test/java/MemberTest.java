import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MemberTest {
    @Test
    public void Member_instantiatesCorrectly_true() {
        Member newMember = new Member("Ivan", "Ivanov", "Leader");
        assertEquals(true, newMember instanceof Member);
    }
    @Test
    public void Member_instantiatesWithFirstAndLastName_String() {
        Member newMember = new Member("Ivan", "Ivanov", "Leader");
        assertEquals("Ivan", newMember.getFirstName());
    }
    @Test
    public void all_returnsAllInstancesOfMember_true() {
        Member firstMember = new Member("Ivan", "Ivanov", "Leader");
        Member secondMember = new Member("Peter", "Petrov", "Architect");
        assertEquals(true, Member.all().contains(firstMember));
        assertEquals(true, Member.all().contains(secondMember));
    }
    @Test
    public void clear_emptiesAllMembersFromArrayList_0() {
        Member newMember = new Member("Ivan", "Ivanov", "Leader");
        Member.clear();
        assertEquals(0, Member.all().size());
    }
    @Test
    public void getId_tasksInstantiateWithAnID_1() {
        Member.clear();  // Remember, the test will fail without this line! We need to empty leftover Tasks from previous tests!
        Member newMember = new Member("Ivan", "Ivanov", "Leader");
        assertEquals(1, newMember.getId());
    }
    @Test
    public void find_returnsMemberWithSameId_secondMember() {
        Member firstMember = new Member("Ivan", "Ivanov", "Leader");
        Member secondMember = new Member("Peter", "Petrov", "Architect");
        assertEquals(Member.find(secondMember.getId()), secondMember);
    }


}

import org.junit.*;
import static org.junit.Assert.*;
public class TeamTest {

    @Test
    public void member_instantiatesCorrectly_true() {
        Team testTeam = new Team("ZipCargo", "Cargo app");
        assertEquals(true, testTeam instanceof Team);
    }

    @Test
    public void getName_teamInstantiatesWithName_ZipCargo() {
        Team testTeam = new Team("ZipCargo", "Cargo app");
        assertEquals("ZipCargo", testTeam.getName());
    }

    @Test
    public void all_returnsAllInstancesOfTeam_true() {
        Team firstTeam = new Team("ZipCargo", "Cargo app");
        Team secondTeam = new Team("UrbanBeat", "Urban app");
        assertEquals(true, Team.all().contains(firstTeam));
        assertEquals(true, Team.all().contains(secondTeam));
    }

    @Test
    public void clear_emptiesAllTeamsFromList_0() {
        Team testTeam = new Team("ZipCargo", "Cargo app");
        Team.clear();
        assertEquals(Team.all().size(), 0);
    }

    @Test
    public void getId_teamsInstantiateWithAnId_1() {
        Team.clear();
        Team testTeam = new Team("ZipCargo", "Cargo app");
        assertEquals(1, testTeam.getId());
    }

    @Test
    public void find_returnsTeamWithSameId_secondTeam() {
        Team.clear();
        Team firstTeam = new Team("ZipCargo", "Cargo app");
        Team secondTeam = new Team("UrbanBeat", "Urban app");
        assertEquals(Team.find(secondTeam.getId()), secondTeam);
    }

    @Test
    public void getMembers_initiallyReturnsEmptyList_ArrayList() {
        Team.clear();
        Team testTeam = new Team("ZipCargo", "Cargo app");
        assertEquals(0, testTeam.getMembers().size());
    }

    @Test
    public void addMember_addsMemberToList_true() {
        Team testTeam = new Team("ZipCargo", "Cargo app");
        Member testMember = new Member("Ivan", "Ivanov", "Leader");
        testTeam.addMember(testMember);
        assertTrue(testTeam.getMembers().contains(testMember));
    }


}

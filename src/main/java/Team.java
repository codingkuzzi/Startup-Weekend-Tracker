import java.util.ArrayList;
import java.util.List;

public class Team {
    private String mName;
    private String mDescription;
    private static List<Team> instances = new ArrayList<Team>();
    private int mId;
    private List<Member> mMembers;

    public Team(String name, String description) {
        mName = name;
        mDescription = description;
        instances.add(this);
        mId = instances.size();
        mMembers = new ArrayList<Member>();
    }

    public String getName() {
        return mName;
    }
    public String getDescription() { return mDescription; }

    public static List<Team> all() {
        return instances;
    }

    public static void clear() {
        instances.clear();
    }

    public int getId() {
        return mId;
    }

    public static Team find(int id) {
        return instances.get(id -1);
    }

    public List<Member> getMembers() {
        return mMembers;
    }

    public void addMember(Member member) {
        mMembers.add(member);
    }
}

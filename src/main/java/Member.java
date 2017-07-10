import java.util.ArrayList;
import java.util.List;

public class Member {
    private String mFirstName;
    private String mLastName;
    private String mRole;
    private static List<Member> instances = new ArrayList<Member>();
    private int mId;

    public Member(String firstName, String lastName, String role) {
    mFirstName = firstName;
    mLastName = lastName;
    mRole = role;
    instances.add(this);
    mId = instances.size();
    }

    public String getFirstName(){
        return mFirstName;
    }
    public String getLastName(){
        return mLastName;
    }
    public String getRole() { return mRole; }
    public static List<Member> all() {
        return instances;
    }
    public static void clear() {
        instances.clear();
    }
    public int getId() {
        return mId;
    }
    public static Member find(int id) {
        return instances.get(id - 1);
    }


}

package Google;

public class Children {
    private String childName;

    public String getChildName() {
        return childName;
    }

    public String getChildBirthday() {
        return childBirthday;
    }

    private String childBirthday;

    public Children(String childName, String childBirthday) {
        this.childName = childName;
        this.childBirthday = childBirthday;
    }
}

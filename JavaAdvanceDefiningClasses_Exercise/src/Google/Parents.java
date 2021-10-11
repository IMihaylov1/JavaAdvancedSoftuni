package Google;

public class Parents {
    public String getParentsName() {
        return parentsName;
    }

    public String getParentsBirthday() {
        return parentsBirthday;
    }

    private  String parentsName;
    private String parentsBirthday;

    public Parents(String parentsName, String parentsBirthday) {
        this.parentsName = parentsName;
        this.parentsBirthday = parentsBirthday;
    }



}

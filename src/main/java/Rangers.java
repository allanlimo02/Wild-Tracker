public class Rangers {
    private String name;
    private int badgeNo;
    private String email;

    public Rangers(String name, int badgeNo, String email) {
        this.name = name;
        this.badgeNo = badgeNo;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBadgeNo() {
        return badgeNo;
    }

    public void setBadgeNo(int badgeNo) {
        this.badgeNo = badgeNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

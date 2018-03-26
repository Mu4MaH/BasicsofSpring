public class Client {
    private int id;
    private String fullName;
    public Client(int id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }



    public void setId (int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setFullName (String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}

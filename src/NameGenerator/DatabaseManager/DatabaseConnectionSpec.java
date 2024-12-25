package NameGenerator.DatabaseManager;

public class DatabaseConnectionSpec {
    public String getConnectionString() {
        return connectionString;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    private String user = "";
    private String password = "";
    private String connectionString = "";

    public DatabaseConnectionSpec(String user, String password, String url){
        this.user = user;
        this.password = password;
        this.connectionString = url;
    }
}

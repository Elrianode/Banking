package Model;

public class Account {
	private String username;
	private String password;
	private int id;
	private int permission;

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public int getId() {
		return id;
	}

    public Account(String username, String password, int id, int permission) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.permission = permission;
    }

    public int getPermission() {
        return permission;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }
     
}
public class User {
    int id;
    String login;
    String password;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.lang.String getLogin() {
        return login;
    }

    public void setLogin(java.lang.String login) {
        this.login = login;
    }

    public java.lang.String getPassword() {
        return password;
    }

    public void setPassword(java.lang.String password) {
        this.password = password;
    }
@Override
    public String toString(){
        return "Id: "+ getId() + " Login: " + getLogin() + " Password: " + getPassword();
    }
}

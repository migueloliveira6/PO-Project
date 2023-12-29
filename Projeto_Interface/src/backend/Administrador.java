package backend;

public class Administrador {
    
    private final String username = "adm";
    private final String password = "0000";
    
    public boolean autenticar(String username, String password) {
        return this.username.equals(username) && 
                this.password.equals(password);
    }
    
    public Administrador(){

    }

    @Override
    public String toString() {
        return "Administrador{" + "username=" + username + ", password=" + password + '}';
    }
}

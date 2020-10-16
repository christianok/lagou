package persistence.entity;

public class User { //主键标识
    private Integer id; //用户名
    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "persistence.entity.User{" +
                "id=" + id +
                ", username='" + username + '\'' + '}';
    }
}
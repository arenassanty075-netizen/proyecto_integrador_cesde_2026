package co.edu.cesde.ga.model;

public class UserRole {

    private int userId;
    private int roleId;

    public UserRole(int userId, int roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public int getUserId() {
        return userId;
    }

    public int getRoleId() {
        return roleId;
    }

    @Override
    public String toString() {
        return "UserRole { userId=" + userId + ", roleId=" + roleId + " }";
    }
}
package co.edu.cesde.ga.model;

public class UserRole {

    private Long userId;
    private Long roleId;

    public UserRole(Long userId, Long roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    @Override
    public String toString() {
        return "UserRole { userId=" + userId + ", roleId=" + roleId + " }";
    }
}
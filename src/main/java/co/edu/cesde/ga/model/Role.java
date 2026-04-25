package co.edu.cesde.ga.model;

public class Role {

    private long roleId;  // ✅ long
    private String name;
    private String description;

    public Role() {
    }

    public Role(long roleId, String name, String description) { // ✅ long
        this.roleId = roleId;
        this.name = name;
        this.description = description;
    }

    public long getRoleId() { // ✅ long
        return roleId;
    }

    public void setRoleId(long roleId) { // ✅ asigna el valor
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return "Role { roleId=" + roleId + ", name=" + name + ", description=" + description + " }";
    }
}
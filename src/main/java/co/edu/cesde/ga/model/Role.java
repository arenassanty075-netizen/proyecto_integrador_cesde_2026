package co.edu.cesde.ga.model;

public class Role {

    private int roleId;
    private String name;
    private String description;

    public Role(int roleId, String name, String description) {
        this.roleId = roleId;
        this.name = name;
        this.description = description;
    }

    public int getRoleId() {
        return roleId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
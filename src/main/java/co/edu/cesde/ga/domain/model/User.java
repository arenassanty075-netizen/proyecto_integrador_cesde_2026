package co.edu.cesde.ga.domain.model;

public class User {

    private Long userId;
    private String username;
    private String email;
    private String passwordHash;
    private String status;
    private String createdAt;

    public User(Long userId, String username, String email, String passwordHash, String status, String createdAt) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getStatus() {
        return status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setUserId(Long l) {
    }

    @Override
    public String toString() {
        return "User { userId=" + userId + ", username=" + username + ", email=" + email + ", status=" + status + " }";
    }
}
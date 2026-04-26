package com.lexitrace.models;

/**
 * DTO for user ranking display on leaderboards.
 */
public class UserRankDTO {

    private Long userId;
    private String userName;
    private String profilePic;
    private Integer totalPoints;
    private Integer rank;

    public UserRankDTO() {}

    public UserRankDTO(Long userId, String userName, String profilePic, Integer totalPoints, Integer rank) {
        this.userId = userId;
        this.userName = userName;
        this.profilePic = profilePic;
        this.totalPoints = totalPoints;
        this.rank = rank;
    }

    // Getters and Setters
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getProfilePic() { return profilePic; }
    public void setProfilePic(String profilePic) { this.profilePic = profilePic; }

    public Integer getTotalPoints() { return totalPoints; }
    public void setTotalPoints(Integer totalPoints) { this.totalPoints = totalPoints; }

    public Integer getRank() { return rank; }
    public void setRank(Integer rank) { this.rank = rank; }
}

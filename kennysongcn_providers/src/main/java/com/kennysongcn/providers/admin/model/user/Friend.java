package com.kennysongcn.providers.admin.model.user;
/**
 * 好友
 * @author songzhihao
 *
 */
public class Friend {
    private Short fId;

    private Integer userId;

    private Integer friendId;

    public Short getfId() {
        return fId;
    }

    public void setfId(Short fId) {
        this.fId = fId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFriendId() {
        return friendId;
    }

    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }
}
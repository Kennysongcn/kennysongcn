package com.kennysongcn.providers.admin.model.user;
/**
 * 用户分组信息
 * @author songzhihao
 *
 */
public class UserGroup {
    private Byte gId;

    private Byte groupId;

    private String groupName;

    private String groupPower;

    public Byte getgId() {
        return gId;
    }

    public void setgId(Byte gId) {
        this.gId = gId;
    }

    public Byte getGroupId() {
        return groupId;
    }

    public void setGroupId(Byte groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public String getGroupPower() {
        return groupPower;
    }

    public void setGroupPower(String groupPower) {
        this.groupPower = groupPower == null ? null : groupPower.trim();
    }
}
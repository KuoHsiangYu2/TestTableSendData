package com.hsiangyu.model;

import java.io.Serializable;

public class CustomerBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id = 0;/* 編號 */
    private String serverName = "";/* 伺服器 */
    private String roleName = "";/* 角色名稱 */
    private String facebookName = "";/* Facebook名稱 */
    private String level = "";/* 等級 */

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CustomerBean [id=");
        stringBuffer.append(id);
        stringBuffer.append(", serverName=");
        stringBuffer.append(serverName);
        stringBuffer.append(", roleName=");
        stringBuffer.append(roleName);
        stringBuffer.append(", facebookName=");
        stringBuffer.append(facebookName);
        stringBuffer.append(", level=");
        stringBuffer.append(level);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public CustomerBean() {
        super();
    }

    public CustomerBean(int id, String serverName, String roleName, String facebookName, String level) {
        super();
        this.id = id;
        this.serverName = serverName;
        this.roleName = roleName;
        this.facebookName = facebookName;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getFacebookName() {
        return facebookName;
    }

    public void setFacebookName(String facebookName) {
        this.facebookName = facebookName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

}

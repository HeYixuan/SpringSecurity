package org.springframe.system.vo;

import java.io.Serializable;

/**
 * @author: HeYixuan
 * @create: 2017-05-05 13:12
 */
public class SystemRoleResouces implements Serializable {

    private String roleName;
    private String resouceName;
    private String url;
    private OPTION action;

    public SystemRoleResouces() {
    }

    public SystemRoleResouces(String roleName, String resouceName, String url, OPTION action) {
        this.roleName = roleName;
        this.resouceName = resouceName;
        this.url = url;
        this.action = action;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getResouceName() {
        return resouceName;
    }

    public void setResouceName(String resouceName) {
        this.resouceName = resouceName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public OPTION getAction() {
        return action;
    }

    public void setAction(OPTION action) {
        this.action = action;
    }


    @Override
    public String toString() {
        return "SystemRoleResouces{" +
                "roleName='" + roleName + '\'' +
                ", resouceName='" + resouceName + '\'' +
                ", url='" + url + '\'' +
                ", action=" + action +
                '}';
    }

    public enum OPTION{
        MENU,
        BUTTON,
        LINKED
    }
}

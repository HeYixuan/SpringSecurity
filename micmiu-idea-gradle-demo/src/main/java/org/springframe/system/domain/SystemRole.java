package org.springframe.system.domain;

import org.springframe.constans.ROLE;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by HeYixuan on 2017/4/18.
 * 角色实体
 */
@Entity
public class SystemRole implements Serializable {

    /**
     * 编号
     */
    @Id
    @GeneratedValue
    @Column(nullable = false, columnDefinition = "int(10)")
    private Integer id;

    /**
     * 编码
     */
    @Column(nullable = false, columnDefinition = "varchar(36)")
    private String code;

    /**
     * 角色名称
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "varchar(36)")
    private ROLE name;


    /**
     * 被分配给的用户
     */
    @ManyToMany(mappedBy="roles")
    private Set<SystemUser> systemUsers = new HashSet<SystemUser>();

    /**
     * 可以访问的资源
     */
    @ManyToMany(mappedBy="roles")
    private Set<SystemResources> resources = new HashSet<SystemResources>();


    public SystemRole() {
    }

    public SystemRole(String code, ROLE name, Set<SystemUser> systemUsers, Set<SystemResources> resources) {
        this.code = code;
        this.name = name;
        this.systemUsers = systemUsers;
        this.resources = resources;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ROLE getName() {
        return name;
    }

    public void setName(ROLE name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "SystemRole{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name=" + name +
                '}';
    }
}

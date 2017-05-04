package org.springframe.domain;

import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by HeYixuan on 2017/4/18.
 * 资源实体
 */
@Entity
public class SystemResources implements Serializable {


    @Id
    @GeneratedValue
    @Column( nullable= false, columnDefinition = "int(10)")
    private Integer id;

    /**
     * 资源名称
     */
    @Column(nullable = false, columnDefinition = "varchar(36)")
    private String name;

    /**
     * 链接
     */
    @URL
    @Column(nullable = false, columnDefinition = "varchar(255)")
    private String url;

    /**
     * 样式
     */
    @Column(nullable = true, columnDefinition = "varchar(255)")
    private String clazz;

    /**
     * 动作:按钮,菜单
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "varchar(36)")
    private OPTION action;

    /**
     * 上级资源
     * 父节点ID
     */
    @Column(nullable= true, columnDefinition = "int(10)")
    private Integer parentId;
    /*@ManyToOne
    @JoinColumn(name="parent_id")
    private SystemResources parentId;*/

    /**下级资源*/
    //private List<SystemResources> children;

    /*@OneToMany(mappedBy="parentId", cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    private Set<SystemResources> children = new HashSet<SystemResources>();*/


    /**
     * 权限描述
     */
    @Column(nullable = true, columnDefinition = "varchar(255)")
    private String descritpion;

    /**
     *哪些角色可以访问
     */
    @ManyToMany
    @JoinTable(name="system_role_resource",joinColumns=@JoinColumn(name="system_resource_id"),
            inverseJoinColumns=@JoinColumn(name="system_role_id"))
    private Set<SystemRole> roles = new HashSet<SystemRole>();


    public enum OPTION{
        MENU,
        BUTTON,
        LINKED
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getDescritpion() {
        return descritpion;
    }

    public void setDescritpion(String descritpion) {
        this.descritpion = descritpion;
    }

    @Override
    public String toString() {
        return "SystemResources{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", action=" + action +
                ", parentId=" + parentId +
                ", descritpion='" + descritpion + '\'' +
                '}';
    }
}

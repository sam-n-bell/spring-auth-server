package com.bell.projects.authserver.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PERMISSION")
public class Permission extends BaseIdEntity {

    @Column(name = "PERMISSION_NAME")
    private String permissionName;

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String name) {
        this.permissionName = name;
    }


}

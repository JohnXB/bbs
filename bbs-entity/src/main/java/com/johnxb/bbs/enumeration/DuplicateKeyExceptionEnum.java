package com.johnxb.bbs.enumeration;

public enum DuplicateKeyExceptionEnum {
    PHONE("电话", "phone"),
    USERNAME("用户名", "username"),
    MAIL("邮箱", "mail");

    private String name;
    private String value;

    private DuplicateKeyExceptionEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

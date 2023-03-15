package com.lms.Bean;

import java.sql.Date;

public class MemberCombine extends Member{

    private String typeName;

    public MemberCombine() {
    }

    public MemberCombine(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "MemberCombine{" +
                super.toString()+
                "typeName='" + typeName + '\'' +
                '}';
    }
}

package com.zhaogang.com.annotation;

@Table("User")
public class Filter {

    @Column(columnName="pkid",searchType=ESearchType.equal)
    public Long pkid;
    
    @Column(columnName="name",searchType=ESearchType.like)
    public String name;
    
    @Column(columnName="email",searchType=ESearchType.in)
    public String email;
    
    public Integer age;
    

    public Long getPkid() {
        return pkid;
    }

    public void setPkid(Long pkid) {
        this.pkid = pkid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }             
}

package com.zhaogang.com.annotation;

public enum ESearchType {

    like(1,"like"),
    equal(2,"="),
    gt(3,">"),
    lt(4,"<"),
    in(5,"in");
    
    /** 主键 */
    private final Long key;

    /** 描述 */
    private final String desc;

    private ESearchType(long key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    public Long getKey() {
        return key;
    }

    public String GetDesc() {
        return desc;
    }

    public static String GetDesc(Long key){
        for(ESearchType typeEnum : ESearchType.values()){
            if(typeEnum.key.equals(key)){
                return typeEnum.desc;
            }
        }
        return "";
    }
}

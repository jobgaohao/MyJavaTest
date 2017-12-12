package com.zhaogang.com.annotation;

public enum ELoseType {

    returnapply(70,"客户遗失"),
    loseapply(80,"我司遗失"),
    others(90,"快递遗失");
    /** 主键 */
    private final Long key;

    /** 描述 */
    private final String desc;

    private ELoseType(long key, String desc) {
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
        for(ELoseType typeEnum : ELoseType.values()){
            if(typeEnum.key.equals(key)){
                return typeEnum.desc;
            }
        }
        return "";
    }
}

package com.tool.cfg.base.data.Entity.enums;

/**
 * Created by XM on 2017/9/18.
 */
public enum ConstantsEnum {

    MINUTE_MAX_TRY_COUNT("每分钟最大尝试次数",5),


    /*时间枚举*/
    MAX_DISABLED_SECONDS("最大失效时间",3000);

    private String name;
    private int index;
    // 构造方法
    private ConstantsEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }
    // 普通方法
    public static String getName(int index) {
        for (ConstantsEnum c : ConstantsEnum.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }
    // 普通方法
    public static int getIndex(String name) {
        for (ConstantsEnum c : ConstantsEnum.values()) {
            if (name.equals(c.getName())) {
                return c.index;
            }
        }
        return 0;
    }
    // get set 方法
    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }
    }

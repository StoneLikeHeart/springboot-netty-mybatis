package com.future.desk.enums;

public enum ResMsgEnum {

    C100(true,"成功"),
    C101(false,"失败"),
    C102(false,"报错");

    ResMsgEnum(boolean res ,String msg){
        this.res = res;
        this.msg = msg;
    }

    private boolean res;
    private String msg;



    public boolean isRes() {
        return res;
    }

    public void setRes(boolean res) {
        this.res = res;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

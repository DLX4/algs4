package pers.dlx.ele;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;

public class EleEntity implements java.io.Serializable {

    @Excel(name = "店名")
    private String  name;

    @Excel(name = "评分")
    private String score;

    @Excel(name = "月售")
    private String soldCnt;

    @Excel(name = "起送")
    private String start;

    @Excel(name = "配送费")
    private String expressFee;

    @Excel(name = "距离")
    private String distance;

    @Excel(name = "时间")
    private String time;

    @Excel(name = "菜系")
    private String category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getSoldCnt() {
        return soldCnt;
    }

    public void setSoldCnt(String soldCnt) {
        this.soldCnt = soldCnt;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getExpressFee() {
        return expressFee;
    }

    public void setExpressFee(String expressFee) {
        this.expressFee = expressFee;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

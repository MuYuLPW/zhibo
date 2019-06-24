package com.muyu.zhibo.bean.liguiBean;

import android.support.annotation.NonNull;

public  class DataBean implements Comparable<DataBean>{
    /**
     * id : 821
     * name : 《梦想女教师》- 蕾蕾
     * cover : http://web.ligui.com/storage/680*453*61d16eefe4c14ae9f19ef84b6b7a564a.jpg
     * url : http://web.ligui.com/storage/video/d5a5e2d7250a43119806fa89996fd53c.mp4
     * length : 757
     * canWatchNum : 30
     * isGood : 0
     * isCommend : 1
     * type : 1
     * mid : 157
     * status : 1
     * playCount : 828
     * lidJson : 1,8
     * score : 0
     * onlinetime : 0
     * sort : 0
     * ctime : 1560840275459
     * utime : 1560862510930
     * modelIcon : http://web.ligui.com/storage/200*300*00810a7af94135bd23e133e06687f7f5.jpg
     * modelName : 蕾蕾
     * modelStatus : 0
     * collect : 0
     */

    private int id;
    private String name;
    private String cover;
    private String url;
    private int length;
    private int canWatchNum;
    private int isGood;
    private int isCommend;
    private int type;
    private int mid;
    private int status;
    private int playCount;
    private String lidJson;
    private int score;
    private int onlinetime;
    private int sort;
    private long ctime;
    private long utime;
    private String modelIcon;
    private String modelName;
    private int modelStatus;
    private int collect;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getCanWatchNum() {
        return canWatchNum;
    }

    public void setCanWatchNum(int canWatchNum) {
        this.canWatchNum = canWatchNum;
    }

    public int getIsGood() {
        return isGood;
    }

    public void setIsGood(int isGood) {
        this.isGood = isGood;
    }

    public int getIsCommend() {
        return isCommend;
    }

    public void setIsCommend(int isCommend) {
        this.isCommend = isCommend;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public String getLidJson() {
        return lidJson;
    }

    public void setLidJson(String lidJson) {
        this.lidJson = lidJson;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getOnlinetime() {
        return onlinetime;
    }

    public void setOnlinetime(int onlinetime) {
        this.onlinetime = onlinetime;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public long getCtime() {
        return ctime;
    }

    public void setCtime(long ctime) {
        this.ctime = ctime;
    }

    public long getUtime() {
        return utime;
    }

    public void setUtime(long utime) {
        this.utime = utime;
    }

    public String getModelIcon() {
        return modelIcon;
    }

    public void setModelIcon(String modelIcon) {
        this.modelIcon = modelIcon;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getModelStatus() {
        return modelStatus;
    }

    public void setModelStatus(int modelStatus) {
        this.modelStatus = modelStatus;
    }

    public int getCollect() {
        return collect;
    }

    public void setCollect(int collect) {
        this.collect = collect;
    }

    @Override
    public int compareTo(@NonNull DataBean o) {
        return this.id-o.id;
    }
}
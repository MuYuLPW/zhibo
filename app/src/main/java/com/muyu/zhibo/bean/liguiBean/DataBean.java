package com.muyu.zhibo.bean.liguiBean;

import android.support.annotation.NonNull;

public  class DataBean implements Comparable<DataBean>{


    /**
     * id : 936
     * type : 2
     * name : 《明月吻香莲》
     * cover : http://store.liguiclub.com/storage/375*240*a32f47a2f65e168141ceb696fbbaed37.jpg
     * length : 373
     * canWatchNum : 0
     * mid : 140543
     * pid : 66060
     * sid : 0
     * isCommend : 1
     * url : http://store.liguiclub.com/storage/video/8cd0f87d038842b8a5418ae082eca287.mp4
     * price : 30
     * info :
     * label : 9,3
     * status : 1
     * checkStatus : 1
     * reason :
     * topType : 0
     * endTopTime : 0
     * startTopTime : 0
     * payCount : 15
     * playCount : 2456
     * collectNum : 14
     * commentNum : 2
     * shareStatus : 1
     * downloadTime : 1586707200000
     * score : 0
     * onlinetime : 0
     * handleOnlineStatus : 0
     * backUpCount : 0
     * sort : 0
     * pushStatus : 0
     * vip : 0
     * ctime : 1570953042557
     * utime : 1571996398511
     * modelName : 丽柜 甜甜
     * modelIcon : http://store.liguiclub.com/storage/1080*1343*6a9a3f9f3fee89113f79930af73a639c.jpeg
     * modelFansCount : 750
     * showWeixin : 1
     * hasFlowModel : false
     * authorFansCount : 0
     * hasFlowAuthor : false
     * authorType : 0
     * hasCollect : false
     * canView : false
     */

    private int id;
    private int type;
    private String name;
    private String cover;
    private String length;
    private int canWatchNum;
    private int mid;
    private int pid;
    private int sid;
    private int isCommend;
    private String url;
    private int price;
    private String info;
    private String label;
    private int status;
    private int checkStatus;
    private String reason;
    private int topType;
    private int endTopTime;
    private int startTopTime;
    private int payCount;
    private int playCount;
    private int collectNum;
    private int commentNum;
    private int shareStatus;
    private long downloadTime;
    private int score;
    private int onlinetime;
    private int handleOnlineStatus;
    private int backUpCount;
    private int sort;
    private int pushStatus;
    private int vip;
    private long ctime;
    private long utime;
    private String modelName;
    private String modelIcon;
    private int modelFansCount;
    private int showWeixin;
    private boolean hasFlowModel;
    private int authorFansCount;
    private boolean hasFlowAuthor;
    private int authorType;
    private boolean hasCollect;
    private boolean canView;

    @Override
    public int compareTo(@NonNull DataBean o) {
        return this.id-o.id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public int getCanWatchNum() {
        return canWatchNum;
    }

    public void setCanWatchNum(int canWatchNum) {
        this.canWatchNum = canWatchNum;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getIsCommend() {
        return isCommend;
    }

    public void setIsCommend(int isCommend) {
        this.isCommend = isCommend;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(int checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getTopType() {
        return topType;
    }

    public void setTopType(int topType) {
        this.topType = topType;
    }

    public int getEndTopTime() {
        return endTopTime;
    }

    public void setEndTopTime(int endTopTime) {
        this.endTopTime = endTopTime;
    }

    public int getStartTopTime() {
        return startTopTime;
    }

    public void setStartTopTime(int startTopTime) {
        this.startTopTime = startTopTime;
    }

    public int getPayCount() {
        return payCount;
    }

    public void setPayCount(int payCount) {
        this.payCount = payCount;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public int getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(int collectNum) {
        this.collectNum = collectNum;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public int getShareStatus() {
        return shareStatus;
    }

    public void setShareStatus(int shareStatus) {
        this.shareStatus = shareStatus;
    }

    public long getDownloadTime() {
        return downloadTime;
    }

    public void setDownloadTime(long downloadTime) {
        this.downloadTime = downloadTime;
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

    public int getHandleOnlineStatus() {
        return handleOnlineStatus;
    }

    public void setHandleOnlineStatus(int handleOnlineStatus) {
        this.handleOnlineStatus = handleOnlineStatus;
    }

    public int getBackUpCount() {
        return backUpCount;
    }

    public void setBackUpCount(int backUpCount) {
        this.backUpCount = backUpCount;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getPushStatus() {
        return pushStatus;
    }

    public void setPushStatus(int pushStatus) {
        this.pushStatus = pushStatus;
    }

    public int getVip() {
        return vip;
    }

    public void setVip(int vip) {
        this.vip = vip;
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

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelIcon() {
        return modelIcon;
    }

    public void setModelIcon(String modelIcon) {
        this.modelIcon = modelIcon;
    }

    public int getModelFansCount() {
        return modelFansCount;
    }

    public void setModelFansCount(int modelFansCount) {
        this.modelFansCount = modelFansCount;
    }

    public int getShowWeixin() {
        return showWeixin;
    }

    public void setShowWeixin(int showWeixin) {
        this.showWeixin = showWeixin;
    }

    public boolean isHasFlowModel() {
        return hasFlowModel;
    }

    public void setHasFlowModel(boolean hasFlowModel) {
        this.hasFlowModel = hasFlowModel;
    }

    public int getAuthorFansCount() {
        return authorFansCount;
    }

    public void setAuthorFansCount(int authorFansCount) {
        this.authorFansCount = authorFansCount;
    }

    public boolean isHasFlowAuthor() {
        return hasFlowAuthor;
    }

    public void setHasFlowAuthor(boolean hasFlowAuthor) {
        this.hasFlowAuthor = hasFlowAuthor;
    }

    public int getAuthorType() {
        return authorType;
    }

    public void setAuthorType(int authorType) {
        this.authorType = authorType;
    }

    public boolean isHasCollect() {
        return hasCollect;
    }

    public void setHasCollect(boolean hasCollect) {
        this.hasCollect = hasCollect;
    }

    public boolean isCanView() {
        return canView;
    }

    public void setCanView(boolean canView) {
        this.canView = canView;
    }
}
package com.muyu.zhibo.bean.liguiBean;

import java.util.List;

public class TabBean extends BaseBean {
    /**
     * success : true
     * data : [{"id":1,"name":"OL职场","status":1,"ctime":1541484227826,"utime":1541484227826},{"id":2,"name":"角色扮演\t","status":1,"ctime":1541484246846,"utime":1541484246846},{"id":3,"name":"性感内衣","status":1,"ctime":1541484259215,"utime":1541484259215},{"id":4,"name":"湿丝诱惑","status":1,"ctime":1541484269096,"utime":1542043723021},{"id":6,"name":"经典回顾","status":1,"ctime":1541484329296,"utime":1542043715855},{"id":7,"name":"神秘黑丝\t","status":1,"ctime":1541484351347,"utime":1542043712257},{"id":8,"name":"浪漫肉丝","status":1,"ctime":1541484359447,"utime":1542043707350},{"id":9,"name":"优雅灰丝","status":1,"ctime":1541484370017,"utime":1541484370017},{"id":10,"name":"纯洁白丝","status":1,"ctime":1541484382207,"utime":1542043744386}]
     * code : 0
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * name : OL职场
         * status : 1
         * ctime : 1541484227826
         * utime : 1541484227826
         */

        private String id;
        private String name;
        private int status;
        private long ctime;
        private long utime;
        private boolean checked=false;

        public boolean isChecked() {
            return checked;
        }

        public void setChecked(boolean checked) {
            this.checked = checked;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
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
    }
}

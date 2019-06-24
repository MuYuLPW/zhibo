package com.muyu.zhibo.bean;

import java.util.List;

public class ZhuBoBean {

    private List<ZhuboBean> zhubo;

    public List<ZhuboBean> getZhubo() {
        return zhubo;
    }

    public void setZhubo(List<ZhuboBean> zhubo) {
        this.zhubo = zhubo;
    }

    public static class ZhuboBean {
        /**
         * address : rtmp://pull.321939.top/live/397194_1560302474
         * img : http://qiuniuxyt.astoo.cn/FhiOViXHksIqYpaVx-KGn54Q4koy?imageView2/2/w/600/h/600
         * title : 玛利亚～风骚小秘书
         */

        private String address;
        private String img;
        private String title;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}

package com.muyu.zhibo.bean.liguiBean;

import android.support.annotation.NonNull;

import java.util.List;

public class ModelListBean extends BaseBean {
    /**
     * data : {"id":156,"name":"星星","cover":"http://web.ligui.com/storage/200*300*bae98ed86ebf7125d1325a0c3ca30272.jpg","icon":"http://web.ligui.com/storage/200*300*bae98ed86ebf7125d1325a0c3ca30272.jpg","nickName":"","englishName":"","birthday":"0","age":0,"height":"172","weight":"46","foot":"37","nation":"","status":1,"playCount":487,"sort":255,"ctime":1560323264277,"utime":1561551191347,"contentArray":[[{"id":816,"name":"《职场新秀》- 星星","cover":"http://web.ligui.com/storage/680*453*365dbae32eceab8514b0bccdf8143fee.jpg","url":"http://web.ligui.com/storage/video/8f88f079956d495a90341e3de82aa8e9.mp4","length":508,"canWatchNum":30,"isGood":0,"isCommend":1,"type":1,"mid":156,"status":1,"playCount":7161,"lidJson":"1,8","score":0,"onlinetime":0,"sort":0,"ctime":1560408389664,"utime":1561551220819}],[{"id":815,"name":"《职场新秀》- 星星","cover":"http://web.ligui.com/storage/200*300*bae98ed86ebf7125d1325a0c3ca30272.jpg","url":"http://web.ligui.com/storage/2000*3000*0e4f1db5a2795b95099031b676d6b427.jpg,http://web.ligui.com/storage/2000*3000*4ce067212bb936e4c52a97938cdf471a.jpg,http://web.ligui.com/storage/2000*3000*64c93ffdc160a16df4817c53bd13c8c7.jpg,http://web.ligui.com/storage/2000*3000*da5e175695ddecd0b4d28819cffc9a40.jpg,http://web.ligui.com/storage/2000*3000*3be225e3ae8428c10ba913a8bf02935f.jpg,http://web.ligui.com/storage/2000*3000*a84acd28f4c749dcd810b26737fbfd4b.jpg,http://web.ligui.com/storage/2000*3000*a94592d976d0338311435b07f28775c2.jpg,http://web.ligui.com/storage/2000*3000*4a8ef621a28e5fc41c6b2ba96d113c84.jpg,http://web.ligui.com/storage/2000*3000*afa9bbadf61e219d72bd6974a3acff84.jpg,http://web.ligui.com/storage/2000*3000*64a54b55b837c947f43d12f526507731.jpg,http://web.ligui.com/storage/2000*3000*669bdf6e34620adb83fbb82f0a232d96.jpg,http://web.ligui.com/storage/2000*3000*683922770a6dadda2cbe3070ec58c0eb.jpg,http://web.ligui.com/storage/2000*3000*8bd0d5b4b304787113be9859626cc899.jpg,http://web.ligui.com/storage/2000*3000*71b8f8cb74b6d672eaf7862a28c9fe14.jpg,http://web.ligui.com/storage/2000*3000*af93c178506b2442d23e2196aad20371.jpg,http://web.ligui.com/storage/2000*3000*f1b56a27857ce3e9ebb42172e66d59d8.jpg,http://web.ligui.com/storage/2000*3000*0da56b66d3cdca7adc0fabcf10dd5d51.jpg,http://web.ligui.com/storage/2000*3000*5b355475a78b37a97848d1d5bd0d864b.jpg,http://web.ligui.com/storage/2000*3000*de350fcc47dee3e08bf4e820100404e0.jpg,http://web.ligui.com/storage/2000*3000*1eb8f996d0f3d99082940cc790448395.jpg,http://web.ligui.com/storage/2000*3000*fa404745a2d955b08bca76f541ff2a02.jpg,http://web.ligui.com/storage/2000*3000*cf42113369cadd5b6c0828b94b235691.jpg,http://web.ligui.com/storage/2000*3000*225cf2744ea83601c8150ef7e38f113a.jpg,http://web.ligui.com/storage/3000*2000*07e68f85a6fb3bda9c216aee614198d5.jpg,http://web.ligui.com/storage/2000*3000*1c61c9fd7dd37a4b700f76508a178fa4.jpg,http://web.ligui.com/storage/2000*3000*c2126c88bf22d2b25388007eb232143c.jpg,http://web.ligui.com/storage/2000*3000*4c3efa81af730704651b3141afd4cbcb.jpg,http://web.ligui.com/storage/3000*2000*4eaa94ab28c41b15faa2c725c327356e.jpg,http://web.ligui.com/storage/3000*2000*575976e606386bbdb4bd33d142c40f3f.jpg,http://web.ligui.com/storage/2000*3000*d6a86f216f6f4e94ff60948bceff3b99.jpg,http://web.ligui.com/storage/2000*3000*01ba00cc778a5ece1dc3acd7aeeb642c.jpg,http://web.ligui.com/storage/2000*3000*670dc2cb8cdc0f1df2fa4f459330bef5.jpg,http://web.ligui.com/storage/2000*3000*95a876ada0c88ddd66f9b7e7da427b7d.jpg,http://web.ligui.com/storage/2000*3000*a13449e990f7a92ce830bad14032c7a2.jpg,http://web.ligui.com/storage/2000*3000*e62de4cfba9f889c20bd55f8377267a2.jpg,http://web.ligui.com/storage/2000*3000*69d0665beb085640327fff1b1a087fab.jpg,http://web.ligui.com/storage/2000*3000*10e4ae27efdae5ba6d693318afabd7a0.jpg,http://web.ligui.com/storage/2000*3000*97ea35487d9be36008e13a030d2bc132.jpg,http://web.ligui.com/storage/3000*2000*100a0f0fe97b731b076ddf7aba6933c4.jpg,http://web.ligui.com/storage/3000*2000*06a2daadc8855afcb7975a276bc80823.jpg,http://web.ligui.com/storage/3000*2000*4c707adbc2dfb6829d4deb81efa254d6.jpg,http://web.ligui.com/storage/3000*2000*95c23a3e9492ccd20659f0b8b5b979ee.jpg,http://web.ligui.com/storage/3000*2000*e31566f81fcd3a199041533c13b92cfd.jpg,http://web.ligui.com/storage/3000*2000*9421bcb92643ff6b2fd05051c5eb30af.jpg,http://web.ligui.com/storage/3000*2000*8ca232f5d637b9f8f64e71c4d8d4f692.jpg,http://web.ligui.com/storage/3000*2000*561a903015290289862c4bdb0bc7f168.jpg,http://web.ligui.com/storage/3000*2000*4c0ba866b1d1cfb6ad5d209ecab4f858.jpg,http://web.ligui.com/storage/3000*2000*211f7e0ed32a43c97edcda73586e4df6.jpg,http://web.ligui.com/storage/3000*2000*37b8c3fe3b6a2043ba79548f008ca639.jpg,http://web.ligui.com/storage/3000*2000*9203389973076e73daa22217100e46d8.jpg,http://web.ligui.com/storage/3000*2000*fe14c43bb2f3766a7c03e724cc3453a6.jpg,http://web.ligui.com/storage/3000*2000*cebc2b33672a57ce896502cd5fb7bedf.jpg,http://web.ligui.com/storage/2000*3000*2ee9948509fac218ce3bd277469bda33.jpg,http://web.ligui.com/storage/2000*3000*d36cd7382bf90f0f5ca574aa8c89ea63.jpg,http://web.ligui.com/storage/3000*2000*47d4f58fb0f06521471c5fad8ba411c2.jpg,http://web.ligui.com/storage/2000*3000*5501e3272765e18a5060ecc4ba68d8e0.jpg,http://web.ligui.com/storage/3000*2000*4a1c894c47e807b740d8a6deab77abfa.jpg,http://web.ligui.com/storage/2000*3000*e35ef956df4066b71eba1acccbfe5623.jpg,http://web.ligui.com/storage/3000*2000*3d871954705c98c60c599539a7005b45.jpg,http://web.ligui.com/storage/3000*2000*6457b999a8f3d163cc7355f3d1ac0468.jpg,http://web.ligui.com/storage/3000*2000*fba73478a6cfaef3b480e6e3c24b4526.jpg,http://web.ligui.com/storage/3000*2000*6c3d651a0f5c6919bcfcf8cd432e3199.jpg,http://web.ligui.com/storage/2000*3000*5a72436799e52e0bb0271f74b238eccf.jpg,http://web.ligui.com/storage/2000*3000*66b2b3b2aa0573d0c6d76846ac7935a5.jpg","length":64,"canWatchNum":3,"isGood":0,"isCommend":1,"type":0,"mid":156,"status":1,"playCount":5556,"lidJson":"1,8","score":0,"onlinetime":0,"sort":0,"ctime":1560323437481,"utime":1561542603626}]]}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 156
         * name : 星星
         * cover : http://web.ligui.com/storage/200*300*bae98ed86ebf7125d1325a0c3ca30272.jpg
         * icon : http://web.ligui.com/storage/200*300*bae98ed86ebf7125d1325a0c3ca30272.jpg
         * nickName :
         * englishName :
         * birthday : 0
         * age : 0
         * height : 172
         * weight : 46
         * foot : 37
         * nation :
         * status : 1
         * playCount : 487
         * sort : 255
         * ctime : 1560323264277
         * utime : 1561551191347
         * contentArray : [[{"id":816,"name":"《职场新秀》- 星星","cover":"http://web.ligui.com/storage/680*453*365dbae32eceab8514b0bccdf8143fee.jpg","url":"http://web.ligui.com/storage/video/8f88f079956d495a90341e3de82aa8e9.mp4","length":508,"canWatchNum":30,"isGood":0,"isCommend":1,"type":1,"mid":156,"status":1,"playCount":7161,"lidJson":"1,8","score":0,"onlinetime":0,"sort":0,"ctime":1560408389664,"utime":1561551220819}],[{"id":815,"name":"《职场新秀》- 星星","cover":"http://web.ligui.com/storage/200*300*bae98ed86ebf7125d1325a0c3ca30272.jpg","url":"http://web.ligui.com/storage/2000*3000*0e4f1db5a2795b95099031b676d6b427.jpg,http://web.ligui.com/storage/2000*3000*4ce067212bb936e4c52a97938cdf471a.jpg,http://web.ligui.com/storage/2000*3000*64c93ffdc160a16df4817c53bd13c8c7.jpg,http://web.ligui.com/storage/2000*3000*da5e175695ddecd0b4d28819cffc9a40.jpg,http://web.ligui.com/storage/2000*3000*3be225e3ae8428c10ba913a8bf02935f.jpg,http://web.ligui.com/storage/2000*3000*a84acd28f4c749dcd810b26737fbfd4b.jpg,http://web.ligui.com/storage/2000*3000*a94592d976d0338311435b07f28775c2.jpg,http://web.ligui.com/storage/2000*3000*4a8ef621a28e5fc41c6b2ba96d113c84.jpg,http://web.ligui.com/storage/2000*3000*afa9bbadf61e219d72bd6974a3acff84.jpg,http://web.ligui.com/storage/2000*3000*64a54b55b837c947f43d12f526507731.jpg,http://web.ligui.com/storage/2000*3000*669bdf6e34620adb83fbb82f0a232d96.jpg,http://web.ligui.com/storage/2000*3000*683922770a6dadda2cbe3070ec58c0eb.jpg,http://web.ligui.com/storage/2000*3000*8bd0d5b4b304787113be9859626cc899.jpg,http://web.ligui.com/storage/2000*3000*71b8f8cb74b6d672eaf7862a28c9fe14.jpg,http://web.ligui.com/storage/2000*3000*af93c178506b2442d23e2196aad20371.jpg,http://web.ligui.com/storage/2000*3000*f1b56a27857ce3e9ebb42172e66d59d8.jpg,http://web.ligui.com/storage/2000*3000*0da56b66d3cdca7adc0fabcf10dd5d51.jpg,http://web.ligui.com/storage/2000*3000*5b355475a78b37a97848d1d5bd0d864b.jpg,http://web.ligui.com/storage/2000*3000*de350fcc47dee3e08bf4e820100404e0.jpg,http://web.ligui.com/storage/2000*3000*1eb8f996d0f3d99082940cc790448395.jpg,http://web.ligui.com/storage/2000*3000*fa404745a2d955b08bca76f541ff2a02.jpg,http://web.ligui.com/storage/2000*3000*cf42113369cadd5b6c0828b94b235691.jpg,http://web.ligui.com/storage/2000*3000*225cf2744ea83601c8150ef7e38f113a.jpg,http://web.ligui.com/storage/3000*2000*07e68f85a6fb3bda9c216aee614198d5.jpg,http://web.ligui.com/storage/2000*3000*1c61c9fd7dd37a4b700f76508a178fa4.jpg,http://web.ligui.com/storage/2000*3000*c2126c88bf22d2b25388007eb232143c.jpg,http://web.ligui.com/storage/2000*3000*4c3efa81af730704651b3141afd4cbcb.jpg,http://web.ligui.com/storage/3000*2000*4eaa94ab28c41b15faa2c725c327356e.jpg,http://web.ligui.com/storage/3000*2000*575976e606386bbdb4bd33d142c40f3f.jpg,http://web.ligui.com/storage/2000*3000*d6a86f216f6f4e94ff60948bceff3b99.jpg,http://web.ligui.com/storage/2000*3000*01ba00cc778a5ece1dc3acd7aeeb642c.jpg,http://web.ligui.com/storage/2000*3000*670dc2cb8cdc0f1df2fa4f459330bef5.jpg,http://web.ligui.com/storage/2000*3000*95a876ada0c88ddd66f9b7e7da427b7d.jpg,http://web.ligui.com/storage/2000*3000*a13449e990f7a92ce830bad14032c7a2.jpg,http://web.ligui.com/storage/2000*3000*e62de4cfba9f889c20bd55f8377267a2.jpg,http://web.ligui.com/storage/2000*3000*69d0665beb085640327fff1b1a087fab.jpg,http://web.ligui.com/storage/2000*3000*10e4ae27efdae5ba6d693318afabd7a0.jpg,http://web.ligui.com/storage/2000*3000*97ea35487d9be36008e13a030d2bc132.jpg,http://web.ligui.com/storage/3000*2000*100a0f0fe97b731b076ddf7aba6933c4.jpg,http://web.ligui.com/storage/3000*2000*06a2daadc8855afcb7975a276bc80823.jpg,http://web.ligui.com/storage/3000*2000*4c707adbc2dfb6829d4deb81efa254d6.jpg,http://web.ligui.com/storage/3000*2000*95c23a3e9492ccd20659f0b8b5b979ee.jpg,http://web.ligui.com/storage/3000*2000*e31566f81fcd3a199041533c13b92cfd.jpg,http://web.ligui.com/storage/3000*2000*9421bcb92643ff6b2fd05051c5eb30af.jpg,http://web.ligui.com/storage/3000*2000*8ca232f5d637b9f8f64e71c4d8d4f692.jpg,http://web.ligui.com/storage/3000*2000*561a903015290289862c4bdb0bc7f168.jpg,http://web.ligui.com/storage/3000*2000*4c0ba866b1d1cfb6ad5d209ecab4f858.jpg,http://web.ligui.com/storage/3000*2000*211f7e0ed32a43c97edcda73586e4df6.jpg,http://web.ligui.com/storage/3000*2000*37b8c3fe3b6a2043ba79548f008ca639.jpg,http://web.ligui.com/storage/3000*2000*9203389973076e73daa22217100e46d8.jpg,http://web.ligui.com/storage/3000*2000*fe14c43bb2f3766a7c03e724cc3453a6.jpg,http://web.ligui.com/storage/3000*2000*cebc2b33672a57ce896502cd5fb7bedf.jpg,http://web.ligui.com/storage/2000*3000*2ee9948509fac218ce3bd277469bda33.jpg,http://web.ligui.com/storage/2000*3000*d36cd7382bf90f0f5ca574aa8c89ea63.jpg,http://web.ligui.com/storage/3000*2000*47d4f58fb0f06521471c5fad8ba411c2.jpg,http://web.ligui.com/storage/2000*3000*5501e3272765e18a5060ecc4ba68d8e0.jpg,http://web.ligui.com/storage/3000*2000*4a1c894c47e807b740d8a6deab77abfa.jpg,http://web.ligui.com/storage/2000*3000*e35ef956df4066b71eba1acccbfe5623.jpg,http://web.ligui.com/storage/3000*2000*3d871954705c98c60c599539a7005b45.jpg,http://web.ligui.com/storage/3000*2000*6457b999a8f3d163cc7355f3d1ac0468.jpg,http://web.ligui.com/storage/3000*2000*fba73478a6cfaef3b480e6e3c24b4526.jpg,http://web.ligui.com/storage/3000*2000*6c3d651a0f5c6919bcfcf8cd432e3199.jpg,http://web.ligui.com/storage/2000*3000*5a72436799e52e0bb0271f74b238eccf.jpg,http://web.ligui.com/storage/2000*3000*66b2b3b2aa0573d0c6d76846ac7935a5.jpg","length":64,"canWatchNum":3,"isGood":0,"isCommend":1,"type":0,"mid":156,"status":1,"playCount":5556,"lidJson":"1,8","score":0,"onlinetime":0,"sort":0,"ctime":1560323437481,"utime":1561542603626}]]
         */

        private int id;
        private String name;
        private String cover;
        private String icon;
        private String nickName;
        private String englishName;
        private String birthday;
        private int age;
        private String height;
        private String weight;
        private String foot;
        private String nation;
        private int status;
        private int playCount;
        private int sort;
        private long ctime;
        private long utime;
        private List<List<ContentArrayBean>> contentArray;

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

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getEnglishName() {
            return englishName;
        }

        public void setEnglishName(String englishName) {
            this.englishName = englishName;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getFoot() {
            return foot;
        }

        public void setFoot(String foot) {
            this.foot = foot;
        }

        public String getNation() {
            return nation;
        }

        public void setNation(String nation) {
            this.nation = nation;
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

        public List<List<ContentArrayBean>> getContentArray() {
            return contentArray;
        }

        public void setContentArray(List<List<ContentArrayBean>> contentArray) {
            this.contentArray = contentArray;
        }

        public static class ContentArrayBean implements Comparable<ContentArrayBean>{
            /**
             * id : 816
             * name : 《职场新秀》- 星星
             * cover : http://web.ligui.com/storage/680*453*365dbae32eceab8514b0bccdf8143fee.jpg
             * url : http://web.ligui.com/storage/video/8f88f079956d495a90341e3de82aa8e9.mp4
             * length : 508
             * canWatchNum : 30
             * isGood : 0
             * isCommend : 1
             * type : 1
             * mid : 156
             * status : 1
             * playCount : 7161
             * lidJson : 1,8
             * score : 0
             * onlinetime : 0
             * sort : 0
             * ctime : 1560408389664
             * utime : 1561551220819
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

            @Override
            public int compareTo(@NonNull ContentArrayBean o) {

                return this.id-o.id;
            }
        }
    }
}

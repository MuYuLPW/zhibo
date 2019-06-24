package com.muyu.zhibo.bean.liguiBean;

public class LoginBean extends BaseBean{
    /**
     * success : true
     * data : {"id":76683,"rand":-1,"userType":0,"phone":"17124267535","rids":[],"ridsJson":"[]","sid":0,"status":0,"name":"17124267535","sex":0,"birthdate":0,"age":0,"size":0,"height":0,"weight":0,"ctime":1542931070476,"utime":1560830153523,"startTime":0,"endTime":0,"score":0,"noticeTime":1550287701091,"suggestionTime":0,"token":"6sxxERCvf1bJ4eQL/cFyPccgq8+U6oQ0kSN03aVQfRA="}
     * code : 0
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
         * id : 76683
         * rand : -1
         * userType : 0
         * phone : 17124267535
         * rids : []
         * ridsJson : []
         * sid : 0
         * status : 0
         * name : 17124267535
         * sex : 0
         * birthdate : 0
         * age : 0
         * size : 0
         * height : 0
         * weight : 0
         * ctime : 1542931070476
         * utime : 1560830153523
         * startTime : 0
         * endTime : 0
         * score : 0
         * noticeTime : 1550287701091
         * suggestionTime : 0
         * token : 6sxxERCvf1bJ4eQL/cFyPccgq8+U6oQ0kSN03aVQfRA=
         */

        private int id;
        private String token;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}

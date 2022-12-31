package us.pinguo.inspire.module.masterlist;

import java.util.List;
import us.pinguo.user.model.IRelation;
/* loaded from: classes9.dex */
public class MasterData {
    private List<ListBean> list;
    private String name;
    private String sp;
    private int type;

    /* loaded from: classes9.dex */
    public static class ListBean implements IRelation {
        private String avatar;
        private String backgroundPic;
        private String desc;
        private String description;
        private int gender;
        private GeoBean geo;
        private String lang;
        private int mark;
        private String mobile;
        private String nickname;
        private int relation;
        private int type;
        private String typeIntro;
        private String userId;

        /* loaded from: classes9.dex */
        public static class GeoBean {
            private String city;
            private String country;
            private String province;

            public String getCity() {
                return this.city;
            }

            public String getCountry() {
                return this.country;
            }

            public String getProvince() {
                return this.province;
            }

            public void setCity(String str) {
                this.city = str;
            }

            public void setCountry(String str) {
                this.country = str;
            }

            public void setProvince(String str) {
                this.province = str;
            }
        }

        public String getAvatar() {
            return this.avatar;
        }

        public String getBackgroundPic() {
            return this.backgroundPic;
        }

        public String getDesc() {
            return this.desc;
        }

        public String getDescription() {
            return this.description;
        }

        public int getGender() {
            return this.gender;
        }

        public GeoBean getGeo() {
            return this.geo;
        }

        public String getLang() {
            return this.lang;
        }

        public int getMark() {
            return this.mark;
        }

        public String getMobile() {
            return this.mobile;
        }

        public String getNickname() {
            return this.nickname;
        }

        @Override // us.pinguo.user.model.IRelation
        public int getRelation() {
            return this.relation;
        }

        public int getType() {
            return this.type;
        }

        public String getTypeIntro() {
            return this.typeIntro;
        }

        public String getUserId() {
            return this.userId;
        }

        public void setAvatar(String str) {
            this.avatar = str;
        }

        public void setBackgroundPic(String str) {
            this.backgroundPic = str;
        }

        public void setDesc(String str) {
            this.desc = str;
        }

        public void setDescription(String str) {
            this.description = str;
        }

        public void setGender(int i2) {
            this.gender = i2;
        }

        public void setGeo(GeoBean geoBean) {
            this.geo = geoBean;
        }

        public void setLang(String str) {
            this.lang = str;
        }

        public void setMark(int i2) {
            this.mark = i2;
        }

        public void setMobile(String str) {
            this.mobile = str;
        }

        public void setNickname(String str) {
            this.nickname = str;
        }

        @Override // us.pinguo.user.model.IRelation
        public void setRelation(int i2) {
            this.relation = i2;
        }

        public void setType(int i2) {
            this.type = i2;
        }

        public void setTypeIntro(String str) {
            this.typeIntro = str;
        }

        public void setUserId(String str) {
            this.userId = str;
        }
    }

    public List<ListBean> getList() {
        return this.list;
    }

    public String getName() {
        return this.name;
    }

    public String getSp() {
        return this.sp;
    }

    public int getType() {
        return this.type;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSp(String str) {
        this.sp = str;
    }

    public void setType(int i2) {
        this.type = i2;
    }
}

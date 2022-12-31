package us.pinguo.bigdata.config;

import android.app.Application;
/* loaded from: classes3.dex */
public final class BDConfig {
    private final String cNum;
    private final String channel;
    private final String cid;
    private final String cuid;
    private final boolean debug;
    private final String lat;
    private final String longt;
    private final Application mApplication;
    private final String newUserTime;
    private final String sysNum;
    private final String userid;

    /* loaded from: classes3.dex */
    public static class Builder {
        private Application context;
        private boolean debug = false;
        private String cid = "";
        private String cuid = "";
        private String lat = "";
        private String longt = "";
        private String newUserTime = "";
        private String sysNum = "";
        private String cNum = "";
        private String userId = "";
        private String channel = "";

        public Builder(Application application) {
            this.context = application;
        }

        public BDConfig build() {
            return new BDConfig(this);
        }

        public Builder setChannel(String str) {
            this.channel = str;
            return this;
        }

        public Builder setCid(String str) {
            this.cid = str;
            return this;
        }

        public Builder setCuid(String str) {
            this.cuid = str;
            return this;
        }

        public Builder setDebug(boolean z) {
            this.debug = z;
            return this;
        }

        public Builder setGps(String str, String str2) {
            this.lat = str;
            this.longt = str2;
            return this;
        }

        public Builder setNewUserTime(String str) {
            this.newUserTime = str;
            return this;
        }

        public Builder setPicNum(String str, String str2) {
            this.sysNum = str;
            this.cNum = str2;
            return this;
        }

        public Builder setUserId(String str) {
            this.userId = str;
            return this;
        }
    }

    public Application getApplication() {
        return this.mApplication;
    }

    public String getChannel() {
        return this.channel;
    }

    public String getCid() {
        return this.cid;
    }

    public String getCuid() {
        return this.cuid;
    }

    public boolean getDebug() {
        return this.debug;
    }

    public String getLat() {
        return this.lat;
    }

    public String getLongt() {
        return this.longt;
    }

    public String getNewUserTime() {
        return this.newUserTime;
    }

    public String getUserid() {
        return this.userid;
    }

    private BDConfig(Builder builder) {
        this.mApplication = builder.context;
        this.debug = builder.debug;
        this.cid = builder.cid;
        this.cuid = builder.cuid;
        this.lat = builder.lat;
        this.longt = builder.longt;
        this.newUserTime = builder.newUserTime;
        this.sysNum = builder.sysNum;
        this.cNum = builder.cNum;
        this.userid = builder.userId;
        this.channel = builder.channel;
    }
}

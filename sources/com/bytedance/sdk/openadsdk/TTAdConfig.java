package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.adnet.face.IHttpStack;
/* loaded from: classes.dex */
public final class TTAdConfig {
    private String a;
    private String b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private String f1317d;

    /* renamed from: e  reason: collision with root package name */
    private String f1318e;

    /* renamed from: f  reason: collision with root package name */
    private int f1319f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1320g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1321h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1322i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f1323j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f1324k;

    /* renamed from: l  reason: collision with root package name */
    private IHttpStack f1325l;
    private String[] m;
    private boolean n;
    private int o;
    private int p;

    /* loaded from: classes.dex */
    public static class Builder {
        private String a;
        private String b;

        /* renamed from: d  reason: collision with root package name */
        private String f1326d;

        /* renamed from: e  reason: collision with root package name */
        private String f1327e;

        /* renamed from: l  reason: collision with root package name */
        private IHttpStack f1334l;
        private String[] m;
        private boolean c = false;

        /* renamed from: f  reason: collision with root package name */
        private int f1328f = 0;

        /* renamed from: g  reason: collision with root package name */
        private boolean f1329g = true;

        /* renamed from: h  reason: collision with root package name */
        private boolean f1330h = false;

        /* renamed from: i  reason: collision with root package name */
        private boolean f1331i = false;

        /* renamed from: j  reason: collision with root package name */
        private boolean f1332j = false;

        /* renamed from: k  reason: collision with root package name */
        private boolean f1333k = false;
        private boolean n = false;
        private int o = 0;
        private int p = -1;

        public Builder allowShowNotify(boolean z) {
            this.f1329g = z;
            return this;
        }

        public Builder allowShowPageWhenScreenLock(boolean z) {
            this.f1331i = z;
            return this;
        }

        public Builder appId(String str) {
            this.a = str;
            return this;
        }

        public Builder appName(String str) {
            this.b = str;
            return this;
        }

        public Builder asyncInit(boolean z) {
            this.n = z;
            return this;
        }

        public TTAdConfig build() {
            TTAdConfig tTAdConfig = new TTAdConfig();
            tTAdConfig.setAppId(this.a);
            tTAdConfig.setCoppa(this.o);
            tTAdConfig.setAppName(this.b);
            tTAdConfig.setPaid(this.c);
            tTAdConfig.setKeywords(this.f1326d);
            tTAdConfig.setData(this.f1327e);
            tTAdConfig.setTitleBarTheme(this.f1328f);
            tTAdConfig.setAllowShowNotify(this.f1329g);
            tTAdConfig.setDebug(this.f1330h);
            tTAdConfig.setAllowShowPageWhenScreenLock(this.f1331i);
            tTAdConfig.setUseTextureView(this.f1332j);
            tTAdConfig.setSupportMultiProcess(this.f1333k);
            tTAdConfig.setHttpStack(this.f1334l);
            tTAdConfig.setNeedClearTaskReset(this.m);
            tTAdConfig.setAsyncInit(this.n);
            tTAdConfig.setGDPR(this.p);
            return tTAdConfig;
        }

        public Builder coppa(int i2) {
            this.o = i2;
            return this;
        }

        public Builder data(String str) {
            this.f1327e = str;
            return this;
        }

        public Builder debug(boolean z) {
            this.f1330h = z;
            return this;
        }

        public Builder httpStack(IHttpStack iHttpStack) {
            this.f1334l = iHttpStack;
            return this;
        }

        public Builder keywords(String str) {
            this.f1326d = str;
            return this;
        }

        public Builder needClearTaskReset(String... strArr) {
            this.m = strArr;
            return this;
        }

        public Builder paid(boolean z) {
            this.c = z;
            return this;
        }

        public Builder setGDPR(int i2) {
            this.p = i2;
            return this;
        }

        public Builder supportMultiProcess(boolean z) {
            this.f1333k = z;
            return this;
        }

        public Builder titleBarTheme(int i2) {
            this.f1328f = i2;
            return this;
        }

        public Builder useTextureView(boolean z) {
            this.f1332j = z;
            return this;
        }
    }

    public String getAppId() {
        return this.a;
    }

    public String getAppName() {
        return this.b;
    }

    public int getCoppa() {
        return this.o;
    }

    public String getData() {
        return this.f1318e;
    }

    public int getGDPR() {
        return this.p;
    }

    public IHttpStack getHttpStack() {
        return this.f1325l;
    }

    public String getKeywords() {
        return this.f1317d;
    }

    public String[] getNeedClearTaskReset() {
        return this.m;
    }

    public int getTitleBarTheme() {
        return this.f1319f;
    }

    public boolean isAllowShowNotify() {
        return this.f1320g;
    }

    public boolean isAllowShowPageWhenScreenLock() {
        return this.f1322i;
    }

    public boolean isAsyncInit() {
        return this.n;
    }

    public boolean isDebug() {
        return this.f1321h;
    }

    public boolean isPaid() {
        return this.c;
    }

    public boolean isSupportMultiProcess() {
        return this.f1324k;
    }

    public boolean isUseTextureView() {
        return this.f1323j;
    }

    public void setAllowShowNotify(boolean z) {
        this.f1320g = z;
    }

    public void setAllowShowPageWhenScreenLock(boolean z) {
        this.f1322i = z;
    }

    public void setAppId(String str) {
        this.a = str;
    }

    public void setAppName(String str) {
        this.b = str;
    }

    public void setAsyncInit(boolean z) {
        this.n = z;
    }

    public void setCoppa(int i2) {
        this.o = i2;
    }

    public void setData(String str) {
        this.f1318e = str;
    }

    public void setDebug(boolean z) {
        this.f1321h = z;
    }

    public void setGDPR(int i2) {
        this.p = i2;
    }

    public void setHttpStack(IHttpStack iHttpStack) {
        this.f1325l = iHttpStack;
    }

    public void setKeywords(String str) {
        this.f1317d = str;
    }

    public void setNeedClearTaskReset(String... strArr) {
        this.m = strArr;
    }

    public void setPaid(boolean z) {
        this.c = z;
    }

    public void setSupportMultiProcess(boolean z) {
        this.f1324k = z;
    }

    public void setTitleBarTheme(int i2) {
        this.f1319f = i2;
    }

    public void setUseTextureView(boolean z) {
        this.f1323j = z;
    }

    private TTAdConfig() {
        this.c = false;
        this.f1319f = 0;
        this.f1320g = true;
        this.f1321h = false;
        this.f1322i = false;
        this.f1323j = false;
        this.f1324k = false;
        this.n = false;
        this.o = 0;
        this.p = -1;
    }
}

package com.tencent.bugly;

import java.util.Map;
/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public class BuglyStrategy {
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private String f7779d;

    /* renamed from: e  reason: collision with root package name */
    private String f7780e;

    /* renamed from: f  reason: collision with root package name */
    private long f7781f;

    /* renamed from: g  reason: collision with root package name */
    private String f7782g;

    /* renamed from: h  reason: collision with root package name */
    private String f7783h;
    private a r;

    /* renamed from: i  reason: collision with root package name */
    private boolean f7784i = true;

    /* renamed from: j  reason: collision with root package name */
    private boolean f7785j = true;

    /* renamed from: k  reason: collision with root package name */
    private boolean f7786k = false;

    /* renamed from: l  reason: collision with root package name */
    private boolean f7787l = true;
    private Class<?> m = null;
    private boolean n = true;
    private boolean o = true;
    private boolean p = true;
    private boolean q = false;
    protected int a = 31;
    protected boolean b = false;

    /* compiled from: BUGLY */
    /* loaded from: classes3.dex */
    public static class a {
        public static final int CRASHTYPE_ANR = 4;
        public static final int CRASHTYPE_BLOCK = 7;
        public static final int CRASHTYPE_COCOS2DX_JS = 5;
        public static final int CRASHTYPE_COCOS2DX_LUA = 6;
        public static final int CRASHTYPE_JAVA_CATCH = 1;
        public static final int CRASHTYPE_JAVA_CRASH = 0;
        public static final int CRASHTYPE_NATIVE = 2;
        public static final int CRASHTYPE_U3D = 3;
        public static final int MAX_USERDATA_KEY_LENGTH = 100;
        public static final int MAX_USERDATA_VALUE_LENGTH = 30000;

        public synchronized Map<String, String> onCrashHandleStart(int i2, String str, String str2, String str3) {
            return null;
        }

        public synchronized byte[] onCrashHandleStart2GetExtraDatas(int i2, String str, String str2, String str3) {
            return null;
        }
    }

    public synchronized String getAppChannel() {
        String str = this.f7779d;
        if (str == null) {
            return com.tencent.bugly.crashreport.common.info.a.b().m;
        }
        return str;
    }

    public synchronized String getAppPackageName() {
        String str = this.f7780e;
        if (str == null) {
            return com.tencent.bugly.crashreport.common.info.a.b().c;
        }
        return str;
    }

    public synchronized long getAppReportDelay() {
        return this.f7781f;
    }

    public synchronized String getAppVersion() {
        String str = this.c;
        if (str == null) {
            return com.tencent.bugly.crashreport.common.info.a.b().f7824k;
        }
        return str;
    }

    public synchronized int getCallBackType() {
        return this.a;
    }

    public synchronized boolean getCloseErrorCallback() {
        return this.b;
    }

    public synchronized a getCrashHandleCallback() {
        return this.r;
    }

    public synchronized String getDeviceID() {
        return this.f7783h;
    }

    public synchronized String getLibBuglySOFilePath() {
        return this.f7782g;
    }

    public synchronized Class<?> getUserInfoActivity() {
        return this.m;
    }

    public synchronized boolean isBuglyLogUpload() {
        return this.n;
    }

    public synchronized boolean isEnableANRCrashMonitor() {
        return this.f7785j;
    }

    public synchronized boolean isEnableCatchAnrTrace() {
        return this.f7786k;
    }

    public synchronized boolean isEnableNativeCrashMonitor() {
        return this.f7784i;
    }

    public synchronized boolean isEnableUserInfo() {
        return this.f7787l;
    }

    public boolean isReplaceOldChannel() {
        return this.o;
    }

    public synchronized boolean isUploadProcess() {
        return this.p;
    }

    public synchronized boolean recordUserInfoOnceADay() {
        return this.q;
    }

    public synchronized BuglyStrategy setAppChannel(String str) {
        this.f7779d = str;
        return this;
    }

    public synchronized BuglyStrategy setAppPackageName(String str) {
        this.f7780e = str;
        return this;
    }

    public synchronized BuglyStrategy setAppReportDelay(long j2) {
        this.f7781f = j2;
        return this;
    }

    public synchronized BuglyStrategy setAppVersion(String str) {
        this.c = str;
        return this;
    }

    public synchronized BuglyStrategy setBuglyLogUpload(boolean z) {
        this.n = z;
        return this;
    }

    public synchronized void setCallBackType(int i2) {
        this.a = i2;
    }

    public synchronized void setCloseErrorCallback(boolean z) {
        this.b = z;
    }

    public synchronized BuglyStrategy setCrashHandleCallback(a aVar) {
        this.r = aVar;
        return this;
    }

    public synchronized BuglyStrategy setDeviceID(String str) {
        this.f7783h = str;
        return this;
    }

    public synchronized BuglyStrategy setEnableANRCrashMonitor(boolean z) {
        this.f7785j = z;
        return this;
    }

    public void setEnableCatchAnrTrace(boolean z) {
        this.f7786k = z;
    }

    public synchronized BuglyStrategy setEnableNativeCrashMonitor(boolean z) {
        this.f7784i = z;
        return this;
    }

    public synchronized BuglyStrategy setEnableUserInfo(boolean z) {
        this.f7787l = z;
        return this;
    }

    public synchronized BuglyStrategy setLibBuglySOFilePath(String str) {
        this.f7782g = str;
        return this;
    }

    public synchronized BuglyStrategy setRecordUserInfoOnceADay(boolean z) {
        this.q = z;
        return this;
    }

    public void setReplaceOldChannel(boolean z) {
        this.o = z;
    }

    public synchronized BuglyStrategy setUploadProcess(boolean z) {
        this.p = z;
        return this;
    }

    public synchronized BuglyStrategy setUserInfoActivity(Class<?> cls) {
        this.m = cls;
        return this;
    }
}

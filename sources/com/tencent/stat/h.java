package com.tencent.stat;
/* loaded from: classes3.dex */
/* synthetic */ class h {
    static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[StatReportStrategy.values().length];
        a = iArr;
        try {
            iArr[StatReportStrategy.INSTANT.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[StatReportStrategy.ONLY_WIFI.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[StatReportStrategy.APP_LAUNCH.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[StatReportStrategy.DEVELOPER.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[StatReportStrategy.BATCH.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[StatReportStrategy.PERIOD.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            a[StatReportStrategy.ONLY_WIFI_NO_CACHE.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
    }
}

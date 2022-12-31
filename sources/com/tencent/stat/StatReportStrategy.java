package com.tencent.stat;
/* loaded from: classes3.dex */
public enum StatReportStrategy {
    INSTANT(1),
    ONLY_WIFI(2),
    BATCH(3),
    APP_LAUNCH(4),
    DEVELOPER(5),
    PERIOD(6),
    ONLY_WIFI_NO_CACHE(7);
    
    int a;

    StatReportStrategy(int i2) {
        this.a = i2;
    }

    public static StatReportStrategy getStatReportStrategy(int i2) {
        StatReportStrategy[] values;
        for (StatReportStrategy statReportStrategy : values()) {
            if (i2 == statReportStrategy.a()) {
                return statReportStrategy;
            }
        }
        return null;
    }

    public int a() {
        return this.a;
    }
}

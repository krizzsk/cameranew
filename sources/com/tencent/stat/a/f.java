package com.tencent.stat.a;
/* loaded from: classes3.dex */
public enum f {
    PAGE_VIEW(1),
    SESSION_ENV(2),
    ERROR(3),
    CUSTOM(1000),
    ADDITION(1001),
    MONITOR_STAT(1002),
    MTA_GAME_USER(1003),
    NETWORK_MONITOR(1004);
    

    /* renamed from: i  reason: collision with root package name */
    private int f8268i;

    f(int i2) {
        this.f8268i = i2;
    }

    public int a() {
        return this.f8268i;
    }
}

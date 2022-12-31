package com.bytedance.sdk.a.b.a.e;
/* compiled from: ErrorCode.java */
/* loaded from: classes.dex */
public enum b {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8);
    

    /* renamed from: g  reason: collision with root package name */
    public final int f946g;

    b(int i2) {
        this.f946g = i2;
    }

    public static b a(int i2) {
        b[] values;
        for (b bVar : values()) {
            if (bVar.f946g == i2) {
                return bVar;
            }
        }
        return null;
    }
}

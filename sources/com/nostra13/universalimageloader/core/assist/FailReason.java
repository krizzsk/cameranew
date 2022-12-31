package com.nostra13.universalimageloader.core.assist;
/* loaded from: classes3.dex */
public class FailReason {
    private final FailType a;
    private final Throwable b;

    /* loaded from: classes3.dex */
    public enum FailType {
        IO_ERROR,
        DECODING_ERROR,
        NETWORK_DENIED,
        OUT_OF_MEMORY,
        UNKNOWN
    }

    public FailReason(FailType failType, Throwable th) {
        this.a = failType;
        this.b = th;
    }

    public Throwable a() {
        return this.b;
    }

    public FailType b() {
        return this.a;
    }
}

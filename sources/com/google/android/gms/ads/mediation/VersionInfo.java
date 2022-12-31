package com.google.android.gms.ads.mediation;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class VersionInfo {
    private final int a;
    private final int b;
    private final int c;

    public VersionInfo(int i2, int i3, int i4) {
        this.a = i2;
        this.b = i3;
        this.c = i4;
    }

    public final int getMajorVersion() {
        return this.a;
    }

    public final int getMicroVersion() {
        return this.c;
    }

    public final int getMinorVersion() {
        return this.b;
    }
}

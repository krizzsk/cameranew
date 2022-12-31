package com.google.android.gms.internal.ads;

import java.io.IOException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzhe extends Exception {
    private final int type;
    private final int zzaej;

    private zzhe(int i2, String str, Throwable th, int i3) {
        super(null, th);
        this.type = i2;
        this.zzaej = i3;
    }

    public static zzhe zza(Exception exc, int i2) {
        return new zzhe(1, null, exc, i2);
    }

    public static zzhe zza(IOException iOException) {
        return new zzhe(0, null, iOException, -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzhe zza(RuntimeException runtimeException) {
        return new zzhe(2, null, runtimeException, -1);
    }
}

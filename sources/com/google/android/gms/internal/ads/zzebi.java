package com.google.android.gms.internal.ads;

import java.util.Arrays;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzebi<P> {
    private final P zzibr;
    private final byte[] zzibs;
    private final zzege zzibt;
    private final zzegx zzibu;
    private final int zzibv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzebi(P p, byte[] bArr, zzege zzegeVar, zzegx zzegxVar, int i2) {
        this.zzibr = p;
        this.zzibs = Arrays.copyOf(bArr, bArr.length);
        this.zzibt = zzegeVar;
        this.zzibu = zzegxVar;
        this.zzibv = i2;
    }

    public final P zzbat() {
        return this.zzibr;
    }

    public final zzege zzbau() {
        return this.zzibt;
    }

    public final zzegx zzbav() {
        return this.zzibu;
    }

    public final byte[] zzbaw() {
        byte[] bArr = this.zzibs;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }
}

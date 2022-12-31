package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public class zzcmb extends Exception {
    private final zzdom zzgnm;

    public zzcmb(zzdom zzdomVar) {
        this.zzgnm = zzdomVar;
    }

    public final zzdom zzarh() {
        return this.zzgnm;
    }

    public zzcmb(zzdom zzdomVar, String str) {
        super(str);
        this.zzgnm = zzdomVar;
    }

    public zzcmb(zzdom zzdomVar, String str, Throwable th) {
        super(str, th);
        this.zzgnm = zzdomVar;
    }
}

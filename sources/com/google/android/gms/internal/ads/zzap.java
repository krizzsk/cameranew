package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public class zzap extends Exception {
    private long zzal;
    private final zzz zzbt;

    public zzap() {
        this.zzbt = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(long j2) {
        this.zzal = j2;
    }

    public zzap(zzz zzzVar) {
        this.zzbt = zzzVar;
    }

    public zzap(String str) {
        super(str);
        this.zzbt = null;
    }

    public zzap(Throwable th) {
        super(th);
        this.zzbt = null;
    }
}

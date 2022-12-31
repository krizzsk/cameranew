package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzmr implements Runnable {
    private final /* synthetic */ zzms zzbdl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmr(zzms zzmsVar) {
        this.zzbdl = zzmsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzbdl.zzht();
    }
}

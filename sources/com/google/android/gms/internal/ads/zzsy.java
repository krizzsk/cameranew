package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzsy implements Runnable {
    private final /* synthetic */ zzsz zzbvc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzsy(zzsz zzszVar) {
        this.zzbvc = zzszVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzbvc.disconnect();
    }
}

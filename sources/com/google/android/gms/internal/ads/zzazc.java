package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
final class zzazc extends Thread {
    private final /* synthetic */ String zzegh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzazc(zzayz zzayzVar, String str) {
        this.zzegh = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        new zzazo().zzel(this.zzegh);
    }
}

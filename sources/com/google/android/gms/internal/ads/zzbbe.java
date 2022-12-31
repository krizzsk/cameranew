package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzbbe implements Runnable {
    private final /* synthetic */ zzbax zzekp;
    private final /* synthetic */ boolean zzeks;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbbe(zzbax zzbaxVar, boolean z) {
        this.zzekp = zzbaxVar;
        this.zzeks = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzekp.zzd("windowVisibilityChanged", "isVisible", String.valueOf(this.zzeks));
    }
}

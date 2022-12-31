package com.google.android.gms.internal.ads;

import java.util.HashMap;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzbdg implements Runnable {
    private final /* synthetic */ String zzegh;
    private final /* synthetic */ String zzepp;
    private final /* synthetic */ boolean zzepv = false;
    private final /* synthetic */ zzbdd zzepy;
    private final /* synthetic */ int zzepz;
    private final /* synthetic */ int zzeqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbdg(zzbdd zzbddVar, String str, String str2, int i2, int i3, boolean z) {
        this.zzepy = zzbddVar;
        this.zzegh = str;
        this.zzepp = str2;
        this.zzepz = i2;
        this.zzeqa = i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheProgress");
        hashMap.put("src", this.zzegh);
        hashMap.put("cachedSrc", this.zzepp);
        hashMap.put("bytesLoaded", Integer.toString(this.zzepz));
        hashMap.put("totalBytes", Integer.toString(this.zzeqa));
        hashMap.put("cacheReady", "0");
        this.zzepy.zza("onPrecacheEvent", hashMap);
    }
}

package com.google.android.gms.internal.ads;

import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbdh implements Runnable {
    private final /* synthetic */ String zzegh;
    private final /* synthetic */ String zzepp;
    private final /* synthetic */ zzbdd zzepy;
    private final /* synthetic */ int zzeqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbdh(zzbdd zzbddVar, String str, String str2, int i2) {
        this.zzepy = zzbddVar;
        this.zzegh = str;
        this.zzepp = str2;
        this.zzeqa = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheComplete");
        hashMap.put("src", this.zzegh);
        hashMap.put("cachedSrc", this.zzepp);
        hashMap.put("totalBytes", Integer.toString(this.zzeqa));
        this.zzepy.zza("onPrecacheEvent", hashMap);
    }
}

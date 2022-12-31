package com.google.android.gms.internal.ads;

import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbdf implements Runnable {
    private final /* synthetic */ String zzegh;
    private final /* synthetic */ String zzepp;
    private final /* synthetic */ long zzepq;
    private final /* synthetic */ long zzepr;
    private final /* synthetic */ long zzeps;
    private final /* synthetic */ long zzept;
    private final /* synthetic */ long zzepu;
    private final /* synthetic */ boolean zzepv;
    private final /* synthetic */ int zzepw;
    private final /* synthetic */ int zzepx;
    private final /* synthetic */ zzbdd zzepy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbdf(zzbdd zzbddVar, String str, String str2, long j2, long j3, long j4, long j5, long j6, boolean z, int i2, int i3) {
        this.zzepy = zzbddVar;
        this.zzegh = str;
        this.zzepp = str2;
        this.zzepq = j2;
        this.zzepr = j3;
        this.zzeps = j4;
        this.zzept = j5;
        this.zzepu = j6;
        this.zzepv = z;
        this.zzepw = i2;
        this.zzepx = i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheProgress");
        hashMap.put("src", this.zzegh);
        hashMap.put("cachedSrc", this.zzepp);
        hashMap.put("bufferedDuration", Long.toString(this.zzepq));
        hashMap.put("totalDuration", Long.toString(this.zzepr));
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcrm)).booleanValue()) {
            hashMap.put("qoeLoadedBytes", Long.toString(this.zzeps));
            hashMap.put("qoeCachedBytes", Long.toString(this.zzept));
            hashMap.put("totalBytes", Long.toString(this.zzepu));
            hashMap.put("reportTime", Long.toString(com.google.android.gms.ads.internal.zzr.zzky().currentTimeMillis()));
        }
        hashMap.put("cacheReady", this.zzepv ? "1" : "0");
        hashMap.put("playerCount", Integer.toString(this.zzepw));
        hashMap.put("playerPreparedCount", Integer.toString(this.zzepx));
        this.zzepy.zza("onPrecacheEvent", hashMap);
    }
}

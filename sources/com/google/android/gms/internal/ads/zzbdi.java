package com.google.android.gms.internal.ads;

import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbdi implements Runnable {
    private final /* synthetic */ String zzegh;
    private final /* synthetic */ String zzepp;
    private final /* synthetic */ long zzepq;
    private final /* synthetic */ long zzepr;
    private final /* synthetic */ boolean zzepv;
    private final /* synthetic */ int zzepw;
    private final /* synthetic */ int zzepx;
    private final /* synthetic */ zzbdd zzepy;
    private final /* synthetic */ int zzepz;
    private final /* synthetic */ int zzeqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbdi(zzbdd zzbddVar, String str, String str2, int i2, int i3, long j2, long j3, boolean z, int i4, int i5) {
        this.zzepy = zzbddVar;
        this.zzegh = str;
        this.zzepp = str2;
        this.zzepz = i2;
        this.zzeqa = i3;
        this.zzepq = j2;
        this.zzepr = j3;
        this.zzepv = z;
        this.zzepw = i4;
        this.zzepx = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheProgress");
        hashMap.put("src", this.zzegh);
        hashMap.put("cachedSrc", this.zzepp);
        hashMap.put("bytesLoaded", Integer.toString(this.zzepz));
        hashMap.put("totalBytes", Integer.toString(this.zzeqa));
        hashMap.put("bufferedDuration", Long.toString(this.zzepq));
        hashMap.put("totalDuration", Long.toString(this.zzepr));
        hashMap.put("cacheReady", this.zzepv ? "1" : "0");
        hashMap.put("playerCount", Integer.toString(this.zzepw));
        hashMap.put("playerPreparedCount", Integer.toString(this.zzepx));
        this.zzepy.zza("onPrecacheEvent", hashMap);
    }
}

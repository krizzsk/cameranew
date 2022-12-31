package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbdj implements Runnable {
    private final /* synthetic */ String val$message;
    private final /* synthetic */ String zzegh;
    private final /* synthetic */ String zzepp;
    private final /* synthetic */ zzbdd zzepy;
    private final /* synthetic */ String zzeqb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbdj(zzbdd zzbddVar, String str, String str2, String str3, String str4) {
        this.zzepy = zzbddVar;
        this.zzegh = str;
        this.zzepp = str2;
        this.zzeqb = str3;
        this.val$message = str4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String zzfi;
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheCanceled");
        hashMap.put("src", this.zzegh);
        if (!TextUtils.isEmpty(this.zzepp)) {
            hashMap.put("cachedSrc", this.zzepp);
        }
        zzbdd zzbddVar = this.zzepy;
        zzfi = zzbdd.zzfi(this.zzeqb);
        hashMap.put("type", zzfi);
        hashMap.put("reason", this.zzeqb);
        if (!TextUtils.isEmpty(this.val$message)) {
            hashMap.put("message", this.val$message);
        }
        this.zzepy.zza("onPrecacheEvent", hashMap);
    }
}

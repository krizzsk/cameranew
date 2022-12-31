package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.Key;
import javax.crypto.Mac;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzeis extends ThreadLocal<Mac> {
    private final /* synthetic */ zzeip zziky;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeis(zzeip zzeipVar) {
        this.zziky = zzeipVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.ThreadLocal
    /* renamed from: zzbft */
    public final Mac initialValue() {
        String str;
        Key key;
        try {
            zzeie<zzeik, Mac> zzeieVar = zzeie.zzikh;
            str = this.zziky.zzikr;
            Mac zzhw = zzeieVar.zzhw(str);
            key = this.zziky.zziks;
            zzhw.init(key);
            return zzhw;
        } catch (GeneralSecurityException e2) {
            throw new IllegalStateException(e2);
        }
    }
}

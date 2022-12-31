package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzemo;
import java.security.GeneralSecurityException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzeay<KeyFormatProtoT extends zzemo, KeyProtoT extends zzemo> {
    private final zzeba<KeyFormatProtoT, KeyProtoT> zzibm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeay(zzeba<KeyFormatProtoT, KeyProtoT> zzebaVar) {
        this.zzibm = zzebaVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final KeyProtoT zzq(zzejr zzejrVar) throws GeneralSecurityException, zzelo {
        KeyFormatProtoT zzr = this.zzibm.zzr(zzejrVar);
        this.zzibm.zzd(zzr);
        return this.zzibm.zze(zzr);
    }
}

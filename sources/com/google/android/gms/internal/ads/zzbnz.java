package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbnz {
    public final List<? extends zzdzw<? extends zzbnt>> zzfwk;

    public zzbnz(List<? extends zzdzw<? extends zzbnt>> list) {
        this.zzfwk = list;
    }

    public static zzcrj<zzbnz> zza(@NonNull zzcty<? extends zzbnt> zzctyVar) {
        return new zzcrm(zzctyVar, zzboc.zzeaj);
    }

    public static zzcrj<zzbnz> zza(@NonNull zzcrj<? extends zzbnt> zzcrjVar) {
        return new zzcrm(zzcrjVar, zzbob.zzeaj);
    }

    public zzbnz(zzbnt zzbntVar) {
        this.zzfwk = Collections.singletonList(zzdzk.zzag(zzbntVar));
    }
}

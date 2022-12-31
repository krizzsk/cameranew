package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdtt;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
final class zzdtw implements zzelj<Integer, zzdtt.zza> {
    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ zzdtt.zza convert(Integer num) {
        zzdtt.zza zzeh = zzdtt.zza.zzeh(num.intValue());
        return zzeh == null ? zzdtt.zza.BLOCKED_REASON_UNKNOWN : zzeh;
    }
}

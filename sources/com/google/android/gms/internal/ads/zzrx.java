package com.google.android.gms.internal.ads;

import java.util.Comparator;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzrx implements Comparator<zzsd> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzrx(zzru zzruVar) {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzsd zzsdVar, zzsd zzsdVar2) {
        zzsd zzsdVar3 = zzsdVar;
        zzsd zzsdVar4 = zzsdVar2;
        int i2 = zzsdVar3.zzbuc - zzsdVar4.zzbuc;
        return i2 != 0 ? i2 : (int) (zzsdVar3.value - zzsdVar4.value);
    }
}

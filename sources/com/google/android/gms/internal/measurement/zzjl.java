package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzjl extends zzjs {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjl(int i2) {
        super(i2, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzjs
    public final void zza() {
        if (!zzb()) {
            for (int i2 = 0; i2 < zzc(); i2++) {
                Map.Entry zzd = zzd(i2);
                if (((zzhi) zzd.getKey()).zzc()) {
                    zzd.setValue(Collections.unmodifiableList((List) zzd.getValue()));
                }
            }
            for (Map.Entry entry : zze()) {
                if (((zzhi) entry.getKey()).zzc()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zza();
    }
}

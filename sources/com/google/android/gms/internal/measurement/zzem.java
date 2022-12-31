package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
final class zzem extends ContentObserver {
    final /* synthetic */ zzen zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzem(zzen zzenVar, Handler handler) {
        super(null);
        this.zza = zzenVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        this.zza.zzc();
    }
}

package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzet extends ContentObserver {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzet(zzeu zzeuVar, Handler handler) {
        super(null);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        zzfg.zzc();
    }
}

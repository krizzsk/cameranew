package com.google.android.gms.internal.ads;

import android.os.Binder;
import android.os.Bundle;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.c;
import java.io.InputStream;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzcnl implements c.a, c.b {
    protected zzatq zzgoq;
    @GuardedBy("mLock")
    @VisibleForTesting(otherwise = 3)
    protected zzasy zzgor;
    protected final zzbaa<InputStream> zzdlg = new zzbaa<>();
    protected final Object mLock = new Object();
    protected boolean zzgoo = false;
    protected boolean zzgop = false;

    @Override // com.google.android.gms.common.internal.c.a
    public abstract /* synthetic */ void onConnected(@Nullable Bundle bundle);

    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        zzazk.zzdy("Disconnected from remote ad request service.");
        this.zzdlg.setException(new zzcoc(zzdom.INTERNAL_ERROR));
    }

    @Override // com.google.android.gms.common.internal.c.a
    public void onConnectionSuspended(int i2) {
        zzazk.zzdy("Cannot connect to remote service, fallback to local instance.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzarp() {
        synchronized (this.mLock) {
            this.zzgop = true;
            if (this.zzgor.isConnected() || this.zzgor.isConnecting()) {
                this.zzgor.disconnect();
            }
            Binder.flushPendingCommands();
        }
    }
}

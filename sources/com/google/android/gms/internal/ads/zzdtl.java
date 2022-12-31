package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdtl implements c.a, c.b {
    private final Object lock = new Object();
    private boolean zzgoo = false;
    private boolean zzgop = false;
    private final zzduh zzhsx;
    private final zzdua zzhsy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdtl(@NonNull Context context, @NonNull Looper looper, @NonNull zzdua zzduaVar) {
        this.zzhsy = zzduaVar;
        this.zzhsx = new zzduh(context, looper, this, this, 12800000);
    }

    private final void zzarp() {
        synchronized (this.lock) {
            if (this.zzhsx.isConnected() || this.zzhsx.isConnecting()) {
                this.zzhsx.disconnect();
            }
            Binder.flushPendingCommands();
        }
    }

    @Override // com.google.android.gms.common.internal.c.a
    public final void onConnected(@Nullable Bundle bundle) {
        synchronized (this.lock) {
            if (this.zzgop) {
                return;
            }
            this.zzgop = true;
            try {
                this.zzhsx.zzayh().zza(new zzduf(this.zzhsy.toByteArray()));
                zzarp();
            } catch (Exception unused) {
                zzarp();
            } catch (Throwable th) {
                zzarp();
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.c.b
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }

    @Override // com.google.android.gms.common.internal.c.a
    public final void onConnectionSuspended(int i2) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzaxv() {
        synchronized (this.lock) {
            if (!this.zzgoo) {
                this.zzgoo = true;
                this.zzhsx.checkAvailabilityAndConnect();
            }
        }
    }
}

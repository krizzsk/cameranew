package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import androidx.annotation.Nullable;
import java.util.concurrent.Future;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zztn {
    private final Context context;
    private final Object lock = new Object();
    @Nullable
    @GuardedBy("lock")
    private zzte zzbve;
    @GuardedBy("lock")
    private boolean zzbvv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zztn(Context context) {
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disconnect() {
        synchronized (this.lock) {
            zzte zzteVar = this.zzbve;
            if (zzteVar == null) {
                return;
            }
            zzteVar.disconnect();
            this.zzbve = null;
            Binder.flushPendingCommands();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Future<zztv> zzd(zzth zzthVar) {
        zztm zztmVar = new zztm(this);
        zztp zztpVar = new zztp(this, zzthVar, zztmVar);
        zztt zzttVar = new zztt(this, zztmVar);
        synchronized (this.lock) {
            zzte zzteVar = new zzte(this.context, com.google.android.gms.ads.internal.zzr.zzlf().zzzp(), zztpVar, zzttVar);
            this.zzbve = zzteVar;
            zzteVar.checkAvailabilityAndConnect();
        }
        return zztmVar;
    }
}

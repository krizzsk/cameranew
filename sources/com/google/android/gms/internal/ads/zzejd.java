package com.google.android.gms.internal.ads;

import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-ads-base@@19.7.0 */
/* loaded from: classes2.dex */
final class zzejd extends zzeiz {
    private final zzejc zzili = new zzejc();

    @Override // com.google.android.gms.internal.ads.zzeiz
    public final void zza(Throwable th, Throwable th2) {
        if (th2 != th) {
            Objects.requireNonNull(th2, "The suppressed exception cannot be null.");
            this.zzili.zza(th, true).add(th2);
            return;
        }
        throw new IllegalArgumentException("Self suppression is not allowed.", th2);
    }

    @Override // com.google.android.gms.internal.ads.zzeiz
    public final void zza(Throwable th, PrintWriter printWriter) {
        th.printStackTrace(printWriter);
        List<Throwable> zza = this.zzili.zza(th, false);
        if (zza == null) {
            return;
        }
        synchronized (zza) {
            for (Throwable th2 : zza) {
                printWriter.print("Suppressed: ");
                th2.printStackTrace(printWriter);
            }
        }
    }
}

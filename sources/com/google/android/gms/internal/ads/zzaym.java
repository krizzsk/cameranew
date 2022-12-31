package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.common.util.Clock;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaym {
    private long zzebt = -1;
    private long zzebu = -1;
    private final /* synthetic */ zzayn zzebv;

    public zzaym(zzayn zzaynVar) {
        this.zzebv = zzaynVar;
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putLong("topen", this.zzebt);
        bundle.putLong("tclose", this.zzebu);
        return bundle;
    }

    public final long zzxf() {
        return this.zzebu;
    }

    public final void zzxg() {
        Clock clock;
        clock = this.zzebv.zzbqg;
        this.zzebu = clock.a();
    }

    public final void zzxh() {
        Clock clock;
        clock = this.zzebv.zzbqg;
        this.zzebt = clock.a();
    }
}

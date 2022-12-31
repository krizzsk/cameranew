package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzdb;
import com.google.android.gms.internal.measurement.zzdj;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public final class h9 {
    zzdj a;
    List<Long> b;
    List<zzdb> c;

    /* renamed from: d  reason: collision with root package name */
    long f3822d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ i9 f3823e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h9(i9 i9Var, a9 a9Var) {
        this.f3823e = i9Var;
    }

    private static final long b(zzdb zzdbVar) {
        return ((zzdbVar.zzf() / 1000) / 60) / 60;
    }

    public final boolean a(long j2, zzdb zzdbVar) {
        com.google.android.gms.common.internal.q.j(zzdbVar);
        if (this.c == null) {
            this.c = new ArrayList();
        }
        if (this.b == null) {
            this.b = new ArrayList();
        }
        if (this.c.size() <= 0 || b(this.c.get(0)) == b(zzdbVar)) {
            long zzbw = this.f3822d + zzdbVar.zzbw();
            this.f3823e.U();
            if (zzbw >= Math.max(0, x2.f3969i.b(null).intValue())) {
                return false;
            }
            this.f3822d = zzbw;
            this.c.add(zzdbVar);
            this.b.add(Long.valueOf(j2));
            int size = this.c.size();
            this.f3823e.U();
            return size < Math.max(1, x2.f3970j.b(null).intValue());
        }
        return false;
    }
}

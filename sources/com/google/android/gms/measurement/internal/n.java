package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Iterator;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class n {
    final String a;
    final String b;
    final String c;

    /* renamed from: d  reason: collision with root package name */
    final long f3877d;

    /* renamed from: e  reason: collision with root package name */
    final long f3878e;

    /* renamed from: f  reason: collision with root package name */
    final zzaq f3879f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(o4 o4Var, String str, String str2, String str3, long j2, long j3, Bundle bundle) {
        zzaq zzaqVar;
        com.google.android.gms.common.internal.q.f(str2);
        com.google.android.gms.common.internal.q.f(str3);
        this.a = str2;
        this.b = str3;
        this.c = true == TextUtils.isEmpty(str) ? null : str;
        this.f3877d = j2;
        this.f3878e = j3;
        if (j3 != 0 && j3 > j2) {
            o4Var.a().p().b("Event created with reverse previous/current timestamps. appId", k3.v(str2));
        }
        if (bundle != null && !bundle.isEmpty()) {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    o4Var.a().m().a("Param name can't be null");
                    it.remove();
                } else {
                    Object q = o4Var.E().q(next, bundle2.get(next));
                    if (q == null) {
                        o4Var.a().p().b("Param value can't be null", o4Var.F().o(next));
                        it.remove();
                    } else {
                        o4Var.E().x(bundle2, next, q);
                    }
                }
            }
            zzaqVar = new zzaq(bundle2);
        } else {
            zzaqVar = new zzaq(new Bundle());
        }
        this.f3879f = zzaqVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final n a(o4 o4Var, long j2) {
        return new n(o4Var, this.c, this.a, this.b, this.f3877d, j2, this.f3879f);
    }

    public final String toString() {
        String str = this.a;
        String str2 = this.b;
        String valueOf = String.valueOf(this.f3879f);
        int length = String.valueOf(str).length();
        StringBuilder sb = new StringBuilder(length + 33 + String.valueOf(str2).length() + String.valueOf(valueOf).length());
        sb.append("Event{appId='");
        sb.append(str);
        sb.append("', name='");
        sb.append(str2);
        sb.append("', params=");
        sb.append(valueOf);
        sb.append('}');
        return sb.toString();
    }

    private n(o4 o4Var, String str, String str2, String str3, long j2, long j3, zzaq zzaqVar) {
        com.google.android.gms.common.internal.q.f(str2);
        com.google.android.gms.common.internal.q.f(str3);
        com.google.android.gms.common.internal.q.j(zzaqVar);
        this.a = str2;
        this.b = str3;
        this.c = true == TextUtils.isEmpty(str) ? null : str;
        this.f3877d = j2;
        this.f3878e = j3;
        if (j3 != 0 && j3 > j2) {
            o4Var.a().p().c("Event created with reverse previous/current timestamps. appId, name", k3.v(str2), k3.v(str3));
        }
        this.f3879f = zzaqVar;
    }
}

package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes2.dex */
final class i0 implements v {
    final /* synthetic */ d a;
    final /* synthetic */ Intent b;
    final /* synthetic */ Context c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ k0 f4880d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i0(k0 k0Var, d dVar, Intent intent, Context context) {
        this.f4880d = k0Var;
        this.a = dVar;
        this.b = intent;
        this.c = context;
    }

    @Override // com.google.android.play.core.splitinstall.v
    public final void a() {
        r0.f4885g.post(new j0(this.f4880d, this.a, 5, 0));
    }

    @Override // com.google.android.play.core.splitinstall.v
    public final void a(int i2) {
        r0.f4885g.post(new j0(this.f4880d, this.a, 6, i2));
    }

    @Override // com.google.android.play.core.splitinstall.v
    public final void b() {
        com.google.android.play.core.internal.j jVar;
        if (this.b.getBooleanExtra("triggered_from_app_after_verification", false)) {
            jVar = ((d.c.a.d.a.a.c) this.f4880d).a;
            jVar.e("Splits copied and verified more than once.", new Object[0]);
            return;
        }
        this.b.putExtra("triggered_from_app_after_verification", true);
        this.c.sendBroadcast(this.b);
    }
}

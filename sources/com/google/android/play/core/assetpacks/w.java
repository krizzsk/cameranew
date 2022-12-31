package com.google.android.play.core.assetpacks;

import android.os.Bundle;
/* loaded from: classes2.dex */
final class w extends s<Void> {
    final int c;

    /* renamed from: d  reason: collision with root package name */
    final String f4815d;

    /* renamed from: e  reason: collision with root package name */
    final int f4816e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ z f4817f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(z zVar, com.google.android.play.core.tasks.p<Void> pVar, int i2, String str, int i3) {
        super(zVar, pVar);
        this.f4817f = zVar;
        this.c = i2;
        this.f4815d = str;
        this.f4816e = i3;
    }

    @Override // com.google.android.play.core.assetpacks.s, com.google.android.play.core.internal.x1
    public final void a(Bundle bundle) {
        com.google.android.play.core.internal.t tVar;
        com.google.android.play.core.internal.j jVar;
        tVar = this.f4817f.c;
        tVar.b();
        int i2 = bundle.getInt("error_code");
        jVar = z.f4837f;
        jVar.e("onError(%d), retrying notifyModuleCompleted...", Integer.valueOf(i2));
        int i3 = this.f4816e;
        if (i3 > 0) {
            this.f4817f.h(this.c, this.f4815d, i3 - 1);
        }
    }
}

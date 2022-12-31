package com.google.android.play.core.assetpacks;

import android.content.ComponentName;
import android.content.Context;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
/* loaded from: classes2.dex */
public final class r3 implements com.google.android.play.core.internal.n1<b> {
    private final com.google.android.play.core.internal.n1<k3> a;
    private final com.google.android.play.core.internal.n1<Context> b;

    public r3(com.google.android.play.core.internal.n1<k3> n1Var, com.google.android.play.core.internal.n1<Context> n1Var2) {
        this.a = n1Var;
        this.b = n1Var2;
    }

    @Override // com.google.android.play.core.internal.n1
    public final /* bridge */ /* synthetic */ b a() {
        k3 a = this.a.a();
        Context a2 = ((t3) this.b).a();
        k3 k3Var = a;
        com.google.android.play.core.internal.t0.i(a2.getPackageManager(), new ComponentName(a2.getPackageName(), "com.google.android.play.core.assetpacks.AssetPackExtractionService"), 4);
        PlayCoreDialogWrapperActivity.a(a2);
        com.google.android.play.core.internal.t0.p(k3Var);
        return k3Var;
    }
}

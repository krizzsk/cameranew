package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
/* loaded from: classes2.dex */
final class i extends ResultReceiver {
    final /* synthetic */ com.google.android.play.core.tasks.p a;
    final /* synthetic */ k3 b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(k3 k3Var, Handler handler, com.google.android.play.core.tasks.p pVar) {
        super(handler);
        this.b = k3Var;
        this.a = pVar;
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i2, Bundle bundle) {
        u0 u0Var;
        if (i2 == 1) {
            this.a.e(-1);
            u0Var = this.b.f4759g;
            u0Var.b(null);
        } else if (i2 != 2) {
            this.a.d(new AssetPackException(-100));
        } else {
            this.a.e(0);
        }
    }
}

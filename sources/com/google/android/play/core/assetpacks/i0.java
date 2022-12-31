package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import java.util.Arrays;
/* loaded from: classes2.dex */
final class i0 extends com.google.android.play.core.internal.y1 {
    private final com.google.android.play.core.internal.j a = new com.google.android.play.core.internal.j("AssetPackExtractionService");
    private final Context b;
    private final AssetPackExtractionService c;

    /* renamed from: d  reason: collision with root package name */
    private final k0 f4747d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i0(Context context, AssetPackExtractionService assetPackExtractionService, k0 k0Var) {
        this.b = context;
        this.c = assetPackExtractionService;
        this.f4747d = k0Var;
    }

    @Override // com.google.android.play.core.internal.z1
    public final void L(Bundle bundle, com.google.android.play.core.internal.b2 b2Var) throws RemoteException {
        String[] packagesForUid;
        this.a.c("updateServiceState AIDL call", new Object[0]);
        if (com.google.android.play.core.internal.z0.a(this.b) && (packagesForUid = this.b.getPackageManager().getPackagesForUid(Binder.getCallingUid())) != null && Arrays.asList(packagesForUid).contains("com.android.vending")) {
            b2Var.e(this.c.a(bundle), new Bundle());
            return;
        }
        b2Var.a(new Bundle());
        this.c.b();
    }

    @Override // com.google.android.play.core.internal.z1
    public final void T(com.google.android.play.core.internal.b2 b2Var) throws RemoteException {
        this.f4747d.C();
        b2Var.c(new Bundle());
    }
}

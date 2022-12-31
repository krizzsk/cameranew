package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
/* loaded from: classes2.dex */
public final class u0 extends q1 implements w0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public u0(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.splitinstall.protocol.ISplitInstallService");
    }

    @Override // com.google.android.play.core.internal.w0
    public final void y(String str, List<Bundle> list, Bundle bundle, y0 y0Var) throws RemoteException {
        Parcel x0 = x0();
        x0.writeString(str);
        x0.writeTypedList(list);
        s1.c(x0, bundle);
        s1.b(x0, y0Var);
        y0(2, x0);
    }
}

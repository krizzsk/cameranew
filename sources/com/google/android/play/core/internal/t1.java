package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
/* loaded from: classes2.dex */
public final class t1 extends q1 implements v1 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public t1(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.assetpacks.protocol.IAssetModuleService");
    }

    @Override // com.google.android.play.core.internal.v1
    public final void B(String str, Bundle bundle, Bundle bundle2, x1 x1Var) throws RemoteException {
        Parcel x0 = x0();
        x0.writeString(str);
        s1.c(x0, bundle);
        s1.c(x0, bundle2);
        s1.b(x0, x1Var);
        y0(13, x0);
    }

    @Override // com.google.android.play.core.internal.v1
    public final void R(String str, Bundle bundle, x1 x1Var) throws RemoteException {
        Parcel x0 = x0();
        x0.writeString(str);
        s1.c(x0, bundle);
        s1.b(x0, x1Var);
        y0(10, x0);
    }

    @Override // com.google.android.play.core.internal.v1
    public final void V(String str, Bundle bundle, Bundle bundle2, x1 x1Var) throws RemoteException {
        Parcel x0 = x0();
        x0.writeString(str);
        s1.c(x0, bundle);
        s1.c(x0, bundle2);
        s1.b(x0, x1Var);
        y0(6, x0);
    }

    @Override // com.google.android.play.core.internal.v1
    public final void Y(String str, Bundle bundle, x1 x1Var) throws RemoteException {
        Parcel x0 = x0();
        x0.writeString(str);
        s1.c(x0, bundle);
        s1.b(x0, x1Var);
        y0(5, x0);
    }

    @Override // com.google.android.play.core.internal.v1
    public final void a0(String str, Bundle bundle, Bundle bundle2, x1 x1Var) throws RemoteException {
        Parcel x0 = x0();
        x0.writeString(str);
        s1.c(x0, bundle);
        s1.c(x0, bundle2);
        s1.b(x0, x1Var);
        y0(7, x0);
    }

    @Override // com.google.android.play.core.internal.v1
    public final void o0(String str, List<Bundle> list, Bundle bundle, x1 x1Var) throws RemoteException {
        Parcel x0 = x0();
        x0.writeString(str);
        x0.writeTypedList(list);
        s1.c(x0, bundle);
        s1.b(x0, x1Var);
        y0(2, x0);
    }

    @Override // com.google.android.play.core.internal.v1
    public final void q0(String str, List<Bundle> list, Bundle bundle, x1 x1Var) throws RemoteException {
        Parcel x0 = x0();
        x0.writeString(str);
        x0.writeTypedList(list);
        s1.c(x0, bundle);
        s1.b(x0, x1Var);
        y0(14, x0);
    }

    @Override // com.google.android.play.core.internal.v1
    public final void u0(String str, List<Bundle> list, Bundle bundle, x1 x1Var) throws RemoteException {
        Parcel x0 = x0();
        x0.writeString(str);
        x0.writeTypedList(list);
        s1.c(x0, bundle);
        s1.b(x0, x1Var);
        y0(12, x0);
    }

    @Override // com.google.android.play.core.internal.v1
    public final void w(String str, Bundle bundle, Bundle bundle2, x1 x1Var) throws RemoteException {
        Parcel x0 = x0();
        x0.writeString(str);
        s1.c(x0, bundle);
        s1.c(x0, bundle2);
        s1.b(x0, x1Var);
        y0(9, x0);
    }

    @Override // com.google.android.play.core.internal.v1
    public final void z(String str, Bundle bundle, Bundle bundle2, x1 x1Var) throws RemoteException {
        Parcel x0 = x0();
        x0.writeString(str);
        s1.c(x0, bundle);
        s1.c(x0, bundle2);
        s1.b(x0, x1Var);
        y0(11, x0);
    }
}

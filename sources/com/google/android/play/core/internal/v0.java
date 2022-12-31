package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes2.dex */
public abstract class v0 extends r1 implements w0 {
    public static w0 y0(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.splitinstall.protocol.ISplitInstallService");
        return queryLocalInterface instanceof w0 ? (w0) queryLocalInterface : new u0(iBinder);
    }
}

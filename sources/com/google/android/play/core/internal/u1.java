package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes2.dex */
public abstract class u1 extends r1 implements v1 {
    public static v1 y0(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.assetpacks.protocol.IAssetModuleService");
        return queryLocalInterface instanceof v1 ? (v1) queryLocalInterface : new t1(iBinder);
    }
}

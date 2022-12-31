package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.maps.g.r;
import com.google.android.gms.maps.g.s;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public final class c {
    @GuardedBy("MapsInitializer.class")
    private static boolean a = false;

    public static synchronized int a(Context context) {
        synchronized (c.class) {
            q.k(context, "Context is null");
            if (a) {
                return 0;
            }
            try {
                s a2 = r.a(context);
                try {
                    a.a(a2.zze());
                    com.google.android.gms.maps.model.b.a(a2.zzf());
                    a = true;
                    return 0;
                } catch (RemoteException e2) {
                    throw new RuntimeRemoteException(e2);
                }
            } catch (GooglePlayServicesNotAvailableException e3) {
                return e3.errorCode;
            }
        }
    }
}

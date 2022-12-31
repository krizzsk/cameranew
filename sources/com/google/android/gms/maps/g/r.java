package com.google.android.gms.maps.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.maps.model.RuntimeRemoteException;
/* loaded from: classes2.dex */
public class r {
    private static final String a = "r";
    @Nullable
    @SuppressLint({"StaticFieldLeak"})
    private static Context b;
    private static s c;

    public static s a(Context context) throws GooglePlayServicesNotAvailableException {
        s tVar;
        com.google.android.gms.common.internal.q.j(context);
        s sVar = c;
        if (sVar != null) {
            return sVar;
        }
        int g2 = com.google.android.gms.common.b.g(context, 13400000);
        if (g2 == 0) {
            Log.i(a, "Making Creator dynamically");
            IBinder iBinder = (IBinder) c(d(context).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl");
            if (iBinder == null) {
                tVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
                if (queryLocalInterface instanceof s) {
                    tVar = (s) queryLocalInterface;
                } else {
                    tVar = new t(iBinder);
                }
            }
            c = tVar;
            try {
                tVar.zza(com.google.android.gms.dynamic.d.z0(d(context).getResources()), com.google.android.gms.common.b.f3641f);
                return c;
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }
        throw new GooglePlayServicesNotAvailableException(g2);
    }

    private static <T> T b(Class<?> cls) {
        try {
            return (T) cls.newInstance();
        } catch (IllegalAccessException unused) {
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalStateException(valueOf.length() != 0 ? "Unable to call the default constructor of ".concat(valueOf) : new String("Unable to call the default constructor of "));
        } catch (InstantiationException unused2) {
            String valueOf2 = String.valueOf(cls.getName());
            throw new IllegalStateException(valueOf2.length() != 0 ? "Unable to instantiate the dynamic class ".concat(valueOf2) : new String("Unable to instantiate the dynamic class "));
        }
    }

    private static <T> T c(ClassLoader classLoader, String str) {
        try {
            com.google.android.gms.common.internal.q.j(classLoader);
            return (T) b(classLoader.loadClass(str));
        } catch (ClassNotFoundException unused) {
            String valueOf = String.valueOf(str);
            throw new IllegalStateException(valueOf.length() != 0 ? "Unable to find dynamic class ".concat(valueOf) : new String("Unable to find dynamic class "));
        }
    }

    @Nullable
    private static Context d(Context context) {
        Context context2 = b;
        if (context2 != null) {
            return context2;
        }
        Context e2 = e(context);
        b = e2;
        return e2;
    }

    @Nullable
    private static Context e(Context context) {
        try {
            return DynamiteModule.e(context, DynamiteModule.f3707i, "com.google.android.gms.maps_dynamite").b();
        } catch (Exception e2) {
            Log.e(a, "Failed to load maps module, use legacy", e2);
            return com.google.android.gms.common.b.d(context);
        }
    }
}

package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzws<T> {
    @Nullable
    private static final zzxy zzcju = zzqw();

    private static zzxy zzqw() {
        try {
            Object newInstance = zzwc.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (!(newInstance instanceof IBinder)) {
                zzazk.zzex("ClientApi class is not an instance of IBinder.");
                return null;
            }
            IBinder iBinder = (IBinder) newInstance;
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
            if (queryLocalInterface instanceof zzxy) {
                return (zzxy) queryLocalInterface;
            }
            return new zzya(iBinder);
        } catch (Exception unused) {
            zzazk.zzex("Failed to instantiate ClientApi class.");
            return null;
        }
    }

    @Nullable
    private final T zzqx() {
        zzxy zzxyVar = zzcju;
        if (zzxyVar == null) {
            zzazk.zzex("ClientApi class cannot be loaded.");
            return null;
        }
        try {
            return zza(zzxyVar);
        } catch (RemoteException e2) {
            zzazk.zzd("Cannot invoke local loader using ClientApi class.", e2);
            return null;
        }
    }

    @Nullable
    private final T zzqy() {
        try {
            return zzqk();
        } catch (RemoteException e2) {
            zzazk.zzd("Cannot invoke remote loader.", e2);
            return null;
        }
    }

    @Nullable
    protected abstract T zza(zzxy zzxyVar) throws RemoteException;

    /* JADX WARN: Removed duplicated region for block: B:21:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final T zzd(android.content.Context r10, boolean r11) {
        /*
            r9 = this;
            r0 = 0
            r1 = 1
            if (r11 != 0) goto L6
            r11 = 0
            goto L7
        L6:
            r11 = 1
        L7:
            if (r11 != 0) goto L1b
            com.google.android.gms.internal.ads.zzwr.zzqn()
            r2 = 12451000(0xbdfcb8, float:1.7447567E-38)
            boolean r2 = com.google.android.gms.internal.ads.zzaza.zzf(r10, r2)
            if (r2 != 0) goto L1b
            java.lang.String r11 = "Google Play Services is not available."
            com.google.android.gms.internal.ads.zzazk.zzdy(r11)
            r11 = 1
        L1b:
            java.lang.String r2 = "com.google.android.gms.ads.dynamite"
            int r3 = com.google.android.gms.dynamite.DynamiteModule.a(r10, r2)
            int r2 = com.google.android.gms.dynamite.DynamiteModule.c(r10, r2)
            if (r3 <= r2) goto L28
            r11 = 1
        L28:
            com.google.android.gms.internal.ads.zzabp.initialize(r10)
            com.google.android.gms.internal.ads.zzacx<java.lang.Boolean> r2 = com.google.android.gms.internal.ads.zzade.zzddd
            java.lang.Object r2 = r2.get()
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L3b
            r11 = 0
            goto L4c
        L3b:
            com.google.android.gms.internal.ads.zzacx<java.lang.Boolean> r2 = com.google.android.gms.internal.ads.zzade.zzdde
            java.lang.Object r2 = r2.get()
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L4c
            r11 = 1
            r2 = 1
            goto L4d
        L4c:
            r2 = 0
        L4d:
            if (r11 == 0) goto L5c
            java.lang.Object r10 = r9.zzqx()
            if (r10 != 0) goto Laa
            if (r2 != 0) goto Laa
            java.lang.Object r10 = r9.zzqy()
            goto Laa
        L5c:
            java.lang.Object r11 = r9.zzqy()
            if (r11 != 0) goto L64
            r2 = 1
            goto L65
        L64:
            r2 = 0
        L65:
            if (r2 == 0) goto La2
            com.google.android.gms.internal.ads.zzacx<java.lang.Long> r3 = com.google.android.gms.internal.ads.zzadr.zzdeq
            java.lang.Object r3 = r3.get()
            java.lang.Long r3 = (java.lang.Long) r3
            int r3 = r3.intValue()
            java.util.Random r4 = com.google.android.gms.internal.ads.zzwr.zzqu()
            int r3 = r4.nextInt(r3)
            if (r3 != 0) goto L7e
            r0 = 1
        L7e:
            if (r0 == 0) goto La2
            android.os.Bundle r7 = new android.os.Bundle
            r7.<init>()
            java.lang.String r0 = "action"
            java.lang.String r1 = "dynamite_load"
            r7.putString(r0, r1)
            java.lang.String r0 = "is_missing"
            r7.putInt(r0, r2)
            com.google.android.gms.internal.ads.zzaza r3 = com.google.android.gms.internal.ads.zzwr.zzqn()
            com.google.android.gms.internal.ads.zzazn r0 = com.google.android.gms.internal.ads.zzwr.zzqt()
            java.lang.String r5 = r0.zzbrp
            r8 = 1
            java.lang.String r6 = "gmob-apps"
            r4 = r10
            r3.zza(r4, r5, r6, r7, r8)
        La2:
            if (r11 != 0) goto La9
            java.lang.Object r10 = r9.zzqx()
            goto Laa
        La9:
            r10 = r11
        Laa:
            if (r10 != 0) goto Lb0
            java.lang.Object r10 = r9.zzqj()
        Lb0:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzws.zzd(android.content.Context, boolean):java.lang.Object");
    }

    @NonNull
    protected abstract T zzqj();

    @Nullable
    protected abstract T zzqk() throws RemoteException;
}

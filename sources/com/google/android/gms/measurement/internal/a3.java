package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public interface a3 extends IInterface {
    void C(zzas zzasVar, zzp zzpVar) throws RemoteException;

    List<zzkg> E(String str, @Nullable String str2, @Nullable String str3, boolean z) throws RemoteException;

    void H(zzp zzpVar) throws RemoteException;

    void S(long j2, @Nullable String str, @Nullable String str2, String str3) throws RemoteException;

    @Nullable
    List<zzkg> U(zzp zzpVar, boolean z) throws RemoteException;

    void W(zzp zzpVar) throws RemoteException;

    void c0(Bundle bundle, zzp zzpVar) throws RemoteException;

    void d0(zzas zzasVar, String str, @Nullable String str2) throws RemoteException;

    @Nullable
    byte[] e0(zzas zzasVar, String str) throws RemoteException;

    List<zzaa> k(@Nullable String str, @Nullable String str2, zzp zzpVar) throws RemoteException;

    void k0(zzp zzpVar) throws RemoteException;

    String m(zzp zzpVar) throws RemoteException;

    void n(zzaa zzaaVar, zzp zzpVar) throws RemoteException;

    List<zzkg> o(@Nullable String str, @Nullable String str2, boolean z, zzp zzpVar) throws RemoteException;

    List<zzaa> p(String str, @Nullable String str2, @Nullable String str3) throws RemoteException;

    void s(zzaa zzaaVar) throws RemoteException;

    void t0(zzp zzpVar) throws RemoteException;

    void x(zzkg zzkgVar, zzp zzpVar) throws RemoteException;
}

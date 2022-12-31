package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.m0;
import com.google.android.gms.common.internal.o0;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public abstract class h extends o0 {
    private int a;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(byte[] bArr) {
        com.google.android.gms.common.internal.q.a(bArr.length == 25);
        this.a = Arrays.hashCode(bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static byte[] z0(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    public boolean equals(@Nullable Object obj) {
        com.google.android.gms.dynamic.b zzb;
        if (obj != null && (obj instanceof m0)) {
            try {
                m0 m0Var = (m0) obj;
                if (m0Var.zzc() == hashCode() && (zzb = m0Var.zzb()) != null) {
                    return Arrays.equals(y0(), (byte[]) com.google.android.gms.dynamic.d.y0(zzb));
                }
                return false;
            } catch (RemoteException e2) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
            }
        }
        return false;
    }

    public int hashCode() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte[] y0();

    @Override // com.google.android.gms.common.internal.m0
    public final com.google.android.gms.dynamic.b zzb() {
        return com.google.android.gms.dynamic.d.z0(y0());
    }

    @Override // com.google.android.gms.common.internal.m0
    public final int zzc() {
        return hashCode();
    }
}

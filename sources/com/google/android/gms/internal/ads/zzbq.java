package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.IOException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public class zzbq extends zzepl implements Closeable {
    private static zzept zzdc = zzept.zzn(zzbq.class);

    public zzbq(zzepn zzepnVar, zzbn zzbnVar) throws IOException {
        zza(zzepnVar, zzepnVar.size(), zzbnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzepl, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.zzjbd.close();
    }

    @Override // com.google.android.gms.internal.ads.zzepl
    public String toString() {
        String obj = this.zzjbd.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 7);
        sb.append("model(");
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }
}

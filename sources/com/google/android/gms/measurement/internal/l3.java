package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class l3 {
    @NonNull
    public final String a;
    @NonNull
    public final String b;
    public final long c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final Bundle f3857d;

    public l3(@NonNull String str, @NonNull String str2, @Nullable Bundle bundle, long j2) {
        this.a = str;
        this.b = str2;
        this.f3857d = bundle;
        this.c = j2;
    }

    public static l3 a(zzas zzasVar) {
        return new l3(zzasVar.zza, zzasVar.zzc, zzasVar.zzb.R(), zzasVar.zzd);
    }

    public final zzas b() {
        return new zzas(this.a, new zzaq(new Bundle(this.f3857d)), this.b, this.c);
    }

    public final String toString() {
        String str = this.b;
        String str2 = this.a;
        String valueOf = String.valueOf(this.f3857d);
        int length = String.valueOf(str).length();
        StringBuilder sb = new StringBuilder(length + 21 + String.valueOf(str2).length() + String.valueOf(valueOf).length());
        sb.append("origin=");
        sb.append(str);
        sb.append(",name=");
        sb.append(str2);
        sb.append(",params=");
        sb.append(valueOf);
        return sb.toString();
    }
}

package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.measurement.zzy;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class r5 {
    final Context a;
    @Nullable
    String b;
    @Nullable
    String c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    String f3920d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    Boolean f3921e;

    /* renamed from: f  reason: collision with root package name */
    long f3922f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    zzy f3923g;

    /* renamed from: h  reason: collision with root package name */
    boolean f3924h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    final Long f3925i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    String f3926j;

    public r5(Context context, @Nullable zzy zzyVar, @Nullable Long l2) {
        this.f3924h = true;
        com.google.android.gms.common.internal.q.j(context);
        Context applicationContext = context.getApplicationContext();
        com.google.android.gms.common.internal.q.j(applicationContext);
        this.a = applicationContext;
        this.f3925i = l2;
        if (zzyVar != null) {
            this.f3923g = zzyVar;
            this.b = zzyVar.zzf;
            this.c = zzyVar.zze;
            this.f3920d = zzyVar.zzd;
            this.f3924h = zzyVar.zzc;
            this.f3922f = zzyVar.zzb;
            this.f3926j = zzyVar.zzh;
            Bundle bundle = zzyVar.zzg;
            if (bundle != null) {
                this.f3921e = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}

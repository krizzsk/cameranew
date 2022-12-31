package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzak extends zzbg {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Context zzc;
    final /* synthetic */ Bundle zzd;
    final /* synthetic */ zzbr zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzak(zzbr zzbrVar, String str, String str2, Context context, Bundle bundle) {
        super(zzbrVar, true);
        this.zze = zzbrVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = context;
        this.zzd = bundle;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004a A[Catch: Exception -> 0x009c, TryCatch #0 {Exception -> 0x009c, blocks: (B:3:0x0004, B:5:0x0011, B:7:0x0022, B:13:0x0037, B:15:0x004a, B:17:0x0056, B:19:0x0064, B:30:0x0078), top: B:35:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0056 A[Catch: Exception -> 0x009c, TryCatch #0 {Exception -> 0x009c, blocks: (B:3:0x0004, B:5:0x0011, B:7:0x0022, B:13:0x0037, B:15:0x004a, B:17:0x0056, B:19:0x0064, B:30:0x0078), top: B:35:0x0004 }] */
    @Override // com.google.android.gms.internal.measurement.zzbg
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza() {
        /*
            r14 = this;
            java.lang.String r0 = "com.google.android.gms.measurement.dynamite"
            r1 = 0
            r2 = 1
            com.google.android.gms.internal.measurement.zzbr r3 = r14.zze     // Catch: java.lang.Exception -> L9c
            java.lang.String r4 = r14.zza     // Catch: java.lang.Exception -> L9c
            java.lang.String r5 = r14.zzb     // Catch: java.lang.Exception -> L9c
            boolean r3 = com.google.android.gms.internal.measurement.zzbr.zzM(r3, r4, r5)     // Catch: java.lang.Exception -> L9c
            r4 = 0
            if (r3 == 0) goto L1f
            java.lang.String r4 = r14.zzb     // Catch: java.lang.Exception -> L9c
            java.lang.String r3 = r14.zza     // Catch: java.lang.Exception -> L9c
            com.google.android.gms.internal.measurement.zzbr r5 = r14.zze     // Catch: java.lang.Exception -> L9c
            java.lang.String r5 = com.google.android.gms.internal.measurement.zzbr.zzN(r5)     // Catch: java.lang.Exception -> L9c
            r10 = r3
            r11 = r4
            r9 = r5
            goto L22
        L1f:
            r9 = r4
            r10 = r9
            r11 = r10
        L22:
            android.content.Context r3 = r14.zzc     // Catch: java.lang.Exception -> L9c
            com.google.android.gms.internal.measurement.zzbr.zzO(r3)     // Catch: java.lang.Exception -> L9c
            java.lang.Boolean r3 = com.google.android.gms.internal.measurement.zzbr.zzP()     // Catch: java.lang.Exception -> L9c
            boolean r3 = r3.booleanValue()     // Catch: java.lang.Exception -> L9c
            if (r3 != 0) goto L36
            if (r10 == 0) goto L34
            goto L36
        L34:
            r3 = 0
            goto L37
        L36:
            r3 = 1
        L37:
            com.google.android.gms.internal.measurement.zzbr r4 = r14.zze     // Catch: java.lang.Exception -> L9c
            android.content.Context r5 = r14.zzc     // Catch: java.lang.Exception -> L9c
            com.google.android.gms.internal.measurement.zzp r5 = r4.zzc(r5, r3)     // Catch: java.lang.Exception -> L9c
            com.google.android.gms.internal.measurement.zzbr.zzQ(r4, r5)     // Catch: java.lang.Exception -> L9c
            com.google.android.gms.internal.measurement.zzbr r4 = r14.zze     // Catch: java.lang.Exception -> L9c
            com.google.android.gms.internal.measurement.zzp r4 = com.google.android.gms.internal.measurement.zzbr.zzR(r4)     // Catch: java.lang.Exception -> L9c
            if (r4 != 0) goto L56
            com.google.android.gms.internal.measurement.zzbr r0 = r14.zze     // Catch: java.lang.Exception -> L9c
            java.lang.String r0 = com.google.android.gms.internal.measurement.zzbr.zzN(r0)     // Catch: java.lang.Exception -> L9c
            java.lang.String r3 = "Failed to connect to measurement client."
            android.util.Log.w(r0, r3)     // Catch: java.lang.Exception -> L9c
            return
        L56:
            android.content.Context r4 = r14.zzc     // Catch: java.lang.Exception -> L9c
            int r4 = com.google.android.gms.dynamite.DynamiteModule.a(r4, r0)     // Catch: java.lang.Exception -> L9c
            android.content.Context r5 = r14.zzc     // Catch: java.lang.Exception -> L9c
            int r0 = com.google.android.gms.dynamite.DynamiteModule.c(r5, r0)     // Catch: java.lang.Exception -> L9c
            if (r3 == 0) goto L6f
            int r3 = java.lang.Math.max(r4, r0)     // Catch: java.lang.Exception -> L9c
            if (r0 >= r4) goto L6c
            r0 = 1
            goto L6d
        L6c:
            r0 = 0
        L6d:
            r8 = r0
            goto L78
        L6f:
            if (r4 <= 0) goto L72
            r0 = r4
        L72:
            r3 = r0
            if (r4 <= 0) goto L77
            r8 = 1
            goto L78
        L77:
            r8 = 0
        L78:
            com.google.android.gms.internal.measurement.zzy r0 = new com.google.android.gms.internal.measurement.zzy     // Catch: java.lang.Exception -> L9c
            long r6 = (long) r3     // Catch: java.lang.Exception -> L9c
            r4 = 39000(0x9858, double:1.92686E-319)
            android.os.Bundle r12 = r14.zzd     // Catch: java.lang.Exception -> L9c
            android.content.Context r3 = r14.zzc     // Catch: java.lang.Exception -> L9c
            java.lang.String r13 = com.google.android.gms.measurement.internal.h4.a(r3)     // Catch: java.lang.Exception -> L9c
            r3 = r0
            r3.<init>(r4, r6, r8, r9, r10, r11, r12, r13)     // Catch: java.lang.Exception -> L9c
            com.google.android.gms.internal.measurement.zzbr r3 = r14.zze     // Catch: java.lang.Exception -> L9c
            com.google.android.gms.internal.measurement.zzp r3 = com.google.android.gms.internal.measurement.zzbr.zzR(r3)     // Catch: java.lang.Exception -> L9c
            android.content.Context r4 = r14.zzc     // Catch: java.lang.Exception -> L9c
            com.google.android.gms.dynamic.b r4 = com.google.android.gms.dynamic.d.z0(r4)     // Catch: java.lang.Exception -> L9c
            long r5 = r14.zzh     // Catch: java.lang.Exception -> L9c
            r3.initialize(r4, r0, r5)     // Catch: java.lang.Exception -> L9c
            return
        L9c:
            r0 = move-exception
            com.google.android.gms.internal.measurement.zzbr r3 = r14.zze
            com.google.android.gms.internal.measurement.zzbr.zzL(r3, r0, r2, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzak.zza():void");
    }
}

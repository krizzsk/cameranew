package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzew {
    static volatile zzfm<Boolean> zza = zzfm.zzc();
    private static final Object zzb = new Object();

    /* JADX WARN: Can't wrap try/catch for region: R(11:18|(6:33|(2:35|(1:37))|27|28|29|30)(1:20)|21|22|23|24|(1:26)|27|28|29|30) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean zza(android.content.Context r3, android.net.Uri r4) {
        /*
            java.lang.String r4 = r4.getAuthority()
            java.lang.String r0 = "com.google.android.gms.phenotype"
            boolean r0 = r0.equals(r4)
            r1 = 0
            if (r0 != 0) goto L2e
            java.lang.String r3 = java.lang.String.valueOf(r4)
            int r3 = r3.length()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            int r3 = r3 + 91
            r0.<init>(r3)
            r0.append(r4)
            java.lang.String r3 = " is an unsupported authority. Only com.google.android.gms.phenotype authority is supported."
            r0.append(r3)
            java.lang.String r3 = "PhenotypeClientHelper"
            java.lang.String r4 = r0.toString()
            android.util.Log.e(r3, r4)
            return r1
        L2e:
            com.google.android.gms.internal.measurement.zzfm<java.lang.Boolean> r4 = com.google.android.gms.internal.measurement.zzew.zza
            boolean r4 = r4.zza()
            if (r4 == 0) goto L43
            com.google.android.gms.internal.measurement.zzfm<java.lang.Boolean> r3 = com.google.android.gms.internal.measurement.zzew.zza
            java.lang.Object r3 = r3.zzb()
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            return r3
        L43:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzew.zzb
            monitor-enter(r4)
            com.google.android.gms.internal.measurement.zzfm<java.lang.Boolean> r0 = com.google.android.gms.internal.measurement.zzew.zza     // Catch: java.lang.Throwable -> La9
            boolean r0 = r0.zza()     // Catch: java.lang.Throwable -> La9
            if (r0 == 0) goto L5c
            com.google.android.gms.internal.measurement.zzfm<java.lang.Boolean> r3 = com.google.android.gms.internal.measurement.zzew.zza     // Catch: java.lang.Throwable -> La9
            java.lang.Object r3 = r3.zzb()     // Catch: java.lang.Throwable -> La9
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch: java.lang.Throwable -> La9
            boolean r3 = r3.booleanValue()     // Catch: java.lang.Throwable -> La9
            monitor-exit(r4)     // Catch: java.lang.Throwable -> La9
            return r3
        L5c:
            java.lang.String r0 = "com.google.android.gms"
            java.lang.String r2 = r3.getPackageName()     // Catch: java.lang.Throwable -> La9
            boolean r0 = r0.equals(r2)     // Catch: java.lang.Throwable -> La9
            if (r0 == 0) goto L69
            goto L80
        L69:
            android.content.pm.PackageManager r0 = r3.getPackageManager()     // Catch: java.lang.Throwable -> La9
            java.lang.String r2 = "com.google.android.gms.phenotype"
            android.content.pm.ProviderInfo r0 = r0.resolveContentProvider(r2, r1)     // Catch: java.lang.Throwable -> La9
            if (r0 == 0) goto L91
            java.lang.String r2 = "com.google.android.gms"
            java.lang.String r0 = r0.packageName     // Catch: java.lang.Throwable -> La9
            boolean r0 = r2.equals(r0)     // Catch: java.lang.Throwable -> La9
            if (r0 != 0) goto L80
            goto L91
        L80:
            android.content.pm.PackageManager r3 = r3.getPackageManager()     // Catch: java.lang.Throwable -> La9
            java.lang.String r0 = "com.google.android.gms"
            android.content.pm.ApplicationInfo r3 = r3.getApplicationInfo(r0, r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L91 java.lang.Throwable -> La9
            int r3 = r3.flags     // Catch: java.lang.Throwable -> La9
            r3 = r3 & 129(0x81, float:1.81E-43)
            if (r3 == 0) goto L91
            r1 = 1
        L91:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r1)     // Catch: java.lang.Throwable -> La9
            com.google.android.gms.internal.measurement.zzfm r3 = com.google.android.gms.internal.measurement.zzfm.zzd(r3)     // Catch: java.lang.Throwable -> La9
            com.google.android.gms.internal.measurement.zzew.zza = r3     // Catch: java.lang.Throwable -> La9
            monitor-exit(r4)     // Catch: java.lang.Throwable -> La9
            com.google.android.gms.internal.measurement.zzfm<java.lang.Boolean> r3 = com.google.android.gms.internal.measurement.zzew.zza
            java.lang.Object r3 = r3.zzb()
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            return r3
        La9:
            r3 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> La9
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzew.zza(android.content.Context, android.net.Uri):boolean");
    }
}

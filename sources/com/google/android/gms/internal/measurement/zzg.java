package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.app.job.JobScheduler;
import androidx.annotation.Nullable;
import java.lang.reflect.Method;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
@TargetApi(24)
/* loaded from: classes2.dex */
public final class zzg {
    @Nullable
    private static final Method zzb;
    @Nullable
    private static final Method zzc;
    private final JobScheduler zza;

    /* JADX WARN: Removed duplicated region for block: B:22:0x003b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        /*
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 6
            r3 = 0
            r4 = 24
            java.lang.String r5 = "JobSchedulerCompat"
            r6 = 0
            if (r1 < r4) goto L34
            r1 = 4
            java.lang.Class[] r1 = new java.lang.Class[r1]     // Catch: java.lang.NoSuchMethodException -> L28
            java.lang.Class<android.app.job.JobInfo> r7 = android.app.job.JobInfo.class
            r1[r3] = r7     // Catch: java.lang.NoSuchMethodException -> L28
            r7 = 1
            r1[r7] = r0     // Catch: java.lang.NoSuchMethodException -> L28
            r7 = 2
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch: java.lang.NoSuchMethodException -> L28
            r1[r7] = r8     // Catch: java.lang.NoSuchMethodException -> L28
            r7 = 3
            r1[r7] = r0     // Catch: java.lang.NoSuchMethodException -> L28
            java.lang.Class<android.app.job.JobScheduler> r0 = android.app.job.JobScheduler.class
            java.lang.String r7 = "scheduleAsPackage"
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r7, r1)     // Catch: java.lang.NoSuchMethodException -> L28
            goto L35
        L28:
            boolean r0 = android.util.Log.isLoggable(r5, r2)
            if (r0 == 0) goto L34
            java.lang.String r0 = "No scheduleAsPackage method available, falling back to schedule"
            android.util.Log.e(r5, r0)
        L34:
            r0 = r6
        L35:
            com.google.android.gms.internal.measurement.zzg.zzb = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r4) goto L52
            java.lang.Class<android.os.UserHandle> r0 = android.os.UserHandle.class
            java.lang.String r1 = "myUserId"
            java.lang.Class[] r3 = new java.lang.Class[r3]     // Catch: java.lang.NoSuchMethodException -> L46
            java.lang.reflect.Method r6 = r0.getDeclaredMethod(r1, r3)     // Catch: java.lang.NoSuchMethodException -> L46
            goto L52
        L46:
            boolean r0 = android.util.Log.isLoggable(r5, r2)
            if (r0 == 0) goto L52
            java.lang.String r0 = "No myUserId method available"
            android.util.Log.e(r5, r0)
        L52:
            com.google.android.gms.internal.measurement.zzg.zzc = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzg.<clinit>():void");
    }

    public zzg(JobScheduler jobScheduler) {
        this.zza = jobScheduler;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x004d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int zza(android.content.Context r6, android.app.job.JobInfo r7, java.lang.String r8, java.lang.String r9) {
        /*
            java.lang.String r8 = "jobscheduler"
            java.lang.Object r8 = r6.getSystemService(r8)
            android.app.job.JobScheduler r8 = (android.app.job.JobScheduler) r8
            java.util.Objects.requireNonNull(r8)
            java.lang.reflect.Method r9 = com.google.android.gms.internal.measurement.zzg.zzb
            if (r9 == 0) goto L7d
            java.lang.String r9 = "android.permission.UPDATE_DEVICE_STATS"
            int r6 = r6.checkSelfPermission(r9)
            if (r6 == 0) goto L18
            goto L7d
        L18:
            com.google.android.gms.internal.measurement.zzg r6 = new com.google.android.gms.internal.measurement.zzg
            r6.<init>(r8)
            java.lang.reflect.Method r8 = com.google.android.gms.internal.measurement.zzg.zzc
            r9 = 0
            if (r8 == 0) goto L44
            java.lang.Class<android.os.UserHandle> r0 = android.os.UserHandle.class
            java.lang.Object[] r1 = new java.lang.Object[r9]     // Catch: java.lang.reflect.InvocationTargetException -> L33 java.lang.IllegalAccessException -> L35
            java.lang.Object r8 = r8.invoke(r0, r1)     // Catch: java.lang.reflect.InvocationTargetException -> L33 java.lang.IllegalAccessException -> L35
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch: java.lang.reflect.InvocationTargetException -> L33 java.lang.IllegalAccessException -> L35
            if (r8 == 0) goto L44
            int r8 = r8.intValue()     // Catch: java.lang.reflect.InvocationTargetException -> L33 java.lang.IllegalAccessException -> L35
            goto L45
        L33:
            r8 = move-exception
            goto L36
        L35:
            r8 = move-exception
        L36:
            r0 = 6
            java.lang.String r1 = "JobSchedulerCompat"
            boolean r0 = android.util.Log.isLoggable(r1, r0)
            if (r0 == 0) goto L44
            java.lang.String r0 = "myUserId invocation illegal"
            android.util.Log.e(r1, r0, r8)
        L44:
            r8 = 0
        L45:
            java.lang.String r0 = "com.google.android.gms"
            java.lang.String r1 = "UploadAlarm"
            java.lang.reflect.Method r2 = com.google.android.gms.internal.measurement.zzg.zzb
            if (r2 == 0) goto L76
            android.app.job.JobScheduler r3 = r6.zza     // Catch: java.lang.reflect.InvocationTargetException -> L6e java.lang.IllegalAccessException -> L70
            r4 = 4
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.reflect.InvocationTargetException -> L6e java.lang.IllegalAccessException -> L70
            r4[r9] = r7     // Catch: java.lang.reflect.InvocationTargetException -> L6e java.lang.IllegalAccessException -> L70
            r5 = 1
            r4[r5] = r0     // Catch: java.lang.reflect.InvocationTargetException -> L6e java.lang.IllegalAccessException -> L70
            r0 = 2
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.reflect.InvocationTargetException -> L6e java.lang.IllegalAccessException -> L70
            r4[r0] = r8     // Catch: java.lang.reflect.InvocationTargetException -> L6e java.lang.IllegalAccessException -> L70
            r8 = 3
            r4[r8] = r1     // Catch: java.lang.reflect.InvocationTargetException -> L6e java.lang.IllegalAccessException -> L70
            java.lang.Object r8 = r2.invoke(r3, r4)     // Catch: java.lang.reflect.InvocationTargetException -> L6e java.lang.IllegalAccessException -> L70
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch: java.lang.reflect.InvocationTargetException -> L6e java.lang.IllegalAccessException -> L70
            if (r8 == 0) goto L7c
            int r9 = r8.intValue()     // Catch: java.lang.reflect.InvocationTargetException -> L6e java.lang.IllegalAccessException -> L70
            goto L7c
        L6e:
            r8 = move-exception
            goto L71
        L70:
            r8 = move-exception
        L71:
            java.lang.String r9 = "error calling scheduleAsPackage"
            android.util.Log.e(r1, r9, r8)
        L76:
            android.app.job.JobScheduler r6 = r6.zza
            int r9 = r6.schedule(r7)
        L7c:
            return r9
        L7d:
            int r6 = r8.schedule(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzg.zza(android.content.Context, android.app.job.JobInfo, java.lang.String, java.lang.String):int");
    }
}

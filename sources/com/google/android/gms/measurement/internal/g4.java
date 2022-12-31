package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzcm;
import com.google.android.gms.internal.measurement.zzco;
import com.google.android.gms.internal.measurement.zzcp;
import com.google.android.gms.internal.measurement.zzcr;
import com.google.android.gms.internal.measurement.zzic;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public final class g4 extends z8 implements d {

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, Map<String, String>> f3790d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, Map<String, Boolean>> f3791e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, Map<String, Boolean>> f3792f;

    /* renamed from: g  reason: collision with root package name */
    private final Map<String, zzcp> f3793g;

    /* renamed from: h  reason: collision with root package name */
    private final Map<String, Map<String, Integer>> f3794h;

    /* renamed from: i  reason: collision with root package name */
    private final Map<String, String> f3795i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g4(i9 i9Var) {
        super(i9Var);
        this.f3790d = new ArrayMap();
        this.f3791e = new ArrayMap();
        this.f3792f = new ArrayMap();
        this.f3793g = new ArrayMap();
        this.f3795i = new ArrayMap();
        this.f3794h = new ArrayMap();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0082, code lost:
        if (r2 == null) goto L12;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00da  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void v(java.lang.String r12) {
        /*
            r11 = this;
            r11.h()
            r11.f()
            com.google.android.gms.common.internal.q.f(r12)
            java.util.Map<java.lang.String, com.google.android.gms.internal.measurement.zzcp> r0 = r11.f3793g
            java.lang.Object r0 = r0.get(r12)
            if (r0 != 0) goto Lde
            com.google.android.gms.measurement.internal.i9 r0 = r11.b
            com.google.android.gms.measurement.internal.i r0 = r0.X()
            com.google.android.gms.common.internal.q.f(r12)
            r0.f()
            r0.h()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r0.L()     // Catch: java.lang.Throwable -> L6a android.database.sqlite.SQLiteException -> L6c
            java.lang.String r3 = "remote_config"
            java.lang.String[] r4 = new java.lang.String[]{r3}     // Catch: java.lang.Throwable -> L6a android.database.sqlite.SQLiteException -> L6c
            r3 = 1
            java.lang.String[] r6 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L6a android.database.sqlite.SQLiteException -> L6c
            r10 = 0
            r6[r10] = r12     // Catch: java.lang.Throwable -> L6a android.database.sqlite.SQLiteException -> L6c
            java.lang.String r3 = "apps"
            java.lang.String r5 = "app_id=?"
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L6a android.database.sqlite.SQLiteException -> L6c
            boolean r3 = r2.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L68 java.lang.Throwable -> Ld6
            if (r3 != 0) goto L45
            if (r2 == 0) goto L87
            goto L84
        L45:
            byte[] r3 = r2.getBlob(r10)     // Catch: android.database.sqlite.SQLiteException -> L68 java.lang.Throwable -> Ld6
            boolean r4 = r2.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L68 java.lang.Throwable -> Ld6
            if (r4 == 0) goto L62
            com.google.android.gms.measurement.internal.o4 r4 = r0.a     // Catch: android.database.sqlite.SQLiteException -> L68 java.lang.Throwable -> Ld6
            com.google.android.gms.measurement.internal.k3 r4 = r4.a()     // Catch: android.database.sqlite.SQLiteException -> L68 java.lang.Throwable -> Ld6
            com.google.android.gms.measurement.internal.i3 r4 = r4.m()     // Catch: android.database.sqlite.SQLiteException -> L68 java.lang.Throwable -> Ld6
            java.lang.String r5 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.k3.v(r12)     // Catch: android.database.sqlite.SQLiteException -> L68 java.lang.Throwable -> Ld6
            r4.b(r5, r6)     // Catch: android.database.sqlite.SQLiteException -> L68 java.lang.Throwable -> Ld6
        L62:
            if (r2 == 0) goto L88
            r2.close()
            goto L88
        L68:
            r3 = move-exception
            goto L6f
        L6a:
            r12 = move-exception
            goto Ld8
        L6c:
            r2 = move-exception
            r3 = r2
            r2 = r1
        L6f:
            com.google.android.gms.measurement.internal.o4 r0 = r0.a     // Catch: java.lang.Throwable -> Ld6
            com.google.android.gms.measurement.internal.k3 r0 = r0.a()     // Catch: java.lang.Throwable -> Ld6
            com.google.android.gms.measurement.internal.i3 r0 = r0.m()     // Catch: java.lang.Throwable -> Ld6
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.k3.v(r12)     // Catch: java.lang.Throwable -> Ld6
            r0.c(r4, r5, r3)     // Catch: java.lang.Throwable -> Ld6
            if (r2 == 0) goto L87
        L84:
            r2.close()
        L87:
            r3 = r1
        L88:
            if (r3 != 0) goto La9
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> r0 = r11.f3790d
            r0.put(r12, r1)
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Boolean>> r0 = r11.f3791e
            r0.put(r12, r1)
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Boolean>> r0 = r11.f3792f
            r0.put(r12, r1)
            java.util.Map<java.lang.String, com.google.android.gms.internal.measurement.zzcp> r0 = r11.f3793g
            r0.put(r12, r1)
            java.util.Map<java.lang.String, java.lang.String> r0 = r11.f3795i
            r0.put(r12, r1)
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Integer>> r0 = r11.f3794h
            r0.put(r12, r1)
            return
        La9:
            com.google.android.gms.internal.measurement.zzcp r0 = r11.x(r12, r3)
            com.google.android.gms.internal.measurement.zzho r0 = r0.zzbu()
            com.google.android.gms.internal.measurement.zzco r0 = (com.google.android.gms.internal.measurement.zzco) r0
            r11.w(r12, r0)
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> r2 = r11.f3790d
            com.google.android.gms.internal.measurement.zzhs r3 = r0.zzaA()
            com.google.android.gms.internal.measurement.zzcp r3 = (com.google.android.gms.internal.measurement.zzcp) r3
            java.util.Map r3 = y(r3)
            r2.put(r12, r3)
            java.util.Map<java.lang.String, com.google.android.gms.internal.measurement.zzcp> r2 = r11.f3793g
            com.google.android.gms.internal.measurement.zzhs r0 = r0.zzaA()
            com.google.android.gms.internal.measurement.zzcp r0 = (com.google.android.gms.internal.measurement.zzcp) r0
            r2.put(r12, r0)
            java.util.Map<java.lang.String, java.lang.String> r0 = r11.f3795i
            r0.put(r12, r1)
            return
        Ld6:
            r12 = move-exception
            r1 = r2
        Ld8:
            if (r1 == 0) goto Ldd
            r1.close()
        Ldd:
            throw r12
        Lde:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.g4.v(java.lang.String):void");
    }

    private final void w(String str, zzco zzcoVar) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        if (zzcoVar != null) {
            for (int i2 = 0; i2 < zzcoVar.zza(); i2++) {
                zzcm zzbu = zzcoVar.zzb(i2).zzbu();
                if (TextUtils.isEmpty(zzbu.zza())) {
                    this.a.a().p().a("EventConfig contained null event name");
                } else {
                    String zza = zzbu.zza();
                    String b = m5.b(zzbu.zza());
                    if (!TextUtils.isEmpty(b)) {
                        zzbu.zzb(b);
                        zzcoVar.zzc(i2, zzbu);
                    }
                    arrayMap.put(zza, Boolean.valueOf(zzbu.zzc()));
                    arrayMap2.put(zzbu.zza(), Boolean.valueOf(zzbu.zzd()));
                    if (zzbu.zze()) {
                        if (zzbu.zzf() >= 2 && zzbu.zzf() <= 65535) {
                            arrayMap3.put(zzbu.zza(), Integer.valueOf(zzbu.zzf()));
                        } else {
                            this.a.a().p().c("Invalid sampling rate. Event name, sample rate", zzbu.zza(), Integer.valueOf(zzbu.zzf()));
                        }
                    }
                }
            }
        }
        this.f3791e.put(str, arrayMap);
        this.f3792f.put(str, arrayMap2);
        this.f3794h.put(str, arrayMap3);
    }

    @WorkerThread
    private final zzcp x(String str, byte[] bArr) {
        if (bArr != null) {
            try {
                zzcp zzaA = ((zzco) j9.G(zzcp.zzj(), bArr)).zzaA();
                this.a.a().u().c("Parsed config. version, gmp_app_id", zzaA.zza() ? Long.valueOf(zzaA.zzb()) : null, zzaA.zzc() ? zzaA.zzd() : null);
                return zzaA;
            } catch (zzic e2) {
                this.a.a().p().c("Unable to merge remote config. appId", k3.v(str), e2);
                return zzcp.zzk();
            } catch (RuntimeException e3) {
                this.a.a().p().c("Unable to merge remote config. appId", k3.v(str), e3);
                return zzcp.zzk();
            }
        }
        return zzcp.zzk();
    }

    private static final Map<String, String> y(zzcp zzcpVar) {
        ArrayMap arrayMap = new ArrayMap();
        if (zzcpVar != null) {
            for (zzcr zzcrVar : zzcpVar.zze()) {
                arrayMap.put(zzcrVar.zza(), zzcrVar.zzb());
            }
        }
        return arrayMap;
    }

    @Override // com.google.android.gms.measurement.internal.d
    @WorkerThread
    public final String b(String str, String str2) {
        f();
        v(str);
        Map<String, String> map = this.f3790d.get(str);
        if (map != null) {
            return map.get(str2);
        }
        return null;
    }

    @Override // com.google.android.gms.measurement.internal.z8
    protected final boolean j() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final zzcp k(String str) {
        h();
        f();
        com.google.android.gms.common.internal.q.f(str);
        v(str);
        return this.f3793g.get(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final String l(String str) {
        f();
        return this.f3795i.get(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void m(String str) {
        f();
        this.f3795i.put(str, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void n(String str) {
        f();
        this.f3793g.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final boolean o(String str) {
        f();
        zzcp k2 = k(str);
        if (k2 == null) {
            return false;
        }
        return k2.zzi();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final boolean p(String str, byte[] bArr, String str2) {
        h();
        f();
        com.google.android.gms.common.internal.q.f(str);
        zzco zzbu = x(str, bArr).zzbu();
        if (zzbu == null) {
            return false;
        }
        w(str, zzbu);
        this.f3793g.put(str, zzbu.zzaA());
        this.f3795i.put(str, str2);
        this.f3790d.put(str, y(zzbu.zzaA()));
        this.b.X().t(str, new ArrayList(zzbu.zzd()));
        try {
            zzbu.zze();
            bArr = zzbu.zzaA().zzbp();
        } catch (RuntimeException e2) {
            this.a.a().p().c("Unable to serialize reduced-size config. Storing full config instead. appId", k3.v(str), e2);
        }
        i X = this.b.X();
        com.google.android.gms.common.internal.q.f(str);
        X.f();
        X.h();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        try {
            if (X.L().update("apps", contentValues, "app_id = ?", new String[]{str}) == 0) {
                X.a.a().m().b("Failed to update remote config (got 0). appId", k3.v(str));
            }
        } catch (SQLiteException e3) {
            X.a.a().m().c("Error storing remote config. appId", k3.v(str), e3);
        }
        this.f3793g.put(str, zzbu.zzaA());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final boolean q(String str, String str2) {
        Boolean bool;
        f();
        v(str);
        if (t(str) && n9.D(str2)) {
            return true;
        }
        if (u(str) && n9.g0(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.f3791e.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final boolean r(String str, String str2) {
        Boolean bool;
        f();
        v(str);
        if (FirebaseAnalytics.Event.ECOMMERCE_PURCHASE.equals(str2) || FirebaseAnalytics.Event.PURCHASE.equals(str2) || FirebaseAnalytics.Event.REFUND.equals(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.f3792f.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final int s(String str, String str2) {
        Integer num;
        f();
        v(str);
        Map<String, Integer> map = this.f3794h.get(str);
        if (map == null || (num = map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean t(String str) {
        return "1".equals(b(str, "measurement.upload.blacklist_internal"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean u(String str) {
        return "1".equals(b(str, "measurement.upload.blacklist_public"));
    }
}

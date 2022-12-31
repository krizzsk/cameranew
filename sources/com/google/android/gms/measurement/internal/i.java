package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.google.android.gms.internal.measurement.zzda;
import com.google.android.gms.internal.measurement.zzdb;
import com.google.android.gms.internal.measurement.zzdi;
import com.google.android.gms.internal.measurement.zzdj;
import com.google.android.gms.internal.measurement.zzmg;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.growingio.android.sdk.monitor.marshaller.json.JsonMarshaller;
import com.tapjoy.TapjoyConstants;
import com.tencent.connect.common.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.slf4j.Marker;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public final class i extends z8 {

    /* renamed from: f  reason: collision with root package name */
    private static final String[] f3824f = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};

    /* renamed from: g  reason: collision with root package name */
    private static final String[] f3825g = {FirebaseAnalytics.Param.ORIGIN, "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};

    /* renamed from: h  reason: collision with root package name */
    private static final String[] f3826h = {TapjoyConstants.TJC_APP_VERSION_NAME, "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", TapjoyConstants.TJC_ANDROID_ID, "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;"};

    /* renamed from: i  reason: collision with root package name */
    private static final String[] f3827i = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};

    /* renamed from: j  reason: collision with root package name */
    private static final String[] f3828j = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};

    /* renamed from: k  reason: collision with root package name */
    private static final String[] f3829k = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};

    /* renamed from: l  reason: collision with root package name */
    private static final String[] f3830l = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] m = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};

    /* renamed from: d  reason: collision with root package name */
    private final h f3831d;

    /* renamed from: e  reason: collision with root package name */
    private final v8 f3832e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(i9 i9Var) {
        super(i9Var);
        this.f3832e = new v8(this.a.zzax());
        this.a.x();
        this.f3831d = new h(this, this.a.zzaw(), "google_app_measurement.db");
    }

    @WorkerThread
    static final void F(ContentValues contentValues, String str, Object obj) {
        com.google.android.gms.common.internal.q.f(FirebaseAnalytics.Param.VALUE);
        com.google.android.gms.common.internal.q.j(obj);
        if (obj instanceof String) {
            contentValues.put(FirebaseAnalytics.Param.VALUE, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(FirebaseAnalytics.Param.VALUE, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(FirebaseAnalytics.Param.VALUE, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    @WorkerThread
    private final long G(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor rawQuery = L().rawQuery(str, strArr);
                if (rawQuery.moveToFirst()) {
                    long j2 = rawQuery.getLong(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return j2;
                }
                throw new SQLiteException("Database returned empty set");
            } catch (SQLiteException e2) {
                this.a.a().m().c("Database error", str, e2);
                throw e2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    @WorkerThread
    private final long H(String str, String[] strArr, long j2) {
        Cursor cursor = null;
        try {
            try {
                cursor = L().rawQuery(str, strArr);
                if (cursor.moveToFirst()) {
                    return cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
                return j2;
            } catch (SQLiteException e2) {
                this.a.a().m().c("Database error", str, e2);
                throw e2;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x023f: MOVE  (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:106:0x023f */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r4v3, types: [boolean] */
    public final void E(String str, long j2, long j3, h9 h9Var) {
        ?? r4;
        Cursor cursor;
        String str2;
        Cursor rawQuery;
        String string;
        String str3;
        String[] strArr;
        com.google.android.gms.common.internal.q.j(h9Var);
        f();
        h();
        Cursor cursor2 = null;
        r3 = null;
        r3 = null;
        String str4 = null;
        try {
            try {
                SQLiteDatabase L = L();
                r4 = TextUtils.isEmpty(null);
                try {
                    if (r4 != 0) {
                        int i2 = (j3 > (-1L) ? 1 : (j3 == (-1L) ? 0 : -1));
                        String[] strArr2 = i2 != 0 ? new String[]{String.valueOf(j3), String.valueOf(j2)} : new String[]{String.valueOf(j2)};
                        str2 = i2 != 0 ? "rowid <= ? and " : "";
                        StringBuilder sb = new StringBuilder(str2.length() + 148);
                        sb.append("select app_id, metadata_fingerprint from raw_events where ");
                        sb.append(str2);
                        sb.append("app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;");
                        rawQuery = L.rawQuery(sb.toString(), strArr2);
                        if (!rawQuery.moveToFirst()) {
                            if (rawQuery != null) {
                                rawQuery.close();
                                return;
                            }
                            return;
                        }
                        str4 = rawQuery.getString(0);
                        string = rawQuery.getString(1);
                        rawQuery.close();
                    } else {
                        int i3 = (j3 > (-1L) ? 1 : (j3 == (-1L) ? 0 : -1));
                        String[] strArr3 = i3 != 0 ? new String[]{null, String.valueOf(j3)} : new String[]{null};
                        str2 = i3 != 0 ? " and rowid <= ?" : "";
                        StringBuilder sb2 = new StringBuilder(str2.length() + 84);
                        sb2.append("select metadata_fingerprint from raw_events where app_id = ?");
                        sb2.append(str2);
                        sb2.append(" order by rowid limit 1;");
                        rawQuery = L.rawQuery(sb2.toString(), strArr3);
                        if (!rawQuery.moveToFirst()) {
                            if (rawQuery != null) {
                                rawQuery.close();
                                return;
                            }
                            return;
                        }
                        string = rawQuery.getString(0);
                        rawQuery.close();
                    }
                    Cursor cursor3 = rawQuery;
                    String str5 = string;
                    try {
                        Cursor query = L.query("raw_events_metadata", new String[]{"metadata"}, "app_id = ? and metadata_fingerprint = ?", new String[]{str4, str5}, null, null, "rowid", "2");
                        try {
                            if (!query.moveToFirst()) {
                                this.a.a().m().b("Raw event metadata record is missing. appId", k3.v(str4));
                                if (query != null) {
                                    query.close();
                                    return;
                                }
                                return;
                            }
                            try {
                                try {
                                    zzdj zzaA = ((zzdi) j9.G(zzdj.zzaj(), query.getBlob(0))).zzaA();
                                    if (query.moveToNext()) {
                                        this.a.a().p().b("Get multiple raw event metadata records, expected one. appId", k3.v(str4));
                                    }
                                    query.close();
                                    com.google.android.gms.common.internal.q.j(zzaA);
                                    h9Var.a = zzaA;
                                    if (j3 != -1) {
                                        str3 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?";
                                        strArr = new String[]{str4, str5, String.valueOf(j3)};
                                    } else {
                                        str3 = "app_id = ? and metadata_fingerprint = ?";
                                        strArr = new String[]{str4, str5};
                                    }
                                    Cursor query2 = L.query("raw_events", new String[]{"rowid", "name", "timestamp", "data"}, str3, strArr, null, null, "rowid", null);
                                    if (query2.moveToFirst()) {
                                        do {
                                            long j4 = query2.getLong(0);
                                            try {
                                                zzda zzdaVar = (zzda) j9.G(zzdb.zzk(), query2.getBlob(3));
                                                zzdaVar.zzl(query2.getString(1));
                                                zzdaVar.zzo(query2.getLong(2));
                                                if (!h9Var.a(j4, zzdaVar.zzaA())) {
                                                    if (query2 != null) {
                                                        query2.close();
                                                        return;
                                                    }
                                                    return;
                                                }
                                            } catch (IOException e2) {
                                                this.a.a().m().c("Data loss. Failed to merge raw event. appId", k3.v(str4), e2);
                                            }
                                        } while (query2.moveToNext());
                                        if (query2 != null) {
                                            query2.close();
                                            return;
                                        }
                                        return;
                                    }
                                    this.a.a().p().b("Raw event data disappeared while in transaction. appId", k3.v(str4));
                                    if (query2 != null) {
                                        query2.close();
                                    }
                                } catch (IOException e3) {
                                    this.a.a().m().c("Data loss. Failed to merge raw event metadata. appId", k3.v(str4), e3);
                                    if (query != null) {
                                        query.close();
                                    }
                                }
                            } catch (SQLiteException e4) {
                                e = e4;
                                r4 = query;
                                this.a.a().m().c("Data loss. Error selecting raw event. appId", k3.v(str4), e);
                                if (r4 != 0) {
                                    r4.close();
                                }
                            } catch (Throwable th) {
                                th = th;
                                cursor2 = query;
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                throw th;
                            }
                        } catch (SQLiteException e5) {
                            e = e5;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (SQLiteException e6) {
                        e = e6;
                        r4 = cursor3;
                    } catch (Throwable th3) {
                        th = th3;
                        cursor2 = cursor3;
                    }
                } catch (SQLiteException e7) {
                    e = e7;
                }
            } catch (Throwable th4) {
                th = th4;
                cursor2 = cursor;
            }
        } catch (SQLiteException e8) {
            e = e8;
            r4 = 0;
        } catch (Throwable th5) {
            th = th5;
        }
    }

    @WorkerThread
    public final void I() {
        h();
        L().beginTransaction();
    }

    @WorkerThread
    public final void J() {
        h();
        L().setTransactionSuccessful();
    }

    @WorkerThread
    public final void K() {
        h();
        L().endTransaction();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final SQLiteDatabase L() {
        f();
        try {
            return this.f3831d.getWritableDatabase();
        } catch (SQLiteException e2) {
            this.a.a().p().b("Error opening database", e2);
            throw e2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0154  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.o M(java.lang.String r28, java.lang.String r29) {
        /*
            Method dump skipped, instructions count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.i.M(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.o");
    }

    @WorkerThread
    public final void N(o oVar) {
        com.google.android.gms.common.internal.q.j(oVar);
        f();
        h();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TapjoyConstants.TJC_APP_ID, oVar.a);
        contentValues.put("name", oVar.b);
        contentValues.put("lifetime_count", Long.valueOf(oVar.c));
        contentValues.put("current_bundle_count", Long.valueOf(oVar.f3889d));
        contentValues.put("last_fire_timestamp", Long.valueOf(oVar.f3891f));
        contentValues.put("last_bundled_timestamp", Long.valueOf(oVar.f3892g));
        contentValues.put("last_bundled_day", oVar.f3893h);
        contentValues.put("last_sampled_complex_event_id", oVar.f3894i);
        contentValues.put("last_sampling_rate", oVar.f3895j);
        contentValues.put("current_session_count", Long.valueOf(oVar.f3890e));
        Boolean bool = oVar.f3896k;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (L().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                this.a.a().m().b("Failed to insert/update event aggregates (got -1). appId", k3.v(oVar.a));
            }
        } catch (SQLiteException e2) {
            this.a.a().m().c("Error storing event aggregates. appId", k3.v(oVar.a), e2);
        }
    }

    @WorkerThread
    public final void O(String str, String str2) {
        com.google.android.gms.common.internal.q.f(str);
        com.google.android.gms.common.internal.q.f(str2);
        f();
        h();
        try {
            L().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e2) {
            this.a.a().m().d("Error deleting user property. appId", k3.v(str), this.a.F().p(str2), e2);
        }
    }

    @WorkerThread
    public final boolean P(l9 l9Var) {
        com.google.android.gms.common.internal.q.j(l9Var);
        f();
        h();
        if (Q(l9Var.a, l9Var.c) == null) {
            if (n9.g0(l9Var.c)) {
                if (G("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{l9Var.a}) >= this.a.x().s(l9Var.a, x2.G, 25, 100)) {
                    return false;
                }
            } else if (!"_npa".equals(l9Var.c)) {
                long G = G("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{l9Var.a, l9Var.b});
                this.a.x();
                if (G >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(TapjoyConstants.TJC_APP_ID, l9Var.a);
        contentValues.put(FirebaseAnalytics.Param.ORIGIN, l9Var.b);
        contentValues.put("name", l9Var.c);
        contentValues.put("set_timestamp", Long.valueOf(l9Var.f3867d));
        F(contentValues, FirebaseAnalytics.Param.VALUE, l9Var.f3868e);
        try {
            if (L().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                this.a.a().m().b("Failed to insert/update user property (got -1). appId", k3.v(l9Var.a));
            }
        } catch (SQLiteException e2) {
            this.a.a().m().c("Error storing user property. appId", k3.v(l9Var.a), e2);
        }
        return true;
    }

    /* JADX WARN: Not initialized variable reg: 11, insn: 0x00a9: MOVE  (r10 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]), block:B:31:0x00a9 */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ac  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.l9 Q(java.lang.String r20, java.lang.String r21) {
        /*
            r19 = this;
            r1 = r19
            r9 = r21
            com.google.android.gms.common.internal.q.f(r20)
            com.google.android.gms.common.internal.q.f(r21)
            r19.f()
            r19.h()
            r10 = 0
            android.database.sqlite.SQLiteDatabase r11 = r19.L()     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> L83
            java.lang.String r0 = "set_timestamp"
            java.lang.String r2 = "value"
            java.lang.String r3 = "origin"
            java.lang.String[] r13 = new java.lang.String[]{r0, r2, r3}     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> L83
            r0 = 2
            java.lang.String[] r15 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> L83
            r2 = 0
            r15[r2] = r20     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> L83
            r3 = 1
            r15[r3] = r9     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> L83
            java.lang.String r12 = "user_attributes"
            java.lang.String r14 = "app_id=? and name=?"
            r16 = 0
            r17 = 0
            r18 = 0
            android.database.Cursor r11 = r11.query(r12, r13, r14, r15, r16, r17, r18)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> L83
            boolean r4 = r11.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L7f java.lang.Throwable -> La8
            if (r4 != 0) goto L42
            if (r11 == 0) goto L41
            r11.close()
        L41:
            return r10
        L42:
            long r6 = r11.getLong(r2)     // Catch: android.database.sqlite.SQLiteException -> L7f java.lang.Throwable -> La8
            java.lang.Object r8 = r1.k(r11, r3)     // Catch: android.database.sqlite.SQLiteException -> L7f java.lang.Throwable -> La8
            if (r8 != 0) goto L52
            if (r11 == 0) goto L51
            r11.close()
        L51:
            return r10
        L52:
            java.lang.String r4 = r11.getString(r0)     // Catch: android.database.sqlite.SQLiteException -> L7f java.lang.Throwable -> La8
            com.google.android.gms.measurement.internal.l9 r0 = new com.google.android.gms.measurement.internal.l9     // Catch: android.database.sqlite.SQLiteException -> L7f java.lang.Throwable -> La8
            r2 = r0
            r3 = r20
            r5 = r21
            r2.<init>(r3, r4, r5, r6, r8)     // Catch: android.database.sqlite.SQLiteException -> L7f java.lang.Throwable -> La8
            boolean r2 = r11.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L7f java.lang.Throwable -> La8
            if (r2 == 0) goto L79
            com.google.android.gms.measurement.internal.o4 r2 = r1.a     // Catch: android.database.sqlite.SQLiteException -> L7f java.lang.Throwable -> La8
            com.google.android.gms.measurement.internal.k3 r2 = r2.a()     // Catch: android.database.sqlite.SQLiteException -> L7f java.lang.Throwable -> La8
            com.google.android.gms.measurement.internal.i3 r2 = r2.m()     // Catch: android.database.sqlite.SQLiteException -> L7f java.lang.Throwable -> La8
            java.lang.String r3 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.k3.v(r20)     // Catch: android.database.sqlite.SQLiteException -> L7f java.lang.Throwable -> La8
            r2.b(r3, r4)     // Catch: android.database.sqlite.SQLiteException -> L7f java.lang.Throwable -> La8
        L79:
            if (r11 == 0) goto L7e
            r11.close()
        L7e:
            return r0
        L7f:
            r0 = move-exception
            goto L85
        L81:
            r0 = move-exception
            goto Laa
        L83:
            r0 = move-exception
            r11 = r10
        L85:
            com.google.android.gms.measurement.internal.o4 r2 = r1.a     // Catch: java.lang.Throwable -> La8
            com.google.android.gms.measurement.internal.k3 r2 = r2.a()     // Catch: java.lang.Throwable -> La8
            com.google.android.gms.measurement.internal.i3 r2 = r2.m()     // Catch: java.lang.Throwable -> La8
            java.lang.String r3 = "Error querying user property. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.k3.v(r20)     // Catch: java.lang.Throwable -> La8
            com.google.android.gms.measurement.internal.o4 r5 = r1.a     // Catch: java.lang.Throwable -> La8
            com.google.android.gms.measurement.internal.f3 r5 = r5.F()     // Catch: java.lang.Throwable -> La8
            java.lang.String r5 = r5.p(r9)     // Catch: java.lang.Throwable -> La8
            r2.d(r3, r4, r5, r0)     // Catch: java.lang.Throwable -> La8
            if (r11 == 0) goto La7
            r11.close()
        La7:
            return r10
        La8:
            r0 = move-exception
            r10 = r11
        Laa:
            if (r10 == 0) goto Laf
            r10.close()
        Laf:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.i.Q(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.l9");
    }

    @WorkerThread
    public final List<l9> R(String str) {
        com.google.android.gms.common.internal.q.f(str);
        f();
        h();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                this.a.x();
                cursor = L().query("user_attributes", new String[]{"name", FirebaseAnalytics.Param.ORIGIN, "set_timestamp", FirebaseAnalytics.Param.VALUE}, "app_id=?", new String[]{str}, null, null, "rowid", Constants.DEFAULT_UIN);
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return arrayList;
                }
                do {
                    String string = cursor.getString(0);
                    String string2 = cursor.getString(1);
                    if (string2 == null) {
                        string2 = "";
                    }
                    String str2 = string2;
                    long j2 = cursor.getLong(2);
                    Object k2 = k(cursor, 3);
                    if (k2 == null) {
                        this.a.a().m().b("Read invalid user property value, ignoring it. appId", k3.v(str));
                    } else {
                        arrayList.add(new l9(str, str2, string, j2, k2));
                    }
                } while (cursor.moveToNext());
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (SQLiteException e2) {
                this.a.a().m().c("Error querying user properties. appId", k3.v(str), e2);
                List<l9> emptyList = Collections.emptyList();
                if (cursor != null) {
                    cursor.close();
                }
                return emptyList;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x009e, code lost:
        r2 = r16.a.a().m();
        r16.a.x();
        r2.b("Read more than the max allowed user properties, ignoring excess", 1000);
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0121  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.google.android.gms.measurement.internal.l9> S(java.lang.String r17, java.lang.String r18, java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.i.S(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    @WorkerThread
    public final boolean T(zzaa zzaaVar) {
        com.google.android.gms.common.internal.q.j(zzaaVar);
        f();
        h();
        String str = zzaaVar.zza;
        com.google.android.gms.common.internal.q.j(str);
        if (Q(str, zzaaVar.zzc.zzb) == null) {
            long G = G("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str});
            this.a.x();
            if (G >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(TapjoyConstants.TJC_APP_ID, str);
        contentValues.put(FirebaseAnalytics.Param.ORIGIN, zzaaVar.zzb);
        contentValues.put("name", zzaaVar.zzc.zzb);
        Object Q = zzaaVar.zzc.Q();
        com.google.android.gms.common.internal.q.j(Q);
        F(contentValues, FirebaseAnalytics.Param.VALUE, Q);
        contentValues.put("active", Boolean.valueOf(zzaaVar.zze));
        contentValues.put("trigger_event_name", zzaaVar.zzf);
        contentValues.put("trigger_timeout", Long.valueOf(zzaaVar.zzh));
        contentValues.put("timed_out_event", this.a.E().J(zzaaVar.zzg));
        contentValues.put("creation_timestamp", Long.valueOf(zzaaVar.zzd));
        contentValues.put("triggered_event", this.a.E().J(zzaaVar.zzi));
        contentValues.put("triggered_timestamp", Long.valueOf(zzaaVar.zzc.zzc));
        contentValues.put("time_to_live", Long.valueOf(zzaaVar.zzj));
        contentValues.put("expired_event", this.a.E().J(zzaaVar.zzk));
        try {
            if (L().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                this.a.a().m().b("Failed to insert/update conditional user property (got -1)", k3.v(str));
            }
        } catch (SQLiteException e2) {
            this.a.a().m().c("Error storing conditional user property", k3.v(str), e2);
        }
        return true;
    }

    /* JADX WARN: Not initialized variable reg: 10, insn: 0x0121: MOVE  (r9 I:??[OBJECT, ARRAY]) = (r10 I:??[OBJECT, ARRAY]), block:B:30:0x0121 */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0124  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzaa U(java.lang.String r31, java.lang.String r32) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.i.U(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzaa");
    }

    @WorkerThread
    public final int V(String str, String str2) {
        com.google.android.gms.common.internal.q.f(str);
        com.google.android.gms.common.internal.q.f(str2);
        f();
        h();
        try {
            return L().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e2) {
            this.a.a().m().d("Error deleting conditional property", k3.v(str), this.a.F().p(str2), e2);
            return 0;
        }
    }

    @WorkerThread
    public final List<zzaa> W(String str, String str2, String str3) {
        com.google.android.gms.common.internal.q.f(str);
        f();
        h();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat(Marker.ANY_MARKER));
            sb.append(" and name glob ?");
        }
        return X(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0058, code lost:
        r2 = r27.a.a().m();
        r27.a.x();
        r2.b("Read more than the max allowed conditional properties, ignoring extra", 1000);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.google.android.gms.measurement.internal.zzaa> X(java.lang.String r28, java.lang.String[] r29) {
        /*
            Method dump skipped, instructions count: 303
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.i.X(java.lang.String, java.lang.String[]):java.util.List");
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x020c: MOVE  (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:60:0x020c */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x011d A[Catch: SQLiteException -> 0x01ec, all -> 0x020b, TryCatch #1 {all -> 0x020b, blocks: (B:4:0x005f, B:9:0x006b, B:11:0x00ce, B:16:0x00d8, B:20:0x0122, B:22:0x0159, B:26:0x0167, B:25:0x0163, B:27:0x016a, B:29:0x0172, B:33:0x017a, B:37:0x0193, B:39:0x019e, B:40:0x01b0, B:42:0x01c1, B:43:0x01ca, B:45:0x01d3, B:36:0x018f, B:19:0x011d, B:55:0x01f2), top: B:64:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0159 A[Catch: SQLiteException -> 0x01ec, all -> 0x020b, TryCatch #1 {all -> 0x020b, blocks: (B:4:0x005f, B:9:0x006b, B:11:0x00ce, B:16:0x00d8, B:20:0x0122, B:22:0x0159, B:26:0x0167, B:25:0x0163, B:27:0x016a, B:29:0x0172, B:33:0x017a, B:37:0x0193, B:39:0x019e, B:40:0x01b0, B:42:0x01c1, B:43:0x01ca, B:45:0x01d3, B:36:0x018f, B:19:0x011d, B:55:0x01f2), top: B:64:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x018f A[Catch: SQLiteException -> 0x01ec, all -> 0x020b, TryCatch #1 {all -> 0x020b, blocks: (B:4:0x005f, B:9:0x006b, B:11:0x00ce, B:16:0x00d8, B:20:0x0122, B:22:0x0159, B:26:0x0167, B:25:0x0163, B:27:0x016a, B:29:0x0172, B:33:0x017a, B:37:0x0193, B:39:0x019e, B:40:0x01b0, B:42:0x01c1, B:43:0x01ca, B:45:0x01d3, B:36:0x018f, B:19:0x011d, B:55:0x01f2), top: B:64:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x019e A[Catch: SQLiteException -> 0x01ec, all -> 0x020b, TryCatch #1 {all -> 0x020b, blocks: (B:4:0x005f, B:9:0x006b, B:11:0x00ce, B:16:0x00d8, B:20:0x0122, B:22:0x0159, B:26:0x0167, B:25:0x0163, B:27:0x016a, B:29:0x0172, B:33:0x017a, B:37:0x0193, B:39:0x019e, B:40:0x01b0, B:42:0x01c1, B:43:0x01ca, B:45:0x01d3, B:36:0x018f, B:19:0x011d, B:55:0x01f2), top: B:64:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01c1 A[Catch: SQLiteException -> 0x01ec, all -> 0x020b, TryCatch #1 {all -> 0x020b, blocks: (B:4:0x005f, B:9:0x006b, B:11:0x00ce, B:16:0x00d8, B:20:0x0122, B:22:0x0159, B:26:0x0167, B:25:0x0163, B:27:0x016a, B:29:0x0172, B:33:0x017a, B:37:0x0193, B:39:0x019e, B:40:0x01b0, B:42:0x01c1, B:43:0x01ca, B:45:0x01d3, B:36:0x018f, B:19:0x011d, B:55:0x01f2), top: B:64:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01d3 A[Catch: SQLiteException -> 0x01ec, all -> 0x020b, TRY_LEAVE, TryCatch #1 {all -> 0x020b, blocks: (B:4:0x005f, B:9:0x006b, B:11:0x00ce, B:16:0x00d8, B:20:0x0122, B:22:0x0159, B:26:0x0167, B:25:0x0163, B:27:0x016a, B:29:0x0172, B:33:0x017a, B:37:0x0193, B:39:0x019e, B:40:0x01b0, B:42:0x01c1, B:43:0x01ca, B:45:0x01d3, B:36:0x018f, B:19:0x011d, B:55:0x01f2), top: B:64:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x020f  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.d5 Y(java.lang.String r34) {
        /*
            Method dump skipped, instructions count: 531
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.i.Y(java.lang.String):com.google.android.gms.measurement.internal.d5");
    }

    @WorkerThread
    public final void Z(d5 d5Var) {
        com.google.android.gms.common.internal.q.j(d5Var);
        f();
        h();
        String N = d5Var.N();
        com.google.android.gms.common.internal.q.j(N);
        ContentValues contentValues = new ContentValues();
        contentValues.put(TapjoyConstants.TJC_APP_ID, N);
        contentValues.put("app_instance_id", d5Var.O());
        contentValues.put("gmp_app_id", d5Var.Q());
        contentValues.put("resettable_device_id_hash", d5Var.W());
        contentValues.put("last_bundle_index", Long.valueOf(d5Var.i()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(d5Var.a0()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(d5Var.c0()));
        contentValues.put(TapjoyConstants.TJC_APP_VERSION_NAME, d5Var.e0());
        contentValues.put("app_store", d5Var.i0());
        contentValues.put("gmp_version", Long.valueOf(d5Var.k0()));
        contentValues.put("dev_cert_hash", Long.valueOf(d5Var.b()));
        contentValues.put("measurement_enabled", Boolean.valueOf(d5Var.f()));
        contentValues.put("day", Long.valueOf(d5Var.o()));
        contentValues.put("daily_public_events_count", Long.valueOf(d5Var.q()));
        contentValues.put("daily_events_count", Long.valueOf(d5Var.s()));
        contentValues.put("daily_conversions_count", Long.valueOf(d5Var.u()));
        contentValues.put("config_fetched_time", Long.valueOf(d5Var.j()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(d5Var.l()));
        contentValues.put("app_version_int", Long.valueOf(d5Var.g0()));
        contentValues.put("firebase_instance_id", d5Var.Y());
        contentValues.put("daily_error_events_count", Long.valueOf(d5Var.y()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(d5Var.w()));
        contentValues.put("health_monitor_sample", d5Var.B());
        contentValues.put(TapjoyConstants.TJC_ANDROID_ID, Long.valueOf(d5Var.E()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(d5Var.G()));
        contentValues.put("admob_app_id", d5Var.S());
        contentValues.put("dynamite_version", Long.valueOf(d5Var.d()));
        List<String> K = d5Var.K();
        if (K != null) {
            if (K.size() == 0) {
                this.a.a().p().b("Safelisted events should not be an empty list. appId", N);
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", K));
            }
        }
        zzmg.zzb();
        if (this.a.x().u(N, x2.i0)) {
            contentValues.put("ga_app_id", d5Var.U());
        }
        try {
            SQLiteDatabase L = L();
            if (L.update("apps", contentValues, "app_id = ?", new String[]{N}) == 0 && L.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                this.a.a().m().b("Failed to insert/update app (got -1). appId", k3.v(N));
            }
        } catch (SQLiteException e2) {
            this.a.a().m().c("Error storing app. appId", k3.v(N), e2);
        }
    }

    @WorkerThread
    public final g a0(long j2, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return b0(j2, str, 1L, false, false, z3, false, z5);
    }

    @WorkerThread
    public final g b0(long j2, String str, long j3, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        com.google.android.gms.common.internal.q.f(str);
        f();
        h();
        String[] strArr = {str};
        g gVar = new g();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase L = L();
                Cursor query = L.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, null, null, null);
                if (!query.moveToFirst()) {
                    this.a.a().p().b("Not updating daily counts, app is not known. appId", k3.v(str));
                    if (query != null) {
                        query.close();
                    }
                    return gVar;
                }
                if (query.getLong(0) == j2) {
                    gVar.b = query.getLong(1);
                    gVar.a = query.getLong(2);
                    gVar.c = query.getLong(3);
                    gVar.f3788d = query.getLong(4);
                    gVar.f3789e = query.getLong(5);
                }
                if (z) {
                    gVar.b += j3;
                }
                if (z2) {
                    gVar.a += j3;
                }
                if (z3) {
                    gVar.c += j3;
                }
                if (z4) {
                    gVar.f3788d += j3;
                }
                if (z5) {
                    gVar.f3789e += j3;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("day", Long.valueOf(j2));
                contentValues.put("daily_public_events_count", Long.valueOf(gVar.a));
                contentValues.put("daily_events_count", Long.valueOf(gVar.b));
                contentValues.put("daily_conversions_count", Long.valueOf(gVar.c));
                contentValues.put("daily_error_events_count", Long.valueOf(gVar.f3788d));
                contentValues.put("daily_realtime_events_count", Long.valueOf(gVar.f3789e));
                L.update("apps", contentValues, "app_id=?", strArr);
                if (query != null) {
                    query.close();
                }
                return gVar;
            } catch (SQLiteException e2) {
                this.a.a().m().c("Error updating daily counts. appId", k3.v(str), e2);
                if (0 != 0) {
                    cursor.close();
                }
                return gVar;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0044  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String c0() {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.L()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch: java.lang.Throwable -> L24 android.database.sqlite.SQLiteException -> L26
            boolean r2 = r0.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L22 java.lang.Throwable -> L3e
            if (r2 == 0) goto L1c
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch: android.database.sqlite.SQLiteException -> L22 java.lang.Throwable -> L3e
            if (r0 == 0) goto L1b
            r0.close()
        L1b:
            return r1
        L1c:
            if (r0 == 0) goto L21
            r0.close()
        L21:
            return r1
        L22:
            r2 = move-exception
            goto L29
        L24:
            r0 = move-exception
            goto L42
        L26:
            r0 = move-exception
            r2 = r0
            r0 = r1
        L29:
            com.google.android.gms.measurement.internal.o4 r3 = r6.a     // Catch: java.lang.Throwable -> L3e
            com.google.android.gms.measurement.internal.k3 r3 = r3.a()     // Catch: java.lang.Throwable -> L3e
            com.google.android.gms.measurement.internal.i3 r3 = r3.m()     // Catch: java.lang.Throwable -> L3e
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.b(r4, r2)     // Catch: java.lang.Throwable -> L3e
            if (r0 == 0) goto L3d
            r0.close()
        L3d:
            return r1
        L3e:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L42:
            if (r1 == 0) goto L47
            r1.close()
        L47:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.i.c0():java.lang.String");
    }

    public final boolean d0() {
        return G("select count(1) > 0 from queue where has_realtime = 1", null) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void e0() {
        f();
        h();
        if (u()) {
            long a = this.a.y().f4005h.a();
            long a2 = this.a.zzax().a();
            long abs = Math.abs(a2 - a);
            this.a.x();
            if (abs > x2.y.b(null).longValue()) {
                this.a.y().f4005h.b(a2);
                f();
                h();
                if (u()) {
                    SQLiteDatabase L = L();
                    this.a.x();
                    int delete = L.delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(this.a.zzax().currentTimeMillis()), String.valueOf(e.g())});
                    if (delete > 0) {
                        this.a.a().u().b("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void f0(List<Long> list) {
        f();
        h();
        com.google.android.gms.common.internal.q.j(list);
        com.google.android.gms.common.internal.q.l(list.size());
        if (u()) {
            String join = TextUtils.join(",", list);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 80);
            sb3.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
            sb3.append(sb2);
            sb3.append(" AND retry_count =  2147483647 LIMIT 1");
            if (G(sb3.toString(), null) > 0) {
                this.a.a().p().a("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase L = L();
                StringBuilder sb4 = new StringBuilder(String.valueOf(sb2).length() + 127);
                sb4.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb4.append(sb2);
                sb4.append(" AND (retry_count IS NULL OR retry_count < ");
                sb4.append(Integer.MAX_VALUE);
                sb4.append(")");
                L.execSQL(sb4.toString());
            } catch (SQLiteException e2) {
                this.a.a().m().b("Error incrementing retry count. error", e2);
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.z8
    protected final boolean j() {
        return false;
    }

    @WorkerThread
    final Object k(Cursor cursor, int i2) {
        int type = cursor.getType(i2);
        if (type == 0) {
            this.a.a().m().a("Loaded invalid null value from database");
            return null;
        } else if (type != 1) {
            if (type != 2) {
                if (type != 3) {
                    if (type != 4) {
                        this.a.a().m().b("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                        return null;
                    }
                    this.a.a().m().a("Loaded invalid blob type value, ignoring it");
                    return null;
                }
                return cursor.getString(i2);
            }
            return Double.valueOf(cursor.getDouble(i2));
        } else {
            return Long.valueOf(cursor.getLong(i2));
        }
    }

    @WorkerThread
    public final long l() {
        return H("select max(bundle_end_timestamp) from queue", null, 0L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final long m(String str, String str2) {
        long H;
        com.google.android.gms.common.internal.q.f(str);
        com.google.android.gms.common.internal.q.f("first_open_count");
        f();
        h();
        SQLiteDatabase L = L();
        L.beginTransaction();
        long j2 = 0;
        try {
            try {
                StringBuilder sb = new StringBuilder(48);
                sb.append("select ");
                sb.append("first_open_count");
                sb.append(" from app2 where app_id=?");
                H = H(sb.toString(), new String[]{str}, -1L);
                if (H == -1) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(TapjoyConstants.TJC_APP_ID, str);
                    contentValues.put("first_open_count", (Integer) 0);
                    contentValues.put("previous_install_count", (Integer) 0);
                    if (L.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                        this.a.a().m().c("Failed to insert column (got -1). appId", k3.v(str), "first_open_count");
                        return -1L;
                    }
                    H = 0;
                }
            } catch (SQLiteException e2) {
                e = e2;
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put(TapjoyConstants.TJC_APP_ID, str);
                contentValues2.put("first_open_count", Long.valueOf(1 + H));
                if (L.update("app2", contentValues2, "app_id = ?", new String[]{str}) == 0) {
                    this.a.a().m().c("Failed to update column (got 0). appId", k3.v(str), "first_open_count");
                    return -1L;
                }
                L.setTransactionSuccessful();
                return H;
            } catch (SQLiteException e3) {
                e = e3;
                j2 = H;
                this.a.a().m().d("Error inserting column. appId", k3.v(str), "first_open_count", e);
                L.endTransaction();
                return j2;
            }
        } finally {
            L.endTransaction();
        }
    }

    @WorkerThread
    public final long n() {
        return H("select max(timestamp) from raw_events", null, 0L);
    }

    public final boolean o() {
        return G("select count(1) > 0 from raw_events", null) != 0;
    }

    public final boolean p() {
        return G("select count(1) > 0 from raw_events where realtime = 1", null) != 0;
    }

    public final long q(String str) {
        com.google.android.gms.common.internal.q.f(str);
        return H("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    public final boolean r(String str, Long l2, long j2, zzdb zzdbVar) {
        f();
        h();
        com.google.android.gms.common.internal.q.j(zzdbVar);
        com.google.android.gms.common.internal.q.f(str);
        com.google.android.gms.common.internal.q.j(l2);
        byte[] zzbp = zzdbVar.zzbp();
        this.a.a().u().c("Saving complex main event, appId, data size", this.a.F().n(str), Integer.valueOf(zzbp.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put(TapjoyConstants.TJC_APP_ID, str);
        contentValues.put(JsonMarshaller.EVENT_ID, l2);
        contentValues.put("children_to_process", Long.valueOf(j2));
        contentValues.put("main_event", zzbp);
        try {
            if (L().insertWithOnConflict("main_event_params", null, contentValues, 5) == -1) {
                this.a.a().m().b("Failed to insert complex main event (got -1). appId", k3.v(str));
                return false;
            }
            return true;
        } catch (SQLiteException e2) {
            this.a.a().m().c("Error storing complex main event. appId", k3.v(str), e2);
            return false;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x00dc: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:47:0x00dc */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.os.Bundle s(java.lang.String r8) {
        /*
            r7 = this;
            r7.f()
            r7.h()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.L()     // Catch: java.lang.Throwable -> Lc2 android.database.sqlite.SQLiteException -> Lc4
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> Lc2 android.database.sqlite.SQLiteException -> Lc4
            r3 = 0
            r2[r3] = r8     // Catch: java.lang.Throwable -> Lc2 android.database.sqlite.SQLiteException -> Lc4
            java.lang.String r4 = "select parameters from default_event_params where app_id=?"
            android.database.Cursor r1 = r1.rawQuery(r4, r2)     // Catch: java.lang.Throwable -> Lc2 android.database.sqlite.SQLiteException -> Lc4
            boolean r2 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> Lc0 java.lang.Throwable -> Ldb
            if (r2 != 0) goto L32
            com.google.android.gms.measurement.internal.o4 r8 = r7.a     // Catch: android.database.sqlite.SQLiteException -> Lc0 java.lang.Throwable -> Ldb
            com.google.android.gms.measurement.internal.k3 r8 = r8.a()     // Catch: android.database.sqlite.SQLiteException -> Lc0 java.lang.Throwable -> Ldb
            com.google.android.gms.measurement.internal.i3 r8 = r8.u()     // Catch: android.database.sqlite.SQLiteException -> Lc0 java.lang.Throwable -> Ldb
            java.lang.String r2 = "Default event parameters not found"
            r8.a(r2)     // Catch: android.database.sqlite.SQLiteException -> Lc0 java.lang.Throwable -> Ldb
            if (r1 == 0) goto L31
            r1.close()
        L31:
            return r0
        L32:
            byte[] r2 = r1.getBlob(r3)     // Catch: android.database.sqlite.SQLiteException -> Lc0 java.lang.Throwable -> Ldb
            com.google.android.gms.internal.measurement.zzda r3 = com.google.android.gms.internal.measurement.zzdb.zzk()     // Catch: java.io.IOException -> La6 android.database.sqlite.SQLiteException -> Lc0 java.lang.Throwable -> Ldb
            com.google.android.gms.internal.measurement.zziw r2 = com.google.android.gms.measurement.internal.j9.G(r3, r2)     // Catch: java.io.IOException -> La6 android.database.sqlite.SQLiteException -> Lc0 java.lang.Throwable -> Ldb
            com.google.android.gms.internal.measurement.zzda r2 = (com.google.android.gms.internal.measurement.zzda) r2     // Catch: java.io.IOException -> La6 android.database.sqlite.SQLiteException -> Lc0 java.lang.Throwable -> Ldb
            com.google.android.gms.internal.measurement.zzhs r2 = r2.zzaA()     // Catch: java.io.IOException -> La6 android.database.sqlite.SQLiteException -> Lc0 java.lang.Throwable -> Ldb
            com.google.android.gms.internal.measurement.zzdb r2 = (com.google.android.gms.internal.measurement.zzdb) r2     // Catch: java.io.IOException -> La6 android.database.sqlite.SQLiteException -> Lc0 java.lang.Throwable -> Ldb
            com.google.android.gms.measurement.internal.i9 r8 = r7.b     // Catch: android.database.sqlite.SQLiteException -> Lc0 java.lang.Throwable -> Ldb
            r8.c0()     // Catch: android.database.sqlite.SQLiteException -> Lc0 java.lang.Throwable -> Ldb
            java.util.List r8 = r2.zza()     // Catch: android.database.sqlite.SQLiteException -> Lc0 java.lang.Throwable -> Ldb
            android.os.Bundle r2 = new android.os.Bundle     // Catch: android.database.sqlite.SQLiteException -> Lc0 java.lang.Throwable -> Ldb
            r2.<init>()     // Catch: android.database.sqlite.SQLiteException -> Lc0 java.lang.Throwable -> Ldb
            java.util.Iterator r8 = r8.iterator()     // Catch: android.database.sqlite.SQLiteException -> Lc0 java.lang.Throwable -> Ldb
        L58:
            boolean r3 = r8.hasNext()     // Catch: android.database.sqlite.SQLiteException -> Lc0 java.lang.Throwable -> Ldb
            if (r3 == 0) goto La0
            java.lang.Object r3 = r8.next()     // Catch: android.database.sqlite.SQLiteException -> Lc0 java.lang.Throwable -> Ldb
            com.google.android.gms.internal.measurement.zzdf r3 = (com.google.android.gms.internal.measurement.zzdf) r3     // Catch: android.database.sqlite.SQLiteException -> Lc0 java.lang.Throwable -> Ldb
            java.lang.String r4 = r3.zzb()     // Catch: android.database.sqlite.SQLiteException -> Lc0 java.lang.Throwable -> Ldb
            boolean r5 = r3.zzi()     // Catch: android.database.sqlite.SQLiteException -> Lc0 java.lang.Throwable -> Ldb
            if (r5 == 0) goto L76
            double r5 = r3.zzj()     // Catch: android.database.sqlite.SQLiteException -> Lc0 java.lang.Throwable -> Ldb
            r2.putDouble(r4, r5)     // Catch: android.database.sqlite.SQLiteException -> Lc0 java.lang.Throwable -> Ldb
            goto L58
        L76:
            boolean r5 = r3.zzg()     // Catch: android.database.sqlite.SQLiteException -> Lc0 java.lang.Throwable -> Ldb
            if (r5 == 0) goto L84
            float r3 = r3.zzh()     // Catch: android.database.sqlite.SQLiteException -> Lc0 java.lang.Throwable -> Ldb
            r2.putFloat(r4, r3)     // Catch: android.database.sqlite.SQLiteException -> Lc0 java.lang.Throwable -> Ldb
            goto L58
        L84:
            boolean r5 = r3.zzc()     // Catch: android.database.sqlite.SQLiteException -> Lc0 java.lang.Throwable -> Ldb
            if (r5 == 0) goto L92
            java.lang.String r3 = r3.zzd()     // Catch: android.database.sqlite.SQLiteException -> Lc0 java.lang.Throwable -> Ldb
            r2.putString(r4, r3)     // Catch: android.database.sqlite.SQLiteException -> Lc0 java.lang.Throwable -> Ldb
            goto L58
        L92:
            boolean r5 = r3.zze()     // Catch: android.database.sqlite.SQLiteException -> Lc0 java.lang.Throwable -> Ldb
            if (r5 == 0) goto L58
            long r5 = r3.zzf()     // Catch: android.database.sqlite.SQLiteException -> Lc0 java.lang.Throwable -> Ldb
            r2.putLong(r4, r5)     // Catch: android.database.sqlite.SQLiteException -> Lc0 java.lang.Throwable -> Ldb
            goto L58
        La0:
            if (r1 == 0) goto La5
            r1.close()
        La5:
            return r2
        La6:
            r2 = move-exception
            com.google.android.gms.measurement.internal.o4 r3 = r7.a     // Catch: android.database.sqlite.SQLiteException -> Lc0 java.lang.Throwable -> Ldb
            com.google.android.gms.measurement.internal.k3 r3 = r3.a()     // Catch: android.database.sqlite.SQLiteException -> Lc0 java.lang.Throwable -> Ldb
            com.google.android.gms.measurement.internal.i3 r3 = r3.m()     // Catch: android.database.sqlite.SQLiteException -> Lc0 java.lang.Throwable -> Ldb
            java.lang.String r4 = "Failed to retrieve default event parameters. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.k3.v(r8)     // Catch: android.database.sqlite.SQLiteException -> Lc0 java.lang.Throwable -> Ldb
            r3.c(r4, r8, r2)     // Catch: android.database.sqlite.SQLiteException -> Lc0 java.lang.Throwable -> Ldb
            if (r1 == 0) goto Lbf
            r1.close()
        Lbf:
            return r0
        Lc0:
            r8 = move-exception
            goto Lc6
        Lc2:
            r8 = move-exception
            goto Ldd
        Lc4:
            r8 = move-exception
            r1 = r0
        Lc6:
            com.google.android.gms.measurement.internal.o4 r2 = r7.a     // Catch: java.lang.Throwable -> Ldb
            com.google.android.gms.measurement.internal.k3 r2 = r2.a()     // Catch: java.lang.Throwable -> Ldb
            com.google.android.gms.measurement.internal.i3 r2 = r2.m()     // Catch: java.lang.Throwable -> Ldb
            java.lang.String r3 = "Error selecting default event parameters"
            r2.b(r3, r8)     // Catch: java.lang.Throwable -> Ldb
            if (r1 == 0) goto Lda
            r1.close()
        Lda:
            return r0
        Ldb:
            r8 = move-exception
            r0 = r1
        Ldd:
            if (r0 == 0) goto Le2
            r0.close()
        Le2:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.i.s(java.lang.String):android.os.Bundle");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x0343, code lost:
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0344, code lost:
        r11.put("session_scoped", r0);
        r11.put("data", r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0358, code lost:
        if (L().insertWithOnConflict("property_filters", null, r11, 5) != (-1)) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x035a, code lost:
        r23.a.a().m().b("Failed to insert property filter (got -1). appId", com.google.android.gms.measurement.internal.k3.v(r24));
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x036e, code lost:
        r0 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0372, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0373, code lost:
        r23.a.a().m().c("Error storing property filter. appId", com.google.android.gms.measurement.internal.k3.v(r24), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0386, code lost:
        h();
        f();
        com.google.android.gms.common.internal.q.f(r24);
        r0 = L();
        r3 = r17;
        r0.delete("property_filters", r3, new java.lang.String[]{r24, java.lang.String.valueOf(r10)});
        r0.delete("event_filters", r3, new java.lang.String[]{r24, java.lang.String.valueOf(r10)});
        r17 = r3;
        r4 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x03bd, code lost:
        r4 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x018b, code lost:
        r11 = r0.zzc().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0197, code lost:
        if (r11.hasNext() == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01a3, code lost:
        if (r11.next().zza() != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x01a5, code lost:
        r23.a.a().p().c("Property filter with no ID. Audience definition ignored. appId, audienceId", com.google.android.gms.measurement.internal.k3.v(r24), java.lang.Integer.valueOf(r10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x01be, code lost:
        r11 = r0.zzf().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01d4, code lost:
        if (r11.hasNext() == false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01d6, code lost:
        r12 = r11.next();
        h();
        f();
        com.google.android.gms.common.internal.q.f(r24);
        com.google.android.gms.common.internal.q.j(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01f0, code lost:
        if (android.text.TextUtils.isEmpty(r12.zzc()) == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01f2, code lost:
        r0 = r23.a.a().p();
        r8 = com.google.android.gms.measurement.internal.k3.v(r24);
        r11 = java.lang.Integer.valueOf(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x020a, code lost:
        if (r12.zza() == false) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x020c, code lost:
        r20 = java.lang.Integer.valueOf(r12.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0217, code lost:
        r20 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0219, code lost:
        r0.d("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", r8, r11, java.lang.String.valueOf(r20));
        r21 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0224, code lost:
        r3 = r12.zzbp();
        r21 = r4;
        r4 = new android.content.ContentValues();
        r4.put(com.tapjoy.TapjoyConstants.TJC_APP_ID, r24);
        r4.put("audience_id", java.lang.Integer.valueOf(r10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x023d, code lost:
        if (r12.zza() == false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x023f, code lost:
        r8 = java.lang.Integer.valueOf(r12.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0248, code lost:
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0249, code lost:
        r4.put("filter_id", r8);
        r4.put(com.tapjoy.TJAdUnitConstants.PARAM_PLACEMENT_NAME, r12.zzc());
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0259, code lost:
        if (r12.zzk() == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x025b, code lost:
        r8 = java.lang.Boolean.valueOf(r12.zzm());
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0264, code lost:
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0265, code lost:
        r4.put("session_scoped", r8);
        r4.put("data", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0279, code lost:
        if (L().insertWithOnConflict("event_filters", null, r4, 5) != (-1)) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x027b, code lost:
        r23.a.a().m().b("Failed to insert event filter (got -1). appId", com.google.android.gms.measurement.internal.k3.v(r24));
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x028e, code lost:
        r4 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0294, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0295, code lost:
        r23.a.a().m().c("Error storing event filter. appId", com.google.android.gms.measurement.internal.k3.v(r24), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x02aa, code lost:
        r21 = r4;
        r0 = r0.zzc().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x02b8, code lost:
        if (r0.hasNext() == false) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x02ba, code lost:
        r3 = r0.next();
        h();
        f();
        com.google.android.gms.common.internal.q.f(r24);
        com.google.android.gms.common.internal.q.j(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x02d4, code lost:
        if (android.text.TextUtils.isEmpty(r3.zzc()) == false) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x02d6, code lost:
        r0 = r23.a.a().p();
        r7 = com.google.android.gms.measurement.internal.k3.v(r24);
        r8 = java.lang.Integer.valueOf(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x02ee, code lost:
        if (r3.zza() == false) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x02f0, code lost:
        r3 = java.lang.Integer.valueOf(r3.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x02f9, code lost:
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x02fa, code lost:
        r0.d("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", r7, r8, java.lang.String.valueOf(r3));
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0303, code lost:
        r4 = r3.zzbp();
        r11 = new android.content.ContentValues();
        r11.put(com.tapjoy.TapjoyConstants.TJC_APP_ID, r24);
        r11.put("audience_id", java.lang.Integer.valueOf(r10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x031a, code lost:
        if (r3.zza() == false) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x031c, code lost:
        r12 = java.lang.Integer.valueOf(r3.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0325, code lost:
        r12 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0326, code lost:
        r11.put("filter_id", r12);
        r22 = r0;
        r11.put("property_name", r3.zzc());
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0338, code lost:
        if (r3.zzg() == false) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x033a, code lost:
        r0 = java.lang.Boolean.valueOf(r3.zzh());
     */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(java.lang.String r24, java.util.List<com.google.android.gms.internal.measurement.zzbu> r25) {
        /*
            Method dump skipped, instructions count: 1221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.i.t(java.lang.String, java.util.List):void");
    }

    protected final boolean u() {
        Context zzaw = this.a.zzaw();
        this.a.x();
        return zzaw.getDatabasePath("google_app_measurement.db").exists();
    }
}

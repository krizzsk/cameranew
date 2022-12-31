package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.SystemClock;
import androidx.annotation.WorkerThread;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class e3 extends c4 {
    private final d3 c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3779d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e3(o4 o4Var) {
        super(o4Var);
        Context zzaw = this.a.zzaw();
        this.a.x();
        this.c = new d3(this, zzaw, "google_app_measurement_local.db");
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0129  */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v13 */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean v(int r17, byte[] r18) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.e3.v(int, byte[]):boolean");
    }

    @Override // com.google.android.gms.measurement.internal.c4
    protected final boolean k() {
        return false;
    }

    @WorkerThread
    public final void m() {
        int delete;
        f();
        try {
            SQLiteDatabase t = t();
            if (t == null || (delete = t.delete("messages", null, null)) <= 0) {
                return;
            }
            this.a.a().u().b("Reset local analytics data. records", Integer.valueOf(delete));
        } catch (SQLiteException e2) {
            this.a.a().m().b("Error resetting local analytics data. error", e2);
        }
    }

    public final boolean n(zzas zzasVar) {
        Parcel obtain = Parcel.obtain();
        r.a(zzasVar, obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length > 131072) {
            this.a.a().n().a("Event is too long for local database. Sending event directly to service");
            return false;
        }
        return v(0, marshall);
    }

    public final boolean o(zzkg zzkgVar) {
        Parcel obtain = Parcel.obtain();
        k9.a(zzkgVar, obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length > 131072) {
            this.a.a().n().a("User property too long for local database. Sending directly to service");
            return false;
        }
        return v(1, marshall);
    }

    public final boolean p(zzaa zzaaVar) {
        byte[] J = this.a.E().J(zzaaVar);
        if (J.length > 131072) {
            this.a.a().n().a("Conditional user property too long for local database. Sending directly to service");
            return false;
        }
        return v(2, J);
    }

    /* JADX WARN: Removed duplicated region for block: B:148:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0205 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x01e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0252 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0252 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0252 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable> q(int r23) {
        /*
            Method dump skipped, instructions count: 628
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.e3.q(int):java.util.List");
    }

    @WorkerThread
    public final boolean r() {
        return v(3, new byte[0]);
    }

    @WorkerThread
    public final boolean s() {
        int i2;
        f();
        if (!this.f3779d && u()) {
            int i3 = 5;
            while (i2 < 5) {
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    SQLiteDatabase t = t();
                    if (t == null) {
                        this.f3779d = true;
                        return false;
                    }
                    t.beginTransaction();
                    t.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                    t.setTransactionSuccessful();
                    t.endTransaction();
                    t.close();
                    return true;
                } catch (SQLiteDatabaseLockedException unused) {
                    SystemClock.sleep(i3);
                    i3 += 20;
                    i2 = 0 == 0 ? i2 + 1 : 0;
                    sQLiteDatabase.close();
                } catch (SQLiteFullException e2) {
                    this.a.a().m().b("Error deleting app launch break from local database", e2);
                    this.f3779d = true;
                    if (0 == 0) {
                    }
                    sQLiteDatabase.close();
                } catch (SQLiteException e3) {
                    if (0 != 0) {
                        try {
                            if (sQLiteDatabase.inTransaction()) {
                                sQLiteDatabase.endTransaction();
                            }
                        } catch (Throwable th) {
                            if (0 != 0) {
                                sQLiteDatabase.close();
                            }
                            throw th;
                        }
                    }
                    this.a.a().m().b("Error deleting app launch break from local database", e3);
                    this.f3779d = true;
                    if (0 != 0) {
                        sQLiteDatabase.close();
                    }
                }
            }
            this.a.a().p().a("Error deleting app launch break from local database in reasonable time");
        }
        return false;
    }

    @WorkerThread
    final SQLiteDatabase t() throws SQLiteException {
        if (this.f3779d) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.c.getWritableDatabase();
        if (writableDatabase == null) {
            this.f3779d = true;
            return null;
        }
        return writableDatabase;
    }

    final boolean u() {
        Context zzaw = this.a.zzaw();
        this.a.x();
        return zzaw.getDatabasePath("google_app_measurement_local.db").exists();
    }
}

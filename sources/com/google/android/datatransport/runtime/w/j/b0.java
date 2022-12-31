package com.google.android.datatransport.runtime.w.j;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.datatransport.runtime.h;
import com.google.android.datatransport.runtime.m;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import com.google.android.datatransport.runtime.synchronization.a;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.growingio.android.sdk.monitor.marshaller.json.JsonMarshaller;
import com.tapjoy.TJAdUnitConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
/* compiled from: SQLiteEventStore.java */
@Singleton
@WorkerThread
/* loaded from: classes2.dex */
public class b0 implements com.google.android.datatransport.runtime.w.j.c, com.google.android.datatransport.runtime.synchronization.a {

    /* renamed from: e  reason: collision with root package name */
    private static final com.google.android.datatransport.b f3428e = com.google.android.datatransport.b.b("proto");
    private final h0 a;
    private final com.google.android.datatransport.runtime.x.a b;
    private final com.google.android.datatransport.runtime.x.a c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.datatransport.runtime.w.j.d f3429d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SQLiteEventStore.java */
    /* loaded from: classes2.dex */
    public interface b<T, U> {
        U apply(T t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SQLiteEventStore.java */
    /* loaded from: classes2.dex */
    public static class c {
        final String a;
        final String b;

        private c(String str, String str2) {
            this.a = str;
            this.b = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SQLiteEventStore.java */
    /* loaded from: classes2.dex */
    public interface d<T> {
        T a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public b0(com.google.android.datatransport.runtime.x.a aVar, com.google.android.datatransport.runtime.x.a aVar2, com.google.android.datatransport.runtime.w.j.d dVar, h0 h0Var) {
        this.a = h0Var;
        this.b = aVar;
        this.c = aVar2;
        this.f3429d = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object O(Throwable th) {
        throw new SynchronizationException("Timed out while trying to acquire the lock.", th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ SQLiteDatabase Q(Throwable th) {
        throw new SynchronizationException("Timed out while trying to open db.", th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Long R(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Long S(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Boolean T(b0 b0Var, com.google.android.datatransport.runtime.m mVar, SQLiteDatabase sQLiteDatabase) {
        Long w = b0Var.w(sQLiteDatabase, mVar);
        if (w == null) {
            return Boolean.FALSE;
        }
        return (Boolean) k0(b0Var.t().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{w.toString()}), u.a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ List U(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            m.a a2 = com.google.android.datatransport.runtime.m.a();
            a2.b(cursor.getString(1));
            a2.d(com.google.android.datatransport.runtime.y.a.b(cursor.getInt(2)));
            a2.c(f0(cursor.getString(3)));
            arrayList.add(a2.a());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ List V(SQLiteDatabase sQLiteDatabase) {
        return (List) k0(sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), t.a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ List W(b0 b0Var, com.google.android.datatransport.runtime.m mVar, SQLiteDatabase sQLiteDatabase) {
        List<i> d0 = b0Var.d0(sQLiteDatabase, mVar);
        b0Var.z(d0, b0Var.e0(sQLiteDatabase, d0));
        return d0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object X(b0 b0Var, List list, com.google.android.datatransport.runtime.m mVar, Cursor cursor) {
        while (cursor.moveToNext()) {
            long j2 = cursor.getLong(0);
            boolean z = cursor.getInt(7) != 0;
            h.a a2 = com.google.android.datatransport.runtime.h.a();
            a2.j(cursor.getString(1));
            a2.i(cursor.getLong(2));
            a2.k(cursor.getLong(3));
            if (z) {
                a2.h(new com.google.android.datatransport.runtime.g(i0(cursor.getString(4)), cursor.getBlob(5)));
            } else {
                a2.h(new com.google.android.datatransport.runtime.g(i0(cursor.getString(4)), b0Var.g0(j2)));
            }
            if (!cursor.isNull(6)) {
                a2.g(Integer.valueOf(cursor.getInt(6)));
            }
            list.add(i.a(j2, mVar, a2.d()));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object Y(Map map, Cursor cursor) {
        while (cursor.moveToNext()) {
            long j2 = cursor.getLong(0);
            Set set = (Set) map.get(Long.valueOf(j2));
            if (set == null) {
                set = new HashSet();
                map.put(Long.valueOf(j2), set);
            }
            set.add(new c(cursor.getString(1), cursor.getString(2)));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Long Z(b0 b0Var, com.google.android.datatransport.runtime.m mVar, com.google.android.datatransport.runtime.h hVar, SQLiteDatabase sQLiteDatabase) {
        if (b0Var.y()) {
            return -1L;
        }
        long e2 = b0Var.e(sQLiteDatabase, mVar);
        int e3 = b0Var.f3429d.e();
        byte[] a2 = hVar.e().a();
        boolean z = a2.length <= e3;
        ContentValues contentValues = new ContentValues();
        contentValues.put("context_id", Long.valueOf(e2));
        contentValues.put("transport_name", hVar.j());
        contentValues.put("timestamp_ms", Long.valueOf(hVar.f()));
        contentValues.put("uptime_ms", Long.valueOf(hVar.k()));
        contentValues.put("payload_encoding", hVar.e().b().a());
        contentValues.put("code", hVar.d());
        contentValues.put("num_attempts", (Integer) 0);
        contentValues.put(TJAdUnitConstants.String.INLINE, Boolean.valueOf(z));
        contentValues.put("payload", z ? a2 : new byte[0]);
        long insert = sQLiteDatabase.insert("events", null, contentValues);
        if (!z) {
            int ceil = (int) Math.ceil(a2.length / e3);
            for (int i2 = 1; i2 <= ceil; i2++) {
                byte[] copyOfRange = Arrays.copyOfRange(a2, (i2 - 1) * e3, Math.min(i2 * e3, a2.length));
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put(JsonMarshaller.EVENT_ID, Long.valueOf(insert));
                contentValues2.put("sequence_num", Integer.valueOf(i2));
                contentValues2.put("bytes", copyOfRange);
                sQLiteDatabase.insert("event_payloads", null, contentValues2);
            }
        }
        for (Map.Entry<String, String> entry : hVar.i().entrySet()) {
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put(JsonMarshaller.EVENT_ID, Long.valueOf(insert));
            contentValues3.put("name", entry.getKey());
            contentValues3.put(FirebaseAnalytics.Param.VALUE, entry.getValue());
            sQLiteDatabase.insert("event_metadata", null, contentValues3);
        }
        return Long.valueOf(insert);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ byte[] a0(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(0);
            arrayList.add(blob);
            i2 += blob.length;
        }
        byte[] bArr = new byte[i2];
        int i3 = 0;
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            byte[] bArr2 = (byte[]) arrayList.get(i4);
            System.arraycopy(bArr2, 0, bArr, i3, bArr2.length);
            i3 += bArr2.length;
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object b0(String str, SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement(str).execute();
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object c0(long j2, com.google.android.datatransport.runtime.m mVar, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j2));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{mVar.b(), String.valueOf(com.google.android.datatransport.runtime.y.a.a(mVar.d()))}) < 1) {
            contentValues.put("backend_name", mVar.b());
            contentValues.put(Constants.FirelogAnalytics.PARAM_PRIORITY, Integer.valueOf(com.google.android.datatransport.runtime.y.a.a(mVar.d())));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }

    private void d(SQLiteDatabase sQLiteDatabase) {
        h0(q.b(sQLiteDatabase), r.a());
    }

    private List<i> d0(SQLiteDatabase sQLiteDatabase, com.google.android.datatransport.runtime.m mVar) {
        ArrayList arrayList = new ArrayList();
        Long w = w(sQLiteDatabase, mVar);
        if (w == null) {
            return arrayList;
        }
        k0(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", TJAdUnitConstants.String.INLINE}, "context_id = ?", new String[]{w.toString()}, null, null, null, String.valueOf(this.f3429d.d())), n.a(this, arrayList, mVar));
        return arrayList;
    }

    private long e(SQLiteDatabase sQLiteDatabase, com.google.android.datatransport.runtime.m mVar) {
        Long w = w(sQLiteDatabase, mVar);
        if (w != null) {
            return w.longValue();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("backend_name", mVar.b());
        contentValues.put(Constants.FirelogAnalytics.PARAM_PRIORITY, Integer.valueOf(com.google.android.datatransport.runtime.y.a.a(mVar.d())));
        contentValues.put("next_request_ms", (Integer) 0);
        if (mVar.c() != null) {
            contentValues.put("extras", Base64.encodeToString(mVar.c(), 0));
        }
        return sQLiteDatabase.insert("transport_contexts", null, contentValues);
    }

    private Map<Long, Set<c>> e0(SQLiteDatabase sQLiteDatabase, List<i> list) {
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i2 = 0; i2 < list.size(); i2++) {
            sb.append(list.get(i2).c());
            if (i2 < list.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        k0(sQLiteDatabase.query("event_metadata", new String[]{JsonMarshaller.EVENT_ID, "name", FirebaseAnalytics.Param.VALUE}, sb.toString(), null, null, null, null), p.a(hashMap));
        return hashMap;
    }

    private static byte[] f0(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    private byte[] g0(long j2) {
        return (byte[]) k0(t().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j2)}, null, null, "sequence_num"), o.a());
    }

    private long getPageSize() {
        return t().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }

    private <T> T h0(d<T> dVar, b<Throwable, T> bVar) {
        long a2 = this.c.a();
        while (true) {
            try {
                return dVar.a();
            } catch (SQLiteDatabaseLockedException e2) {
                if (this.c.a() >= this.f3429d.b() + a2) {
                    return bVar.apply(e2);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    private static com.google.android.datatransport.b i0(@Nullable String str) {
        if (str == null) {
            return f3428e;
        }
        return com.google.android.datatransport.b.b(str);
    }

    private static String j0(Iterable<i> iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator<i> it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(it.next().c());
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    @VisibleForTesting
    static <T> T k0(Cursor cursor, b<Cursor, T> bVar) {
        try {
            return bVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    private long v() {
        return t().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }

    @Nullable
    private Long w(SQLiteDatabase sQLiteDatabase, com.google.android.datatransport.runtime.m mVar) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(mVar.b(), String.valueOf(com.google.android.datatransport.runtime.y.a.a(mVar.d()))));
        if (mVar.c() != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(mVar.c(), 0));
        } else {
            sb.append(" and extras is null");
        }
        return (Long) k0(sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null), x.a());
    }

    private boolean y() {
        return v() * getPageSize() >= this.f3429d.f();
    }

    private List<i> z(List<i> list, Map<Long, Set<c>> map) {
        ListIterator<i> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            i next = listIterator.next();
            if (map.containsKey(Long.valueOf(next.c()))) {
                h.a l2 = next.b().l();
                for (c cVar : map.get(Long.valueOf(next.c()))) {
                    l2.c(cVar.a, cVar.b);
                }
                listIterator.set(i.a(next.c(), next.d(), l2.d()));
            }
        }
        return list;
    }

    @Override // com.google.android.datatransport.runtime.w.j.c
    public int B() {
        return ((Integer) x(m.a(this.b.a() - this.f3429d.c()))).intValue();
    }

    @Override // com.google.android.datatransport.runtime.w.j.c
    public Iterable<com.google.android.datatransport.runtime.m> G() {
        return (Iterable) x(l.a());
    }

    @Override // com.google.android.datatransport.runtime.w.j.c
    public long I(com.google.android.datatransport.runtime.m mVar) {
        return ((Long) k0(t().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{mVar.b(), String.valueOf(com.google.android.datatransport.runtime.y.a.a(mVar.d()))}), z.a())).longValue();
    }

    @Override // com.google.android.datatransport.runtime.w.j.c
    public boolean J(com.google.android.datatransport.runtime.m mVar) {
        return ((Boolean) x(a0.a(this, mVar))).booleanValue();
    }

    @Override // com.google.android.datatransport.runtime.w.j.c
    public void K(Iterable<i> iterable) {
        if (iterable.iterator().hasNext()) {
            x(y.a("UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + j0(iterable)));
        }
    }

    @Override // com.google.android.datatransport.runtime.w.j.c
    public Iterable<i> L(com.google.android.datatransport.runtime.m mVar) {
        return (Iterable) x(k.a(this, mVar));
    }

    @Override // com.google.android.datatransport.runtime.w.j.c
    @Nullable
    public i M(com.google.android.datatransport.runtime.m mVar, com.google.android.datatransport.runtime.h hVar) {
        com.google.android.datatransport.runtime.u.a.b("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", mVar.d(), hVar.j(), mVar.b());
        long longValue = ((Long) x(w.a(this, mVar, hVar))).longValue();
        if (longValue < 1) {
            return null;
        }
        return i.a(longValue, mVar, hVar);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.a
    public <T> T a(a.InterfaceC0131a<T> interfaceC0131a) {
        SQLiteDatabase t = t();
        d(t);
        try {
            T execute = interfaceC0131a.execute();
            t.setTransactionSuccessful();
            return execute;
        } finally {
            t.endTransaction();
        }
    }

    @Override // com.google.android.datatransport.runtime.w.j.c
    public void c(Iterable<i> iterable) {
        if (iterable.iterator().hasNext()) {
            t().compileStatement("DELETE FROM events WHERE _id in " + j0(iterable)).execute();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.close();
    }

    @Override // com.google.android.datatransport.runtime.w.j.c
    public void f(com.google.android.datatransport.runtime.m mVar, long j2) {
        x(j.a(j2, mVar));
    }

    @VisibleForTesting
    SQLiteDatabase t() {
        h0 h0Var = this.a;
        h0Var.getClass();
        return (SQLiteDatabase) h0(s.b(h0Var), v.a());
    }

    @VisibleForTesting
    <T> T x(b<SQLiteDatabase, T> bVar) {
        SQLiteDatabase t = t();
        t.beginTransaction();
        try {
            T apply = bVar.apply(t);
            t.setTransactionSuccessful();
            return apply;
        } finally {
            t.endTransaction();
        }
    }
}

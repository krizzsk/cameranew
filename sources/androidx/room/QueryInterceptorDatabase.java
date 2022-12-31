package androidx.room;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class QueryInterceptorDatabase implements SupportSQLiteDatabase {
    private final SupportSQLiteDatabase mDelegate;
    private final RoomDatabase.QueryCallback mQueryCallback;
    private final Executor mQueryCallbackExecutor;

    /* JADX INFO: Access modifiers changed from: package-private */
    public QueryInterceptorDatabase(@NonNull SupportSQLiteDatabase supportSQLiteDatabase, @NonNull RoomDatabase.QueryCallback queryCallback, @NonNull Executor executor) {
        this.mDelegate = supportSQLiteDatabase;
        this.mQueryCallback = queryCallback;
        this.mQueryCallbackExecutor = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N */
    public /* synthetic */ void O() {
        this.mQueryCallback.onQuery("END TRANSACTION", Collections.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q */
    public /* synthetic */ void R(String str) {
        this.mQueryCallback.onQuery(str, new ArrayList(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S */
    public /* synthetic */ void T(String str, List list) {
        this.mQueryCallback.onQuery(str, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U */
    public /* synthetic */ void V(String str) {
        this.mQueryCallback.onQuery(str, Collections.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W */
    public /* synthetic */ void X(String str, List list) {
        this.mQueryCallback.onQuery(str, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y */
    public /* synthetic */ void Z(SupportSQLiteQuery supportSQLiteQuery, QueryInterceptorProgram queryInterceptorProgram) {
        this.mQueryCallback.onQuery(supportSQLiteQuery.getSql(), queryInterceptorProgram.getBindArgs());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a0 */
    public /* synthetic */ void b0(SupportSQLiteQuery supportSQLiteQuery, QueryInterceptorProgram queryInterceptorProgram) {
        this.mQueryCallback.onQuery(supportSQLiteQuery.getSql(), queryInterceptorProgram.getBindArgs());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c0 */
    public /* synthetic */ void d0() {
        this.mQueryCallback.onQuery("TRANSACTION SUCCESSFUL", Collections.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void t() {
        this.mQueryCallback.onQuery("BEGIN EXCLUSIVE TRANSACTION", Collections.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public /* synthetic */ void w() {
        this.mQueryCallback.onQuery("BEGIN DEFERRED TRANSACTION", Collections.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public /* synthetic */ void y() {
        this.mQueryCallback.onQuery("BEGIN EXCLUSIVE TRANSACTION", Collections.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public /* synthetic */ void A() {
        this.mQueryCallback.onQuery("BEGIN DEFERRED TRANSACTION", Collections.emptyList());
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransaction() {
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.i0
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.this.t();
            }
        });
        this.mDelegate.beginTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionNonExclusive() {
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.z
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.this.w();
            }
        });
        this.mDelegate.beginTransactionNonExclusive();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListener(@NonNull SQLiteTransactionListener sQLiteTransactionListener) {
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.j0
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.this.y();
            }
        });
        this.mDelegate.beginTransactionWithListener(sQLiteTransactionListener);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListenerNonExclusive(@NonNull SQLiteTransactionListener sQLiteTransactionListener) {
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.c0
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.this.A();
            }
        });
        this.mDelegate.beginTransactionWithListenerNonExclusive(sQLiteTransactionListener);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mDelegate.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @NonNull
    public SupportSQLiteStatement compileStatement(@NonNull String str) {
        return new QueryInterceptorStatement(this.mDelegate.compileStatement(str), this.mQueryCallback, str, this.mQueryCallbackExecutor);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int delete(@NonNull String str, @NonNull String str2, @NonNull Object[] objArr) {
        return this.mDelegate.delete(str, str2, objArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @RequiresApi(api = 16)
    public void disableWriteAheadLogging() {
        this.mDelegate.disableWriteAheadLogging();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean enableWriteAheadLogging() {
        return this.mDelegate.enableWriteAheadLogging();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void endTransaction() {
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.y
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.this.O();
            }
        });
        this.mDelegate.endTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public /* synthetic */ void execPerConnectionSQL(String str, Object[] objArr) {
        androidx.sqlite.db.a.$default$execPerConnectionSQL(this, str, objArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(@NonNull final String str) throws SQLException {
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.d0
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.this.R(str);
            }
        });
        this.mDelegate.execSQL(str);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @NonNull
    public List<Pair<String, String>> getAttachedDbs() {
        return this.mDelegate.getAttachedDbs();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getMaximumSize() {
        return this.mDelegate.getMaximumSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getPageSize() {
        return this.mDelegate.getPageSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @NonNull
    public String getPath() {
        return this.mDelegate.getPath();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int getVersion() {
        return this.mDelegate.getVersion();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean inTransaction() {
        return this.mDelegate.inTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long insert(@NonNull String str, int i2, @NonNull ContentValues contentValues) throws SQLException {
        return this.mDelegate.insert(str, i2, contentValues);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDatabaseIntegrityOk() {
        return this.mDelegate.isDatabaseIntegrityOk();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDbLockedByCurrentThread() {
        return this.mDelegate.isDbLockedByCurrentThread();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public /* synthetic */ boolean isExecPerConnectionSQLSupported() {
        return androidx.sqlite.db.a.$default$isExecPerConnectionSQLSupported(this);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isOpen() {
        return this.mDelegate.isOpen();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isReadOnly() {
        return this.mDelegate.isReadOnly();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @RequiresApi(api = 16)
    public boolean isWriteAheadLoggingEnabled() {
        return this.mDelegate.isWriteAheadLoggingEnabled();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean needUpgrade(int i2) {
        return this.mDelegate.needUpgrade(i2);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @NonNull
    public Cursor query(@NonNull final String str) {
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.f0
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.this.V(str);
            }
        });
        return this.mDelegate.query(str);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @RequiresApi(api = 16)
    public void setForeignKeyConstraintsEnabled(boolean z) {
        this.mDelegate.setForeignKeyConstraintsEnabled(z);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setLocale(@NonNull Locale locale) {
        this.mDelegate.setLocale(locale);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setMaxSqlCacheSize(int i2) {
        this.mDelegate.setMaxSqlCacheSize(i2);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long setMaximumSize(long j2) {
        return this.mDelegate.setMaximumSize(j2);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setPageSize(long j2) {
        this.mDelegate.setPageSize(j2);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setTransactionSuccessful() {
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.a0
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.this.d0();
            }
        });
        this.mDelegate.setTransactionSuccessful();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setVersion(int i2) {
        this.mDelegate.setVersion(i2);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int update(@NonNull String str, int i2, @NonNull ContentValues contentValues, @NonNull String str2, @NonNull Object[] objArr) {
        return this.mDelegate.update(str, i2, contentValues, str2, objArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely() {
        return this.mDelegate.yieldIfContendedSafely();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely(long j2) {
        return this.mDelegate.yieldIfContendedSafely(j2);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(@NonNull final String str, @NonNull Object[] objArr) throws SQLException {
        final ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(objArr));
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.b0
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.this.T(str, arrayList);
            }
        });
        this.mDelegate.execSQL(str, arrayList.toArray());
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @NonNull
    public Cursor query(@NonNull final String str, @NonNull Object[] objArr) {
        final ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(objArr));
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.g0
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.this.X(str, arrayList);
            }
        });
        return this.mDelegate.query(str, objArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @NonNull
    public Cursor query(@NonNull final SupportSQLiteQuery supportSQLiteQuery) {
        final QueryInterceptorProgram queryInterceptorProgram = new QueryInterceptorProgram();
        supportSQLiteQuery.bindTo(queryInterceptorProgram);
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.e0
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.this.Z(supportSQLiteQuery, queryInterceptorProgram);
            }
        });
        return this.mDelegate.query(supportSQLiteQuery);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @NonNull
    public Cursor query(@NonNull final SupportSQLiteQuery supportSQLiteQuery, @NonNull CancellationSignal cancellationSignal) {
        final QueryInterceptorProgram queryInterceptorProgram = new QueryInterceptorProgram();
        supportSQLiteQuery.bindTo(queryInterceptorProgram);
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.h0
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.this.b0(supportSQLiteQuery, queryInterceptorProgram);
            }
        });
        return this.mDelegate.query(supportSQLiteQuery);
    }
}

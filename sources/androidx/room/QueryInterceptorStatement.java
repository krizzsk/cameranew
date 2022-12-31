package androidx.room;

import androidx.annotation.NonNull;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class QueryInterceptorStatement implements SupportSQLiteStatement {
    private final List<Object> mBindArgsCache = new ArrayList();
    private final SupportSQLiteStatement mDelegate;
    private final RoomDatabase.QueryCallback mQueryCallback;
    private final Executor mQueryCallbackExecutor;
    private final String mSqlStatement;

    /* JADX INFO: Access modifiers changed from: package-private */
    public QueryInterceptorStatement(@NonNull SupportSQLiteStatement supportSQLiteStatement, @NonNull RoomDatabase.QueryCallback queryCallback, String str, @NonNull Executor executor) {
        this.mDelegate = supportSQLiteStatement;
        this.mQueryCallback = queryCallback;
        this.mSqlStatement = str;
        this.mQueryCallbackExecutor = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N */
    public /* synthetic */ void O() {
        this.mQueryCallback.onQuery(this.mSqlStatement, this.mBindArgsCache);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void t() {
        this.mQueryCallback.onQuery(this.mSqlStatement, this.mBindArgsCache);
    }

    private void saveArgsToCache(int i2, Object obj) {
        int i3 = i2 - 1;
        if (i3 >= this.mBindArgsCache.size()) {
            for (int size = this.mBindArgsCache.size(); size <= i3; size++) {
                this.mBindArgsCache.add(null);
            }
        }
        this.mBindArgsCache.set(i3, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public /* synthetic */ void w() {
        this.mQueryCallback.onQuery(this.mSqlStatement, this.mBindArgsCache);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public /* synthetic */ void y() {
        this.mQueryCallback.onQuery(this.mSqlStatement, this.mBindArgsCache);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public /* synthetic */ void A() {
        this.mQueryCallback.onQuery(this.mSqlStatement, this.mBindArgsCache);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int i2, byte[] bArr) {
        saveArgsToCache(i2, bArr);
        this.mDelegate.bindBlob(i2, bArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int i2, double d2) {
        saveArgsToCache(i2, Double.valueOf(d2));
        this.mDelegate.bindDouble(i2, d2);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int i2, long j2) {
        saveArgsToCache(i2, Long.valueOf(j2));
        this.mDelegate.bindLong(i2, j2);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int i2) {
        saveArgsToCache(i2, this.mBindArgsCache.toArray());
        this.mDelegate.bindNull(i2);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int i2, String str) {
        saveArgsToCache(i2, str);
        this.mDelegate.bindString(i2, str);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        this.mBindArgsCache.clear();
        this.mDelegate.clearBindings();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mDelegate.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public void execute() {
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.l0
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorStatement.this.t();
            }
        });
        this.mDelegate.execute();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long executeInsert() {
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.m0
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorStatement.this.w();
            }
        });
        return this.mDelegate.executeInsert();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public int executeUpdateDelete() {
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.n0
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorStatement.this.y();
            }
        });
        return this.mDelegate.executeUpdateDelete();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long simpleQueryForLong() {
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.o0
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorStatement.this.A();
            }
        });
        return this.mDelegate.simpleQueryForLong();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public String simpleQueryForString() {
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.k0
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorStatement.this.O();
            }
        });
        return this.mDelegate.simpleQueryForString();
    }
}

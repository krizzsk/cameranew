package com.facebook.common.statfs;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import com.facebook.common.internal.m;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes.dex */
public class StatFsHelper {

    /* renamed from: h  reason: collision with root package name */
    private static StatFsHelper f2414h;

    /* renamed from: i  reason: collision with root package name */
    private static final long f2415i = TimeUnit.MINUTES.toMillis(2);
    @Nullable
    private volatile File b;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private volatile File f2416d;
    @GuardedBy("lock")

    /* renamed from: e  reason: collision with root package name */
    private long f2417e;
    @Nullable
    private volatile StatFs a = null;
    @Nullable
    private volatile StatFs c = null;

    /* renamed from: g  reason: collision with root package name */
    private volatile boolean f2419g = false;

    /* renamed from: f  reason: collision with root package name */
    private final Lock f2418f = new ReentrantLock();

    /* loaded from: classes.dex */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    protected StatFsHelper() {
    }

    protected static StatFs a(String str) {
        return new StatFs(str);
    }

    private void b() {
        if (this.f2419g) {
            return;
        }
        this.f2418f.lock();
        try {
            if (!this.f2419g) {
                this.b = Environment.getDataDirectory();
                this.f2416d = Environment.getExternalStorageDirectory();
                f();
                this.f2419g = true;
            }
        } finally {
            this.f2418f.unlock();
        }
    }

    private void d() {
        if (this.f2418f.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.f2417e > f2415i) {
                    f();
                }
            } finally {
                this.f2418f.unlock();
            }
        }
    }

    @GuardedBy("lock")
    private void f() {
        this.a = g(this.a, this.b);
        this.c = g(this.c, this.f2416d);
        this.f2417e = SystemClock.uptimeMillis();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.os.StatFs] */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.os.StatFs] */
    /* JADX WARN: Type inference failed for: r0v4 */
    @Nullable
    private StatFs g(@Nullable StatFs statFs, @Nullable File file) {
        ?? r0 = 0;
        r0 = 0;
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (statFs == null) {
                statFs = a(file.getAbsolutePath());
            } else {
                statFs.restat(file.getAbsolutePath());
            }
            r0 = statFs;
            return r0;
        } catch (IllegalArgumentException unused) {
            return r0;
        } catch (Throwable th) {
            m.a(th);
            throw r0;
        }
    }

    public static synchronized StatFsHelper getInstance() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (f2414h == null) {
                f2414h = new StatFsHelper();
            }
            statFsHelper = f2414h;
        }
        return statFsHelper;
    }

    @SuppressLint({"DeprecatedMethod"})
    public long c(StorageType storageType) {
        long blockSize;
        long availableBlocks;
        b();
        d();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.a : this.c;
        if (statFs != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                blockSize = statFs.getBlockSizeLong();
                availableBlocks = statFs.getAvailableBlocksLong();
            } else {
                blockSize = statFs.getBlockSize();
                availableBlocks = statFs.getAvailableBlocks();
            }
            return blockSize * availableBlocks;
        }
        return 0L;
    }

    public boolean e(StorageType storageType, long j2) {
        b();
        long c = c(storageType);
        return c <= 0 || c < j2;
    }
}

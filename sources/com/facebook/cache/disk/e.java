package com.facebook.cache.disk;

import androidx.annotation.VisibleForTesting;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.disk.c;
import com.facebook.common.file.FileUtils;
import com.facebook.common.internal.k;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import javax.annotation.Nullable;
/* compiled from: DynamicDefaultDiskStorage.java */
/* loaded from: classes.dex */
public class e implements c {

    /* renamed from: f  reason: collision with root package name */
    private static final Class<?> f2388f = e.class;
    private final int a;
    private final k<File> b;
    private final String c;

    /* renamed from: d  reason: collision with root package name */
    private final CacheErrorLogger f2389d;
    @VisibleForTesting

    /* renamed from: e  reason: collision with root package name */
    volatile a f2390e = new a(null, null);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DynamicDefaultDiskStorage.java */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class a {
        @Nullable
        public final c a;
        @Nullable
        public final File b;

        @VisibleForTesting
        a(@Nullable File file, @Nullable c cVar) {
            this.a = cVar;
            this.b = file;
        }
    }

    public e(int i2, k<File> kVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.a = i2;
        this.f2389d = cacheErrorLogger;
        this.b = kVar;
        this.c = str;
    }

    private void i() throws IOException {
        File file = new File(this.b.get(), this.c);
        h(file);
        this.f2390e = new a(file, new DefaultDiskStorage(file, this.a, this.f2389d));
    }

    private boolean l() {
        File file;
        a aVar = this.f2390e;
        return aVar.a == null || (file = aVar.b) == null || !file.exists();
    }

    @Override // com.facebook.cache.disk.c
    public void a() {
        try {
            k().a();
        } catch (IOException e2) {
            com.facebook.common.logging.a.e(f2388f, "purgeUnexpectedResources", e2);
        }
    }

    @Override // com.facebook.cache.disk.c
    public boolean b(String str, Object obj) throws IOException {
        return k().b(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public long c(c.a aVar) throws IOException {
        return k().c(aVar);
    }

    @Override // com.facebook.cache.disk.c
    public c.b d(String str, Object obj) throws IOException {
        return k().d(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean e(String str, Object obj) throws IOException {
        return k().e(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    @Nullable
    public com.facebook.binaryresource.a f(String str, Object obj) throws IOException {
        return k().f(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> g() throws IOException {
        return k().g();
    }

    @VisibleForTesting
    void h(File file) throws IOException {
        try {
            FileUtils.a(file);
            com.facebook.common.logging.a.a(f2388f, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e2) {
            this.f2389d.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, f2388f, "createRootDirectoryIfNecessary", e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return k().isExternal();
        } catch (IOException unused) {
            return false;
        }
    }

    @VisibleForTesting
    void j() {
        if (this.f2390e.a == null || this.f2390e.b == null) {
            return;
        }
        com.facebook.common.file.a.b(this.f2390e.b);
    }

    @VisibleForTesting
    synchronized c k() throws IOException {
        c cVar;
        if (l()) {
            j();
            i();
        }
        cVar = this.f2390e.a;
        com.facebook.common.internal.h.g(cVar);
        return cVar;
    }

    @Override // com.facebook.cache.disk.c
    public long remove(String str) throws IOException {
        return k().remove(str);
    }
}

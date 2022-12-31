package com.facebook.cache.disk;

import android.os.Environment;
import androidx.annotation.VisibleForTesting;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.disk.c;
import com.facebook.common.file.FileUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* loaded from: classes.dex */
public class DefaultDiskStorage implements com.facebook.cache.disk.c {

    /* renamed from: f  reason: collision with root package name */
    private static final Class<?> f2356f = DefaultDiskStorage.class;

    /* renamed from: g  reason: collision with root package name */
    static final long f2357g = TimeUnit.MINUTES.toMillis(30);
    private final File a;
    private final boolean b;
    private final File c;

    /* renamed from: d  reason: collision with root package name */
    private final CacheErrorLogger f2358d;

    /* renamed from: e  reason: collision with root package name */
    private final com.facebook.common.time.a f2359e;

    /* loaded from: classes.dex */
    private static class IncompleteFileException extends IOException {
        public IncompleteFileException(long j2, long j3) {
            super("File was not written completely. Expected: " + j2 + ", found: " + j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements com.facebook.common.file.b {
        private final List<c.a> a;

        private b() {
            this.a = new ArrayList();
        }

        @Override // com.facebook.common.file.b
        public void a(File file) {
        }

        @Override // com.facebook.common.file.b
        public void b(File file) {
            d t = DefaultDiskStorage.this.t(file);
            if (t == null || t.a != ".cnt") {
                return;
            }
            this.a.add(new c(t.b, file));
        }

        @Override // com.facebook.common.file.b
        public void c(File file) {
        }

        public List<c.a> d() {
            return Collections.unmodifiableList(this.a);
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    static class c implements c.a {
        private final String a;
        private final com.facebook.binaryresource.b b;
        private long c;

        /* renamed from: d  reason: collision with root package name */
        private long f2360d;

        @Override // com.facebook.cache.disk.c.a
        public long a() {
            if (this.f2360d < 0) {
                this.f2360d = this.b.d().lastModified();
            }
            return this.f2360d;
        }

        public com.facebook.binaryresource.b b() {
            return this.b;
        }

        @Override // com.facebook.cache.disk.c.a
        public String getId() {
            return this.a;
        }

        @Override // com.facebook.cache.disk.c.a
        public long getSize() {
            if (this.c < 0) {
                this.c = this.b.size();
            }
            return this.c;
        }

        private c(String str, File file) {
            com.facebook.common.internal.h.g(file);
            com.facebook.common.internal.h.g(str);
            this.a = str;
            this.b = com.facebook.binaryresource.b.b(file);
            this.c = -1L;
            this.f2360d = -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d {
        public final String a;
        public final String b;

        @Nullable
        public static d b(File file) {
            String r;
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf > 0 && (r = DefaultDiskStorage.r(name.substring(lastIndexOf))) != null) {
                String substring = name.substring(0, lastIndexOf);
                if (r.equals(".tmp")) {
                    int lastIndexOf2 = substring.lastIndexOf(46);
                    if (lastIndexOf2 <= 0) {
                        return null;
                    }
                    substring = substring.substring(0, lastIndexOf2);
                }
                return new d(r, substring);
            }
            return null;
        }

        public File a(File file) throws IOException {
            return File.createTempFile(this.b + ".", ".tmp", file);
        }

        public String c(String str) {
            return str + File.separator + this.b + this.a;
        }

        public String toString() {
            return this.a + "(" + this.b + ")";
        }

        private d(String str, String str2) {
            this.a = str;
            this.b = str2;
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    class e implements c.b {
        private final String a;
        @VisibleForTesting
        final File b;

        public e(String str, File file) {
            this.a = str;
            this.b = file;
        }

        @Override // com.facebook.cache.disk.c.b
        public boolean B() {
            return !this.b.exists() || this.b.delete();
        }

        @Override // com.facebook.cache.disk.c.b
        public void C(com.facebook.cache.common.f fVar, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.b);
                try {
                    com.facebook.common.internal.c cVar = new com.facebook.common.internal.c(fileOutputStream);
                    fVar.a(cVar);
                    cVar.flush();
                    long d2 = cVar.d();
                    fileOutputStream.close();
                    if (this.b.length() != d2) {
                        throw new IncompleteFileException(d2, this.b.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e2) {
                DefaultDiskStorage.this.f2358d.a(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, DefaultDiskStorage.f2356f, "updateResource", e2);
                throw e2;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public com.facebook.binaryresource.a D(Object obj) throws IOException {
            return a(obj, DefaultDiskStorage.this.f2359e.now());
        }

        public com.facebook.binaryresource.a a(Object obj, long j2) throws IOException {
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            File p = DefaultDiskStorage.this.p(this.a);
            try {
                FileUtils.b(this.b, p);
                if (p.exists()) {
                    p.setLastModified(j2);
                }
                return com.facebook.binaryresource.b.b(p);
            } catch (FileUtils.RenameException e2) {
                Throwable cause = e2.getCause();
                if (cause != null) {
                    if (!(cause instanceof FileUtils.ParentDirNotFoundException)) {
                        if (cause instanceof FileNotFoundException) {
                            cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND;
                        } else {
                            cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_OTHER;
                        }
                    } else {
                        cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND;
                    }
                } else {
                    cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_OTHER;
                }
                DefaultDiskStorage.this.f2358d.a(cacheErrorCategory, DefaultDiskStorage.f2356f, "commit", e2);
                throw e2;
            }
        }
    }

    /* loaded from: classes.dex */
    private class f implements com.facebook.common.file.b {
        private boolean a;

        private f() {
        }

        private boolean d(File file) {
            d t = DefaultDiskStorage.this.t(file);
            if (t == null) {
                return false;
            }
            String str = t.a;
            if (str == ".tmp") {
                return e(file);
            }
            com.facebook.common.internal.h.i(str == ".cnt");
            return true;
        }

        private boolean e(File file) {
            return file.lastModified() > DefaultDiskStorage.this.f2359e.now() - DefaultDiskStorage.f2357g;
        }

        @Override // com.facebook.common.file.b
        public void a(File file) {
            if (!DefaultDiskStorage.this.a.equals(file) && !this.a) {
                file.delete();
            }
            if (this.a && file.equals(DefaultDiskStorage.this.c)) {
                this.a = false;
            }
        }

        @Override // com.facebook.common.file.b
        public void b(File file) {
            if (this.a && d(file)) {
                return;
            }
            file.delete();
        }

        @Override // com.facebook.common.file.b
        public void c(File file) {
            if (this.a || !file.equals(DefaultDiskStorage.this.c)) {
                return;
            }
            this.a = true;
        }
    }

    public DefaultDiskStorage(File file, int i2, CacheErrorLogger cacheErrorLogger) {
        com.facebook.common.internal.h.g(file);
        this.a = file;
        this.b = x(file, cacheErrorLogger);
        this.c = new File(file, w(i2));
        this.f2358d = cacheErrorLogger;
        A();
        this.f2359e = com.facebook.common.time.c.a();
    }

    private void A() {
        boolean z = true;
        if (this.a.exists()) {
            if (this.c.exists()) {
                z = false;
            } else {
                com.facebook.common.file.a.b(this.a);
            }
        }
        if (z) {
            try {
                FileUtils.a(this.c);
            } catch (FileUtils.CreateDirectoryException unused) {
                CacheErrorLogger cacheErrorLogger = this.f2358d;
                CacheErrorLogger.CacheErrorCategory cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR;
                Class<?> cls = f2356f;
                cacheErrorLogger.a(cacheErrorCategory, cls, "version directory could not be created: " + this.c, null);
            }
        }
    }

    private long o(File file) {
        if (file.exists()) {
            long length = file.length();
            if (file.delete()) {
                return length;
            }
            return -1L;
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static String r(String str) {
        if (".cnt".equals(str)) {
            return ".cnt";
        }
        if (".tmp".equals(str)) {
            return ".tmp";
        }
        return null;
    }

    private String s(String str) {
        d dVar = new d(".cnt", str);
        return dVar.c(v(dVar.b));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public d t(File file) {
        d b2 = d.b(file);
        if (b2 != null && u(b2.b).equals(file.getParentFile())) {
            return b2;
        }
        return null;
    }

    private File u(String str) {
        return new File(v(str));
    }

    private String v(String str) {
        String valueOf = String.valueOf(Math.abs(str.hashCode() % 100));
        return this.c + File.separator + valueOf;
    }

    @VisibleForTesting
    static String w(int i2) {
        return String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i2));
    }

    private static boolean x(File file, CacheErrorLogger cacheErrorLogger) {
        try {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory != null) {
                try {
                } catch (IOException e2) {
                    e = e2;
                }
                try {
                    return file.getCanonicalPath().contains(externalStorageDirectory.toString());
                } catch (IOException e3) {
                    e = e3;
                    CacheErrorLogger.CacheErrorCategory cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.OTHER;
                    Class<?> cls = f2356f;
                    cacheErrorLogger.a(cacheErrorCategory, cls, "failed to read folder to check if external: " + ((String) null), e);
                    return false;
                }
            }
            return false;
        } catch (Exception e4) {
            cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, f2356f, "failed to get the external storage directory!", e4);
            return false;
        }
    }

    private void y(File file, String str) throws IOException {
        try {
            FileUtils.a(file);
        } catch (FileUtils.CreateDirectoryException e2) {
            this.f2358d.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, f2356f, str, e2);
            throw e2;
        }
    }

    private boolean z(String str, boolean z) {
        File p = p(str);
        boolean exists = p.exists();
        if (z && exists) {
            p.setLastModified(this.f2359e.now());
        }
        return exists;
    }

    @Override // com.facebook.cache.disk.c
    public void a() {
        com.facebook.common.file.a.c(this.a, new f());
    }

    @Override // com.facebook.cache.disk.c
    public boolean b(String str, Object obj) {
        return z(str, true);
    }

    @Override // com.facebook.cache.disk.c
    public long c(c.a aVar) {
        return o(((c) aVar).b().d());
    }

    @Override // com.facebook.cache.disk.c
    public c.b d(String str, Object obj) throws IOException {
        d dVar = new d(".tmp", str);
        File u = u(dVar.b);
        if (!u.exists()) {
            y(u, "insert");
        }
        try {
            return new e(str, dVar.a(u));
        } catch (IOException e2) {
            this.f2358d.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, f2356f, "insert", e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public boolean e(String str, Object obj) {
        return z(str, false);
    }

    @Override // com.facebook.cache.disk.c
    @Nullable
    public com.facebook.binaryresource.a f(String str, Object obj) {
        File p = p(str);
        if (p.exists()) {
            p.setLastModified(this.f2359e.now());
            return com.facebook.binaryresource.b.c(p);
        }
        return null;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        return this.b;
    }

    @VisibleForTesting
    File p(String str) {
        return new File(s(str));
    }

    @Override // com.facebook.cache.disk.c
    /* renamed from: q */
    public List<c.a> g() throws IOException {
        b bVar = new b();
        com.facebook.common.file.a.c(this.c, bVar);
        return bVar.d();
    }

    @Override // com.facebook.cache.disk.c
    public long remove(String str) {
        return o(p(str));
    }
}

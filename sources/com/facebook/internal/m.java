package com.facebook.internal;

import com.facebook.LoggingBehavior;
import com.tencent.matrix.report.Issue;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
/* compiled from: FileLruCache.java */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: g  reason: collision with root package name */
    static final String f3071g = "m";

    /* renamed from: h  reason: collision with root package name */
    private static final AtomicLong f3072h = new AtomicLong();
    private final String a;
    private final f b;
    private final File c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3073d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f3074e;

    /* renamed from: f  reason: collision with root package name */
    private AtomicLong f3075f = new AtomicLong(0);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FileLruCache.java */
    /* loaded from: classes.dex */
    public class a implements h {
        final /* synthetic */ long a;
        final /* synthetic */ File b;
        final /* synthetic */ String c;

        a(long j2, File file, String str) {
            this.a = j2;
            this.b = file;
            this.c = str;
        }

        @Override // com.facebook.internal.m.h
        public void onClose() {
            if (this.a >= m.this.f3075f.get()) {
                m.this.k(this.c, this.b);
            } else {
                this.b.delete();
            }
        }
    }

    /* compiled from: FileLruCache.java */
    /* loaded from: classes.dex */
    class b implements Runnable {
        final /* synthetic */ File[] a;

        b(m mVar, File[] fileArr) {
            this.a = fileArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                for (File file : this.a) {
                    file.delete();
                }
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FileLruCache.java */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                m.this.l();
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FileLruCache.java */
    /* loaded from: classes.dex */
    public static class d {
        private static final FilenameFilter a = new a();
        private static final FilenameFilter b = new b();

        /* compiled from: FileLruCache.java */
        /* loaded from: classes.dex */
        static class a implements FilenameFilter {
            a() {
            }

            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return !str.startsWith("buffer");
            }
        }

        /* compiled from: FileLruCache.java */
        /* loaded from: classes.dex */
        static class b implements FilenameFilter {
            b() {
            }

            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.startsWith("buffer");
            }
        }

        static void a(File file) {
            File[] listFiles = file.listFiles(c());
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    file2.delete();
                }
            }
        }

        static FilenameFilter b() {
            return a;
        }

        static FilenameFilter c() {
            return b;
        }

        static File d(File file) {
            return new File(file, "buffer" + Long.valueOf(m.f3072h.incrementAndGet()).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FileLruCache.java */
    /* loaded from: classes.dex */
    public static class e extends OutputStream {
        final OutputStream a;
        final h b;

        e(OutputStream outputStream, h hVar) {
            this.a = outputStream;
            this.b = hVar;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                this.a.close();
            } finally {
                this.b.onClose();
            }
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.a.flush();
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i2, int i3) throws IOException {
            this.a.write(bArr, i2, i3);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.a.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(int i2) throws IOException {
            this.a.write(i2);
        }
    }

    /* compiled from: FileLruCache.java */
    /* loaded from: classes.dex */
    public static final class f {
        private int b = 1024;
        private int a = 1048576;

        int a() {
            return this.a;
        }

        int b() {
            return this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FileLruCache.java */
    /* loaded from: classes.dex */
    public static final class g implements Comparable<g> {
        private final File a;
        private final long b;

        g(File file) {
            this.a = file;
            this.b = file.lastModified();
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(g gVar) {
            if (c() < gVar.c()) {
                return -1;
            }
            if (c() > gVar.c()) {
                return 1;
            }
            return b().compareTo(gVar.b());
        }

        File b() {
            return this.a;
        }

        long c() {
            return this.b;
        }

        public boolean equals(Object obj) {
            return (obj instanceof g) && compareTo((g) obj) == 0;
        }

        public int hashCode() {
            return ((1073 + this.a.hashCode()) * 37) + ((int) (this.b % 2147483647L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FileLruCache.java */
    /* loaded from: classes.dex */
    public interface h {
        void onClose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FileLruCache.java */
    /* loaded from: classes.dex */
    public static final class i {
        static JSONObject a(InputStream inputStream) throws IOException {
            if (inputStream.read() != 0) {
                return null;
            }
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < 3; i4++) {
                int read = inputStream.read();
                if (read == -1) {
                    r.g(LoggingBehavior.CACHE, m.f3071g, "readHeader: stream.read returned -1 while reading header size");
                    return null;
                }
                i3 = (i3 << 8) + (read & 255);
            }
            byte[] bArr = new byte[i3];
            while (i2 < i3) {
                int read2 = inputStream.read(bArr, i2, i3 - i2);
                if (read2 < 1) {
                    LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                    String str = m.f3071g;
                    r.g(loggingBehavior, str, "readHeader: stream.read stopped at " + Integer.valueOf(i2) + " when expected " + i3);
                    return null;
                }
                i2 += read2;
            }
            try {
                Object nextValue = new JSONTokener(new String(bArr)).nextValue();
                if (!(nextValue instanceof JSONObject)) {
                    LoggingBehavior loggingBehavior2 = LoggingBehavior.CACHE;
                    String str2 = m.f3071g;
                    r.g(loggingBehavior2, str2, "readHeader: expected JSONObject, got " + nextValue.getClass().getCanonicalName());
                    return null;
                }
                return (JSONObject) nextValue;
            } catch (JSONException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        static void b(OutputStream outputStream, JSONObject jSONObject) throws IOException {
            byte[] bytes = jSONObject.toString().getBytes();
            outputStream.write(0);
            outputStream.write((bytes.length >> 16) & 255);
            outputStream.write((bytes.length >> 8) & 255);
            outputStream.write((bytes.length >> 0) & 255);
            outputStream.write(bytes);
        }
    }

    public m(String str, f fVar) {
        this.a = str;
        this.b = fVar;
        File file = new File(com.facebook.f.l(), str);
        this.c = file;
        this.f3074e = new Object();
        if (file.mkdirs() || file.isDirectory()) {
            d.a(file);
        }
    }

    private void j() {
        synchronized (this.f3074e) {
            if (!this.f3073d) {
                this.f3073d = true;
                com.facebook.f.p().execute(new c());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, File file) {
        if (!file.renameTo(new File(this.c, x.c0(str)))) {
            file.delete();
        }
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        int i2;
        long j2;
        g gVar;
        synchronized (this.f3074e) {
            this.f3073d = false;
        }
        try {
            r.g(LoggingBehavior.CACHE, f3071g, "trim started");
            PriorityQueue priorityQueue = new PriorityQueue();
            File[] listFiles = this.c.listFiles(d.b());
            long j3 = 0;
            if (listFiles != null) {
                j2 = 0;
                for (File file : listFiles) {
                    priorityQueue.add(new g(file));
                    r.g(LoggingBehavior.CACHE, f3071g, "  trim considering time=" + Long.valueOf(gVar.c()) + " name=" + gVar.b().getName());
                    j3 += file.length();
                    j2++;
                }
            } else {
                j2 = 0;
            }
            while (true) {
                if (j3 <= this.b.a() && j2 <= this.b.b()) {
                    synchronized (this.f3074e) {
                        this.f3074e.notifyAll();
                    }
                    return;
                }
                File b2 = ((g) priorityQueue.remove()).b();
                r.g(LoggingBehavior.CACHE, f3071g, "  trim removing " + b2.getName());
                j3 -= b2.length();
                j2--;
                b2.delete();
            }
        } catch (Throwable th) {
            synchronized (this.f3074e) {
                this.f3074e.notifyAll();
                throw th;
            }
        }
    }

    public void e() {
        File[] listFiles = this.c.listFiles(d.b());
        this.f3075f.set(System.currentTimeMillis());
        if (listFiles != null) {
            com.facebook.f.p().execute(new b(this, listFiles));
        }
    }

    public InputStream f(String str) throws IOException {
        return g(str, null);
    }

    public InputStream g(String str, String str2) throws IOException {
        File file = new File(this.c, x.c0(str));
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 8192);
            try {
                JSONObject a2 = i.a(bufferedInputStream);
                if (a2 == null) {
                    return null;
                }
                String optString = a2.optString("key");
                if (optString != null && optString.equals(str)) {
                    String optString2 = a2.optString(Issue.ISSUE_REPORT_TAG, null);
                    if ((str2 != null || optString2 == null) && (str2 == null || str2.equals(optString2))) {
                        long time = new Date().getTime();
                        LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                        String str3 = f3071g;
                        r.g(loggingBehavior, str3, "Setting lastModified to " + Long.valueOf(time) + " for " + file.getName());
                        file.setLastModified(time);
                        return bufferedInputStream;
                    }
                    return null;
                }
                return null;
            } finally {
                bufferedInputStream.close();
            }
        } catch (IOException unused) {
            return null;
        }
    }

    public OutputStream h(String str) throws IOException {
        return i(str, null);
    }

    public OutputStream i(String str, String str2) throws IOException {
        File d2 = d.d(this.c);
        d2.delete();
        if (d2.createNewFile()) {
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new e(new FileOutputStream(d2), new a(System.currentTimeMillis(), d2, str)), 8192);
                try {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("key", str);
                        if (!x.S(str2)) {
                            jSONObject.put(Issue.ISSUE_REPORT_TAG, str2);
                        }
                        i.b(bufferedOutputStream, jSONObject);
                        return bufferedOutputStream;
                    } catch (JSONException e2) {
                        LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                        String str3 = f3071g;
                        r.e(loggingBehavior, 5, str3, "Error creating JSON header for cache file: " + e2);
                        throw new IOException(e2.getMessage());
                    }
                } catch (Throwable th) {
                    bufferedOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e3) {
                LoggingBehavior loggingBehavior2 = LoggingBehavior.CACHE;
                String str4 = f3071g;
                r.e(loggingBehavior2, 5, str4, "Error creating buffer output stream: " + e3);
                throw new IOException(e3.getMessage());
            }
        }
        throw new IOException("Could not create file at " + d2.getAbsolutePath());
    }

    public String toString() {
        return "{FileLruCache: tag:" + this.a + " file:" + this.c.getName() + "}";
    }
}

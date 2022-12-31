package com.bumptech.glide.g;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* compiled from: DiskLruCache.java */
/* loaded from: classes.dex */
public final class a implements Closeable {
    private final File a;
    private final File b;
    private final File c;

    /* renamed from: d  reason: collision with root package name */
    private final File f637d;

    /* renamed from: e  reason: collision with root package name */
    private final int f638e;

    /* renamed from: f  reason: collision with root package name */
    private long f639f;

    /* renamed from: g  reason: collision with root package name */
    private final int f640g;

    /* renamed from: i  reason: collision with root package name */
    private Writer f642i;

    /* renamed from: k  reason: collision with root package name */
    private int f644k;

    /* renamed from: h  reason: collision with root package name */
    private long f641h = 0;

    /* renamed from: j  reason: collision with root package name */
    private final LinkedHashMap<String, c> f643j = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: l  reason: collision with root package name */
    private long f645l = 0;
    final ThreadPoolExecutor m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> n = new CallableC0025a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DiskLruCache.java */
    /* renamed from: com.bumptech.glide.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class CallableC0025a implements Callable<Void> {
        CallableC0025a() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() throws Exception {
            synchronized (a.this) {
                if (a.this.f642i == null) {
                    return null;
                }
                a.this.V();
                if (a.this.A()) {
                    a.this.S();
                    a.this.f644k = 0;
                }
                return null;
            }
        }
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    public final class b {
        private final c a;
        private final boolean[] b;
        private boolean c;

        /* synthetic */ b(a aVar, c cVar, CallableC0025a callableC0025a) {
            this(cVar);
        }

        public void a() throws IOException {
            a.this.u(this, false);
        }

        public void b() {
            if (this.c) {
                return;
            }
            try {
                a();
            } catch (IOException unused) {
            }
        }

        public void e() throws IOException {
            a.this.u(this, true);
            this.c = true;
        }

        public File f(int i2) throws IOException {
            File k2;
            synchronized (a.this) {
                if (this.a.f649f == this) {
                    if (!this.a.f648e) {
                        this.b[i2] = true;
                    }
                    k2 = this.a.k(i2);
                    if (!a.this.a.exists()) {
                        a.this.a.mkdirs();
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
            return k2;
        }

        private b(c cVar) {
            this.a = cVar;
            this.b = cVar.f648e ? null : new boolean[a.this.f640g];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    public final class c {
        private final String a;
        private final long[] b;
        File[] c;

        /* renamed from: d  reason: collision with root package name */
        File[] f647d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f648e;

        /* renamed from: f  reason: collision with root package name */
        private b f649f;

        /* renamed from: g  reason: collision with root package name */
        private long f650g;

        /* synthetic */ c(a aVar, String str, CallableC0025a callableC0025a) {
            this(str);
        }

        private IOException m(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(String[] strArr) throws IOException {
            if (strArr.length == a.this.f640g) {
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    try {
                        this.b[i2] = Long.parseLong(strArr[i2]);
                    } catch (NumberFormatException unused) {
                        m(strArr);
                        throw null;
                    }
                }
                return;
            }
            m(strArr);
            throw null;
        }

        public File j(int i2) {
            return this.c[i2];
        }

        public File k(int i2) {
            return this.f647d[i2];
        }

        public String l() throws IOException {
            long[] jArr;
            StringBuilder sb = new StringBuilder();
            for (long j2 : this.b) {
                sb.append(' ');
                sb.append(j2);
            }
            return sb.toString();
        }

        private c(String str) {
            this.a = str;
            this.b = new long[a.this.f640g];
            this.c = new File[a.this.f640g];
            this.f647d = new File[a.this.f640g];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i2 = 0; i2 < a.this.f640g; i2++) {
                sb.append(i2);
                this.c[i2] = new File(a.this.a, sb.toString());
                sb.append(".tmp");
                this.f647d[i2] = new File(a.this.a, sb.toString());
                sb.setLength(length);
            }
        }
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    public final class d {
        private final File[] a;

        /* synthetic */ d(a aVar, String str, long j2, File[] fileArr, long[] jArr, CallableC0025a callableC0025a) {
            this(aVar, str, j2, fileArr, jArr);
        }

        public File a(int i2) {
            return this.a[i2];
        }

        private d(a aVar, String str, long j2, File[] fileArr, long[] jArr) {
            this.a = fileArr;
        }
    }

    private a(File file, int i2, int i3, long j2) {
        this.a = file;
        this.f638e = i2;
        this.b = new File(file, "journal");
        this.c = new File(file, "journal.tmp");
        this.f637d = new File(file, "journal.bkp");
        this.f640g = i3;
        this.f639f = j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A() {
        int i2 = this.f644k;
        return i2 >= 2000 && i2 >= this.f643j.size();
    }

    public static a N(File file, int i2, int i3, long j2) throws IOException {
        if (j2 > 0) {
            if (i3 > 0) {
                File file2 = new File(file, "journal.bkp");
                if (file2.exists()) {
                    File file3 = new File(file, "journal");
                    if (file3.exists()) {
                        file2.delete();
                    } else {
                        U(file2, file3, false);
                    }
                }
                a aVar = new a(file, i2, i3, j2);
                if (aVar.b.exists()) {
                    try {
                        aVar.Q();
                        aVar.O();
                        return aVar;
                    } catch (IOException e2) {
                        PrintStream printStream = System.out;
                        printStream.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                        aVar.v();
                    }
                }
                file.mkdirs();
                a aVar2 = new a(file, i2, i3, j2);
                aVar2.S();
                return aVar2;
            }
            throw new IllegalArgumentException("valueCount <= 0");
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private void O() throws IOException {
        w(this.c);
        Iterator<c> it = this.f643j.values().iterator();
        while (it.hasNext()) {
            c next = it.next();
            int i2 = 0;
            if (next.f649f != null) {
                next.f649f = null;
                while (i2 < this.f640g) {
                    w(next.j(i2));
                    w(next.k(i2));
                    i2++;
                }
                it.remove();
            } else {
                while (i2 < this.f640g) {
                    this.f641h += next.b[i2];
                    i2++;
                }
            }
        }
    }

    private void Q() throws IOException {
        com.bumptech.glide.g.b bVar = new com.bumptech.glide.g.b(new FileInputStream(this.b), com.bumptech.glide.g.c.a);
        try {
            String v = bVar.v();
            String v2 = bVar.v();
            String v3 = bVar.v();
            String v4 = bVar.v();
            String v5 = bVar.v();
            if (!"libcore.io.DiskLruCache".equals(v) || !"1".equals(v2) || !Integer.toString(this.f638e).equals(v3) || !Integer.toString(this.f640g).equals(v4) || !"".equals(v5)) {
                throw new IOException("unexpected journal header: [" + v + ", " + v2 + ", " + v4 + ", " + v5 + "]");
            }
            int i2 = 0;
            while (true) {
                try {
                    R(bVar.v());
                    i2++;
                } catch (EOFException unused) {
                    this.f644k = i2 - this.f643j.size();
                    if (bVar.t()) {
                        S();
                    } else {
                        this.f642i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.b, true), com.bumptech.glide.g.c.a));
                    }
                    com.bumptech.glide.g.c.a(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.bumptech.glide.g.c.a(bVar);
            throw th;
        }
    }

    private void R(String str) throws IOException {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i2 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i2);
            if (indexOf2 == -1) {
                substring = str.substring(i2);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.f643j.remove(substring);
                    return;
                }
            } else {
                substring = str.substring(i2, indexOf2);
            }
            c cVar = this.f643j.get(substring);
            if (cVar == null) {
                cVar = new c(this, substring, null);
                this.f643j.put(substring, cVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                cVar.f648e = true;
                cVar.f649f = null;
                cVar.n(split);
                return;
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                cVar.f649f = new b(this, cVar, null);
                return;
            } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
                return;
            } else {
                throw new IOException("unexpected journal line: " + str);
            }
        }
        throw new IOException("unexpected journal line: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void S() throws IOException {
        Writer writer = this.f642i;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c), com.bumptech.glide.g.c.a));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f638e));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f640g));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (c cVar : this.f643j.values()) {
            if (cVar.f649f != null) {
                bufferedWriter.write("DIRTY " + cVar.a + '\n');
            } else {
                bufferedWriter.write("CLEAN " + cVar.a + cVar.l() + '\n');
            }
        }
        bufferedWriter.close();
        if (this.b.exists()) {
            U(this.b, this.f637d, true);
        }
        U(this.c, this.b, false);
        this.f637d.delete();
        this.f642i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.b, true), com.bumptech.glide.g.c.a));
    }

    private static void U(File file, File file2, boolean z) throws IOException {
        if (z) {
            w(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() throws IOException {
        while (this.f641h > this.f639f) {
            T(this.f643j.entrySet().iterator().next().getKey());
        }
    }

    private void t() {
        if (this.f642i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void u(b bVar, boolean z) throws IOException {
        c cVar = bVar.a;
        if (cVar.f649f == bVar) {
            if (z && !cVar.f648e) {
                for (int i2 = 0; i2 < this.f640g; i2++) {
                    if (bVar.b[i2]) {
                        if (!cVar.k(i2).exists()) {
                            bVar.a();
                            return;
                        }
                    } else {
                        bVar.a();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                    }
                }
            }
            for (int i3 = 0; i3 < this.f640g; i3++) {
                File k2 = cVar.k(i3);
                if (z) {
                    if (k2.exists()) {
                        File j2 = cVar.j(i3);
                        k2.renameTo(j2);
                        long j3 = cVar.b[i3];
                        long length = j2.length();
                        cVar.b[i3] = length;
                        this.f641h = (this.f641h - j3) + length;
                    }
                } else {
                    w(k2);
                }
            }
            this.f644k++;
            cVar.f649f = null;
            if (cVar.f648e | z) {
                cVar.f648e = true;
                this.f642i.append((CharSequence) "CLEAN");
                this.f642i.append(' ');
                this.f642i.append((CharSequence) cVar.a);
                this.f642i.append((CharSequence) cVar.l());
                this.f642i.append('\n');
                if (z) {
                    long j4 = this.f645l;
                    this.f645l = 1 + j4;
                    cVar.f650g = j4;
                }
            } else {
                this.f643j.remove(cVar.a);
                this.f642i.append((CharSequence) "REMOVE");
                this.f642i.append(' ');
                this.f642i.append((CharSequence) cVar.a);
                this.f642i.append('\n');
            }
            this.f642i.flush();
            if (this.f641h > this.f639f || A()) {
                this.m.submit(this.n);
            }
            return;
        }
        throw new IllegalStateException();
    }

    private static void w(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private synchronized b y(String str, long j2) throws IOException {
        t();
        c cVar = this.f643j.get(str);
        if (j2 == -1 || (cVar != null && cVar.f650g == j2)) {
            if (cVar != null) {
                if (cVar.f649f != null) {
                    return null;
                }
            } else {
                cVar = new c(this, str, null);
                this.f643j.put(str, cVar);
            }
            b bVar = new b(this, cVar, null);
            cVar.f649f = bVar;
            this.f642i.append((CharSequence) "DIRTY");
            this.f642i.append(' ');
            this.f642i.append((CharSequence) str);
            this.f642i.append('\n');
            this.f642i.flush();
            return bVar;
        }
        return null;
    }

    public synchronized boolean T(String str) throws IOException {
        t();
        c cVar = this.f643j.get(str);
        if (cVar != null && cVar.f649f == null) {
            for (int i2 = 0; i2 < this.f640g; i2++) {
                File j2 = cVar.j(i2);
                if (j2.exists() && !j2.delete()) {
                    throw new IOException("failed to delete " + j2);
                }
                this.f641h -= cVar.b[i2];
                cVar.b[i2] = 0;
            }
            this.f644k++;
            this.f642i.append((CharSequence) "REMOVE");
            this.f642i.append(' ');
            this.f642i.append((CharSequence) str);
            this.f642i.append('\n');
            this.f643j.remove(str);
            if (A()) {
                this.m.submit(this.n);
            }
            return true;
        }
        return false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.f642i == null) {
            return;
        }
        Iterator it = new ArrayList(this.f643j.values()).iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.f649f != null) {
                cVar.f649f.a();
            }
        }
        V();
        this.f642i.close();
        this.f642i = null;
    }

    public void v() throws IOException {
        close();
        com.bumptech.glide.g.c.b(this.a);
    }

    public b x(String str) throws IOException {
        return y(str, -1L);
    }

    public synchronized d z(String str) throws IOException {
        t();
        c cVar = this.f643j.get(str);
        if (cVar == null) {
            return null;
        }
        if (cVar.f648e) {
            for (File file : cVar.c) {
                if (!file.exists()) {
                    return null;
                }
            }
            this.f644k++;
            this.f642i.append((CharSequence) "READ");
            this.f642i.append(' ');
            this.f642i.append((CharSequence) str);
            this.f642i.append('\n');
            if (A()) {
                this.m.submit(this.n);
            }
            return new d(this, str, cVar.f650g, cVar.c, cVar.b, null);
        }
        return null;
    }
}

package d.f.a.a.a.c.c;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DiskLruCache.java */
/* loaded from: classes3.dex */
public final class a implements Closeable {
    static final Pattern q = Pattern.compile("[a-z0-9_-]{1,64}");
    private static final OutputStream r = new b();
    private final File a;
    private final File b;
    private final File c;

    /* renamed from: d  reason: collision with root package name */
    private final File f8576d;

    /* renamed from: e  reason: collision with root package name */
    private final int f8577e;

    /* renamed from: f  reason: collision with root package name */
    private long f8578f;

    /* renamed from: g  reason: collision with root package name */
    private int f8579g;

    /* renamed from: h  reason: collision with root package name */
    private final int f8580h;

    /* renamed from: k  reason: collision with root package name */
    private Writer f8583k;
    private int m;

    /* renamed from: i  reason: collision with root package name */
    private long f8581i = 0;

    /* renamed from: j  reason: collision with root package name */
    private int f8582j = 0;

    /* renamed from: l  reason: collision with root package name */
    private final LinkedHashMap<String, d> f8584l = new LinkedHashMap<>(0, 0.75f, true);
    private long n = 0;
    final ThreadPoolExecutor o = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> p = new CallableC0301a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DiskLruCache.java */
    /* renamed from: d.f.a.a.a.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class CallableC0301a implements Callable<Void> {
        CallableC0301a() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() throws Exception {
            synchronized (a.this) {
                if (a.this.f8583k == null) {
                    return null;
                }
                a.this.b0();
                a.this.a0();
                if (a.this.S()) {
                    a.this.X();
                    a.this.m = 0;
                }
                return null;
            }
        }
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: classes3.dex */
    static class b extends OutputStream {
        b() {
        }

        @Override // java.io.OutputStream
        public void write(int i2) throws IOException {
        }
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: classes3.dex */
    public final class c {
        private final d a;
        private final boolean[] b;
        private boolean c;

        /* compiled from: DiskLruCache.java */
        /* renamed from: d.f.a.a.a.c.c.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        private class C0302a extends FilterOutputStream {
            /* synthetic */ C0302a(c cVar, OutputStream outputStream, CallableC0301a callableC0301a) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    c.this.c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    c.this.c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i2) {
                try {
                    ((FilterOutputStream) this).out.write(i2);
                } catch (IOException unused) {
                    c.this.c = true;
                }
            }

            private C0302a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i2, int i3) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i2, i3);
                } catch (IOException unused) {
                    c.this.c = true;
                }
            }
        }

        /* synthetic */ c(a aVar, d dVar, CallableC0301a callableC0301a) {
            this(dVar);
        }

        public void a() throws IOException {
            a.this.z(this, false);
        }

        public void e() throws IOException {
            if (this.c) {
                a.this.z(this, false);
                a.this.Y(this.a.a);
                return;
            }
            a.this.z(this, true);
        }

        public OutputStream f(int i2) throws IOException {
            FileOutputStream fileOutputStream;
            C0302a c0302a;
            synchronized (a.this) {
                if (this.a.f8586d == this) {
                    if (!this.a.c) {
                        this.b[i2] = true;
                    }
                    File k2 = this.a.k(i2);
                    try {
                        fileOutputStream = new FileOutputStream(k2);
                    } catch (FileNotFoundException unused) {
                        a.this.a.mkdirs();
                        try {
                            fileOutputStream = new FileOutputStream(k2);
                        } catch (FileNotFoundException unused2) {
                            return a.r;
                        }
                    }
                    c0302a = new C0302a(this, fileOutputStream, null);
                } else {
                    throw new IllegalStateException();
                }
            }
            return c0302a;
        }

        private c(d dVar) {
            this.a = dVar;
            this.b = dVar.c ? null : new boolean[a.this.f8580h];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DiskLruCache.java */
    /* loaded from: classes3.dex */
    public final class d {
        private final String a;
        private final long[] b;
        private boolean c;

        /* renamed from: d  reason: collision with root package name */
        private c f8586d;

        /* renamed from: e  reason: collision with root package name */
        private long f8587e;

        /* synthetic */ d(a aVar, String str, CallableC0301a callableC0301a) {
            this(str);
        }

        private IOException m(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(String[] strArr) throws IOException {
            if (strArr.length == a.this.f8580h) {
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
            File file = a.this.a;
            return new File(file, this.a + "." + i2);
        }

        public File k(int i2) {
            File file = a.this.a;
            return new File(file, this.a + "." + i2 + ".tmp");
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

        private d(String str) {
            this.a = str;
            this.b = new long[a.this.f8580h];
        }
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: classes3.dex */
    public final class e implements Closeable {
        private File[] a;
        private final InputStream[] b;

        /* synthetic */ e(a aVar, String str, long j2, File[] fileArr, InputStream[] inputStreamArr, long[] jArr, CallableC0301a callableC0301a) {
            this(aVar, str, j2, fileArr, inputStreamArr, jArr);
        }

        public File a(int i2) {
            return this.a[i2];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.b) {
                d.f.a.a.a.c.c.d.a(inputStream);
            }
        }

        private e(a aVar, String str, long j2, File[] fileArr, InputStream[] inputStreamArr, long[] jArr) {
            this.a = fileArr;
            this.b = inputStreamArr;
        }
    }

    private a(File file, int i2, int i3, long j2, int i4) {
        this.a = file;
        this.f8577e = i2;
        this.b = new File(file, "journal");
        this.c = new File(file, "journal.tmp");
        this.f8576d = new File(file, "journal.bkp");
        this.f8580h = i3;
        this.f8578f = j2;
        this.f8579g = i4;
    }

    private static void N(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private synchronized c Q(String str, long j2) throws IOException {
        y();
        c0(str);
        d dVar = this.f8584l.get(str);
        if (j2 == -1 || (dVar != null && dVar.f8587e == j2)) {
            if (dVar != null) {
                if (dVar.f8586d != null) {
                    return null;
                }
            } else {
                dVar = new d(this, str, null);
                this.f8584l.put(str, dVar);
            }
            c cVar = new c(this, dVar, null);
            dVar.f8586d = cVar;
            Writer writer = this.f8583k;
            writer.write("DIRTY " + str + '\n');
            this.f8583k.flush();
            return cVar;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean S() {
        int i2 = this.m;
        return i2 >= 2000 && i2 >= this.f8584l.size();
    }

    public static a T(File file, int i2, int i3, long j2, int i4) throws IOException {
        if (j2 > 0) {
            if (i4 > 0) {
                if (i3 > 0) {
                    File file2 = new File(file, "journal.bkp");
                    if (file2.exists()) {
                        File file3 = new File(file, "journal");
                        if (file3.exists()) {
                            file2.delete();
                        } else {
                            Z(file2, file3, false);
                        }
                    }
                    a aVar = new a(file, i2, i3, j2, i4);
                    if (aVar.b.exists()) {
                        try {
                            aVar.V();
                            aVar.U();
                            aVar.f8583k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(aVar.b, true), d.f.a.a.a.c.c.d.a));
                            return aVar;
                        } catch (IOException e2) {
                            PrintStream printStream = System.out;
                            printStream.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                            aVar.A();
                        }
                    }
                    file.mkdirs();
                    a aVar2 = new a(file, i2, i3, j2, i4);
                    aVar2.X();
                    return aVar2;
                }
                throw new IllegalArgumentException("valueCount <= 0");
            }
            throw new IllegalArgumentException("maxFileCount <= 0");
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private void U() throws IOException {
        N(this.c);
        Iterator<d> it = this.f8584l.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i2 = 0;
            if (next.f8586d != null) {
                next.f8586d = null;
                while (i2 < this.f8580h) {
                    N(next.j(i2));
                    N(next.k(i2));
                    i2++;
                }
                it.remove();
            } else {
                while (i2 < this.f8580h) {
                    this.f8581i += next.b[i2];
                    this.f8582j++;
                    i2++;
                }
            }
        }
    }

    private void V() throws IOException {
        d.f.a.a.a.c.c.c cVar = new d.f.a.a.a.c.c.c(new FileInputStream(this.b), d.f.a.a.a.c.c.d.a);
        try {
            String t = cVar.t();
            String t2 = cVar.t();
            String t3 = cVar.t();
            String t4 = cVar.t();
            String t5 = cVar.t();
            if (!"libcore.io.DiskLruCache".equals(t) || !"1".equals(t2) || !Integer.toString(this.f8577e).equals(t3) || !Integer.toString(this.f8580h).equals(t4) || !"".equals(t5)) {
                throw new IOException("unexpected journal header: [" + t + ", " + t2 + ", " + t4 + ", " + t5 + "]");
            }
            int i2 = 0;
            while (true) {
                try {
                    W(cVar.t());
                    i2++;
                } catch (EOFException unused) {
                    this.m = i2 - this.f8584l.size();
                    d.f.a.a.a.c.c.d.a(cVar);
                    return;
                }
            }
        } catch (Throwable th) {
            d.f.a.a.a.c.c.d.a(cVar);
            throw th;
        }
    }

    private void W(String str) throws IOException {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i2 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i2);
            if (indexOf2 == -1) {
                substring = str.substring(i2);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.f8584l.remove(substring);
                    return;
                }
            } else {
                substring = str.substring(i2, indexOf2);
            }
            d dVar = this.f8584l.get(substring);
            if (dVar == null) {
                dVar = new d(this, substring, null);
                this.f8584l.put(substring, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                dVar.c = true;
                dVar.f8586d = null;
                dVar.n(split);
                return;
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.f8586d = new c(this, dVar, null);
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
    public synchronized void X() throws IOException {
        Writer writer = this.f8583k;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c), d.f.a.a.a.c.c.d.a));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f8577e));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f8580h));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (d dVar : this.f8584l.values()) {
            if (dVar.f8586d != null) {
                bufferedWriter.write("DIRTY " + dVar.a + '\n');
            } else {
                bufferedWriter.write("CLEAN " + dVar.a + dVar.l() + '\n');
            }
        }
        bufferedWriter.close();
        if (this.b.exists()) {
            Z(this.b, this.f8576d, true);
        }
        Z(this.c, this.b, false);
        this.f8576d.delete();
        this.f8583k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.b, true), d.f.a.a.a.c.c.d.a));
    }

    private static void Z(File file, File file2, boolean z) throws IOException {
        if (z) {
            N(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0() throws IOException {
        while (this.f8582j > this.f8579g) {
            Y(this.f8584l.entrySet().iterator().next().getKey());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0() throws IOException {
        while (this.f8581i > this.f8578f) {
            Y(this.f8584l.entrySet().iterator().next().getKey());
        }
    }

    private void c0(String str) {
        if (q.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + "\"");
    }

    private void y() {
        if (this.f8583k == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void z(c cVar, boolean z) throws IOException {
        d dVar = cVar.a;
        if (dVar.f8586d == cVar) {
            if (z && !dVar.c) {
                for (int i2 = 0; i2 < this.f8580h; i2++) {
                    if (cVar.b[i2]) {
                        if (!dVar.k(i2).exists()) {
                            cVar.a();
                            return;
                        }
                    } else {
                        cVar.a();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                    }
                }
            }
            for (int i3 = 0; i3 < this.f8580h; i3++) {
                File k2 = dVar.k(i3);
                if (z) {
                    if (k2.exists()) {
                        File j2 = dVar.j(i3);
                        k2.renameTo(j2);
                        long j3 = dVar.b[i3];
                        long length = j2.length();
                        dVar.b[i3] = length;
                        this.f8581i = (this.f8581i - j3) + length;
                        this.f8582j++;
                    }
                } else {
                    N(k2);
                }
            }
            this.m++;
            dVar.f8586d = null;
            if (dVar.c | z) {
                dVar.c = true;
                this.f8583k.write("CLEAN " + dVar.a + dVar.l() + '\n');
                if (z) {
                    long j4 = this.n;
                    this.n = 1 + j4;
                    dVar.f8587e = j4;
                }
            } else {
                this.f8584l.remove(dVar.a);
                this.f8583k.write("REMOVE " + dVar.a + '\n');
            }
            this.f8583k.flush();
            if (this.f8581i > this.f8578f || this.f8582j > this.f8579g || S()) {
                this.o.submit(this.p);
            }
            return;
        }
        throw new IllegalStateException();
    }

    public void A() throws IOException {
        close();
        d.f.a.a.a.c.c.d.b(this.a);
    }

    public c O(String str) throws IOException {
        return Q(str, -1L);
    }

    public synchronized e R(String str) throws IOException {
        y();
        c0(str);
        d dVar = this.f8584l.get(str);
        if (dVar == null) {
            return null;
        }
        if (dVar.c) {
            int i2 = this.f8580h;
            File[] fileArr = new File[i2];
            InputStream[] inputStreamArr = new InputStream[i2];
            for (int i3 = 0; i3 < this.f8580h; i3++) {
                try {
                    File j2 = dVar.j(i3);
                    fileArr[i3] = j2;
                    inputStreamArr[i3] = new FileInputStream(j2);
                } catch (FileNotFoundException unused) {
                    for (int i4 = 0; i4 < this.f8580h && inputStreamArr[i4] != null; i4++) {
                        d.f.a.a.a.c.c.d.a(inputStreamArr[i4]);
                    }
                    return null;
                }
            }
            this.m++;
            this.f8583k.append((CharSequence) ("READ " + str + '\n'));
            if (S()) {
                this.o.submit(this.p);
            }
            return new e(this, str, dVar.f8587e, fileArr, inputStreamArr, dVar.b, null);
        }
        return null;
    }

    public synchronized boolean Y(String str) throws IOException {
        y();
        c0(str);
        d dVar = this.f8584l.get(str);
        if (dVar != null && dVar.f8586d == null) {
            for (int i2 = 0; i2 < this.f8580h; i2++) {
                File j2 = dVar.j(i2);
                if (j2.exists() && !j2.delete()) {
                    throw new IOException("failed to delete " + j2);
                }
                this.f8581i -= dVar.b[i2];
                this.f8582j--;
                dVar.b[i2] = 0;
            }
            this.m++;
            this.f8583k.append((CharSequence) ("REMOVE " + str + '\n'));
            this.f8584l.remove(str);
            if (S()) {
                this.o.submit(this.p);
            }
            return true;
        }
        return false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.f8583k == null) {
            return;
        }
        Iterator it = new ArrayList(this.f8584l.values()).iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar.f8586d != null) {
                dVar.f8586d.a();
            }
        }
        b0();
        a0();
        this.f8583k.close();
        this.f8583k = null;
    }
}

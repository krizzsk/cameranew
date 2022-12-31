package com.bytedance.sdk.adnet.core;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.bytedance.sdk.adnet.face.a;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DiskBasedCache.java */
/* loaded from: classes.dex */
public class f implements com.bytedance.sdk.adnet.face.a {
    private final Map<String, a> a;
    private long b;
    private final File c;

    /* renamed from: d  reason: collision with root package name */
    private final int f1235d;

    public f(File file, int i2) {
        this.a = new LinkedHashMap(16, 0.75f, true);
        this.b = 0L;
        this.c = file;
        this.f1235d = i2;
    }

    private String d(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(str.substring(0, length).hashCode());
        return valueOf + String.valueOf(str.substring(length).hashCode());
    }

    private void e(String str) {
        a remove = this.a.remove(str);
        if (remove != null) {
            this.b -= remove.a;
        }
    }

    @Override // com.bytedance.sdk.adnet.face.a
    public synchronized a.C0044a a(String str) {
        b bVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar = this.a.get(str);
        if (aVar == null) {
            return null;
        }
        File c = c(str);
        try {
            bVar = new b(new BufferedInputStream(a(c)), c.length());
        } catch (Throwable th) {
            th = th;
            bVar = null;
        }
        try {
            a a2 = a.a(bVar);
            if (!TextUtils.equals(str, a2.b)) {
                o.b("%s: key=%s, found=%s", c.getAbsolutePath(), str, a2.b);
                e(str);
                bVar.close();
                try {
                    bVar.close();
                } catch (Throwable unused) {
                }
                return null;
            }
            a.C0044a a3 = aVar.a(a(bVar, bVar.a()));
            bVar.close();
            try {
                bVar.close();
            } catch (Throwable unused2) {
            }
            return a3;
        } catch (Throwable th2) {
            th = th2;
            o.b("%s: %s", c.getAbsolutePath(), th.toString());
            b(str);
            if (bVar != null) {
                try {
                    bVar.close();
                } catch (Throwable unused3) {
                }
            }
            return null;
        }
    }

    public synchronized void b(String str) {
        boolean delete = c(str).delete();
        e(str);
        if (!delete) {
            o.b("Could not delete cache entry for key=%s, filename=%s", str, d(str));
        }
    }

    public File c(String str) {
        return new File(this.c, d(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DiskBasedCache.java */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class a {
        long a;
        final String b;
        final String c;

        /* renamed from: d  reason: collision with root package name */
        final long f1236d;

        /* renamed from: e  reason: collision with root package name */
        final long f1237e;

        /* renamed from: f  reason: collision with root package name */
        final long f1238f;

        /* renamed from: g  reason: collision with root package name */
        final long f1239g;

        /* renamed from: h  reason: collision with root package name */
        final List<Header> f1240h;

        private a(String str, String str2, long j2, long j3, long j4, long j5, List<Header> list) {
            this.b = str;
            this.c = "".equals(str2) ? null : str2;
            this.f1236d = j2;
            this.f1237e = j3;
            this.f1238f = j4;
            this.f1239g = j5;
            this.f1240h = list;
        }

        private static List<Header> a(a.C0044a c0044a) {
            List<Header> list = c0044a.f1266i;
            return list != null ? list : com.bytedance.sdk.adnet.d.b.b(c0044a.f1265h);
        }

        static a a(b bVar) throws Throwable {
            if (f.a((InputStream) bVar) == 538247942) {
                return new a(f.a(bVar), f.a(bVar), f.b((InputStream) bVar), f.b((InputStream) bVar), f.b((InputStream) bVar), f.b((InputStream) bVar), f.b(bVar));
            }
            throw new IOException();
        }

        a(String str, a.C0044a c0044a) {
            this(str, c0044a.c, c0044a.f1261d, c0044a.f1262e, c0044a.f1263f, c0044a.f1264g, a(c0044a));
        }

        a.C0044a a(byte[] bArr) {
            a.C0044a c0044a = new a.C0044a();
            c0044a.b = bArr;
            c0044a.c = this.c;
            c0044a.f1261d = this.f1236d;
            c0044a.f1262e = this.f1237e;
            c0044a.f1263f = this.f1238f;
            c0044a.f1264g = this.f1239g;
            c0044a.f1265h = com.bytedance.sdk.adnet.d.b.a(this.f1240h);
            c0044a.f1266i = Collections.unmodifiableList(this.f1240h);
            return c0044a;
        }

        boolean a(OutputStream outputStream) {
            try {
                f.a(outputStream, 538247942);
                f.a(outputStream, this.b);
                String str = this.c;
                if (str == null) {
                    str = "";
                }
                f.a(outputStream, str);
                f.a(outputStream, this.f1236d);
                f.a(outputStream, this.f1237e);
                f.a(outputStream, this.f1238f);
                f.a(outputStream, this.f1239g);
                f.a(this.f1240h, outputStream);
                outputStream.flush();
                return true;
            } catch (Throwable th) {
                o.b("%s", th.toString());
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DiskBasedCache.java */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class b extends FilterInputStream {
        private final long a;
        private long b;

        b(InputStream inputStream, long j2) {
            super(inputStream);
            this.a = j2;
        }

        long a() {
            return this.a - this.b;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                this.b++;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) throws IOException {
            int read = super.read(bArr, i2, i3);
            if (read != -1) {
                this.b += read;
            }
            return read;
        }
    }

    private static int c(InputStream inputStream) throws Throwable {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    public f(File file) {
        this(file, 5242880);
    }

    private void b() {
        if (this.b < this.f1235d) {
            return;
        }
        if (o.a) {
            o.a("Pruning old cache entries.", new Object[0]);
        }
        long j2 = this.b;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<Map.Entry<String, a>> it = this.a.entrySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            a value = it.next().getValue();
            if (c(value.b).delete()) {
                this.b -= value.a;
            } else {
                String str = value.b;
                o.b("Could not delete cache entry for key=%s, filename=%s", str, d(str));
            }
            it.remove();
            i2++;
            if (((float) this.b) < this.f1235d * 0.9f) {
                break;
            }
        }
        if (o.a) {
            o.a("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.b - j2), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
        }
    }

    @VisibleForTesting
    OutputStream b(File file) throws Throwable {
        return new FileOutputStream(file);
    }

    static long b(InputStream inputStream) throws Throwable {
        return ((c(inputStream) & 255) << 0) | 0 | ((c(inputStream) & 255) << 8) | ((c(inputStream) & 255) << 16) | ((c(inputStream) & 255) << 24) | ((c(inputStream) & 255) << 32) | ((c(inputStream) & 255) << 40) | ((c(inputStream) & 255) << 48) | ((255 & c(inputStream)) << 56);
    }

    @Override // com.bytedance.sdk.adnet.face.a
    public synchronized void a() {
        if (!this.c.exists()) {
            if (!this.c.mkdirs()) {
                o.c("Unable to create cache dir %s", this.c.getAbsolutePath());
            }
            return;
        }
        File[] listFiles = this.c.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            long length = file.length();
            b bVar = new b(new BufferedInputStream(a(file)), length);
            try {
                a a2 = a.a(bVar);
                a2.a = length;
                a(a2.b, a2);
            } catch (Throwable unused) {
            }
            bVar.close();
        }
    }

    static List<Header> b(b bVar) throws Throwable {
        int a2 = a((InputStream) bVar);
        if (a2 >= 0) {
            List<Header> emptyList = a2 == 0 ? Collections.emptyList() : new ArrayList<>();
            for (int i2 = 0; i2 < a2; i2++) {
                emptyList.add(new Header(a(bVar).intern(), a(bVar).intern()));
            }
            return emptyList;
        }
        throw new IOException("readHeaderList size=" + a2);
    }

    @Override // com.bytedance.sdk.adnet.face.a
    public synchronized void a(String str, a.C0044a c0044a) {
        long j2 = this.b;
        byte[] bArr = c0044a.b;
        long length = j2 + bArr.length;
        int i2 = this.f1235d;
        if (length > i2 && bArr.length > i2 * 0.9f) {
            return;
        }
        File c = c(str);
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(b(c));
            try {
                a aVar = new a(str, c0044a);
                if (aVar.a(bufferedOutputStream2)) {
                    bufferedOutputStream2.write(c0044a.b);
                    aVar.a = c.length();
                    a(str, aVar);
                    b();
                    try {
                        bufferedOutputStream2.close();
                    } catch (Throwable unused) {
                    }
                    return;
                }
                bufferedOutputStream2.close();
                o.b("Failed to write header for %s", c.getAbsolutePath());
                throw new IOException();
            } catch (Throwable unused2) {
                bufferedOutputStream = bufferedOutputStream2;
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (Throwable unused3) {
                    }
                }
                if (!c.delete()) {
                    o.b("Could not clean up file %s", c.getAbsolutePath());
                }
            }
        } catch (Throwable unused4) {
        }
    }

    private void a(String str, a aVar) {
        if (!this.a.containsKey(str)) {
            this.b += aVar.a;
        } else {
            this.b += aVar.a - this.a.get(str).a;
        }
        this.a.put(str, aVar);
    }

    @VisibleForTesting
    static byte[] a(b bVar, long j2) throws Throwable {
        long a2 = bVar.a();
        if (j2 >= 0 && j2 <= a2) {
            int i2 = (int) j2;
            if (i2 == j2) {
                byte[] bArr = new byte[i2];
                new DataInputStream(bVar).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j2 + ", maxLength=" + a2);
    }

    @VisibleForTesting
    InputStream a(File file) throws Throwable {
        return new FileInputStream(file);
    }

    static void a(OutputStream outputStream, int i2) throws Throwable {
        outputStream.write((i2 >> 0) & 255);
        outputStream.write((i2 >> 8) & 255);
        outputStream.write((i2 >> 16) & 255);
        outputStream.write((i2 >> 24) & 255);
    }

    static int a(InputStream inputStream) throws Throwable {
        return (c(inputStream) << 24) | (c(inputStream) << 0) | 0 | (c(inputStream) << 8) | (c(inputStream) << 16);
    }

    static void a(OutputStream outputStream, long j2) throws Throwable {
        outputStream.write((byte) (j2 >>> 0));
        outputStream.write((byte) (j2 >>> 8));
        outputStream.write((byte) (j2 >>> 16));
        outputStream.write((byte) (j2 >>> 24));
        outputStream.write((byte) (j2 >>> 32));
        outputStream.write((byte) (j2 >>> 40));
        outputStream.write((byte) (j2 >>> 48));
        outputStream.write((byte) (j2 >>> 56));
    }

    static void a(OutputStream outputStream, String str) throws Throwable {
        byte[] bytes = str.getBytes("UTF-8");
        a(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    static String a(b bVar) throws Throwable {
        return new String(a(bVar, b((InputStream) bVar)), "UTF-8");
    }

    static void a(List<Header> list, OutputStream outputStream) throws Throwable {
        if (list != null) {
            a(outputStream, list.size());
            for (Header header : list) {
                a(outputStream, header.getName());
                a(outputStream, header.getValue());
            }
            return;
        }
        a(outputStream, 0);
    }
}

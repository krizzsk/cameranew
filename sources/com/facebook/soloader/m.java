package com.facebook.soloader;

import android.content.Context;
import android.os.Parcel;
import android.os.StrictMode;
import android.util.Log;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
/* compiled from: UnpackingSoSource.java */
/* loaded from: classes.dex */
public abstract class m extends com.facebook.soloader.c {
    protected final Context c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    protected String f3285d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, Object> f3286e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UnpackingSoSource.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        final /* synthetic */ File a;
        final /* synthetic */ byte[] b;
        final /* synthetic */ c c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ File f3287d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ g f3288e;

        a(File file, byte[] bArr, c cVar, File file2, g gVar) {
            this.a = file;
            this.b = bArr;
            this.c = cVar;
            this.f3287d = file2;
            this.f3288e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.v("fb-UnpackingSoSource", "starting syncer worker");
                RandomAccessFile randomAccessFile = new RandomAccessFile(this.a, "rw");
                try {
                    randomAccessFile.write(this.b);
                    randomAccessFile.setLength(randomAccessFile.getFilePointer());
                    randomAccessFile.close();
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(new File(m.this.a, "dso_manifest"), "rw");
                    try {
                        this.c.b(randomAccessFile2);
                        randomAccessFile2.close();
                        SysUtil.f(m.this.a);
                        m.r(this.f3287d, (byte) 1);
                        Log.v("fb-UnpackingSoSource", "releasing dso store lock for " + m.this.a + " (from syncer thread)");
                        this.f3288e.close();
                    } finally {
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            randomAccessFile.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* compiled from: UnpackingSoSource.java */
    /* loaded from: classes.dex */
    public static class b {
        public final String a;
        public final String b;

        public b(String str, String str2) {
            this.a = str;
            this.b = str2;
        }
    }

    /* compiled from: UnpackingSoSource.java */
    /* loaded from: classes.dex */
    public static final class c {
        public final b[] a;

        public c(b[] bVarArr) {
            this.a = bVarArr;
        }

        static final c a(DataInput dataInput) throws IOException {
            if (dataInput.readByte() == 1) {
                int readInt = dataInput.readInt();
                if (readInt >= 0) {
                    b[] bVarArr = new b[readInt];
                    for (int i2 = 0; i2 < readInt; i2++) {
                        bVarArr[i2] = new b(dataInput.readUTF(), dataInput.readUTF());
                    }
                    return new c(bVarArr);
                }
                throw new RuntimeException("illegal number of shared libraries");
            }
            throw new RuntimeException("wrong dso manifest version");
        }

        public final void b(DataOutput dataOutput) throws IOException {
            dataOutput.writeByte(1);
            dataOutput.writeInt(this.a.length);
            int i2 = 0;
            while (true) {
                b[] bVarArr = this.a;
                if (i2 >= bVarArr.length) {
                    return;
                }
                dataOutput.writeUTF(bVarArr[i2].a);
                dataOutput.writeUTF(this.a[i2].b);
                i2++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: UnpackingSoSource.java */
    /* loaded from: classes.dex */
    public static final class d implements Closeable {
        public final b a;
        public final InputStream b;

        public d(b bVar, InputStream inputStream) {
            this.a = bVar;
            this.b = inputStream;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.b.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: UnpackingSoSource.java */
    /* loaded from: classes.dex */
    public static abstract class e implements Closeable {
        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        public abstract boolean d();

        public abstract d t() throws IOException;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: UnpackingSoSource.java */
    /* loaded from: classes.dex */
    public static abstract class f implements Closeable {
        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        protected abstract c d() throws IOException;

        protected abstract e t() throws IOException;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public m(Context context, String str) {
        super(l(context, str), 1);
        this.f3286e = new HashMap();
        this.c = context;
    }

    private void g(b[] bVarArr) throws IOException {
        String[] list = this.a.list();
        if (list != null) {
            for (String str : list) {
                if (!str.equals("dso_state") && !str.equals("dso_lock") && !str.equals("dso_deps") && !str.equals("dso_manifest")) {
                    boolean z = false;
                    for (int i2 = 0; !z && i2 < bVarArr.length; i2++) {
                        if (bVarArr[i2].a.equals(str)) {
                            z = true;
                        }
                    }
                    if (!z) {
                        File file = new File(this.a, str);
                        Log.v("fb-UnpackingSoSource", "deleting unaccounted-for file " + file);
                        SysUtil.c(file);
                    }
                }
            }
            return;
        }
        throw new IOException("unable to list directory " + this.a);
    }

    private void h(d dVar, byte[] bArr) throws IOException {
        boolean writable;
        Log.i("fb-UnpackingSoSource", "extracting DSO " + dVar.a.a);
        try {
            if (this.a.setWritable(true)) {
                i(dVar, bArr);
                if (writable) {
                    return;
                }
                return;
            }
            throw new IOException("cannot make directory writable for us: " + this.a);
        } finally {
            if (!this.a.setWritable(false)) {
                Log.w("fb-UnpackingSoSource", "error removing " + this.a.getCanonicalPath() + " write permission");
            }
        }
    }

    private void i(d dVar, byte[] bArr) throws IOException {
        RandomAccessFile randomAccessFile;
        File file = new File(this.a, dVar.a.a);
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                if (file.exists() && !file.setWritable(true)) {
                    Log.w("fb-UnpackingSoSource", "error adding write permission to: " + file);
                }
                try {
                    randomAccessFile = new RandomAccessFile(file, "rw");
                } catch (IOException e2) {
                    Log.w("fb-UnpackingSoSource", "error overwriting " + file + " trying to delete and start over", e2);
                    SysUtil.c(file);
                    randomAccessFile = new RandomAccessFile(file, "rw");
                }
                randomAccessFile2 = randomAccessFile;
                int available = dVar.b.available();
                if (available > 1) {
                    SysUtil.d(randomAccessFile2.getFD(), available);
                }
                SysUtil.a(randomAccessFile2, dVar.b, Integer.MAX_VALUE, bArr);
                randomAccessFile2.setLength(randomAccessFile2.getFilePointer());
                if (file.setExecutable(true, false)) {
                    if (!file.setWritable(false)) {
                        Log.w("fb-UnpackingSoSource", "error removing " + file + " write permission");
                    }
                    randomAccessFile2.close();
                    return;
                }
                throw new IOException("cannot make file executable: " + file);
            } catch (Throwable th) {
                if (!file.setWritable(false)) {
                    Log.w("fb-UnpackingSoSource", "error removing " + file + " write permission");
                }
                if (randomAccessFile2 != null) {
                    randomAccessFile2.close();
                }
                throw th;
            }
        } catch (IOException e3) {
            SysUtil.c(file);
            throw e3;
        }
    }

    private Object k(String str) {
        Object obj;
        synchronized (this.f3286e) {
            obj = this.f3286e.get(str);
            if (obj == null) {
                obj = new Object();
                this.f3286e.put(str, obj);
            }
        }
        return obj;
    }

    public static File l(Context context, String str) {
        return new File(context.getApplicationInfo().dataDir + "/" + str);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00a4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean o(com.facebook.soloader.g r12, int r13, byte[] r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.m.o(com.facebook.soloader.g, int, byte[]):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0043 A[Catch: all -> 0x0036, TryCatch #5 {all -> 0x0036, blocks: (B:4:0x0031, B:13:0x0043, B:14:0x004a, B:15:0x0054, B:17:0x005a, B:42:0x00a0, B:9:0x003a, B:20:0x0062, B:22:0x0067, B:24:0x0075, B:27:0x0086, B:31:0x008d), top: B:53:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005a A[Catch: all -> 0x0036, TRY_LEAVE, TryCatch #5 {all -> 0x0036, blocks: (B:4:0x0031, B:13:0x0043, B:14:0x004a, B:15:0x0054, B:17:0x005a, B:42:0x00a0, B:9:0x003a, B:20:0x0062, B:22:0x0067, B:24:0x0075, B:27:0x0086, B:31:0x008d), top: B:53:0x0031 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void p(byte r10, com.facebook.soloader.m.c r11, com.facebook.soloader.m.e r12) throws java.io.IOException {
        /*
            r9 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "regenerating DSO store "
            r0.append(r1)
            java.lang.Class r1 = r9.getClass()
            java.lang.String r1 = r1.getName()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "fb-UnpackingSoSource"
            android.util.Log.v(r1, r0)
            java.io.File r0 = new java.io.File
            java.io.File r2 = r9.a
            java.lang.String r3 = "dso_manifest"
            r0.<init>(r2, r3)
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile
            java.lang.String r3 = "rw"
            r2.<init>(r0, r3)
            r0 = 1
            if (r10 != r0) goto L3f
            com.facebook.soloader.m$c r10 = com.facebook.soloader.m.c.a(r2)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L39
            goto L40
        L36:
            r10 = move-exception
            goto Lc4
        L39:
            r10 = move-exception
            java.lang.String r3 = "error reading existing DSO manifest"
            android.util.Log.i(r1, r3, r10)     // Catch: java.lang.Throwable -> L36
        L3f:
            r10 = 0
        L40:
            r3 = 0
            if (r10 != 0) goto L4a
            com.facebook.soloader.m$c r10 = new com.facebook.soloader.m$c     // Catch: java.lang.Throwable -> L36
            com.facebook.soloader.m$b[] r4 = new com.facebook.soloader.m.b[r3]     // Catch: java.lang.Throwable -> L36
            r10.<init>(r4)     // Catch: java.lang.Throwable -> L36
        L4a:
            com.facebook.soloader.m$b[] r11 = r11.a     // Catch: java.lang.Throwable -> L36
            r9.g(r11)     // Catch: java.lang.Throwable -> L36
            r11 = 32768(0x8000, float:4.5918E-41)
            byte[] r11 = new byte[r11]     // Catch: java.lang.Throwable -> L36
        L54:
            boolean r4 = r12.d()     // Catch: java.lang.Throwable -> L36
            if (r4 == 0) goto La4
            com.facebook.soloader.m$d r4 = r12.t()     // Catch: java.lang.Throwable -> L36
            r5 = 1
            r6 = 0
        L60:
            if (r5 == 0) goto L8b
            com.facebook.soloader.m$b[] r7 = r10.a     // Catch: java.lang.Throwable -> L89
            int r8 = r7.length     // Catch: java.lang.Throwable -> L89
            if (r6 >= r8) goto L8b
            r7 = r7[r6]     // Catch: java.lang.Throwable -> L89
            java.lang.String r7 = r7.a     // Catch: java.lang.Throwable -> L89
            com.facebook.soloader.m$b r8 = r4.a     // Catch: java.lang.Throwable -> L89
            java.lang.String r8 = r8.a     // Catch: java.lang.Throwable -> L89
            boolean r7 = r7.equals(r8)     // Catch: java.lang.Throwable -> L89
            if (r7 == 0) goto L86
            com.facebook.soloader.m$b[] r7 = r10.a     // Catch: java.lang.Throwable -> L89
            r7 = r7[r6]     // Catch: java.lang.Throwable -> L89
            java.lang.String r7 = r7.b     // Catch: java.lang.Throwable -> L89
            com.facebook.soloader.m$b r8 = r4.a     // Catch: java.lang.Throwable -> L89
            java.lang.String r8 = r8.b     // Catch: java.lang.Throwable -> L89
            boolean r7 = r7.equals(r8)     // Catch: java.lang.Throwable -> L89
            if (r7 == 0) goto L86
            r5 = 0
        L86:
            int r6 = r6 + 1
            goto L60
        L89:
            r10 = move-exception
            goto L91
        L8b:
            if (r5 == 0) goto L9e
            r9.h(r4, r11)     // Catch: java.lang.Throwable -> L89
            goto L9e
        L91:
            throw r10     // Catch: java.lang.Throwable -> L92
        L92:
            r11 = move-exception
            if (r4 == 0) goto L9d
            r4.close()     // Catch: java.lang.Throwable -> L99
            goto L9d
        L99:
            r12 = move-exception
            r10.addSuppressed(r12)     // Catch: java.lang.Throwable -> L36
        L9d:
            throw r11     // Catch: java.lang.Throwable -> L36
        L9e:
            if (r4 == 0) goto L54
            r4.close()     // Catch: java.lang.Throwable -> L36
            goto L54
        La4:
            r2.close()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Finished regenerating DSO store "
            r10.append(r11)
            java.lang.Class r11 = r9.getClass()
            java.lang.String r11 = r11.getName()
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            android.util.Log.v(r1, r10)
            return
        Lc4:
            throw r10     // Catch: java.lang.Throwable -> Lc5
        Lc5:
            r11 = move-exception
            r2.close()     // Catch: java.lang.Throwable -> Lca
            goto Lce
        Lca:
            r12 = move-exception
            r10.addSuppressed(r12)
        Lce:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.m.p(byte, com.facebook.soloader.m$c, com.facebook.soloader.m$e):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r(File file, byte b2) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        try {
            randomAccessFile.seek(0L);
            randomAccessFile.write(b2);
            randomAccessFile.setLength(randomAccessFile.getFilePointer());
            randomAccessFile.getFD().sync();
            randomAccessFile.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    @Override // com.facebook.soloader.c, com.facebook.soloader.k
    public int a(String str, int i2, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        int e2;
        synchronized (k(str)) {
            e2 = e(str, i2, this.a, threadPolicy);
        }
        return e2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.soloader.k
    public void b(int i2) throws IOException {
        SysUtil.j(this.a);
        g a2 = g.a(new File(this.a, "dso_lock"));
        try {
            Log.v("fb-UnpackingSoSource", "locked dso store " + this.a);
            if (o(a2, i2, j())) {
                a2 = null;
            } else {
                Log.i("fb-UnpackingSoSource", "dso store is up-to-date: " + this.a);
            }
        } finally {
            if (a2 != null) {
                Log.v("fb-UnpackingSoSource", "releasing dso store lock for " + this.a);
                a2.close();
            } else {
                Log.v("fb-UnpackingSoSource", "not releasing dso store lock for " + this.a + " (syncer thread started)");
            }
        }
    }

    protected byte[] j() throws IOException {
        Parcel obtain = Parcel.obtain();
        f m = m();
        try {
            b[] bVarArr = m.d().a;
            obtain.writeByte((byte) 1);
            obtain.writeInt(bVarArr.length);
            for (int i2 = 0; i2 < bVarArr.length; i2++) {
                obtain.writeString(bVarArr[i2].a);
                obtain.writeString(bVarArr[i2].b);
            }
            if (m != null) {
                m.close();
            }
            byte[] marshall = obtain.marshall();
            obtain.recycle();
            return marshall;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (m != null) {
                    try {
                        m.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    protected abstract f m() throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void n(String str) throws IOException {
        synchronized (k(str)) {
            this.f3285d = str;
            b(2);
        }
    }

    public void q(String[] strArr) {
    }
}

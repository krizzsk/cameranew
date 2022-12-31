package com.google.android.play.core.assetpacks;

import com.tencent.connect.common.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Properties;
import us.pinguo.inspire.module.MissionDetail.TaskDetailBasePresenter;
/* loaded from: classes2.dex */
final class z2 {

    /* renamed from: h  reason: collision with root package name */
    private static final com.google.android.play.core.internal.j f4850h = new com.google.android.play.core.internal.j("SliceMetadataManager");
    private final k0 b;
    private final String c;

    /* renamed from: d  reason: collision with root package name */
    private final int f4851d;

    /* renamed from: e  reason: collision with root package name */
    private final long f4852e;

    /* renamed from: f  reason: collision with root package name */
    private final String f4853f;
    private final byte[] a = new byte[8192];

    /* renamed from: g  reason: collision with root package name */
    private int f4854g = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z2(k0 k0Var, String str, int i2, long j2, String str2) {
        this.b = k0Var;
        this.c = str;
        this.f4851d = i2;
        this.f4852e = j2;
        this.f4853f = str2;
    }

    private final File n() {
        File B = this.b.B(this.c, this.f4851d, this.f4852e, this.f4853f);
        if (!B.exists()) {
            B.mkdirs();
        }
        return B;
    }

    private final File o() throws IOException {
        File o = this.b.o(this.c, this.f4851d, this.f4852e, this.f4853f);
        o.getParentFile().mkdirs();
        o.createNewFile();
        return o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final y2 a() throws IOException {
        File o = this.b.o(this.c, this.f4851d, this.f4852e, this.f4853f);
        if (o.exists()) {
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(o);
            try {
                properties.load(fileInputStream);
                fileInputStream.close();
                if (properties.getProperty("fileStatus") == null || properties.getProperty("previousChunk") == null) {
                    throw new bv("Slice checkpoint file corrupt.");
                }
                try {
                    int parseInt = Integer.parseInt(properties.getProperty("fileStatus"));
                    String property = properties.getProperty("fileName");
                    long parseLong = Long.parseLong(properties.getProperty("fileOffset", TaskDetailBasePresenter.SCENE_LIST));
                    long parseLong2 = Long.parseLong(properties.getProperty("remainingBytes", TaskDetailBasePresenter.SCENE_LIST));
                    int parseInt2 = Integer.parseInt(properties.getProperty("previousChunk"));
                    this.f4854g = Integer.parseInt(properties.getProperty("metadataFileCounter", "0"));
                    return new y2(parseInt, property, parseLong, parseLong2, parseInt2);
                } catch (NumberFormatException e2) {
                    throw new bv("Slice checkpoint file corrupt.", e2);
                }
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    com.google.android.play.core.internal.j1.a(th, th2);
                }
                throw th;
            }
        }
        throw new bv("Slice checkpoint file does not exist.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(int i2) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", "3");
        properties.put("fileOffset", String.valueOf(i().length()));
        properties.put("previousChunk", String.valueOf(i2));
        properties.put("metadataFileCounter", String.valueOf(this.f4854g));
        FileOutputStream fileOutputStream = new FileOutputStream(o());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                com.google.android.play.core.internal.j1.a(th, th2);
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(long j2, byte[] bArr, int i2, int i3) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(i(), "rw");
        try {
            randomAccessFile.seek(j2);
            randomAccessFile.write(bArr, i2, i3);
            randomAccessFile.close();
        } catch (Throwable th) {
            try {
                randomAccessFile.close();
            } catch (Throwable th2) {
                com.google.android.play.core.internal.j1.a(th, th2);
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(InputStream inputStream, long j2) throws IOException {
        int read;
        RandomAccessFile randomAccessFile = new RandomAccessFile(i(), "rw");
        try {
            randomAccessFile.seek(j2);
            do {
                read = inputStream.read(this.a);
                if (read > 0) {
                    randomAccessFile.write(this.a, 0, read);
                }
            } while (read == this.a.length);
            randomAccessFile.close();
        } catch (Throwable th) {
            try {
                randomAccessFile.close();
            } catch (Throwable th2) {
                com.google.android.play.core.internal.j1.a(th, th2);
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e(String str, long j2, long j3, int i2) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", "1");
        properties.put("fileName", str);
        properties.put("fileOffset", String.valueOf(j2));
        properties.put("remainingBytes", String.valueOf(j3));
        properties.put("previousChunk", String.valueOf(i2));
        properties.put("metadataFileCounter", String.valueOf(this.f4854g));
        FileOutputStream fileOutputStream = new FileOutputStream(o());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                com.google.android.play.core.internal.j1.a(th, th2);
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f(byte[] bArr) throws IOException {
        this.f4854g++;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(n(), String.format("%s-LFH.dat", Integer.valueOf(this.f4854g))));
            fileOutputStream.write(bArr);
            fileOutputStream.close();
        } catch (IOException e2) {
            throw new bv("Could not write metadata file.", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void g(byte[] bArr, int i2) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", "2");
        properties.put("previousChunk", String.valueOf(i2));
        properties.put("metadataFileCounter", String.valueOf(this.f4854g));
        FileOutputStream fileOutputStream = new FileOutputStream(o());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
            File t = this.b.t(this.c, this.f4851d, this.f4852e, this.f4853f);
            if (t.exists()) {
                t.delete();
            }
            fileOutputStream = new FileOutputStream(t);
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.close();
            } finally {
                try {
                    fileOutputStream.close();
                } catch (Throwable th) {
                    com.google.android.play.core.internal.j1.a(th, th);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void h(byte[] bArr, InputStream inputStream) throws IOException {
        this.f4854g++;
        FileOutputStream fileOutputStream = new FileOutputStream(i());
        try {
            fileOutputStream.write(bArr);
            int read = inputStream.read(this.a);
            while (read > 0) {
                fileOutputStream.write(this.a, 0, read);
                read = inputStream.read(this.a);
            }
            fileOutputStream.close();
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                com.google.android.play.core.internal.j1.a(th, th2);
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final File i() {
        return new File(n(), String.format("%s-NAM.dat", Integer.valueOf(this.f4854g)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void j(int i2) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", Constants.VIA_TO_TYPE_QZONE);
        properties.put("previousChunk", String.valueOf(i2));
        properties.put("metadataFileCounter", String.valueOf(this.f4854g));
        FileOutputStream fileOutputStream = new FileOutputStream(o());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                com.google.android.play.core.internal.j1.a(th, th2);
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void k(byte[] bArr, int i2) throws IOException {
        this.f4854g++;
        FileOutputStream fileOutputStream = new FileOutputStream(i());
        try {
            fileOutputStream.write(bArr, 0, i2);
            fileOutputStream.close();
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                com.google.android.play.core.internal.j1.a(th, th2);
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int l() throws IOException {
        File o = this.b.o(this.c, this.f4851d, this.f4852e, this.f4853f);
        if (o.exists()) {
            FileInputStream fileInputStream = new FileInputStream(o);
            try {
                Properties properties = new Properties();
                properties.load(fileInputStream);
                fileInputStream.close();
                if (Integer.parseInt(properties.getProperty("fileStatus", TaskDetailBasePresenter.SCENE_LIST)) == 4) {
                    return -1;
                }
                if (properties.getProperty("previousChunk") != null) {
                    return Integer.parseInt(properties.getProperty("previousChunk")) + 1;
                }
                throw new bv("Slice checkpoint file corrupt.");
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    com.google.android.play.core.internal.j1.a(th, th2);
                }
                throw th;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean m() {
        File o = this.b.o(this.c, this.f4851d, this.f4852e, this.f4853f);
        if (o.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(o);
                Properties properties = new Properties();
                properties.load(fileInputStream);
                fileInputStream.close();
                if (properties.getProperty("fileStatus") != null) {
                    return Integer.parseInt(properties.getProperty("fileStatus")) == 4;
                }
                f4850h.e("Slice checkpoint file corrupt while checking if extraction finished.", new Object[0]);
                return false;
            } catch (IOException e2) {
                f4850h.e("Could not read checkpoint while checking if extraction finished. %s", e2);
                return false;
            }
        }
        return false;
    }
}

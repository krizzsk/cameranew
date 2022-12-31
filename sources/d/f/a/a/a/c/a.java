package d.f.a.a.a.c;

import android.graphics.Bitmap;
import d.f.a.b.c;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: BaseDiscCache.java */
/* loaded from: classes3.dex */
public abstract class a implements d.f.a.a.a.b {

    /* renamed from: g  reason: collision with root package name */
    public static final Bitmap.CompressFormat f8572g = Bitmap.CompressFormat.PNG;
    protected final File a;
    protected final File b;
    protected final d.f.a.a.a.d.a c;

    /* renamed from: d  reason: collision with root package name */
    protected int f8573d = 32768;

    /* renamed from: e  reason: collision with root package name */
    protected Bitmap.CompressFormat f8574e = f8572g;

    /* renamed from: f  reason: collision with root package name */
    protected int f8575f = 100;

    public a(File file, File file2, d.f.a.a.a.d.a aVar) {
        if (file == null) {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        }
        if (aVar != null) {
            this.a = file;
            this.b = file2;
            this.c = aVar;
            return;
        }
        throw new IllegalArgumentException("fileNameGenerator argument must be not null");
    }

    @Override // d.f.a.a.a.a
    public boolean a(String str, Bitmap bitmap) throws IOException {
        File c = c(str);
        File file = new File(c.getAbsolutePath() + ".tmp");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), this.f8573d);
        try {
            boolean compress = bitmap.compress(this.f8574e, this.f8575f, bufferedOutputStream);
            c.a(bufferedOutputStream);
            if (compress && !file.renameTo(c)) {
                compress = false;
            }
            if (!compress) {
                file.delete();
            }
            bitmap.recycle();
            return compress;
        } catch (Throwable th) {
            c.a(bufferedOutputStream);
            file.delete();
            throw th;
        }
    }

    @Override // d.f.a.a.a.a
    public boolean b(String str, InputStream inputStream, c.a aVar) throws IOException {
        boolean z;
        File c = c(str);
        File file = new File(c.getAbsolutePath() + ".tmp");
        boolean z2 = false;
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), this.f8573d);
            z = c.c(inputStream, bufferedOutputStream, aVar, this.f8573d);
            try {
                c.a(bufferedOutputStream);
                c.a(inputStream);
                if (!z || file.renameTo(c)) {
                    z2 = z;
                }
                if (!z2) {
                    file.delete();
                }
                return z2;
            } catch (Throwable th) {
                th = th;
                c.a(inputStream);
                if (!z || file.renameTo(c)) {
                    z2 = z;
                }
                if (!z2) {
                    file.delete();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            z = false;
        }
    }

    protected File c(String str) {
        File file;
        String a = this.c.a(str);
        File file2 = this.a;
        if (!file2.exists() && !this.a.mkdirs() && (file = this.b) != null && (file.exists() || this.b.mkdirs())) {
            file2 = this.b;
        }
        return new File(file2, a);
    }

    @Override // d.f.a.a.a.a
    public File get(String str) {
        return c(str);
    }

    @Override // d.f.a.a.a.a
    public boolean remove(String str) {
        return c(str).delete();
    }
}

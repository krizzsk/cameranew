package com.tapjoy.internal;

import android.graphics.Bitmap;
import com.tapjoy.internal.ap;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import us.pinguo.common.network.HttpRequest;
/* loaded from: classes3.dex */
public final class hx {

    /* renamed from: e  reason: collision with root package name */
    public static final bi f7652e;

    /* renamed from: f  reason: collision with root package name */
    private static final an f7653f;
    public URL a;
    public Bitmap b;
    public byte[] c;

    /* renamed from: d  reason: collision with root package name */
    public ie f7654d;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.tapjoy.internal.ap$a] */
    static {
        ar arVar = new ar();
        if (!(arVar instanceof as)) {
            arVar = new ap.a(arVar);
        }
        f7653f = arVar;
        f7652e = new bi() { // from class: com.tapjoy.internal.hx.1
            @Override // com.tapjoy.internal.bi
            public final /* synthetic */ Object a(bn bnVar) {
                return new hx(bnVar);
            }
        };
    }

    public hx(URL url) {
        this.a = url;
    }

    public final boolean a() {
        return (this.b == null && this.c == null) ? false : true;
    }

    public final void b() {
        Bitmap bitmap;
        File a;
        Bitmap bitmap2;
        boolean a2 = ga.b().a("mm_external_cache_enabled", true);
        boolean z = !a2;
        if (z) {
            Bitmap bitmap3 = (Bitmap) f7653f.a(this.a);
            this.b = bitmap3;
            if (bitmap3 != null) {
                return;
            }
        }
        if (a2 && (a = ht.a.a(this.a)) != null) {
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(a);
                try {
                    a(fileInputStream2);
                    jz.a(fileInputStream2);
                } catch (IOException unused) {
                    fileInputStream = fileInputStream2;
                    jz.a(fileInputStream);
                    bitmap2 = this.b;
                    if (bitmap2 == null) {
                    }
                    if (z) {
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    jz.a(fileInputStream);
                    throw th;
                }
            } catch (IOException unused2) {
            } catch (Throwable th2) {
                th = th2;
            }
            bitmap2 = this.b;
            if (bitmap2 == null || this.c != null) {
                if (z || bitmap2 == null) {
                    return;
                }
                f7653f.a(this.a, bitmap2);
                return;
            }
            a.delete();
        }
        URLConnection a3 = fj.a(this.a);
        long j2 = 0;
        String headerField = a3.getHeaderField(HttpRequest.HEADER_CACHE_CONTROL);
        if (!jq.c(headerField)) {
            String[] split = headerField.split(",");
            int length = split.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                String trim = split[i2].trim();
                if (trim.startsWith("max-age=")) {
                    try {
                        j2 = Long.parseLong(trim.substring(8));
                        break;
                    } catch (NumberFormatException unused3) {
                    }
                } else {
                    i2++;
                }
            }
        }
        final long j3 = j2;
        InputStream inputStream = a3.getInputStream();
        final ByteArrayInputStream a4 = a(inputStream);
        jz.a(inputStream);
        final ht htVar = ht.a;
        if (ht.a(j3) && a2 && (this.b != null || this.c != null)) {
            final URL url = this.a;
            if (htVar.b != null) {
                htVar.f7639e.submit(new Runnable() { // from class: com.tapjoy.internal.ht.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            File createTempFile = File.createTempFile("tj_", null, htVar.b());
                            if (createTempFile == null) {
                                return;
                            }
                            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                            jx.a(a4, fileOutputStream);
                            fileOutputStream.close();
                            long j4 = j3;
                            if (j4 > 604800) {
                                j4 = 604800;
                            }
                            long b = v.b() + (j4 * 1000);
                            synchronized (htVar) {
                                String b2 = htVar.b(url);
                                if (createTempFile.renameTo(htVar.a(b2))) {
                                    htVar.c.edit().putLong(b2, b).commit();
                                }
                            }
                        } catch (FileNotFoundException | IOException unused4) {
                        }
                    }
                });
            }
        }
        if (!z || (bitmap = this.b) == null) {
            return;
        }
        f7653f.a(this.a, bitmap);
    }

    private ByteArrayInputStream a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        jx.a(inputStream, byteArrayOutputStream);
        byteArrayOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
        Cif cif = new Cif();
        cif.a(byteArray);
        ie a = cif.a();
        if (a.b == 0) {
            this.c = byteArray;
            this.f7654d = a;
        } else {
            s sVar = s.a;
            this.b = s.a(byteArrayInputStream);
            byteArrayInputStream.reset();
        }
        return byteArrayInputStream;
    }

    hx(bn bnVar) {
        if (bnVar.k() == bs.STRING) {
            this.a = bnVar.e();
            return;
        }
        bnVar.h();
        String l2 = bnVar.l();
        while (bnVar.j()) {
            if ("url".equals(l2)) {
                this.a = bnVar.e();
            } else {
                bnVar.s();
            }
        }
        bnVar.i();
    }
}

package com.bytedance.sdk.openadsdk.core.video.a.b;

import android.content.Context;
import com.bytedance.sdk.a.b.ab;
import com.bytedance.sdk.a.b.e;
import com.bytedance.sdk.a.b.v;
import com.bytedance.sdk.a.b.y;
import com.bytedance.sdk.openadsdk.core.video.a.a.c;
import com.bytedance.sdk.openadsdk.i.b;
import com.bytedance.sdk.openadsdk.utils.o;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
/* compiled from: VideoPreload.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    private static final HashSet<String> f1782e = new HashSet<>();
    private Context a;
    private long b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private String f1783d;

    public a(Context context, String str, String str2, long j2) {
        this.a = context;
        this.b = j2;
        this.c = str;
        this.f1783d = str2;
    }

    public boolean a() {
        return c.a(this.a, this.f1783d).exists();
    }

    public void b() {
        if (a()) {
            o.c("VideoPreload", "Cache file is exist");
            return;
        }
        HashSet<String> hashSet = f1782e;
        synchronized (hashSet) {
            if (com.bytedance.sdk.openadsdk.core.video.a.a.a(this.f1783d) == null && !hashSet.contains(this.f1783d)) {
                hashSet.add(this.f1783d);
                com.bytedance.sdk.openadsdk.i.a.a().b().execute(new b() { // from class: com.bytedance.sdk.openadsdk.core.video.a.b.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ab abVar;
                        InputStream inputStream;
                        FileOutputStream fileOutputStream;
                        e a = new v().a(new y.a().a("RANGE", "bytes=0-" + a.this.b).a(a.this.c).a().d());
                        File b = c.b(a.this.a, a.this.f1783d);
                        FileOutputStream fileOutputStream2 = null;
                        try {
                            try {
                                abVar = a.a().g();
                                try {
                                    inputStream = abVar.b();
                                    if (inputStream == null) {
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException e2) {
                                                e2.printStackTrace();
                                                return;
                                            }
                                        }
                                        if (abVar != null) {
                                            abVar.close();
                                        }
                                        synchronized (a.f1782e) {
                                            a.f1782e.remove(a.this.f1783d);
                                        }
                                        if (com.bytedance.sdk.openadsdk.core.video.a.a.a(a.this.f1783d) == null) {
                                            if (!b.renameTo(c.a(a.this.a, a.this.f1783d))) {
                                                b.delete();
                                            }
                                            o.c("VideoPreload", "preload success md5 = " + a.this.f1783d);
                                            return;
                                        }
                                        b.delete();
                                        return;
                                    }
                                    try {
                                        try {
                                            if (b.exists()) {
                                                b.delete();
                                            }
                                            fileOutputStream = new FileOutputStream(b);
                                        } catch (IOException e3) {
                                            e = e3;
                                        }
                                        try {
                                            byte[] bArr = new byte[16384];
                                            while (true) {
                                                int read = inputStream.read(bArr);
                                                if (read == -1) {
                                                    break;
                                                }
                                                fileOutputStream.write(bArr, 0, read);
                                            }
                                            fileOutputStream.flush();
                                            fileOutputStream.close();
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                            if (abVar != null) {
                                                abVar.close();
                                            }
                                            synchronized (a.f1782e) {
                                                a.f1782e.remove(a.this.f1783d);
                                            }
                                            if (com.bytedance.sdk.openadsdk.core.video.a.a.a(a.this.f1783d) == null) {
                                                if (!b.renameTo(c.a(a.this.a, a.this.f1783d))) {
                                                    b.delete();
                                                }
                                                o.c("VideoPreload", "preload success md5 = " + a.this.f1783d);
                                                return;
                                            }
                                            b.delete();
                                        } catch (IOException e4) {
                                            e = e4;
                                            fileOutputStream2 = fileOutputStream;
                                            e.printStackTrace();
                                            if (fileOutputStream2 != null) {
                                                fileOutputStream2.close();
                                            }
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                            if (abVar != null) {
                                                abVar.close();
                                            }
                                            synchronized (a.f1782e) {
                                                a.f1782e.remove(a.this.f1783d);
                                            }
                                            if (com.bytedance.sdk.openadsdk.core.video.a.a.a(a.this.f1783d) == null) {
                                                if (!b.renameTo(c.a(a.this.a, a.this.f1783d))) {
                                                    b.delete();
                                                }
                                                o.c("VideoPreload", "preload success md5 = " + a.this.f1783d);
                                                return;
                                            }
                                            b.delete();
                                        } catch (Throwable th) {
                                            th = th;
                                            fileOutputStream2 = fileOutputStream;
                                            if (fileOutputStream2 != null) {
                                                try {
                                                    fileOutputStream2.close();
                                                } catch (IOException e5) {
                                                    e5.printStackTrace();
                                                    throw th;
                                                }
                                            }
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                            if (abVar != null) {
                                                abVar.close();
                                            }
                                            synchronized (a.f1782e) {
                                                a.f1782e.remove(a.this.f1783d);
                                            }
                                            if (com.bytedance.sdk.openadsdk.core.video.a.a.a(a.this.f1783d) == null) {
                                                if (!b.renameTo(c.a(a.this.a, a.this.f1783d))) {
                                                    b.delete();
                                                }
                                                o.c("VideoPreload", "preload success md5 = " + a.this.f1783d);
                                            } else {
                                                b.delete();
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                } catch (IOException e6) {
                                    e = e6;
                                    inputStream = null;
                                } catch (Throwable th3) {
                                    th = th3;
                                    inputStream = null;
                                }
                            } catch (IOException e7) {
                                e = e7;
                                abVar = null;
                                inputStream = null;
                            } catch (Throwable th4) {
                                th = th4;
                                abVar = null;
                                inputStream = null;
                            }
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                    }
                });
                return;
            }
            o.c("VideoPreload", "Cache file is downloading ...");
        }
    }
}

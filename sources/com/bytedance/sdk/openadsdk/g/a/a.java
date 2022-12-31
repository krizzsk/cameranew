package com.bytedance.sdk.openadsdk.g.a;

import android.text.TextUtils;
import android.util.LruCache;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.b.d;
import com.bytedance.sdk.openadsdk.utils.h;
import com.bytedance.sdk.openadsdk.utils.o;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.WeakHashMap;
/* compiled from: GifCache.java */
/* loaded from: classes.dex */
public class a {
    private static String a;

    /* renamed from: e  reason: collision with root package name */
    private static volatile a f1968e;
    private WeakHashMap<String, String> b = new WeakHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private final LruCache<String, C0059a> f1969d = new LruCache<String, C0059a>(5242880) { // from class: com.bytedance.sdk.openadsdk.g.a.a.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: a */
        public int sizeOf(String str, C0059a c0059a) {
            byte[] bArr = c0059a.a;
            int length = bArr != null ? 0 + bArr.length : 0;
            return length == 0 ? super.sizeOf(str, c0059a) : length;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: a */
        public void entryRemoved(boolean z, String str, C0059a c0059a, C0059a c0059a2) {
            super.entryRemoved(z, str, c0059a, c0059a2);
            if (!z || c0059a == null) {
                return;
            }
            c0059a.a = null;
        }
    };
    private final com.bytedance.sdk.openadsdk.b.a c = new d();

    /* compiled from: GifCache.java */
    /* renamed from: com.bytedance.sdk.openadsdk.g.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0059a {
        byte[] a;

        public C0059a(byte[] bArr) {
            this.a = bArr;
        }
    }

    private a() {
    }

    public static a a() {
        if (f1968e == null) {
            synchronized (a.class) {
                if (f1968e == null) {
                    f1968e = new a();
                }
            }
        }
        return f1968e;
    }

    public synchronized void b(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (!a(bArr)) {
                this.f1969d.put(str, new C0059a(bArr));
            }
            File file = new File(b(), str);
            if (file.exists() && file.isFile() && file.length() > 0) {
                return;
            }
            File file2 = new File(file + ".tmp");
            file2.delete();
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    file2.createNewFile();
                    fileOutputStream = new FileOutputStream(file2);
                } catch (IOException unused) {
                }
                try {
                    fileOutputStream.write(bArr);
                    fileOutputStream.flush();
                    if (file2.exists() && file2.length() > 0) {
                        if (file.exists()) {
                            file.delete();
                        }
                        file2.renameTo(file);
                    }
                    this.c.a(file);
                    fileOutputStream.close();
                } catch (Throwable unused2) {
                    fileOutputStream2 = fileOutputStream;
                    file2.delete();
                    file.delete();
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                }
            } catch (Throwable unused3) {
            }
        }
    }

    public synchronized void a(String str, byte[] bArr) {
        b(str, bArr);
    }

    private boolean a(byte[] bArr) {
        return bArr != null && bArr.length >= 3 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70;
    }

    public synchronized File a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(b(), str);
        if (file.exists()) {
            if (file.length() > 0) {
                return file;
            }
        }
        return null;
    }

    public synchronized String a(String str, int i2, int i3, ImageView.ScaleType scaleType) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("https")) {
            str = str.replaceFirst("https", "http");
        }
        String str2 = this.b.get(str);
        if (TextUtils.isEmpty(str2)) {
            String a2 = h.a(str);
            this.b.put(str, a2);
            return a2;
        }
        return str2;
    }

    public synchronized C0059a b(String str) {
        FileInputStream fileInputStream;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0059a c0059a = this.f1969d.get(str);
        if (c0059a != null) {
            return c0059a;
        }
        File file = new File(b(), str);
        if (file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    ByteBuffer allocate = ByteBuffer.allocate(Long.valueOf(file.length()).intValue());
                    fileInputStream.getChannel().read(allocate);
                    C0059a c0059a2 = new C0059a(allocate.array());
                    try {
                        fileInputStream.close();
                    } catch (IOException unused) {
                    }
                    return c0059a2;
                } catch (Throwable th) {
                    th = th;
                    o.c("GifCache", "gifCache get error ", th);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
            }
        }
        return null;
    }

    private static String b() {
        if (TextUtils.isEmpty(a)) {
            File file = new File(com.bytedance.sdk.adnet.a.b(com.bytedance.sdk.openadsdk.core.o.a()), "diskGif");
            file.mkdirs();
            a = file.getAbsolutePath();
        }
        return a;
    }
}

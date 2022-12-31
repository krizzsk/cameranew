package com.bytedance.sdk.openadsdk.g;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.h;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.WeakHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DiskImageCache.java */
/* loaded from: classes.dex */
public class a extends com.bytedance.sdk.adnet.b.a {
    private static String b;
    private WeakHashMap<String, String> c = new WeakHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.b.a f1967d = new com.bytedance.sdk.openadsdk.b.d();

    private a() {
    }

    public static a a() {
        return new a();
    }

    private static String b() {
        if (TextUtils.isEmpty(b)) {
            File file = new File(com.bytedance.sdk.adnet.a.b(o.a()), "diskImage");
            file.mkdirs();
            b = file.getAbsolutePath();
        }
        return b;
    }

    @Override // com.bytedance.sdk.adnet.b.a, com.bytedance.sdk.adnet.b.d.b
    public Bitmap a(String str) {
        FileInputStream fileInputStream;
        Bitmap a = super.a(str);
        if (a == null) {
            File file = new File(b(), str);
            if (file.exists()) {
                FileInputStream fileInputStream2 = null;
                try {
                    try {
                        fileInputStream = new FileInputStream(file);
                    } catch (IOException unused) {
                    }
                    try {
                        a = BitmapFactory.decodeFileDescriptor(fileInputStream.getFD(), null, null);
                        if (a != null) {
                            super.a(str, a);
                        }
                        fileInputStream.close();
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream2 = fileInputStream;
                        try {
                            com.bytedance.sdk.openadsdk.utils.o.c("DiskImageCache", "diskImageCache getBitmap error ", th);
                            if (fileInputStream2 != null) {
                                fileInputStream2.close();
                            }
                            return a;
                        } catch (Throwable th2) {
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException unused2) {
                                }
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        }
        return a;
    }

    @Override // com.bytedance.sdk.adnet.b.a, com.bytedance.sdk.adnet.b.d.b
    public void a(String str, Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        super.a(str, bitmap);
        File file = new File(b(), str);
        if (file.exists() && file.isFile() && file.length() > 0) {
            return;
        }
        File file2 = new File(file + ".tmp");
        file2.delete();
        FileOutputStream fileOutputStream = null;
        try {
            try {
                file2.createNewFile();
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream2);
                    fileOutputStream2.flush();
                    if (file2.exists() && file2.length() > 0) {
                        file2.renameTo(file);
                    }
                    this.f1967d.a(file);
                    fileOutputStream2.close();
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    try {
                        com.bytedance.sdk.openadsdk.utils.o.c("DiskImageCache", "diskImageCache putBitmap error ", th);
                        file2.delete();
                        file.delete();
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (Throwable th2) {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th2;
                    }
                }
            } catch (IOException unused2) {
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Override // com.bytedance.sdk.adnet.b.a, com.bytedance.sdk.adnet.b.d.b
    public String a(String str, int i2, int i3, ImageView.ScaleType scaleType) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = this.c.get(str);
        if (TextUtils.isEmpty(str2)) {
            String a = h.a(str);
            this.c.put(str, a);
            return a;
        }
        return str2;
    }
}

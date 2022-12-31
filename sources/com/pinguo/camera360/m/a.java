package com.pinguo.camera360.m;

import android.content.Context;
import com.tencent.bugly.crashreport.CrashReport;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import us.pinguo.foundation.j;
import us.pinguo.foundation.utils.e;
import us.pinguo.util.i;
import us.pinguo.util.k;
import us.pinguo.util.v;
/* compiled from: GPUImageSdkFactory.java */
/* loaded from: classes3.dex */
public final class a {
    private static final String a = "a";
    private static byte[] c;
    private static final byte[] b = new byte[0];

    /* renamed from: d  reason: collision with root package name */
    private static CopyOnWriteArrayList<b> f6856d = new CopyOnWriteArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private static boolean f6857e = true;

    /* renamed from: f  reason: collision with root package name */
    private static String f6858f = v.a().getFilesDir().getAbsolutePath() + "/effect/installed/";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GPUImageSdkFactory.java */
    /* renamed from: com.pinguo.camera360.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0245a extends Thread {
        final /* synthetic */ byte[] a;
        final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0245a(String str, byte[] bArr, String str2) {
            super(str);
            this.a = bArr;
            this.b = str2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            a.g(this.a, this.b);
        }
    }

    /* compiled from: GPUImageSdkFactory.java */
    /* loaded from: classes3.dex */
    public interface b {
        void reloadResources();
    }

    private static byte[] b(Context context) {
        try {
            return e.c(context, "load_background.jpg");
        } catch (IOException e2) {
            us.pinguo.common.log.a.f(e2);
            return null;
        }
    }

    public static String c() {
        return f6858f + "/shader/frontImage.jpg";
    }

    public static byte[] d() {
        synchronized (b) {
            byte[] bArr = c;
            if (bArr != null && !f6857e) {
                if (bArr.length < 153600) {
                    CrashReport.postCatchedException(new RuntimeException("error front image size:" + c.length));
                }
                return c;
            }
            Context a2 = v.a();
            if (a2 == null) {
                return null;
            }
            byte[] e2 = e(a2);
            c = e2;
            if (e2 == null) {
                us.pinguo.common.log.a.g(a, "初始化加载load_background失败!!!!!!!", new Object[0]);
                CrashReport.postCatchedException(new RuntimeException("error front image size: 0"));
                return null;
            }
            f6857e = false;
            if (e2.length < 153600) {
                CrashReport.postCatchedException(new RuntimeException("error front image size:" + c.length));
            }
            return c;
        }
    }

    private static byte[] e(Context context) {
        byte[] b2;
        byte[] b3;
        String absolutePath = new File(c()).getParentFile().getAbsolutePath();
        StringBuilder sb = new StringBuilder();
        sb.append(absolutePath);
        String str = File.separator;
        sb.append(str);
        sb.append("load_background.jpg");
        String sb2 = sb.toString();
        File file = new File(sb2);
        String k2 = j.e().k("key_front_image_crc32", "");
        if (k2 != null && !"".equals(k2) && !"0".equals(k2)) {
            if (97 >= j.e().h()) {
                return b(context);
            }
            if (file.exists() && (b3 = k.b(file)) != null) {
                if (k2.equals(Long.toHexString(i.b(b3)))) {
                    return b3;
                }
                file.delete();
            }
            File file2 = new File(absolutePath + str + "frontImage.jpg");
            if (file2.exists() && (b2 = k.b(file2)) != null) {
                if (k2.equals(Long.toHexString(i.b(b2)))) {
                    h(b2, sb2);
                    if (b2.length < 153600) {
                        CrashReport.postCatchedException(new RuntimeException("error front image size:" + b2.length));
                        return b(context);
                    }
                    return b2;
                }
                file2.delete();
            }
            return b(context);
        }
        return b(context);
    }

    private static void f() {
        Iterator<b> it = f6856d.iterator();
        while (it.hasNext()) {
            it.next().reloadResources();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(byte[] bArr, String str) {
        if (k.i(str, bArr)) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    private static void h(byte[] bArr, String str) {
        new C0245a("备份线程", bArr, str).start();
    }

    public static void i() {
        f6857e = true;
        f();
    }
}

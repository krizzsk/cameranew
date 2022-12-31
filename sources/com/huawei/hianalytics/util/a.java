package com.huawei.hianalytics.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Pair;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    private static volatile a f5123d;
    private String a;
    private String b;
    private Context c;

    /* renamed from: e  reason: collision with root package name */
    private String f5124e;

    private a(Context context) {
        this.c = context;
        this.f5124e = context.getFilesDir().getPath();
    }

    public static a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f5123d == null) {
                f5123d = new a(context);
            }
            aVar = f5123d;
        }
        return aVar;
    }

    private String a(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException unused) {
        } catch (IOException unused2) {
        }
        try {
            b bVar = new b(1024);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                bVar.a(bArr, read);
            }
            if (bVar.a() == 0) {
                try {
                    fileInputStream.close();
                } catch (IOException unused3) {
                    com.huawei.hianalytics.b.b.c("HiAnalytics/aes128key", "get info from file :IOException");
                }
                return "";
            }
            String str = new String(bVar.b(), "UTF-8");
            try {
                fileInputStream.close();
            } catch (IOException unused4) {
                com.huawei.hianalytics.b.b.c("HiAnalytics/aes128key", "get info from file :IOException");
            }
            return str;
        } catch (FileNotFoundException unused5) {
            fileInputStream2 = fileInputStream;
            com.huawei.hianalytics.b.b.c("HiAnalytics/aes128key", "not find exc from read info to file !");
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException unused6) {
                    com.huawei.hianalytics.b.b.c("HiAnalytics/aes128key", "get info from file :IOException");
                }
            }
            return "";
        } catch (IOException unused7) {
            fileInputStream2 = fileInputStream;
            com.huawei.hianalytics.b.b.c("HiAnalytics/aes128key", "io exc from read info to file");
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException unused8) {
                    com.huawei.hianalytics.b.b.c("HiAnalytics/aes128key", "get info from file :IOException");
                }
            }
            return "";
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException unused9) {
                    com.huawei.hianalytics.b.b.c("HiAnalytics/aes128key", "get info from file :IOException");
                }
            }
            throw th;
        }
    }

    private void a(SharedPreferences sharedPreferences, String str) {
        byte[] c = d.c();
        long currentTimeMillis = System.currentTimeMillis();
        k.b(sharedPreferences, "analytics_key", d.a(c, d.a(c(), c, str)));
        k.a(sharedPreferences, "flashKeyTime", currentTimeMillis);
    }

    private void a(File file, String str) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (FileNotFoundException unused) {
            } catch (IOException unused2) {
            }
            try {
                fileOutputStream.write(str.getBytes("UTF-8"));
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (FileNotFoundException unused3) {
                fileOutputStream2 = fileOutputStream;
                com.huawei.hianalytics.b.b.c("HiAnalytics/aes128key", "not find exc from save info to file !");
                if (fileOutputStream2 == null) {
                    return;
                }
                fileOutputStream2.close();
            } catch (IOException unused4) {
                fileOutputStream2 = fileOutputStream;
                com.huawei.hianalytics.b.b.c("HiAnalytics/aes128key", "io exc from write info to file");
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused5) {
                        com.huawei.hianalytics.b.b.c("HiAnalytics/aes128key", "OutputStream is not close");
                    }
                }
                throw th;
            }
        } catch (IOException unused6) {
            com.huawei.hianalytics.b.b.c("HiAnalytics/aes128key", "OutputStream is not close");
        }
    }

    private String b(Context context) {
        SharedPreferences a = k.a(context, "analytics_key");
        String a2 = k.a(a, "analytics_key", "");
        if (!TextUtils.isEmpty(a2)) {
            Pair<byte[], String> b = d.b(a2);
            String b2 = d.b(c(), (byte[]) b.first, (String) b.second);
            if (!TextUtils.isEmpty(b2)) {
                return b2;
            }
        }
        String a3 = d.a();
        a(a, a3);
        return a3;
    }

    private String b(String str) {
        String str2 = this.f5124e + File.separator + str;
        File file = new File(str2);
        if (!file.exists() && !file.mkdirs()) {
            com.huawei.hianalytics.b.b.d("HiAnalytics/aes128key", "aes file create fail!");
        }
        File file2 = new File(str2, "hianalytics_" + str);
        String a = a(file2);
        if (TextUtils.isEmpty(a)) {
            String b = d.b();
            a(file2, b);
            return b;
        }
        return a;
    }

    private void b() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f5124e);
        String str = File.separator;
        sb.append(str);
        sb.append("secondAssembly");
        String str2 = this.f5124e + str + "thirdAssembly";
        String str3 = this.f5124e + str + "fourthAssembly";
        a(new File(sb.toString(), "hianalytics_secondAssembly"), d.b());
        a(new File(str2, "hianalytics_thirdAssembly"), d.b());
        a(new File(str3, "hianalytics_fourthAssembly"), d.b());
        a(new File(this.f5124e + str + "fiveAssembly", "hianalytics_fiveAssembly"), d.b());
    }

    private String c() {
        if (TextUtils.isEmpty(this.a)) {
            this.a = e();
        }
        return this.a;
    }

    private String d() {
        String a = n.a();
        String b = com.huawei.hianalytics.a.a.b();
        String a2 = h.a();
        return n.a(a + b + a2, 4);
    }

    private String e() {
        return n.a(d(), b("secondAssembly"), b("thirdAssembly"), b("fourthAssembly"), b("fiveAssembly"));
    }

    public String a() {
        if (TextUtils.isEmpty(this.b)) {
            this.b = b(this.c);
        }
        return this.b;
    }

    public void a(String str) {
        SharedPreferences a = k.a(this.c, "analytics_key");
        long b = k.b(a, "flashKeyTime", -1L);
        if (TextUtils.isEmpty(str) || System.currentTimeMillis() - b <= 43200000) {
            return;
        }
        this.b = str;
        long b2 = k.b(a, "assemblyFlash", -1L);
        int i2 = (b2 > (-1L) ? 1 : (b2 == (-1L) ? 0 : -1));
        long currentTimeMillis = System.currentTimeMillis();
        if (i2 == 0) {
            k.a(a, "assemblyFlash", currentTimeMillis);
        } else if (currentTimeMillis - b2 > 31536000000L) {
            b();
            k.a(a, "assemblyFlash", System.currentTimeMillis());
            this.a = e();
        }
        a(a, str);
    }
}

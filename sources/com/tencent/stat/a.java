package com.tencent.stat;

import android.content.Context;
import android.os.Environment;
import android.provider.Settings;
import com.tencent.stat.common.StatLogger;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
/* loaded from: classes3.dex */
public class a {
    private static a b;
    private StatLogger a = com.tencent.stat.common.k.b();
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8249d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f8250e;

    /* renamed from: f  reason: collision with root package name */
    private Context f8251f;

    private a(Context context) {
        this.c = false;
        this.f8249d = false;
        this.f8250e = false;
        this.f8251f = null;
        this.f8251f = context.getApplicationContext();
        this.c = b(context);
        this.f8249d = d(context);
        this.f8250e = c(context);
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (b == null) {
                b = new a(context);
            }
            aVar = b;
        }
        return aVar;
    }

    private boolean b(Context context) {
        if (com.tencent.stat.common.k.a(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            return true;
        }
        this.a.e("Check permission failed: android.permission.WRITE_EXTERNAL_STORAGE");
        return false;
    }

    private boolean c(Context context) {
        if (com.tencent.stat.common.k.a(context, "android.permission.WRITE_SETTINGS")) {
            return true;
        }
        this.a.e("Check permission failed: android.permission.WRITE_SETTINGS");
        return false;
    }

    private boolean d(Context context) {
        if (com.tencent.stat.common.k.d() < 14) {
            return b(context);
        }
        return true;
    }

    public boolean a(String str, String str2) {
        com.tencent.stat.common.p.b(this.f8251f, str, str2);
        return true;
    }

    public String b(String str, String str2) {
        return com.tencent.stat.common.p.a(this.f8251f, str, str2);
    }

    public boolean c(String str, String str2) {
        if (this.c) {
            try {
                com.tencent.stat.common.d.a(Environment.getExternalStorageDirectory() + "/Tencent/mta");
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(Environment.getExternalStorageDirectory(), "Tencent/mta/.mid.txt")));
                bufferedWriter.write(str + "," + str2);
                bufferedWriter.write("\n");
                bufferedWriter.close();
                return true;
            } catch (Throwable th) {
                this.a.w(th);
                return false;
            }
        }
        return false;
    }

    public String d(String str, String str2) {
        if (this.c) {
            try {
                for (String str3 : com.tencent.stat.common.d.a(new File(Environment.getExternalStorageDirectory(), "Tencent/mta/.mid.txt"))) {
                    String[] split = str3.split(",");
                    if (split.length == 2 && split[0].equals(str)) {
                        return split[1];
                    }
                }
            } catch (FileNotFoundException unused) {
                this.a.w("Tencent/mta/.mid.txt not found.");
            } catch (Throwable th) {
                this.a.w(th);
            }
            return null;
        }
        return null;
    }

    public boolean e(String str, String str2) {
        if (this.f8250e) {
            Settings.System.putString(this.f8251f.getContentResolver(), str, str2);
            return true;
        }
        return false;
    }

    public String f(String str, String str2) {
        return !this.f8250e ? str2 : Settings.System.getString(this.f8251f.getContentResolver(), str);
    }
}

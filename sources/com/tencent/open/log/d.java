package com.tencent.open.log;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import java.text.SimpleDateFormat;
/* compiled from: ProGuard */
/* loaded from: classes3.dex */
public class d {

    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    public static final class a {
        public static final boolean a(int i2, int i3) {
            return i3 == (i2 & i3);
        }
    }

    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    public static final class b {
        public static boolean a() {
            String externalStorageState = Environment.getExternalStorageState();
            return "mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState);
        }

        public static c b() {
            if (a()) {
                return c.b(Environment.getExternalStorageDirectory());
            }
            return null;
        }
    }

    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    public static class c {
        private File a;
        private long b;
        private long c;

        public File a() {
            return this.a;
        }

        public long b() {
            return this.b;
        }

        public long c() {
            return this.c;
        }

        public String toString() {
            return String.format("[%s : %d / %d]", a().getAbsolutePath(), Long.valueOf(c()), Long.valueOf(b()));
        }

        public void a(File file) {
            this.a = file;
        }

        public void b(long j2) {
            this.c = j2;
        }

        public static c b(File file) {
            StatFs statFs;
            c cVar = new c();
            cVar.a(file);
            long blockSize = new StatFs(file.getAbsolutePath()).getBlockSize();
            cVar.a(statFs.getBlockCount() * blockSize);
            cVar.b(statFs.getAvailableBlocks() * blockSize);
            return cVar;
        }

        public void a(long j2) {
            this.b = j2;
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.log.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0282d {
        @SuppressLint({"SimpleDateFormat"})
        public static SimpleDateFormat a(String str) {
            return new SimpleDateFormat(str);
        }
    }

    public static boolean a(String str) {
        return str.contains("access_token") || str.contains("pay_token") || str.contains("pfkey") || str.contains("expires_in") || str.contains("openid") || str.contains("proxy_code") || str.contains("proxy_expires_in");
    }

    public static Bundle b(Bundle bundle) {
        if (a(bundle)) {
            Bundle bundle2 = new Bundle(bundle);
            bundle2.remove("access_token");
            bundle2.remove("pay_token");
            bundle2.remove("pfkey");
            bundle2.remove("expires_in");
            bundle2.remove("openid");
            bundle2.remove("proxy_code");
            bundle2.remove("proxy_expires_in");
            return bundle2;
        }
        return bundle;
    }

    public static boolean a(Bundle bundle) {
        return bundle.containsKey("access_token") || bundle.containsKey("pay_token") || bundle.containsKey("pfkey") || bundle.containsKey("expires_in") || bundle.containsKey("openid") || bundle.containsKey("proxy_code") || bundle.containsKey("proxy_expires_in");
    }
}

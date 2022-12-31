package vStudio.Android.Camera360.activity;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;
/* compiled from: SystemInfo.java */
/* loaded from: classes7.dex */
public class h {
    private volatile boolean a;
    private long b = -1;
    private long c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f12592d = 0;

    /* renamed from: e  reason: collision with root package name */
    private long f12593e = -1;

    /* renamed from: f  reason: collision with root package name */
    private String f12594f = null;

    private h() {
        this.a = false;
        if (this.a) {
            return;
        }
        this.a = true;
        try {
            d();
        } catch (Exception unused) {
        }
        try {
            e();
        } catch (Exception unused2) {
        }
        try {
            f();
        } catch (Exception unused3) {
        }
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static h b() {
        return new h();
    }

    private boolean c(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt < '0' || charAt > '9') {
                return false;
            }
        }
        return true;
    }

    private void d() throws IOException {
        BufferedReader bufferedReader;
        Throwable th;
        int indexOf;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        String trim = readLine.trim();
                        if (!trim.isEmpty() && (indexOf = trim.indexOf(58)) != -1) {
                            String trim2 = trim.substring(0, indexOf).trim();
                            String trim3 = trim.substring(indexOf + 1).trim();
                            if ("processor".equals(trim2)) {
                                if (c(trim3)) {
                                    this.f12592d++;
                                }
                            } else if ("Hardware".equals(trim2)) {
                                this.f12594f = trim3;
                            }
                        }
                    } else {
                        a(bufferedReader);
                        return;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    a(bufferedReader);
                    throw th;
                }
            }
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    private void e() throws Exception {
        BufferedReader bufferedReader;
        Throwable th;
        try {
            bufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"));
            try {
                this.f12593e = Integer.parseInt(bufferedReader.readLine().trim()) / 1000;
                a(bufferedReader);
            } catch (Throwable th2) {
                th = th2;
                a(bufferedReader);
                throw th;
            }
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    private void f() throws IOException {
        BufferedReader bufferedReader;
        Throwable th;
        int indexOf;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        String trim = readLine.trim();
                        if (!trim.isEmpty() && (indexOf = trim.indexOf(58)) != -1) {
                            String trim2 = trim.substring(0, indexOf).trim();
                            String trim3 = trim.substring(indexOf + 1).trim();
                            if ("MemTotal".equals(trim2)) {
                                this.b = Long.parseLong(trim3.split(" ")[0]) / 1024;
                            } else if ("MemFree".equals(trim2)) {
                                this.c = Long.parseLong(trim3.split(" ")[0]) / 1024;
                            }
                        }
                    } else {
                        a(bufferedReader);
                        return;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    a(bufferedReader);
                    throw th;
                }
            }
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            long r1 = r7.b
            r3 = -1
            r5 = 59
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 == 0) goto L25
            long r1 = r7.c
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 != 0) goto L16
            goto L25
        L16:
            r0.append(r1)
            r0.append(r5)
            long r1 = r7.b
            r0.append(r1)
            r0.append(r5)
            goto L2a
        L25:
            java.lang.String r1 = ";;"
            r0.append(r1)
        L2a:
            long r1 = r7.f12593e
            r3 = 0
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 <= 0) goto L35
            r0.append(r1)
        L35:
            r0.append(r5)
            int r1 = r7.f12592d
            if (r1 <= 0) goto L3f
            r0.append(r1)
        L3f:
            r0.append(r5)
            java.lang.String r1 = r7.f12594f
            if (r1 == 0) goto L49
            r0.append(r1)
        L49:
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: vStudio.Android.Camera360.activity.h.toString():java.lang.String");
    }
}

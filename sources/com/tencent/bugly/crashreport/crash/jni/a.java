package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.util.Map;
/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public final class a implements NativeExceptionHandler {
    private final Context a;
    private final com.tencent.bugly.crashreport.crash.b b;
    private final com.tencent.bugly.crashreport.common.info.a c;

    /* renamed from: d  reason: collision with root package name */
    private final com.tencent.bugly.crashreport.common.strategy.a f7916d;

    public a(Context context, com.tencent.bugly.crashreport.common.info.a aVar, com.tencent.bugly.crashreport.crash.b bVar, com.tencent.bugly.crashreport.common.strategy.a aVar2) {
        this.a = context;
        this.b = bVar;
        this.c = aVar;
        this.f7916d = aVar2;
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final void handleNativeException(int i2, int i3, long j2, long j3, String str, String str2, String str3, String str4, int i4, String str5, int i5, int i6, int i7, String str6, String str7) {
        x.a("Native Crash Happen v1", new Object[0]);
        handleNativeException2(i2, i3, j2, j3, str, str2, str3, str4, i4, str5, i5, i6, i7, str6, str7, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0149 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x011d A[Catch: all -> 0x0298, TryCatch #2 {all -> 0x0298, blocks: (B:3:0x0010, B:6:0x001c, B:15:0x0069, B:18:0x0071, B:20:0x0074, B:22:0x0078, B:24:0x0093, B:25:0x009c, B:26:0x00a6, B:28:0x00b0, B:30:0x00ba, B:32:0x00c2, B:34:0x00ce, B:36:0x00d8, B:39:0x00df, B:41:0x00ee, B:43:0x00fa, B:46:0x0101, B:47:0x0117, B:49:0x011d, B:51:0x012d, B:54:0x014d, B:56:0x0187, B:58:0x01ac, B:59:0x01b3, B:62:0x01bf, B:64:0x01c7, B:55:0x0165, B:40:0x00ea, B:27:0x00a9, B:9:0x0041, B:10:0x0045, B:12:0x004f), top: B:98:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x014d A[Catch: all -> 0x0298, TryCatch #2 {all -> 0x0298, blocks: (B:3:0x0010, B:6:0x001c, B:15:0x0069, B:18:0x0071, B:20:0x0074, B:22:0x0078, B:24:0x0093, B:25:0x009c, B:26:0x00a6, B:28:0x00b0, B:30:0x00ba, B:32:0x00c2, B:34:0x00ce, B:36:0x00d8, B:39:0x00df, B:41:0x00ee, B:43:0x00fa, B:46:0x0101, B:47:0x0117, B:49:0x011d, B:51:0x012d, B:54:0x014d, B:56:0x0187, B:58:0x01ac, B:59:0x01b3, B:62:0x01bf, B:64:0x01c7, B:55:0x0165, B:40:0x00ea, B:27:0x00a9, B:9:0x0041, B:10:0x0045, B:12:0x004f), top: B:98:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01ac A[Catch: all -> 0x0298, TryCatch #2 {all -> 0x0298, blocks: (B:3:0x0010, B:6:0x001c, B:15:0x0069, B:18:0x0071, B:20:0x0074, B:22:0x0078, B:24:0x0093, B:25:0x009c, B:26:0x00a6, B:28:0x00b0, B:30:0x00ba, B:32:0x00c2, B:34:0x00ce, B:36:0x00d8, B:39:0x00df, B:41:0x00ee, B:43:0x00fa, B:46:0x0101, B:47:0x0117, B:49:0x011d, B:51:0x012d, B:54:0x014d, B:56:0x0187, B:58:0x01ac, B:59:0x01b3, B:62:0x01bf, B:64:0x01c7, B:55:0x0165, B:40:0x00ea, B:27:0x00a9, B:9:0x0041, B:10:0x0045, B:12:0x004f), top: B:98:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01bf A[Catch: all -> 0x0298, TRY_ENTER, TryCatch #2 {all -> 0x0298, blocks: (B:3:0x0010, B:6:0x001c, B:15:0x0069, B:18:0x0071, B:20:0x0074, B:22:0x0078, B:24:0x0093, B:25:0x009c, B:26:0x00a6, B:28:0x00b0, B:30:0x00ba, B:32:0x00c2, B:34:0x00ce, B:36:0x00d8, B:39:0x00df, B:41:0x00ee, B:43:0x00fa, B:46:0x0101, B:47:0x0117, B:49:0x011d, B:51:0x012d, B:54:0x014d, B:56:0x0187, B:58:0x01ac, B:59:0x01b3, B:62:0x01bf, B:64:0x01c7, B:55:0x0165, B:40:0x00ea, B:27:0x00a9, B:9:0x0041, B:10:0x0045, B:12:0x004f), top: B:98:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0223 A[Catch: all -> 0x0294, TryCatch #1 {all -> 0x0294, blocks: (B:67:0x021d, B:69:0x0223, B:71:0x022c), top: B:97:0x021d }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x022c A[Catch: all -> 0x0294, TRY_LEAVE, TryCatch #1 {all -> 0x0294, blocks: (B:67:0x021d, B:69:0x0223, B:71:0x022c), top: B:97:0x021d }] */
    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void handleNativeException2(int r27, int r28, long r29, long r31, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, int r37, java.lang.String r38, int r39, int r40, int r41, java.lang.String r42, java.lang.String r43, java.lang.String[] r44) {
        /*
            Method dump skipped, instructions count: 676
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.a.handleNativeException2(int, int, long, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, int, int, int, java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final CrashDetailBean packageCrashDatas(String str, String str2, long j2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, byte[] bArr, Map<String, String> map, boolean z, boolean z2) {
        int i2;
        String str12;
        int indexOf;
        boolean m = c.a().m();
        if (m) {
            x.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.b = 1;
        crashDetailBean.f7843e = this.c.h();
        com.tencent.bugly.crashreport.common.info.a aVar = this.c;
        crashDetailBean.f7844f = aVar.f7824k;
        crashDetailBean.f7845g = aVar.q();
        crashDetailBean.m = this.c.g();
        crashDetailBean.n = str3;
        crashDetailBean.o = m ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
        crashDetailBean.p = str4;
        String str13 = str5 != null ? str5 : "";
        crashDetailBean.q = str13;
        crashDetailBean.r = j2;
        crashDetailBean.u = z.a(str13.getBytes());
        crashDetailBean.A = str;
        crashDetailBean.B = str2;
        crashDetailBean.I = this.c.s();
        crashDetailBean.f7846h = this.c.p();
        crashDetailBean.f7847i = this.c.B();
        crashDetailBean.v = str8;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        String dumpFilePath = nativeCrashHandler != null ? nativeCrashHandler.getDumpFilePath() : null;
        String a = b.a(dumpFilePath, str8);
        if (!z.a(a)) {
            crashDetailBean.V = a;
        }
        crashDetailBean.W = b.b(dumpFilePath);
        crashDetailBean.w = b.a(str9, c.f7873e, null, false);
        crashDetailBean.x = b.a(str10, c.f7873e, null, true);
        crashDetailBean.J = str7;
        crashDetailBean.K = str6;
        crashDetailBean.L = str11;
        crashDetailBean.F = this.c.k();
        crashDetailBean.G = this.c.j();
        crashDetailBean.H = this.c.l();
        if (z) {
            crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.g();
            crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.e();
            crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.i();
            if (crashDetailBean.w == null) {
                crashDetailBean.w = z.a(this.a, c.f7873e, (String) null);
            }
            crashDetailBean.y = y.a();
            com.tencent.bugly.crashreport.common.info.a aVar2 = this.c;
            crashDetailBean.M = aVar2.a;
            crashDetailBean.N = aVar2.a();
            crashDetailBean.z = z.a(c.f7874f, false);
            int indexOf2 = crashDetailBean.q.indexOf("java:\n");
            if (indexOf2 > 0 && (i2 = indexOf2 + 6) < crashDetailBean.q.length()) {
                String str14 = crashDetailBean.q;
                String substring = str14.substring(i2, str14.length() - 1);
                if (substring.length() > 0 && crashDetailBean.z.containsKey(crashDetailBean.B) && (indexOf = (str12 = crashDetailBean.z.get(crashDetailBean.B)).indexOf(substring)) > 0) {
                    String substring2 = str12.substring(indexOf);
                    crashDetailBean.z.put(crashDetailBean.B, substring2);
                    crashDetailBean.q = crashDetailBean.q.substring(0, i2);
                    crashDetailBean.q += substring2;
                }
            }
            if (str == null) {
                crashDetailBean.A = this.c.f7817d;
            }
            this.b.d(crashDetailBean);
            crashDetailBean.Q = this.c.z();
            crashDetailBean.R = this.c.A();
            crashDetailBean.S = this.c.t();
            crashDetailBean.T = this.c.y();
        } else {
            crashDetailBean.C = -1L;
            crashDetailBean.D = -1L;
            crashDetailBean.E = -1L;
            if (crashDetailBean.w == null) {
                crashDetailBean.w = "this crash is occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc.";
            }
            crashDetailBean.M = -1L;
            crashDetailBean.Q = -1;
            crashDetailBean.R = -1;
            crashDetailBean.S = map;
            crashDetailBean.T = this.c.y();
            crashDetailBean.z = null;
            if (str == null) {
                crashDetailBean.A = "unknown(record)";
            }
            if (bArr != null) {
                crashDetailBean.y = bArr;
            }
        }
        return crashDetailBean;
    }
}

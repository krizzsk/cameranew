package com.tencent.bugly.proguard;

import android.content.Context;
import com.tapjoy.TapjoyConstants;
import com.tencent.bugly.BuglyStrategy;
import java.util.Map;
import java.util.UUID;
/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public final class v implements Runnable {
    private int a;
    private int b;
    private final Context c;

    /* renamed from: d  reason: collision with root package name */
    private final int f8014d;

    /* renamed from: e  reason: collision with root package name */
    private final byte[] f8015e;

    /* renamed from: f  reason: collision with root package name */
    private final com.tencent.bugly.crashreport.common.info.a f8016f;

    /* renamed from: g  reason: collision with root package name */
    private final com.tencent.bugly.crashreport.common.strategy.a f8017g;

    /* renamed from: h  reason: collision with root package name */
    private final s f8018h;

    /* renamed from: i  reason: collision with root package name */
    private final u f8019i;

    /* renamed from: j  reason: collision with root package name */
    private final int f8020j;

    /* renamed from: k  reason: collision with root package name */
    private final t f8021k;

    /* renamed from: l  reason: collision with root package name */
    private final t f8022l;
    private String m;
    private final String n;
    private final Map<String, String> o;
    private int p;
    private long q;
    private long r;
    private boolean s;

    public v(Context context, int i2, int i3, byte[] bArr, String str, String str2, t tVar, boolean z, boolean z2) {
        this(context, i2, i3, bArr, str, str2, tVar, 2, BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH, z2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(com.tencent.bugly.proguard.an r4, boolean r5, int r6, java.lang.String r7) {
        /*
            r3 = this;
            int r4 = r3.f8014d
            r0 = 630(0x276, float:8.83E-43)
            if (r4 == r0) goto L1a
            r0 = 640(0x280, float:8.97E-43)
            if (r4 == r0) goto L17
            r0 = 830(0x33e, float:1.163E-42)
            if (r4 == r0) goto L1a
            r0 = 840(0x348, float:1.177E-42)
            if (r4 == r0) goto L17
            java.lang.String r4 = java.lang.String.valueOf(r4)
            goto L1c
        L17:
            java.lang.String r4 = "userinfo"
            goto L1c
        L1a:
            java.lang.String r4 = "crash"
        L1c:
            r0 = 1
            r1 = 0
            if (r5 == 0) goto L2a
            java.lang.Object[] r6 = new java.lang.Object[r0]
            r6[r1] = r4
            java.lang.String r4 = "[Upload] Success: %s"
            com.tencent.bugly.proguard.x.a(r4, r6)
            goto L3d
        L2a:
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r2[r1] = r6
            r2[r0] = r4
            r4 = 2
            r2[r4] = r7
            java.lang.String r4 = "[Upload] Failed to upload(%d) %s: %s"
            com.tencent.bugly.proguard.x.e(r4, r2)
        L3d:
            long r6 = r3.q
            long r0 = r3.r
            long r6 = r6 + r0
            r0 = 0
            int r4 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r4 <= 0) goto L5d
            com.tencent.bugly.proguard.u r4 = r3.f8019i
            boolean r6 = r3.s
            long r6 = r4.a(r6)
            long r0 = r3.q
            long r6 = r6 + r0
            long r0 = r3.r
            long r6 = r6 + r0
            com.tencent.bugly.proguard.u r4 = r3.f8019i
            boolean r0 = r3.s
            r4.a(r6, r0)
        L5d:
            com.tencent.bugly.proguard.t r4 = r3.f8021k
            if (r4 == 0) goto L64
            r4.a(r5)
        L64:
            com.tencent.bugly.proguard.t r4 = r3.f8022l
            if (r4 == 0) goto L6b
            r4.a(r5)
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.v.a(com.tencent.bugly.proguard.an, boolean, int, java.lang.String):void");
    }

    public final void b(long j2) {
        this.r += j2;
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x0220 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01ba A[Catch: all -> 0x0332, TryCatch #0 {all -> 0x0332, blocks: (B:3:0x0007, B:5:0x001a, B:8:0x0022, B:11:0x0027, B:13:0x003b, B:15:0x003f, B:17:0x0043, B:20:0x0049, B:22:0x004f, B:24:0x0055, B:26:0x0082, B:27:0x0085, B:29:0x00b4, B:32:0x00bc, B:34:0x00c2, B:35:0x00d6, B:38:0x00de, B:40:0x00f5, B:41:0x0102, B:44:0x0145, B:46:0x0158, B:49:0x0160, B:52:0x0167, B:55:0x016f, B:67:0x01ba, B:69:0x01e6, B:70:0x01ee, B:72:0x01f4, B:73:0x0215, B:78:0x024f, B:80:0x0262, B:82:0x0273, B:83:0x027b, B:85:0x0281, B:86:0x029c, B:89:0x02a5, B:91:0x02ac, B:94:0x02b4, B:96:0x02ba, B:98:0x02c1, B:102:0x02d5, B:104:0x02e8, B:106:0x02ef, B:101:0x02d4, B:109:0x02f7, B:57:0x0179, B:59:0x017f, B:60:0x0187, B:62:0x0195, B:63:0x01a1, B:64:0x01ae, B:111:0x031d, B:113:0x0324, B:115:0x032b), top: B:123:0x0007 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 829
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.v.run():void");
    }

    public v(Context context, int i2, int i3, byte[] bArr, String str, String str2, t tVar, int i4, int i5, boolean z, Map<String, String> map) {
        this.a = 2;
        this.b = BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;
        this.m = null;
        this.p = 0;
        this.q = 0L;
        this.r = 0L;
        this.s = false;
        this.c = context;
        this.f8016f = com.tencent.bugly.crashreport.common.info.a.a(context);
        this.f8015e = bArr;
        this.f8017g = com.tencent.bugly.crashreport.common.strategy.a.a();
        this.f8018h = s.a(context);
        this.f8019i = u.a();
        this.f8020j = i2;
        this.m = str;
        this.n = str2;
        this.f8021k = tVar;
        this.f8022l = null;
        this.f8014d = i3;
        if (i4 > 0) {
            this.a = i4;
        }
        if (i5 > 0) {
            this.b = i5;
        }
        this.s = z;
        this.o = map;
    }

    private static boolean a(an anVar, com.tencent.bugly.crashreport.common.info.a aVar, com.tencent.bugly.crashreport.common.strategy.a aVar2) {
        if (anVar == null) {
            x.d("resp == null!", new Object[0]);
            return false;
        }
        byte b = anVar.a;
        if (b != 0) {
            x.e("resp result error %d", Byte.valueOf(b));
            return false;
        }
        try {
            if (!z.a(anVar.f7948e) && !com.tencent.bugly.crashreport.common.info.a.b().i().equals(anVar.f7948e)) {
                p.a().a(com.tencent.bugly.crashreport.common.strategy.a.a, TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, anVar.f7948e.getBytes("UTF-8"), (o) null, true);
                aVar.e(anVar.f7948e);
            }
        } catch (Throwable th) {
            x.a(th);
        }
        aVar.f7823j = anVar.f7947d;
        int i2 = anVar.b;
        if (i2 == 510) {
            byte[] bArr = anVar.c;
            if (bArr == null) {
                x.e("[Upload] Strategy data is null. Response cmd: %d", Integer.valueOf(i2));
                return false;
            }
            ap apVar = (ap) a.a(bArr, ap.class);
            if (apVar == null) {
                x.e("[Upload] Failed to decode strategy from server. Response cmd: %d", Integer.valueOf(anVar.b));
                return false;
            }
            aVar2.a(apVar);
        }
        return true;
    }

    public final void a(long j2) {
        this.p++;
        this.q += j2;
    }

    private static String a(String str) {
        if (z.a(str)) {
            return str;
        }
        try {
            return String.format("%s?aid=%s", str, UUID.randomUUID().toString());
        } catch (Throwable th) {
            x.a(th);
            return str;
        }
    }
}

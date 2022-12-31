package us.pinguo.camera360.loc;

import android.os.Build;
import android.text.TextUtils;
import java.util.regex.Pattern;
import us.pinguo.loc.q;
import us.pinguo.performance.manager.PerformanceLevelManager;
/* compiled from: LocAdapter.java */
/* loaded from: classes3.dex */
public class c {
    private static volatile q a;
    private static boolean b;

    static {
        b();
    }

    private static void a(q qVar) {
        if (qVar != null) {
            if (!d(qVar)) {
                us.pinguo.common.log.a.k("not current phone,filter modelInfo:" + qVar, new Object[0]);
                return;
            }
            if (a == null) {
                a = new q();
            }
            if (!TextUtils.isEmpty(qVar.a)) {
                a.a = qVar.a;
            }
            if (!TextUtils.isEmpty(qVar.b)) {
                a.b = qVar.b;
            }
            if (!TextUtils.isEmpty(qVar.c)) {
                a.c = qVar.c;
            }
            if (!TextUtils.isEmpty(qVar.f11544d)) {
                a.f11544d = qVar.f11544d;
            }
            if (!TextUtils.isEmpty(qVar.f11546f)) {
                a.f11546f = qVar.f11546f;
            }
            if (!TextUtils.isEmpty(qVar.f11547g)) {
                a.f11547g = qVar.f11547g;
            }
            if (!TextUtils.isEmpty(qVar.f11548h)) {
                a.f11548h = qVar.f11548h;
            }
            if (!TextUtils.isEmpty(qVar.f11545e)) {
                a.f11545e = qVar.f11545e;
            }
            us.pinguo.common.log.a.k("is current phone,modelInfo:" + a.toString(), new Object[0]);
        }
    }

    private static void b() {
        q qVar = new q();
        qVar.a = "-20";
        a(qVar);
        q qVar2 = new q();
        qVar2.f11546f = ".*MT67[35].+";
        qVar2.f11548h = "false";
        a(qVar2);
        q qVar3 = new q();
        qVar3.f11546f = "MT6580";
        a(qVar3);
        q qVar4 = new q();
        qVar4.f11546f = ".*kirin.*(920|935|960)";
        qVar4.f11548h = "false";
        a(qVar4);
        q qVar5 = new q();
        qVar5.f11546f = "UNIVERSAL3475|M86";
        qVar5.f11548h = "false";
        a(qVar5);
        q qVar6 = new q();
        qVar6.f11544d = "MotoG3|A33fw|ASUS_Z00ADB|MX5";
        a(qVar6);
        q qVar7 = new q();
        qVar7.f11544d = "MHA-AL00|LON-AL00|DUK-AL20|VTR-AL00|VKY-AL00";
        qVar7.f11548h = "false";
        a(qVar7);
        q qVar8 = new q();
        qVar8.f11544d = "PRO 6";
        a(qVar8);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0092, code lost:
        if (java.lang.Integer.valueOf(r7).intValue() == r2) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean c(us.pinguo.loc.q r7) {
        /*
            if (r7 != 0) goto L5
            java.lang.String r7 = ""
            goto L7
        L5:
            java.lang.String r7 = r7.a
        L7:
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            r1 = 1
            if (r0 == 0) goto Lf
            return r1
        Lf:
            r0 = 0
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.NumberFormatException -> Lbb
            char r3 = r7.charAt(r0)     // Catch: java.lang.NumberFormatException -> Lbb
            r4 = 43
            if (r3 != r4) goto L2b
            java.lang.String r3 = r7.substring(r1)     // Catch: java.lang.NumberFormatException -> Lbb
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.NumberFormatException -> Lbb
            int r3 = r3.intValue()     // Catch: java.lang.NumberFormatException -> Lbb
            if (r2 < r3) goto L29
            goto L94
        L29:
            r1 = 0
            goto L94
        L2b:
            char r3 = r7.charAt(r0)     // Catch: java.lang.NumberFormatException -> Lbb
            r4 = 45
            if (r3 != r4) goto L42
            java.lang.String r3 = r7.substring(r1)     // Catch: java.lang.NumberFormatException -> Lbb
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.NumberFormatException -> Lbb
            int r3 = r3.intValue()     // Catch: java.lang.NumberFormatException -> Lbb
            if (r2 > r3) goto L29
            goto L94
        L42:
            r3 = 126(0x7e, float:1.77E-43)
            int r4 = r7.indexOf(r3)     // Catch: java.lang.NumberFormatException -> Lbb
            if (r4 <= 0) goto L8a
            int r3 = r7.indexOf(r3)     // Catch: java.lang.NumberFormatException -> Lbb
            java.lang.String r4 = r7.substring(r0, r3)     // Catch: java.lang.NumberFormatException -> Lbb
            int r3 = r3 + r1
            java.lang.String r3 = r7.substring(r3)     // Catch: java.lang.NumberFormatException -> Lbb
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.NumberFormatException -> Lbb
            int r4 = r4.intValue()     // Catch: java.lang.NumberFormatException -> Lbb
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.NumberFormatException -> Lbb
            int r3 = r3.intValue()     // Catch: java.lang.NumberFormatException -> Lbb
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.NumberFormatException -> Lbb
            r5.<init>()     // Catch: java.lang.NumberFormatException -> Lbb
            java.lang.String r6 = "startApi:"
            r5.append(r6)     // Catch: java.lang.NumberFormatException -> Lbb
            r5.append(r4)     // Catch: java.lang.NumberFormatException -> Lbb
            java.lang.String r6 = " endApi:"
            r5.append(r6)     // Catch: java.lang.NumberFormatException -> Lbb
            r5.append(r3)     // Catch: java.lang.NumberFormatException -> Lbb
            java.lang.String r5 = r5.toString()     // Catch: java.lang.NumberFormatException -> Lbb
            java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch: java.lang.NumberFormatException -> Lbb
            us.pinguo.common.log.a.k(r5, r6)     // Catch: java.lang.NumberFormatException -> Lbb
            if (r2 < r4) goto L29
            if (r2 > r3) goto L29
            goto L94
        L8a:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.NumberFormatException -> Lbb
            int r3 = r3.intValue()     // Catch: java.lang.NumberFormatException -> Lbb
            if (r3 != r2) goto L29
        L94:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.NumberFormatException -> Lbb
            r3.<init>()     // Catch: java.lang.NumberFormatException -> Lbb
            java.lang.String r4 = "currentApi:"
            r3.append(r4)     // Catch: java.lang.NumberFormatException -> Lbb
            r3.append(r2)     // Catch: java.lang.NumberFormatException -> Lbb
            java.lang.String r2 = " modelApi:"
            r3.append(r2)     // Catch: java.lang.NumberFormatException -> Lbb
            r3.append(r7)     // Catch: java.lang.NumberFormatException -> Lbb
            java.lang.String r7 = " isCurrentVersion:"
            r3.append(r7)     // Catch: java.lang.NumberFormatException -> Lbb
            r3.append(r1)     // Catch: java.lang.NumberFormatException -> Lbb
            java.lang.String r7 = r3.toString()     // Catch: java.lang.NumberFormatException -> Lbb
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch: java.lang.NumberFormatException -> Lbb
            us.pinguo.common.log.a.k(r7, r2)     // Catch: java.lang.NumberFormatException -> Lbb
            return r1
        Lbb:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera360.loc.c.c(us.pinguo.loc.q):boolean");
    }

    public static boolean d(q qVar) {
        boolean c;
        if (qVar != null && (c = c(qVar))) {
            if (!TextUtils.isEmpty(qVar.f11544d)) {
                return e(qVar.f11544d, Build.MODEL);
            }
            if (!TextUtils.isEmpty(qVar.c)) {
                return e(qVar.c, Build.DEVICE);
            }
            if (!TextUtils.isEmpty(qVar.b)) {
                return e(qVar.b, Build.BRAND);
            }
            PerformanceLevelManager performanceLevelManager = PerformanceLevelManager.a;
            String d2 = performanceLevelManager.d();
            String f2 = performanceLevelManager.f();
            us.pinguo.common.log.a.k("当前机型CPU:" + d2 + " GPU:" + f2, new Object[0]);
            if (TextUtils.isEmpty(qVar.f11546f)) {
                return !TextUtils.isEmpty(qVar.f11547g) ? e(qVar.f11547g, f2) : c;
            }
            return e(qVar.f11546f, d2);
        }
        return false;
    }

    private static boolean e(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return Pattern.compile(str, 2).matcher(str2).find();
    }

    public static boolean f() {
        if (b) {
            return false;
        }
        return (d(a) && TextUtils.isEmpty(a.f11548h)) ? false : true;
    }
}

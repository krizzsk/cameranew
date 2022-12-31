package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import us.pinguo.common.network.common.header.PGTransHeader;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class k3 extends j5 {
    private char c;

    /* renamed from: d  reason: collision with root package name */
    private long f3846d;
    @GuardedBy("this")

    /* renamed from: e  reason: collision with root package name */
    private String f3847e;

    /* renamed from: f  reason: collision with root package name */
    private final i3 f3848f;

    /* renamed from: g  reason: collision with root package name */
    private final i3 f3849g;

    /* renamed from: h  reason: collision with root package name */
    private final i3 f3850h;

    /* renamed from: i  reason: collision with root package name */
    private final i3 f3851i;

    /* renamed from: j  reason: collision with root package name */
    private final i3 f3852j;

    /* renamed from: k  reason: collision with root package name */
    private final i3 f3853k;

    /* renamed from: l  reason: collision with root package name */
    private final i3 f3854l;
    private final i3 m;
    private final i3 n;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k3(o4 o4Var) {
        super(o4Var);
        this.c = (char) 0;
        this.f3846d = -1L;
        this.f3848f = new i3(this, 6, false, false);
        this.f3849g = new i3(this, 6, true, false);
        this.f3850h = new i3(this, 6, false, true);
        this.f3851i = new i3(this, 5, false, false);
        this.f3852j = new i3(this, 5, true, false);
        this.f3853k = new i3(this, 5, false, true);
        this.f3854l = new i3(this, 4, false, false);
        this.m = new i3(this, 3, false, false);
        this.n = new i3(this, 2, false, false);
    }

    private static String E(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf == -1 ? str : str.substring(0, lastIndexOf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object v(String str) {
        if (str == null) {
            return null;
        }
        return new j3(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String y(boolean z, String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String z2 = z(z, obj);
        String z3 = z(z, obj2);
        String z4 = z(z, obj3);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(z2)) {
            sb.append(str2);
            sb.append(z2);
            str2 = ", ";
        }
        if (TextUtils.isEmpty(z3)) {
            str3 = str2;
        } else {
            sb.append(str2);
            sb.append(z3);
        }
        if (!TextUtils.isEmpty(z4)) {
            sb.append(str3);
            sb.append(z4);
        }
        return sb.toString();
    }

    static String z(boolean z, Object obj) {
        String str;
        String className;
        if (obj == null) {
            return "";
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        int i2 = 0;
        if (obj instanceof Long) {
            if (!z) {
                return String.valueOf(obj);
            }
            Long l2 = (Long) obj;
            if (Math.abs(l2.longValue()) < 100) {
                return String.valueOf(obj);
            }
            String str2 = String.valueOf(obj).charAt(0) == '-' ? PGTransHeader.CONNECTOR : "";
            String valueOf = String.valueOf(Math.abs(l2.longValue()));
            long round = Math.round(Math.pow(10.0d, valueOf.length() - 1));
            long round2 = Math.round(Math.pow(10.0d, valueOf.length()) - 1.0d);
            StringBuilder sb = new StringBuilder(str2.length() + 43 + str2.length());
            sb.append(str2);
            sb.append(round);
            sb.append("...");
            sb.append(str2);
            sb.append(round2);
            return sb.toString();
        } else if (obj instanceof Boolean) {
            return String.valueOf(obj);
        } else {
            if (obj instanceof Throwable) {
                Throwable th = (Throwable) obj;
                StringBuilder sb2 = new StringBuilder(z ? th.getClass().getName() : th.toString());
                String E = E(o4.class.getCanonicalName());
                StackTraceElement[] stackTrace = th.getStackTrace();
                int length = stackTrace.length;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    StackTraceElement stackTraceElement = stackTrace[i2];
                    if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && E(className).equals(E)) {
                        sb2.append(": ");
                        sb2.append(stackTraceElement);
                        break;
                    }
                    i2++;
                }
                return sb2.toString();
            } else if (!(obj instanceof j3)) {
                return z ? PGTransHeader.CONNECTOR : String.valueOf(obj);
            } else {
                str = ((j3) obj).a;
                return str;
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.j5
    protected final boolean g() {
        return false;
    }

    public final i3 m() {
        return this.f3848f;
    }

    public final i3 n() {
        return this.f3849g;
    }

    public final i3 o() {
        return this.f3850h;
    }

    public final i3 p() {
        return this.f3851i;
    }

    public final i3 q() {
        return this.f3852j;
    }

    public final i3 r() {
        return this.f3853k;
    }

    public final i3 s() {
        return this.f3854l;
    }

    public final i3 t() {
        return this.m;
    }

    public final i3 u() {
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void w(int i2, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && Log.isLoggable(x(), i2)) {
            Log.println(i2, x(), y(false, str, obj, obj2, obj3));
        }
        if (z2 || i2 < 5) {
            return;
        }
        com.google.android.gms.common.internal.q.j(str);
        l4 C = this.a.C();
        if (C == null) {
            Log.println(6, x(), "Scheduler not set. Not logging error/warn");
        } else if (!C.i()) {
            Log.println(6, x(), "Scheduler not initialized. Not logging error/warn");
        } else {
            C.p(new h3(this, i2 >= 9 ? 8 : i2, str, obj, obj2, obj3));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @EnsuresNonNull({"logTagDoNotUseDirectly"})
    public final String x() {
        String str;
        synchronized (this) {
            if (this.f3847e == null) {
                if (this.a.L() != null) {
                    this.f3847e = this.a.L();
                } else {
                    this.f3847e = this.a.x().j();
                }
            }
            com.google.android.gms.common.internal.q.j(this.f3847e);
            str = this.f3847e;
        }
        return str;
    }
}

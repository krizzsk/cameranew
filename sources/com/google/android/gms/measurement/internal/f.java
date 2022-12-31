package com.google.android.gms.measurement.internal;

import android.os.Bundle;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class f {
    public static final f c = new f(null, null);
    private final Boolean a;
    private final Boolean b;

    public f(Boolean bool, Boolean bool2) {
        this.a = bool;
        this.b = bool2;
    }

    public static String a(Bundle bundle) {
        String string = bundle.getString("ad_storage");
        if (string == null || o(string) != null) {
            String string2 = bundle.getString("analytics_storage");
            if (string2 == null || o(string2) != null) {
                return null;
            }
            return string2;
        }
        return string;
    }

    public static f b(Bundle bundle) {
        return bundle == null ? c : new f(o(bundle.getString("ad_storage")), o(bundle.getString("analytics_storage")));
    }

    public static f c(String str) {
        Boolean bool;
        if (str != null) {
            Boolean p = str.length() >= 3 ? p(str.charAt(2)) : null;
            bool = str.length() >= 4 ? p(str.charAt(3)) : null;
            r0 = p;
        } else {
            bool = null;
        }
        return new f(r0, bool);
    }

    static Boolean j(Boolean bool, Boolean bool2) {
        if (bool == null) {
            return bool2;
        }
        if (bool2 == null) {
            return bool;
        }
        boolean z = false;
        if (bool.booleanValue() && bool2.booleanValue()) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    public static boolean m(int i2, int i3) {
        return i2 <= i3;
    }

    static final int n(Boolean bool) {
        if (bool == null) {
            return 0;
        }
        return bool.booleanValue() ? 1 : 2;
    }

    private static Boolean o(String str) {
        if (str == null) {
            return null;
        }
        if (str.equals("granted")) {
            return Boolean.TRUE;
        }
        if (str.equals("denied")) {
            return Boolean.FALSE;
        }
        return null;
    }

    private static Boolean p(char c2) {
        if (c2 != '0') {
            if (c2 != '1') {
                return null;
            }
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private static final char q(Boolean bool) {
        if (bool == null) {
            return '-';
        }
        return bool.booleanValue() ? '1' : '0';
    }

    public final String d() {
        return "G1" + q(this.a) + q(this.b);
    }

    public final Boolean e() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof f) {
            f fVar = (f) obj;
            return n(this.a) == n(fVar.a) && n(this.b) == n(fVar.b);
        }
        return false;
    }

    public final boolean f() {
        Boolean bool = this.a;
        return bool == null || bool.booleanValue();
    }

    public final Boolean g() {
        return this.b;
    }

    public final boolean h() {
        Boolean bool = this.b;
        return bool == null || bool.booleanValue();
    }

    public final int hashCode() {
        return ((n(this.a) + 527) * 31) + n(this.b);
    }

    public final boolean i(f fVar) {
        Boolean bool = this.a;
        Boolean bool2 = Boolean.FALSE;
        if (bool != bool2 || fVar.a == bool2) {
            return this.b == bool2 && fVar.b != bool2;
        }
        return true;
    }

    public final f k(f fVar) {
        return new f(j(this.a, fVar.a), j(this.b, fVar.b));
    }

    public final f l(f fVar) {
        Boolean bool = this.a;
        if (bool == null) {
            bool = fVar.a;
        }
        Boolean bool2 = this.b;
        if (bool2 == null) {
            bool2 = fVar.b;
        }
        return new f(bool, bool2);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ConsentSettings: ");
        sb.append("adStorage=");
        Boolean bool = this.a;
        if (bool == null) {
            sb.append("uninitialized");
        } else {
            sb.append(true != bool.booleanValue() ? "denied" : "granted");
        }
        sb.append(", analyticsStorage=");
        Boolean bool2 = this.b;
        if (bool2 == null) {
            sb.append("uninitialized");
        } else {
            sb.append(true == bool2.booleanValue() ? "granted" : "denied");
        }
        return sb.toString();
    }
}

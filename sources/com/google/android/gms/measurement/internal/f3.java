package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class f3 extends j5 {
    protected static final AtomicReference<String[]> c = new AtomicReference<>();

    /* renamed from: d  reason: collision with root package name */
    protected static final AtomicReference<String[]> f3784d = new AtomicReference<>();

    /* renamed from: e  reason: collision with root package name */
    protected static final AtomicReference<String[]> f3785e = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public f3(o4 o4Var) {
        super(o4Var);
    }

    private static final String s(String str, String[] strArr, String[] strArr2, AtomicReference<String[]> atomicReference) {
        String str2;
        com.google.android.gms.common.internal.q.j(strArr);
        com.google.android.gms.common.internal.q.j(strArr2);
        com.google.android.gms.common.internal.q.j(atomicReference);
        com.google.android.gms.common.internal.q.a(strArr.length == strArr2.length);
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (n9.E(str, strArr[i2])) {
                synchronized (atomicReference) {
                    String[] strArr3 = atomicReference.get();
                    if (strArr3 == null) {
                        strArr3 = new String[strArr2.length];
                        atomicReference.set(strArr3);
                    }
                    str2 = strArr3[i2];
                    if (str2 == null) {
                        str2 = strArr2[i2] + "(" + strArr[i2] + ")";
                        strArr3[i2] = str2;
                    }
                }
                return str2;
            }
        }
        return str;
    }

    @Override // com.google.android.gms.measurement.internal.j5
    protected final boolean g() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean m() {
        this.a.d();
        return this.a.I() && Log.isLoggable(this.a.a().x(), 3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String n(String str) {
        if (str == null) {
            return null;
        }
        return !m() ? str : s(str, m5.c, m5.a, c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String o(String str) {
        if (str == null) {
            return null;
        }
        return !m() ? str : s(str, n5.b, n5.a, f3784d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String p(String str) {
        if (str == null) {
            return null;
        }
        if (m()) {
            if (str.startsWith("_exp_")) {
                return "experiment_id(" + str + ")";
            }
            return s(str, o5.b, o5.a, f3785e);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String q(Bundle bundle) {
        String valueOf;
        if (bundle == null) {
            return null;
        }
        if (!m()) {
            return bundle.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Bundle[{");
        for (String str : bundle.keySet()) {
            if (sb.length() != 8) {
                sb.append(", ");
            }
            sb.append(o(str));
            sb.append("=");
            Object obj = bundle.get(str);
            if (obj instanceof Bundle) {
                valueOf = r(new Object[]{obj});
            } else if (obj instanceof Object[]) {
                valueOf = r((Object[]) obj);
            } else if (obj instanceof ArrayList) {
                valueOf = r(((ArrayList) obj).toArray());
            } else {
                valueOf = String.valueOf(obj);
            }
            sb.append(valueOf);
        }
        sb.append("}]");
        return sb.toString();
    }

    protected final String r(Object[] objArr) {
        String valueOf;
        if (objArr == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Object obj : objArr) {
            if (obj instanceof Bundle) {
                valueOf = q((Bundle) obj);
            } else {
                valueOf = String.valueOf(obj);
            }
            if (valueOf != null) {
                if (sb.length() != 1) {
                    sb.append(", ");
                }
                sb.append(valueOf);
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

package com.tapjoy.internal;
/* loaded from: classes3.dex */
public final class jf {
    public static jf a = new jf(null);
    public String b;
    public Throwable c;

    /* renamed from: d  reason: collision with root package name */
    private Object[] f7739d;

    public jf(String str) {
        this(str, null, null);
    }

    public jf(String str, Object[] objArr, Throwable th) {
        this.b = str;
        this.c = th;
        if (th == null) {
            this.f7739d = objArr;
        } else if (objArr != null && objArr.length != 0) {
            int length = objArr.length - 1;
            Object[] objArr2 = new Object[length];
            System.arraycopy(objArr, 0, objArr2, 0, length);
            this.f7739d = objArr2;
        } else {
            throw new IllegalStateException("non-sensical empty or null argument array");
        }
    }
}

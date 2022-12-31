package com.tapjoy.internal;
/* loaded from: classes3.dex */
public enum eg {
    VARINT(0),
    FIXED64(1),
    LENGTH_DELIMITED(2),
    FIXED32(5);
    

    /* renamed from: e  reason: collision with root package name */
    final int f7398e;

    /* renamed from: com.tapjoy.internal.eg$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[eg.values().length];
            a = iArr;
            try {
                iArr[eg.VARINT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[eg.FIXED32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[eg.FIXED64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[eg.LENGTH_DELIMITED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    eg(int i2) {
        this.f7398e = i2;
    }

    public final ej a() {
        int i2 = AnonymousClass1.a[ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 == 4) {
                        return ej.q;
                    }
                    throw new AssertionError();
                }
                return ej.f7408l;
            }
            return ej.f7403g;
        }
        return ej.f7406j;
    }
}

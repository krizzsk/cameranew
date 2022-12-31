package com.tapjoy.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class ej {
    public static final ej c;

    /* renamed from: d  reason: collision with root package name */
    public static final ej f7400d;

    /* renamed from: e  reason: collision with root package name */
    public static final ej f7401e;

    /* renamed from: f  reason: collision with root package name */
    public static final ej f7402f;

    /* renamed from: g  reason: collision with root package name */
    public static final ej f7403g;

    /* renamed from: h  reason: collision with root package name */
    public static final ej f7404h;

    /* renamed from: i  reason: collision with root package name */
    public static final ej f7405i;

    /* renamed from: j  reason: collision with root package name */
    public static final ej f7406j;

    /* renamed from: k  reason: collision with root package name */
    public static final ej f7407k;

    /* renamed from: l  reason: collision with root package name */
    public static final ej f7408l;
    public static final ej m;
    public static final ej n;
    public static final ej o;
    public static final ej p;
    public static final ej q;
    final Class a;
    ej b;
    private final eg r;

    /* loaded from: classes3.dex */
    public static final class a extends IllegalArgumentException {
        public final int a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i2, Class cls) {
            super("Unknown enum tag " + i2 + " for " + cls.getCanonicalName());
            this.a = i2;
        }
    }

    static {
        eg egVar = eg.VARINT;
        c = new ej(egVar, Boolean.class) { // from class: com.tapjoy.internal.ej.1
            @Override // com.tapjoy.internal.ej
            public final /* bridge */ /* synthetic */ int a(Object obj) {
                return 1;
            }

            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ void a(el elVar, Object obj) {
                elVar.c(((Boolean) obj).booleanValue() ? 1 : 0);
            }

            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ Object a(ek ekVar) {
                int d2 = ekVar.d();
                if (d2 == 0) {
                    return Boolean.FALSE;
                }
                if (d2 == 1) {
                    return Boolean.TRUE;
                }
                throw new IOException(String.format("Invalid boolean value 0x%02x", Integer.valueOf(d2)));
            }
        };
        f7400d = new ej(egVar, Integer.class) { // from class: com.tapjoy.internal.ej.7
            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ int a(Object obj) {
                int intValue = ((Integer) obj).intValue();
                if (intValue >= 0) {
                    return el.a(intValue);
                }
                return 10;
            }

            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ void a(el elVar, Object obj) {
                int intValue = ((Integer) obj).intValue();
                if (intValue >= 0) {
                    elVar.c(intValue);
                } else {
                    elVar.c(intValue);
                }
            }

            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ Object a(ek ekVar) {
                return Integer.valueOf(ekVar.d());
            }
        };
        f7401e = new ej(egVar, Integer.class) { // from class: com.tapjoy.internal.ej.8
            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ int a(Object obj) {
                return el.a(((Integer) obj).intValue());
            }

            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ void a(el elVar, Object obj) {
                elVar.c(((Integer) obj).intValue());
            }

            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ Object a(ek ekVar) {
                return Integer.valueOf(ekVar.d());
            }
        };
        f7402f = new ej(egVar, Integer.class) { // from class: com.tapjoy.internal.ej.9
            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ int a(Object obj) {
                return el.a(el.b(((Integer) obj).intValue()));
            }

            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ void a(el elVar, Object obj) {
                elVar.c(el.b(((Integer) obj).intValue()));
            }

            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ Object a(ek ekVar) {
                int d2 = ekVar.d();
                return Integer.valueOf((-(d2 & 1)) ^ (d2 >>> 1));
            }
        };
        eg egVar2 = eg.FIXED32;
        ej ejVar = new ej(egVar2, Integer.class) { // from class: com.tapjoy.internal.ej.10
            @Override // com.tapjoy.internal.ej
            public final /* bridge */ /* synthetic */ int a(Object obj) {
                return 4;
            }

            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ void a(el elVar, Object obj) {
                elVar.d(((Integer) obj).intValue());
            }

            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ Object a(ek ekVar) {
                return Integer.valueOf(ekVar.f());
            }
        };
        f7403g = ejVar;
        f7404h = ejVar;
        f7405i = new ej(egVar, Long.class) { // from class: com.tapjoy.internal.ej.11
            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ int a(Object obj) {
                return el.a(((Long) obj).longValue());
            }

            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ void a(el elVar, Object obj) {
                elVar.c(((Long) obj).longValue());
            }

            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ Object a(ek ekVar) {
                return Long.valueOf(ekVar.e());
            }
        };
        f7406j = new ej(egVar, Long.class) { // from class: com.tapjoy.internal.ej.12
            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ int a(Object obj) {
                return el.a(((Long) obj).longValue());
            }

            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ void a(el elVar, Object obj) {
                elVar.c(((Long) obj).longValue());
            }

            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ Object a(ek ekVar) {
                return Long.valueOf(ekVar.e());
            }
        };
        f7407k = new ej(egVar, Long.class) { // from class: com.tapjoy.internal.ej.13
            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ int a(Object obj) {
                return el.a(el.b(((Long) obj).longValue()));
            }

            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ void a(el elVar, Object obj) {
                elVar.c(el.b(((Long) obj).longValue()));
            }

            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ Object a(ek ekVar) {
                long e2 = ekVar.e();
                return Long.valueOf((-(e2 & 1)) ^ (e2 >>> 1));
            }
        };
        eg egVar3 = eg.FIXED64;
        ej ejVar2 = new ej(egVar3, Long.class) { // from class: com.tapjoy.internal.ej.14
            @Override // com.tapjoy.internal.ej
            public final /* bridge */ /* synthetic */ int a(Object obj) {
                return 8;
            }

            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ void a(el elVar, Object obj) {
                elVar.d(((Long) obj).longValue());
            }

            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ Object a(ek ekVar) {
                return Long.valueOf(ekVar.g());
            }
        };
        f7408l = ejVar2;
        m = ejVar2;
        n = new ej(egVar2, Float.class) { // from class: com.tapjoy.internal.ej.2
            @Override // com.tapjoy.internal.ej
            public final /* bridge */ /* synthetic */ int a(Object obj) {
                return 4;
            }

            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ void a(el elVar, Object obj) {
                elVar.d(Float.floatToIntBits(((Float) obj).floatValue()));
            }

            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ Object a(ek ekVar) {
                return Float.valueOf(Float.intBitsToFloat(ekVar.f()));
            }
        };
        o = new ej(egVar3, Double.class) { // from class: com.tapjoy.internal.ej.3
            @Override // com.tapjoy.internal.ej
            public final /* bridge */ /* synthetic */ int a(Object obj) {
                return 8;
            }

            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ void a(el elVar, Object obj) {
                elVar.d(Double.doubleToLongBits(((Double) obj).doubleValue()));
            }

            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ Object a(ek ekVar) {
                return Double.valueOf(Double.longBitsToDouble(ekVar.g()));
            }
        };
        eg egVar4 = eg.LENGTH_DELIMITED;
        p = new ej(egVar4, String.class) { // from class: com.tapjoy.internal.ej.4
            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ int a(Object obj) {
                int i2;
                String str = (String) obj;
                int length = str.length();
                int i3 = 0;
                int i4 = 0;
                while (i3 < length) {
                    char charAt = str.charAt(i3);
                    if (charAt >= 128) {
                        if (charAt < 2048) {
                            i4 += 2;
                        } else if (charAt < 55296 || charAt > 57343) {
                            i4 += 3;
                        } else if (charAt <= 56319 && (i2 = i3 + 1) < length && str.charAt(i2) >= 56320 && str.charAt(i2) <= 57343) {
                            i4 += 4;
                            i3 = i2;
                        }
                        i3++;
                    }
                    i4++;
                    i3++;
                }
                return i4;
            }

            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ void a(el elVar, Object obj) {
                elVar.a.b((String) obj);
            }

            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ Object a(ek ekVar) {
                return ekVar.a.c(ekVar.h());
            }
        };
        q = new ej(egVar4, iu.class) { // from class: com.tapjoy.internal.ej.5
            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ int a(Object obj) {
                return ((iu) obj).c();
            }

            @Override // com.tapjoy.internal.ej
            public final /* bridge */ /* synthetic */ void a(el elVar, Object obj) {
                elVar.a((iu) obj);
            }

            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ Object a(ek ekVar) {
                return ekVar.a.b(ekVar.h());
            }
        };
    }

    public ej(eg egVar, Class cls) {
        this.r = egVar;
        this.a = cls;
    }

    public static String c(Object obj) {
        return obj.toString();
    }

    public int a(int i2, Object obj) {
        int a2 = a(obj);
        if (this.r == eg.LENGTH_DELIMITED) {
            a2 += el.a(a2);
        }
        return a2 + el.a(el.a(i2, eg.VARINT));
    }

    public abstract int a(Object obj);

    public abstract Object a(ek ekVar);

    public abstract void a(el elVar, Object obj);

    public final byte[] b(Object obj) {
        ei.a(obj, "value == null");
        ir irVar = new ir();
        try {
            a(irVar, obj);
            return irVar.g();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public void a(el elVar, int i2, Object obj) {
        elVar.c(el.a(i2, this.r));
        if (this.r == eg.LENGTH_DELIMITED) {
            elVar.c(a(obj));
        }
        a(elVar, obj);
    }

    private void a(is isVar, Object obj) {
        ei.a(obj, "value == null");
        ei.a(isVar, "sink == null");
        a(new el(isVar), obj);
    }

    public final void a(OutputStream outputStream, Object obj) {
        ei.a(obj, "value == null");
        ei.a(outputStream, "stream == null");
        is a2 = iv.a(iv.a(outputStream));
        a(a2, obj);
        a2.a();
    }

    public final Object a(byte[] bArr) {
        ei.a(bArr, "bytes == null");
        ir irVar = new ir();
        if (bArr != null) {
            return a((it) irVar.a(bArr, 0, bArr.length));
        }
        throw new IllegalArgumentException("source == null");
    }

    public final Object a(InputStream inputStream) {
        ei.a(inputStream, "stream == null");
        return a(iv.a(iv.a(inputStream)));
    }

    private Object a(it itVar) {
        ei.a(itVar, "source == null");
        return a(new ek(itVar));
    }

    public final ej a() {
        ej ejVar = this.b;
        if (ejVar != null) {
            return ejVar;
        }
        ej ejVar2 = new ej(this.r, List.class) { // from class: com.tapjoy.internal.ej.6
            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ int a(int i2, Object obj) {
                List list = (List) obj;
                int size = list.size();
                int i3 = 0;
                for (int i4 = 0; i4 < size; i4++) {
                    i3 += ej.this.a(i2, list.get(i4));
                }
                return i3;
            }

            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ void a(el elVar, int i2, Object obj) {
                List list = (List) obj;
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ej.this.a(elVar, i2, list.get(i3));
                }
            }

            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ Object a(ek ekVar) {
                return Collections.singletonList(ej.this.a(ekVar));
            }

            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ void a(el elVar, Object obj) {
                throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
            }

            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ int a(Object obj) {
                throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
            }
        };
        this.b = ejVar2;
        return ejVar2;
    }
}

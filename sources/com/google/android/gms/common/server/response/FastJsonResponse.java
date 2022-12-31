package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.converter.zaa;
import com.google.android.gms.common.util.l;
import com.google.android.gms.common.util.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public abstract class FastJsonResponse {

    /* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
    /* loaded from: classes2.dex */
    public static class Field<I, O> extends AbstractSafeParcelable {
        public static final b CREATOR = new b();
        protected final int a;
        protected final boolean b;
        protected final int c;

        /* renamed from: d  reason: collision with root package name */
        protected final boolean f3691d;

        /* renamed from: e  reason: collision with root package name */
        protected final String f3692e;

        /* renamed from: f  reason: collision with root package name */
        protected final int f3693f;

        /* renamed from: g  reason: collision with root package name */
        protected final Class<? extends FastJsonResponse> f3694g;
        private final int zalk;
        private final String zaqo;
        private zal zaqp;
        private a<I, O> zaqq;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Field(int i2, int i3, boolean z, int i4, boolean z2, String str, int i5, String str2, zaa zaaVar) {
            this.zalk = i2;
            this.a = i3;
            this.b = z;
            this.c = i4;
            this.f3691d = z2;
            this.f3692e = str;
            this.f3693f = i5;
            if (str2 == null) {
                this.f3694g = null;
                this.zaqo = null;
            } else {
                this.f3694g = SafeParcelResponse.class;
                this.zaqo = str2;
            }
            if (zaaVar == null) {
                this.zaqq = null;
            } else {
                this.zaqq = (a<I, O>) zaaVar.Q();
            }
        }

        private final String T() {
            String str = this.zaqo;
            if (str == null) {
                return null;
            }
            return str;
        }

        private final zaa V() {
            a<I, O> aVar = this.zaqq;
            if (aVar == null) {
                return null;
            }
            return zaa.h(aVar);
        }

        public int Q() {
            return this.f3693f;
        }

        public final void S(zal zalVar) {
            this.zaqp = zalVar;
        }

        public final boolean U() {
            return this.zaqq != null;
        }

        public final Map<String, Field<?, ?>> W() {
            q.j(this.zaqo);
            q.j(this.zaqp);
            return this.zaqp.S(this.zaqo);
        }

        public final I a(O o) {
            return this.zaqq.a(o);
        }

        public String toString() {
            p.a c = p.c(this);
            c.a("versionCode", Integer.valueOf(this.zalk));
            c.a("typeIn", Integer.valueOf(this.a));
            c.a("typeInArray", Boolean.valueOf(this.b));
            c.a("typeOut", Integer.valueOf(this.c));
            c.a("typeOutArray", Boolean.valueOf(this.f3691d));
            c.a("outputFieldName", this.f3692e);
            c.a("safeParcelFieldId", Integer.valueOf(this.f3693f));
            c.a("concreteTypeName", T());
            Class<? extends FastJsonResponse> cls = this.f3694g;
            if (cls != null) {
                c.a("concreteType.class", cls.getCanonicalName());
            }
            a<I, O> aVar = this.zaqq;
            if (aVar != null) {
                c.a("converterName", aVar.getClass().getCanonicalName());
            }
            return c.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            com.google.android.gms.common.internal.safeparcel.a.m(parcel, 1, this.zalk);
            com.google.android.gms.common.internal.safeparcel.a.m(parcel, 2, this.a);
            com.google.android.gms.common.internal.safeparcel.a.c(parcel, 3, this.b);
            com.google.android.gms.common.internal.safeparcel.a.m(parcel, 4, this.c);
            com.google.android.gms.common.internal.safeparcel.a.c(parcel, 5, this.f3691d);
            com.google.android.gms.common.internal.safeparcel.a.v(parcel, 6, this.f3692e, false);
            com.google.android.gms.common.internal.safeparcel.a.m(parcel, 7, Q());
            com.google.android.gms.common.internal.safeparcel.a.v(parcel, 8, T(), false);
            com.google.android.gms.common.internal.safeparcel.a.t(parcel, 9, V(), i2, false);
            com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
    /* loaded from: classes2.dex */
    public interface a<I, O> {
        I a(O o);
    }

    private static void h(StringBuilder sb, Field field, Object obj) {
        int i2 = field.a;
        if (i2 == 11) {
            sb.append(field.f3694g.cast(obj).toString());
        } else if (i2 == 7) {
            sb.append("\"");
            sb.append(l.a((String) obj));
            sb.append("\"");
        } else {
            sb.append(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public static <O, I> I j(Field<I, O> field, Object obj) {
        return ((Field) field).zaqq != null ? field.a(obj) : obj;
    }

    public abstract Map<String, Field<?, ?>> a();

    /* JADX INFO: Access modifiers changed from: protected */
    public Object b(Field field) {
        String str = field.f3692e;
        if (field.f3694g != null) {
            q.o(c(str) == null, "Concrete field shouldn't be value object: %s", field.f3692e);
            boolean z = field.f3691d;
            try {
                char upperCase = Character.toUpperCase(str.charAt(0));
                String substring = str.substring(1);
                StringBuilder sb = new StringBuilder(String.valueOf(substring).length() + 4);
                sb.append("get");
                sb.append(upperCase);
                sb.append(substring);
                return getClass().getMethod(sb.toString(), new Class[0]).invoke(this, new Object[0]);
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return c(str);
    }

    protected abstract Object c(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean f(Field field) {
        if (field.c == 11) {
            if (field.f3691d) {
                String str = field.f3692e;
                throw new UnsupportedOperationException("Concrete type arrays not supported");
            }
            String str2 = field.f3692e;
            throw new UnsupportedOperationException("Concrete types not supported");
        }
        return g(field.f3692e);
    }

    protected abstract boolean g(String str);

    public String toString() {
        Map<String, Field<?, ?>> a2 = a();
        StringBuilder sb = new StringBuilder(100);
        for (String str : a2.keySet()) {
            Field<?, ?> field = a2.get(str);
            if (f(field)) {
                Object j2 = j(field, b(field));
                if (sb.length() == 0) {
                    sb.append("{");
                } else {
                    sb.append(",");
                }
                sb.append("\"");
                sb.append(str);
                sb.append("\":");
                if (j2 == null) {
                    sb.append("null");
                } else {
                    switch (field.c) {
                        case 8:
                            sb.append("\"");
                            sb.append(com.google.android.gms.common.util.c.a((byte[]) j2));
                            sb.append("\"");
                            continue;
                        case 9:
                            sb.append("\"");
                            sb.append(com.google.android.gms.common.util.c.b((byte[]) j2));
                            sb.append("\"");
                            continue;
                        case 10:
                            m.a(sb, (HashMap) j2);
                            continue;
                        default:
                            if (field.b) {
                                ArrayList arrayList = (ArrayList) j2;
                                sb.append("[");
                                int size = arrayList.size();
                                for (int i2 = 0; i2 < size; i2++) {
                                    if (i2 > 0) {
                                        sb.append(",");
                                    }
                                    Object obj = arrayList.get(i2);
                                    if (obj != null) {
                                        h(sb, field, obj);
                                    }
                                }
                                sb.append("]");
                                break;
                            } else {
                                h(sb, field, j2);
                                continue;
                            }
                    }
                }
            }
        }
        if (sb.length() > 0) {
            sb.append("}");
        } else {
            sb.append("{}");
        }
        return sb.toString();
    }
}

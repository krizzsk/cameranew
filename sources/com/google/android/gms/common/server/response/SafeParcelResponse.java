package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.l;
import com.google.android.gms.common.util.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public class SafeParcelResponse extends FastSafeParcelableJsonResponse {
    public static final Parcelable.Creator<SafeParcelResponse> CREATOR = new e();
    private final String mClassName;
    private final int zalk;
    private final zal zaqp;
    private final Parcel zarr;
    private final int zars;
    private int zart;
    private int zaru;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SafeParcelResponse(int i2, Parcel parcel, zal zalVar) {
        this.zalk = i2;
        q.j(parcel);
        this.zarr = parcel;
        this.zars = 2;
        this.zaqp = zalVar;
        if (zalVar == null) {
            this.mClassName = null;
        } else {
            this.mClassName = zalVar.R();
        }
        this.zart = 2;
    }

    private static void k(StringBuilder sb, int i2, Object obj) {
        switch (i2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(obj);
                return;
            case 7:
                sb.append("\"");
                sb.append(l.a(obj.toString()));
                sb.append("\"");
                return;
            case 8:
                sb.append("\"");
                sb.append(com.google.android.gms.common.util.c.a((byte[]) obj));
                sb.append("\"");
                return;
            case 9:
                sb.append("\"");
                sb.append(com.google.android.gms.common.util.c.b((byte[]) obj));
                sb.append("\"");
                return;
            case 10:
                m.a(sb, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                StringBuilder sb2 = new StringBuilder(26);
                sb2.append("Unknown type = ");
                sb2.append(i2);
                throw new IllegalArgumentException(sb2.toString());
        }
    }

    private final void l(StringBuilder sb, Map<String, FastJsonResponse.Field<?, ?>> map, Parcel parcel) {
        SparseArray sparseArray = new SparseArray();
        for (Map.Entry<String, FastJsonResponse.Field<?, ?>> entry : map.entrySet()) {
            sparseArray.put(entry.getValue().Q(), entry);
        }
        sb.append('{');
        int N = SafeParcelReader.N(parcel);
        boolean z = false;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            Map.Entry entry2 = (Map.Entry) sparseArray.get(SafeParcelReader.v(D));
            if (entry2 != null) {
                if (z) {
                    sb.append(",");
                }
                FastJsonResponse.Field<?, ?> field = (FastJsonResponse.Field) entry2.getValue();
                sb.append("\"");
                sb.append((String) entry2.getKey());
                sb.append("\":");
                if (field.U()) {
                    switch (field.c) {
                        case 0:
                            m(sb, field, FastJsonResponse.j(field, Integer.valueOf(SafeParcelReader.F(parcel, D))));
                            break;
                        case 1:
                            m(sb, field, FastJsonResponse.j(field, SafeParcelReader.c(parcel, D)));
                            break;
                        case 2:
                            m(sb, field, FastJsonResponse.j(field, Long.valueOf(SafeParcelReader.I(parcel, D))));
                            break;
                        case 3:
                            m(sb, field, FastJsonResponse.j(field, Float.valueOf(SafeParcelReader.B(parcel, D))));
                            break;
                        case 4:
                            m(sb, field, FastJsonResponse.j(field, Double.valueOf(SafeParcelReader.z(parcel, D))));
                            break;
                        case 5:
                            m(sb, field, FastJsonResponse.j(field, SafeParcelReader.a(parcel, D)));
                            break;
                        case 6:
                            m(sb, field, FastJsonResponse.j(field, Boolean.valueOf(SafeParcelReader.w(parcel, D))));
                            break;
                        case 7:
                            m(sb, field, FastJsonResponse.j(field, SafeParcelReader.p(parcel, D)));
                            break;
                        case 8:
                        case 9:
                            m(sb, field, FastJsonResponse.j(field, SafeParcelReader.g(parcel, D)));
                            break;
                        case 10:
                            Bundle f2 = SafeParcelReader.f(parcel, D);
                            HashMap hashMap = new HashMap();
                            for (String str : f2.keySet()) {
                                hashMap.put(str, f2.getString(str));
                            }
                            m(sb, field, FastJsonResponse.j(field, hashMap));
                            break;
                        case 11:
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        default:
                            int i2 = field.c;
                            StringBuilder sb2 = new StringBuilder(36);
                            sb2.append("Unknown field out type = ");
                            sb2.append(i2);
                            throw new IllegalArgumentException(sb2.toString());
                    }
                } else if (field.f3691d) {
                    sb.append("[");
                    switch (field.c) {
                        case 0:
                            com.google.android.gms.common.util.b.e(sb, SafeParcelReader.j(parcel, D));
                            break;
                        case 1:
                            com.google.android.gms.common.util.b.g(sb, SafeParcelReader.d(parcel, D));
                            break;
                        case 2:
                            com.google.android.gms.common.util.b.f(sb, SafeParcelReader.l(parcel, D));
                            break;
                        case 3:
                            com.google.android.gms.common.util.b.d(sb, SafeParcelReader.i(parcel, D));
                            break;
                        case 4:
                            com.google.android.gms.common.util.b.c(sb, SafeParcelReader.h(parcel, D));
                            break;
                        case 5:
                            com.google.android.gms.common.util.b.g(sb, SafeParcelReader.b(parcel, D));
                            break;
                        case 6:
                            com.google.android.gms.common.util.b.h(sb, SafeParcelReader.e(parcel, D));
                            break;
                        case 7:
                            com.google.android.gms.common.util.b.i(sb, SafeParcelReader.q(parcel, D));
                            break;
                        case 8:
                        case 9:
                        case 10:
                            throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                        case 11:
                            Parcel[] n = SafeParcelReader.n(parcel, D);
                            int length = n.length;
                            for (int i3 = 0; i3 < length; i3++) {
                                if (i3 > 0) {
                                    sb.append(",");
                                }
                                n[i3].setDataPosition(0);
                                l(sb, field.W(), n[i3]);
                            }
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out.");
                    }
                    sb.append("]");
                } else {
                    switch (field.c) {
                        case 0:
                            sb.append(SafeParcelReader.F(parcel, D));
                            break;
                        case 1:
                            sb.append(SafeParcelReader.c(parcel, D));
                            break;
                        case 2:
                            sb.append(SafeParcelReader.I(parcel, D));
                            break;
                        case 3:
                            sb.append(SafeParcelReader.B(parcel, D));
                            break;
                        case 4:
                            sb.append(SafeParcelReader.z(parcel, D));
                            break;
                        case 5:
                            sb.append(SafeParcelReader.a(parcel, D));
                            break;
                        case 6:
                            sb.append(SafeParcelReader.w(parcel, D));
                            break;
                        case 7:
                            String p = SafeParcelReader.p(parcel, D);
                            sb.append("\"");
                            sb.append(l.a(p));
                            sb.append("\"");
                            break;
                        case 8:
                            byte[] g2 = SafeParcelReader.g(parcel, D);
                            sb.append("\"");
                            sb.append(com.google.android.gms.common.util.c.a(g2));
                            sb.append("\"");
                            break;
                        case 9:
                            byte[] g3 = SafeParcelReader.g(parcel, D);
                            sb.append("\"");
                            sb.append(com.google.android.gms.common.util.c.b(g3));
                            sb.append("\"");
                            break;
                        case 10:
                            Bundle f3 = SafeParcelReader.f(parcel, D);
                            Set<String> keySet = f3.keySet();
                            keySet.size();
                            sb.append("{");
                            boolean z2 = true;
                            for (String str2 : keySet) {
                                if (!z2) {
                                    sb.append(",");
                                }
                                sb.append("\"");
                                sb.append(str2);
                                sb.append("\"");
                                sb.append(":");
                                sb.append("\"");
                                sb.append(l.a(f3.getString(str2)));
                                sb.append("\"");
                                z2 = false;
                            }
                            sb.append("}");
                            break;
                        case 11:
                            Parcel m = SafeParcelReader.m(parcel, D);
                            m.setDataPosition(0);
                            l(sb, field.W(), m);
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out");
                    }
                }
                z = true;
            }
        }
        if (parcel.dataPosition() == N) {
            sb.append('}');
            return;
        }
        StringBuilder sb3 = new StringBuilder(37);
        sb3.append("Overread allowed size end=");
        sb3.append(N);
        throw new SafeParcelReader.ParseException(sb3.toString(), parcel);
    }

    private final void m(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Object obj) {
        if (field.b) {
            ArrayList arrayList = (ArrayList) obj;
            sb.append("[");
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (i2 != 0) {
                    sb.append(",");
                }
                k(sb, field.a, arrayList.get(i2));
            }
            sb.append("]");
            return;
        }
        k(sb, field.a, obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0005, code lost:
        if (r0 != 1) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final android.os.Parcel n() {
        /*
            r2 = this;
            int r0 = r2.zart
            if (r0 == 0) goto L8
            r1 = 1
            if (r0 == r1) goto L10
            goto L1a
        L8:
            android.os.Parcel r0 = r2.zarr
            int r0 = com.google.android.gms.common.internal.safeparcel.a.a(r0)
            r2.zaru = r0
        L10:
            android.os.Parcel r0 = r2.zarr
            int r1 = r2.zaru
            com.google.android.gms.common.internal.safeparcel.a.b(r0, r1)
            r0 = 2
            r2.zart = r0
        L1a:
            android.os.Parcel r0 = r2.zarr
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.server.response.SafeParcelResponse.n():android.os.Parcel");
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public Map<String, FastJsonResponse.Field<?, ?>> a() {
        zal zalVar = this.zaqp;
        if (zalVar == null) {
            return null;
        }
        return zalVar.S(this.mClassName);
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    public Object c(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    public boolean g(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public String toString() {
        q.k(this.zaqp, "Cannot convert to JSON on client side.");
        Parcel n = n();
        n.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        l(sb, this.zaqp.S(this.mClassName), n);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        zal zalVar;
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 1, this.zalk);
        com.google.android.gms.common.internal.safeparcel.a.s(parcel, 2, n(), false);
        int i3 = this.zars;
        if (i3 == 0) {
            zalVar = null;
        } else if (i3 == 1) {
            zalVar = this.zaqp;
        } else if (i3 == 2) {
            zalVar = this.zaqp;
        } else {
            int i4 = this.zars;
            StringBuilder sb = new StringBuilder(34);
            sb.append("Invalid creation type: ");
            sb.append(i4);
            throw new IllegalStateException(sb.toString());
        }
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 3, zalVar, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}

package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
@KeepName
/* loaded from: classes2.dex */
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    public static final Parcelable.Creator<DataHolder> CREATOR = new i();
    private static final a zamd = new h(new String[0], null);
    private final int zalk;
    private final String[] zalv;
    private Bundle zalw;
    private final CursorWindow[] zalx;
    private final int zaly;
    private final Bundle zalz;
    private int[] zama;
    private int zamb;
    private boolean mClosed = false;
    private boolean zamc = true;

    /* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
    /* loaded from: classes2.dex */
    public static class zaa extends RuntimeException {
        public zaa(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataHolder(int i2, String[] strArr, CursorWindow[] cursorWindowArr, int i3, Bundle bundle) {
        this.zalk = i2;
        this.zalv = strArr;
        this.zalx = cursorWindowArr;
        this.zaly = i3;
        this.zalz = bundle;
    }

    private final void U(String str, int i2) {
        Bundle bundle = this.zalw;
        if (bundle != null && bundle.containsKey(str)) {
            if (!isClosed()) {
                if (i2 < 0 || i2 >= this.zamb) {
                    throw new CursorIndexOutOfBoundsException(i2, this.zamb);
                }
                return;
            }
            throw new IllegalArgumentException("Buffer is closed.");
        }
        String valueOf = String.valueOf(str);
        throw new IllegalArgumentException(valueOf.length() != 0 ? "No such column: ".concat(valueOf) : new String("No such column: "));
    }

    public static a h(String[] strArr) {
        return new a(strArr, null, null);
    }

    public final Bundle Q() {
        return this.zalz;
    }

    public final int R() {
        return this.zaly;
    }

    public final String S(String str, int i2, int i3) {
        U(str, i2);
        return this.zalx[i3].getString(i2, this.zalw.getInt(str));
    }

    public final int T(int i2) {
        int[] iArr;
        int i3 = 0;
        q.m(i2 >= 0 && i2 < this.zamb);
        while (true) {
            iArr = this.zama;
            if (i3 >= iArr.length) {
                break;
            } else if (i2 < iArr[i3]) {
                i3--;
                break;
            } else {
                i3++;
            }
        }
        return i3 == iArr.length ? i3 - 1 : i3;
    }

    public final void V() {
        this.zalw = new Bundle();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            String[] strArr = this.zalv;
            if (i3 >= strArr.length) {
                break;
            }
            this.zalw.putInt(strArr[i3], i3);
            i3++;
        }
        this.zama = new int[this.zalx.length];
        int i4 = 0;
        while (true) {
            CursorWindow[] cursorWindowArr = this.zalx;
            if (i2 < cursorWindowArr.length) {
                this.zama[i2] = i4;
                i4 += this.zalx[i2].getNumRows() - (i4 - cursorWindowArr[i2].getStartPosition());
                i2++;
            } else {
                this.zamb = i4;
                return;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this) {
            if (!this.mClosed) {
                this.mClosed = true;
                int i2 = 0;
                while (true) {
                    CursorWindow[] cursorWindowArr = this.zalx;
                    if (i2 >= cursorWindowArr.length) {
                        break;
                    }
                    cursorWindowArr[i2].close();
                    i2++;
                }
            }
        }
    }

    protected final void finalize() throws Throwable {
        try {
            if (this.zamc && this.zalx.length > 0 && !isClosed()) {
                close();
                String obj = toString();
                StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 178);
                sb.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ");
                sb.append(obj);
                sb.append(")");
                Log.e("DataBuffer", sb.toString());
            }
        } finally {
            super.finalize();
        }
    }

    public final int getCount() {
        return this.zamb;
    }

    public final boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.mClosed;
        }
        return z;
    }

    public final byte[] j(String str, int i2, int i3) {
        U(str, i2);
        return this.zalx[i3].getBlob(i2, this.zalw.getInt(str));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.w(parcel, 1, this.zalv, false);
        com.google.android.gms.common.internal.safeparcel.a.y(parcel, 2, this.zalx, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 3, R());
        com.google.android.gms.common.internal.safeparcel.a.e(parcel, 4, Q(), false);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 1000, this.zalk);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a2);
        if ((i2 & 1) != 0) {
            close();
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
    /* loaded from: classes2.dex */
    public static class a {
        private final ArrayList<HashMap<String, Object>> a;
        private final String b;
        private final HashMap<Object, Integer> c;

        private a(String[] strArr, String str) {
            q.j(strArr);
            this.a = new ArrayList<>();
            this.b = str;
            this.c = new HashMap<>();
        }

        public a a(ContentValues contentValues) {
            com.google.android.gms.common.internal.b.c(contentValues);
            HashMap<String, Object> hashMap = new HashMap<>(contentValues.size());
            for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            return b(hashMap);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public com.google.android.gms.common.data.DataHolder.a b(java.util.HashMap<java.lang.String, java.lang.Object> r5) {
            /*
                r4 = this;
                com.google.android.gms.common.internal.b.c(r5)
                java.lang.String r0 = r4.b
                r1 = -1
                if (r0 != 0) goto La
            L8:
                r0 = -1
                goto L2f
            La:
                java.lang.Object r0 = r5.get(r0)
                if (r0 != 0) goto L11
                goto L8
            L11:
                java.util.HashMap<java.lang.Object, java.lang.Integer> r2 = r4.c
                java.lang.Object r2 = r2.get(r0)
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 != 0) goto L2b
                java.util.HashMap<java.lang.Object, java.lang.Integer> r2 = r4.c
                java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> r3 = r4.a
                int r3 = r3.size()
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                r2.put(r0, r3)
                goto L8
            L2b:
                int r0 = r2.intValue()
            L2f:
                if (r0 != r1) goto L37
                java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> r0 = r4.a
                r0.add(r5)
                goto L41
            L37:
                java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> r1 = r4.a
                r1.remove(r0)
                java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> r1 = r4.a
                r1.add(r0, r5)
            L41:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.data.DataHolder.a.b(java.util.HashMap):com.google.android.gms.common.data.DataHolder$a");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(String[] strArr, String str, h hVar) {
            this(strArr, null);
        }
    }
}

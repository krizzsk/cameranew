package us.pinguo.foundation;

import android.content.Context;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import us.pinguo.foundation.utils.y;
/* compiled from: ListPreference.java */
/* loaded from: classes4.dex */
public class h implements Cloneable {

    /* renamed from: k  reason: collision with root package name */
    private static final String f11005k = h.class.getSimpleName();
    j a;
    private String b;
    private final String c;

    /* renamed from: d  reason: collision with root package name */
    protected String f11006d;

    /* renamed from: e  reason: collision with root package name */
    protected String f11007e;

    /* renamed from: f  reason: collision with root package name */
    protected String[] f11008f;

    /* renamed from: g  reason: collision with root package name */
    private Object[] f11009g;

    /* renamed from: h  reason: collision with root package name */
    private String[] f11010h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f11011i = true;

    /* renamed from: j  reason: collision with root package name */
    private boolean f11012j = false;

    public h(String str, String str2) {
        this.a = null;
        this.b = null;
        this.b = str2;
        this.c = str;
        this.a = j.e();
    }

    public void a(List<String> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int length = this.f11010h.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (list.indexOf(this.f11010h[i2].toString()) >= 0) {
                arrayList.add((String) this.f11009g[i2]);
                arrayList2.add(this.f11010h[i2]);
            }
        }
        int size = arrayList.size();
        this.f11009g = arrayList.toArray(new String[size]);
        this.f11010h = (String[]) arrayList2.toArray(new String[size]);
    }

    public int b(String str) {
        int length = this.f11010h.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (y.a(this.f11010h[i2], str)) {
                return i2;
            }
            if (Float.parseFloat(this.f11010h[i2]) == Float.parseFloat(str)) {
                return i2;
            }
        }
        return -1;
    }

    public Object[] c() {
        return this.f11009g;
    }

    public Object clone() throws CloneNotSupportedException {
        h hVar = (h) super.clone();
        String[] strArr = this.f11008f;
        if (strArr != null) {
            hVar.f11008f = (String[]) strArr.clone();
        }
        Object[] objArr = this.f11009g;
        if (objArr != null) {
            hVar.f11009g = (Object[]) objArr.clone();
        }
        String[] strArr2 = this.f11010h;
        if (strArr2 != null) {
            hVar.f11010h = (String[]) strArr2.clone();
        }
        return hVar;
    }

    public Object d() {
        int b = b(i());
        if (b >= 0) {
            Object[] objArr = this.f11009g;
            if (b < objArr.length) {
                return objArr[b];
            }
            return null;
        }
        return null;
    }

    public String e(Context context) {
        Object obj = this.f11009g[b(i())];
        if (obj instanceof String) {
            return (String) obj;
        }
        return obj instanceof Integer ? context.getString(((Integer) obj).intValue()) : "";
    }

    public String[] f() {
        return this.f11010h;
    }

    public String g() {
        return this.c;
    }

    public String h() {
        return this.b;
    }

    public String i() {
        String[] strArr;
        if (!this.f11012j) {
            j e2 = j.e();
            if (e2 != null) {
                this.f11006d = e2.k(this.c, this.f11007e);
                if ("pref_camera_jpegquality_key".equals(this.c) && "100".equals(this.f11006d)) {
                    this.f11006d = "95";
                    e2.s(this.c, "95");
                }
                us.pinguo.common.log.a.m("sssss", "getValue mkey = " + this.c + " mValue = " + this.f11006d, new Object[0]);
            } else {
                us.pinguo.common.log.a.g(f11005k, "PGCamera2Preferences is null!!", new Object[0]);
            }
            this.f11012j = true;
        }
        if (this.f11006d == null && (strArr = this.f11010h) != null && strArr.length > 0) {
            this.f11006d = strArr[0];
        }
        return this.f11006d;
    }

    public void j(String str) {
        this.f11007e = str;
        this.f11006d = str;
    }

    public void k(String[] strArr) {
        if (strArr == null) {
            strArr = new String[0];
        }
        this.f11008f = strArr;
    }

    public void l(Object[] objArr) {
        if (objArr == null) {
            objArr = new Object[0];
        }
        this.f11009g = objArr;
    }

    public void m(String[] strArr) {
        if (strArr == null) {
            strArr = new String[0];
        }
        this.f11010h = strArr;
    }

    public void n(String str) {
        if (b(str) >= 0) {
            this.f11006d = str;
            j e2 = j.e();
            if (e2 != null) {
                e2.s(this.c, str);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("value error, key=" + this.c + ",value=" + str);
    }

    public void o(int i2) {
        n(this.f11010h[i2]);
    }

    public String toString() {
        return "ListPreference{PGCamera2Preferences=" + this.a + ", mTitle='" + this.b + "', mKey='" + this.c + "', mValue='" + this.f11006d + "', mDefault='" + this.f11007e + "', mDefaultValues=" + Arrays.toString(this.f11008f) + ", mEntries=" + Arrays.toString(this.f11009g) + ", mEntryValues=" + Arrays.toString(this.f11010h) + ", mEnable=" + this.f11011i + ", mLoaded=" + this.f11012j + '}';
    }
}

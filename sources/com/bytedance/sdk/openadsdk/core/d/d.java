package com.bytedance.sdk.openadsdk.core.d;

import androidx.annotation.NonNull;
import org.json.JSONObject;
/* compiled from: ClickEventModel.java */
/* loaded from: classes.dex */
public class d {
    private final int[] a;
    private final int[] b;
    private final int[] c;

    /* renamed from: d  reason: collision with root package name */
    private final int[] f1556d;

    /* renamed from: e  reason: collision with root package name */
    private final int f1557e;

    /* renamed from: f  reason: collision with root package name */
    private final int f1558f;

    /* renamed from: g  reason: collision with root package name */
    private final int f1559g;

    /* renamed from: h  reason: collision with root package name */
    private final int f1560h;

    /* renamed from: i  reason: collision with root package name */
    private final long f1561i;

    /* renamed from: j  reason: collision with root package name */
    private final long f1562j;

    /* renamed from: k  reason: collision with root package name */
    private final int f1563k;

    /* renamed from: l  reason: collision with root package name */
    private final int f1564l;
    private final int m;

    /* compiled from: ClickEventModel.java */
    /* loaded from: classes.dex */
    public static class a {
        private long a;
        private long b;
        private int c;

        /* renamed from: d  reason: collision with root package name */
        private int f1565d;

        /* renamed from: e  reason: collision with root package name */
        private int f1566e;

        /* renamed from: f  reason: collision with root package name */
        private int f1567f;

        /* renamed from: g  reason: collision with root package name */
        private int[] f1568g;

        /* renamed from: h  reason: collision with root package name */
        private int[] f1569h;

        /* renamed from: i  reason: collision with root package name */
        private int[] f1570i;

        /* renamed from: j  reason: collision with root package name */
        private int[] f1571j;

        /* renamed from: k  reason: collision with root package name */
        private int f1572k;

        /* renamed from: l  reason: collision with root package name */
        private int f1573l;
        private int m;

        public a a(long j2) {
            this.a = j2;
            return this;
        }

        public a b(long j2) {
            this.b = j2;
            return this;
        }

        public a c(int i2) {
            this.f1566e = i2;
            return this;
        }

        public a d(int i2) {
            this.f1567f = i2;
            return this;
        }

        public a e(int i2) {
            this.f1572k = i2;
            return this;
        }

        public a f(int i2) {
            this.f1573l = i2;
            return this;
        }

        public a g(int i2) {
            this.m = i2;
            return this;
        }

        public a a(int i2) {
            this.c = i2;
            return this;
        }

        public a b(int i2) {
            this.f1565d = i2;
            return this;
        }

        public a c(int[] iArr) {
            this.f1570i = iArr;
            return this;
        }

        public a d(int[] iArr) {
            this.f1571j = iArr;
            return this;
        }

        public a a(int[] iArr) {
            this.f1568g = iArr;
            return this;
        }

        public a b(int[] iArr) {
            this.f1569h = iArr;
            return this;
        }

        public d a() {
            return new d(this);
        }
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            int[] iArr = this.a;
            if (iArr != null && iArr.length == 2) {
                jSONObject.putOpt("ad_x", Integer.valueOf(iArr[0])).putOpt("ad_y", Integer.valueOf(this.a[1]));
            }
            int[] iArr2 = this.b;
            if (iArr2 != null && iArr2.length == 2) {
                jSONObject.putOpt("width", Integer.valueOf(iArr2[0])).putOpt("height", Integer.valueOf(this.b[1]));
            }
            int[] iArr3 = this.c;
            if (iArr3 != null && iArr3.length == 2) {
                jSONObject.putOpt("button_x", Integer.valueOf(iArr3[0])).putOpt("button_y", Integer.valueOf(this.c[1]));
            }
            int[] iArr4 = this.f1556d;
            if (iArr4 != null && iArr4.length == 2) {
                jSONObject.putOpt("button_width", Integer.valueOf(iArr4[0])).putOpt("button_height", Integer.valueOf(this.f1556d[1]));
            }
            jSONObject.putOpt("down_x", Integer.valueOf(this.f1557e)).putOpt("down_y", Integer.valueOf(this.f1558f)).putOpt("up_x", Integer.valueOf(this.f1559g)).putOpt("up_y", Integer.valueOf(this.f1560h)).putOpt("down_time", Long.valueOf(this.f1561i)).putOpt("up_time", Long.valueOf(this.f1562j)).putOpt("toolType", Integer.valueOf(this.f1563k)).putOpt("deviceId", Integer.valueOf(this.f1564l)).putOpt("source", Integer.valueOf(this.m));
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private d(@NonNull a aVar) {
        this.a = aVar.f1569h;
        this.b = aVar.f1570i;
        this.f1556d = aVar.f1571j;
        this.c = aVar.f1568g;
        this.f1557e = aVar.f1567f;
        this.f1558f = aVar.f1566e;
        this.f1559g = aVar.f1565d;
        this.f1560h = aVar.c;
        this.f1561i = aVar.b;
        this.f1562j = aVar.a;
        this.f1563k = aVar.f1572k;
        this.f1564l = aVar.f1573l;
        this.m = aVar.m;
    }
}

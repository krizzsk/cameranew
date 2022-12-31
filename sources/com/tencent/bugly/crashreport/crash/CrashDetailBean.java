package com.tencent.bugly.crashreport.crash;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.proguard.z;
import java.util.Map;
import java.util.UUID;
/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public class CrashDetailBean implements Parcelable, Comparable<CrashDetailBean> {
    public static final Parcelable.Creator<CrashDetailBean> CREATOR = new a();
    public String A;
    public String B;
    public long C;
    public long D;
    public long E;
    public long F;
    public long G;
    public long H;
    public String I;
    public String J;
    public String K;
    public String L;
    public long M;
    public boolean N;
    public Map<String, String> O;
    public Map<String, String> P;
    public int Q;
    public int R;
    public Map<String, String> S;
    public Map<String, String> T;
    public byte[] U;
    public String V;
    public String W;
    private String X;
    public long a;
    public int b;
    public String c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f7842d;

    /* renamed from: e  reason: collision with root package name */
    public String f7843e;

    /* renamed from: f  reason: collision with root package name */
    public String f7844f;

    /* renamed from: g  reason: collision with root package name */
    public String f7845g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, PlugInBean> f7846h;

    /* renamed from: i  reason: collision with root package name */
    public Map<String, PlugInBean> f7847i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f7848j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f7849k;

    /* renamed from: l  reason: collision with root package name */
    public int f7850l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public long r;
    public String s;
    public int t;
    public String u;
    public String v;
    public String w;
    public String x;
    public byte[] y;
    public Map<String, String> z;

    /* compiled from: BUGLY */
    /* loaded from: classes3.dex */
    static class a implements Parcelable.Creator<CrashDetailBean> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CrashDetailBean createFromParcel(Parcel parcel) {
            return new CrashDetailBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ CrashDetailBean[] newArray(int i2) {
            return new CrashDetailBean[i2];
        }
    }

    public CrashDetailBean() {
        this.a = -1L;
        this.b = 0;
        this.c = UUID.randomUUID().toString();
        this.f7842d = false;
        this.f7843e = "";
        this.f7844f = "";
        this.f7845g = "";
        this.f7846h = null;
        this.f7847i = null;
        this.f7848j = false;
        this.f7849k = false;
        this.f7850l = 0;
        this.m = "";
        this.n = "";
        this.o = "";
        this.p = "";
        this.q = "";
        this.r = -1L;
        this.s = null;
        this.t = 0;
        this.u = "";
        this.v = "";
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = "";
        this.B = "";
        this.C = -1L;
        this.D = -1L;
        this.E = -1L;
        this.F = -1L;
        this.G = -1L;
        this.H = -1L;
        this.I = "";
        this.X = "";
        this.J = "";
        this.K = "";
        this.L = "";
        this.M = -1L;
        this.N = false;
        this.O = null;
        this.P = null;
        this.Q = -1;
        this.R = -1;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = null;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(CrashDetailBean crashDetailBean) {
        int i2;
        CrashDetailBean crashDetailBean2 = crashDetailBean;
        if (crashDetailBean2 == null || this.r - crashDetailBean2.r > 0) {
            return 1;
        }
        return i2 < 0 ? -1 : 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.b);
        parcel.writeString(this.c);
        parcel.writeByte(this.f7842d ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f7843e);
        parcel.writeString(this.f7844f);
        parcel.writeString(this.f7845g);
        parcel.writeByte(this.f7848j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f7849k ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f7850l);
        parcel.writeString(this.m);
        parcel.writeString(this.n);
        parcel.writeString(this.o);
        parcel.writeString(this.p);
        parcel.writeString(this.q);
        parcel.writeLong(this.r);
        parcel.writeString(this.s);
        parcel.writeInt(this.t);
        parcel.writeString(this.u);
        parcel.writeString(this.v);
        parcel.writeString(this.w);
        z.b(parcel, this.z);
        parcel.writeString(this.A);
        parcel.writeString(this.B);
        parcel.writeLong(this.C);
        parcel.writeLong(this.D);
        parcel.writeLong(this.E);
        parcel.writeLong(this.F);
        parcel.writeLong(this.G);
        parcel.writeLong(this.H);
        parcel.writeString(this.I);
        parcel.writeString(this.X);
        parcel.writeString(this.J);
        parcel.writeString(this.K);
        parcel.writeString(this.L);
        parcel.writeLong(this.M);
        parcel.writeByte(this.N ? (byte) 1 : (byte) 0);
        z.b(parcel, this.O);
        z.a(parcel, this.f7846h);
        z.a(parcel, this.f7847i);
        parcel.writeInt(this.Q);
        parcel.writeInt(this.R);
        z.b(parcel, this.S);
        z.b(parcel, this.T);
        parcel.writeByteArray(this.U);
        parcel.writeByteArray(this.y);
        parcel.writeString(this.V);
        parcel.writeString(this.W);
        parcel.writeString(this.x);
    }

    public CrashDetailBean(Parcel parcel) {
        this.a = -1L;
        this.b = 0;
        this.c = UUID.randomUUID().toString();
        this.f7842d = false;
        this.f7843e = "";
        this.f7844f = "";
        this.f7845g = "";
        this.f7846h = null;
        this.f7847i = null;
        this.f7848j = false;
        this.f7849k = false;
        this.f7850l = 0;
        this.m = "";
        this.n = "";
        this.o = "";
        this.p = "";
        this.q = "";
        this.r = -1L;
        this.s = null;
        this.t = 0;
        this.u = "";
        this.v = "";
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = "";
        this.B = "";
        this.C = -1L;
        this.D = -1L;
        this.E = -1L;
        this.F = -1L;
        this.G = -1L;
        this.H = -1L;
        this.I = "";
        this.X = "";
        this.J = "";
        this.K = "";
        this.L = "";
        this.M = -1L;
        this.N = false;
        this.O = null;
        this.P = null;
        this.Q = -1;
        this.R = -1;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = null;
        this.b = parcel.readInt();
        this.c = parcel.readString();
        this.f7842d = parcel.readByte() == 1;
        this.f7843e = parcel.readString();
        this.f7844f = parcel.readString();
        this.f7845g = parcel.readString();
        this.f7848j = parcel.readByte() == 1;
        this.f7849k = parcel.readByte() == 1;
        this.f7850l = parcel.readInt();
        this.m = parcel.readString();
        this.n = parcel.readString();
        this.o = parcel.readString();
        this.p = parcel.readString();
        this.q = parcel.readString();
        this.r = parcel.readLong();
        this.s = parcel.readString();
        this.t = parcel.readInt();
        this.u = parcel.readString();
        this.v = parcel.readString();
        this.w = parcel.readString();
        this.z = z.b(parcel);
        this.A = parcel.readString();
        this.B = parcel.readString();
        this.C = parcel.readLong();
        this.D = parcel.readLong();
        this.E = parcel.readLong();
        this.F = parcel.readLong();
        this.G = parcel.readLong();
        this.H = parcel.readLong();
        this.I = parcel.readString();
        this.X = parcel.readString();
        this.J = parcel.readString();
        this.K = parcel.readString();
        this.L = parcel.readString();
        this.M = parcel.readLong();
        this.N = parcel.readByte() == 1;
        this.O = z.b(parcel);
        this.f7846h = z.a(parcel);
        this.f7847i = z.a(parcel);
        this.Q = parcel.readInt();
        this.R = parcel.readInt();
        this.S = z.b(parcel);
        this.T = z.b(parcel);
        this.U = parcel.createByteArray();
        this.y = parcel.createByteArray();
        this.V = parcel.readString();
        this.W = parcel.readString();
        this.x = parcel.readString();
    }
}

package com.tencent.bugly.crashreport.common.strategy;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkRequest;
import com.tencent.bugly.proguard.z;
import java.util.Map;
/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public class StrategyBean implements Parcelable {
    public static final Parcelable.Creator<StrategyBean> CREATOR = new a();
    public static String a = "https://android.bugly.qq.com/rqd/async";
    public static String b = "https://android.bugly.qq.com/rqd/async";
    public long c;

    /* renamed from: d  reason: collision with root package name */
    public long f7826d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f7827e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7828f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f7829g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f7830h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f7831i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f7832j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f7833k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f7834l;
    public boolean m;
    public long n;
    public long o;
    public String p;
    public String q;
    public String r;
    public Map<String, String> s;
    public int t;
    public long u;
    public long v;

    /* compiled from: BUGLY */
    /* loaded from: classes3.dex */
    static class a implements Parcelable.Creator<StrategyBean> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ StrategyBean createFromParcel(Parcel parcel) {
            return new StrategyBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ StrategyBean[] newArray(int i2) {
            return new StrategyBean[i2];
        }
    }

    public StrategyBean() {
        this.c = -1L;
        this.f7826d = -1L;
        this.f7827e = true;
        this.f7828f = true;
        this.f7829g = true;
        this.f7830h = true;
        this.f7831i = false;
        this.f7832j = true;
        this.f7833k = true;
        this.f7834l = true;
        this.m = true;
        this.o = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
        this.p = a;
        this.q = b;
        this.t = 10;
        this.u = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
        this.v = -1L;
        this.f7826d = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append("S(@L@L");
        sb.append("@)");
        sb.toString();
        sb.setLength(0);
        sb.append("*^@K#K");
        sb.append("@!");
        this.r = sb.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f7826d);
        parcel.writeByte(this.f7827e ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f7828f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f7829g ? (byte) 1 : (byte) 0);
        parcel.writeString(this.p);
        parcel.writeString(this.q);
        parcel.writeString(this.r);
        z.b(parcel, this.s);
        parcel.writeByte(this.f7830h ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f7831i ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f7834l ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.m ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.o);
        parcel.writeByte(this.f7832j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f7833k ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.n);
        parcel.writeInt(this.t);
        parcel.writeLong(this.u);
        parcel.writeLong(this.v);
    }

    public StrategyBean(Parcel parcel) {
        this.c = -1L;
        this.f7826d = -1L;
        boolean z = true;
        this.f7827e = true;
        this.f7828f = true;
        this.f7829g = true;
        this.f7830h = true;
        this.f7831i = false;
        this.f7832j = true;
        this.f7833k = true;
        this.f7834l = true;
        this.m = true;
        this.o = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
        this.p = a;
        this.q = b;
        this.t = 10;
        this.u = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
        this.v = -1L;
        try {
            String str = "S(@L@L@)";
            this.f7826d = parcel.readLong();
            this.f7827e = parcel.readByte() == 1;
            this.f7828f = parcel.readByte() == 1;
            this.f7829g = parcel.readByte() == 1;
            this.p = parcel.readString();
            this.q = parcel.readString();
            this.r = parcel.readString();
            this.s = z.b(parcel);
            this.f7830h = parcel.readByte() == 1;
            this.f7831i = parcel.readByte() == 1;
            this.f7834l = parcel.readByte() == 1;
            this.m = parcel.readByte() == 1;
            this.o = parcel.readLong();
            this.f7832j = parcel.readByte() == 1;
            if (parcel.readByte() != 1) {
                z = false;
            }
            this.f7833k = z;
            this.n = parcel.readLong();
            this.t = parcel.readInt();
            this.u = parcel.readLong();
            this.v = parcel.readLong();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}

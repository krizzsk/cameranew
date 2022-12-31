package com.tencent.bugly.crashreport.biz;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.proguard.z;
import java.util.Map;
/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public class UserInfoBean implements Parcelable {
    public static final Parcelable.Creator<UserInfoBean> CREATOR = new a();
    public long a;
    public int b;
    public String c;

    /* renamed from: d  reason: collision with root package name */
    public String f7798d;

    /* renamed from: e  reason: collision with root package name */
    public long f7799e;

    /* renamed from: f  reason: collision with root package name */
    public long f7800f;

    /* renamed from: g  reason: collision with root package name */
    public long f7801g;

    /* renamed from: h  reason: collision with root package name */
    public long f7802h;

    /* renamed from: i  reason: collision with root package name */
    public long f7803i;

    /* renamed from: j  reason: collision with root package name */
    public String f7804j;

    /* renamed from: k  reason: collision with root package name */
    public long f7805k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f7806l;
    public String m;
    public String n;
    public int o;
    public int p;
    public int q;
    public Map<String, String> r;
    public Map<String, String> s;

    /* compiled from: BUGLY */
    /* loaded from: classes3.dex */
    static class a implements Parcelable.Creator<UserInfoBean> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ UserInfoBean createFromParcel(Parcel parcel) {
            return new UserInfoBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ UserInfoBean[] newArray(int i2) {
            return new UserInfoBean[i2];
        }
    }

    public UserInfoBean() {
        this.f7805k = 0L;
        this.f7806l = false;
        this.m = "unknown";
        this.p = -1;
        this.q = -1;
        this.r = null;
        this.s = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.f7798d);
        parcel.writeLong(this.f7799e);
        parcel.writeLong(this.f7800f);
        parcel.writeLong(this.f7801g);
        parcel.writeLong(this.f7802h);
        parcel.writeLong(this.f7803i);
        parcel.writeString(this.f7804j);
        parcel.writeLong(this.f7805k);
        parcel.writeByte(this.f7806l ? (byte) 1 : (byte) 0);
        parcel.writeString(this.m);
        parcel.writeInt(this.p);
        parcel.writeInt(this.q);
        z.b(parcel, this.r);
        z.b(parcel, this.s);
        parcel.writeString(this.n);
        parcel.writeInt(this.o);
    }

    public UserInfoBean(Parcel parcel) {
        this.f7805k = 0L;
        this.f7806l = false;
        this.m = "unknown";
        this.p = -1;
        this.q = -1;
        this.r = null;
        this.s = null;
        this.b = parcel.readInt();
        this.c = parcel.readString();
        this.f7798d = parcel.readString();
        this.f7799e = parcel.readLong();
        this.f7800f = parcel.readLong();
        this.f7801g = parcel.readLong();
        this.f7802h = parcel.readLong();
        this.f7803i = parcel.readLong();
        this.f7804j = parcel.readString();
        this.f7805k = parcel.readLong();
        this.f7806l = parcel.readByte() == 1;
        this.m = parcel.readString();
        this.p = parcel.readInt();
        this.q = parcel.readInt();
        this.r = z.b(parcel);
        this.s = z.b(parcel);
        this.n = parcel.readString();
        this.o = parcel.readInt();
    }
}

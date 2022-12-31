package com.tencent.bugly.crashreport.common.info;

import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public class PlugInBean implements Parcelable {
    public static final Parcelable.Creator<PlugInBean> CREATOR = new a();
    public final String a;
    public final String b;
    public final String c;

    /* compiled from: BUGLY */
    /* loaded from: classes3.dex */
    static class a implements Parcelable.Creator<PlugInBean> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PlugInBean createFromParcel(Parcel parcel) {
            return new PlugInBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PlugInBean[] newArray(int i2) {
            return new PlugInBean[i2];
        }
    }

    public PlugInBean(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "plid:" + this.a + " plV:" + this.b + " plUUID:" + this.c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }

    public PlugInBean(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
    }
}

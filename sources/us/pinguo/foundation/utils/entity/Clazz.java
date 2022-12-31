package us.pinguo.foundation.utils.entity;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes4.dex */
public class Clazz implements Parcelable {
    public static final Parcelable.Creator<Clazz> CREATOR = new a();
    private Object[] args;
    private String clazzName;
    private String method;

    /* loaded from: classes4.dex */
    class a implements Parcelable.Creator<Clazz> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Clazz createFromParcel(Parcel parcel) {
            return new Clazz(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public Clazz[] newArray(int i2) {
            return new Clazz[i2];
        }
    }

    public Clazz() {
    }

    public Object[] a() {
        return this.args;
    }

    public String b() {
        return this.clazzName;
    }

    public String c() {
        return this.method;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void f(Object[] objArr) {
        this.args = objArr;
    }

    public void g(String str) {
        this.clazzName = str;
    }

    public void h(String str) {
        this.method = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.clazzName);
        parcel.writeString(this.method);
        parcel.writeArray(this.args);
    }

    protected Clazz(Parcel parcel) {
        this.clazzName = parcel.readString();
        this.method = parcel.readString();
        this.args = parcel.readArray(Object[].class.getClassLoader());
    }
}

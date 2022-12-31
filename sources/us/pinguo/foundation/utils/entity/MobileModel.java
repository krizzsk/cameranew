package us.pinguo.foundation.utils.entity;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes4.dex */
public class MobileModel implements Parcelable {
    public static final Parcelable.Creator<MobileModel> CREATOR = new a();
    private String brand;
    private Clazz clazz;
    private String feature;
    private boolean isFrontFlashSupport;
    private String model;
    private String name;
    private int sdkVersion;

    /* loaded from: classes4.dex */
    class a implements Parcelable.Creator<MobileModel> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MobileModel createFromParcel(Parcel parcel) {
            return new MobileModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public MobileModel[] newArray(int i2) {
            return new MobileModel[i2];
        }
    }

    public MobileModel() {
        this.isFrontFlashSupport = true;
    }

    public String a() {
        return this.brand;
    }

    public Clazz b() {
        return this.clazz;
    }

    public String c() {
        return this.feature;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String f() {
        return this.model;
    }

    public void g(String str) {
        this.brand = str;
    }

    public void h(Clazz clazz) {
        this.clazz = clazz;
    }

    public void j(String str) {
        this.feature = str;
    }

    public void k(String str) {
        this.model = str;
    }

    public void l(String str) {
        this.name = str;
    }

    public void m(int i2) {
        this.sdkVersion = i2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.brand);
        parcel.writeString(this.name);
        parcel.writeString(this.model);
        parcel.writeByte(this.isFrontFlashSupport ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.sdkVersion);
        parcel.writeString(this.feature);
        parcel.writeParcelable(this.clazz, i2);
    }

    protected MobileModel(Parcel parcel) {
        this.isFrontFlashSupport = true;
        this.brand = parcel.readString();
        this.name = parcel.readString();
        this.model = parcel.readString();
        this.isFrontFlashSupport = parcel.readByte() != 0;
        this.sdkVersion = parcel.readInt();
        this.feature = parcel.readString();
        this.clazz = (Clazz) parcel.readParcelable(Clazz.class.getClassLoader());
    }
}

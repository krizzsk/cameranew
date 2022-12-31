package us.pinguo.advconfigdata.database;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public class SslDomain implements Parcelable {
    public static final Parcelable.Creator<SslDomain> CREATOR = new a();
    private String domain;
    private String fingerprint;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<SslDomain> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SslDomain createFromParcel(Parcel parcel) {
            return new SslDomain(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SslDomain[] newArray(int i2) {
            return new SslDomain[i2];
        }
    }

    public SslDomain() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDomain() {
        return this.domain;
    }

    public String getFingerprint() {
        return this.fingerprint;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public void setFingerprint(String str) {
        this.fingerprint = str;
    }

    public String toString() {
        return "SslDomain{domain='" + this.domain + "', fingerprint='" + this.fingerprint + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.domain);
        parcel.writeString(this.fingerprint);
    }

    protected SslDomain(Parcel parcel) {
        this.domain = parcel.readString();
        this.fingerprint = parcel.readString();
    }
}

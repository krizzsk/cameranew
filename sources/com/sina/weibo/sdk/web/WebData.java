package com.sina.weibo.sdk.web;

import android.os.Parcel;
import android.os.Parcelable;
import com.sina.weibo.sdk.auth.AuthInfo;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class WebData implements Parcelable, Serializable {
    public static final Parcelable.Creator<WebData> CREATOR = new Parcelable.Creator<WebData>() { // from class: com.sina.weibo.sdk.web.WebData.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WebData createFromParcel(Parcel parcel) {
            return new WebData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WebData[] newArray(int i2) {
            return new WebData[i2];
        }
    };
    private static final long serialVersionUID = -4038177938155795889L;
    protected AuthInfo aA;
    protected String aB;
    protected int type;
    protected String url;

    public WebData(AuthInfo authInfo, int i2, String str, String str2) {
        this.aA = authInfo;
        this.type = i2;
        this.url = str;
        this.aB = str2;
    }

    public final AuthInfo a() {
        return this.aA;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String u() {
        return this.aB;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.aA, i2);
        parcel.writeInt(this.type);
        parcel.writeString(this.url);
        parcel.writeString(this.aB);
    }

    protected WebData(Parcel parcel) {
        this.aA = (AuthInfo) parcel.readParcelable(AuthInfo.class.getClassLoader());
        this.type = parcel.readInt();
        this.url = parcel.readString();
        this.aB = parcel.readString();
    }
}

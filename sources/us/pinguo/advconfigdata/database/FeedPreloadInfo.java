package us.pinguo.advconfigdata.database;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public class FeedPreloadInfo implements Parcelable {
    public static final Parcelable.Creator<FeedPreloadInfo> CREATOR = new a();
    public static String key_admid = "admId";
    public static String key_advtype = "advType";
    public static String key_cachenum = "sdkAdvNumLimit";
    public static String key_fbid = "fbId";
    public static String key_mvid = "mvId";
    public String admId;
    public String advType;
    public String fbId;
    public String mvId;
    public int sdkAdvNumLimit;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<FeedPreloadInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public FeedPreloadInfo createFromParcel(Parcel parcel) {
            return new FeedPreloadInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public FeedPreloadInfo[] newArray(int i2) {
            return new FeedPreloadInfo[i2];
        }
    }

    public FeedPreloadInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.sdkAdvNumLimit);
        parcel.writeString(this.advType);
        parcel.writeString(this.fbId);
        parcel.writeString(this.mvId);
        parcel.writeString(this.admId);
    }

    protected FeedPreloadInfo(Parcel parcel) {
        this.sdkAdvNumLimit = parcel.readInt();
        this.advType = parcel.readString();
        this.fbId = parcel.readString();
        this.mvId = parcel.readString();
        this.admId = parcel.readString();
    }
}

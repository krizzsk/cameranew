package us.pinguo.share.util;

import android.os.Parcel;
import android.os.Parcelable;
import us.pinguo.share.core.ShareSite;
/* loaded from: classes6.dex */
public class ExpandShareSite implements Parcelable {
    public static final Parcelable.Creator<ExpandShareSite> CREATOR = new a();
    private ShareSite mShareSite;
    private int mSiteIconRes;
    private int mSiteTitleRes;
    private String mTag;

    /* loaded from: classes6.dex */
    class a implements Parcelable.Creator<ExpandShareSite> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ExpandShareSite createFromParcel(Parcel parcel) {
            return new ExpandShareSite(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ExpandShareSite[] newArray(int i2) {
            return new ExpandShareSite[i2];
        }
    }

    public ExpandShareSite(ShareSite shareSite) {
        this.mShareSite = shareSite;
    }

    public ShareSite a() {
        ShareSite shareSite = this.mShareSite;
        return shareSite == null ? ShareSite.OTHER : shareSite;
    }

    public int b() {
        return this.mSiteIconRes;
    }

    public int c() {
        return this.mSiteTitleRes;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String f() {
        return this.mTag;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        ShareSite shareSite = this.mShareSite;
        parcel.writeInt(shareSite == null ? -1 : shareSite.ordinal());
        parcel.writeInt(this.mSiteTitleRes);
        parcel.writeInt(this.mSiteIconRes);
        parcel.writeString(this.mTag);
    }

    protected ExpandShareSite(Parcel parcel) {
        int readInt = parcel.readInt();
        this.mShareSite = readInt == -1 ? null : ShareSite.values()[readInt];
        this.mSiteTitleRes = parcel.readInt();
        this.mSiteIconRes = parcel.readInt();
        this.mTag = parcel.readString();
    }
}

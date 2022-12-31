package us.pinguo.advconfigdata.database;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import us.pinguo.advconfigdata.AdvConfigManager;
/* loaded from: classes3.dex */
public class AdvItemSingle implements Parcelable {
    public static final Parcelable.Creator<AdvItemSingle> CREATOR = new a();
    public long activeTime;
    public int activeType;
    public int activeUserType;
    public AdvData advData;
    public String advId;
    public String advType;
    public long expireTime;
    public int forceInnerBrowser;
    public int forceSingle;
    public int guidType;
    public int initStamp;
    public float priority;
    public String sdkPlan;
    public int showSingle;
    public String title;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<AdvItemSingle> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AdvItemSingle createFromParcel(Parcel parcel) {
            return new AdvItemSingle(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public AdvItemSingle[] newArray(int i2) {
            return new AdvItemSingle[i2];
        }
    }

    public AdvItemSingle() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean isFilterVip() {
        boolean z = !TextUtils.isEmpty(AdvConfigManager.getInstance().getAdvConfig().getUserId());
        int i2 = this.activeUserType;
        if (i2 != 1 || z) {
            return i2 == 2 && z;
        }
        return true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.advId);
        parcel.writeString(this.title);
        parcel.writeLong(this.activeTime);
        parcel.writeLong(this.expireTime);
        parcel.writeFloat(this.priority);
        parcel.writeInt(this.forceInnerBrowser);
        parcel.writeInt(this.activeType);
        parcel.writeInt(this.activeUserType);
        parcel.writeInt(this.showSingle);
        parcel.writeInt(this.forceSingle);
        parcel.writeInt(this.initStamp);
        parcel.writeInt(this.guidType);
        parcel.writeString(this.sdkPlan);
        parcel.writeString(this.advType);
        parcel.writeParcelable(this.advData, i2);
    }

    protected AdvItemSingle(Parcel parcel) {
        this.advId = parcel.readString();
        this.title = parcel.readString();
        this.activeTime = parcel.readLong();
        this.expireTime = parcel.readLong();
        this.priority = parcel.readFloat();
        this.forceInnerBrowser = parcel.readInt();
        this.activeType = parcel.readInt();
        this.activeUserType = parcel.readInt();
        this.showSingle = parcel.readInt();
        this.forceSingle = parcel.readInt();
        this.initStamp = parcel.readInt();
        this.guidType = parcel.readInt();
        this.sdkPlan = parcel.readString();
        this.advType = parcel.readString();
        this.advData = (AdvData) parcel.readParcelable(AdvData.class.getClassLoader());
    }
}

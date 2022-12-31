package us.pinguo.advstrategy.strategybean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import us.pinguo.advsdk.bean.BaseBean;
/* loaded from: classes3.dex */
public class StrategyData extends BaseBean {
    public static final Parcelable.Creator<StrategyData> CREATOR = new Parcelable.Creator<StrategyData>() { // from class: us.pinguo.advstrategy.strategybean.StrategyData.1
        @Override // android.os.Parcelable.Creator
        public StrategyData createFromParcel(Parcel parcel) {
            return new StrategyData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public StrategyData[] newArray(int i2) {
            return new StrategyData[i2];
        }
    };
    public String adhost;
    public String country_code;
    public String etag;
    public String exp_version;
    public int interval;
    public ArrayList<StrategyItem> parameters;

    public StrategyData() {
    }

    @Override // us.pinguo.advsdk.bean.BaseBean, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // us.pinguo.advsdk.bean.BaseBean, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.exp_version);
        parcel.writeInt(this.interval);
        parcel.writeString(this.country_code);
        parcel.writeString(this.etag);
        parcel.writeString(this.adhost);
        parcel.writeTypedList(this.parameters);
    }

    protected StrategyData(Parcel parcel) {
        super(parcel);
        this.exp_version = parcel.readString();
        this.interval = parcel.readInt();
        this.country_code = parcel.readString();
        this.etag = parcel.readString();
        this.adhost = parcel.readString();
        this.parameters = parcel.createTypedArrayList(StrategyItem.CREATOR);
    }
}

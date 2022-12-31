package us.pinguo.advstrategy.strategybean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tapjoy.TJAdUnitConstants;
import java.util.ArrayList;
import java.util.Iterator;
import us.pinguo.advsdk.bean.AdsItem;
import us.pinguo.advsdk.bean.BaseBean;
import us.pinguo.advsdk.utils.b;
/* loaded from: classes3.dex */
public class StrategyItem extends BaseBean {
    public static final Parcelable.Creator<StrategyItem> CREATOR = new Parcelable.Creator<StrategyItem>() { // from class: us.pinguo.advstrategy.strategybean.StrategyItem.1
        @Override // android.os.Parcelable.Creator
        public StrategyItem createFromParcel(Parcel parcel) {
            return new StrategyItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public StrategyItem[] newArray(int i2) {
            return new StrategyItem[i2];
        }
    };
    public int button_shimmer_times;
    public int displayDuration;
    public String display_format;
    public String edit_result_upperright_bt_entry;
    public String frequency_capping;
    public long getadInterval;
    public String home_page_type;
    public String home_upperright_bt_entry;
    public ArrayList<String> install_broadcast_to;
    public int interstitialInterval;
    public int is_collect_process;
    public String local_push;
    public String on_off;
    public ArrayList<String> open_key;
    public String plan;
    public String prod_tag;
    public long pullTimeout;
    public long realTimeLoad;
    public String server_push;
    public String square_upperright_bt_entry;
    public String tag;
    public String uiStyle;
    public int ui_type;
    public String unit_desc;
    public String unit_id;
    public String update;
    public String user_guide_type;
    public long waitTime;
    public ArrayList<AdsItem> waterfall;

    public StrategyItem() {
    }

    @Override // us.pinguo.advsdk.bean.BaseBean, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getButton_shimmer_times() {
        return this.button_shimmer_times;
    }

    public int getFrequencyTimes() {
        if (TextUtils.isEmpty(this.frequency_capping)) {
            return 0;
        }
        try {
            return Integer.valueOf(this.frequency_capping).intValue();
        } catch (NumberFormatException e2) {
            b.a(e2.getMessage());
            return 0;
        }
    }

    public String getHomePageType() {
        return this.home_page_type;
    }

    public ArrayList<String> getInstallBroadCastList() {
        return this.install_broadcast_to;
    }

    public String getLocal_push() {
        return this.local_push;
    }

    public String getLockScreenType() {
        return this.user_guide_type;
    }

    public String getProductTag() {
        return this.prod_tag;
    }

    public long getPullTimeOut() {
        return this.pullTimeout;
    }

    public long getRealTimeLoad() {
        return this.realTimeLoad;
    }

    public String getServer_push() {
        return this.server_push;
    }

    public String getTag() {
        return this.tag;
    }

    public int getUi_type() {
        return this.ui_type;
    }

    public String getUpdateInfo() {
        return this.update;
    }

    public long getWaitTime() {
        return this.waitTime;
    }

    public boolean isCollectProcess() {
        return this.is_collect_process == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean isContaninAlliance() {
        /*
            r4 = this;
            java.util.ArrayList<us.pinguo.advsdk.bean.AdsItem> r0 = r4.waterfall
            r1 = 1
            if (r0 == 0) goto L28
            int r0 = r0.size()
            if (r0 != 0) goto Lc
            goto L28
        Lc:
            java.util.ArrayList<us.pinguo.advsdk.bean.AdsItem> r0 = r4.waterfall
            java.util.Iterator r0 = r0.iterator()
        L12:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L26
            java.lang.Object r2 = r0.next()
            us.pinguo.advsdk.bean.AdsItem r2 = (us.pinguo.advsdk.bean.AdsItem) r2
            int r2 = r2.loadSDK
            if (r2 == 0) goto L25
            r3 = 6
            if (r2 != r3) goto L12
        L25:
            return r1
        L26:
            r0 = 0
            return r0
        L28:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.advstrategy.strategybean.StrategyItem.isContaninAlliance():boolean");
    }

    public boolean isEnable() {
        return TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON.equals(this.on_off);
    }

    public boolean isExperiment() {
        String str = this.tag;
        return (str == null || str.equals("")) ? false : true;
    }

    public boolean isWaterfallEmpty() {
        ArrayList<AdsItem> arrayList = this.waterfall;
        if (arrayList != null && arrayList.size() != 0) {
            Iterator<AdsItem> it = this.waterfall.iterator();
            while (it.hasNext()) {
                int i2 = it.next().loadSDK;
                if (i2 != 0 && i2 != 6) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // us.pinguo.advsdk.bean.BaseBean, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.unit_id);
        parcel.writeString(this.unit_desc);
        parcel.writeString(this.on_off);
        parcel.writeString(this.display_format);
        parcel.writeString(this.tag);
        parcel.writeString(this.prod_tag);
        parcel.writeInt(this.ui_type);
        parcel.writeInt(this.button_shimmer_times);
        parcel.writeString(this.home_page_type);
        parcel.writeString(this.user_guide_type);
        parcel.writeString(this.frequency_capping);
        parcel.writeStringList(this.install_broadcast_to);
        parcel.writeString(this.local_push);
        parcel.writeString(this.server_push);
        parcel.writeString(this.home_upperright_bt_entry);
        parcel.writeString(this.square_upperright_bt_entry);
        parcel.writeString(this.edit_result_upperright_bt_entry);
        parcel.writeInt(this.is_collect_process);
        parcel.writeStringList(this.open_key);
        parcel.writeLong(this.getadInterval);
        parcel.writeLong(this.pullTimeout);
        parcel.writeTypedList(this.waterfall);
        parcel.writeString(this.update);
        parcel.writeString(this.plan);
        parcel.writeInt(this.interstitialInterval);
        parcel.writeLong(this.realTimeLoad);
        parcel.writeLong(this.waitTime);
        parcel.writeString(this.uiStyle);
        parcel.writeInt(this.displayDuration);
    }

    protected StrategyItem(Parcel parcel) {
        super(parcel);
        this.unit_id = parcel.readString();
        this.unit_desc = parcel.readString();
        this.on_off = parcel.readString();
        this.display_format = parcel.readString();
        this.tag = parcel.readString();
        this.prod_tag = parcel.readString();
        this.ui_type = parcel.readInt();
        this.button_shimmer_times = parcel.readInt();
        this.home_page_type = parcel.readString();
        this.user_guide_type = parcel.readString();
        this.frequency_capping = parcel.readString();
        this.install_broadcast_to = parcel.createStringArrayList();
        this.local_push = parcel.readString();
        this.server_push = parcel.readString();
        this.home_upperright_bt_entry = parcel.readString();
        this.square_upperright_bt_entry = parcel.readString();
        this.edit_result_upperright_bt_entry = parcel.readString();
        this.is_collect_process = parcel.readInt();
        this.open_key = parcel.createStringArrayList();
        this.getadInterval = parcel.readLong();
        this.pullTimeout = parcel.readLong();
        this.waterfall = parcel.createTypedArrayList(AdsItem.CREATOR);
        this.update = parcel.readString();
        this.plan = parcel.readString();
        this.interstitialInterval = parcel.readInt();
        this.realTimeLoad = parcel.readLong();
        this.waitTime = parcel.readLong();
        this.uiStyle = parcel.readString();
        this.displayDuration = parcel.readInt();
    }
}

package us.pinguo.admobvista.StaticsAdv;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import us.pinguo.advconfigdata.DispatcherData.AdvDataKeeper;
import us.pinguo.advconfigdata.Utils.AdvConstants;
import us.pinguo.advconfigdata.database.AdvItem;
/* loaded from: classes3.dex */
public class AdvItemStatistic extends IADStatisticBase {
    AdvItem mAdvItem;
    String mPage;
    String mPos;
    String mUnitId;
    boolean mbFunctionArea;

    public AdvItemStatistic(Context context, String str, String str2, boolean z, String str3) {
        super(context);
        this.mPos = str2;
        this.mPage = str;
        this.mbFunctionArea = z;
        this.mUnitId = str3;
    }

    @Override // us.pinguo.admobvista.StaticsAdv.IADStatisticBase
    public String ClickStatistics(String str) {
        AdvItem advItem = this.mAdvItem;
        if (advItem != null) {
            advItem.exePvTaskClick();
        }
        return super.ClickStatistics(str);
    }

    @Override // us.pinguo.admobvista.StaticsAdv.IADStatisticBase
    public String getADPos() {
        return this.mPos;
    }

    @Override // us.pinguo.admobvista.StaticsAdv.IADStatisticBase
    public String getAdCategory() {
        AdvItem advItem = this.mAdvItem;
        return advItem == null ? IADStatisticBase.VARCHAR_DEFALUT_VALUE : advItem.tag;
    }

    @Override // us.pinguo.admobvista.StaticsAdv.IADStatisticBase
    public String getAdDescription() {
        AdvItem advItem = this.mAdvItem;
        return advItem == null ? IADStatisticBase.VARCHAR_DEFALUT_VALUE : advItem.desc;
    }

    @Override // us.pinguo.admobvista.StaticsAdv.IADStatisticBase
    public String getAdId() {
        return getOfferid();
    }

    @Override // us.pinguo.admobvista.StaticsAdv.IADStatisticBase
    public String getAdvertiser() {
        AdvItem advItem = this.mAdvItem;
        return advItem == null ? IADStatisticBase.VARCHAR_DEFALUT_VALUE : advItem.advertiser;
    }

    @Override // us.pinguo.admobvista.StaticsAdv.IADStatisticBase
    public String getBid() {
        return String.valueOf(-1);
    }

    @Override // us.pinguo.admobvista.StaticsAdv.IADStatisticBase
    public String getChargeMode() {
        return IADStatisticBase.VARCHAR_DEFALUT_VALUE;
    }

    @Override // us.pinguo.admobvista.StaticsAdv.IADStatisticBase
    public String getConvType() {
        return IADStatisticBase.VARCHAR_DEFALUT_VALUE;
    }

    @Override // us.pinguo.admobvista.StaticsAdv.IADStatisticBase
    public String getCreativeAuthor() {
        return IADStatisticBase.VARCHAR_DEFALUT_VALUE;
    }

    @Override // us.pinguo.admobvista.StaticsAdv.IADStatisticBase
    public String getCtaText() {
        AdvItem advItem = this.mAdvItem;
        return (advItem == null || TextUtils.isEmpty(advItem.btnText)) ? IADStatisticBase.VARCHAR_DEFALUT_VALUE : this.mAdvItem.btnText;
    }

    @Override // us.pinguo.admobvista.StaticsAdv.IADStatisticBase
    public String getDeliverType() {
        int i2;
        AdvItem advItem = this.mAdvItem;
        if (advItem == null) {
            return IADStatisticBase.VARCHAR_DEFALUT_VALUE;
        }
        if ("appwall".equals(advItem.advType) && (1 == (i2 = this.mAdvItem.advProvider) || 8 == i2)) {
            return IADStatisticBase.DELIVER_TYPE_THIRD_SDK;
        }
        return IADStatisticBase.DELIVER_TYPE_BRAND;
    }

    @Override // us.pinguo.admobvista.StaticsAdv.IADStatisticBase
    public String getDisplayType() {
        AdvItem advItem = this.mAdvItem;
        if (advItem == null) {
            return IADStatisticBase.VARCHAR_DEFALUT_VALUE;
        }
        if ("appwall".equals(advItem.advType)) {
            if (TextUtils.isEmpty(this.mAdvItem.interactionUri)) {
                return IADStatisticBase.DISPLAY_TYPE_APPWALL;
            }
            return IADStatisticBase.DISPLAY_TYPE_H5_NON_WAPPWALL;
        } else if (this.mbFunctionArea) {
            return IADStatisticBase.DISPLAY_TYPE_RECTANGLE;
        } else {
            if (IADStatisticBase.PAGE_STARTUP.equals(getPage())) {
                return IADStatisticBase.DISPLAY_TYPE_FULL_SCREEN;
            }
            return IADStatisticBase.DISPLAY_TYPE_LARGE_CARD;
        }
    }

    @Override // us.pinguo.admobvista.StaticsAdv.IADStatisticBase
    public String getExpTag() {
        return IADStatisticBase.VARCHAR_DEFALUT_VALUE;
    }

    @Override // us.pinguo.admobvista.StaticsAdv.IADStatisticBase
    public String getFinalSourceType() {
        return IADStatisticBase.VARCHAR_DEFALUT_VALUE;
    }

    @Override // us.pinguo.admobvista.StaticsAdv.IADStatisticBase
    public String getIconUrl() {
        AdvItem advItem = this.mAdvItem;
        return advItem == null ? IADStatisticBase.VARCHAR_DEFALUT_VALUE : advItem.iconUrl;
    }

    @Override // us.pinguo.admobvista.StaticsAdv.IADStatisticBase
    public String getImageUrl() {
        AdvItem advItem = this.mAdvItem;
        return advItem == null ? IADStatisticBase.VARCHAR_DEFALUT_VALUE : advItem.imageUrl;
    }

    @Override // us.pinguo.admobvista.StaticsAdv.IADStatisticBase
    public String getMediaType() {
        AdvItem advItem = this.mAdvItem;
        if (advItem == null) {
            return IADStatisticBase.VARCHAR_DEFALUT_VALUE;
        }
        ArrayList<AdvDataKeeper.ImageData> arrayList = advItem.mImageList;
        if (arrayList != null && arrayList.size() != 1) {
            return IADStatisticBase.MEDIA_TYPE_MULTI;
        }
        return IADStatisticBase.MEDIA_TYPE_SINGLE;
    }

    @Override // us.pinguo.admobvista.StaticsAdv.IADStatisticBase
    public String getOfferid() {
        if (this.mAdvItem == null) {
            return IADStatisticBase.VARCHAR_DEFALUT_VALUE;
        }
        return getSrcType() + "_" + this.mAdvItem.advId;
    }

    @Override // us.pinguo.admobvista.StaticsAdv.IADStatisticBase
    public String getPage() {
        return this.mPage;
    }

    @Override // us.pinguo.admobvista.StaticsAdv.IADStatisticBase
    public String getPlacementId() {
        if ("appwall".equals(this.mAdvItem.advType)) {
            int i2 = this.mAdvItem.advProvider;
            if (1 == i2) {
                return "mobvista_" + this.mAdvItem.mvId;
            } else if (8 == i2) {
                return "yeahmobi_" + this.mAdvItem.sdkId;
            } else {
                return IADStatisticBase.VARCHAR_DEFALUT_VALUE;
            }
        }
        return IADStatisticBase.VARCHAR_DEFALUT_VALUE;
    }

    @Override // us.pinguo.admobvista.StaticsAdv.IADStatisticBase
    public String getPrice() {
        return String.valueOf(-1);
    }

    @Override // us.pinguo.admobvista.StaticsAdv.IADStatisticBase
    public int getRank() {
        return this.mRank;
    }

    @Override // us.pinguo.admobvista.StaticsAdv.IADStatisticBase
    public String getShowTime() {
        return IADStatisticBase.VARCHAR_DEFALUT_VALUE;
    }

    @Override // us.pinguo.admobvista.StaticsAdv.IADStatisticBase
    public String getSrcType() {
        AdvItem advItem = this.mAdvItem;
        if (advItem == null) {
            return IADStatisticBase.SOURCE_TYPE_BRAND;
        }
        if ("appwall".equals(advItem.advType)) {
            int i2 = this.mAdvItem.advProvider;
            if (1 == i2) {
                return IADStatisticBase.SOURCE_TYPE_MV;
            }
            if (8 == i2) {
                return IADStatisticBase.SOURCE_TYPE_YM;
            }
            return IADStatisticBase.SOURCE_TYPE_BRAND;
        }
        return this.mAdvItem.advType;
    }

    @Override // us.pinguo.admobvista.StaticsAdv.IADStatisticBase
    public String getTitle() {
        AdvItem advItem = this.mAdvItem;
        return advItem == null ? IADStatisticBase.VARCHAR_DEFALUT_VALUE : advItem.content;
    }

    @Override // us.pinguo.admobvista.StaticsAdv.IADStatisticBase
    public String getUnitId() {
        return this.mUnitId;
    }

    @Override // us.pinguo.admobvista.StaticsAdv.IADStatisticBase
    public String getloadTime() {
        return IADStatisticBase.VARCHAR_DEFALUT_VALUE;
    }

    @Override // us.pinguo.admobvista.StaticsAdv.IADStatisticBase
    public boolean isIncent() {
        AdvItem advItem = this.mAdvItem;
        return advItem != null && advItem.incent == 1;
    }

    @Override // us.pinguo.admobvista.StaticsAdv.IADStatisticBase
    public boolean isUpload() {
        AdvItem advItem = this.mAdvItem;
        if (advItem == null || TextUtils.isEmpty(advItem.advId) || TextUtils.isEmpty(this.mAdvItem.advType)) {
            return false;
        }
        return AdvConstants.ADV_TYPE_BRAND.equals(this.mAdvItem.advType) || "appwall".equals(this.mAdvItem.advType);
    }

    public void setAdvItem(AdvItem advItem) {
        this.mAdvItem = advItem;
    }

    public void setRank(int i2) {
        this.mRank = i2;
    }
}

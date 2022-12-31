package us.pinguo.admobvista.StaticsAdv;

import android.content.Context;
import android.text.TextUtils;
import java.util.List;
import us.pinguo.admobvista.DataBean.InputAdvItem;
import us.pinguo.admobvista.DataBean.InputContentAdvData;
import us.pinguo.admobvista.DataBean.InputContentAdvDataIconData;
import us.pinguo.admobvista.DataBean.InputContentAdvDataImageData;
import us.pinguo.advconfigdata.Utils.AdvConstants;
/* loaded from: classes3.dex */
public class AdvInputAdvItemStatistic extends IADStatisticBase {
    InputAdvItem mAdvItem;
    String mPage;
    String mPos;
    String mUnitId;

    public AdvInputAdvItemStatistic(Context context, String str, String str2, String str3) {
        super(context);
        this.mPos = str2;
        this.mPage = str;
        this.mUnitId = str3;
    }

    @Override // us.pinguo.admobvista.StaticsAdv.IADStatisticBase
    public String getADPos() {
        return this.mPos;
    }

    @Override // us.pinguo.admobvista.StaticsAdv.IADStatisticBase
    public String getAdCategory() {
        InputAdvItem inputAdvItem = this.mAdvItem;
        return inputAdvItem == null ? IADStatisticBase.VARCHAR_DEFALUT_VALUE : inputAdvItem.advData.tag;
    }

    @Override // us.pinguo.admobvista.StaticsAdv.IADStatisticBase
    public String getAdDescription() {
        InputAdvItem inputAdvItem = this.mAdvItem;
        return inputAdvItem == null ? IADStatisticBase.VARCHAR_DEFALUT_VALUE : inputAdvItem.advData.desc;
    }

    @Override // us.pinguo.admobvista.StaticsAdv.IADStatisticBase
    public String getAdId() {
        return getOfferid();
    }

    @Override // us.pinguo.admobvista.StaticsAdv.IADStatisticBase
    public String getAdvertiser() {
        InputAdvItem inputAdvItem = this.mAdvItem;
        return inputAdvItem == null ? IADStatisticBase.VARCHAR_DEFALUT_VALUE : inputAdvItem.advData.advertiser;
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
        return "self";
    }

    @Override // us.pinguo.admobvista.StaticsAdv.IADStatisticBase
    public String getCtaText() {
        InputContentAdvData inputContentAdvData;
        InputAdvItem inputAdvItem = this.mAdvItem;
        return (inputAdvItem == null || (inputContentAdvData = inputAdvItem.advData) == null || TextUtils.isEmpty(inputContentAdvData.btnText)) ? IADStatisticBase.VARCHAR_DEFALUT_VALUE : this.mAdvItem.advData.btnText;
    }

    @Override // us.pinguo.admobvista.StaticsAdv.IADStatisticBase
    public String getDeliverType() {
        return IADStatisticBase.DELIVER_TYPE_BRAND;
    }

    @Override // us.pinguo.admobvista.StaticsAdv.IADStatisticBase
    public String getDisplayType() {
        return IADStatisticBase.DISPLAY_TYPE_FEEDS;
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
        InputContentAdvData inputContentAdvData;
        List<InputContentAdvDataIconData> list;
        InputAdvItem inputAdvItem = this.mAdvItem;
        return (inputAdvItem == null || (inputContentAdvData = inputAdvItem.advData) == null || (list = inputContentAdvData.iconData) == null) ? IADStatisticBase.VARCHAR_DEFALUT_VALUE : list.get(0).imageUrl;
    }

    @Override // us.pinguo.admobvista.StaticsAdv.IADStatisticBase
    public String getImageUrl() {
        InputContentAdvData inputContentAdvData;
        List<InputContentAdvDataImageData> list;
        InputAdvItem inputAdvItem = this.mAdvItem;
        return (inputAdvItem == null || (inputContentAdvData = inputAdvItem.advData) == null || (list = inputContentAdvData.imageData) == null) ? IADStatisticBase.VARCHAR_DEFALUT_VALUE : list.get(0).imageUrl;
    }

    @Override // us.pinguo.admobvista.StaticsAdv.IADStatisticBase
    public String getMediaType() {
        InputAdvItem inputAdvItem = this.mAdvItem;
        if (inputAdvItem == null) {
            return IADStatisticBase.VARCHAR_DEFALUT_VALUE;
        }
        if (InputContentAdvData.TYPE_VIDEO.equals(inputAdvItem.advData.dataType)) {
            return IADStatisticBase.MEDIA_TYPE_VIDEO;
        }
        List<InputContentAdvDataImageData> list = this.mAdvItem.advData.imageData;
        if (list != null && list.size() > 1) {
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
        return IADStatisticBase.SOURCE_TYPE_BRAND;
    }

    @Override // us.pinguo.admobvista.StaticsAdv.IADStatisticBase
    public String getTitle() {
        InputAdvItem inputAdvItem = this.mAdvItem;
        return inputAdvItem == null ? IADStatisticBase.VARCHAR_DEFALUT_VALUE : inputAdvItem.advData.content;
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
        InputAdvItem inputAdvItem = this.mAdvItem;
        return inputAdvItem != null && inputAdvItem.advData.incent == 1;
    }

    @Override // us.pinguo.admobvista.StaticsAdv.IADStatisticBase
    public boolean isUpload() {
        InputAdvItem inputAdvItem = this.mAdvItem;
        return (inputAdvItem == null || TextUtils.isEmpty(inputAdvItem.advId) || TextUtils.isEmpty(this.mAdvItem.advType) || !AdvConstants.ADV_TYPE_BRAND.equals(this.mAdvItem.advType)) ? false : true;
    }

    public void setAdvItem(InputAdvItem inputAdvItem) {
        this.mAdvItem = inputAdvItem;
    }

    public void setRank(int i2) {
        this.mRank = i2;
    }
}

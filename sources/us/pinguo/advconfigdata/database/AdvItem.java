package us.pinguo.advconfigdata.database;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import us.pinguo.advconfigdata.AdvAddition.AdvPVTask;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.advconfigdata.AdvThird.AdvThirdItemListener;
import us.pinguo.advconfigdata.DispatcherData.AdvDataKeeper;
import us.pinguo.advconfigdata.Utils.AdvConstants;
/* loaded from: classes3.dex */
public class AdvItem implements Parcelable {
    public static final Parcelable.Creator<AdvItem> CREATOR = new a();
    public long activeTime;
    public String additionInfo;
    public String admId;
    public String advId;
    public int advProvider;
    public String advType;
    public String advertiser;
    public int afterCameraPopNum;
    public int allowIgnore;
    public String at;
    public String bgColor;
    public String bgColor1;
    public int bgType;
    public String bottomLeftIconBgColor;
    public String bottomLeftIconBgUrl;
    public String bottomLeftIconTextColor;
    public String bottomLeftIconUrl;
    public String bottomLeftType;
    public String bottomRightIconBgColor;
    public String bottomRightIconBgUrl;
    public String bottomRightIconTextColor;
    public String bottomRightIconUrl;
    public String bottomRightType;
    public String btnColor;
    public String btnText;
    public int btnType;
    public String btnclickUri;
    public String content;
    public int contentType;
    public String copyright;
    public int dayCount;
    public String desc;
    public int displayCount;
    public String downloadedFilePath;
    public String downloadedIconPath;
    public String dspCallUrl;
    public double duration;
    public int entryPos;
    public long expireTime;
    public AdvDataKeeper.d extraField;
    public String fbId;
    public String filterId;
    public String filterinfo;
    public String fontColor;
    public boolean forceInnerBrowser;
    public boolean forceSingle;
    public int gifShowCount;
    public String guid;
    public int guidType;
    public String headUrl;
    public String headclickUri;
    public String htmlSource;
    public int iconType;
    public String iconUrl;
    public int imageHeight;
    public String imageUrl;
    public int imageWidth;
    public int imgDefault;
    public String inSpireClickText;
    public String inSpireDesc;
    public int inSpireIndex;
    public int incent;
    public int index;
    public String interactionUri;
    public int logoColor;
    public ArrayList<String> mClicks;
    public ArrayList<AdvDataKeeper.ImageData> mIconList;
    public ArrayList<String> mIconLocalPath;
    public ArrayList<AdvDataKeeper.ImageData> mImageList;
    public ArrayList<String> mImageLocalPath;
    public ArrayList<String> mImpressions;
    public ArrayList<AdvDataKeeper.VideoData> mVideoList;
    public String mVideoUrl;
    public String makeupId;
    public String materialType;
    public long metaInterval;
    public String mvId;
    public String name;
    public int newAddToday;
    public boolean nonWifiPicPreload;
    public int opacity;
    public String popBtnText;
    public String popContent;
    public String popPosition;
    public String popTitle;
    public double priority;
    public String publisher;
    public String recommendDownUrl;
    public String recommendPackageName;
    public String recommendSoftwareName;
    public int recommendType;
    public String resGid;
    public String resId;
    public int resType;
    public String resUrl;
    public int screenType;
    public String sdkId;
    public String sdkPlacementId;
    public String sdkPlan;
    public String shareConfig;
    public int showContent;
    public int showIcon;
    public int showImage;
    public boolean showSingle;
    public int startupBtnPos;
    public String stickerId;
    public String tag;
    public String taskConfig;
    public String templateId;
    public String titleColor;
    public String topNavLogoImg;
    public String topNavMenuImg;
    public String topNavVipImg;
    public String unionAdsFlag;
    public int usePop;
    public JSONArray vipStatusArray;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<AdvItem> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AdvItem createFromParcel(Parcel parcel) {
            return new AdvItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public AdvItem[] newArray(int i2) {
            return new AdvItem[i2];
        }
    }

    public AdvItem() {
        this.logoColor = 0;
        this.displayCount = -1;
        this.nonWifiPicPreload = false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void exePvTaskClick() {
        ArrayList<String> arrayList = this.mClicks;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        new AdvPVTask().execute(this.mClicks);
    }

    public void exePvTaskShow() {
        ArrayList<String> arrayList = this.mImpressions;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        new AdvPVTask().execute(this.mImpressions);
    }

    public String getPopContent() {
        return this.popContent;
    }

    public String getPopImageUrl() {
        return this.iconUrl;
    }

    public boolean isJump() {
        return this.usePop == 1;
    }

    public void loadThirdAdv(AdvThirdItemListener advThirdItemListener) {
        loadThirdAdv(advThirdItemListener, false);
    }

    public boolean needLoadThirdAdv() {
        return AdvConstants.ADV_TYPE_DSP.equals(this.advType) && !TextUtils.isEmpty(this.dspCallUrl);
    }

    public String toString() {
        return "AdvItem{guid='" + this.guid + "', advId='" + this.advId + "', name='" + this.name + "', guidType=" + this.guidType + ", imageUrl='" + this.imageUrl + "', imageWidth=" + this.imageWidth + ", imageHeight=" + this.imageHeight + ", imgDefault=" + this.imgDefault + ", copyright='" + this.copyright + "', iconUrl='" + this.iconUrl + "', content='" + this.content + "', desc='" + this.desc + "', fontColor='" + this.fontColor + "', btnColor='" + this.btnColor + "', btnText='" + this.btnText + "', logoColor=" + this.logoColor + ", bgColor='" + this.bgColor + "', opacity=" + this.opacity + ", recommendType=" + this.recommendType + ", downloadedFilePath='" + this.downloadedFilePath + "', downloadedIconPath='" + this.downloadedIconPath + "', interactionUri='" + this.interactionUri + "', forceInnerBrowser=" + this.forceInnerBrowser + ", duration=" + this.duration + ", metaInterval=" + this.metaInterval + ", recommendPackageName='" + this.recommendPackageName + "', recommendSoftwareName='" + this.recommendSoftwareName + "', recommendDownUrl='" + this.recommendDownUrl + "', inSpireIndex=" + this.inSpireIndex + ", inSpireDesc='" + this.inSpireDesc + "', inSpireClickText='" + this.inSpireClickText + "', popTitle='" + this.popTitle + "', popContent='" + this.popContent + "', popBtnText='" + this.popBtnText + "', popPosition='" + this.popPosition + "', screenType=" + this.screenType + ", additionInfo='" + this.additionInfo + "', sdkPlan='" + this.sdkPlan + "', sdkPlacementId='" + this.sdkPlacementId + "', advType='" + this.advType + "', admId='" + this.admId + "', fbId='" + this.fbId + "', mvId='" + this.mvId + "', headclickUri='" + this.headclickUri + "', btnclickUri='" + this.btnclickUri + "', headUrl='" + this.headUrl + "', publisher='" + this.publisher + "', at='" + this.at + "', sdkId='" + this.sdkId + "', index=" + this.index + ", activeTime=" + this.activeTime + ", expireTime=" + this.expireTime + ", priority=" + this.priority + ", displayCount=" + this.displayCount + ", showSingle=" + this.showSingle + ", forceSingle=" + this.forceSingle + ", nonWifiPicPreload=" + this.nonWifiPicPreload + ", taskConfig='" + this.taskConfig + "', usePop=" + this.usePop + ", startupBtnPos=" + this.startupBtnPos + ", allowIgnore=" + this.allowIgnore + ", gifShowCount=" + this.gifShowCount + ", templateId='" + this.templateId + "', mImageList=" + this.mImageList + ", filterinfo='" + this.filterinfo + "', advProvider=" + this.advProvider + ", mImpressions=" + this.mImpressions + ", mClicks=" + this.mClicks + ", showContent=" + this.showContent + ", showIcon=" + this.showIcon + ", showImage=" + this.showImage + ", mIconList=" + this.mIconList + ", mVideoList=" + this.mVideoList + ", mVideoUrl='" + this.mVideoUrl + "', mIconLocalPath=" + this.mIconLocalPath + ", mImageLocalPath=" + this.mImageLocalPath + ", tag='" + this.tag + "', advertiser='" + this.advertiser + "', incent=" + this.incent + ", resId='" + this.resId + "', resUrl='" + this.resUrl + "', resGid='" + this.resGid + "', resType=" + this.resType + ", entryPos=" + this.entryPos + ", bgType=" + this.bgType + ", iconType=" + this.iconType + ", dayCount=" + this.dayCount + ", bgColor1='" + this.bgColor1 + "', dspCallUrl='" + this.dspCallUrl + "', stickerId='" + this.stickerId + "', btnType=" + this.btnType + ", shareConfig='" + this.shareConfig + "', materialType=" + this.materialType + ", filterId='" + this.filterId + "', makeupId='" + this.makeupId + "', htmlSource='" + this.htmlSource + "', extraField='" + this.extraField + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.guid);
        parcel.writeString(this.advId);
        parcel.writeString(this.name);
        parcel.writeInt(this.guidType);
        parcel.writeString(this.imageUrl);
        parcel.writeInt(this.imageWidth);
        parcel.writeInt(this.imageHeight);
        parcel.writeInt(this.imgDefault);
        parcel.writeString(this.copyright);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.content);
        parcel.writeString(this.desc);
        parcel.writeString(this.fontColor);
        parcel.writeString(this.btnColor);
        parcel.writeString(this.btnText);
        parcel.writeInt(this.logoColor);
        parcel.writeString(this.bgColor);
        parcel.writeInt(this.opacity);
        parcel.writeInt(this.recommendType);
        parcel.writeString(this.downloadedFilePath);
        parcel.writeString(this.downloadedIconPath);
        parcel.writeString(this.interactionUri);
        parcel.writeByte(this.forceInnerBrowser ? (byte) 1 : (byte) 0);
        parcel.writeDouble(this.duration);
        parcel.writeLong(this.metaInterval);
        parcel.writeString(this.recommendPackageName);
        parcel.writeString(this.recommendSoftwareName);
        parcel.writeString(this.recommendDownUrl);
        parcel.writeInt(this.inSpireIndex);
        parcel.writeString(this.inSpireDesc);
        parcel.writeString(this.inSpireClickText);
        parcel.writeString(this.popTitle);
        parcel.writeString(this.popContent);
        parcel.writeString(this.popBtnText);
        parcel.writeString(this.popPosition);
        parcel.writeInt(this.screenType);
        parcel.writeString(this.additionInfo);
        parcel.writeString(this.sdkPlan);
        parcel.writeString(this.sdkPlacementId);
        parcel.writeString(this.advType);
        parcel.writeString(this.admId);
        parcel.writeString(this.fbId);
        parcel.writeString(this.mvId);
        parcel.writeString(this.headclickUri);
        parcel.writeString(this.btnclickUri);
        parcel.writeString(this.headUrl);
        parcel.writeString(this.publisher);
        parcel.writeString(this.at);
        parcel.writeString(this.sdkId);
        parcel.writeInt(this.index);
        parcel.writeLong(this.activeTime);
        parcel.writeLong(this.expireTime);
        parcel.writeDouble(this.priority);
        parcel.writeInt(this.displayCount);
        parcel.writeByte(this.showSingle ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.forceSingle ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.nonWifiPicPreload ? (byte) 1 : (byte) 0);
        parcel.writeString(this.taskConfig);
        parcel.writeInt(this.usePop);
        parcel.writeInt(this.startupBtnPos);
        parcel.writeInt(this.allowIgnore);
        parcel.writeInt(this.gifShowCount);
        parcel.writeString(this.templateId);
        parcel.writeList(this.mImageList);
        parcel.writeString(this.filterinfo);
        parcel.writeInt(this.advProvider);
        parcel.writeStringList(this.mImpressions);
        parcel.writeStringList(this.mClicks);
        parcel.writeInt(this.showContent);
        parcel.writeInt(this.showIcon);
        parcel.writeInt(this.showImage);
        parcel.writeList(this.mIconList);
        parcel.writeList(this.mVideoList);
        parcel.writeString(this.mVideoUrl);
        parcel.writeStringList(this.mIconLocalPath);
        parcel.writeStringList(this.mImageLocalPath);
        parcel.writeString(this.tag);
        parcel.writeString(this.advertiser);
        parcel.writeInt(this.incent);
        parcel.writeString(this.resId);
        parcel.writeString(this.resUrl);
        parcel.writeString(this.resGid);
        parcel.writeInt(this.resType);
        parcel.writeInt(this.entryPos);
        parcel.writeInt(this.bgType);
        parcel.writeInt(this.iconType);
        parcel.writeInt(this.dayCount);
        parcel.writeInt(this.contentType);
        parcel.writeString(this.bgColor1);
        parcel.writeString(this.dspCallUrl);
        parcel.writeString(this.stickerId);
        parcel.writeInt(this.btnType);
        parcel.writeString(this.shareConfig);
        parcel.writeString(this.materialType);
        parcel.writeString(this.filterId);
        parcel.writeString(this.makeupId);
        parcel.writeString(this.htmlSource);
    }

    public void loadThirdAdv(AdvThirdItemListener advThirdItemListener, boolean z) {
        if (!TextUtils.isEmpty(this.dspCallUrl)) {
            AdvConfigManager.getInstance().loadThirdAdv(this.guid, this.dspCallUrl, advThirdItemListener, z);
        } else if (advThirdItemListener != null) {
            advThirdItemListener.onAdvFailed();
        }
    }

    protected AdvItem(Parcel parcel) {
        this.logoColor = 0;
        this.displayCount = -1;
        this.nonWifiPicPreload = false;
        this.guid = parcel.readString();
        this.advId = parcel.readString();
        this.name = parcel.readString();
        this.guidType = parcel.readInt();
        this.imageUrl = parcel.readString();
        this.imageWidth = parcel.readInt();
        this.imageHeight = parcel.readInt();
        this.imgDefault = parcel.readInt();
        this.copyright = parcel.readString();
        this.iconUrl = parcel.readString();
        this.content = parcel.readString();
        this.desc = parcel.readString();
        this.fontColor = parcel.readString();
        this.btnColor = parcel.readString();
        this.btnText = parcel.readString();
        this.logoColor = parcel.readInt();
        this.bgColor = parcel.readString();
        this.opacity = parcel.readInt();
        this.recommendType = parcel.readInt();
        this.downloadedFilePath = parcel.readString();
        this.downloadedIconPath = parcel.readString();
        this.interactionUri = parcel.readString();
        this.forceInnerBrowser = parcel.readByte() != 0;
        this.duration = parcel.readDouble();
        this.metaInterval = parcel.readLong();
        this.recommendPackageName = parcel.readString();
        this.recommendSoftwareName = parcel.readString();
        this.recommendDownUrl = parcel.readString();
        this.inSpireIndex = parcel.readInt();
        this.inSpireDesc = parcel.readString();
        this.inSpireClickText = parcel.readString();
        this.popTitle = parcel.readString();
        this.popContent = parcel.readString();
        this.popBtnText = parcel.readString();
        this.popPosition = parcel.readString();
        this.screenType = parcel.readInt();
        this.additionInfo = parcel.readString();
        this.sdkPlan = parcel.readString();
        this.sdkPlacementId = parcel.readString();
        this.advType = parcel.readString();
        this.admId = parcel.readString();
        this.fbId = parcel.readString();
        this.mvId = parcel.readString();
        this.headclickUri = parcel.readString();
        this.btnclickUri = parcel.readString();
        this.headUrl = parcel.readString();
        this.publisher = parcel.readString();
        this.at = parcel.readString();
        this.sdkId = parcel.readString();
        this.index = parcel.readInt();
        this.activeTime = parcel.readLong();
        this.expireTime = parcel.readLong();
        this.priority = parcel.readDouble();
        this.displayCount = parcel.readInt();
        this.showSingle = parcel.readByte() != 0;
        this.forceSingle = parcel.readByte() != 0;
        this.nonWifiPicPreload = parcel.readByte() != 0;
        this.taskConfig = parcel.readString();
        this.usePop = parcel.readInt();
        this.startupBtnPos = parcel.readInt();
        this.allowIgnore = parcel.readInt();
        this.gifShowCount = parcel.readInt();
        this.templateId = parcel.readString();
        ArrayList<AdvDataKeeper.ImageData> arrayList = new ArrayList<>();
        this.mImageList = arrayList;
        parcel.readList(arrayList, AdvDataKeeper.ImageData.class.getClassLoader());
        this.filterinfo = parcel.readString();
        this.advProvider = parcel.readInt();
        this.mImpressions = parcel.createStringArrayList();
        this.mClicks = parcel.createStringArrayList();
        this.showContent = parcel.readInt();
        this.showIcon = parcel.readInt();
        this.showImage = parcel.readInt();
        ArrayList<AdvDataKeeper.ImageData> arrayList2 = new ArrayList<>();
        this.mIconList = arrayList2;
        parcel.readList(arrayList2, AdvDataKeeper.ImageData.class.getClassLoader());
        ArrayList<AdvDataKeeper.VideoData> arrayList3 = new ArrayList<>();
        this.mVideoList = arrayList3;
        parcel.readList(arrayList3, AdvDataKeeper.VideoData.class.getClassLoader());
        this.mVideoUrl = parcel.readString();
        this.mIconLocalPath = parcel.createStringArrayList();
        this.mImageLocalPath = parcel.createStringArrayList();
        this.tag = parcel.readString();
        this.advertiser = parcel.readString();
        this.incent = parcel.readInt();
        this.resId = parcel.readString();
        this.resUrl = parcel.readString();
        this.resGid = parcel.readString();
        this.resType = parcel.readInt();
        this.entryPos = parcel.readInt();
        this.bgType = parcel.readInt();
        this.iconType = parcel.readInt();
        this.dayCount = parcel.readInt();
        this.contentType = parcel.readInt();
        this.bgColor1 = parcel.readString();
        this.dspCallUrl = parcel.readString();
        this.stickerId = parcel.readString();
        this.btnType = parcel.readInt();
        this.shareConfig = parcel.readString();
        this.materialType = parcel.readString();
        this.filterId = parcel.readString();
        this.makeupId = parcel.readString();
        this.htmlSource = parcel.readString();
    }
}

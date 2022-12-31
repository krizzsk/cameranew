package us.pinguo.advsdk.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
/* loaded from: classes3.dex */
public class AdsItem extends BaseBean {
    public static final Parcelable.Creator<AdsItem> CREATOR = new a();
    public boolean bLocal;
    public ButtonBean button;
    public int cacheTime;
    public List<String> click;
    public String clickUrl;
    public String content;
    public String contentType;
    public List<String> deep;
    public String deliverType;
    public String desc;
    public String displayFormat;
    public String iconUrl;
    public ImageBean image;
    public List<String> impression;
    public String landingUrl;
    public int loadSDK;
    public int mask;
    public List<String> notice;
    public String offerId;
    public String placementId;
    public int rotating;
    public String source;
    public String stat;
    public int templateId;
    public String title;
    public VideoBean video;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<AdsItem> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AdsItem createFromParcel(Parcel parcel) {
            return new AdsItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public AdsItem[] newArray(int i2) {
            return new AdsItem[i2];
        }
    }

    public AdsItem() {
    }

    public String a() {
        return String.valueOf(this.loadSDK) + this.placementId + this.offerId;
    }

    public String b() {
        return this.loadSDK + "";
    }

    public boolean c() {
        int i2 = this.loadSDK;
        return i2 == 0 || i2 == 6;
    }

    @Override // us.pinguo.advsdk.bean.BaseBean, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean f() {
        return "interstitial".equalsIgnoreCase(this.displayFormat) || "interstitial_appwall".equalsIgnoreCase(this.displayFormat) || "interstitial_video".equalsIgnoreCase(this.displayFormat);
    }

    @Override // us.pinguo.advsdk.bean.BaseBean, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeInt(this.loadSDK);
        parcel.writeString(this.displayFormat);
        parcel.writeString(this.placementId);
        parcel.writeString(this.offerId);
        parcel.writeInt(this.templateId);
        parcel.writeString(this.title);
        parcel.writeString(this.desc);
        parcel.writeString(this.landingUrl);
        parcel.writeString(this.clickUrl);
        parcel.writeParcelable(this.image, i2);
        parcel.writeParcelable(this.video, i2);
        parcel.writeStringList(this.impression);
        parcel.writeStringList(this.click);
        parcel.writeStringList(this.notice);
        parcel.writeStringList(this.deep);
        parcel.writeParcelable(this.button, i2);
        parcel.writeString(this.stat);
        parcel.writeString(this.source);
        parcel.writeString(this.iconUrl);
        parcel.writeInt(this.mask);
        parcel.writeInt(this.rotating);
        parcel.writeString(this.deliverType);
        parcel.writeByte(this.bLocal ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.cacheTime);
        parcel.writeString(this.content);
        parcel.writeString(this.contentType);
    }

    protected AdsItem(Parcel parcel) {
        super(parcel);
        this.loadSDK = parcel.readInt();
        this.displayFormat = parcel.readString();
        this.placementId = parcel.readString();
        this.offerId = parcel.readString();
        this.templateId = parcel.readInt();
        this.title = parcel.readString();
        this.desc = parcel.readString();
        this.landingUrl = parcel.readString();
        this.clickUrl = parcel.readString();
        this.image = (ImageBean) parcel.readParcelable(ImageBean.class.getClassLoader());
        this.video = (VideoBean) parcel.readParcelable(VideoBean.class.getClassLoader());
        this.impression = parcel.createStringArrayList();
        this.click = parcel.createStringArrayList();
        this.notice = parcel.createStringArrayList();
        this.deep = parcel.createStringArrayList();
        this.button = (ButtonBean) parcel.readParcelable(ButtonBean.class.getClassLoader());
        this.stat = parcel.readString();
        this.source = parcel.readString();
        this.iconUrl = parcel.readString();
        this.mask = parcel.readInt();
        this.rotating = parcel.readInt();
        this.deliverType = parcel.readString();
        this.bLocal = parcel.readByte() != 0;
        this.cacheTime = parcel.readInt();
        this.content = parcel.readString();
        this.contentType = parcel.readString();
    }
}

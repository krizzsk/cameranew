package us.pinguo.admobvista.DataBean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
/* loaded from: classes3.dex */
public class InputContentAdvData implements Parcelable {
    public static final Parcelable.Creator<InputContentAdvData> CREATOR = new a();
    public static final String TYPE_MULTI_PHOTO = "adMulti";
    public static final String TYPE_SINGLE_PHOTO = "adPhoto";
    public static final String TYPE_VIDEO = "adVideo";
    public String admId;
    public String advertiser;
    public String at;
    public String btnClickUrl;
    public String btnText;
    public List<String> click;
    public String clickPackage;
    public String clickType;
    public String clickUrl;
    public String content;
    public String dataType;
    public String desc;
    public String dspCallUrl;
    public String fbId;
    public String headClickUrl;
    public String headUrl;
    public List<InputContentAdvDataIconData> iconData;
    public List<InputContentAdvDataImageData> imageData;
    public List<String> impression;
    public int incent;
    public String mvId;
    public int noTip;
    public String publisher;
    public int sdkAdvNumLimit;
    public String tag;
    public String templateId;
    public List<InputContentAdvDataVideoData> videoData;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<InputContentAdvData> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public InputContentAdvData createFromParcel(Parcel parcel) {
            return new InputContentAdvData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public InputContentAdvData[] newArray(int i2) {
            return new InputContentAdvData[i2];
        }
    }

    public InputContentAdvData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.admId);
        parcel.writeString(this.fbId);
        parcel.writeString(this.mvId);
        parcel.writeString(this.clickType);
        parcel.writeString(this.clickUrl);
        parcel.writeString(this.publisher);
        parcel.writeString(this.headUrl);
        parcel.writeString(this.headClickUrl);
        parcel.writeString(this.btnClickUrl);
        parcel.writeString(this.content);
        parcel.writeString(this.at);
        parcel.writeString(this.btnText);
        parcel.writeString(this.desc);
        parcel.writeString(this.dspCallUrl);
        parcel.writeInt(this.sdkAdvNumLimit);
        parcel.writeString(this.dataType);
        parcel.writeInt(this.noTip);
        parcel.writeString(this.clickPackage);
        parcel.writeString(this.templateId);
        parcel.writeTypedList(this.imageData);
        parcel.writeTypedList(this.iconData);
        parcel.writeTypedList(this.videoData);
        parcel.writeStringList(this.impression);
        parcel.writeStringList(this.click);
        parcel.writeString(this.tag);
        parcel.writeString(this.advertiser);
        parcel.writeInt(this.incent);
    }

    protected InputContentAdvData(Parcel parcel) {
        this.admId = parcel.readString();
        this.fbId = parcel.readString();
        this.mvId = parcel.readString();
        this.clickType = parcel.readString();
        this.clickUrl = parcel.readString();
        this.publisher = parcel.readString();
        this.headUrl = parcel.readString();
        this.headClickUrl = parcel.readString();
        this.btnClickUrl = parcel.readString();
        this.content = parcel.readString();
        this.at = parcel.readString();
        this.btnText = parcel.readString();
        this.desc = parcel.readString();
        this.dspCallUrl = parcel.readString();
        this.sdkAdvNumLimit = parcel.readInt();
        this.dataType = parcel.readString();
        this.noTip = parcel.readInt();
        this.clickPackage = parcel.readString();
        this.templateId = parcel.readString();
        this.imageData = parcel.createTypedArrayList(InputContentAdvDataImageData.CREATOR);
        this.iconData = parcel.createTypedArrayList(InputContentAdvDataIconData.CREATOR);
        this.videoData = parcel.createTypedArrayList(InputContentAdvDataVideoData.CREATOR);
        this.impression = parcel.createStringArrayList();
        this.click = parcel.createStringArrayList();
        this.tag = parcel.readString();
        this.advertiser = parcel.readString();
        this.incent = parcel.readInt();
    }
}

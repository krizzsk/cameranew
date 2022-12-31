package us.pinguo.advconfigdata.database;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
/* loaded from: classes3.dex */
public class AdvData implements Parcelable {
    public static final Parcelable.Creator<AdvData> CREATOR = new a();
    public List<IconData> IconData;
    public List<ImageData> ImageData;
    public String admId;
    public int allowIgnore;
    public int appWallPos;
    public String at;
    public String author;
    public String bgColor;
    public String button1Text;
    public String button2Text;
    public String clickPackage;
    public String clickType;
    public String clickUrl;
    public String content;
    public String copyright;
    public String desc;
    public int displayCount;
    public String downloadUrl;
    public float duration;
    public String fbId;
    public String fontColor;
    public String inSpireClickText;
    public String inSpireDesc;
    public int inSpireIndex;
    public int index;
    public int logoColor;
    public float metaInterval;
    public String mvId;
    public int noTip;
    public int nonWifiPicPreload;
    public float opacity;
    public String packageName;
    public String popBtnText;
    public String popContent;
    public String popPositon;
    public String popTitle;
    public String publisher;
    public int recommendType;
    public String scheme;
    public String softwareName;
    public int startupBtnPos;
    public String taskConfig;
    public String templateId;
    public int usePop;
    public int wifiShowBest;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<AdvData> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AdvData createFromParcel(Parcel parcel) {
            return new AdvData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public AdvData[] newArray(int i2) {
            return new AdvData[i2];
        }
    }

    public AdvData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.clickType);
        parcel.writeString(this.clickUrl);
        parcel.writeString(this.content);
        parcel.writeString(this.copyright);
        parcel.writeString(this.clickPackage);
        parcel.writeString(this.packageName);
        parcel.writeString(this.softwareName);
        parcel.writeString(this.downloadUrl);
        parcel.writeString(this.taskConfig);
        parcel.writeString(this.author);
        parcel.writeString(this.scheme);
        parcel.writeString(this.inSpireDesc);
        parcel.writeString(this.inSpireClickText);
        parcel.writeString(this.desc);
        parcel.writeString(this.button1Text);
        parcel.writeString(this.button2Text);
        parcel.writeString(this.fontColor);
        parcel.writeString(this.popTitle);
        parcel.writeString(this.popContent);
        parcel.writeString(this.popBtnText);
        parcel.writeString(this.popPositon);
        parcel.writeString(this.bgColor);
        parcel.writeInt(this.wifiShowBest);
        parcel.writeInt(this.displayCount);
        parcel.writeInt(this.recommendType);
        parcel.writeInt(this.inSpireIndex);
        parcel.writeInt(this.logoColor);
        parcel.writeInt(this.allowIgnore);
        parcel.writeInt(this.nonWifiPicPreload);
        parcel.writeInt(this.appWallPos);
        parcel.writeInt(this.noTip);
        parcel.writeInt(this.index);
        parcel.writeInt(this.startupBtnPos);
        parcel.writeFloat(this.duration);
        parcel.writeFloat(this.metaInterval);
        parcel.writeFloat(this.opacity);
        parcel.writeString(this.at);
        parcel.writeString(this.publisher);
        parcel.writeString(this.templateId);
        parcel.writeString(this.admId);
        parcel.writeString(this.fbId);
        parcel.writeString(this.mvId);
        parcel.writeInt(this.usePop);
        parcel.writeTypedList(this.ImageData);
        parcel.writeTypedList(this.IconData);
    }

    protected AdvData(Parcel parcel) {
        this.clickType = parcel.readString();
        this.clickUrl = parcel.readString();
        this.content = parcel.readString();
        this.copyright = parcel.readString();
        this.clickPackage = parcel.readString();
        this.packageName = parcel.readString();
        this.softwareName = parcel.readString();
        this.downloadUrl = parcel.readString();
        this.taskConfig = parcel.readString();
        this.author = parcel.readString();
        this.scheme = parcel.readString();
        this.inSpireDesc = parcel.readString();
        this.inSpireClickText = parcel.readString();
        this.desc = parcel.readString();
        this.button1Text = parcel.readString();
        this.button2Text = parcel.readString();
        this.fontColor = parcel.readString();
        this.popTitle = parcel.readString();
        this.popContent = parcel.readString();
        this.popBtnText = parcel.readString();
        this.popPositon = parcel.readString();
        this.bgColor = parcel.readString();
        this.wifiShowBest = parcel.readInt();
        this.displayCount = parcel.readInt();
        this.recommendType = parcel.readInt();
        this.inSpireIndex = parcel.readInt();
        this.logoColor = parcel.readInt();
        this.allowIgnore = parcel.readInt();
        this.nonWifiPicPreload = parcel.readInt();
        this.appWallPos = parcel.readInt();
        this.noTip = parcel.readInt();
        this.index = parcel.readInt();
        this.startupBtnPos = parcel.readInt();
        this.duration = parcel.readFloat();
        this.metaInterval = parcel.readFloat();
        this.opacity = parcel.readFloat();
        this.at = parcel.readString();
        this.publisher = parcel.readString();
        this.templateId = parcel.readString();
        this.admId = parcel.readString();
        this.fbId = parcel.readString();
        this.mvId = parcel.readString();
        this.usePop = parcel.readInt();
        this.ImageData = parcel.createTypedArrayList(ImageData.CREATOR);
        this.IconData = parcel.createTypedArrayList(IconData.CREATOR);
    }
}

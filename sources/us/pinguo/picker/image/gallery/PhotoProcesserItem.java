package us.pinguo.picker.image.gallery;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes5.dex */
public class PhotoProcesserItem implements Parcelable {
    public static final Parcelable.Creator<PhotoProcesserItem> CREATOR = new a();
    public static final String ITEM_STATE_BROKEN = "broken";
    public static final String ITEM_STATE_EDITING = "editing";
    public static final String ITEM_STATE_FINISHED = "finished";
    private int cameraModeIndex;
    private long dateTaken;
    private String destPath;
    private long elapsedTime;
    private String exif;
    public int height;
    public boolean isSaveOrgPhoto;
    public boolean isTimeWatermark;
    private String mEditParams;
    private String mEffectAlias;
    private String mEffectAppendix;
    private String mJsonExpand;
    private String mLayerEffectParams;
    private us.pinguo.librouter.b.c.f mLocation;
    private int operation;
    private int orientation;
    private int photoType;
    private String projectState;
    private String sourcePath;
    private int tryCount;
    private String version;
    public int width;

    /* loaded from: classes5.dex */
    class a implements Parcelable.Creator<PhotoProcesserItem> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PhotoProcesserItem createFromParcel(Parcel parcel) {
            return new PhotoProcesserItem(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public PhotoProcesserItem[] newArray(int i2) {
            return new PhotoProcesserItem[i2];
        }
    }

    /* synthetic */ PhotoProcesserItem(Parcel parcel, a aVar) {
        this(parcel);
    }

    public void a(Parcel parcel) {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "PhotoProcesserItem{mLocation=" + this.mLocation + ",\n dateTaken=" + this.dateTaken + ", sourcePath='" + this.sourcePath + "', destPath='" + this.destPath + "', mEffectAlias='" + this.mEffectAlias + "', orientation=" + this.orientation + ", photoType=" + this.photoType + ", tryCount=" + this.tryCount + ", projectState='" + this.projectState + "', elapsedTime=" + this.elapsedTime + ", version='" + this.version + "', operation=" + this.operation + ", width=" + this.width + ", height=" + this.height + ", isSaveOrgPhoto=" + this.isSaveOrgPhoto + ", isTimeWatermark=" + this.isTimeWatermark + ", exif='" + this.exif + "', mJsonExpand='" + this.mJsonExpand + "', mEffectAppendix='" + this.mEffectAppendix + "', mLayerEffectParams='" + this.mLayerEffectParams + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
    }

    public PhotoProcesserItem() {
        this.exif = null;
        this.mJsonExpand = null;
        this.mEffectAppendix = null;
    }

    private PhotoProcesserItem(Parcel parcel) {
        this.exif = null;
        this.mJsonExpand = null;
        this.mEffectAppendix = null;
        a(parcel);
    }
}

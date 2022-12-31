package us.pinguo.picker.image.picker;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
/* compiled from: ImagePickerConfig.kt */
/* loaded from: classes5.dex */
public final class ImagePickerConfigModel implements Parcelable {
    public static final int DEFAULT_MAX_SELECT_COUNT = 6;
    public static final String EXTRA_DATA = "image_pick";
    public static final String RESULT_DATA = "result_data";
    private boolean isMultiSelect;
    private boolean isPreviewImg;
    private int maxSelectCount;
    private String tipString;
    public static final a Companion = new a(null);
    public static final Parcelable.Creator<ImagePickerConfigModel> CREATOR = new b();

    /* compiled from: ImagePickerConfig.kt */
    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }
    }

    /* compiled from: ImagePickerConfig.kt */
    /* loaded from: classes5.dex */
    public static final class b implements Parcelable.Creator<ImagePickerConfigModel> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final ImagePickerConfigModel createFromParcel(Parcel parcel) {
            s.h(parcel, "parcel");
            return new ImagePickerConfigModel(parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final ImagePickerConfigModel[] newArray(int i2) {
            return new ImagePickerConfigModel[i2];
        }
    }

    public ImagePickerConfigModel() {
        this(null, false, false, 0, 15, null);
    }

    public ImagePickerConfigModel(String str, boolean z, boolean z2, int i2) {
        this.tipString = str;
        this.isMultiSelect = z;
        this.isPreviewImg = z2;
        this.maxSelectCount = i2;
    }

    public final String a() {
        return this.tipString;
    }

    public final boolean b() {
        return this.tipString != null;
    }

    public final boolean c() {
        return this.isMultiSelect;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ImagePickerConfigModel) {
            ImagePickerConfigModel imagePickerConfigModel = (ImagePickerConfigModel) obj;
            return s.c(this.tipString, imagePickerConfigModel.tipString) && this.isMultiSelect == imagePickerConfigModel.isMultiSelect && this.isPreviewImg == imagePickerConfigModel.isPreviewImg && this.maxSelectCount == imagePickerConfigModel.maxSelectCount;
        }
        return false;
    }

    public final boolean f() {
        return this.isPreviewImg;
    }

    public final void g(boolean z) {
        this.isMultiSelect = z;
    }

    public final void h(boolean z) {
        this.isPreviewImg = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.tipString;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        boolean z = this.isMultiSelect;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int i3 = (hashCode + i2) * 31;
        boolean z2 = this.isPreviewImg;
        return ((i3 + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.maxSelectCount;
    }

    public final void j(String str) {
        this.tipString = str;
    }

    public String toString() {
        return "ImagePickerConfigModel(tipString=" + ((Object) this.tipString) + ", isMultiSelect=" + this.isMultiSelect + ", isPreviewImg=" + this.isPreviewImg + ", maxSelectCount=" + this.maxSelectCount + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i2) {
        s.h(out, "out");
        out.writeString(this.tipString);
        out.writeInt(this.isMultiSelect ? 1 : 0);
        out.writeInt(this.isPreviewImg ? 1 : 0);
        out.writeInt(this.maxSelectCount);
    }

    public /* synthetic */ ImagePickerConfigModel(String str, boolean z, boolean z2, int i2, int i3, o oVar) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? true : z, (i3 & 4) != 0 ? true : z2, (i3 & 8) != 0 ? 6 : i2);
    }
}

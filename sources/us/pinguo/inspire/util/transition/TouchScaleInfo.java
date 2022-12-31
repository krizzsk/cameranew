package us.pinguo.inspire.util.transition;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;
import us.pinguo.inspire.module.discovery.entity.InspireFeedContent;
import us.pinguo.inspire.module.discovery.entity.InspireFeedPhoto;
import us.pinguo.inspire.widget.PhotoGridView;
import us.pinguo.ui.R;
/* loaded from: classes9.dex */
public class TouchScaleInfo implements Parcelable {
    public static final Parcelable.Creator<TouchScaleInfo> CREATOR = new a();
    public Bitmap bitmap;
    public Rect bounds;
    public int workHeight;
    public int workWidth;

    /* loaded from: classes9.dex */
    class a implements Parcelable.Creator<TouchScaleInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public TouchScaleInfo createFromParcel(Parcel parcel) {
            return new TouchScaleInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public TouchScaleInfo[] newArray(int i2) {
            return new TouchScaleInfo[i2];
        }
    }

    public TouchScaleInfo() {
    }

    public static TouchScaleInfo a(PhotoGridView photoGridView, InspireFeedContent inspireFeedContent, int i2) {
        TouchScaleInfo touchScaleInfo = new TouchScaleInfo();
        touchScaleInfo.bounds = photoGridView.getItemBoundsInWindow(i2);
        Bitmap[] bitmaps = photoGridView.getBitmaps();
        if (bitmaps != null && i2 < bitmaps.length) {
            touchScaleInfo.bitmap = bitmaps[i2];
        }
        if (touchScaleInfo.bitmap == null) {
            try {
                int color = photoGridView.getResources().getColor(R.color.inspire_loading_color);
                int[] iArr = new int[touchScaleInfo.bounds.width() * touchScaleInfo.bounds.height()];
                Arrays.fill(iArr, color);
                touchScaleInfo.bitmap = Bitmap.createBitmap(iArr, touchScaleInfo.bounds.width(), touchScaleInfo.bounds.height(), Bitmap.Config.RGB_565);
            } catch (OutOfMemoryError e2) {
                us.pinguo.common.log.a.f(e2);
                return null;
            }
        }
        List<InspireFeedPhoto> list = inspireFeedContent.photos;
        if (list != null) {
            InspireFeedPhoto inspireFeedPhoto = list.get(i2);
            touchScaleInfo.workWidth = inspireFeedPhoto.width;
            touchScaleInfo.workHeight = inspireFeedPhoto.height;
        }
        return touchScaleInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.bitmap, i2);
        parcel.writeParcelable(this.bounds, i2);
        parcel.writeInt(this.workWidth);
        parcel.writeInt(this.workHeight);
    }

    protected TouchScaleInfo(Parcel parcel) {
        this.bitmap = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.bounds = (Rect) parcel.readParcelable(Rect.class.getClassLoader());
        this.workWidth = parcel.readInt();
        this.workHeight = parcel.readInt();
    }
}

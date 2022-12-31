package us.pinguo.inspire.widget.photopager;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import us.pinguo.inspire.module.discovery.entity.InspireFeedPhoto;
/* loaded from: classes9.dex */
public class FullScreenPhoto implements Parcelable {
    public static final Parcelable.Creator<FullScreenPhoto> CREATOR = new a();
    public InspireFeedPhoto photo;
    public Rect rect;
    public int topOffset;

    /* loaded from: classes9.dex */
    class a implements Parcelable.Creator<FullScreenPhoto> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public FullScreenPhoto createFromParcel(Parcel parcel) {
            return new FullScreenPhoto(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public FullScreenPhoto[] newArray(int i2) {
            return new FullScreenPhoto[i2];
        }
    }

    public FullScreenPhoto() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.photo, i2);
        parcel.writeParcelable(this.rect, i2);
    }

    protected FullScreenPhoto(Parcel parcel) {
        this.photo = (InspireFeedPhoto) parcel.readParcelable(InspireFeedPhoto.class.getClassLoader());
        this.rect = (Rect) parcel.readParcelable(Rect.class.getClassLoader());
    }
}

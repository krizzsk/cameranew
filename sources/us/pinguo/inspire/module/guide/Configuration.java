package us.pinguo.inspire.module.guide;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
/* loaded from: classes9.dex */
public class Configuration implements Parcelable {
    public static final Parcelable.Creator<Configuration> CREATOR = new Parcelable.Creator<Configuration>() { // from class: us.pinguo.inspire.module.guide.Configuration.1
        @Override // android.os.Parcelable.Creator
        public Configuration createFromParcel(Parcel parcel) {
            return new Configuration(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Configuration[] newArray(int i2) {
            return new Configuration[i2];
        }
    };
    int mAlpha;
    boolean mAutoDismiss;
    int mCorner;
    int mEnterAnimationId;
    int mExitAnimationId;
    int mFullingColorId;
    int mFullingViewId;
    int mGraphStyle;
    boolean mOutsideTouchable;
    boolean mOverlayTarget;
    int mPadding;
    int mPaddingBottom;
    int mPaddingLeft;
    int mPaddingRight;
    int mPaddingTop;
    View mTargetView;
    int mTargetViewId;

    public Configuration() {
        this.mTargetView = null;
        this.mPadding = 0;
        this.mPaddingLeft = 0;
        this.mPaddingRight = 0;
        this.mPaddingTop = 0;
        this.mPaddingBottom = 0;
        this.mAlpha = 255;
        this.mFullingViewId = -1;
        this.mTargetViewId = -1;
        this.mCorner = 0;
        this.mGraphStyle = 0;
        this.mFullingColorId = 17170444;
        this.mAutoDismiss = true;
        this.mOverlayTarget = false;
        this.mEnterAnimationId = -1;
        this.mExitAnimationId = -1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.mPadding);
        parcel.writeInt(this.mPaddingLeft);
        parcel.writeInt(this.mPaddingRight);
        parcel.writeInt(this.mPaddingTop);
        parcel.writeInt(this.mPaddingBottom);
        parcel.writeByte(this.mOutsideTouchable ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.mAlpha);
        parcel.writeInt(this.mFullingViewId);
        parcel.writeInt(this.mTargetViewId);
        parcel.writeInt(this.mCorner);
        parcel.writeInt(this.mGraphStyle);
        parcel.writeInt(this.mFullingColorId);
        parcel.writeByte(this.mAutoDismiss ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mOverlayTarget ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.mEnterAnimationId);
        parcel.writeInt(this.mExitAnimationId);
    }

    protected Configuration(Parcel parcel) {
        this.mTargetView = null;
        this.mPadding = 0;
        this.mPaddingLeft = 0;
        this.mPaddingRight = 0;
        this.mPaddingTop = 0;
        this.mPaddingBottom = 0;
        this.mAlpha = 255;
        this.mFullingViewId = -1;
        this.mTargetViewId = -1;
        this.mCorner = 0;
        this.mGraphStyle = 0;
        this.mFullingColorId = 17170444;
        this.mAutoDismiss = true;
        this.mOverlayTarget = false;
        this.mEnterAnimationId = -1;
        this.mExitAnimationId = -1;
        this.mPadding = parcel.readInt();
        this.mPaddingLeft = parcel.readInt();
        this.mPaddingRight = parcel.readInt();
        this.mPaddingTop = parcel.readInt();
        this.mPaddingBottom = parcel.readInt();
        this.mOutsideTouchable = parcel.readByte() != 0;
        this.mAlpha = parcel.readInt();
        this.mFullingViewId = parcel.readInt();
        this.mTargetViewId = parcel.readInt();
        this.mCorner = parcel.readInt();
        this.mGraphStyle = parcel.readInt();
        this.mFullingColorId = parcel.readInt();
        this.mAutoDismiss = parcel.readByte() != 0;
        this.mOverlayTarget = parcel.readByte() != 0;
        this.mEnterAnimationId = parcel.readInt();
        this.mExitAnimationId = parcel.readInt();
    }
}

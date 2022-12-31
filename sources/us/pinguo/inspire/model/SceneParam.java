package us.pinguo.inspire.model;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes9.dex */
public class SceneParam implements Parcelable {
    public static final Parcelable.Creator<SceneParam> CREATOR = new Parcelable.Creator<SceneParam>() { // from class: us.pinguo.inspire.model.SceneParam.1
        @Override // android.os.Parcelable.Creator
        public SceneParam createFromParcel(Parcel parcel) {
            SceneParam sceneParam = new SceneParam();
            sceneParam.title = parcel.readString();
            sceneParam.image = parcel.readString();
            return sceneParam;
        }

        @Override // android.os.Parcelable.Creator
        public SceneParam[] newArray(int i2) {
            return new SceneParam[i2];
        }
    };
    public String image;
    public String title;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.title);
        parcel.writeString(this.image);
    }
}

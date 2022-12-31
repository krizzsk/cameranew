package us.pinguo.inspire.model;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes9.dex */
public class JoinStatus implements Parcelable {
    public static final Parcelable.Creator<JoinStatus> CREATOR = new Parcelable.Creator<JoinStatus>() { // from class: us.pinguo.inspire.model.JoinStatus.1
        @Override // android.os.Parcelable.Creator
        public JoinStatus createFromParcel(Parcel parcel) {
            return new JoinStatus(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public JoinStatus[] newArray(int i2) {
            return new JoinStatus[i2];
        }
    };
    public String message;
    public int status;

    public JoinStatus() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.status);
        parcel.writeString(this.message);
    }

    protected JoinStatus(Parcel parcel) {
        this.status = parcel.readInt();
        this.message = parcel.readString();
    }
}

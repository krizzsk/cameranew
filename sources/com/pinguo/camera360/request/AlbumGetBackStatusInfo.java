package com.pinguo.camera360.request;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public class AlbumGetBackStatusInfo implements Parcelable {
    public static final Parcelable.Creator<AlbumGetBackStatusInfo> CREATOR = new Parcelable.Creator<AlbumGetBackStatusInfo>() { // from class: com.pinguo.camera360.request.AlbumGetBackStatusInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AlbumGetBackStatusInfo createFromParcel(Parcel parcel) {
            return new AlbumGetBackStatusInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AlbumGetBackStatusInfo[] newArray(int i2) {
            return new AlbumGetBackStatusInfo[i2];
        }
    };
    public String email;
    public int status;
    public int success;

    /* loaded from: classes3.dex */
    public enum AlbumGetBackStatus {
        ALBUM_GET_BACK_STATUS_NONE(-1),
        ALBUM_GET_BACK_STATUS_HANDING(0),
        ALBUM_GET_BACK_STATUS_FINISHED(1);
        
        public int status;

        AlbumGetBackStatus(int i2) {
            this.status = i2;
        }
    }

    public AlbumGetBackStatusInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.success);
        parcel.writeInt(this.status);
        parcel.writeString(this.email);
    }

    protected AlbumGetBackStatusInfo(Parcel parcel) {
        this.success = parcel.readInt();
        this.status = parcel.readInt();
        this.email = parcel.readString();
    }
}

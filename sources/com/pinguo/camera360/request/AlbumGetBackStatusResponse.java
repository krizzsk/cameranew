package com.pinguo.camera360.request;

import android.os.Parcel;
import android.os.Parcelable;
import us.pinguo.common.network.BaseResponse;
/* loaded from: classes3.dex */
public class AlbumGetBackStatusResponse extends BaseResponse<AlbumGetBackStatusInfo> implements Parcelable {
    public static final Parcelable.Creator<AlbumGetBackStatusResponse> CREATOR = new Parcelable.Creator<AlbumGetBackStatusResponse>() { // from class: com.pinguo.camera360.request.AlbumGetBackStatusResponse.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AlbumGetBackStatusResponse createFromParcel(Parcel parcel) {
            return new AlbumGetBackStatusResponse(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AlbumGetBackStatusResponse[] newArray(int i2) {
            return new AlbumGetBackStatusResponse[i2];
        }
    };

    public AlbumGetBackStatusResponse() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
    }

    protected AlbumGetBackStatusResponse(Parcel parcel) {
    }
}

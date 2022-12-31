package us.pinguo.inspire.module.discovery.entity.dicovery;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes9.dex */
public class AuthorInfo implements Parcelable {
    public static final Parcelable.Creator<AuthorInfo> CREATOR = new Parcelable.Creator<AuthorInfo>() { // from class: us.pinguo.inspire.module.discovery.entity.dicovery.AuthorInfo.1
        @Override // android.os.Parcelable.Creator
        public AuthorInfo createFromParcel(Parcel parcel) {
            return new AuthorInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public AuthorInfo[] newArray(int i2) {
            return new AuthorInfo[i2];
        }
    };
    public String avatar;
    public int mark;
    public String nationalFlag;
    public String nickname;
    public int ranking;
    public int relation;
    public int type;
    public String userId;

    public AuthorInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.userId);
        parcel.writeString(this.nickname);
        parcel.writeString(this.avatar);
        parcel.writeString(this.nationalFlag);
        parcel.writeInt(this.relation);
        parcel.writeInt(this.type);
        parcel.writeInt(this.mark);
        parcel.writeInt(this.ranking);
    }

    protected AuthorInfo(Parcel parcel) {
        this.userId = parcel.readString();
        this.nickname = parcel.readString();
        this.avatar = parcel.readString();
        this.nationalFlag = parcel.readString();
        this.relation = parcel.readInt();
        this.type = parcel.readInt();
        this.mark = parcel.readInt();
        this.ranking = parcel.readInt();
    }
}

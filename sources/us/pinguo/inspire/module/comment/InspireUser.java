package us.pinguo.inspire.module.comment;

import android.os.Parcel;
import android.os.Parcelable;
import us.pinguo.user.model.IRelation;
/* loaded from: classes9.dex */
public class InspireUser implements IRelation, Parcelable {
    public static final Parcelable.Creator<InspireUser> CREATOR = new Parcelable.Creator<InspireUser>() { // from class: us.pinguo.inspire.module.comment.InspireUser.1
        @Override // android.os.Parcelable.Creator
        public InspireUser createFromParcel(Parcel parcel) {
            return new InspireUser(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public InspireUser[] newArray(int i2) {
            return new InspireUser[i2];
        }
    };
    public static final int TYPE_V = 1;
    public String avatar;
    public String backgroundPic;
    public String desc;
    public int gender;
    public String highlight;
    public int mark;
    public String mobile;
    public String nickname;
    public int relation;
    public int type;
    public String userId;

    public InspireUser() {
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InspireUser) {
            String str = this.userId;
            String str2 = ((InspireUser) obj).userId;
            return str != null ? str.equals(str2) : str2 == null;
        }
        return false;
    }

    @Override // us.pinguo.user.model.IRelation
    public int getRelation() {
        return this.relation;
    }

    public int hashCode() {
        String str = this.userId;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @Override // us.pinguo.user.model.IRelation
    public void setRelation(int i2) {
        this.relation = i2;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.userId);
        parcel.writeString(this.nickname);
        parcel.writeString(this.avatar);
        parcel.writeInt(this.gender);
        parcel.writeString(this.mobile);
        parcel.writeString(this.desc);
        parcel.writeInt(this.relation);
        parcel.writeString(this.backgroundPic);
        parcel.writeInt(this.type);
        parcel.writeInt(this.mark);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public InspireUser(Parcel parcel) {
        this.userId = parcel.readString();
        this.nickname = parcel.readString();
        this.avatar = parcel.readString();
        this.gender = parcel.readInt();
        this.mobile = parcel.readString();
        this.desc = parcel.readString();
        this.relation = parcel.readInt();
        this.backgroundPic = parcel.readString();
        this.type = parcel.readInt();
        this.mark = parcel.readInt();
    }
}

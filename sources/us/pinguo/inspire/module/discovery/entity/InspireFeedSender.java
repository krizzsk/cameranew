package us.pinguo.inspire.module.discovery.entity;

import android.os.Parcel;
import android.os.Parcelable;
import us.pinguo.inspire.model.InspireGeo;
import us.pinguo.user.model.IRelation;
/* loaded from: classes9.dex */
public class InspireFeedSender implements IRelation, Parcelable {
    public static final Parcelable.Creator<InspireFeedSender> CREATOR = new Parcelable.Creator<InspireFeedSender>() { // from class: us.pinguo.inspire.module.discovery.entity.InspireFeedSender.1
        @Override // android.os.Parcelable.Creator
        public InspireFeedSender createFromParcel(Parcel parcel) {
            return new InspireFeedSender(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public InspireFeedSender[] newArray(int i2) {
            return new InspireFeedSender[i2];
        }
    };
    public String avatar;
    public String description;
    public int fansCount;
    public int followCount;
    public int gender;
    public InspireGeo geo;
    public int level;
    public int likeSum;
    public int mark;
    public String nickname;
    public int picSum;
    public int points;
    public int relation;
    public int scores;
    public int type;
    public String userId;

    public InspireFeedSender() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        InspireFeedSender inspireFeedSender = (InspireFeedSender) obj;
        if (this.gender == inspireFeedSender.gender && this.scores == inspireFeedSender.scores && this.points == inspireFeedSender.points && this.level == inspireFeedSender.level && this.picSum == inspireFeedSender.picSum && this.likeSum == inspireFeedSender.likeSum && this.followCount == inspireFeedSender.followCount && this.fansCount == inspireFeedSender.fansCount && this.relation == inspireFeedSender.relation) {
            String str = this.userId;
            if (str == null ? inspireFeedSender.userId == null : str.equals(inspireFeedSender.userId)) {
                String str2 = this.avatar;
                if (str2 == null ? inspireFeedSender.avatar == null : str2.equals(inspireFeedSender.avatar)) {
                    String str3 = this.nickname;
                    if (str3 == null ? inspireFeedSender.nickname == null : str3.equals(inspireFeedSender.nickname)) {
                        String str4 = this.description;
                        if (str4 == null ? inspireFeedSender.description == null : str4.equals(inspireFeedSender.description)) {
                            InspireGeo inspireGeo = this.geo;
                            InspireGeo inspireGeo2 = inspireFeedSender.geo;
                            return inspireGeo != null ? inspireGeo.equals(inspireGeo2) : inspireGeo2 == null;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // us.pinguo.user.model.IRelation
    public int getRelation() {
        return this.relation;
    }

    public int hashCode() {
        String str = this.userId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.avatar;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.nickname;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.description;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        InspireGeo inspireGeo = this.geo;
        return ((((((((((((((((((hashCode4 + (inspireGeo != null ? inspireGeo.hashCode() : 0)) * 31) + this.gender) * 31) + this.scores) * 31) + this.points) * 31) + this.level) * 31) + this.picSum) * 31) + this.likeSum) * 31) + this.followCount) * 31) + this.fansCount) * 31) + this.relation;
    }

    @Override // us.pinguo.user.model.IRelation
    public void setRelation(int i2) {
        this.relation = i2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.userId);
        parcel.writeString(this.avatar);
        parcel.writeString(this.nickname);
        parcel.writeParcelable(this.geo, i2);
        parcel.writeInt(this.gender);
        parcel.writeInt(this.scores);
        parcel.writeInt(this.points);
        parcel.writeInt(this.level);
        parcel.writeInt(this.picSum);
        parcel.writeInt(this.likeSum);
        parcel.writeInt(this.followCount);
        parcel.writeInt(this.fansCount);
        parcel.writeInt(this.relation);
        parcel.writeInt(this.mark);
    }

    protected InspireFeedSender(Parcel parcel) {
        this.userId = parcel.readString();
        this.avatar = parcel.readString();
        this.nickname = parcel.readString();
        this.geo = (InspireGeo) parcel.readParcelable(InspireGeo.class.getClassLoader());
        this.gender = parcel.readInt();
        this.scores = parcel.readInt();
        this.points = parcel.readInt();
        this.level = parcel.readInt();
        this.picSum = parcel.readInt();
        this.likeSum = parcel.readInt();
        this.followCount = parcel.readInt();
        this.fansCount = parcel.readInt();
        this.relation = parcel.readInt();
        this.mark = parcel.readInt();
    }
}

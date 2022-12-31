package us.pinguo.user.model;

import android.os.Parcel;
import android.os.Parcelable;
import us.pinguo.inspire.model.InspireGeo;
import us.pinguo.user.User;
/* loaded from: classes6.dex */
public class ProfileAuthorInfo implements IRelation, Parcelable {
    public static final Parcelable.Creator<ProfileAuthorInfo> CREATOR = new Parcelable.Creator<ProfileAuthorInfo>() { // from class: us.pinguo.user.model.ProfileAuthorInfo.1
        @Override // android.os.Parcelable.Creator
        public ProfileAuthorInfo createFromParcel(Parcel parcel) {
            return new ProfileAuthorInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ProfileAuthorInfo[] newArray(int i2) {
            return new ProfileAuthorInfo[i2];
        }
    };
    public String avatar;
    public String backgroundPic;
    public String desc;
    public int fansCount;
    public int flowerWorkCount;
    public int followCount;
    public int gender;
    public InspireGeo geo;
    public int getFlowerSum;
    public int level;
    public int likeSum;
    public int mark;
    public String nickname;
    public int picSum;
    public int points;
    public int ranking;
    public int relation;
    public int scores;
    public int type;
    public String typeIntro;
    public String userId;
    public int workSum;

    public ProfileAuthorInfo() {
    }

    public static ProfileAuthorInfo userToProfileAuthorInfo(User.Info info) {
        ProfileAuthorInfo profileAuthorInfo = new ProfileAuthorInfo();
        profileAuthorInfo.avatar = info.avatar;
        profileAuthorInfo.backgroundPic = info.backgroundPic;
        profileAuthorInfo.userId = info.userId;
        profileAuthorInfo.desc = info.description;
        try {
            profileAuthorInfo.gender = Integer.parseInt(info.gender);
        } catch (Exception unused) {
            profileAuthorInfo.gender = 0;
        }
        profileAuthorInfo.nickname = info.nickname;
        InspireGeo inspireGeo = new InspireGeo();
        inspireGeo.province = info.province;
        inspireGeo.country = info.country;
        inspireGeo.city = info.city;
        profileAuthorInfo.geo = inspireGeo;
        return profileAuthorInfo;
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
        ProfileAuthorInfo profileAuthorInfo = (ProfileAuthorInfo) obj;
        if (this.gender == profileAuthorInfo.gender && this.scores == profileAuthorInfo.scores && this.level == profileAuthorInfo.level && this.followCount == profileAuthorInfo.followCount && this.fansCount == profileAuthorInfo.fansCount && this.relation == profileAuthorInfo.relation && this.picSum == profileAuthorInfo.picSum && this.workSum == profileAuthorInfo.workSum && this.likeSum == profileAuthorInfo.likeSum && this.type == profileAuthorInfo.type && this.mark == profileAuthorInfo.mark) {
            String str = this.userId;
            if (str == null ? profileAuthorInfo.userId == null : str.equals(profileAuthorInfo.userId)) {
                String str2 = this.avatar;
                if (str2 == null ? profileAuthorInfo.avatar == null : str2.equals(profileAuthorInfo.avatar)) {
                    String str3 = this.nickname;
                    if (str3 == null ? profileAuthorInfo.nickname == null : str3.equals(profileAuthorInfo.nickname)) {
                        InspireGeo inspireGeo = this.geo;
                        if (inspireGeo == null ? profileAuthorInfo.geo == null : inspireGeo.equals(profileAuthorInfo.geo)) {
                            String str4 = this.desc;
                            if (str4 == null ? profileAuthorInfo.desc == null : str4.equals(profileAuthorInfo.desc)) {
                                String str5 = this.backgroundPic;
                                if (str5 == null ? profileAuthorInfo.backgroundPic == null : str5.equals(profileAuthorInfo.backgroundPic)) {
                                    String str6 = this.typeIntro;
                                    String str7 = profileAuthorInfo.typeIntro;
                                    return str6 != null ? str6.equals(str7) : str7 == null;
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
        InspireGeo inspireGeo = this.geo;
        int hashCode4 = (((((((((((((((((((hashCode3 + (inspireGeo != null ? inspireGeo.hashCode() : 0)) * 31) + this.gender) * 31) + this.scores) * 31) + this.level) * 31) + this.followCount) * 31) + this.fansCount) * 31) + this.relation) * 31) + this.picSum) * 31) + this.workSum) * 31) + this.likeSum) * 31;
        String str4 = this.desc;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.backgroundPic;
        int hashCode6 = (((((hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.type) * 31) + this.mark) * 31;
        String str6 = this.typeIntro;
        return hashCode6 + (str6 != null ? str6.hashCode() : 0);
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
        parcel.writeString(this.typeIntro);
        parcel.writeParcelable(this.geo, 0);
        parcel.writeInt(this.gender);
        parcel.writeInt(this.scores);
        parcel.writeInt(this.points);
        parcel.writeInt(this.level);
        parcel.writeInt(this.followCount);
        parcel.writeInt(this.fansCount);
        parcel.writeInt(this.relation);
        parcel.writeInt(this.picSum);
        parcel.writeInt(this.workSum);
        parcel.writeInt(this.likeSum);
        parcel.writeString(this.desc);
        parcel.writeString(this.backgroundPic);
        parcel.writeInt(this.type);
        parcel.writeInt(this.followCount);
        parcel.writeInt(this.ranking);
        parcel.writeInt(this.getFlowerSum);
    }

    protected ProfileAuthorInfo(Parcel parcel) {
        this.userId = parcel.readString();
        this.avatar = parcel.readString();
        this.nickname = parcel.readString();
        this.typeIntro = parcel.readString();
        this.geo = (InspireGeo) parcel.readParcelable(InspireGeo.class.getClassLoader());
        this.gender = parcel.readInt();
        this.scores = parcel.readInt();
        this.points = parcel.readInt();
        this.level = parcel.readInt();
        this.followCount = parcel.readInt();
        this.fansCount = parcel.readInt();
        this.relation = parcel.readInt();
        this.picSum = parcel.readInt();
        this.workSum = parcel.readInt();
        this.likeSum = parcel.readInt();
        this.desc = parcel.readString();
        this.backgroundPic = parcel.readString();
        this.type = parcel.readInt();
        this.flowerWorkCount = parcel.readInt();
        this.ranking = parcel.readInt();
        this.getFlowerSum = parcel.readInt();
    }
}

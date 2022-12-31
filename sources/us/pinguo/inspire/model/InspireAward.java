package us.pinguo.inspire.model;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes9.dex */
public class InspireAward implements Parcelable {
    public static final Parcelable.Creator<InspireAward> CREATOR = new Parcelable.Creator<InspireAward>() { // from class: us.pinguo.inspire.model.InspireAward.1
        @Override // android.os.Parcelable.Creator
        public InspireAward createFromParcel(Parcel parcel) {
            InspireAward inspireAward = new InspireAward();
            inspireAward.awardTitle = parcel.readString();
            inspireAward.awardDesc = parcel.readString();
            inspireAward.awardPic = parcel.readString();
            inspireAward.awardLink = parcel.readString();
            inspireAward.awardShortDesc = parcel.readString();
            return inspireAward;
        }

        @Override // android.os.Parcelable.Creator
        public InspireAward[] newArray(int i2) {
            return new InspireAward[i2];
        }
    };
    public String awardLink;
    public String awardPic;
    public String awardTitle;
    public String awardDesc = "长奖品描述";
    public String awardShortDesc = "短奖品描述";
    public String awardRule = "举办方:相机360\n最大限制:10000*10000px";

    public static InspireAward fromString(String str) {
        return (InspireAward) new com.google.gson.e().j(str, InspireAward.class);
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
        InspireAward inspireAward = (InspireAward) obj;
        String str = this.awardTitle;
        if (str == null ? inspireAward.awardTitle == null : str.equals(inspireAward.awardTitle)) {
            String str2 = this.awardDesc;
            if (str2 == null ? inspireAward.awardDesc == null : str2.equals(inspireAward.awardDesc)) {
                String str3 = this.awardPic;
                if (str3 == null ? inspireAward.awardPic == null : str3.equals(inspireAward.awardPic)) {
                    String str4 = this.awardLink;
                    if (str4 == null ? inspireAward.awardLink == null : str4.equals(inspireAward.awardLink)) {
                        String str5 = this.awardShortDesc;
                        if (str5 == null ? inspireAward.awardShortDesc == null : str5.equals(inspireAward.awardShortDesc)) {
                            String str6 = this.awardRule;
                            String str7 = inspireAward.awardRule;
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

    public int hashCode() {
        String str = this.awardTitle;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.awardDesc;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.awardPic;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.awardLink;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.awardShortDesc;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.awardRule;
        return hashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    public String toString() {
        return new com.google.gson.e().s(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.awardTitle);
        parcel.writeString(this.awardDesc);
        parcel.writeString(this.awardPic);
        parcel.writeString(this.awardLink);
        parcel.writeString(this.awardShortDesc);
    }
}

package us.pinguo.inspire.module.attention;

import android.os.Parcel;
import android.os.Parcelable;
import us.pinguo.inspire.model.InspireGeo;
import us.pinguo.inspire.module.comment.InspireUser;
/* loaded from: classes9.dex */
public class InspireAttention extends InspireUser implements Parcelable {
    public static final Parcelable.Creator<InspireAttention> CREATOR = new Parcelable.Creator<InspireAttention>() { // from class: us.pinguo.inspire.module.attention.InspireAttention.1
        @Override // android.os.Parcelable.Creator
        public InspireAttention createFromParcel(Parcel parcel) {
            return new InspireAttention(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public InspireAttention[] newArray(int i2) {
            return new InspireAttention[i2];
        }
    };
    public int fansCount;
    public int followCount;
    public InspireGeo geo;
    public int isRecommend;

    public InspireAttention() {
    }

    @Override // us.pinguo.inspire.module.comment.InspireUser, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // us.pinguo.inspire.module.comment.InspireUser
    public boolean equals(Object obj) {
        return this.userId.equals(((InspireAttention) obj).userId);
    }

    @Override // us.pinguo.inspire.module.comment.InspireUser
    public int hashCode() {
        return (((((super.hashCode() * 31) + this.followCount) * 31) + this.fansCount) * 31) + this.geo.hashCode();
    }

    @Override // us.pinguo.inspire.module.comment.InspireUser, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeInt(this.followCount);
        parcel.writeInt(this.fansCount);
    }

    protected InspireAttention(Parcel parcel) {
        super(parcel);
        this.followCount = parcel.readInt();
        this.fansCount = parcel.readInt();
    }
}

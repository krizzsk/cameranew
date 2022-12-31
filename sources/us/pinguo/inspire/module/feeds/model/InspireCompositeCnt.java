package us.pinguo.inspire.module.feeds.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class InspireCompositeCnt implements Parcelable {
    public static final Parcelable.Creator<InspireCompositeCnt> CREATOR = new Parcelable.Creator<InspireCompositeCnt>() { // from class: us.pinguo.inspire.module.feeds.model.InspireCompositeCnt.1
        @Override // android.os.Parcelable.Creator
        public InspireCompositeCnt createFromParcel(Parcel parcel) {
            return new InspireCompositeCnt(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public InspireCompositeCnt[] newArray(int i2) {
            return new InspireCompositeCnt[i2];
        }
    };
    public long lastMfeedTime;
    public int upUserCount;
    public List<User> users;
    public List<Work> works;

    /* loaded from: classes9.dex */
    public static class User {
        public String avatar;
        public String nickname;
        public String userId;
    }

    /* loaded from: classes9.dex */
    public static class Work {
        public static final String TYPE_PHOTO = "photo";
        public static final String TYPE_VIDEO = "video";
        public int height;
        public String mid;
        public String mtype;
        public String murl;
        public int width;
    }

    protected InspireCompositeCnt(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        this.users = arrayList;
        parcel.readList(arrayList, List.class.getClassLoader());
        ArrayList arrayList2 = new ArrayList();
        this.works = arrayList2;
        parcel.readList(arrayList2, List.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeList(this.users);
        parcel.writeList(this.works);
    }
}

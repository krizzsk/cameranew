package us.pinguo.inspire.module.discovery.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.inspire.model.InspireTask;
/* loaded from: classes9.dex */
public class InspireTaskCnt implements Parcelable {
    public static final Parcelable.Creator<InspireTaskCnt> CREATOR = new Parcelable.Creator<InspireTaskCnt>() { // from class: us.pinguo.inspire.module.discovery.entity.InspireTaskCnt.1
        @Override // android.os.Parcelable.Creator
        public InspireTaskCnt createFromParcel(Parcel parcel) {
            return new InspireTaskCnt(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public InspireTaskCnt[] newArray(int i2) {
            return new InspireTaskCnt[i2];
        }
    };
    public int browseCount;
    public int challengeCount;
    public String desc;
    public List<InspireFeedPhoto> photos;
    public long pubTime;
    public InspireTask task;
    public List<InspireFeedVideo> videos;

    public InspireTaskCnt() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.task, 0);
        parcel.writeLong(this.pubTime);
        parcel.writeInt(this.challengeCount);
        parcel.writeInt(this.browseCount);
        parcel.writeString(this.desc);
        parcel.writeList(this.photos);
        parcel.writeList(this.videos);
    }

    protected InspireTaskCnt(Parcel parcel) {
        this.task = (InspireTask) parcel.readParcelable(InspireTask.class.getClassLoader());
        this.pubTime = parcel.readLong();
        this.challengeCount = parcel.readInt();
        this.browseCount = parcel.readInt();
        this.desc = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.photos = arrayList;
        parcel.readList(arrayList, List.class.getClassLoader());
        ArrayList arrayList2 = new ArrayList();
        this.videos = arrayList2;
        parcel.readList(arrayList2, List.class.getClassLoader());
    }
}

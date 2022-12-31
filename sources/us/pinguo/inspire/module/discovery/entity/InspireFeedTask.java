package us.pinguo.inspire.module.discovery.entity;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes9.dex */
public class InspireFeedTask implements Parcelable {
    public static final Parcelable.Creator<InspireFeedTask> CREATOR = new Parcelable.Creator<InspireFeedTask>() { // from class: us.pinguo.inspire.module.discovery.entity.InspireFeedTask.1
        @Override // android.os.Parcelable.Creator
        public InspireFeedTask createFromParcel(Parcel parcel) {
            return new InspireFeedTask(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public InspireFeedTask[] newArray(int i2) {
            return new InspireFeedTask[i2];
        }
    };
    public int taskFinish;
    public String taskId;
    public String taskName;

    public InspireFeedTask() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.taskId);
        parcel.writeString(this.taskName);
        parcel.writeInt(this.taskFinish);
    }

    protected InspireFeedTask(Parcel parcel) {
        this.taskId = parcel.readString();
        this.taskName = parcel.readString();
        this.taskFinish = parcel.readInt();
    }
}

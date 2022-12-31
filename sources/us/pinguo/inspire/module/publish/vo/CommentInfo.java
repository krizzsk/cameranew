package us.pinguo.inspire.module.publish.vo;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes9.dex */
public class CommentInfo implements Parcelable {
    public static final Parcelable.Creator<CommentInfo> CREATOR = new Parcelable.Creator<CommentInfo>() { // from class: us.pinguo.inspire.module.publish.vo.CommentInfo.1
        @Override // android.os.Parcelable.Creator
        public CommentInfo createFromParcel(Parcel parcel) {
            return new CommentInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public CommentInfo[] newArray(int i2) {
            return new CommentInfo[i2];
        }
    };
    public String content;
    public String emoticonId;
    public String replyId;
    public String workId;

    public CommentInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.workId);
        parcel.writeString(this.replyId);
        parcel.writeString(this.content);
        parcel.writeString(this.emoticonId);
    }

    protected CommentInfo(Parcel parcel) {
        this.workId = parcel.readString();
        this.replyId = parcel.readString();
        this.content = parcel.readString();
        this.emoticonId = parcel.readString();
    }
}

package us.pinguo.inspire.module.comment;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.rockerhieu.emoji.model.Emoticon;
import java.util.List;
import us.pinguo.inspire.model.InspirePhoto;
import us.pinguo.inspire.module.attention.InspireAttention;
import us.pinguo.inspire.module.publish.vo.PublishData;
/* loaded from: classes9.dex */
public class InspireComment implements Comparable<InspireComment>, Parcelable {
    public static final Parcelable.Creator<InspireComment> CREATOR = new Parcelable.Creator<InspireComment>() { // from class: us.pinguo.inspire.module.comment.InspireComment.1
        @Override // android.os.Parcelable.Creator
        public InspireComment createFromParcel(Parcel parcel) {
            return new InspireComment(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public InspireComment[] newArray(int i2) {
            return new InspireComment[i2];
        }
    };
    public List<InspireAttention> atMembers;
    public String clientId;
    public String commentId;
    public CommentBody content;
    public long createTime;
    public boolean isReply;
    public PublishData publishData;
    public InspireUser receiver;
    public String replyId;
    public InspireUser sender;
    public String workId;

    /* loaded from: classes9.dex */
    public static class CommentBody implements Parcelable {
        public static final Parcelable.Creator<CommentBody> CREATOR = new Parcelable.Creator<CommentBody>() { // from class: us.pinguo.inspire.module.comment.InspireComment.CommentBody.1
            @Override // android.os.Parcelable.Creator
            public CommentBody createFromParcel(Parcel parcel) {
                return new CommentBody(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public CommentBody[] newArray(int i2) {
                return new CommentBody[i2];
            }
        };
        public Emoticon emoticon;
        public List<InspirePhoto> imgs;
        public String lang;
        public String text;
        public int translate;

        public CommentBody() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.text);
            parcel.writeString(this.lang);
            parcel.writeInt(this.translate);
            parcel.writeTypedList(this.imgs);
            parcel.writeParcelable(this.emoticon, i2);
        }

        protected CommentBody(Parcel parcel) {
            this.text = parcel.readString();
            this.lang = parcel.readString();
            this.translate = parcel.readInt();
            this.imgs = parcel.createTypedArrayList(InspirePhoto.CREATOR);
            this.emoticon = (Emoticon) parcel.readParcelable(Emoticon.class.getClassLoader());
        }
    }

    public InspireComment() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof InspireComment) {
            return TextUtils.isEmpty(this.commentId) ? super.equals(obj) : this.commentId.equals(((InspireComment) obj).commentId);
        }
        return false;
    }

    public String getAtMembersJsonString() {
        List<InspireAttention> list = this.atMembers;
        String str = "";
        if (list != null && list.size() != 0) {
            us.pinguo.common.log.a.m("zw", "member size:" + this.atMembers.size(), new Object[0]);
            for (int i2 = 0; i2 < this.atMembers.size(); i2++) {
                str = i2 == this.atMembers.size() - 1 ? str + this.atMembers.get(i2).userId : str + this.atMembers.get(i2).userId + ",";
            }
            us.pinguo.common.log.a.m("zw", "list:" + str, new Object[0]);
        }
        return str;
    }

    public int hashCode() {
        return TextUtils.isEmpty(this.commentId) ? super.hashCode() : this.commentId.hashCode();
    }

    public boolean needTranslate() {
        CommentBody commentBody = this.content;
        return commentBody != null && commentBody.translate == 1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.commentId);
        parcel.writeString(this.workId);
        parcel.writeString(this.replyId);
        parcel.writeLong(this.createTime);
        parcel.writeParcelable(this.sender, i2);
        parcel.writeParcelable(this.receiver, i2);
        parcel.writeParcelable(this.content, i2);
        parcel.writeTypedList(this.atMembers);
        parcel.writeByte(this.isReply ? (byte) 1 : (byte) 0);
    }

    protected InspireComment(Parcel parcel) {
        this.commentId = parcel.readString();
        this.workId = parcel.readString();
        this.replyId = parcel.readString();
        this.createTime = parcel.readLong();
        this.sender = (InspireUser) parcel.readParcelable(InspireUser.class.getClassLoader());
        this.receiver = (InspireUser) parcel.readParcelable(InspireUser.class.getClassLoader());
        this.content = (CommentBody) parcel.readParcelable(CommentBody.class.getClassLoader());
        this.atMembers = parcel.createTypedArrayList(InspireAttention.CREATOR);
        this.isReply = parcel.readByte() != 0;
    }

    @Override // java.lang.Comparable
    public int compareTo(InspireComment inspireComment) {
        if (inspireComment == null) {
            return 1;
        }
        return (int) (inspireComment.createTime - this.createTime);
    }
}

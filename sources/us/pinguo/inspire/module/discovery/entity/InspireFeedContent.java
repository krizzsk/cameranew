package us.pinguo.inspire.module.discovery.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.inspire.model.InspireGeo;
import us.pinguo.inspire.module.comment.InspireComment;
/* loaded from: classes9.dex */
public class InspireFeedContent implements Parcelable {
    public static final Parcelable.Creator<InspireFeedContent> CREATOR = new Parcelable.Creator<InspireFeedContent>() { // from class: us.pinguo.inspire.module.discovery.entity.InspireFeedContent.1
        @Override // android.os.Parcelable.Creator
        public InspireFeedContent createFromParcel(Parcel parcel) {
            return new InspireFeedContent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public InspireFeedContent[] newArray(int i2) {
            return new InspireFeedContent[i2];
        }
    };
    public int comCount;
    public List<InspireComment> comments;
    public String desc;
    public String descLang;
    public int flowerSum;
    public InspireGeo geo;
    public int like;
    public int likeCount;
    public List<InspireFeedPhoto> photos;
    public String poi;
    public InspireFeedTask task;
    public int translate;
    public List<InspireFeedVideo> videos;
    public String workId;

    public InspireFeedContent() {
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
        InspireFeedContent inspireFeedContent = (InspireFeedContent) obj;
        if (this.comCount == inspireFeedContent.comCount && this.like == inspireFeedContent.like && this.likeCount == inspireFeedContent.likeCount) {
            InspireFeedTask inspireFeedTask = this.task;
            if (inspireFeedTask == null ? inspireFeedContent.task == null : inspireFeedTask.equals(inspireFeedContent.task)) {
                List<InspireFeedPhoto> list = this.photos;
                if (list == null ? inspireFeedContent.photos == null : list.equals(inspireFeedContent.photos)) {
                    List<InspireFeedVideo> list2 = this.videos;
                    if (list2 == null ? inspireFeedContent.videos == null : list2.equals(inspireFeedContent.videos)) {
                        InspireGeo inspireGeo = this.geo;
                        if (inspireGeo == null ? inspireFeedContent.geo == null : inspireGeo.equals(inspireFeedContent.geo)) {
                            String str = this.desc;
                            if (str == null ? inspireFeedContent.desc == null : str.equals(inspireFeedContent.desc)) {
                                List<InspireComment> list3 = this.comments;
                                if (list3 == null ? inspireFeedContent.comments == null : list3.equals(inspireFeedContent.comments)) {
                                    String str2 = this.workId;
                                    String str3 = inspireFeedContent.workId;
                                    return str2 != null ? str2.equals(str3) : str3 == null;
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

    public String getLocation() {
        if (!TextUtils.isEmpty(this.poi)) {
            return this.poi;
        }
        InspireGeo inspireGeo = this.geo;
        return inspireGeo == null ? "" : inspireGeo.toString();
    }

    public int hashCode() {
        InspireFeedTask inspireFeedTask = this.task;
        int hashCode = (inspireFeedTask != null ? inspireFeedTask.hashCode() : 0) * 31;
        List<InspireFeedPhoto> list = this.photos;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<InspireFeedVideo> list2 = this.videos;
        int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
        InspireGeo inspireGeo = this.geo;
        int hashCode4 = (hashCode3 + (inspireGeo != null ? inspireGeo.hashCode() : 0)) * 31;
        String str = this.desc;
        int hashCode5 = (((((((hashCode4 + (str != null ? str.hashCode() : 0)) * 31) + this.comCount) * 31) + this.like) * 31) + this.likeCount) * 31;
        List<InspireComment> list3 = this.comments;
        int hashCode6 = (hashCode5 + (list3 != null ? list3.hashCode() : 0)) * 31;
        String str2 = this.workId;
        return hashCode6 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.task, i2);
        parcel.writeList(this.photos);
        parcel.writeList(this.videos);
        parcel.writeParcelable(this.geo, 0);
        parcel.writeString(this.desc);
        parcel.writeInt(this.comCount);
        parcel.writeInt(this.like);
        parcel.writeInt(this.likeCount);
        parcel.writeList(this.comments);
        parcel.writeString(this.workId);
        parcel.writeInt(this.flowerSum);
    }

    protected InspireFeedContent(Parcel parcel) {
        this.task = (InspireFeedTask) parcel.readParcelable(InspireFeedTask.class.getClassLoader());
        ArrayList arrayList = new ArrayList();
        this.photos = arrayList;
        parcel.readList(arrayList, List.class.getClassLoader());
        ArrayList arrayList2 = new ArrayList();
        this.videos = arrayList2;
        parcel.readList(arrayList2, List.class.getClassLoader());
        this.geo = (InspireGeo) parcel.readParcelable(InspireGeo.class.getClassLoader());
        this.desc = parcel.readString();
        this.comCount = parcel.readInt();
        this.like = parcel.readInt();
        this.likeCount = parcel.readInt();
        ArrayList arrayList3 = new ArrayList();
        this.comments = arrayList3;
        parcel.readList(arrayList3, List.class.getClassLoader());
        this.workId = parcel.readString();
        this.flowerSum = parcel.readInt();
    }
}

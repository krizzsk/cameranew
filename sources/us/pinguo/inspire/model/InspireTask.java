package us.pinguo.inspire.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.foundation.VideoMusic;
import us.pinguo.inspire.module.discovery.entity.dicovery.AuthorInfo;
/* loaded from: classes9.dex */
public class InspireTask implements Parcelable {
    public static final Parcelable.Creator<InspireTask> CREATOR = new Parcelable.Creator<InspireTask>() { // from class: us.pinguo.inspire.model.InspireTask.1
        @Override // android.os.Parcelable.Creator
        public InspireTask createFromParcel(Parcel parcel) {
            return new InspireTask(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public InspireTask[] newArray(int i2) {
            return new InspireTask[i2];
        }
    };
    public static final int MUSIC_TYPE_LIMIT = 3;
    public static final int MUSIC_TYPE_NO = 2;
    public static final int MUSIC_TYPE_NO_LIMIT = 1;
    public static final int SPECIAL_EFFECT_FLASH_BACK = 4;
    public static final int SPECIAL_EFFECT_KICHIKU = 1;
    public static final int SPECIAL_EFFECT_NULL = 0;
    public static final int SPECIAL_EFFECT_QUICK_ACTION = 2;
    public static final int SPECIAL_EFFECT_SLOW_ACTION = 3;
    public static final int TYPE_PHOTO_MV = 5;
    public static final int TYPE_PHOTO_NEW = 4;
    public static final int TYPE_PHOTO_OLD = 1;
    public static final int TYPE_VIDEO_NEW = 3;
    public static final int TYPE_VIDEO_OLD = 2;
    public List<AuthorInfo> authorInfo;
    public List<String> avatars;
    public InspireAward award;
    public long beginTime;
    public int bgMusicType;
    public String cover;
    public int cpoint;
    public long createTime;
    public DailyAward dailyAward;
    public String desc;
    public long endTime;
    public Endpage endpage;
    public int endpageMode;
    public boolean finished;
    public List<VideoMusic> fixedMusic;
    public String guide;
    public String icon;
    public Influencer influencer;
    public int isInfluencer;
    public JoinStatus isJoin;
    @com.google.gson.s.b(us.pinguo.foundation.utils.g.class)
    public boolean isPlay;
    public String language;
    public int picSum;
    public List<InspireWork> rankingList;
    public List<InspirePhoto> recommend;
    public int remainingDays;
    public String sceneGotoUrl;
    public SceneParam sceneParam;
    public int score;
    public String shareDescription;
    public String shareTitle;
    public String shortDesc;
    public int sort;
    public int specialEffect;
    public String taskCover;
    public String taskGotoUrl;
    public String taskId;
    public int taskMode;
    public String taskName;
    public int taskType;
    public String videoUrl;
    public int watchSum;
    public List<InspireWork> work;
    public int worksStatus;

    public InspireTask() {
        this.recommend = new ArrayList();
        this.work = new ArrayList();
        this.watchSum = 0;
        this.avatars = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InspireTask) {
            InspireTask inspireTask = (InspireTask) obj;
            String str = this.taskId;
            if (str != null) {
                if (str.equals(inspireTask.taskId) && this.language.equals(inspireTask.language)) {
                    return true;
                }
            } else if (inspireTask.taskId == null) {
                return true;
            }
            return false;
        }
        return false;
    }

    public String getDiffId() {
        return this.taskId;
    }

    public int hashCode() {
        String str = this.taskId;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public boolean isNewTask() {
        int i2 = this.taskType;
        return i2 == 3 || i2 == 4 || i2 == 5;
    }

    public boolean isVideo() {
        int i2 = this.taskType;
        return i2 == 3 || i2 == 2 || i2 == 5;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.taskMode);
        parcel.writeInt(this.isInfluencer);
        parcel.writeInt(this.endpageMode);
        parcel.writeParcelable(this.influencer, 0);
        parcel.writeParcelable(this.endpage, 0);
        parcel.writeString(this.taskId);
        parcel.writeString(this.taskName);
        parcel.writeString(this.icon);
        parcel.writeString(this.cover);
        parcel.writeString(this.desc);
        parcel.writeInt(this.picSum);
        parcel.writeInt(this.sort);
        parcel.writeLong(this.beginTime);
        parcel.writeLong(this.endTime);
        parcel.writeByte(this.finished ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.award, i2);
        parcel.writeTypedList(this.recommend);
        parcel.writeTypedList(this.work);
        parcel.writeList(this.authorInfo);
        parcel.writeLong(this.createTime);
        parcel.writeString(this.taskCover);
        parcel.writeString(this.shortDesc);
        parcel.writeString(this.language);
        parcel.writeInt(this.remainingDays);
        parcel.writeInt(this.cpoint);
        parcel.writeInt(this.score);
        parcel.writeParcelable(this.dailyAward, i2);
        parcel.writeInt(this.watchSum);
        parcel.writeString(this.sceneGotoUrl);
        parcel.writeString(this.shareTitle);
        parcel.writeString(this.shareDescription);
        parcel.writeParcelable(this.sceneParam, i2);
        parcel.writeString(this.videoUrl);
        parcel.writeInt(this.taskType);
        parcel.writeString(this.guide);
        parcel.writeInt(this.worksStatus);
        parcel.writeStringList(this.avatars);
        parcel.writeParcelable(this.isJoin, i2);
        parcel.writeList(this.rankingList);
        parcel.writeInt(this.isPlay ? 1 : 0);
        parcel.writeString(this.taskGotoUrl);
        parcel.writeInt(this.specialEffect);
        parcel.writeTypedList(this.fixedMusic);
        parcel.writeInt(this.bgMusicType);
    }

    protected InspireTask(Parcel parcel) {
        this.recommend = new ArrayList();
        this.work = new ArrayList();
        this.watchSum = 0;
        this.avatars = new ArrayList();
        this.taskMode = parcel.readInt();
        this.isInfluencer = parcel.readInt();
        this.endpageMode = parcel.readInt();
        this.influencer = (Influencer) parcel.readParcelable(Influencer.class.getClassLoader());
        this.endpage = (Endpage) parcel.readParcelable(Endpage.class.getClassLoader());
        this.taskId = parcel.readString();
        this.taskName = parcel.readString();
        this.icon = parcel.readString();
        this.cover = parcel.readString();
        this.desc = parcel.readString();
        this.picSum = parcel.readInt();
        this.sort = parcel.readInt();
        this.beginTime = parcel.readLong();
        this.endTime = parcel.readLong();
        this.finished = parcel.readByte() != 0;
        this.award = (InspireAward) parcel.readParcelable(InspireAward.class.getClassLoader());
        this.recommend = parcel.createTypedArrayList(InspirePhoto.CREATOR);
        this.work = parcel.createTypedArrayList(InspireWork.CREATOR);
        ArrayList arrayList = new ArrayList();
        this.authorInfo = arrayList;
        parcel.readList(arrayList, AuthorInfo.class.getClassLoader());
        this.createTime = parcel.readLong();
        this.taskCover = parcel.readString();
        this.shortDesc = parcel.readString();
        this.language = parcel.readString();
        this.remainingDays = parcel.readInt();
        this.cpoint = parcel.readInt();
        this.score = parcel.readInt();
        this.dailyAward = (DailyAward) parcel.readParcelable(DailyAward.class.getClassLoader());
        this.watchSum = parcel.readInt();
        this.sceneGotoUrl = parcel.readString();
        this.shareTitle = parcel.readString();
        this.shareDescription = parcel.readString();
        this.sceneParam = (SceneParam) parcel.readParcelable(SceneParam.class.getClassLoader());
        this.videoUrl = parcel.readString();
        this.taskType = parcel.readInt();
        this.guide = parcel.readString();
        this.worksStatus = parcel.readInt();
        this.avatars = parcel.createStringArrayList();
        this.isJoin = (JoinStatus) parcel.readParcelable(JoinStatus.class.getClassLoader());
        ArrayList arrayList2 = new ArrayList();
        this.rankingList = arrayList2;
        parcel.readList(arrayList2, InspireWork.class.getClassLoader());
        this.isPlay = parcel.readInt() == 1;
        this.taskGotoUrl = parcel.readString();
        this.specialEffect = parcel.readInt();
        this.fixedMusic = parcel.createTypedArrayList(VideoMusic.CREATOR);
        this.bgMusicType = parcel.readInt();
    }
}

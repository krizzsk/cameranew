package us.pinguo.inspire.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.zhy.android.percent.support.PercentLayoutHelper;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.foundation.VideoMusic;
import us.pinguo.foundation.utils.u;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.api.EmptyResponse;
import us.pinguo.inspire.api.Payload;
import us.pinguo.inspire.module.comment.CommentLoader;
import us.pinguo.inspire.module.comment.OtherInfo;
import us.pinguo.inspire.module.discovery.entity.dicovery.AuthorInfo;
import us.pinguo.inspire.module.discovery.fragment.DiscoveryHotVideoFragment;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
import us.pinguo.user.model.IRelation;
import us.pinguo.user.s0;
/* loaded from: classes9.dex */
public class InspireWork extends InspirePhoto implements us.pinguo.inspire.widget.like.a, IRelation {
    public static final us.pinguo.inspire.a0.i<InspireWork> CREATOR = new us.pinguo.inspire.a0.i<InspireWork>() { // from class: us.pinguo.inspire.model.InspireWork.6
        @Override // us.pinguo.inspire.a0.i
        public Type getType() {
            return InspireWork.class;
        }

        @Override // us.pinguo.inspire.a0.i, android.os.Parcelable.Creator
        public InspireWork createFromParcel(Parcel parcel) {
            InspireWork inspireWork = new InspireWork();
            inspireWork.picUrl = parcel.readString();
            inspireWork.width = parcel.readInt();
            inspireWork.height = parcel.readInt();
            inspireWork.creator = parcel.readString();
            inspireWork.desc = parcel.readString();
            inspireWork.exif = parcel.readString();
            inspireWork.taskId = parcel.readString();
            inspireWork.exifTime = parcel.readString();
            ArrayList arrayList = new ArrayList();
            inspireWork.tags = arrayList;
            parcel.readList(arrayList, getClass().getClassLoader());
            inspireWork.etag = parcel.readString();
            inspireWork.picId = parcel.readString();
            inspireWork.authorId = parcel.readString();
            inspireWork.uploadTime = parcel.readLong();
            inspireWork.voteSum = parcel.readInt();
            inspireWork.watchSum = parcel.readInt();
            inspireWork.ranking = parcel.readInt();
            inspireWork.geo = (InspireGeo) parcel.readParcelable(getClass().getClassLoader());
            inspireWork.authorName = parcel.readString();
            inspireWork.authorAvatar = parcel.readString();
            inspireWork.pageNum = parcel.readInt();
            inspireWork.taskInfo = (TaskInfo) parcel.readParcelable(getClass().getClassLoader());
            inspireWork.collect = parcel.readByte() != 0;
            inspireWork.workType = parcel.readInt();
            inspireWork.duration = parcel.readString();
            inspireWork.vId = parcel.readString();
            inspireWork.videoUrl = parcel.readString();
            inspireWork.workUrl = parcel.readString();
            inspireWork.members = parcel.createTypedArrayList(WorkMember.CREATOR);
            inspireWork.workId = parcel.readString();
            inspireWork.like = parcel.readInt();
            inspireWork.authorRelation = parcel.readInt();
            inspireWork.authorType = parcel.readInt();
            inspireWork.mockRotation = parcel.readInt();
            inspireWork.translate = parcel.readInt();
            inspireWork.descLang = parcel.readString();
            inspireWork.isDemo = parcel.readInt() == 1;
            inspireWork.isKing = parcel.readInt() == 1;
            inspireWork.isAd = parcel.readByte() == 1;
            inspireWork.webpUrl = parcel.readString();
            inspireWork.shareSum = parcel.readInt();
            inspireWork.authorInfo = (AuthorInfo) parcel.readParcelable(AuthorInfo.class.getClassLoader());
            inspireWork.nationalFlag = parcel.readString();
            inspireWork.authorRanking = parcel.readInt();
            inspireWork.flowerSum = parcel.readInt();
            return inspireWork;
        }

        @Override // us.pinguo.inspire.a0.i, android.os.Parcelable.Creator
        public InspireWork[] newArray(int i2) {
            return new InspireWork[i2];
        }

        @Override // us.pinguo.inspire.a0.i
        public InspireWork newInstance() {
            return new InspireWork();
        }
    };
    public static final int WORK_TYPE_PHOTO = 1;
    public static final int WORK_TYPE_PHOTO_MUILTY = 3;
    public static final int WORK_TYPE_VIDEO = 2;
    public String authorAvatar;
    public String authorId;
    public AuthorInfo authorInfo;
    public int authorMark;
    public String authorName;
    public int authorRanking;
    public int authorRelation;
    public int authorType;
    public int citySum;
    public boolean collect;
    public CommentLoader.CommentAndLike commentAndLike;
    public int commentSum;
    public int ctype;
    public String descLang;
    public String duration;
    public String etag;
    public String exif;
    public String exifTime;
    public int flowerSum;
    public InspireGeo geo;
    public HomePageHeaderInfo homePageInfo;
    public boolean isAd;
    @com.google.gson.s.b(us.pinguo.foundation.utils.g.class)
    public boolean isDemo;
    @com.google.gson.s.b(us.pinguo.foundation.utils.g.class)
    public boolean isKing;
    public transient boolean isLocalData;
    public int like;
    public int likeSum;
    public String map;
    public InspirePoint member;
    public List<WorkMember> members;
    public int mockRotation;
    public String nationalFlag;
    public ChallengeComment officialComment;
    public OtherInfo otherInfo;
    public int pageNum;
    String picId;
    public String poi;
    public int ranking;
    public int shareSum;
    public String stickerId = "";
    public List<String> tags;
    public String taskId;
    public TaskInfo taskInfo;
    public int translate;
    public long uploadTime;
    String vId;
    public String videoUrl;
    public int voteSum;
    public int watchSum;
    public String webpUrl;
    public String workId;
    public int workType;
    public String workUrl;

    /* loaded from: classes9.dex */
    public static class BanData {
        public String tips;
        public int type;
    }

    /* loaded from: classes9.dex */
    public static class ChallengeComment {
        public String avatar;
        public String content;
        public String desc;

        public boolean isEmpty() {
            return TextUtils.isEmpty(this.avatar) && TextUtils.isEmpty(this.content) && TextUtils.isEmpty(this.desc);
        }
    }

    /* loaded from: classes9.dex */
    public static class TaskInfo implements Parcelable {
        public static final Parcelable.Creator<TaskInfo> CREATOR = new Parcelable.Creator<TaskInfo>() { // from class: us.pinguo.inspire.model.InspireWork.TaskInfo.1
            @Override // android.os.Parcelable.Creator
            public TaskInfo createFromParcel(Parcel parcel) {
                return new TaskInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public TaskInfo[] newArray(int i2) {
                return new TaskInfo[i2];
            }
        };
        public int bgMusicType;
        public Endpage endpage;
        public int endpageMode;
        public boolean finish;
        public boolean finished;
        public List<VideoMusic> fixedMusic;
        public String flowerIcon;
        public String h5GotoUrl;
        public String icon;
        public Influencer influencer;
        public int isInfluencer;
        public JoinStatus isJoin;
        public int picSum;
        public String sceneGotoUrl;
        public String shortDesc;
        public int specialEffect;
        public int taskFinish;
        public String taskId;
        public int taskMode;
        public String taskName;
        public int taskType;
        public int workCount;

        public TaskInfo() {
        }

        public static TaskInfo fromTask(InspireTask inspireTask) {
            TaskInfo taskInfo = new TaskInfo();
            taskInfo.taskMode = inspireTask.taskMode;
            taskInfo.isInfluencer = inspireTask.isInfluencer;
            taskInfo.endpageMode = inspireTask.endpageMode;
            taskInfo.influencer = inspireTask.influencer;
            taskInfo.endpage = inspireTask.endpage;
            taskInfo.taskName = inspireTask.taskName;
            taskInfo.picSum = inspireTask.picSum;
            taskInfo.shortDesc = inspireTask.shortDesc;
            taskInfo.taskFinish = inspireTask.finished ? 1 : 0;
            taskInfo.icon = inspireTask.icon;
            taskInfo.taskId = inspireTask.taskId;
            taskInfo.bgMusicType = inspireTask.bgMusicType;
            taskInfo.fixedMusic = inspireTask.fixedMusic;
            taskInfo.specialEffect = inspireTask.specialEffect;
            taskInfo.sceneGotoUrl = inspireTask.sceneGotoUrl;
            taskInfo.taskType = inspireTask.taskType;
            taskInfo.isJoin = inspireTask.isJoin;
            return taskInfo;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean isFinished() {
            return this.finished || this.taskFinish == 1 || this.finish;
        }

        public InspireTask toTask() {
            InspireTask inspireTask = new InspireTask();
            inspireTask.taskMode = this.taskMode;
            inspireTask.isInfluencer = this.isInfluencer;
            inspireTask.endpageMode = this.endpageMode;
            inspireTask.influencer = this.influencer;
            inspireTask.endpage = this.endpage;
            inspireTask.taskName = this.taskName;
            inspireTask.taskId = this.taskId;
            inspireTask.shortDesc = this.shortDesc;
            inspireTask.finished = this.taskFinish == 1;
            inspireTask.icon = this.icon;
            inspireTask.sceneGotoUrl = this.sceneGotoUrl;
            inspireTask.specialEffect = this.specialEffect;
            inspireTask.bgMusicType = this.bgMusicType;
            inspireTask.fixedMusic = this.fixedMusic;
            inspireTask.taskType = this.taskType;
            inspireTask.isJoin = this.isJoin;
            return inspireTask;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.taskMode);
            parcel.writeInt(this.isInfluencer);
            parcel.writeInt(this.endpageMode);
            parcel.writeParcelable(this.influencer, 0);
            parcel.writeParcelable(this.endpage, 0);
            parcel.writeString(this.taskName);
            parcel.writeInt(this.picSum);
            parcel.writeInt(this.workCount);
            parcel.writeString(this.shortDesc);
            parcel.writeInt(this.taskFinish);
            parcel.writeString(this.icon);
            parcel.writeString(this.taskId);
            parcel.writeString(this.sceneGotoUrl);
            parcel.writeInt(this.specialEffect);
            parcel.writeInt(this.bgMusicType);
            parcel.writeTypedList(this.fixedMusic);
            parcel.writeString(this.h5GotoUrl);
            parcel.writeByte(this.finished ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.finish ? (byte) 1 : (byte) 0);
            parcel.writeString(this.flowerIcon);
            parcel.writeInt(this.taskType);
            parcel.writeParcelable(this.isJoin, 0);
        }

        protected TaskInfo(Parcel parcel) {
            this.taskMode = parcel.readInt();
            this.isInfluencer = parcel.readInt();
            this.endpageMode = parcel.readInt();
            this.influencer = (Influencer) parcel.readParcelable(Influencer.class.getClassLoader());
            this.endpage = (Endpage) parcel.readParcelable(Endpage.class.getClassLoader());
            this.taskName = parcel.readString();
            this.picSum = parcel.readInt();
            this.workCount = parcel.readInt();
            this.shortDesc = parcel.readString();
            this.taskFinish = parcel.readInt();
            this.icon = parcel.readString();
            this.taskId = parcel.readString();
            this.sceneGotoUrl = parcel.readString();
            this.specialEffect = parcel.readInt();
            this.bgMusicType = parcel.readInt();
            this.fixedMusic = parcel.createTypedArrayList(VideoMusic.CREATOR);
            this.h5GotoUrl = parcel.readString();
            this.finished = parcel.readByte() == 1;
            this.finish = parcel.readByte() == 1;
            this.flowerIcon = parcel.readString();
            this.taskType = parcel.readInt();
            this.isJoin = (JoinStatus) parcel.readParcelable(JoinStatus.class.getClassLoader());
        }
    }

    /* loaded from: classes9.dex */
    public static class WorkMember implements Parcelable {
        public static final Parcelable.Creator<WorkMember> CREATOR = new Parcelable.Creator<WorkMember>() { // from class: us.pinguo.inspire.model.InspireWork.WorkMember.1
            @Override // android.os.Parcelable.Creator
            public WorkMember createFromParcel(Parcel parcel) {
                WorkMember workMember = new WorkMember();
                workMember.memId = parcel.readString();
                workMember.memUrl = parcel.readString();
                workMember.authorId = parcel.readString();
                workMember.longitude = parcel.readString();
                workMember.latitude = parcel.readString();
                workMember.etag = parcel.readString();
                workMember.uploadTime = parcel.readLong();
                workMember.width = parcel.readInt();
                workMember.height = parcel.readInt();
                workMember.workType = parcel.readInt();
                workMember.status = parcel.readInt();
                return workMember;
            }

            @Override // android.os.Parcelable.Creator
            public WorkMember[] newArray(int i2) {
                return new WorkMember[i2];
            }
        };
        public String authorId;
        public String etag;
        public int height;
        public String latitude;
        public String longitude;
        public String memId;
        public String memUrl;
        public int status;
        public long uploadTime;
        public int width;
        public int workType;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.memId);
            parcel.writeString(this.memUrl);
            parcel.writeString(this.authorId);
            parcel.writeString(this.longitude);
            parcel.writeString(this.latitude);
            parcel.writeString(this.etag);
            parcel.writeLong(this.uploadTime);
            parcel.writeInt(this.width);
            parcel.writeInt(this.height);
            parcel.writeInt(this.workType);
            parcel.writeInt(this.status);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ Void c(EmptyResponse.Data data) {
        List<InspireWork> list;
        if (this.authorId.equals(s0.getInstance().getUserId())) {
            us.pinguo.common.log.a.m("zhouwei", "delete my work........", new Object[0]);
            MyWorksCache myWorksCache = new MyWorksCache(this.authorId, this.taskId);
            List<InspireWork> a = myWorksCache.wrap().a();
            if (a.contains(this)) {
                us.pinguo.common.log.a.m("zhouwei", "delete my work success........", new Object[0]);
                a.remove(this);
                myWorksCache.wrap().b(a);
            }
        }
        InspireHomePageDiskCache inspireHomePageDiskCache = new InspireHomePageDiskCache(this.authorId);
        InspirePersonalCenterInfo a2 = inspireHomePageDiskCache.wrap().a();
        if (a2 == null || (list = a2.items) == null || list.size() <= 0 || !list.contains(this)) {
            return null;
        }
        list.remove(this);
        a2.items = list;
        inspireHomePageDiskCache.wrap().b(a2);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ BanData f(Throwable th) {
        BanData banData = new BanData();
        banData.type = 0;
        return banData;
    }

    public static String formatNum(int i2) {
        if (u.b()) {
            float f2 = i2;
            return f2 >= 1000000.0f ? String.format(Locale.getDefault(), "%.1fm", Float.valueOf(f2 / 1000000.0f)) : i2 >= 10000 ? String.format(Locale.getDefault(), "%.1fW", Float.valueOf(f2 / 10000.0f)) : i2 >= 1000 ? String.format(Locale.getDefault(), "%.1fk", Float.valueOf(f2 / 1000.0f)) : String.valueOf(i2);
        } else if (i2 < 10000) {
            return String.valueOf(i2);
        } else {
            return i2 < 1000000 ? String.format(Locale.getDefault(), "%.1fk", Float.valueOf(i2 / 1000.0f)) : String.format(Locale.getDefault(), "%.1fm", Float.valueOf(i2 / 1000000.0f));
        }
    }

    @Deprecated
    private String getDeprecatedWorkId() {
        if (isVideo()) {
            return this.vId;
        }
        return this.picId;
    }

    public static String getTop(InspireWork inspireWork) {
        TaskInfo taskInfo = inspireWork.taskInfo;
        int i2 = taskInfo != null ? taskInfo.picSum : -1;
        int i3 = inspireWork.ranking;
        int i4 = (int) ((1.0f - (i3 / i2)) * 100.0f);
        int i5 = 0;
        if (i4 < 0) {
            i4 = 0;
        }
        int i6 = 1;
        if (i3 != 0 && i2 != -1) {
            i5 = i3 == 1 ? 100 : i4;
        }
        int i7 = 100 - i5;
        if (i7 >= 100) {
            i6 = 99;
        } else if (i7 >= 1) {
            i6 = i7;
        }
        return "TOP " + i6 + PercentLayoutHelper.PercentLayoutInfo.BASEMODE.PERCENT;
    }

    public static int getTopValue(InspireWork inspireWork) {
        TaskInfo taskInfo = inspireWork.taskInfo;
        int i2 = taskInfo != null ? taskInfo.picSum : -1;
        int i3 = inspireWork.ranking;
        int i4 = (int) ((1.0f - (i3 / i2)) * 100.0f);
        int i5 = 0;
        if (i4 < 0) {
            i4 = 0;
        }
        if (i3 != 0 && i2 != -1) {
            i5 = i3 == 1 ? 100 : i4;
        }
        int i6 = 100 - i5;
        if (i6 >= 100) {
            return 99;
        }
        if (i6 < 1) {
            return 1;
        }
        return i6;
    }

    public static Observable<BanData> isBanned() {
        return us.pinguo.foundation.m.f.f(new Inspire.d<BaseResponse<BanData>>() { // from class: us.pinguo.inspire.model.InspireWork.5
        }.url("/user/ban").build()).map(new Payload()).onErrorReturn(n.a);
    }

    public Observable<Boolean> accuse() {
        return us.pinguo.foundation.m.f.f(new Inspire.d<EmptyResponse>() { // from class: us.pinguo.inspire.model.InspireWork.1
        }.url("/user/Accusation").put("picId", getWorkId()).put(GuestProfileFragment.USER_ID, s0.getInstance().getUserId()).put("taskId", this.taskId).build()).map(o.a);
    }

    public void copyMockData(InspireWork inspireWork) {
        if (inspireWork == null) {
            return;
        }
        this.mockRotation = inspireWork.mockRotation;
        this.translate = inspireWork.translate;
        this.descLang = inspireWork.descLang;
        if (inspireWork.isTaskFinished()) {
            setTaskFinished();
        }
        InspireGeo inspireGeo = this.geo;
        if (inspireGeo == null || TextUtils.isEmpty(inspireGeo.toString())) {
            this.geo = inspireWork.geo;
            StringBuilder sb = new StringBuilder();
            sb.append("详情地理位置为空，使用来自feed的地理位置:");
            InspireGeo inspireGeo2 = inspireWork.geo;
            sb.append(inspireGeo2 == null ? "null" : inspireGeo2.toString());
            us.pinguo.common.log.a.k(sb.toString(), new Object[0]);
        }
    }

    public Observable<Void> delete() {
        return us.pinguo.foundation.m.f.a(new Inspire.d<EmptyResponse>() { // from class: us.pinguo.inspire.model.InspireWork.2
        }.url("/pic/deletePic").put("taskId", this.taskId).put("picId", getWorkId()).build()).map(new Payload()).map(new Func1() { // from class: us.pinguo.inspire.model.m
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return InspireWork.this.c((EmptyResponse.Data) obj);
            }
        }).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Boolean> disLike() {
        return us.pinguo.foundation.m.f.f(new Inspire.d<BaseResponse<Boolean>>() { // from class: us.pinguo.inspire.model.InspireWork.4
        }.url("/comment/like/del").put(DiscoveryHotVideoFragment.WORK_ID, getWorkId()).build()).map(new Payload());
    }

    @Override // us.pinguo.inspire.model.InspirePhoto
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InspireWork) {
            InspireWork inspireWork = (InspireWork) obj;
            String str = this.taskId;
            if (str == null ? inspireWork.taskId == null : str.equals(inspireWork.taskId)) {
                String str2 = this.workId;
                String str3 = inspireWork.workId;
                return str2 != null ? str2.equals(str3) : str3 == null;
            }
            return false;
        }
        return false;
    }

    public String getAddress() {
        if (TextUtils.isEmpty(this.poi)) {
            InspireGeo inspireGeo = this.geo;
            return inspireGeo == null ? "" : inspireGeo.toString();
        }
        return this.poi;
    }

    public String getAvatar() {
        AuthorInfo authorInfo = this.authorInfo;
        if (authorInfo != null && !TextUtils.isEmpty(authorInfo.avatar)) {
            return this.authorInfo.avatar;
        }
        return this.authorAvatar;
    }

    public String getDiffId() {
        return this.workId;
    }

    public int getHeight() {
        int i2 = this.height;
        if (i2 != 0) {
            return i2;
        }
        if (!isMulityPhotos() || us.pinguo.foundation.utils.k.a(this.members) || this.members.get(0).height == 0) {
            return 0;
        }
        return this.members.get(0).height;
    }

    public int getMembersCount() {
        if (this.workType != 3) {
            return 1;
        }
        if (us.pinguo.foundation.utils.k.a(this.members)) {
            return 0;
        }
        return this.members.size();
    }

    public String getNickName() {
        AuthorInfo authorInfo = this.authorInfo;
        if (authorInfo != null && !TextUtils.isEmpty(authorInfo.nickname)) {
            return this.authorInfo.nickname;
        }
        return this.authorName;
    }

    @Override // us.pinguo.user.model.IRelation
    public int getRelation() {
        AuthorInfo authorInfo = this.authorInfo;
        if (authorInfo == null) {
            return this.authorRelation;
        }
        int i2 = authorInfo.relation;
        return i2 == 0 ? this.authorRelation : i2;
    }

    public int getWidth() {
        int i2 = this.width;
        if (i2 != 0) {
            return i2;
        }
        if (!isMulityPhotos() || us.pinguo.foundation.utils.k.a(this.members) || this.members.get(0).width == 0) {
            return 0;
        }
        return this.members.get(0).width;
    }

    public String getWorkId() {
        return TextUtils.isEmpty(this.workId) ? getDeprecatedWorkId() : this.workId;
    }

    public String getWorkUrl() {
        if (TextUtils.isEmpty(this.workUrl)) {
            if (isVideo()) {
                return this.workUrl;
            }
            if (isMulityPhotos()) {
                if (!us.pinguo.foundation.utils.k.a(this.members) && !TextUtils.isEmpty(this.members.get(0).memUrl)) {
                    return this.members.get(0).memUrl;
                }
            } else {
                return this.picUrl;
            }
        }
        return this.workUrl;
    }

    @Override // us.pinguo.inspire.model.InspirePhoto
    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.taskId;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.workId;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public boolean isKingWork() {
        return this.ctype == 5;
    }

    @Override // us.pinguo.inspire.widget.like.a
    public boolean isLiked() {
        return this.like == 1;
    }

    public boolean isMulityPhotos() {
        return this.workType == 3;
    }

    public boolean isSWork() {
        return this.ctype == 4;
    }

    public boolean isTaskFinished() {
        TaskInfo taskInfo = this.taskInfo;
        return taskInfo != null && taskInfo.isFinished();
    }

    public boolean isTaskWork() {
        return !TextUtils.isEmpty(this.taskId);
    }

    public boolean isVideo() {
        return this.workType == 2;
    }

    public Observable<Boolean> like() {
        return us.pinguo.foundation.m.f.f(new Inspire.d<BaseResponse<Boolean>>() { // from class: us.pinguo.inspire.model.InspireWork.3
        }.url("/comment/like/add").put(DiscoveryHotVideoFragment.WORK_ID, getWorkId()).build()).map(new Payload());
    }

    public boolean needTranslate() {
        return this.translate == 1;
    }

    @Override // us.pinguo.inspire.widget.like.a
    public void setLikeState(boolean z) {
        this.like = z ? 1 : 0;
    }

    public void setPicId(String str) {
        this.picId = str;
    }

    @Override // us.pinguo.user.model.IRelation
    public void setRelation(int i2) {
        this.authorRelation = i2;
        AuthorInfo authorInfo = this.authorInfo;
        if (authorInfo != null) {
            authorInfo.relation = i2;
        }
    }

    public void setTaskFinished() {
        TaskInfo taskInfo = this.taskInfo;
        if (taskInfo != null) {
            taskInfo.taskFinish = 1;
        }
    }

    public void setVideoId(String str) {
        this.vId = str;
    }

    @Override // us.pinguo.inspire.model.InspirePhoto, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.exif);
        parcel.writeString(this.taskId);
        parcel.writeString(this.exifTime);
        parcel.writeList(this.tags);
        parcel.writeString(this.etag);
        parcel.writeString(this.picId);
        parcel.writeString(this.authorId);
        parcel.writeLong(this.uploadTime);
        parcel.writeInt(this.voteSum);
        parcel.writeInt(this.watchSum);
        parcel.writeInt(this.ranking);
        parcel.writeParcelable(this.geo, i2);
        parcel.writeString(this.authorName);
        parcel.writeString(this.authorAvatar);
        parcel.writeInt(this.pageNum);
        parcel.writeParcelable(this.taskInfo, i2);
        parcel.writeByte(this.collect ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.workType);
        parcel.writeString(this.duration);
        parcel.writeString(this.vId);
        parcel.writeString(this.videoUrl);
        parcel.writeString(this.workUrl);
        parcel.writeTypedList(this.members);
        parcel.writeString(this.workId);
        parcel.writeInt(this.like);
        parcel.writeInt(this.authorRelation);
        parcel.writeInt(this.authorType);
        parcel.writeInt(this.mockRotation);
        parcel.writeInt(this.translate);
        parcel.writeString(this.descLang);
        parcel.writeInt(this.isDemo ? 1 : 0);
        parcel.writeInt(this.isKing ? 1 : 0);
        parcel.writeInt(this.isAd ? 1 : 0);
        parcel.writeString(this.webpUrl);
        parcel.writeInt(this.shareSum);
        parcel.writeParcelable(this.authorInfo, i2);
        parcel.writeString(this.nationalFlag);
        parcel.writeInt(this.authorRanking);
        parcel.writeInt(this.flowerSum);
    }
}

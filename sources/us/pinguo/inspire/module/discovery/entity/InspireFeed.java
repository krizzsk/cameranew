package us.pinguo.inspire.module.discovery.entity;

import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.admobvista.DataBean.InputAdvItem;
import us.pinguo.common.log.a;
import us.pinguo.foundation.statistics.FeedStat;
import us.pinguo.foundation.utils.k;
import us.pinguo.inspire.model.InspireGeo;
import us.pinguo.inspire.model.InspireTask;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.module.contact.entry.Recommend;
import us.pinguo.inspire.module.discovery.entity.dicovery.AuthorInfo;
import us.pinguo.inspire.module.discovery.entity.dicovery.DiscoveryFixedItem;
import us.pinguo.inspire.module.feeds.model.InspireCompositeCnt;
import us.pinguo.inspire.module.feeds.model.LiveCnt;
import us.pinguo.inspire.module.message.category.type.InspireRelation;
import us.pinguo.inspire.module.publish.vo.PublishData;
import us.pinguo.librouter.c.d;
import us.pinguo.user.s0;
/* loaded from: classes9.dex */
public class InspireFeed implements Parcelable {
    public static final Parcelable.Creator<InspireFeed> CREATOR = new Parcelable.Creator<InspireFeed>() { // from class: us.pinguo.inspire.module.discovery.entity.InspireFeed.1
        @Override // android.os.Parcelable.Creator
        public InspireFeed createFromParcel(Parcel parcel) {
            return new InspireFeed(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public InspireFeed[] newArray(int i2) {
            return new InspireFeed[i2];
        }
    };
    private static final String FILE_HEADER = "file://";
    public static final String TYPE_AD = "dispatcher";
    public static final String TYPE_DYNAMIC = "followLike";
    public static final String TYPE_HOTVIDEO = "hotVideo";
    public static final String TYPE_LAST_TASK = "latestTask";
    public static final String TYPE_LIVE = "live";
    public static final String TYPE_MULTI = "multi";
    public static final String TYPE_PHOTO = "photo";
    public static final String TYPE_RECUSER = "recUser";
    public static final String TYPE_TASK = "task";
    public static final String TYPE_VIDEO = "video";
    public String clientId;
    public List<InputAdvItem> data;
    @Deprecated
    public InspireFeedContent fcnt;
    public String fid;
    public InspireCompositeCnt followLikeCnt;
    public DiscoveryFixedItem hvcnt;
    public boolean isMock;
    public InspireTaskCnt latestTaskCnt;
    public LiveCnt liveCnt;
    public InspireFeedContent multiCnt;
    public InspireFeedContent photoCnt;
    public Recommend recUserCnt;
    public InspireFeedSender sender;
    public List<FeedStat> stat;
    public InspireTask taskCnt;
    public long timeline;
    public String type;
    public InspireFeedContent videoCnt;

    public InspireFeed() {
    }

    public static InspireFeed convertPublishDataToFeed(PublishData publishData) {
        InspireFeed inspireFeed = new InspireFeed();
        inspireFeed.clientId = publishData.clientId;
        inspireFeed.isMock = true;
        inspireFeed.fid = "";
        InspireFeedContent inspireFeedContent = new InspireFeedContent();
        InspireGeo inspireGeo = new InspireGeo();
        inspireFeedContent.geo = inspireGeo;
        String str = publishData.poi;
        inspireGeo.city = str;
        inspireFeedContent.poi = str;
        if (publishData.isPhoto) {
            if (!k.a(publishData.filePathes)) {
                if (publishData.filePathes.size() == 1) {
                    inspireFeed.type = "photo";
                    inspireFeed.photoCnt = inspireFeedContent;
                } else {
                    inspireFeed.type = TYPE_MULTI;
                    inspireFeed.multiCnt = inspireFeedContent;
                }
            }
        } else {
            inspireFeed.type = "video";
            inspireFeed.videoCnt = inspireFeedContent;
        }
        inspireFeed.timeline = publishData.clientTimeInMillis;
        InspireFeedSender inspireFeedSender = new InspireFeedSender();
        inspireFeed.sender = inspireFeedSender;
        inspireFeedSender.avatar = s0.getInstance().g();
        inspireFeed.sender.nickname = s0.getInstance().d();
        inspireFeed.sender.relation = InspireRelation.SELF.ordinal();
        inspireFeed.sender.userId = s0.getInstance().getUserId();
        inspireFeedContent.desc = publishData.desc;
        String str2 = inspireFeed.type;
        if (str2 == "photo" || str2 == TYPE_MULTI) {
            inspireFeedContent.photos = new ArrayList();
            List<String> list = publishData.filePathes;
            if (list != null) {
                for (String str3 : list) {
                    InspireFeedPhoto inspireFeedPhoto = new InspireFeedPhoto();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(str3, options);
                    inspireFeedPhoto.width = options.outWidth;
                    inspireFeedPhoto.height = options.outHeight;
                    inspireFeedPhoto.url = "file://" + str3;
                    inspireFeedContent.photos.add(inspireFeedPhoto);
                }
            }
        } else if (str2 == "video") {
            inspireFeedContent.videos = new ArrayList();
            List<String> list2 = publishData.filePathes;
            if (list2 != null) {
                for (String str4 : list2) {
                    InspireFeedVideo inspireFeedVideo = new InspireFeedVideo();
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(str4);
                    String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
                    if (!TextUtils.isEmpty(extractMetadata)) {
                        inspireFeedVideo.width = Integer.parseInt(extractMetadata);
                    }
                    String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                    if (!TextUtils.isEmpty(extractMetadata)) {
                        inspireFeedVideo.height = Integer.parseInt(extractMetadata2);
                    }
                    inspireFeedVideo.url = "file://" + str4;
                    long currentTimeMillis = System.currentTimeMillis();
                    int f2 = d.b().getInterface().f(str4);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    a.k("rotation:" + f2 + " 耗时:" + (currentTimeMillis2 - currentTimeMillis) + "ms", new Object[0]);
                    inspireFeedVideo.mockRotation = f2;
                    inspireFeedContent.videos.add(inspireFeedVideo);
                }
            }
        }
        return inspireFeed;
    }

    public static InspireFeed convertVideoToFeed(InspireWork inspireWork) {
        InspireFeed inspireFeed = new InspireFeed();
        InspireFeedSender inspireFeedSender = new InspireFeedSender();
        inspireFeed.sender = inspireFeedSender;
        AuthorInfo authorInfo = inspireWork.authorInfo;
        inspireFeedSender.avatar = authorInfo.avatar;
        inspireFeedSender.nickname = authorInfo.nickname;
        inspireFeedSender.relation = authorInfo.relation;
        inspireFeedSender.mark = authorInfo.mark;
        inspireFeedSender.userId = inspireWork.authorId;
        InspireFeedContent inspireFeedContent = new InspireFeedContent();
        inspireFeed.videoCnt = inspireFeedContent;
        inspireFeedContent.desc = inspireWork.desc;
        inspireFeedContent.likeCount = inspireWork.likeSum;
        inspireFeedContent.like = inspireWork.like;
        inspireFeedContent.geo = inspireWork.geo;
        inspireFeedContent.poi = inspireWork.poi;
        inspireFeedContent.videos = new ArrayList();
        InspireFeedVideo inspireFeedVideo = new InspireFeedVideo();
        inspireFeedVideo.url = inspireWork.workUrl;
        inspireFeedVideo.width = inspireWork.width;
        inspireFeedVideo.height = inspireWork.height;
        inspireFeed.videoCnt.videos.add(inspireFeedVideo);
        inspireFeed.videoCnt.workId = inspireWork.workId;
        inspireFeed.timeline = inspireWork.uploadTime;
        inspireFeed.type = "video";
        return inspireFeed;
    }

    public static InspireFeed convertWorkToFeed(InspireWork inspireWork) {
        if (inspireWork == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        InspireFeed inspireFeed = new InspireFeed();
        InspireFeedSender inspireFeedSender = new InspireFeedSender();
        inspireFeed.sender = inspireFeedSender;
        AuthorInfo authorInfo = inspireWork.authorInfo;
        if (authorInfo != null) {
            inspireFeedSender.avatar = authorInfo.avatar;
            inspireFeedSender.nickname = authorInfo.nickname;
            inspireFeedSender.relation = authorInfo.relation;
            inspireFeedSender.mark = authorInfo.mark;
            inspireFeedSender.type = authorInfo.type;
        } else {
            inspireFeedSender.avatar = inspireWork.authorAvatar;
            inspireFeedSender.nickname = inspireWork.authorName;
            inspireFeedSender.relation = inspireWork.authorRelation;
            inspireFeedSender.type = inspireWork.authorType;
            inspireFeedSender.mark = inspireWork.authorMark;
        }
        inspireFeedSender.userId = inspireWork.authorId;
        InspireFeedContent inspireFeedContent = new InspireFeedContent();
        inspireFeedContent.workId = inspireWork.workId;
        inspireFeedContent.desc = inspireWork.desc;
        inspireFeedContent.likeCount = inspireWork.likeSum;
        inspireFeedContent.comCount = inspireWork.commentSum;
        inspireFeedContent.like = inspireWork.like;
        inspireFeedContent.geo = inspireWork.geo;
        inspireFeedContent.poi = inspireWork.poi;
        int i2 = inspireWork.workType;
        if (i2 == 1) {
            inspireFeed.photoCnt = inspireFeedContent;
            InspireFeedPhoto inspireFeedPhoto = new InspireFeedPhoto();
            inspireFeedPhoto.vid = inspireWork.workId;
            inspireFeedPhoto.url = inspireWork.workUrl;
            inspireFeedPhoto.width = inspireWork.width;
            inspireFeedPhoto.height = inspireWork.height;
            inspireFeed.photoCnt.photos = new ArrayList();
            inspireFeed.photoCnt.photos.add(inspireFeedPhoto);
            inspireFeed.type = "photo";
            inspireFeed.photoCnt.flowerSum = inspireWork.flowerSum;
        } else if (i2 == 2) {
            inspireFeed.videoCnt = inspireFeedContent;
            InspireFeedVideo inspireFeedVideo = new InspireFeedVideo();
            inspireFeedVideo.vid = inspireWork.workId;
            inspireFeedVideo.url = inspireWork.workUrl;
            inspireFeedVideo.width = inspireWork.width;
            inspireFeedVideo.height = inspireWork.height;
            inspireFeed.videoCnt.videos = new ArrayList();
            inspireFeed.videoCnt.videos.add(inspireFeedVideo);
            InspireFeedContent inspireFeedContent2 = inspireFeed.videoCnt;
            inspireFeedContent2.workId = inspireWork.workId;
            inspireFeed.type = "video";
            inspireFeedContent2.flowerSum = inspireWork.flowerSum;
        } else if (i2 == 3) {
            inspireFeed.multiCnt = inspireFeedContent;
            inspireFeedContent.photos = new ArrayList();
            List<InspireWork.WorkMember> list = inspireWork.members;
            if (list != null) {
                for (InspireWork.WorkMember workMember : list) {
                    InspireFeedPhoto inspireFeedPhoto2 = new InspireFeedPhoto();
                    inspireFeedPhoto2.vid = inspireWork.workId;
                    inspireFeedPhoto2.url = workMember.memUrl;
                    inspireFeedPhoto2.width = workMember.width;
                    inspireFeedPhoto2.height = workMember.height;
                    inspireFeed.multiCnt.photos.add(inspireFeedPhoto2);
                }
            }
            inspireFeed.type = TYPE_MULTI;
            inspireFeed.multiCnt.flowerSum = inspireWork.flowerSum;
        }
        inspireFeed.timeline = inspireWork.uploadTime;
        long currentTimeMillis2 = System.currentTimeMillis();
        InspireFeedContent fcnt = inspireFeed.getFcnt();
        if (fcnt != null && !TextUtils.isEmpty(inspireWork.taskId)) {
            InspireFeedTask inspireFeedTask = new InspireFeedTask();
            fcnt.task = inspireFeedTask;
            inspireFeedTask.taskId = inspireWork.taskId;
            InspireWork.TaskInfo taskInfo = inspireWork.taskInfo;
            if (taskInfo != null) {
                inspireFeedTask.taskFinish = taskInfo.taskFinish;
                inspireFeedTask.taskName = taskInfo.taskName;
            }
        }
        if (fcnt != null) {
            fcnt.translate = inspireWork.translate;
            fcnt.descLang = inspireWork.descLang;
        }
        a.m("FUCK", "covert one entry cost time:" + (currentTimeMillis2 - currentTimeMillis), new Object[0]);
        return inspireFeed;
    }

    public InspireWork convertFeedToWork() {
        InspireWork inspireWork = new InspireWork();
        if (this.sender != null) {
            AuthorInfo authorInfo = new AuthorInfo();
            inspireWork.authorInfo = authorInfo;
            InspireFeedSender inspireFeedSender = this.sender;
            String str = inspireFeedSender.avatar;
            authorInfo.avatar = str;
            String str2 = inspireFeedSender.nickname;
            authorInfo.nickname = str2;
            int i2 = inspireFeedSender.relation;
            authorInfo.relation = i2;
            int i3 = inspireFeedSender.type;
            authorInfo.type = i3;
            inspireWork.authorAvatar = str;
            inspireWork.authorName = str2;
            inspireWork.authorRelation = i2;
            inspireWork.authorType = i3;
            String str3 = inspireFeedSender.userId;
            inspireWork.authorId = str3;
            authorInfo.userId = str3;
        }
        InspireFeedContent fcnt = getFcnt();
        if (fcnt != null) {
            inspireWork.translate = fcnt.translate;
            inspireWork.descLang = fcnt.descLang;
            inspireWork.workId = fcnt.workId;
            inspireWork.desc = fcnt.desc;
            inspireWork.likeSum = fcnt.likeCount;
            inspireWork.commentSum = fcnt.comCount;
            inspireWork.like = fcnt.like;
            inspireWork.geo = fcnt.geo;
            inspireWork.poi = fcnt.poi;
            InspireFeedVideo inspireFeedVideo = null;
            r4 = null;
            InspireFeedPhoto inspireFeedPhoto = null;
            inspireFeedVideo = null;
            if ("photo".equals(this.type)) {
                inspireWork.workType = 1;
                List<InspireFeedPhoto> list = fcnt.photos;
                if (list != null && list.size() > 0) {
                    inspireFeedPhoto = fcnt.photos.get(0);
                }
                if (inspireFeedPhoto != null) {
                    inspireWork.workUrl = inspireFeedPhoto.url;
                    inspireWork.width = inspireFeedPhoto.width;
                    inspireWork.height = inspireFeedPhoto.height;
                }
            } else if ("video".equals(this.type)) {
                inspireWork.workType = 2;
                List<InspireFeedVideo> list2 = fcnt.videos;
                if (list2 != null && list2.size() > 0) {
                    inspireFeedVideo = fcnt.videos.get(0);
                }
                if (inspireFeedVideo != null) {
                    String str4 = inspireFeedVideo.url;
                    inspireWork.workUrl = str4;
                    inspireWork.width = inspireFeedVideo.width;
                    inspireWork.height = inspireFeedVideo.height;
                    inspireWork.videoUrl = str4;
                    inspireWork.mockRotation = inspireFeedVideo.mockRotation;
                }
            } else if (TYPE_MULTI.equals(this.type)) {
                inspireWork.workType = 3;
                List<InspireFeedPhoto> list3 = fcnt.photos;
                if (list3 != null && list3.size() > 0) {
                    inspireWork.members = new ArrayList();
                    for (InspireFeedPhoto inspireFeedPhoto2 : list3) {
                        InspireWork.WorkMember workMember = new InspireWork.WorkMember();
                        workMember.memUrl = inspireFeedPhoto2.url;
                        workMember.width = inspireFeedPhoto2.width;
                        workMember.height = inspireFeedPhoto2.height;
                        inspireWork.members.add(workMember);
                    }
                }
            }
            if (fcnt.task != null) {
                InspireWork.TaskInfo taskInfo = new InspireWork.TaskInfo();
                inspireWork.taskInfo = taskInfo;
                InspireFeedTask inspireFeedTask = fcnt.task;
                taskInfo.taskName = inspireFeedTask.taskName;
                taskInfo.taskFinish = inspireFeedTask.taskFinish;
            }
        }
        inspireWork.uploadTime = this.timeline;
        inspireWork.taskId = getTaskId();
        return inspireWork;
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
        InspireFeed inspireFeed = (InspireFeed) obj;
        String str = this.clientId;
        if (str == null ? inspireFeed.clientId == null : str.equals(inspireFeed.clientId)) {
            String str2 = this.fid;
            if (str2 == null ? inspireFeed.fid == null : str2.equals(inspireFeed.fid)) {
                String str3 = this.type;
                if (str3 == null ? inspireFeed.type == null : str3.equals(inspireFeed.type)) {
                    InspireFeedSender inspireFeedSender = this.sender;
                    if (inspireFeedSender == null ? inspireFeed.sender == null : inspireFeedSender.equals(inspireFeed.sender)) {
                        InspireFeedContent inspireFeedContent = this.photoCnt;
                        if (inspireFeedContent == null ? inspireFeed.photoCnt == null : inspireFeedContent.equals(inspireFeed.photoCnt)) {
                            InspireFeedContent inspireFeedContent2 = this.videoCnt;
                            if (inspireFeedContent2 == null ? inspireFeed.videoCnt == null : inspireFeedContent2.equals(inspireFeed.videoCnt)) {
                                InspireFeedContent inspireFeedContent3 = this.multiCnt;
                                InspireFeedContent inspireFeedContent4 = inspireFeed.multiCnt;
                                return inspireFeedContent3 != null ? inspireFeedContent3.equals(inspireFeedContent4) : inspireFeedContent4 == null;
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

    public String getDiffId() {
        return this.fid;
    }

    public InspireFeedContent getFcnt() {
        String str = this.type;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 104256825:
                if (str.equals(TYPE_MULTI)) {
                    c = 0;
                    break;
                }
                break;
            case 106642994:
                if (str.equals("photo")) {
                    c = 1;
                    break;
                }
                break;
            case 112202875:
                if (str.equals("video")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return this.multiCnt;
            case 1:
                return this.photoCnt;
            case 2:
                return this.videoCnt;
            default:
                return null;
        }
    }

    public String getTaskId() {
        InspireFeedTask inspireFeedTask;
        InspireFeedContent fcnt = getFcnt();
        if (fcnt == null || (inspireFeedTask = fcnt.task) == null) {
            return null;
        }
        return inspireFeedTask.taskId;
    }

    public int hashCode() {
        String str = this.clientId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.fid;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.type;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        InspireFeedSender inspireFeedSender = this.sender;
        int hashCode4 = (hashCode3 + (inspireFeedSender != null ? inspireFeedSender.hashCode() : 0)) * 31;
        InspireFeedContent inspireFeedContent = this.photoCnt;
        int hashCode5 = (hashCode4 + (inspireFeedContent != null ? inspireFeedContent.hashCode() : 0)) * 31;
        InspireFeedContent inspireFeedContent2 = this.videoCnt;
        int hashCode6 = (hashCode5 + (inspireFeedContent2 != null ? inspireFeedContent2.hashCode() : 0)) * 31;
        InspireFeedContent inspireFeedContent3 = this.multiCnt;
        return hashCode6 + (inspireFeedContent3 != null ? inspireFeedContent3.hashCode() : 0);
    }

    public boolean isChallengeTask() {
        InspireFeedContent fcnt = getFcnt();
        return (fcnt == null || fcnt.task == null) ? false : true;
    }

    public boolean isVideo() {
        return "video".equals(this.type);
    }

    public boolean taskFinished() {
        InspireFeedTask inspireFeedTask;
        InspireFeedContent fcnt = getFcnt();
        return (fcnt == null || (inspireFeedTask = fcnt.task) == null || inspireFeedTask.taskFinish != 1) ? false : true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.fid);
        parcel.writeString(this.type);
        parcel.writeParcelable(this.sender, 0);
        parcel.writeParcelable(this.fcnt, 0);
        parcel.writeParcelable(this.photoCnt, 0);
        parcel.writeParcelable(this.videoCnt, 0);
        parcel.writeParcelable(this.multiCnt, 0);
        parcel.writeParcelable(this.followLikeCnt, 0);
        parcel.writeLong(this.timeline);
        parcel.writeParcelable(this.latestTaskCnt, 0);
    }

    protected InspireFeed(Parcel parcel) {
        this.fid = parcel.readString();
        this.type = parcel.readString();
        this.sender = (InspireFeedSender) parcel.readParcelable(InspireFeedSender.class.getClassLoader());
        this.fcnt = (InspireFeedContent) parcel.readParcelable(InspireFeedContent.class.getClassLoader());
        this.photoCnt = (InspireFeedContent) parcel.readParcelable(InspireFeedContent.class.getClassLoader());
        this.videoCnt = (InspireFeedContent) parcel.readParcelable(InspireFeedContent.class.getClassLoader());
        this.multiCnt = (InspireFeedContent) parcel.readParcelable(InspireFeedContent.class.getClassLoader());
        this.followLikeCnt = (InspireCompositeCnt) parcel.readParcelable(InspireCompositeCnt.class.getClassLoader());
        this.timeline = parcel.readLong();
        this.latestTaskCnt = (InspireTaskCnt) parcel.readParcelable(InspireTaskCnt.class.getClassLoader());
    }
}

package us.pinguo.inspire.module.comment;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.rockerhieu.emoji.model.LocaleUtils;
import com.tapjoy.TapjoyAuctionFlags;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.foundation.m.f;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.api.EmptyResponse;
import us.pinguo.inspire.api.Payload;
import us.pinguo.inspire.api.UserBannedException;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.module.discovery.fragment.DiscoveryHotVideoFragment;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
/* loaded from: classes9.dex */
public class CommentLoader {
    private static final String ADD_COMMENT_URL = "/comment/comment/add";
    private static final String DELETE_COMMENT_URL = "/comment/comment/del";
    private static final String FETCH_COMMENT_URL = "/comment/comment/fetch";
    public static final String GET_COMMENT_ALL_URL = "/comment/getAll";
    private static final String GET_WORK_DETAIL_URL;
    @Deprecated
    private static final String GET_WORK_URL = "/task/getWork";
    private static final String LOGIN_REQUIRE_URL;
    private static final String REPORT_COMMENT_URL = "/manage/report/comment";
    private static final String REPORT_URL = "/manage/report/work";
    public static final String TRANSLATE_TYPE_COMMENT = "comment";
    public static final String TRANSLATE_TYPE_WORK = "work";
    private static final String TRANSLATE_URL = "/translate/translate/index";

    /* loaded from: classes9.dex */
    public static class CommentAndLike implements Parcelable {
        public static final Parcelable.Creator<CommentAndLike> CREATOR = new Parcelable.Creator<CommentAndLike>() { // from class: us.pinguo.inspire.module.comment.CommentLoader.CommentAndLike.1
            @Override // android.os.Parcelable.Creator
            public CommentAndLike createFromParcel(Parcel parcel) {
                return new CommentAndLike(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public CommentAndLike[] newArray(int i2) {
                return new CommentAndLike[i2];
            }
        };
        public CommentResp comment;
        public LikeResp like;
        public InspireComment toReplyComment;

        public CommentAndLike() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeParcelable(this.comment, i2);
            parcel.writeParcelable(this.like, i2);
            parcel.writeParcelable(this.toReplyComment, i2);
        }

        protected CommentAndLike(Parcel parcel) {
            this.comment = (CommentResp) parcel.readParcelable(CommentResp.class.getClassLoader());
            this.like = (LikeResp) parcel.readParcelable(LikeResp.class.getClassLoader());
            this.toReplyComment = (InspireComment) parcel.readParcelable(InspireComment.class.getClassLoader());
        }
    }

    /* loaded from: classes9.dex */
    public static class CommentResp implements Parcelable {
        public static final Parcelable.Creator<CommentResp> CREATOR = new Parcelable.Creator<CommentResp>() { // from class: us.pinguo.inspire.module.comment.CommentLoader.CommentResp.1
            @Override // android.os.Parcelable.Creator
            public CommentResp createFromParcel(Parcel parcel) {
                return new CommentResp(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public CommentResp[] newArray(int i2) {
                return new CommentResp[i2];
            }
        };
        public String ep;
        public List<InspireComment> list;
        public String sp;

        public CommentResp() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeList(this.list);
            parcel.writeString(this.sp);
            parcel.writeString(this.ep);
        }

        protected CommentResp(Parcel parcel) {
            ArrayList arrayList = new ArrayList();
            this.list = arrayList;
            parcel.readList(arrayList, InspireComment.class.getClassLoader());
            this.sp = parcel.readString();
            this.ep = parcel.readString();
        }
    }

    /* loaded from: classes9.dex */
    public static class LikeResp implements Parcelable {
        public static final Parcelable.Creator<LikeResp> CREATOR = new Parcelable.Creator<LikeResp>() { // from class: us.pinguo.inspire.module.comment.CommentLoader.LikeResp.1
            @Override // android.os.Parcelable.Creator
            public LikeResp createFromParcel(Parcel parcel) {
                return new LikeResp(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public LikeResp[] newArray(int i2) {
                return new LikeResp[i2];
            }
        };
        public List<InspireLike> list;
        public String sp;

        public LikeResp() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeList(this.list);
            parcel.writeString(this.sp);
        }

        protected LikeResp(Parcel parcel) {
            ArrayList arrayList = new ArrayList();
            this.list = arrayList;
            parcel.readList(arrayList, InspireLike.class.getClassLoader());
            this.sp = parcel.readString();
        }
    }

    /* loaded from: classes9.dex */
    private static class LoginRequiredResp {
        boolean loginRequired;

        private LoginRequiredResp() {
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        String str = Inspire.f11205f;
        sb.append(str);
        sb.append("/camera360/work/detail");
        GET_WORK_DETAIL_URL = sb.toString();
        LOGIN_REQUIRE_URL = str + "/camera360/task/loginRequired";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ Observable b(String str, String str2, String str3, InspireComment inspireComment, InspireWork.BanData banData) {
        if (banData.type == 1) {
            return Observable.error(new UserBannedException(banData.tips));
        }
        return addComment(str, str2, str3, inspireComment);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Void c(EmptyResponse.Data data) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Void e(EmptyResponse.Data data) {
        return null;
    }

    public static boolean isLoginRequired() {
        return true;
    }

    public Observable<InspireComment> addComment(String str, String str2, String str3, InspireComment inspireComment) {
        return us.pinguo.foundation.m.f.f(new Inspire.d<BaseResponse<InspireComment>>() { // from class: us.pinguo.inspire.module.comment.CommentLoader.2
        }.url(ADD_COMMENT_URL).put(DiscoveryHotVideoFragment.WORK_ID, str).put(TapjoyAuctionFlags.AUCTION_ID, str2).put(FirebaseAnalytics.Param.CONTENT, str3).put("replyId", inspireComment.replyId).put("atMembers", inspireComment.getAtMembersJsonString()).build()).map(new Payload());
    }

    public Observable<InspireComment> addCommentIfUnBanned(final String str, final String str2, final String str3, final InspireComment inspireComment) {
        return InspireWork.isBanned().flatMap(new Func1() { // from class: us.pinguo.inspire.module.comment.e
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return CommentLoader.this.b(str, str2, str3, inspireComment, (InspireWork.BanData) obj);
            }
        });
    }

    public Observable<Void> delete(String str, String str2, String str3) {
        return us.pinguo.foundation.m.f.f(new Inspire.d<EmptyResponse>() { // from class: us.pinguo.inspire.module.comment.CommentLoader.9
        }.url("/pic/deletePic").put("taskId", str).put("picId", str2).put(GuestProfileFragment.USER_ID, str3).build()).map(new Payload()).map(d.a);
    }

    public Observable<Boolean> deleteComment(String str) {
        return us.pinguo.foundation.m.f.f(new Inspire.d<BaseResponse<Boolean>>() { // from class: us.pinguo.inspire.module.comment.CommentLoader.3
        }.url(DELETE_COMMENT_URL).put("commentId", str).build()).map(c.a);
    }

    public Observable<CommentResp> fetchCommentList(String str, String str2, String str3, int i2) {
        f.a<BaseResponse<CommentResp>> cacheKey = new Inspire.d<BaseResponse<CommentResp>>() { // from class: us.pinguo.inspire.module.comment.CommentLoader.1
        }.url(FETCH_COMMENT_URL).put(DiscoveryHotVideoFragment.WORK_ID, str).put("sort", -1).put("toward", i2).setCacheKey(String.valueOf(System.nanoTime()));
        cacheKey.put("ep", str3);
        cacheKey.put("sp", str2);
        return us.pinguo.foundation.m.f.f(cacheKey.build()).map(new Payload());
    }

    public Observable<CommentAndLike> getCommentAndLike(String str, String str2, String str3, int i2, int i3) {
        return us.pinguo.foundation.m.f.f(new Inspire.d<BaseResponse<CommentAndLike>>() { // from class: us.pinguo.inspire.module.comment.CommentLoader.7
        }.url(GET_COMMENT_ALL_URL).put(DiscoveryHotVideoFragment.WORK_ID, str).put("commentId", str2).put("commentMp", str3).put("commentNum", i2).put("likeSum", i3).setCacheKey(String.valueOf(System.nanoTime())).build()).map(new Payload());
    }

    @Deprecated
    public Observable<InspireWork> getWork(String str) {
        return us.pinguo.foundation.m.f.f(new Inspire.d<BaseResponse<InspireWork>>() { // from class: us.pinguo.inspire.module.comment.CommentLoader.5
        }.url(GET_WORK_URL).put(DiscoveryHotVideoFragment.WORK_ID, str).put("locale", LocaleUtils.getDefault().getLanguage()).setCacheKey(String.valueOf(System.nanoTime())).build()).map(new Payload());
    }

    public Observable<InspireWork> getWorkDetail(String str) {
        return us.pinguo.foundation.m.f.f(new Inspire.d<BaseResponse<InspireWork>>() { // from class: us.pinguo.inspire.module.comment.CommentLoader.6
        }.url(GET_WORK_DETAIL_URL).put(DiscoveryHotVideoFragment.WORK_ID, str).build()).map(new Payload());
    }

    public Observable<Void> report(String str, String str2) {
        return us.pinguo.foundation.m.f.f(new Inspire.d<EmptyResponse>() { // from class: us.pinguo.inspire.module.comment.CommentLoader.8
        }.url(REPORT_URL).put(DiscoveryHotVideoFragment.WORK_ID, str).put(GuestProfileFragment.USER_ID, str2).build()).map(new Payload()).map(a.a);
    }

    public Observable<Object> reportComment(String str) {
        return us.pinguo.foundation.m.f.f(new Inspire.d<BaseResponse<Object>>() { // from class: us.pinguo.inspire.module.comment.CommentLoader.4
        }.url(REPORT_COMMENT_URL).put("commentId", str).build()).map(b.a);
    }

    public Observable<TranslateData> translate(String str, String str2) {
        return us.pinguo.foundation.m.f.f(new Inspire.d<BaseResponse<TranslateData>>() { // from class: us.pinguo.inspire.module.comment.CommentLoader.10
        }.url(TRANSLATE_URL).put("sourceId", str).put("type", str2).build()).map(new Payload());
    }
}

package us.pinguo.inspire.module.attention;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.math.BigDecimal;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.foundation.m.f;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.api.Payload;
import us.pinguo.inspire.module.comment.InspireUser;
import us.pinguo.inspire.module.contact.ContactLoader;
import us.pinguo.inspire.module.contact.entry.Recommend;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
/* loaded from: classes9.dex */
public class InspireAtentionLoader {
    private static final String ADD_ATTENTION_URL = "/user/friend/follow";
    private static final String CANCEL_ATTENTION_URL = "/user/friend/unfollow";
    private static final String FANS_LIST_URL = "/user/friend/fans";
    private static final String FOLLOW_LIST_URL = "/user/friend/follows";
    private static final String RECOMMED_LIST_URL = "/rec/users/follow";
    private static final String USER_SEARCH = "/user/search";

    /* loaded from: classes9.dex */
    public static class AttentionResp {
        public int isRecommend;
        public List<InspireAttention> list;
        public int ower;
        public List<InspireAttention> recentList;
        public BigDecimal sp;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            AttentionResp attentionResp = (AttentionResp) obj;
            if (this.ower == attentionResp.ower && this.isRecommend == attentionResp.isRecommend) {
                BigDecimal bigDecimal = this.sp;
                if (bigDecimal == null ? attentionResp.sp == null : bigDecimal.equals(attentionResp.sp)) {
                    List<InspireAttention> list = this.list;
                    if (list == null ? attentionResp.list == null : list.equals(attentionResp.list)) {
                        List<InspireAttention> list2 = this.recentList;
                        List<InspireAttention> list3 = attentionResp.recentList;
                        return list2 != null ? list2.equals(list3) : list3 == null;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            BigDecimal bigDecimal = this.sp;
            int hashCode = (((bigDecimal != null ? bigDecimal.hashCode() : 0) * 31) + this.ower) * 31;
            List<InspireAttention> list = this.list;
            int hashCode2 = (((hashCode + (list != null ? list.hashCode() : 0)) * 31) + this.isRecommend) * 31;
            List<InspireAttention> list2 = this.recentList;
            return hashCode2 + (list2 != null ? list2.hashCode() : 0);
        }
    }

    /* loaded from: classes9.dex */
    public static class UserSearchResp {
        List<InspireUser> list;
        BigDecimal sp;
    }

    public Observable<InspireAttention> addAttention(String str, String str2) {
        return us.pinguo.foundation.m.f.f(new Inspire.d<BaseResponse<InspireAttention>>() { // from class: us.pinguo.inspire.module.attention.InspireAtentionLoader.1
        }.url(ADD_ATTENTION_URL).put(GuestProfileFragment.USER_ID, str).put("followId", str2).build()).map(new Payload());
    }

    public Observable<InspireAttention> cancelAttention(String str, String str2) {
        return us.pinguo.foundation.m.f.f(new Inspire.d<BaseResponse<InspireAttention>>() { // from class: us.pinguo.inspire.module.attention.InspireAtentionLoader.2
        }.url(CANCEL_ATTENTION_URL).put(GuestProfileFragment.USER_ID, str).put("followId", str2).build()).map(new Payload());
    }

    public Observable<AttentionResp> fetchAttentionList(String str, String str2, boolean z) {
        return fetchAttentionList(str, str2, z, new BigDecimal((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
    }

    public Observable<AttentionResp> fetchFansList(String str, String str2, BigDecimal bigDecimal) {
        f.a<BaseResponse<AttentionResp>> put = new Inspire.d<BaseResponse<AttentionResp>>() { // from class: us.pinguo.inspire.module.attention.InspireAtentionLoader.4
        }.url(FANS_LIST_URL).put(GuestProfileFragment.USER_ID, str).put("masterId", str2);
        if (bigDecimal.doubleValue() != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            put.put("sp", bigDecimal.toPlainString());
        }
        return us.pinguo.foundation.m.f.f(put.build()).map(new Payload());
    }

    public Observable<List<Recommend>> fetchRecommedList(String str) {
        return us.pinguo.foundation.m.f.f(new Inspire.d<BaseResponse<ContactLoader.RecommendResp>>() { // from class: us.pinguo.inspire.module.attention.InspireAtentionLoader.6
        }.url(RECOMMED_LIST_URL).put(GuestProfileFragment.USER_ID, str).build()).map(new Payload()).map(new Func1<ContactLoader.RecommendResp, List<Recommend>>() { // from class: us.pinguo.inspire.module.attention.InspireAtentionLoader.7
            @Override // rx.functions.Func1
            public List<Recommend> call(ContactLoader.RecommendResp recommendResp) {
                return recommendResp.list;
            }
        });
    }

    public Observable<AttentionResp> searchUser(String str, String str2, BigDecimal bigDecimal) {
        return us.pinguo.foundation.m.f.f(new Inspire.d<BaseResponse<AttentionResp>>() { // from class: us.pinguo.inspire.module.attention.InspireAtentionLoader.5
        }.url(USER_SEARCH).put(GuestProfileFragment.USER_ID, str).put("name", str2).put("highlight", 1).put("sp", bigDecimal.toPlainString()).build()).map(new Payload());
    }

    public Observable<AttentionResp> fetchAttentionList(String str, String str2, boolean z, BigDecimal bigDecimal) {
        f.a<BaseResponse<AttentionResp>> put = new Inspire.d<BaseResponse<AttentionResp>>() { // from class: us.pinguo.inspire.module.attention.InspireAtentionLoader.3
        }.url(FOLLOW_LIST_URL).put(GuestProfileFragment.USER_ID, str).put("masterId", str2);
        put.put("recommend", (z ? 1 : 0) + "");
        if (bigDecimal.doubleValue() != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            put.put("sp", bigDecimal.toPlainString());
        }
        return us.pinguo.foundation.m.f.f(put.build()).map(new Payload());
    }

    public Observable<AttentionResp> fetchFansList(String str, String str2) {
        return fetchFansList(str, str2, new BigDecimal((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
    }
}

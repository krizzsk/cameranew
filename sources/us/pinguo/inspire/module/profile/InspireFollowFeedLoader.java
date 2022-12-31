package us.pinguo.inspire.module.profile;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.api.Payload;
/* loaded from: classes4.dex */
public class InspireFollowFeedLoader {
    private static final String URL_CHALLENGE_FOLLOW_UNREAD_COUNT = Inspire.f11203d + "/feed/ufeed/unReadCount";

    /* loaded from: classes4.dex */
    private static class SingletonHolder {
        private static InspireFollowFeedLoader instance = new InspireFollowFeedLoader();

        private SingletonHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class UnReadCountData {
        public int unReadCount;

        private UnReadCountData() {
        }
    }

    public static InspireFollowFeedLoader getInstance() {
        return SingletonHolder.instance;
    }

    public Observable<Integer> getUnReadCount() {
        return us.pinguo.foundation.m.f.a(new Inspire.d<BaseResponse<UnReadCountData>>() { // from class: us.pinguo.inspire.module.profile.InspireFollowFeedLoader.1
        }.url(URL_CHALLENGE_FOLLOW_UNREAD_COUNT).put("lastTime", 0).build()).map(new Payload()).map(k.a).observeOn(AndroidSchedulers.mainThread());
    }
}

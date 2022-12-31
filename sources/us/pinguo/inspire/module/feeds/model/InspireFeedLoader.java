package us.pinguo.inspire.module.feeds.model;

import android.text.TextUtils;
import com.android.volley.AuthFailureError;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.api.Payload;
import us.pinguo.inspire.module.discovery.cache.InspireFeedRespDiskCache;
import us.pinguo.inspire.module.feeds.model.PortalFeeds;
import us.pinguo.user.s0;
import us.pinguo.util.s;
/* loaded from: classes9.dex */
public class InspireFeedLoader {
    private static final String URL_FOLLOW_AND_LIKE_DETAIL = "/feed/detail/followAndLike";
    private static final String URL_PORTAL_FEEDS = Inspire.f11204e + "/page/show";

    /* loaded from: classes9.dex */
    private static class FeedsExtraParams implements us.pinguo.foundation.m.k {
        private static String mGpId;
        private static int mGpIdCounter;

        private FeedsExtraParams() {
        }

        private String getGpId() {
            return null;
        }

        @Override // us.pinguo.foundation.m.k
        public void append(Map<String, String> map) throws AuthFailureError {
            if (map == null) {
                map = new HashMap<>();
            }
            if (TextUtils.isEmpty(mGpId) && mGpIdCounter == 0) {
                mGpId = getGpId();
                mGpIdCounter++;
            }
            if (TextUtils.isEmpty(mGpId)) {
                return;
            }
            map.put("gpid", mGpId);
        }
    }

    /* loaded from: classes9.dex */
    public static class InspireFollowAndLikeDetailData {
        public List<InspireFollowAndLikeDetail> list;
        public long serverTime;
    }

    /* loaded from: classes9.dex */
    private static class SingletonHolder {
        private static InspireFeedLoader instance = new InspireFeedLoader();

        private SingletonHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ PortalFeeds b(boolean z, PortalFeeds portalFeeds) {
        PortalFeeds.Body body;
        List<PortalFeeds.Body.FeedItem> list;
        if (z) {
            try {
                new InspireFeedRespDiskCache(s0.getInstance().getUserId()).putObject(portalFeeds);
                if (portalFeeds != null && (body = portalFeeds.body) != null && (list = body.list) != null && list.size() > 0) {
                    Inspire.c().edit().putBoolean(FeedsHotManager.KEY_CACHE_EXIST, true).apply();
                } else {
                    Inspire.c().edit().putBoolean(FeedsHotManager.KEY_CACHE_EXIST, false).apply();
                }
            } catch (Exception e2) {
                Inspire.f(e2);
            }
        }
        return portalFeeds;
    }

    public static InspireFeedLoader getInstance() {
        return SingletonHolder.instance;
    }

    public Observable<List<InspireFollowAndLikeDetail>> getFollowAndLikeDetail(double d2) {
        return us.pinguo.foundation.m.f.a(new Inspire.d<BaseResponse<InspireFollowAndLikeDetailData>>() { // from class: us.pinguo.inspire.module.feeds.model.InspireFeedLoader.3
        }.url(URL_FOLLOW_AND_LIKE_DETAIL).put("lastMtime", d2).build()).map(new Payload()).map(p.a).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<PortalFeeds> getHotFeedRespFromServer(final boolean z, int i2, String str) {
        return us.pinguo.foundation.m.f.a(new Inspire.d<BaseResponse<PortalFeeds>>() { // from class: us.pinguo.inspire.module.feeds.model.InspireFeedLoader.2
        }.url(URL_PORTAL_FEEDS).put("unReadCount", i2).putNonNull("lastTime", str).put("androidid", s.a(us.pinguo.foundation.e.b())).put(new FeedsExtraParams()).build()).map(new Payload()).map(new Func1() { // from class: us.pinguo.inspire.module.feeds.model.q
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                PortalFeeds portalFeeds = (PortalFeeds) obj;
                InspireFeedLoader.b(z, portalFeeds);
                return portalFeeds;
            }
        }).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<PortalFeeds> getInspireFeedRespFromCache() {
        return Observable.create(new Observable.OnSubscribe<PortalFeeds>() { // from class: us.pinguo.inspire.module.feeds.model.InspireFeedLoader.1
            @Override // rx.functions.Action1
            public void call(Subscriber<? super PortalFeeds> subscriber) {
                try {
                    PortalFeeds object = new InspireFeedRespDiskCache(s0.getInstance().getUserId()).getObject();
                    if (object != null) {
                        subscriber.onNext(object);
                        subscriber.onCompleted();
                        return;
                    }
                    throw new EmptyFeedsCacheException();
                } catch (Exception e2) {
                    subscriber.onError(e2);
                    Inspire.f(e2);
                }
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    private InspireFeedLoader() {
    }
}

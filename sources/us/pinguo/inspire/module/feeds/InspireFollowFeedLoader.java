package us.pinguo.inspire.module.feeds;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.api.Payload;
import us.pinguo.inspire.module.discovery.cache.InspireFollowFeedRespDiskCache;
import us.pinguo.inspire.module.feeds.model.EmptyFeedsCacheException;
import us.pinguo.inspire.module.feeds.model.FeedsFollowManager;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
import us.pinguo.user.s0;
/* loaded from: classes9.dex */
public class InspireFollowFeedLoader extends us.pinguo.inspire.module.profile.InspireFollowFeedLoader {
    private static final String URL_CHALLENGE_FOLLOW_UNREAD_COUNT;
    private static final String URL_PORTAL_FOLLOW_FEEDS;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class SingletonHolder {
        private static InspireFollowFeedLoader instance = new InspireFollowFeedLoader();

        private SingletonHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class UnReadCountData {
        public int unReadCount;

        private UnReadCountData() {
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        String str = Inspire.f11203d;
        sb.append(str);
        sb.append("/feed/ufeed");
        URL_PORTAL_FOLLOW_FEEDS = sb.toString();
        URL_CHALLENGE_FOLLOW_UNREAD_COUNT = str + "/feed/ufeed/unReadCount";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ PortalFollowFeeds b(boolean z, PortalFollowFeeds portalFollowFeeds) {
        if (z) {
            try {
                new InspireFollowFeedRespDiskCache(s0.getInstance().getUserId()).putObject(portalFollowFeeds);
            } catch (Exception e2) {
                Inspire.f(e2);
            }
        }
        return portalFollowFeeds;
    }

    public static InspireFollowFeedLoader getInstance() {
        return SingletonHolder.instance;
    }

    public Observable<PortalFollowFeeds> getFollowFeedRespFromServer(String str, String str2, final boolean z, int i2) {
        return us.pinguo.foundation.m.f.a(new Inspire.d<BaseResponse<PortalFollowFeeds>>() { // from class: us.pinguo.inspire.module.feeds.InspireFollowFeedLoader.2
        }.url(URL_PORTAL_FOLLOW_FEEDS).put("lastTime", str2).put("sp", str).put("isRec", i2).build()).map(new Payload()).map(new Func1() { // from class: us.pinguo.inspire.module.feeds.e
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                PortalFollowFeeds portalFollowFeeds = (PortalFollowFeeds) obj;
                InspireFollowFeedLoader.b(z, portalFollowFeeds);
                return portalFollowFeeds;
            }
        }).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<PortalFollowFeeds> getInspireFeedRespFromCache() {
        return Observable.create(new Observable.OnSubscribe<PortalFollowFeeds>() { // from class: us.pinguo.inspire.module.feeds.InspireFollowFeedLoader.1
            @Override // rx.functions.Action1
            public void call(Subscriber<? super PortalFollowFeeds> subscriber) {
                try {
                    PortalFollowFeeds object = new InspireFollowFeedRespDiskCache(s0.getInstance().getUserId()).getObject();
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

    @Override // us.pinguo.inspire.module.profile.InspireFollowFeedLoader
    public Observable<Integer> getUnReadCount() {
        return us.pinguo.foundation.m.f.a(new Inspire.d<BaseResponse<UnReadCountData>>() { // from class: us.pinguo.inspire.module.feeds.InspireFollowFeedLoader.3
        }.url(URL_CHALLENGE_FOLLOW_UNREAD_COUNT).put("lastTime", FeedsFollowManager.getLastTime()).build()).map(new Payload()).map(d.a).observeOn(AndroidSchedulers.mainThread());
    }

    private InspireFollowFeedLoader() {
    }
}

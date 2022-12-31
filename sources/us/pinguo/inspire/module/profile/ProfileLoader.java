package us.pinguo.inspire.module.profile;

import android.text.TextUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import org.json.JSONException;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.foundation.network.Fault;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.api.Payload;
import us.pinguo.inspire.model.InspireCollectionInfo;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.model.MallSwitch;
import us.pinguo.inspire.model.MyCollectionCache;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
import us.pinguo.user.User;
import us.pinguo.user.api.UserInfoResponse;
import us.pinguo.user.model.PersonalInfoCache;
import us.pinguo.user.model.ProfileAuthorInfo;
/* loaded from: classes9.dex */
public class ProfileLoader {
    private static final String MINE_WORK_URL = "/user/profileList";
    public static final String PERSONAL_PROFILE_URL = "/user/profile";
    public static final String URL_COLLECT_LIST = "/comment/like/fetchWorksByUid";
    public static final String URL_FLOWER_LIST = "/comment/gift/fetchFlowerWork";
    private static final String URL_MALL_SWITCH = "/manage/MallSwitch";
    private MyCollectionCache mMyCollectionCache;
    private PersonalInfoCache mPersonalInfoCache;
    private ProfileDiskCache mProfileDiskCache;

    /* loaded from: classes9.dex */
    public static class FavoriteResp {
        public List<InspireWork> items;
    }

    /* loaded from: classes9.dex */
    private static final class Holder {
        private static final ProfileLoader INSTANCE = new ProfileLoader();

        private Holder() {
        }
    }

    public ProfileLoader() {
        String userId = us.pinguo.user.s0.getInstance().getUserId();
        this.mProfileDiskCache = new ProfileDiskCache(userId);
        this.mMyCollectionCache = new MyCollectionCache();
        this.mPersonalInfoCache = new PersonalInfoCache(userId);
    }

    private /* synthetic */ InspireCollectionInfo a(BigDecimal bigDecimal, InspireCollectionInfo inspireCollectionInfo) {
        if (bigDecimal.doubleValue() == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            this.mMyCollectionCache.wrap().b(inspireCollectionInfo);
        }
        return inspireCollectionInfo;
    }

    private /* synthetic */ InspireCollectionInfo c(BigDecimal bigDecimal, InspireCollectionInfo inspireCollectionInfo) {
        if (bigDecimal.doubleValue() == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            this.mMyCollectionCache.wrap().b(inspireCollectionInfo);
        }
        return inspireCollectionInfo;
    }

    private /* synthetic */ ProfileEntry e(ProfileEntry profileEntry) {
        this.mPersonalInfoCache.wrap().b(profileEntry);
        return profileEntry;
    }

    private /* synthetic */ ProfileEntry g(String str, long j2, ProfileEntry profileEntry) {
        if (str.equals(us.pinguo.user.s0.getInstance().getUserId()) && j2 == 0) {
            this.mProfileDiskCache.wrap().b(profileEntry);
        }
        return profileEntry;
    }

    public static ProfileLoader getInstance() {
        return Holder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ UserInfoResponse i(String str) {
        UserInfoResponse userInfoResponse;
        try {
            userInfoResponse = new UserInfoResponse(str, "");
        } catch (JSONException e2) {
            Inspire.f(e2);
            userInfoResponse = null;
        }
        int i2 = userInfoResponse.status;
        if (i2 == 420) {
            User.E();
            throw null;
        } else if (i2 == 200) {
            User d2 = User.d();
            if (d2.q()) {
                User.Info h2 = d2.h();
                User.Info info = (User.Info) userInfoResponse.data;
                info.loginmode = h2.loginmode;
                info.token = h2.token;
                User.v(info);
                return userInfoResponse;
            }
            throw new IllegalArgumentException("用户不合法");
        } else {
            throw new Fault(userInfoResponse.status, userInfoResponse.message);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void j(us.pinguo.user.model.ProfileEntry profileEntry) {
        if (profileEntry == null || profileEntry.authorInfo == null) {
            return;
        }
        User.Info h2 = User.d().h();
        h2.mark = profileEntry.authorInfo.mark;
        User.v(h2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void k(Throwable th) {
        Inspire.f(th);
        us.pinguo.common.log.a.f(th);
    }

    public /* synthetic */ InspireCollectionInfo b(BigDecimal bigDecimal, InspireCollectionInfo inspireCollectionInfo) {
        a(bigDecimal, inspireCollectionInfo);
        return inspireCollectionInfo;
    }

    public /* synthetic */ InspireCollectionInfo d(BigDecimal bigDecimal, InspireCollectionInfo inspireCollectionInfo) {
        c(bigDecimal, inspireCollectionInfo);
        return inspireCollectionInfo;
    }

    public /* synthetic */ ProfileEntry f(ProfileEntry profileEntry) {
        e(profileEntry);
        return profileEntry;
    }

    public Observable<InspireCollectionInfo> fetchMyFavoriteList(final BigDecimal bigDecimal, int i2, String str) {
        return us.pinguo.foundation.m.f.a(new Inspire.d<BaseResponse<InspireCollectionInfo>>() { // from class: us.pinguo.inspire.module.profile.ProfileLoader.2
        }.url(URL_COLLECT_LIST).put("sp", bigDecimal.toPlainString()).put("num", i2).put("masterId", str).build()).map(new Payload()).map(new Func1() { // from class: us.pinguo.inspire.module.profile.o
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                InspireCollectionInfo inspireCollectionInfo = (InspireCollectionInfo) obj;
                ProfileLoader.this.b(bigDecimal, inspireCollectionInfo);
                return inspireCollectionInfo;
            }
        }).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<InspireCollectionInfo> fetchMyFlowerList(final BigDecimal bigDecimal, int i2, String str) {
        return us.pinguo.foundation.m.f.a(new Inspire.d<BaseResponse<InspireCollectionInfo>>() { // from class: us.pinguo.inspire.module.profile.ProfileLoader.3
        }.url(URL_FLOWER_LIST).put("sp", bigDecimal.toPlainString()).put("num", i2).put("masterId", str).build()).map(new Payload()).map(new Func1() { // from class: us.pinguo.inspire.module.profile.n
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                InspireCollectionInfo inspireCollectionInfo = (InspireCollectionInfo) obj;
                ProfileLoader.this.d(bigDecimal, inspireCollectionInfo);
                return inspireCollectionInfo;
            }
        }).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<ProfileEntry> fetchMyProfile(String str) {
        return us.pinguo.foundation.m.f.f(new Inspire.d<BaseResponse<ProfileEntry>>() { // from class: us.pinguo.inspire.module.profile.ProfileLoader.6
        }.url(PERSONAL_PROFILE_URL).put("authorId", str).build()).map(new Payload()).map(new Func1() { // from class: us.pinguo.inspire.module.profile.r
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                ProfileEntry profileEntry = (ProfileEntry) obj;
                ProfileLoader.this.f(profileEntry);
                return profileEntry;
            }
        });
    }

    public Observable<ProfileEntry> fetchProfileList(final String str, final long j2) {
        return us.pinguo.foundation.m.f.f(new Inspire.d<BaseResponse<ProfileEntry>>() { // from class: us.pinguo.inspire.module.profile.ProfileLoader.1
        }.url(MINE_WORK_URL).put("authorId", str).put("beginTime", j2).build()).map(new Payload()).map(new Func1() { // from class: us.pinguo.inspire.module.profile.s
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                ProfileEntry profileEntry = (ProfileEntry) obj;
                ProfileLoader.this.h(str, j2, profileEntry);
                return profileEntry;
            }
        });
    }

    public Observable<MallSwitch> getMallSwitch() {
        return us.pinguo.foundation.m.f.f(new Inspire.d<BaseResponse<MallSwitch>>() { // from class: us.pinguo.inspire.module.profile.ProfileLoader.4
        }.url(URL_MALL_SWITCH).build()).map(new Payload());
    }

    public ProfileAuthorInfo getProfile() {
        try {
            ProfileEntry object = this.mProfileDiskCache.getObject();
            if (object != null) {
                return object.authorInfo;
            }
            return null;
        } catch (IOException e2) {
            Inspire.f(e2);
            return null;
        }
    }

    public Observable<ProfileEntry> getProfileFromDiskCache() {
        return Observable.create(new Observable.OnSubscribe<ProfileEntry>() { // from class: us.pinguo.inspire.module.profile.ProfileLoader.5
            @Override // rx.functions.Action1
            public void call(Subscriber<? super ProfileEntry> subscriber) {
                try {
                    subscriber.onNext(ProfileLoader.this.mProfileDiskCache.getObject());
                    subscriber.onCompleted();
                } catch (IOException e2) {
                    Inspire.f(e2);
                    subscriber.onError(e2);
                }
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<UserInfoResponse> getUserInfo() {
        return us.pinguo.foundation.m.f.a(new Inspire.d<String>() { // from class: us.pinguo.inspire.module.profile.ProfileLoader.7
        }.url(us.pinguo.user.t0.F).put(GuestProfileFragment.USER_ID, us.pinguo.user.s0.getInstance().getUserId()).build()).map(q.a).observeOn(AndroidSchedulers.mainThread());
    }

    public /* synthetic */ ProfileEntry h(String str, long j2, ProfileEntry profileEntry) {
        g(str, j2, profileEntry);
        return profileEntry;
    }

    public void updateUserMark() {
        if (TextUtils.isEmpty(us.pinguo.user.s0.getInstance().getUserId())) {
            return;
        }
        us.pinguo.foundation.utils.h.a(new us.pinguo.user.loader.ProfileLoader().a(us.pinguo.user.s0.getInstance().getUserId()).subscribe(p.a, m.a));
    }
}

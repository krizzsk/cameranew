package us.pinguo.inspire.module.profile;

import android.app.Activity;
import android.text.TextUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import rx.functions.Action1;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.event.ShowProfileRecommendEvent;
import us.pinguo.inspire.model.InspireCollectionInfo;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.module.attention.InspireAtentionLoader;
import us.pinguo.inspire.module.attention.InspireAttention;
import us.pinguo.user.model.ProfileAuthorInfo;
/* loaded from: classes9.dex */
public class ProfilePresenter extends us.pinguo.foundation.p.a {
    public static final int DEFAULT_NUM = 30;
    public static final long DEFAULT_TIME = 0;
    public static final String MALL_URL = "mall_url";
    private int gender = -10;
    private Activity mActivity;
    private List<InspireWork> mFavoriteList;
    private List<InspireWork> mFlowerList;
    private BigDecimal mFlowerSp;
    private List<InspireWork> mInspireWorks;
    private BigDecimal mLikeSp;
    private ProfileAuthorInfo mProfileAuthorInfo;
    private ProfileLoader mProfileLoader;
    private IProfileView mProfileView;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public /* synthetic */ void C(InspireCollectionInfo inspireCollectionInfo) {
        List<InspireWork> arrayList = new ArrayList<>();
        if (inspireCollectionInfo != null) {
            arrayList = inspireCollectionInfo.list;
            this.mFlowerSp = inspireCollectionInfo.sp;
        }
        if (arrayList != null) {
            this.mFlowerList.addAll(arrayList);
            this.mProfileView.appendData(arrayList);
        }
        this.mProfileView.hideLoadMore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public /* synthetic */ void E(Throwable th) {
        Inspire.f(th);
        us.pinguo.common.log.a.f(th);
        this.mProfileView.hideLoadMore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F */
    public /* synthetic */ void G(ProfileEntry profileEntry) {
        this.mInspireWorks.addAll(profileEntry.items);
        this.mProfileView.appendData(profileEntry.items);
        this.mProfileView.hideLoadMore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H */
    public /* synthetic */ void I(Throwable th) {
        Inspire.f(th);
        us.pinguo.common.log.a.f(th);
        this.mProfileView.hideLoadMore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J */
    public /* synthetic */ void K(us.pinguo.inspire_proxy.a.a aVar) {
        if (aVar.a == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.mInspireWorks.size()) {
                break;
            } else if (aVar.a.equals(this.mInspireWorks.get(i2).workId)) {
                this.mInspireWorks.remove(i2);
                break;
            } else {
                i2++;
            }
        }
        this.mProfileView.deleteWork(aVar.a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void L(Throwable th) {
        Inspire.f(th);
        us.pinguo.common.log.a.f(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M */
    public /* synthetic */ void N(us.pinguo.foundation.r.a aVar) {
        this.mProfileView.loginout();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void O(Throwable th) {
        Inspire.f(th);
        us.pinguo.common.log.a.f(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P */
    public /* synthetic */ void Q(us.pinguo.user.event.a aVar) {
        this.gender = aVar.a;
        this.mProfileView.refreshProfile();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void R(Throwable th) {
        Inspire.f(th);
        us.pinguo.common.log.a.f(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S */
    public /* synthetic */ void T(us.pinguo.inspire.event.e eVar) {
        this.mProfileView.scrollToFirstPosition();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void U(Throwable th) {
        Inspire.f(th);
        us.pinguo.common.log.a.f(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void b(String str, InspireAttention inspireAttention) {
        us.pinguo.common.log.a.m("GuestActivity", "success ：" + inspireAttention, new Object[0]);
        this.mProfileView.addAttention(inspireAttention);
        us.pinguo.foundation.r.d.a().b(new us.pinguo.inspire.event.a(str, inspireAttention.relation));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(Throwable th) {
        Inspire.f(th);
        us.pinguo.common.log.a.m("GuestActivity", "fail ：" + th, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void e(String str, InspireAttention inspireAttention) {
        this.mProfileView.cancelAttention(inspireAttention);
        us.pinguo.foundation.r.d.a().b(new us.pinguo.inspire.event.a(str, inspireAttention.relation));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void f(Throwable th) {
        Inspire.f(th);
        us.pinguo.common.log.a.m("GuestActivity", "fail ：" + th, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void h(InspireCollectionInfo inspireCollectionInfo) {
        this.mProfileView.hideLoading();
        this.mLikeSp = inspireCollectionInfo.sp;
        List<InspireWork> arrayList = new ArrayList<>();
        if (inspireCollectionInfo != null) {
            arrayList = inspireCollectionInfo.list;
        }
        ProfileAuthorInfo profileAuthorInfo = inspireCollectionInfo.authorInfo;
        this.mProfileAuthorInfo = profileAuthorInfo;
        int i2 = 0;
        if (arrayList != null && arrayList.size() > 0) {
            i2 = arrayList.get(0).authorRanking;
        }
        profileAuthorInfo.ranking = i2;
        if (arrayList != null) {
            this.mFavoriteList.clear();
            this.mFavoriteList.addAll(arrayList);
            this.mProfileView.setFavorite(arrayList);
        }
        this.mProfileView.setOnRefreshComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public /* synthetic */ void j(Throwable th) {
        Inspire.f(th);
        us.pinguo.common.log.a.f(th);
        us.pinguo.user.util.i.b(th);
        this.mProfileView.setOnRefreshComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public /* synthetic */ void l(InspireCollectionInfo inspireCollectionInfo) {
        this.mProfileView.hideLoading();
        this.mFlowerSp = inspireCollectionInfo.sp;
        List<InspireWork> arrayList = new ArrayList<>();
        if (inspireCollectionInfo != null) {
            arrayList = inspireCollectionInfo.list;
        }
        if (arrayList != null) {
            this.mFlowerList.clear();
            this.mFlowerList.addAll(arrayList);
            this.mProfileView.setFlowerWorks(arrayList);
        }
        this.mProfileView.setOnRefreshComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public /* synthetic */ void n(Throwable th) {
        Inspire.f(th);
        us.pinguo.common.log.a.f(th);
        us.pinguo.user.util.i.b(th);
        this.mProfileView.setOnRefreshComplete();
    }

    private void notifyProfileData(ProfileEntry profileEntry) {
        if (profileEntry != null) {
            this.mInspireWorks.clear();
            ProfileAuthorInfo profileAuthorInfo = profileEntry.authorInfo;
            this.mProfileAuthorInfo = profileAuthorInfo;
            List<InspireWork> list = profileEntry.items;
            int i2 = 0;
            if (list != null && list.size() > 0) {
                i2 = profileEntry.items.get(0).authorRanking;
            }
            profileAuthorInfo.ranking = i2;
            int i3 = this.gender;
            if (i3 != -10) {
                this.mProfileAuthorInfo.gender = i3;
            }
            this.mInspireWorks.addAll(profileEntry.items);
            this.mProfileView.setData(this.mInspireWorks);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public /* synthetic */ void p(ProfileEntry profileEntry) {
        this.mProfileView.hideLoading();
        notifyProfileData(profileEntry);
        this.mProfileView.setOnRefreshComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public /* synthetic */ void r(Throwable th) {
        Inspire.f(th);
        us.pinguo.common.log.a.f(th);
        this.mProfileView.setOnRefreshComplete();
        if (us.pinguo.user.util.m.a(th)) {
            us.pinguo.user.util.m.b(this.mActivity);
        }
        us.pinguo.user.util.i.b(th);
    }

    private void registerScrollRecyclerViewToFirstPosition() {
        addSubscription(us.pinguo.foundation.r.d.a().c(us.pinguo.inspire.event.e.class).subscribe(new Action1() { // from class: us.pinguo.inspire.module.profile.v
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ProfilePresenter.this.T((us.pinguo.inspire.event.e) obj);
            }
        }, x.a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void t(Throwable th) {
        Inspire.f(th);
        us.pinguo.common.log.a.f(th);
        us.pinguo.user.util.i.b(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public /* synthetic */ void v(ProfileEntry profileEntry) {
        if (profileEntry != null) {
            this.mProfileView.hideLoading();
        }
        notifyProfileData(profileEntry);
        us.pinguo.common.log.a.m("ProfilePresenter", "load cache success.....", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void w(Throwable th) {
        Inspire.f(th);
        us.pinguo.common.log.a.f(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public /* synthetic */ void y(InspireCollectionInfo inspireCollectionInfo) {
        List<InspireWork> arrayList = new ArrayList<>();
        if (inspireCollectionInfo != null) {
            arrayList = inspireCollectionInfo.list;
            this.mLikeSp = inspireCollectionInfo.sp;
            ProfileAuthorInfo profileAuthorInfo = inspireCollectionInfo.authorInfo;
            this.mProfileAuthorInfo = profileAuthorInfo;
            int i2 = 0;
            if (arrayList != null && arrayList.size() > 0) {
                i2 = arrayList.get(0).authorRanking;
            }
            profileAuthorInfo.ranking = i2;
        }
        if (arrayList != null) {
            this.mFavoriteList.addAll(arrayList);
            this.mProfileView.appendData(arrayList);
        }
        this.mProfileView.hideLoadMore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public /* synthetic */ void A(Throwable th) {
        Inspire.f(th);
        us.pinguo.common.log.a.f(th);
        this.mProfileView.hideLoadMore();
    }

    public void addAttention(String str, final String str2) {
        addSubscription(new InspireAtentionLoader().addAttention(str, str2).subscribe(new Action1() { // from class: us.pinguo.inspire.module.profile.o0
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ProfilePresenter.this.b(str2, (InspireAttention) obj);
            }
        }, k0.a));
    }

    public void attachView(us.pinguo.foundation.p.b bVar) {
        IProfileView iProfileView = (IProfileView) bVar;
        this.mProfileView = iProfileView;
        this.mActivity = (Activity) iProfileView.getFragmentContext();
        this.mInspireWorks = new ArrayList();
        this.mFavoriteList = new ArrayList();
        this.mFlowerList = new ArrayList();
        this.mProfileLoader = new ProfileLoader();
        registerLoginout();
        if (this.mProfileView.getAuthorId().equals(us.pinguo.user.s0.getInstance().getUserId())) {
            getProfileCache();
        }
        this.mProfileView.showLoading();
        fetchProfileList(this.mProfileView.getAuthorId(), 0L);
        registerFeedDelete();
        registerRefreshProfile();
        registerScrollRecyclerViewToFirstPosition();
    }

    public void cancelAttention(String str, final String str2) {
        addSubscription(new InspireAtentionLoader().cancelAttention(str, str2).subscribe(new Action1() { // from class: us.pinguo.inspire.module.profile.l0
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ProfilePresenter.this.e(str2, (InspireAttention) obj);
            }
        }, u0.a));
    }

    public void fetchMyFavoriteList(String str, long j2, int i2) {
        ProfileLoader profileLoader = this.mProfileLoader;
        if (profileLoader != null) {
            addSubscription(profileLoader.fetchMyFavoriteList(new BigDecimal(j2), i2, str).subscribe(new Action1() { // from class: us.pinguo.inspire.module.profile.i0
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    ProfilePresenter.this.h((InspireCollectionInfo) obj);
                }
            }, new Action1() { // from class: us.pinguo.inspire.module.profile.c0
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    ProfilePresenter.this.j((Throwable) obj);
                }
            }));
        }
    }

    public void fetchMyFlowerList(String str, long j2, int i2) {
        ProfileLoader profileLoader = this.mProfileLoader;
        if (profileLoader != null) {
            addSubscription(profileLoader.fetchMyFlowerList(new BigDecimal(j2), i2, str).subscribe(new Action1() { // from class: us.pinguo.inspire.module.profile.j0
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    ProfilePresenter.this.l((InspireCollectionInfo) obj);
                }
            }, new Action1() { // from class: us.pinguo.inspire.module.profile.z
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    ProfilePresenter.this.n((Throwable) obj);
                }
            }));
        }
    }

    public void fetchProfileList(String str, long j2) {
        if (TextUtils.isEmpty(str)) {
            this.mProfileView.setOnRefreshComplete();
            return;
        }
        ProfileLoader profileLoader = this.mProfileLoader;
        if (profileLoader != null) {
            addSubscription(profileLoader.fetchProfileList(str, j2).subscribe(new Action1() { // from class: us.pinguo.inspire.module.profile.r0
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    ProfilePresenter.this.p((ProfileEntry) obj);
                }
            }, new Action1() { // from class: us.pinguo.inspire.module.profile.f0
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    ProfilePresenter.this.r((Throwable) obj);
                }
            }));
        }
    }

    public void fetchRecommendList(final String str) {
        addSubscription(new InspireAtentionLoader().fetchRecommedList(str).subscribe(new Action1() { // from class: us.pinguo.inspire.module.profile.p0
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                us.pinguo.foundation.r.d.a().b(new ShowProfileRecommendEvent(str, (List) obj));
            }
        }, t0.a));
    }

    public void fetchUserVipInfo(String str) {
        if (this.mActivity == null) {
            return;
        }
        us.pinguo.librouter.c.d.b().getInterface().o(this.mActivity, str);
    }

    public ProfileAuthorInfo getHeaderAuthorInfo() {
        return this.mProfileAuthorInfo;
    }

    public List<InspireWork> getMyFavoriteList() {
        return this.mFavoriteList;
    }

    public List<InspireWork> getMyFlowerList() {
        return this.mFlowerList;
    }

    public List<InspireWork> getMyWorkList() {
        return this.mInspireWorks;
    }

    public void getProfileCache() {
        ProfileLoader profileLoader = this.mProfileLoader;
        if (profileLoader != null) {
            addSubscription(profileLoader.getProfileFromDiskCache().subscribe(new Action1() { // from class: us.pinguo.inspire.module.profile.y
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    ProfilePresenter.this.v((ProfileEntry) obj);
                }
            }, q0.a));
        }
    }

    public void loadMoreFavarite(int i2, String str) {
        BigDecimal bigDecimal;
        BigDecimal bigDecimal2 = this.mLikeSp;
        if (bigDecimal2 != null && bigDecimal2.doubleValue() == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            this.mProfileView.hideLoadMore();
            return;
        }
        ProfileLoader profileLoader = this.mProfileLoader;
        if (profileLoader == null || (bigDecimal = this.mLikeSp) == null) {
            return;
        }
        addSubscription(profileLoader.fetchMyFavoriteList(bigDecimal, i2, str).subscribe(new Action1() { // from class: us.pinguo.inspire.module.profile.e0
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ProfilePresenter.this.y((InspireCollectionInfo) obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.module.profile.u
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ProfilePresenter.this.A((Throwable) obj);
            }
        }));
    }

    public void loadMoreFlowerWork(int i2, String str) {
        BigDecimal bigDecimal;
        BigDecimal bigDecimal2 = this.mFlowerSp;
        if (bigDecimal2 != null && bigDecimal2.doubleValue() == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            this.mProfileView.hideLoadMore();
            return;
        }
        ProfileLoader profileLoader = this.mProfileLoader;
        if (profileLoader == null || (bigDecimal = this.mFlowerSp) == null) {
            return;
        }
        addSubscription(profileLoader.fetchMyFlowerList(bigDecimal, i2, str).subscribe(new Action1() { // from class: us.pinguo.inspire.module.profile.t
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ProfilePresenter.this.C((InspireCollectionInfo) obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.module.profile.w
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ProfilePresenter.this.E((Throwable) obj);
            }
        }));
    }

    public void loadMoreWorks(String str, long j2) {
        if (TextUtils.isEmpty(str)) {
            this.mProfileView.hideLoadMore();
            return;
        }
        ProfileLoader profileLoader = this.mProfileLoader;
        if (profileLoader != null) {
            addSubscription(profileLoader.fetchProfileList(str, j2).subscribe(new Action1() { // from class: us.pinguo.inspire.module.profile.a0
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    ProfilePresenter.this.G((ProfileEntry) obj);
                }
            }, new Action1() { // from class: us.pinguo.inspire.module.profile.n0
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    ProfilePresenter.this.I((Throwable) obj);
                }
            }));
        }
    }

    public void registerFeedDelete() {
        addSubscription(us.pinguo.foundation.r.d.a().c(us.pinguo.inspire_proxy.a.a.class).subscribe(new Action1() { // from class: us.pinguo.inspire.module.profile.b0
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ProfilePresenter.this.K((us.pinguo.inspire_proxy.a.a) obj);
            }
        }, m0.a));
    }

    public void registerLoginout() {
        addSubscription(us.pinguo.foundation.r.d.a().c(us.pinguo.foundation.r.a.class).subscribe(new Action1() { // from class: us.pinguo.inspire.module.profile.h0
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ProfilePresenter.this.N((us.pinguo.foundation.r.a) obj);
            }
        }, d0.a));
    }

    public void registerRefreshProfile() {
        addSubscription(us.pinguo.foundation.r.d.a().c(us.pinguo.user.event.a.class).subscribe(new Action1() { // from class: us.pinguo.inspire.module.profile.g0
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ProfilePresenter.this.Q((us.pinguo.user.event.a) obj);
            }
        }, s0.a));
    }
}

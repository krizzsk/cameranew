package us.pinguo.inspire.module.contact;

import android.content.ContentResolver;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.math.BigDecimal;
import rx.functions.Action1;
import us.pinguo.inspire.module.contact.ContactLoader;
import us.pinguo.inspire.module.contact.entry.ThirdSiteInfo;
import us.pinguo.inspire.module.contact.entry.ThirdSiteRedDot;
/* loaded from: classes9.dex */
public class ContactPresenter extends us.pinguo.foundation.p.a {
    public static int DEFAULT_NUM = 30;
    private static final String TAG = "ContactPresenter";
    private ContactLoader mContactLoader;
    private IContactView mContactView;
    private BigDecimal mRecommendSp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(Throwable th) {
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.g(TAG, th.getMessage(), new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void d(ThirdSiteInfo thirdSiteInfo) {
        us.pinguo.common.log.a.m(TAG, "bind success................", new Object[0]);
        if (thirdSiteInfo != null) {
            this.mContactView.onBindThirdSiteSuccess(thirdSiteInfo.siteCode, thirdSiteInfo.accessToken);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void e(Throwable th) {
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.f(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ void g(BigDecimal bigDecimal, ContactLoader.RecommendResp recommendResp) {
        this.mRecommendSp = recommendResp.sp;
        if (bigDecimal.doubleValue() == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            this.mContactView.setRecommend(recommendResp.list);
        } else {
            this.mContactView.appendRecommend(recommendResp.list);
        }
        hideLoadingOrLoadMore(bigDecimal.doubleValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public /* synthetic */ void i(BigDecimal bigDecimal, Throwable th) {
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.f(th);
        us.pinguo.user.util.i.b(th);
        hideLoadingOrLoadMore(bigDecimal.doubleValue());
    }

    private void hideLoadingOrLoadMore(double d2) {
        if (d2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            this.mContactView.hideLoading();
        } else {
            this.mContactView.hideLoadMore();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public /* synthetic */ void k(Integer num) {
        us.pinguo.common.log.a.m(TAG, "red dot count:" + num, new Object[0]);
        this.mContactView.setRedDotCount(num.intValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void l(Throwable th) {
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.f(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public /* synthetic */ void n(ThirdSiteRedDot thirdSiteRedDot) {
        us.pinguo.common.log.a.m(TAG, "sina friend count:" + thirdSiteRedDot.sina, new Object[0]);
        this.mContactView.setThirdSiteFriendCount(thirdSiteRedDot);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void o(Throwable th) {
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.f(th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void p(Throwable th) {
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.f(th);
    }

    public void addBook(ContentResolver contentResolver) {
        addSubscription(this.mContactLoader.addBook(contentResolver).subscribe(y.a, z.a));
    }

    public void attachView(us.pinguo.foundation.p.b bVar) {
        this.mContactView = (IContactView) bVar;
        this.mContactLoader = new ContactLoader();
        fetchRedDotCount();
        fetchThirdSiteFriendCount();
        fetchRecommendList(new BigDecimal(0), DEFAULT_NUM);
        registerRefreshRedDot();
    }

    public void bindThirdSite(String str, String str2, String str3, long j2, String str4) {
        addSubscription(this.mContactLoader.bindThirdSite(str, str2, str3, j2, str4).subscribe(new Action1() { // from class: us.pinguo.inspire.module.contact.w
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ContactPresenter.this.d((ThirdSiteInfo) obj);
            }
        }, t.a));
    }

    public void fetchRecommendList(final BigDecimal bigDecimal, int i2) {
        if (bigDecimal.doubleValue() == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            this.mContactView.showLoadingKeepHeader();
        }
        addSubscription(this.mContactLoader.fetchRecommendList(bigDecimal, i2).subscribe(new Action1() { // from class: us.pinguo.inspire.module.contact.r
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ContactPresenter.this.g(bigDecimal, (ContactLoader.RecommendResp) obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.module.contact.x
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ContactPresenter.this.i(bigDecimal, (Throwable) obj);
            }
        }));
    }

    public void fetchRedDotCount() {
        addSubscription(this.mContactLoader.fetchRedDotCount().subscribe(new Action1() { // from class: us.pinguo.inspire.module.contact.q
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ContactPresenter.this.k((Integer) obj);
            }
        }, u.a));
    }

    public void fetchThirdSiteFriendCount() {
        addSubscription(this.mContactLoader.fetchThirdFriendCount().subscribe(new Action1() { // from class: us.pinguo.inspire.module.contact.v
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ContactPresenter.this.n((ThirdSiteRedDot) obj);
            }
        }, p.a));
    }

    public void loadMoreRecommed() {
        fetchRecommendList(this.mRecommendSp, DEFAULT_NUM);
    }

    public void registerRefreshRedDot() {
        addSubscription(us.pinguo.foundation.r.d.a().c(us.pinguo.inspire.event.d.class).subscribe(new Action1<us.pinguo.inspire.event.d>() { // from class: us.pinguo.inspire.module.contact.ContactPresenter.1
            @Override // rx.functions.Action1
            public void call(us.pinguo.inspire.event.d dVar) {
                if (dVar.a) {
                    ContactPresenter.this.fetchRedDotCount();
                } else {
                    ContactPresenter.this.fetchThirdSiteFriendCount();
                }
            }
        }, s.a));
    }
}

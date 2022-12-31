package us.pinguo.inspire.module.attention;

import java.math.BigDecimal;
import rx.functions.Action1;
import us.pinguo.inspire.module.attention.InspireAtentionLoader;
import us.pinguo.user.s0;
/* loaded from: classes9.dex */
public class InspireAttentionPresenter extends us.pinguo.foundation.p.a {
    public static final int TYPE_ATTENTION = 1;
    public static final int TYPE_FANS = 2;
    private InspireAtentionLoader mAtentionLoader;
    private BigDecimal mAttentionSp;
    private BigDecimal mFansSp;
    private IAttentionView mIAttentionView;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void b(InspireAtentionLoader.AttentionResp attentionResp) {
        this.mFansSp = attentionResp.sp;
        us.pinguo.common.log.a.m("AttentionActivity", "fans：" + attentionResp.list.size() + "", new Object[0]);
        this.mIAttentionView.showFansList(attentionResp.list);
        this.mIAttentionView.setComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void d(Throwable th) {
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.f(th);
        this.mIAttentionView.setComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void f(InspireAtentionLoader.AttentionResp attentionResp) {
        this.mAttentionSp = attentionResp.sp;
        us.pinguo.common.log.a.m("InspireAttentionPresenter", attentionResp.list.size() + "", new Object[0]);
        this.mIAttentionView.setAttentionList(attentionResp.list);
        this.mIAttentionView.setComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void h(Throwable th) {
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.f(th);
        this.mIAttentionView.setComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public /* synthetic */ void j(InspireAtentionLoader.AttentionResp attentionResp) {
        this.mFansSp = attentionResp.sp;
        this.mIAttentionView.appendDataList(attentionResp.list);
        this.mIAttentionView.hideLoadMore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public /* synthetic */ void l(Throwable th) {
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.f(th);
        this.mIAttentionView.hideLoadMore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public /* synthetic */ void n(InspireAtentionLoader.AttentionResp attentionResp) {
        this.mAttentionSp = attentionResp.sp;
        this.mIAttentionView.appendDataList(attentionResp.list);
        this.mIAttentionView.hideLoadMore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public /* synthetic */ void p(Throwable th) {
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.f(th);
        this.mIAttentionView.hideLoadMore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public /* synthetic */ void r(AttentionItemCell attentionItemCell) {
        this.mIAttentionView.removeItem(attentionItemCell);
    }

    private void registerCancelAttentionNotify() {
        addSubscription(us.pinguo.foundation.r.d.a().c(AttentionItemCell.class).subscribe(new Action1() { // from class: us.pinguo.inspire.module.attention.c
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                InspireAttentionPresenter.this.r((AttentionItemCell) obj);
            }
        }, k.a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void s(Throwable th) {
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.f(th);
    }

    public void attachView(us.pinguo.foundation.p.b bVar) {
        this.mIAttentionView = (IAttentionView) bVar;
        this.mAtentionLoader = new InspireAtentionLoader();
        String userId = s0.getInstance().e() ? s0.getInstance().getUserId() : "";
        if (this.mIAttentionView.getType() == 1) {
            fetchFollows(userId, this.mIAttentionView.getMasterUserId());
        } else {
            fetchFans(userId, this.mIAttentionView.getMasterUserId());
        }
        registerCancelAttentionNotify();
    }

    @Override // us.pinguo.foundation.p.a
    public void detachView() {
        super.detachView();
        this.mIAttentionView = null;
    }

    public void fetchFans(String str, String str2) {
        addSubscription(this.mAtentionLoader.fetchFansList(str, str2).subscribe(new Action1() { // from class: us.pinguo.inspire.module.attention.l
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                InspireAttentionPresenter.this.b((InspireAtentionLoader.AttentionResp) obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.module.attention.j
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                InspireAttentionPresenter.this.d((Throwable) obj);
            }
        }));
    }

    public void fetchFollows(String str, String str2) {
        addSubscription(this.mAtentionLoader.fetchAttentionList(str, str2, false).subscribe(new Action1() { // from class: us.pinguo.inspire.module.attention.h
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                InspireAttentionPresenter.this.f((InspireAtentionLoader.AttentionResp) obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.module.attention.f
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                InspireAttentionPresenter.this.h((Throwable) obj);
            }
        }));
    }

    public BigDecimal getAttentionSp() {
        return this.mAttentionSp;
    }

    public BigDecimal getFansSp() {
        return this.mFansSp;
    }

    public void loadMoreFans(String str, String str2, BigDecimal bigDecimal) {
        addSubscription(this.mAtentionLoader.fetchFansList(str, str2, bigDecimal).subscribe(new Action1() { // from class: us.pinguo.inspire.module.attention.g
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                InspireAttentionPresenter.this.j((InspireAtentionLoader.AttentionResp) obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.module.attention.i
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                InspireAttentionPresenter.this.l((Throwable) obj);
            }
        }));
    }

    public void loadMoreFollows(String str, String str2, BigDecimal bigDecimal) {
        addSubscription(this.mAtentionLoader.fetchAttentionList(str, str2, false, bigDecimal).subscribe(new Action1() { // from class: us.pinguo.inspire.module.attention.e
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                InspireAttentionPresenter.this.n((InspireAtentionLoader.AttentionResp) obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.module.attention.d
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                InspireAttentionPresenter.this.p((Throwable) obj);
            }
        }));
    }
}

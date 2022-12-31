package us.pinguo.camera360.shop;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.huawei.HuaweiAgent;
import com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel;
import com.pinguo.camera360.k.b.a;
import com.pinguo.camera360.member.C360MemberRepository;
import com.pinguo.camera360.member.MemberRightsActivity;
import com.pinguo.camera360.member.PayChinaMobileWebViewActivity;
import com.pinguo.camera360.member.SubscriptionMemberActivity;
import com.pinguo.camera360.newShop.model.StoreHistoryNew;
import com.pinguo.camera360.newShop.model.StoreOrder;
import com.pinguo.camera360.newShop.model.StoreOrderItem;
import com.pinguo.camera360.ui.TitleBarLayout;
import com.pinguo.camera360.vip.VipManager;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.b.l;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import rx.functions.Action1;
import us.pinguo.camera2020.activity.y;
import us.pinguo.camera360.shop.StoreActivity2;
import us.pinguo.camera360.shop.activity.StoreManagerFilterActivity;
import us.pinguo.camera360.shop.activity.StoreRecoveryFilterActivity;
import us.pinguo.camera360.shop.cardsviewpager.CycleViewPager;
import us.pinguo.camera360.shop.cardsviewpager.StoreCardFragment;
import us.pinguo.camera360.shop.cardsviewpager.StoreIndicatorTextView;
import us.pinguo.camera360.shop.cardsviewpager.StoreVipFragment;
import us.pinguo.camera360.shop.data.FilterType;
import us.pinguo.camera360.shop.data.install.FilterOperateManager;
import us.pinguo.camera360.shop.data.install.p;
import us.pinguo.camera360.shop.data.install.w;
import us.pinguo.camera360.shop.data.k;
import us.pinguo.camera360.shop.data.show.BaseShow;
import us.pinguo.camera360.shop.data.show.ShowPkg;
import us.pinguo.camera360.shop.data.show.ShowScene;
import us.pinguo.camera360.shop.data.show.ShowTopic;
import us.pinguo.camera360.shop.data.show.UnlockManager;
import us.pinguo.camera360.shop.data.show.UnlockType;
import us.pinguo.camera360.shop.data.show.s;
import us.pinguo.camera360.shop.data.show.u;
import us.pinguo.camera360.shop.details.PkgDetailsView;
import us.pinguo.camera360.shop.details.TopicDetailsView;
import us.pinguo.camera360.shop.view.details.DetailsLoadView;
import us.pinguo.foundation.base.SubscriptionActivity;
import us.pinguo.foundation.eventbus.PGEventBus;
import us.pinguo.foundation.utils.k0;
import us.pinguo.inspire.module.MissionDetail.TaskDetailBasePresenter;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.paylibcenter.C360MemberPayHelp;
import us.pinguo.paylibcenter.PayCallback;
import us.pinguo.paylibcenter.PayHelp;
import us.pinguo.paylibcenter.bean.PayResult;
import us.pinguo.payssion.PayssionManager;
import us.pinguo.share.core.PGShareListener;
import us.pinguo.share.core.ShareSite;
import us.pinguo.user.u0;
import us.pinguo.util.q;
import us.pinguo.widget.common.guide.GuideHandler;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class StoreActivity2 extends SubscriptionActivity implements us.pinguo.camera360.shop.details.g, PGShareListener, us.pinguo.foundation.p.b, j, us.pinguo.paylibcenter.e {
    private static final String C = StoreActivity2.class.getSimpleName();
    private PayCallback A;
    private PopupWindow B;
    private StoreVipLayout b;
    private CycleViewPager c;

    /* renamed from: d  reason: collision with root package name */
    private MagicIndicator f9544d;

    /* renamed from: e  reason: collision with root package name */
    private CommonNavigator f9545e;

    /* renamed from: f  reason: collision with root package name */
    private us.pinguo.camera360.shop.cardsviewpager.i f9546f;

    /* renamed from: l  reason: collision with root package name */
    private u f9552l;
    private StoreActivity2 m;
    private us.pinguo.camera360.shop.details.h o;
    private us.pinguo.camera360.shop.details.i p;
    private PkgDetailsView q;
    private TopicDetailsView r;
    private DetailsLoadView v;
    private PGShareListener w;
    private GuideHandler x;
    private C360MemberRepository y;
    private boolean a = false;

    /* renamed from: g  reason: collision with root package name */
    private List<ShowScene> f9547g = null;

    /* renamed from: h  reason: collision with root package name */
    private boolean f9548h = false;

    /* renamed from: i  reason: collision with root package name */
    private String f9549i = null;

    /* renamed from: j  reason: collision with root package name */
    private List<String> f9550j = null;

    /* renamed from: k  reason: collision with root package name */
    private ArrayMap<String, p> f9551k = new ArrayMap<>();
    private int n = 0;
    private String s = TaskDetailBasePresenter.SCENE_LIST;
    private boolean t = false;
    private boolean u = false;
    private boolean z = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements s {
        a() {
        }

        @Override // us.pinguo.camera360.shop.data.show.s
        public void a() {
            if ((Build.VERSION.SDK_INT < 17 || !StoreActivity2.this.m.isDestroyed()) && !StoreActivity2.this.m.isFinishing()) {
                StoreActivity2.this.m1();
            }
        }

        @Override // us.pinguo.camera360.shop.data.show.s
        public void b(List<ShowScene> list) {
            if ((Build.VERSION.SDK_INT < 17 || !StoreActivity2.this.m.isDestroyed()) && !StoreActivity2.this.m.isFinishing()) {
                StoreActivity2.this.r1(list);
            }
        }

        @Override // us.pinguo.camera360.shop.data.show.s
        public void c(Exception exc) {
            us.pinguo.common.log.a.e("update data error:" + exc.getMessage() + "\n" + Log.getStackTraceString(exc), new Object[0]);
            if ((Build.VERSION.SDK_INT < 17 || !StoreActivity2.this.m.isDestroyed()) && !StoreActivity2.this.m.isFinishing()) {
                StoreActivity2.this.m1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b extends net.lucode.hackware.magicindicator.buildins.commonnavigator.a.a {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: h */
        public /* synthetic */ void i(int i2, View view) {
            VdsAgent.lambdaOnClick(view);
            String str = StoreActivity2.C;
            us.pinguo.common.log.a.d(str, "tab onClick=" + i2, new Object[0]);
            StoreActivity2.this.c.setCurrentItemForNear(i2, true);
        }

        @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.a
        public int a() {
            return StoreActivity2.this.f9547g.size();
        }

        @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.a
        public net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c b(Context context) {
            LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
            linePagerIndicator.setMode(1);
            linePagerIndicator.setColors(-209109);
            return linePagerIndicator;
        }

        @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.a
        public net.lucode.hackware.magicindicator.buildins.commonnavigator.a.d c(Context context, final int i2) {
            ShowScene showScene = (ShowScene) StoreActivity2.this.f9547g.get(i2);
            StoreIndicatorTextView storeIndicatorTextView = new StoreIndicatorTextView(context);
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{16843868});
            storeIndicatorTextView.setBackground(obtainStyledAttributes.getDrawable(0));
            obtainStyledAttributes.recycle();
            storeIndicatorTextView.setTextSize(16.0f);
            if (showScene.isVip()) {
                storeIndicatorTextView.setNormalColor(-13421773);
                storeIndicatorTextView.setSelectedColor(-13421773);
            } else {
                storeIndicatorTextView.setNormalColor(-10066330);
                storeIndicatorTextView.setSelectedColor(-13421773);
            }
            storeIndicatorTextView.setText(showScene.getName());
            StoreActivity2.this.k1(storeIndicatorTextView, showScene);
            storeIndicatorTextView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera360.shop.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StoreActivity2.b.this.i(i2, view);
                }
            });
            storeIndicatorTextView.setVipBackground(showScene.isVip());
            return storeIndicatorTextView;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements ViewPager.OnPageChangeListener {
        c() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            ShowScene showScene = (ShowScene) StoreActivity2.this.f9547g.get(i2);
            StoreActivity2 storeActivity2 = StoreActivity2.this;
            storeActivity2.j1((StoreIndicatorTextView) storeActivity2.f9545e.j(i2), showScene);
            a.b.l(showScene.getId());
            k.f(showScene.getId());
            k.a.e(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d implements TitleBarLayout.a {
        final /* synthetic */ TitleBarLayout a;

        d(TitleBarLayout titleBarLayout) {
            this.a = titleBarLayout;
        }

        @Override // com.pinguo.camera360.ui.TitleBarLayout.a
        public void onLeftBtnClick(View view) {
            if (StoreActivity2.this.q1()) {
                return;
            }
            StoreActivity2.this.l1(null);
        }

        @Override // com.pinguo.camera360.ui.TitleBarLayout.a
        public void onRightBtnClick(View view) {
            StoreActivity2.this.S0(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e implements UnlockManager.h {
        e() {
        }

        @Override // us.pinguo.camera360.shop.data.show.UnlockManager.h
        public void a(BaseShow baseShow) {
        }

        @Override // us.pinguo.camera360.shop.data.show.UnlockManager.h
        public void b(BaseShow baseShow) {
            if (baseShow instanceof ShowPkg) {
                ShowPkg showPkg = (ShowPkg) baseShow;
                if (showPkg.getType() == UnlockType.SHARE) {
                    a.b.o(a.b.a, showPkg.getId(), a.b.f6821e);
                } else if (showPkg.getType() == UnlockType.MEMBER) {
                    a.b.o(a.b.a, showPkg.getId(), a.b.f6822f);
                }
                if (StoreActivity2.this.q.isShowing()) {
                    StoreActivity2.this.o.x(showPkg);
                }
                us.pinguo.common.log.a.m(StoreActivity2.C, "goUnlock onUnlocked", new Object[0]);
                StoreActivity2.this.v1(showPkg.getType());
                if (q.h(StoreActivity2.this)) {
                    StoreActivity2.this.O0(showPkg);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    class f implements w {
        final /* synthetic */ ShowPkg a;
        final /* synthetic */ us.pinguo.camera360.shop.data.h b;

        f(ShowPkg showPkg, us.pinguo.camera360.shop.data.h hVar) {
            this.a = showPkg;
            this.b = hVar;
        }

        @Override // us.pinguo.camera360.shop.data.install.w
        public void a(int i2) {
            if (i2 == 0) {
                if (StoreActivity2.this.q.isShowing()) {
                    StoreActivity2.this.o.y(this.a.getId(), -1);
                }
                if (StoreActivity2.this.r.isShowing()) {
                    StoreActivity2.this.p.n(this.a);
                }
                StoreActivity2.this.f9548h = true;
                if (StoreActivity2.this.f9550j == null) {
                    StoreActivity2.this.f9550j = new ArrayList();
                }
                StoreActivity2.this.f9550j.add(this.b.f());
                StoreActivity2.this.t1(this.a.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class g implements DialogInterface.OnClickListener {
        g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        @Instrumented
        public void onClick(DialogInterface dialogInterface, int i2) {
            VdsAgent.onClick(this, dialogInterface, i2);
            if (i2 == -1) {
                dialogInterface.dismiss();
                return;
            }
            FilterOperateManager.h().e();
            dialogInterface.dismiss();
            StoreActivity2.this.l1(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class h implements p {
        private String a;

        h(String str) {
            this.a = str;
        }

        @Override // us.pinguo.camera360.shop.data.install.p
        public void a(us.pinguo.camera360.shop.data.install.q qVar) {
            us.pinguo.common.log.a.c("install finished,id:" + qVar.c() + ",success:" + qVar.d() + ",errorCode:" + qVar.a(), new Object[0]);
            if (qVar.b() != null) {
                qVar.b().printStackTrace();
            }
            if (qVar.d()) {
                if (StoreActivity2.this.r.isShowing()) {
                    StoreActivity2.this.p.r(this.a, 100);
                }
                if (StoreActivity2.this.q.isShowing()) {
                    StoreActivity2.this.o.y(this.a, 100);
                }
                us.pinguo.foundation.statistics.h.a.I("", this.a, "download_success", "1");
            } else {
                if (StoreActivity2.this.r.isShowing()) {
                    StoreActivity2.this.p.r(this.a, -1);
                }
                if (StoreActivity2.this.q.isShowing()) {
                    StoreActivity2.this.o.y(this.a, -1);
                }
                Toast makeText = Toast.makeText(StoreActivity2.this, (int) R.string.download_error_retry, 1);
                makeText.show();
                VdsAgent.showToast(makeText);
            }
            StoreActivity2.this.t1(this.a);
        }

        @Override // us.pinguo.camera360.shop.data.install.p
        public void b(String str) {
            StoreActivity2.this.t1(this.a);
            if (StoreActivity2.this.r.isShowing()) {
                StoreActivity2.this.p.r(this.a, 0);
            }
            if (StoreActivity2.this.q.isShowing()) {
                StoreActivity2.this.o.y(this.a, 0);
            }
        }

        @Override // us.pinguo.camera360.shop.data.install.p
        public void c(String str, int i2) {
            if (StoreActivity2.this.q.isShowing()) {
                StoreActivity2.this.o.y(str, i2);
            }
        }
    }

    private void L0(Intent intent) {
        VipManager vipManager = VipManager.a;
        if (!vipManager.G() && !vipManager.H()) {
            intent.setClass(this, MemberRightsActivity.class);
        } else {
            intent.setClass(this, SubscriptionMemberActivity.class);
        }
        startActivityForResult(intent, 4);
    }

    private void M0() {
        Set<String> i2 = FilterOperateManager.h().i();
        if (i2 == null || i2.size() <= 0) {
            return;
        }
        for (String str : i2) {
            h hVar = new h(str);
            this.f9551k.put(str, hVar);
            FilterOperateManager.h().q(str, hVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(ShowPkg showPkg) {
        h hVar = new h(showPkg.getId());
        if (FilterOperateManager.h().k(showPkg.getId())) {
            hVar.a(new us.pinguo.camera360.shop.data.install.q(showPkg.getId(), true, 0, null));
            return;
        }
        this.f9551k.put(showPkg.getId(), hVar);
        FilterOperateManager.h().q(showPkg.getId(), hVar);
        FilterOperateManager.h().m(showPkg);
        us.pinguo.foundation.statistics.h.a.I("", showPkg.getId(), "download_begin", "1");
    }

    private void P0(ShowPkg showPkg) {
        this.f9552l.p(showPkg, new e(), this);
    }

    private void Q0() {
        this.m.startActivityForResult(new Intent(this.m, StoreManagerFilterActivity.class), 2);
    }

    private void R0(List<ShowScene> list) {
        if (!TaskDetailBasePresenter.SCENE_LIST.equalsIgnoreCase(this.s)) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                ShowScene showScene = list.get(i2);
                if (this.s.equals(showScene.getId())) {
                    this.c.setCurrentItemForCenter(i2, false);
                    k.f(showScene.getId());
                    return;
                }
            }
            return;
        }
        us.pinguo.common.log.a.m("chenxiaokai", "goto scenenid is -1", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0(TitleBarLayout titleBarLayout) {
        if (this.B == null) {
            this.B = new us.pinguo.camera360.shop.view.details.f().c(this, new String[]{us.pinguo.common.utils.k.c(R.string.store_recovery_title), us.pinguo.common.utils.k.c(R.string.str_manage_collected_filter)}, new l() { // from class: us.pinguo.camera360.shop.d
                @Override // kotlin.jvm.b.l
                public final Object invoke(Object obj) {
                    return StoreActivity2.this.Y0((Integer) obj);
                }
            });
        }
        if (this.B.isShowing()) {
            this.B.dismiss();
            return;
        }
        PopupWindow popupWindow = this.B;
        ImageView d2 = titleBarLayout.d();
        popupWindow.showAsDropDown(d2);
        VdsAgent.showAsDropDown(popupWindow, d2);
    }

    private void U0() {
        if (u.b().r(new a(), true)) {
            this.v.e();
        } else {
            m1();
        }
        boolean i2 = this.y.i();
        us.pinguo.common.log.a.k("needSync = " + i2, new Object[0]);
        if (i2) {
            this.y.r(this, false);
        }
        us.pinguo.camera360.shop.data.i.e().u();
    }

    private void V0() {
        ((ViewStub) findViewById(R.id.store_pkg_details_vs)).inflate();
        ((ViewStub) findViewById(R.id.store_topic_details_vs)).inflate();
        this.r = (TopicDetailsView) findViewById(R.id.store_topic_details_view);
        this.q = (PkgDetailsView) findViewById(R.id.store_pkg_details_view);
        us.pinguo.camera360.shop.details.h hVar = new us.pinguo.camera360.shop.details.h();
        this.o = hVar;
        hVar.i(this.q);
        this.q.setPresenter(this.o);
        us.pinguo.camera360.shop.details.i iVar = new us.pinguo.camera360.shop.details.i();
        this.p = iVar;
        iVar.i(this.r);
        this.r.setPresenter(this.p);
        this.p.a(this);
        this.o.a(this);
        this.r.setVisiableListener(this);
        this.q.setVisiableListener(this);
    }

    private void W0() {
        CommonNavigator commonNavigator = new CommonNavigator(this);
        this.f9545e = commonNavigator;
        commonNavigator.setAdapter(new b());
        this.f9544d.setNavigator(this.f9545e);
        us.pinguo.camera360.shop.cardsviewpager.h.a(this.f9544d, this.c);
        this.c.addOnPageChangeListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X0 */
    public /* synthetic */ kotlin.u Y0(Integer num) {
        if (num.intValue() == 0) {
            startActivityForResult(new Intent(this, StoreRecoveryFilterActivity.class), 18);
        } else {
            a.b.m(a.b.a);
            Q0();
        }
        this.B.dismiss();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z0 */
    public /* synthetic */ void a1(View view) {
        VdsAgent.lambdaOnClick(view);
        us.pinguo.foundation.statistics.h.a.u("goto_free_trial", "click");
        Intent intent = new Intent();
        intent.putExtra("source_page", "store_vip_banner");
        intent.putExtra("source_extra", "store_vip_banner");
        L0(intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Map b1() {
        HashMap hashMap = new HashMap();
        u0.e(BaseApplication.d(), hashMap);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Map c1() {
        HashMap hashMap = new HashMap();
        u0.e(BaseApplication.d(), hashMap);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d1 */
    public /* synthetic */ void e1(us.pinguo.foundation.r.c cVar) {
        w1();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void f1(Throwable th) {
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.f(th);
    }

    private void g1() {
        if (this.n == 0) {
            if (this.q.isShowing()) {
                this.q.t();
            } else if (this.r.isShowing()) {
                this.r.s();
            }
        } else if (this.q.isShowing() && this.n == 1) {
            this.q.t();
        } else {
            l1(null);
        }
    }

    private void h1() {
        View findViewById = findViewById(R.id.store_title_layout);
        findViewById.setVisibility(4);
        VdsAgent.onSetViewVisibility(findViewById, 4);
    }

    private void i1() {
        addSubscription(us.pinguo.foundation.r.d.a().c(us.pinguo.foundation.r.c.class).subscribe(new Action1() { // from class: us.pinguo.camera360.shop.g
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                StoreActivity2.this.e1((us.pinguo.foundation.r.c) obj);
            }
        }, us.pinguo.camera360.shop.c.a));
    }

    private void initView() {
        TitleBarLayout titleBarLayout = (TitleBarLayout) findViewById(R.id.store_title_layout);
        titleBarLayout.setTiTleText(R.string.effect_store);
        titleBarLayout.setRightImageBtnRes(R.drawable.ic_store_setting);
        titleBarLayout.q();
        titleBarLayout.setOnTitleBarClickListener(new d(titleBarLayout));
        this.v = (DetailsLoadView) findViewById(R.id.store_details_dlv);
        this.c = (CycleViewPager) findViewById(R.id.store_main_viewPager);
        this.f9544d = (MagicIndicator) findViewById(R.id.store_main_table_indicator);
        this.f9546f = new us.pinguo.camera360.shop.cardsviewpager.i(getSupportFragmentManager());
        StoreVipLayout storeVipLayout = (StoreVipLayout) findViewById(R.id.layout_vip);
        this.b = storeVipLayout;
        storeVipLayout.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera360.shop.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StoreActivity2.this.a1(view);
            }
        });
        if (VipManager.a.e(true)) {
            StoreVipLayout storeVipLayout2 = this.b;
            storeVipLayout2.setVisibility(8);
            VdsAgent.onSetViewVisibility(storeVipLayout2, 8);
            return;
        }
        us.pinguo.foundation.statistics.h.a.u("goto_free_trial", "show");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j1(StoreIndicatorTextView storeIndicatorTextView, ShowScene showScene) {
        us.pinguo.common.log.a.m(C, MessageFormat.format("redPoint setSceneRedPointDismiss hasRedPoint={0},id={1}", Boolean.valueOf(showScene.hasRedPoint()), showScene.getId()), new Object[0]);
        if (showScene.hasRedPoint()) {
            storeIndicatorTextView.setHasRedPoint(false);
            showScene.clearRedPoint();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k1(StoreIndicatorTextView storeIndicatorTextView, ShowScene showScene) {
        us.pinguo.common.log.a.m(C, MessageFormat.format("redPoint setSceneRedPointVisible hasRedPoint={0},id={1}", Boolean.valueOf(showScene.hasRedPoint()), showScene.getId()), new Object[0]);
        if (showScene.hasRedPoint()) {
            storeIndicatorTextView.setHasRedPoint(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m1() {
        try {
            r1(u.b().d(this.a));
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
            r1(null);
        }
    }

    private void p1() {
        if (this.n == 0 && CameraBusinessSettingModel.v().o()) {
            GuideHandler k2 = GuideHandler.k(this);
            k2.H("store_setting_guide", 1);
            k2.B(GuideHandler.Gravity.LEFT);
            k2.G(GuideHandler.VGravity.DOWN);
            k2.w(false);
            k2.C(R.drawable.emoji_glass);
            k2.A(R.drawable.guide_toast_upleft);
            k2.z(50, 0);
            k2.F(getResources().getString(R.string.store_setting_guide));
            this.x = k2;
            this.x.x(findViewById(R.id.title_right_img_btn));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q1() {
        if (FilterOperateManager.h().i().isEmpty()) {
            return false;
        }
        us.pinguo.foundation.utils.w.i(this, R.string.exit_when_filter_downloading, R.string.filter_downloading_positive, R.string.filter_downloading_negative, new g());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r1(List<ShowScene> list) {
        if (list == null) {
            this.v.d();
            return;
        }
        this.v.b();
        this.f9547g = list;
        this.f9546f.h(list);
        this.c.setAdapter((us.pinguo.camera360.shop.cardsviewpager.g) this.f9546f);
        this.c.setOffscreenPageLimit(1);
        W0();
        String str = this.f9549i;
        if (str != null) {
            this.s = str;
            R0(this.f9547g);
        }
    }

    private void s1() {
        for (Map.Entry<String, p> entry : this.f9551k.entrySet()) {
            FilterOperateManager.h().u(entry.getKey());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t1(String str) {
        for (int i2 = 0; i2 < this.f9546f.b(); i2++) {
            Fragment item = this.f9546f.getItem(i2);
            if (item instanceof StoreCardFragment) {
                ((StoreCardFragment) item).b0(str);
            }
            if (item instanceof StoreVipFragment) {
                ((StoreVipFragment) item).a0(str);
            }
        }
    }

    private void u1(List<String> list) {
        if (list == null) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            String str = list.get(i2);
            for (int i3 = 0; i3 < this.f9546f.b(); i3++) {
                Fragment item = this.f9546f.getItem(i3);
                if (item instanceof StoreCardFragment) {
                    ((StoreCardFragment) item).b0(str);
                }
                if (item instanceof StoreVipFragment) {
                    ((StoreVipFragment) item).a0(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v1(UnlockType unlockType) {
        for (int i2 = 0; i2 < this.f9546f.b(); i2++) {
            Fragment item = this.f9546f.getItem(i2);
            if (item instanceof StoreCardFragment) {
                ((StoreCardFragment) item).c0(unlockType);
            }
            if (item instanceof StoreVipFragment) {
                ((StoreVipFragment) item).b0(unlockType);
            }
        }
    }

    private void w1() {
        StoreOrder storeOrder;
        List<StoreOrderItem> list;
        try {
            StoreHistoryNew c2 = u.b().c();
            if (c2 == null || (storeOrder = c2.data) == null || (list = storeOrder.lists) == null || list.size() < 1) {
                return;
            }
            HashSet<StoreOrderItem> hashSet = new HashSet(list);
            ArrayList arrayList = new ArrayList();
            for (StoreOrderItem storeOrderItem : hashSet) {
                if (storeOrderItem.type == 1) {
                    arrayList.add(storeOrderItem.productId);
                }
            }
            u1(arrayList);
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
        }
    }

    @Override // us.pinguo.camera360.shop.details.g
    public void H(ShowPkg showPkg) {
        us.pinguo.common.log.a.c("onShareLockClick", new Object[0]);
        P0(showPkg);
    }

    @Override // us.pinguo.camera360.shop.details.g
    public void L(ShowPkg showPkg) {
        us.pinguo.common.log.a.c("onPayLockClick", new Object[0]);
        P0(showPkg);
    }

    protected void N0() {
        GuideHandler guideHandler = this.x;
        if (guideHandler == null || !guideHandler.r()) {
            return;
        }
        this.x.l();
    }

    @Override // us.pinguo.paylibcenter.e
    public void S(Activity activity, String str, PayCallback payCallback) {
        Intent intent = new Intent(this, PayChinaMobileWebViewActivity.class);
        intent.putExtra("url", str);
        startActivityForResult(intent, 5);
        this.A = payCallback;
    }

    public void T0() {
        Context d2 = BaseApplication.d();
        if (us.pinguo.foundation.q.a.d(d2) || us.pinguo.foundation.q.a.f(d2) || us.pinguo.foundation.q.a.e(d2)) {
            us.pinguo.foundation.q.a.b(d2);
            us.pinguo.foundation.q.a.a(d2);
            us.pinguo.foundation.q.a.c(d2);
            us.pinguo.foundation.eventbus.b bVar = new us.pinguo.foundation.eventbus.b();
            PGEventBus.getInstance().a(bVar);
            us.pinguo.foundation.r.d.a().b(bVar);
        }
    }

    @Override // us.pinguo.camera360.shop.details.g
    public void X(ShowPkg showPkg) {
        if ((this.n != 0 && this.z) || !this.a) {
            if (TextUtils.isEmpty(showPkg.getId())) {
                return;
            }
            if (!showPkg.isSupportInCamera()) {
                k0.a.a(R.string.str_edit_only_filter);
                return;
            }
        }
        l1(showPkg.getId());
    }

    @Override // us.pinguo.camera360.shop.details.g
    public void Y(ShowPkg showPkg) {
        us.pinguo.common.log.a.c("onLoginLockClick", new Object[0]);
        i1();
        P0(showPkg);
    }

    @Override // us.pinguo.camera360.shop.details.g
    public void c0(ShowPkg showPkg) {
        us.pinguo.common.log.a.c("onInstallClick", new Object[0]);
        O0(showPkg);
    }

    @Override // us.pinguo.camera360.shop.details.g
    public void i(ShowPkg showPkg) {
        Intent intent = new Intent();
        intent.putExtra("source_page", "filter_store");
        intent.putExtra("source_extra", showPkg.getId());
        L0(intent);
    }

    @Override // us.pinguo.camera360.shop.details.g
    public void l(ShowPkg showPkg) {
        us.pinguo.camera360.shop.data.h k2 = us.pinguo.camera360.shop.data.i.e().k(showPkg.getId(), showPkg.getPackageType());
        FilterOperateManager.h().t(k2, new f(showPkg, k2));
    }

    public void l1(String str) {
        int currentItem;
        if (TextUtils.isEmpty(str)) {
            if (this.t) {
                y.b().e(0, new Intent());
            }
            if (this.f9548h) {
                Intent intent = new Intent();
                intent.putExtra("is_collection_changed", true);
                List<String> list = this.f9550j;
                if (list != null) {
                    intent.putExtra("delete_list", (Serializable) list);
                }
                setResult(-1, intent);
            } else if (!this.f9551k.isEmpty()) {
                Intent intent2 = new Intent();
                intent2.putExtra("need_refresh_list", true);
                setResult(-1, intent2);
            } else {
                setResult(0);
            }
            finish();
            return;
        }
        us.pinguo.camera360.shop.data.i e2 = us.pinguo.camera360.shop.data.i.e();
        FilterType filterType = FilterType.Effect;
        FilterType filterType2 = FilterType.Loc;
        us.pinguo.camera360.shop.data.h k2 = e2.k(str, filterType, filterType2);
        if (this.u && k2 != null && k2.c(filterType, filterType2).size() == 0) {
            Toast makeText = Toast.makeText(this, (int) R.string.edit_not_support_sticker, 1);
            makeText.show();
            VdsAgent.showToast(makeText);
        } else if (this.n != 0 && this.z) {
            if (this.t) {
                Bundle extras = getIntent().getExtras();
                extras.putString("bundle_key_package", str);
                startActivity(us.pinguo.foundation.b.i(this, extras));
            } else if (getIntent().getBooleanExtra("bundle_key_is_save_publish", false)) {
                startActivity(us.pinguo.foundation.b.e(this, str, getIntent().getStringExtra("key_filter_id")));
            } else {
                startActivity(us.pinguo.foundation.b.b(this, str, getIntent().getStringExtra("key_filter_id")));
            }
            finish();
        } else {
            String str2 = null;
            if (!this.f9547g.isEmpty() && (currentItem = this.c.getCurrentItem()) != -1 && currentItem < this.f9547g.size()) {
                str2 = this.f9547g.get(currentItem).getId();
            }
            Intent intent3 = new Intent();
            intent3.putExtra("filter_package_id", str);
            intent3.putExtra("category_id", str2);
            setResult(-1, intent3);
            finish();
        }
    }

    @Override // us.pinguo.camera360.shop.details.g
    public void m(ShowPkg showPkg) {
        us.pinguo.common.log.a.c("onInstallingClick", new Object[0]);
    }

    public void n1(ShowPkg showPkg, String str) {
        this.o.w(showPkg, str);
    }

    public void o1(ShowTopic showTopic) {
        this.p.q(showTopic, a.b.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i2, i3, intent);
        PayssionManager.INSTANCE.handleActitvityResult(i2, i3, intent);
        PayHelp.getInstance().J(i2, i3, intent);
        if (i2 == 2 && i3 == 3 && intent != null) {
            this.f9548h = intent.getBooleanExtra("key_data_changed", false);
            ArrayList<String> stringArrayListExtra2 = intent.getStringArrayListExtra("key_storemanager_install_list");
            ArrayList<String> stringArrayListExtra3 = intent.getStringArrayListExtra("key_storemanager_uninstall_list");
            if (stringArrayListExtra2 != null) {
                u1(stringArrayListExtra2);
            }
            if (stringArrayListExtra3 != null) {
                u1(stringArrayListExtra3);
            }
        }
        if (18 == i2 && 3 == i3 && intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("key_storemanager_install_list")) != null) {
            u1(stringArrayListExtra);
        }
        if (i2 != 4) {
            if (i2 == 5) {
                PayResult payResult = new PayResult(0, "");
                if (i3 == -1) {
                    this.A.d(payResult);
                }
            }
        } else if (i3 == -1) {
            v1(UnlockType.MEMBER);
            v1(UnlockType.SHARE);
            v1(UnlockType.PAY);
            us.pinguo.camera360.shop.details.h hVar = this.o;
            if (hVar != null && hVar.q()) {
                this.o.B();
            }
            StoreVipLayout storeVipLayout = this.b;
            int i4 = VipManager.a.e(true) ? 8 : 0;
            storeVipLayout.setVisibility(i4);
            VdsAgent.onSetViewVisibility(storeVipLayout, i4);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        l1(null);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        PayHelp.PAYWAY payway;
        super.onCreate(bundle);
        k.a.b();
        Intent intent = getIntent();
        this.y = new C360MemberRepository(this);
        this.t = intent.getBooleanExtra("key_is_intent", false);
        this.u = intent.getBooleanExtra("key_just_support_effect", false);
        this.a = intent.getBooleanExtra("from_edit", false);
        this.f9549i = intent.getStringExtra("pre_selected");
        this.m = this;
        setContentView(R.layout.store_layout2);
        getWindow().setBackgroundDrawable(null);
        this.f9552l = u.b();
        Intent intent2 = getIntent();
        this.n = intent2.getIntExtra("key_type", 0);
        this.z = intent2.getBooleanExtra("key_need_intent_camera", true);
        V0();
        int i2 = this.n;
        if (i2 == 2) {
            h1();
            this.o.p(intent2.getStringExtra("key_details_id"));
        } else if (i2 == 1) {
            h1();
            this.p.l(intent2.getStringExtra("key_details_id"));
        } else if (i2 == 8) {
            String stringExtra = intent2.getStringExtra("key_details_id");
            this.s = stringExtra;
            this.s = stringExtra.trim();
        }
        initView();
        U0();
        M0();
        String str = C;
        us.pinguo.common.log.a.m(str, "dpi=" + getResources().getDisplayMetrics().densityDpi, new Object[0]);
        p1();
        try {
            if (VipManager.a.G()) {
                payway = PayHelp.PAYWAY.GooglePay;
            } else if (HuaweiAgent.isHuaweiSupport()) {
                payway = PayHelp.PAYWAY.HuaweiIAP;
            } else {
                payway = PayHelp.PAYWAY.OtherPay;
            }
            PayHelp.getInstance().M(this, us.pinguo.camera360.shop.e.a, payway);
            if (payway == PayHelp.PAYWAY.OtherPay) {
                C360MemberPayHelp.getInstance().M(this, us.pinguo.camera360.shop.f.a, payway);
            }
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
        }
        C360MemberPayHelp.getInstance().Z(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.SubscriptionActivity, us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        s1();
        this.f9552l.k();
        this.f9552l.l();
        CycleViewPager cycleViewPager = this.c;
        if (cycleViewPager != null) {
            cycleViewPager.clearOnPageChangeListeners();
        }
        this.o.m();
        this.p.k();
        this.o = null;
        this.p = null;
        this.w = null;
        T0();
        this.q = null;
        this.r = null;
        N0();
        PayHelp.getInstance().t();
        us.pinguo.common.log.a.m(C, "store activity2 onDestroy", new Object[0]);
        C360MemberPayHelp.getInstance().Z(null);
    }

    @Override // us.pinguo.camera360.shop.details.g
    public void onDetailViewCloseClick(View view) {
        g1();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
            if (!this.r.isShowing() && !this.q.isShowing()) {
                if (q1()) {
                    return true;
                }
            } else {
                g1();
                return true;
            }
        }
        return super.onKeyDown(i2, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        us.pinguo.foundation.q.a.b(this);
        us.pinguo.foundation.q.a.a(this);
        us.pinguo.foundation.q.a.c(this);
        us.pinguo.foundation.statistics.f.e("store_page", true);
        this.q.x();
        this.r.w();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        us.pinguo.foundation.statistics.f.f("store_page");
        this.q.y();
        this.r.x();
    }

    @Override // us.pinguo.share.core.PGShareListener
    public void onShareCancel(ShareSite shareSite) {
        PGShareListener pGShareListener = this.w;
        if (pGShareListener != null) {
            pGShareListener.onShareCancel(shareSite);
        }
    }

    @Override // us.pinguo.share.core.PGShareListener
    public void onShareComplete(ShareSite shareSite, boolean z) {
        PGShareListener pGShareListener = this.w;
        if (pGShareListener != null) {
            pGShareListener.onShareComplete(shareSite, z);
        }
    }

    @Override // us.pinguo.share.core.PGShareListener
    public void onShareError(ShareSite shareSite, Throwable th) {
        PGShareListener pGShareListener = this.w;
        if (pGShareListener != null) {
            pGShareListener.onShareError(shareSite, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        CycleViewPager cycleViewPager;
        super.onStop();
        us.pinguo.camera360.shop.cardsviewpager.i iVar = this.f9546f;
        if (iVar == null || (cycleViewPager = this.c) == null) {
            return;
        }
        ShowScene g2 = iVar.g(cycleViewPager.getCurrentItem());
        CameraBusinessSettingModel.v().H("key_current_card_id_str", g2 == null ? "" : g2.getId());
    }

    @Override // us.pinguo.camera360.shop.j
    public void q(View view, boolean z) {
        if (view instanceof PkgDetailsView) {
            if (z) {
                us.pinguo.foundation.statistics.f.e("store_page", true);
                us.pinguo.foundation.statistics.f.f("store_filter_details_page");
            } else {
                us.pinguo.foundation.statistics.f.f("store_page");
                us.pinguo.foundation.statistics.f.e("store_filter_details_page", true);
            }
        }
        if (view instanceof TopicDetailsView) {
            if (z) {
                us.pinguo.foundation.statistics.f.e("store_page", true);
            } else {
                us.pinguo.foundation.statistics.f.f("store_page");
            }
        }
    }
}

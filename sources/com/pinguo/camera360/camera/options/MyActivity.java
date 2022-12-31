package com.pinguo.camera360.camera.options;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentTransaction;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.request.AlbumGetBackStatusInfo;
import com.pinguo.camera360.request.AlbumGetBackStatusResponse;
import com.pinguo.camera360.request.ApiGetAlbumBackStatus;
import com.pinguo.camera360.ui.PGAlbumGetBackStatusActivity;
import com.pinguo.camera360.ui.PGAlbumServicePauseActivity;
import com.pinguo.camera360.ui.TitleBarLayout;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import rx.functions.Action1;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.advconfigdata.database.AdvItem;
import us.pinguo.camera2020.activity.SettingsActivity;
import us.pinguo.foundation.base.InspireBaseActivity;
import us.pinguo.foundation.eventbus.PGEventBus;
import us.pinguo.foundation.o.c;
import us.pinguo.foundation.ui.view.CommonItemView;
import us.pinguo.foundation.utils.n0;
import us.pinguo.ui.b.a;
import us.pinguo.user.EditInfoActivity;
import us.pinguo.user.User;
import us.pinguo.user.event.SyncVipInfoDoneEvent;
import us.pinguo.user.v0;
import vStudio.Android.Camera360.Conditions;
import vStudio.Android.Camera360.R;
/* compiled from: MyActivity.kt */
/* loaded from: classes3.dex */
public final class MyActivity extends InspireBaseActivity implements us.pinguo.foundation.statistics.e {
    public Map<Integer, View> a = new LinkedHashMap();
    private AlbumGetBackStatusResponse b;
    private a.C0454a c;

    /* compiled from: MyActivity.kt */
    /* loaded from: classes3.dex */
    public static final class a extends j.a.c.b.d<AlbumGetBackStatusResponse> {
        a() {
        }

        @Override // j.a.c.b.d
        /* renamed from: a */
        public void onSuccess(AlbumGetBackStatusResponse albumGetBackStatusResponse) {
            kotlin.jvm.internal.s.h(albumGetBackStatusResponse, "albumGetBackStatusResponse");
            MyActivity.this.b = albumGetBackStatusResponse;
            a.C0454a c0454a = MyActivity.this.c;
            if (c0454a != null) {
                c0454a.a();
            }
            Intent intent = new Intent();
            AlbumGetBackStatusResponse albumGetBackStatusResponse2 = MyActivity.this.b;
            kotlin.jvm.internal.s.e(albumGetBackStatusResponse2);
            if (((AlbumGetBackStatusInfo) albumGetBackStatusResponse2.data).status == AlbumGetBackStatusInfo.AlbumGetBackStatus.ALBUM_GET_BACK_STATUS_NONE.status) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("AlbumGetBackStatusResponse", MyActivity.this.b);
                intent.putExtras(bundle);
                intent.setClass(MyActivity.this, PGAlbumServicePauseActivity.class);
            } else {
                intent.setClass(MyActivity.this, PGAlbumGetBackStatusActivity.class);
                AlbumGetBackStatusResponse albumGetBackStatusResponse3 = MyActivity.this.b;
                kotlin.jvm.internal.s.e(albumGetBackStatusResponse3);
                intent.putExtra(NotificationCompat.CATEGORY_EMAIL, ((AlbumGetBackStatusInfo) albumGetBackStatusResponse3.data).email);
                AlbumGetBackStatusResponse albumGetBackStatusResponse4 = MyActivity.this.b;
                kotlin.jvm.internal.s.e(albumGetBackStatusResponse4);
                intent.putExtra("status", ((AlbumGetBackStatusInfo) albumGetBackStatusResponse4.data).status);
            }
            MyActivity.this.startActivity(intent);
        }

        @Override // j.a.c.b.d
        public void onError(Exception exc) {
            a.C0454a c0454a = MyActivity.this.c;
            if (c0454a == null) {
                return;
            }
            c0454a.a();
        }
    }

    /* compiled from: MyActivity.kt */
    /* loaded from: classes3.dex */
    public static final class b implements c.a {
        final /* synthetic */ String a;
        final /* synthetic */ AlertDialog b;
        final /* synthetic */ MyActivity c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f6227d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.b.a<kotlin.u> f6228e;

        b(String str, AlertDialog alertDialog, MyActivity myActivity, String str2, kotlin.jvm.b.a<kotlin.u> aVar) {
            this.a = str;
            this.b = alertDialog;
            this.c = myActivity;
            this.f6227d = str2;
            this.f6228e = aVar;
        }

        @Override // us.pinguo.foundation.o.c.a
        public void a() {
            try {
                try {
                    String str = this.a;
                    if (str != null) {
                        us.pinguo.inspire.v.a(this.c, str, this.f6227d);
                    } else {
                        kotlin.jvm.b.a<kotlin.u> aVar = this.f6228e;
                        if (aVar != null) {
                            aVar.invoke();
                        }
                    }
                    if (!this.b.isShowing()) {
                        return;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    if (!this.b.isShowing()) {
                        return;
                    }
                }
                this.b.dismiss();
            } catch (Throwable th) {
                if (this.b.isShowing()) {
                    this.b.dismiss();
                }
                throw th;
            }
        }

        @Override // us.pinguo.foundation.o.c.a
        public void b() {
            if (this.b.isShowing()) {
                this.b.dismiss();
            }
        }

        @Override // us.pinguo.foundation.o.c.a
        public void c() {
            if (this.a != null) {
                AlertDialog alertDialog = this.b;
                alertDialog.show();
                VdsAgent.showDialog(alertDialog);
            }
        }

        @Override // us.pinguo.foundation.o.c.a
        public void d() {
            if (this.b.isShowing()) {
                this.b.dismiss();
            }
        }

        @Override // us.pinguo.foundation.o.c.a
        public void e() {
            c.a.C0395a.a(this);
        }

        @Override // us.pinguo.foundation.o.c.a
        public void f(int i2) {
        }

        @Override // us.pinguo.foundation.o.c.a
        public void g() {
            if (this.b.isShowing()) {
                this.b.dismiss();
            }
        }
    }

    private final void A0() {
        List<AdvItem> adItems = AdvConfigManager.getInstance().getItems("2b38adaa9dbcc9a78239d3d98098291e");
        kotlin.jvm.internal.s.g(adItems, "adItems");
        for (AdvItem advItem : adItems) {
            AdFamilyView adFamilyView = new AdFamilyView(this);
            adFamilyView.a(advItem);
            ((LinearLayout) _$_findCachedViewById(R.id.cameraSettingLinearLayout)).addView(adFamilyView);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void C0(MyActivity myActivity, String str, String str2, String str3, kotlin.jvm.b.a aVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        if ((i2 & 4) != 0) {
            str3 = null;
        }
        if ((i2 & 8) != 0) {
            aVar = null;
        }
        myActivity.B0(str, str2, str3, aVar);
    }

    private final void M0() {
        if (User.d().n()) {
            CommonItemView cloudAlbum = (CommonItemView) _$_findCachedViewById(R.id.cloudAlbum);
            kotlin.jvm.internal.s.g(cloudAlbum, "cloudAlbum");
            int i2 = us.pinguo.repository2020.abtest.b.a.b() ^ true ? 0 : 8;
            cloudAlbum.setVisibility(i2);
            VdsAgent.onSetViewVisibility(cloudAlbum, i2);
            U0();
            return;
        }
        CommonItemView commonItemView = (CommonItemView) _$_findCachedViewById(R.id.cloudAlbum);
        commonItemView.setVisibility(8);
        VdsAgent.onSetViewVisibility(commonItemView, 8);
        T0();
    }

    private final void N0() {
        addSubscription(us.pinguo.foundation.r.d.a().c(us.pinguo.foundation.r.b.class).subscribe(new Action1() { // from class: com.pinguo.camera360.camera.options.d
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                MyActivity.O0(MyActivity.this, (us.pinguo.foundation.r.b) obj);
            }
        }, com.pinguo.camera360.camera.options.b.a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(MyActivity this$0, us.pinguo.foundation.r.b bVar) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.M0();
        User d2 = User.d();
        if (d2.n()) {
            User.Info h2 = d2.h();
            kotlin.jvm.internal.s.e(h2);
            if (h2.firstLogin) {
                Intent intent = new Intent();
                intent.setClass(this$0, EditInfoActivity.class);
                intent.putExtra("firstLogin", true);
                this$0.startActivity(intent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(Throwable th) {
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.f(th);
    }

    private final void Q0() {
        addSubscription(us.pinguo.foundation.r.d.a().c(us.pinguo.foundation.r.a.class).subscribe(new Action1() { // from class: com.pinguo.camera360.camera.options.h
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                MyActivity.R0(MyActivity.this, (us.pinguo.foundation.r.a) obj);
            }
        }, e.a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R0(MyActivity this$0, us.pinguo.foundation.r.a aVar) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.M0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S0(Throwable th) {
        us.pinguo.common.log.a.f(th);
        us.pinguo.foundation.e.e(th);
    }

    private final void T0() {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        MySettingLoginFragment mySettingLoginFragment = new MySettingLoginFragment();
        FragmentTransaction replace = beginTransaction.replace(R.id.personLayout, mySettingLoginFragment);
        VdsAgent.onFragmentTransactionReplace(beginTransaction, R.id.personLayout, mySettingLoginFragment, replace);
        replace.commitAllowingStateLoss();
    }

    private final void U0() {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        MySettingPersonInfoFragment mySettingPersonInfoFragment = new MySettingPersonInfoFragment();
        FragmentTransaction replace = beginTransaction.replace(R.id.personLayout, mySettingPersonInfoFragment);
        VdsAgent.onFragmentTransactionReplace(beginTransaction, R.id.personLayout, mySettingPersonInfoFragment, replace);
        replace.commitAllowingStateLoss();
    }

    private final void V0() {
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.my_vip_layout);
        linearLayout.setVisibility(8);
        VdsAgent.onSetViewVisibility(linearLayout, 8);
    }

    private final void initView() {
        this.c = us.pinguo.ui.b.a.b(this, getString(R.string.load_more));
        if (!Conditions.d() && !Conditions.e() && n0.n()) {
            us.pinguo.foundation.statistics.h.a.y("show");
            if (kotlin.jvm.internal.s.c("VIVO应用商店", us.pinguo.foundation.utils.i.a())) {
                CommonItemView commonItemView = (CommonItemView) _$_findCachedViewById(R.id.suggestions);
                commonItemView.setVisibility(8);
                VdsAgent.onSetViewVisibility(commonItemView, 8);
                return;
            }
            return;
        }
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.my_vip_layout);
        linearLayout.setVisibility(8);
        VdsAgent.onSetViewVisibility(linearLayout, 8);
        CommonItemView commonItemView2 = (CommonItemView) _$_findCachedViewById(R.id.suggestions);
        commonItemView2.setVisibility(8);
        VdsAgent.onSetViewVisibility(commonItemView2, 8);
    }

    private final void t0() {
        ((CommonItemView) _$_findCachedViewById(R.id.cloudAlbum)).setOnItemClickListener(new CommonItemView.a() { // from class: com.pinguo.camera360.camera.options.c
            @Override // us.pinguo.foundation.ui.view.CommonItemView.a
            public final void onItemClick(View view) {
                MyActivity.u0(MyActivity.this, view);
            }
        });
        ((CommonItemView) _$_findCachedViewById(R.id.myVip)).setOnItemClickListener(new CommonItemView.a() { // from class: com.pinguo.camera360.camera.options.g
            @Override // us.pinguo.foundation.ui.view.CommonItemView.a
            public final void onItemClick(View view) {
                MyActivity.v0(MyActivity.this, view);
            }
        });
        ((CommonItemView) _$_findCachedViewById(R.id.setting)).setOnItemClickListener(new CommonItemView.a() { // from class: com.pinguo.camera360.camera.options.i
            @Override // us.pinguo.foundation.ui.view.CommonItemView.a
            public final void onItemClick(View view) {
                MyActivity.w0(MyActivity.this, view);
            }
        });
        ((CommonItemView) _$_findCachedViewById(R.id.suggestions)).setOnItemClickListener(new CommonItemView.a() { // from class: com.pinguo.camera360.camera.options.f
            @Override // us.pinguo.foundation.ui.view.CommonItemView.a
            public final void onItemClick(View view) {
                MyActivity.x0(MyActivity.this, view);
            }
        });
        ((CommonItemView) _$_findCachedViewById(R.id.about)).setOnItemClickListener(new CommonItemView.a() { // from class: com.pinguo.camera360.camera.options.j
            @Override // us.pinguo.foundation.ui.view.CommonItemView.a
            public final void onItemClick(View view) {
                MyActivity.y0(MyActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(MyActivity this$0, View view) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.z0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(MyActivity this$0, View view) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        Intent intent = new Intent();
        intent.setClassName(this$0, "com.pinguo.camera360.member.MemberRightsActivity");
        this$0.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(MyActivity this$0, View view) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.startActivity(new Intent(this$0, SettingsActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(MyActivity this$0, View view) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        us.pinguo.foundation.statistics.h.a.u0();
        l0.b(this$0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(MyActivity this$0, View view) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        Intent intent = new Intent();
        intent.setClassName(this$0, "com.pinguo.camera360.camera.options.OptionsAbouts");
        this$0.startActivity(intent);
    }

    private final void z0() {
        if (User.d().n()) {
            a.C0454a c0454a = this.c;
            if (c0454a != null) {
                c0454a.e();
            }
            new ApiGetAlbumBackStatus(this, User.l()).get(new a());
            return;
        }
        v0.f(this);
    }

    public final void B0(String featureName, String str, String str2, kotlin.jvm.b.a<kotlin.u> aVar) {
        kotlin.jvm.internal.s.h(featureName, "featureName");
        us.pinguo.foundation.o.c.a.a(featureName, new b(str, us.pinguo.ui.b.a.a(this), this, str2, aVar));
    }

    @Override // us.pinguo.foundation.statistics.e
    public String C() {
        return "user_center_page";
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this.a;
        View view = map.get(Integer.valueOf(i2));
        if (view == null) {
            View findViewById = findViewById(i2);
            if (findViewById == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.InspireBaseActivity, us.pinguo.foundation.base.InspireRedirectActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_my_layout);
        int i2 = R.id.titleBarLayout;
        if (((TitleBarLayout) _$_findCachedViewById(i2)) != null) {
            ((TitleBarLayout) _$_findCachedViewById(i2)).setTiTleText(R.string.portal_bottom_profile);
        }
        initView();
        A0();
        M0();
        t0();
        Q0();
        N0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.InspireBaseActivity, us.pinguo.foundation.base.SubscriptionActivity, us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.c != null) {
            this.c = null;
        }
    }

    public final void onEvent(SyncVipInfoDoneEvent event) {
        kotlin.jvm.internal.s.h(event, "event");
        us.pinguo.common.log.a.k("onEvent SyncVipInfoDoneEvent ", new Object[0]);
        V0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.InspireBaseActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        PGEventBus.getInstance().c(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.InspireBaseActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        PGEventBus.getInstance().b(this);
        V0();
    }
}

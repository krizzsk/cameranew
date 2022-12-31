package com.pinguo.camera360.test;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.function.Consumer;
import kotlin.text.StringsKt__StringsKt;
import us.pinguo.camera360.shop.data.FilterType;
import us.pinguo.camera360.shop.data.install.FilterOperateManager;
import us.pinguo.camera360.shop.data.show.ShowPkg;
import us.pinguo.camera360.shop.data.show.ShowScene;
import us.pinguo.foundation.base.BaseActivity;
import vStudio.Android.Camera360.R;
/* compiled from: FilterInstallTestActivity.kt */
/* loaded from: classes3.dex */
public final class FilterInstallTestActivity extends BaseActivity implements u0 {
    private List<ShowScene> b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private int f6966d;

    /* renamed from: e  reason: collision with root package name */
    private int f6967e;

    /* renamed from: g  reason: collision with root package name */
    private List<? extends us.pinguo.camera360.shop.data.h> f6969g;

    /* renamed from: h  reason: collision with root package name */
    private s0 f6970h;
    public Map<Integer, View> a = new LinkedHashMap();

    /* renamed from: f  reason: collision with root package name */
    private String f6968f = "/sdcard/c360_filter/";

    /* compiled from: FilterInstallTestActivity.kt */
    /* loaded from: classes3.dex */
    public static final class a implements us.pinguo.camera360.shop.data.show.s {
        a() {
        }

        @Override // us.pinguo.camera360.shop.data.show.s
        public void a() {
            FilterInstallTestActivity filterInstallTestActivity = FilterInstallTestActivity.this;
            List<ShowScene> d2 = us.pinguo.camera360.shop.data.show.u.b().d(false);
            kotlin.jvm.internal.s.g(d2, "get().getCachedScenes(false)");
            filterInstallTestActivity.b = d2;
            ((TextView) FilterInstallTestActivity.this._$_findCachedViewById(R.id.tv_test_edit)).setText(FilterInstallTestActivity.this.y0());
            if (FilterInstallTestActivity.this.f6967e > 0) {
                ((Button) FilterInstallTestActivity.this._$_findCachedViewById(R.id.btn_filter_install)).setEnabled(true);
            } else {
                ((Button) FilterInstallTestActivity.this._$_findCachedViewById(R.id.btn_filter_install)).setText("所有滤镜已安装");
            }
        }

        @Override // us.pinguo.camera360.shop.data.show.s
        public void b(List<ShowScene> showScenes) {
            kotlin.jvm.internal.s.h(showScenes, "showScenes");
            FilterInstallTestActivity.this.b = showScenes;
            ((TextView) FilterInstallTestActivity.this._$_findCachedViewById(R.id.tv_test_edit)).setText(FilterInstallTestActivity.this.y0());
            ((Button) FilterInstallTestActivity.this._$_findCachedViewById(R.id.btn_filter_install)).setEnabled(true);
        }

        @Override // us.pinguo.camera360.shop.data.show.s
        public void c(Exception exc) {
            ((TextView) FilterInstallTestActivity.this._$_findCachedViewById(R.id.tv_test_edit)).setText("滤镜列表更新失败!");
            ((Button) FilterInstallTestActivity.this._$_findCachedViewById(R.id.btn_filter_install)).setEnabled(false);
        }
    }

    /* compiled from: FilterInstallTestActivity.kt */
    /* loaded from: classes3.dex */
    public static final class b implements us.pinguo.camera360.shop.data.install.p {
        final /* synthetic */ int b;
        final /* synthetic */ ShowPkg c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ CountDownLatch f6971d;

        b(int i2, ShowPkg showPkg, CountDownLatch countDownLatch) {
            this.b = i2;
            this.c = showPkg;
            this.f6971d = countDownLatch;
        }

        @Override // us.pinguo.camera360.shop.data.install.p
        public void a(us.pinguo.camera360.shop.data.install.q qVar) {
            if (qVar != null && qVar.d()) {
                FilterInstallTestActivity.this.w0("----------->安装成功");
            } else {
                FilterInstallTestActivity filterInstallTestActivity = FilterInstallTestActivity.this;
                filterInstallTestActivity.w0(",重试" + (this.b + 1) + (char) 27425);
                FilterInstallTestActivity.this.D0(this.c, this.b + 1);
            }
            this.f6971d.countDown();
        }

        @Override // us.pinguo.camera360.shop.data.install.p
        public void b(String str) {
        }

        @Override // us.pinguo.camera360.shop.data.install.p
        public void c(String str, int i2) {
        }
    }

    private final void A0() {
        ((TextView) _$_findCachedViewById(R.id.tv_test_edit)).setText("开始安装.......\n");
        int i2 = R.id.btn_filter_install;
        ((Button) _$_findCachedViewById(i2)).setText("开始安装.......");
        ((Button) _$_findCachedViewById(i2)).setEnabled(false);
        ((Button) _$_findCachedViewById(R.id.btn_filter_make)).setEnabled(false);
        kotlin.x.a.a((r12 & 1) != 0, (r12 & 2) != 0 ? false : false, (r12 & 4) != 0 ? null : null, (r12 & 8) != 0 ? null : null, (r12 & 16) != 0 ? -1 : 0, new FilterInstallTestActivity$installFiltersAsync$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B0() {
        List<ShowScene> list = this.b;
        if (list != null) {
            for (ShowScene showScene : list) {
                if (this.c) {
                    return;
                }
                w0("================= " + ((Object) showScene.getName()) + " =================\n");
                List<ShowPkg> showPkgs = showScene.getShowPkgs();
                kotlin.jvm.internal.s.g(showPkgs, "se.showPkgs");
                for (ShowPkg pkg : showPkgs) {
                    if (this.c) {
                        return;
                    }
                    String name = pkg.getName();
                    kotlin.jvm.internal.s.g(name, "pkg.name");
                    w0(name);
                    if (FilterOperateManager.h().k(pkg.getId())) {
                        w0("------------> 已安装");
                    } else {
                        w0(",安装中....");
                        kotlin.jvm.internal.s.g(pkg, "pkg");
                        E0(this, pkg, 0, 2, null);
                    }
                    w0("\n");
                }
            }
            runOnUiThread(new Runnable() { // from class: com.pinguo.camera360.test.t
                @Override // java.lang.Runnable
                public final void run() {
                    FilterInstallTestActivity.C0(FilterInstallTestActivity.this);
                }
            });
            return;
        }
        kotlin.jvm.internal.s.z("sences");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(FilterInstallTestActivity this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (this$0.c) {
            return;
        }
        if (this$0.f6966d == 0) {
            ((Button) this$0._$_findCachedViewById(R.id.btn_filter_install)).setText("安装成功!!");
        } else {
            ((Button) this$0._$_findCachedViewById(R.id.btn_filter_install)).setText(this$0.f6966d + "个滤镜安装失败!!");
        }
        ((Button) this$0._$_findCachedViewById(R.id.btn_filter_make)).setEnabled(new File(kotlin.jvm.internal.s.q(this$0.f6968f, "map.txt")).exists());
        this$0.f6969g = us.pinguo.camera360.shop.data.i.e().l(FilterType.Effect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D0(ShowPkg showPkg, int i2) {
        if (this.c) {
            return;
        }
        if (i2 > 3) {
            w0("---------->失败!!!!!!!!!!!!!!!!");
            this.f6966d++;
            return;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        FilterOperateManager.h().q(showPkg.getId(), new b(i2, showPkg, countDownLatch));
        FilterOperateManager.h().m(showPkg);
        countDownLatch.await();
    }

    static /* synthetic */ void E0(FilterInstallTestActivity filterInstallTestActivity, ShowPkg showPkg, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        filterInstallTestActivity.D0(showPkg, i2);
    }

    private final void L0() {
        ((TextView) _$_findCachedViewById(R.id.tv_test_edit)).setText("");
        s0 s0Var = new s0(this.f6969g);
        this.f6970h = s0Var;
        if (s0Var != null) {
            s0Var.h(this);
        }
        s0 s0Var2 = this.f6970h;
        if (s0Var2 == null) {
            return;
        }
        s0Var2.i(O0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(FilterInstallTestActivity this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.A0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(FilterInstallTestActivity this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.L0();
    }

    private final List<r0> O0() {
        List<r0> h2;
        try {
            final ArrayList arrayList = new ArrayList();
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(new File(kotlin.jvm.internal.s.q(this.f6968f, "map.txt"))), kotlin.text.d.a);
            (inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192)).lines().forEach(new Consumer() { // from class: com.pinguo.camera360.test.x
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    FilterInstallTestActivity.P0(FilterInstallTestActivity.this, arrayList, (String) obj);
                }
            });
            return arrayList;
        } catch (Exception e2) {
            String message = e2.getMessage();
            if (message == null) {
                message = "map.txt数据异常!!";
            }
            Q0(message);
            h2 = kotlin.collections.u.h();
            return h2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(FilterInstallTestActivity this$0, ArrayList list, String it) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(list, "$list");
        kotlin.jvm.internal.s.g(it, "it");
        r0 S0 = this$0.S0(it);
        if (S0 != null) {
            list.add(S0);
        }
    }

    private final void Q0(final String str) {
        runOnUiThread(new Runnable() { // from class: com.pinguo.camera360.test.y
            @Override // java.lang.Runnable
            public final void run() {
                FilterInstallTestActivity.R0(FilterInstallTestActivity.this, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R0(FilterInstallTestActivity this$0, String msg) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(msg, "$msg");
        Toast makeText = Toast.makeText(this$0, msg, 1);
        makeText.show();
        VdsAgent.showToast(makeText);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.pinguo.camera360.test.r0 S0(java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pinguo.camera360.test.FilterInstallTestActivity.S0(java.lang.String):com.pinguo.camera360.test.r0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w0(final String str) {
        runOnUiThread(new Runnable() { // from class: com.pinguo.camera360.test.w
            @Override // java.lang.Runnable
            public final void run() {
                FilterInstallTestActivity.x0(FilterInstallTestActivity.this, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(FilterInstallTestActivity this$0, String msg) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(msg, "$msg");
        if (this$0.c) {
            return;
        }
        ((TextView) this$0._$_findCachedViewById(R.id.tv_test_edit)).append(msg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String y0() {
        StringBuilder sb = new StringBuilder();
        List<ShowScene> list = this.b;
        if (list != null) {
            for (ShowScene showScene : list) {
                sb.append("================= " + ((Object) showScene.getName()) + " =================\n");
                List<ShowPkg> showPkgs = showScene.getShowPkgs();
                kotlin.jvm.internal.s.g(showPkgs, "se.showPkgs");
                for (ShowPkg showPkg : showPkgs) {
                    sb.append(showPkg.getName());
                    if (FilterOperateManager.h().k(showPkg.getId())) {
                        sb.append("------------> 已安装");
                    } else {
                        this.f6967e++;
                    }
                    sb.append("\n");
                }
                sb.append("\n\n");
            }
            String sb2 = sb.toString();
            kotlin.jvm.internal.s.g(sb2, "sb.toString()");
            return sb2;
        }
        kotlin.jvm.internal.s.z("sences");
        throw null;
    }

    private final void z0() {
        this.f6969g = us.pinguo.camera360.shop.data.i.e().l(FilterType.Effect);
        ((TextView) _$_findCachedViewById(R.id.tv_test_edit)).setText("滤镜列表更新中....");
        ((Button) _$_findCachedViewById(R.id.btn_filter_install)).setEnabled(false);
        us.pinguo.camera360.shop.data.show.u.b().r(new a(), true);
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

    @Override // com.pinguo.camera360.test.u0
    public void e0() {
        w0("==========制作完成==============");
        this.f6970h = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (us.pinguo.foundation.d.f10987f || us.pinguo.foundation.d.f10985d) {
            setContentView(R.layout.test_filter_install);
            z0();
            ((Button) _$_findCachedViewById(R.id.btn_filter_install)).setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.test.v
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FilterInstallTestActivity.M0(FilterInstallTestActivity.this, view);
                }
            });
            int i2 = R.id.btn_filter_make;
            ((Button) _$_findCachedViewById(i2)).setEnabled(new File(kotlin.jvm.internal.s.q(this.f6968f, "map.txt")).exists());
            ((Button) _$_findCachedViewById(i2)).setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.test.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FilterInstallTestActivity.N0(FilterInstallTestActivity.this, view);
                }
            });
            this.c = false;
            this.f6966d = 0;
            return;
        }
        throw new RuntimeException("Only Test!");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.c = true;
        s0 s0Var = this.f6970h;
        if (s0Var != null) {
            s0Var.e();
        }
        this.f6970h = null;
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        getWindow().clearFlags(128);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getWindow().setFlags(128, 128);
    }

    @Override // com.pinguo.camera360.test.u0
    public void s(String name) {
        int P;
        kotlin.jvm.internal.s.h(name, "name");
        P = StringsKt__StringsKt.P(name, "result/", 0, false, 6, null);
        StringBuilder sb = new StringBuilder();
        sb.append("error:   ");
        String substring = name.substring(P + 7);
        kotlin.jvm.internal.s.g(substring, "this as java.lang.String).substring(startIndex)");
        sb.append(substring);
        sb.append('\n');
        w0(sb.toString());
    }

    @Override // com.pinguo.camera360.test.u0
    public void t(String name) {
        int P;
        kotlin.jvm.internal.s.h(name, "name");
        P = StringsKt__StringsKt.P(name, "result/", 0, false, 6, null);
        StringBuilder sb = new StringBuilder();
        sb.append("success ");
        String substring = name.substring(P + 7);
        kotlin.jvm.internal.s.g(substring, "this as java.lang.String).substring(startIndex)");
        sb.append(substring);
        sb.append('\n');
        w0(sb.toString());
    }
}

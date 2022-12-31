package com.pinguo.camera360.member;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.camera360.camera.controller.VipHalfScreenController;
import com.pinguo.camera360.camera.options.OptionsWebviewActivity;
import com.pinguo.camera360.vip.VipManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.text.StringsKt__StringsKt;
import org.slf4j.Marker;
import us.pinguo.common.widget.banner2.ViewPager2Banner;
import us.pinguo.foundation.base.BaseActivity;
import us.pinguo.ui.widget.AlphaPressedConstraintLayout;
import us.pinguo.ui.widget.AutofitTextView;
import vStudio.Android.Camera360.R;
/* compiled from: NewPayWallActivity.kt */
/* loaded from: classes3.dex */
public final class NewPayWallActivity extends BaseActivity implements View.OnClickListener, y0<e1>, us.pinguo.foundation.statistics.e {
    public Map<Integer, View> a = new LinkedHashMap();
    private boolean b;
    private final kotlin.f c;

    /* renamed from: d  reason: collision with root package name */
    private String f6896d;

    /* renamed from: e  reason: collision with root package name */
    private x0 f6897e;

    public NewPayWallActivity() {
        kotlin.f b;
        b = kotlin.h.b(new NewPayWallActivity$sloganList$2(this));
        this.c = b;
        this.f6896d = "yearly_vip_2399_paynow";
    }

    private final void initView() {
        View it = getLayoutInflater().inflate(R.layout.item_new_pay_wall_no_switch, (ViewGroup) null);
        kotlin.jvm.internal.x xVar = kotlin.jvm.internal.x.a;
        String string = getString(R.string.pay_wall_open_3day_free);
        kotlin.jvm.internal.s.g(string, "getString(R.string.pay_wall_open_3day_free)");
        String format = String.format(string, Arrays.copyOf(new Object[]{3}, 1));
        kotlin.jvm.internal.s.g(format, "format(format, *args)");
        ((TextView) it.findViewById(R.id.tvHint)).setText(format);
        if (us.pinguo.util.p.c()) {
            us.pinguo.repository2020.abtest.j jVar = us.pinguo.repository2020.abtest.j.a;
            this.f6896d = jVar.b();
            if (jVar.c()) {
                String string2 = getString(R.string.pay_wall_price_month_after);
                kotlin.jvm.internal.s.g(string2, "getString(R.string.pay_wall_price_month_after)");
                String format2 = String.format(string2, Arrays.copyOf(new Object[]{VipManager.a.r(this.f6896d)}, 1));
                kotlin.jvm.internal.s.g(format2, "format(format, *args)");
                ((TextView) it.findViewById(R.id.tvPrice)).setText(format2);
            } else {
                kotlin.jvm.internal.s.g(it, "it");
                u0(it);
            }
        } else {
            this.f6896d = "yearly_vip_2399_3dayfree";
            if (this.b) {
                String r = VipManager.a.r("yearly_vip_2399_3dayfree");
                String a = com.pinguo.camera360.i.a.a(this.f6896d, r);
                String string3 = getString(R.string.vip_gp_price);
                kotlin.jvm.internal.s.g(string3, "getString(R.string.vip_gp_price)");
                String format3 = String.format(string3, Arrays.copyOf(new Object[]{r, a}, 2));
                kotlin.jvm.internal.s.g(format3, "format(format, *args)");
                ((TextView) it.findViewById(R.id.tvPrice)).setText(format3);
            } else {
                kotlin.jvm.internal.s.g(it, "it");
                u0(it);
            }
        }
        ((FrameLayout) _$_findCachedViewById(R.id.flContainer)).addView(it);
        v0();
        w0(0);
    }

    private final ArrayList<String> r0() {
        return (ArrayList) this.c.getValue();
    }

    private final void s0() {
        ((ImageView) _$_findCachedViewById(R.id.iv_close)).setOnClickListener(this);
        ((AlphaPressedConstraintLayout) _$_findCachedViewById(R.id.alphaLayout)).setOnClickListener(this);
        ((TextView) _$_findCachedViewById(R.id.tvPrivacy)).setOnClickListener(this);
        ((TextView) _$_findCachedViewById(R.id.tvProtocol)).setOnClickListener(this);
    }

    private final void u0(View view) {
        kotlin.jvm.internal.x xVar = kotlin.jvm.internal.x.a;
        String string = getString(R.string.pay_wall_price_after);
        kotlin.jvm.internal.s.g(string, "getString(R.string.pay_wall_price_after)");
        String format = String.format(string, Arrays.copyOf(new Object[]{VipManager.a.r(this.f6896d)}, 1));
        kotlin.jvm.internal.s.g(format, "format(format, *args)");
        ((TextView) view.findViewById(R.id.tvPrice)).setText(format);
    }

    private final void v0() {
        List j2;
        int i2 = R.id.bannerView;
        ViewPager2Banner viewPager2Banner = (ViewPager2Banner) _$_findCachedViewById(i2);
        j2 = kotlin.collections.u.j(Integer.valueOf((int) R.drawable.ic_banner_professional_tool), Integer.valueOf((int) R.drawable.ic_banner_filter), Integer.valueOf((int) R.drawable.ic_banner_portrait_change));
        ViewPager2Banner bannerView = (ViewPager2Banner) _$_findCachedViewById(i2);
        kotlin.jvm.internal.s.g(bannerView, "bannerView");
        us.pinguo.common.widget.banner2.d.a(bannerView, new NewPayWallActivity$setupBanner$1$1(j2));
        ((ViewPager2Banner) _$_findCachedViewById(i2)).setOnPageScrolled(new NewPayWallActivity$setupBanner$1$2(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w0(int i2) {
        int P;
        if (i2 > 0) {
            i2--;
        }
        if (i2 >= r0().size()) {
            return;
        }
        String str = r0().get(i2);
        kotlin.jvm.internal.s.g(str, "sloganList[p]");
        String str2 = str;
        P = StringsKt__StringsKt.P(str2, Marker.ANY_NON_NULL_MARKER, 0, false, 6, null);
        ((AutofitTextView) _$_findCachedViewById(R.id.tvSlogan)).setText(us.pinguo.common.widget.i.a.c(str2, 1, new kotlin.z.d(0, P + 1)));
    }

    @Override // us.pinguo.foundation.statistics.e
    public String C() {
        return "vip_free_trial_page";
    }

    @Override // com.pinguo.camera360.member.y0
    public void Q() {
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

    @Override // com.pinguo.camera360.member.y0
    public String b() {
        return this.f6896d;
    }

    @Override // com.pinguo.camera360.member.y0
    public Activity g() {
        return this;
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        x0 x0Var;
        VdsAgent.onClick(this, view);
        Integer valueOf = view == null ? null : Integer.valueOf(view.getId());
        if (valueOf != null && valueOf.intValue() == R.id.iv_close_res_0x7f090422) {
            finish();
        } else if (valueOf != null && valueOf.intValue() == R.id.alphaLayout) {
            if (us.pinguo.common.widget.tab.k.b(us.pinguo.common.widget.tab.k.a, 0, 1, null) || (x0Var = this.f6897e) == null) {
                return;
            }
            x0Var.b(this.f6896d);
        } else if (valueOf != null && valueOf.intValue() == R.id.tvPrivacy) {
            Intent intent = new Intent();
            intent.putExtra("towhere", VipHalfScreenController.URL_PRIVACY);
            intent.setClass(this, OptionsWebviewActivity.class);
            startActivity(intent);
        } else if (valueOf != null && valueOf.intValue() == R.id.tvProtocol) {
            Intent intent2 = new Intent();
            intent2.putExtra("towhere", VipHalfScreenController.URL_SERVICE_PROTOCOL);
            intent2.setClass(this, OptionsWebviewActivity.class);
            startActivity(intent2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        us.pinguo.foundation.utils.d0.a(this);
        super.onCreate(bundle);
        this.b = getIntent().getBooleanExtra("with_full_text", false);
        this.mEnableBaseNotch = false;
        setContentView(R.layout.activity_new_pay_wall);
        us.pinguo.util.h.o(this);
        new e1(this);
        initView();
        s0();
        getLifecycle().addObserver(new NewPayWallLifecycleObserver());
        us.pinguo.repository2020.abtest.f.a.c(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        us.pinguo.foundation.utils.d0.b(this);
        super.onDestroy();
        x0 x0Var = this.f6897e;
        if (x0Var == null) {
            return;
        }
        ((e1) x0Var).n();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (VipManager.a.I()) {
            finish();
        }
        requestCheckIsFullDisplay(-1);
    }

    @Override // com.pinguo.camera360.member.a1
    /* renamed from: t0 */
    public void D(e1 presenter) {
        kotlin.jvm.internal.s.h(presenter, "presenter");
        this.f6897e = presenter;
    }
}

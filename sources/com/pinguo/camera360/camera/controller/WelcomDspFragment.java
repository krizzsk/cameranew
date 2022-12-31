package com.pinguo.camera360.camera.controller;

import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.lib.PGDisplayUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
import us.pinguo.advsdk.a.b;
import us.pinguo.advsdk.bean.AdsItem;
import us.pinguo.advsdk.manager.LaunchScreenManager;
import us.pinguo.advsdk.manager.PgAdvManager;
import us.pinguo.advstrategy.strategybean.StrategyItem;
import us.pinguo.common.imageloader.widget.ImageLoaderView;
import us.pinguo.foundation.base.BaseFragment;
import us.pinguo.librouter.application.BaseApplication;
import vStudio.Android.Camera360.R;
import vStudio.Android.Camera360.a;
import vStudio.Android.Camera360.guide.view.GuideVideoView;
/* loaded from: classes3.dex */
public class WelcomDspFragment extends BaseFragment implements b.a {
    private AdsItem a;
    private String b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private ImageLoaderView f6202d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f6203e;

    /* renamed from: f  reason: collision with root package name */
    private GuideVideoView f6204f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f6205g;

    /* renamed from: h  reason: collision with root package name */
    private ViewGroup f6206h;

    /* renamed from: i  reason: collision with root package name */
    private ViewGroup f6207i;

    /* renamed from: j  reason: collision with root package name */
    private StrategyItem f6208j;

    /* renamed from: k  reason: collision with root package name */
    private a.InterfaceC0470a f6209k = null;

    /* renamed from: l  reason: collision with root package name */
    private boolean f6210l = false;
    private int m = PathInterpolatorCompat.MAX_NUM_POINTS;
    private Timer n = null;
    private TimerTask o = null;
    private Handler p = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements us.pinguo.ui.widget.f {
        a() {
        }

        @Override // us.pinguo.ui.widget.f
        public void a() {
            WelcomDspFragment.this.v0();
        }
    }

    /* loaded from: classes3.dex */
    class b extends Handler {
        b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i2 = message.what;
            if (i2 != 1) {
                if (i2 != 3) {
                    return;
                }
                if (WelcomDspFragment.this.m > 0) {
                    TextView textView = WelcomDspFragment.this.f6205g;
                    textView.setText((WelcomDspFragment.this.m / 1000) + " " + WelcomDspFragment.this.getResources().getString(R.string.guide_page_jump_text));
                    return;
                }
                WelcomDspFragment.this.p.sendEmptyMessage(1);
                return;
            }
            if (WelcomDspFragment.this.f6209k != null) {
                WelcomDspFragment.this.f6209k.n(1, null);
            }
            WelcomDspFragment.this.l0();
            if (WelcomDspFragment.this.f6202d == null) {
                return;
            }
            FragmentActivity activity = WelcomDspFragment.this.getActivity();
            if (activity == null || !activity.isFinishing()) {
                WelcomDspFragment welcomDspFragment = WelcomDspFragment.this;
                welcomDspFragment.s0(welcomDspFragment.f6202d);
                WelcomDspFragment welcomDspFragment2 = WelcomDspFragment.this;
                welcomDspFragment2.t0(welcomDspFragment2.f6204f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c extends TimerTask {
        c() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            WelcomDspFragment.i0(WelcomDspFragment.this, 1000);
            Message message = new Message();
            message.what = 3;
            message.arg1 = WelcomDspFragment.this.m;
            WelcomDspFragment.this.p.sendMessage(message);
        }
    }

    static /* synthetic */ int i0(WelcomDspFragment welcomDspFragment, int i2) {
        int i3 = welcomDspFragment.m - i2;
        welcomDspFragment.m = i3;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0() {
        Timer timer = this.n;
        if (timer != null) {
            timer.cancel();
            this.o.cancel();
            this.n = null;
            this.o = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0 */
    public /* synthetic */ void n0(View view) {
        VdsAgent.lambdaOnClick(view);
        if (this.p.hasMessages(1)) {
            this.p.removeMessages(1);
        }
        this.p.sendEmptyMessage(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0 */
    public /* synthetic */ void p0(View view) {
        VdsAgent.lambdaOnClick(view);
        if (this.f6204f.v()) {
            this.f6204f.setSilent(false);
            this.f6203e.setImageResource(R.drawable.guide_video_sound_open);
            return;
        }
        this.f6204f.setSilent(true);
        this.f6203e.setImageResource(R.drawable.guide_video_sound_close);
    }

    private void q0() {
        HashMap hashMap = new HashMap();
        hashMap.put("cache_num", "1");
        hashMap.put("pg_unit_id", IADStatisticBase.UNIT_ID_SPLASH);
        new us.pinguo.advsdk.manager.f(BaseApplication.d(), hashMap).r(BaseApplication.d(), false);
    }

    private void r0(ViewGroup viewGroup) {
        viewGroup.getLayoutParams().height = (int) (PGDisplayUtils.getDisplaySize().b() * 0.16f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0(ImageView imageView) {
        imageView.setImageBitmap(null);
        imageView.setVisibility(8);
        ViewGroup viewGroup = (ViewGroup) imageView.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(imageView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0(GuideVideoView guideVideoView) {
        guideVideoView.x();
        guideVideoView.y();
        ViewGroup viewGroup = (ViewGroup) guideVideoView.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(guideVideoView);
        }
    }

    private boolean u0() {
        com.pinguo.camera360.k.a.a.a.b displaySize = PGDisplayUtils.getDisplaySize();
        int b2 = displaySize.b();
        int c2 = displaySize.c();
        if (b2 <= c2) {
            b2 = c2;
        }
        try {
            if (!TextUtils.isEmpty(this.a.image.url)) {
                if (!TextUtils.isEmpty(this.b)) {
                    this.f6202d.setImageBitmap(us.pinguo.util.e.w(this.b, b2, 1, false));
                } else {
                    this.f6202d.setImageUrl(this.a.image.url);
                }
                v0();
            } else {
                float f2 = 0.5625f;
                Point f3 = us.pinguo.foundation.t.b.a.f();
                float f4 = f3.x / f3.y;
                if (Math.abs(f4 - 0.5625f) >= Math.abs(f4 - 0.46141216f)) {
                    f2 = 0.46141216f;
                }
                this.f6204f.requestFocus();
                this.f6204f.requestFocusFromTouch();
                this.f6204f.setSilent(false);
                if (this.f6204f.v()) {
                    this.f6203e.setImageResource(R.drawable.guide_video_sound_close);
                } else {
                    this.f6203e.setImageResource(R.drawable.guide_video_sound_open);
                }
                this.f6203e.setVisibility(0);
                this.f6203e.setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.camera.controller.q
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        WelcomDspFragment.this.p0(view);
                    }
                });
                this.f6204f.setRate(f2);
                if (!TextUtils.isEmpty(this.c)) {
                    this.f6204f.setVideoURI(Uri.fromFile(new File(this.c)));
                } else {
                    this.f6204f.setVideoURI(Uri.parse(this.a.video.url));
                }
                this.f6204f.A(0);
                this.f6204f.setLooping(true);
                this.f6204f.setOnStartListener(new a());
                this.f6204f.B();
            }
        } catch (Throwable unused) {
            this.p.sendEmptyMessage(1);
        }
        us.pinguo.advsdk.c.a aVar = new us.pinguo.advsdk.c.a(this.a, null, null);
        if (us.pinguo.user.util.n.i()) {
            ViewGroup viewGroup = this.f6207i;
            viewGroup.setVisibility(0);
            VdsAgent.onSetViewVisibility(viewGroup, 0);
            aVar.p(this.f6207i, new ArrayList(), null, this);
        } else if (!TextUtils.isEmpty(this.a.image.url)) {
            aVar.p(this.f6202d, new ArrayList(), null, this);
        } else {
            aVar.p(this.f6204f, new ArrayList(), null, this);
        }
        LaunchScreenManager.getInstance().a(IADStatisticBase.UNIT_ID_SPLASH);
        StrategyItem strategyItem = this.f6208j;
        if (strategyItem != null && strategyItem.realTimeLoad == 0) {
            q0();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0() {
        this.n = null;
        this.o = null;
        this.n = new Timer();
        c cVar = new c();
        this.o = cVar;
        this.n.schedule(cVar, 1000L, 1000L);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        FragmentActivity activity = getActivity();
        if (activity instanceof a.InterfaceC0470a) {
            this.f6209k = (a.InterfaceC0470a) activity;
        }
        Bundle arguments = getArguments();
        this.a = (AdsItem) arguments.getParcelable("key_adv_dsp_data");
        this.f6208j = (StrategyItem) arguments.getParcelable("key_adv_strategy_data");
        this.b = PgAdvManager.getInstance().n().b(this.a.image.url);
        this.c = PgAdvManager.getInstance().n().b(this.a.video.url);
        this.m = arguments.getInt("mAdsDuration", PathInterpolatorCompat.MAX_NUM_POINTS);
        TextView textView = this.f6205g;
        textView.setText((this.m / 1000) + " " + getResources().getString(R.string.guide_page_jump_text));
        if (!TextUtils.isEmpty(this.f6208j.uiStyle)) {
            if ("closeLogo".equals(this.f6208j.uiStyle)) {
                ViewGroup viewGroup = this.f6206h;
                viewGroup.setVisibility(4);
                VdsAgent.onSetViewVisibility(viewGroup, 4);
            } else {
                ViewGroup viewGroup2 = this.f6206h;
                viewGroup2.setVisibility(0);
                VdsAgent.onSetViewVisibility(viewGroup2, 0);
            }
        }
        if (!TextUtils.isEmpty(this.a.image.url)) {
            this.f6202d.setVisibility(0);
            GuideVideoView guideVideoView = this.f6204f;
            guideVideoView.setVisibility(8);
            VdsAgent.onSetViewVisibility(guideVideoView, 8);
        } else {
            this.f6202d.setVisibility(8);
            GuideVideoView guideVideoView2 = this.f6204f;
            guideVideoView2.setVisibility(0);
            VdsAgent.onSetViewVisibility(guideVideoView2, 0);
        }
        u0();
    }

    @Override // us.pinguo.advsdk.a.b.a
    public void onClick() {
        String str;
        if (this.f6209k != null) {
            this.p.removeMessages(3);
            this.p.removeMessages(1);
            if (TextUtils.isEmpty(this.a.clickUrl) && TextUtils.isEmpty(this.a.landingUrl)) {
                str = "";
            } else {
                str = this.a.clickUrl + this.a.landingUrl;
            }
            this.f6209k.n(64, str);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.layout_welcom_dsp, (ViewGroup) null);
        this.f6202d = (ImageLoaderView) inflate.findViewById(R.id.welcome_ad_image_view);
        this.f6204f = (GuideVideoView) inflate.findViewById(R.id.guide_video_view);
        this.f6206h = (ViewGroup) inflate.findViewById(R.id.logo_layout);
        this.f6207i = (ViewGroup) inflate.findViewById(R.id.logo_layout);
        this.f6203e = (ImageView) inflate.findViewById(R.id.guide_video_sound);
        TextView textView = (TextView) inflate.findViewById(R.id.skip);
        this.f6205g = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.camera.controller.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WelcomDspFragment.this.n0(view);
            }
        });
        r0(this.f6206h);
        return inflate;
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        this.f6210l = true;
        this.p.removeMessages(1);
        GuideVideoView guideVideoView = this.f6204f;
        if (guideVideoView != null && guideVideoView.getVisibility() == 0) {
            this.f6204f.x();
        }
        l0();
        super.onPause();
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f6210l) {
            GuideVideoView guideVideoView = this.f6204f;
            if (guideVideoView != null && guideVideoView.getVisibility() == 0) {
                this.f6204f.B();
            } else {
                v0();
            }
        }
    }
}

package com.pinguo.camera360.camera.controller;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.camera.controller.WelcomeAdsFragment;
import com.pinguo.camera360.k.b.a;
import com.pinguo.lib.PGDisplayUtils;
import java.io.File;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import us.pinguo.admobvista.StaticsAdv.AdvItemStatistic;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.advconfigdata.Utils.AdvConstants;
import us.pinguo.advconfigdata.database.AdvItem;
import us.pinguo.foundation.base.BaseFragment;
import us.pinguo.foundation.interaction.AppGoto;
import us.pinguo.foundation.utils.n0;
import us.pinguo.librouter.application.BaseApplication;
import vStudio.Android.Camera360.R;
import vStudio.Android.Camera360.a;
import vStudio.Android.Camera360.guide.view.GuideVideoView;
/* loaded from: classes3.dex */
public class WelcomeAdsFragment extends BaseFragment {
    private int c;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f6220g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f6221h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f6222i;

    /* renamed from: j  reason: collision with root package name */
    private TextView f6223j;

    /* renamed from: k  reason: collision with root package name */
    private RelativeLayout f6224k;

    /* renamed from: l  reason: collision with root package name */
    private ViewStub f6225l;
    private AdvItem n;
    private GuideVideoView o;
    private ImageView p;
    private ImageView q;
    private String a = IADStatisticBase.VARCHAR_DEFALUT_VALUE;
    private int b = ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED;

    /* renamed from: d  reason: collision with root package name */
    private String f6217d = null;

    /* renamed from: e  reason: collision with root package name */
    private String f6218e = null;

    /* renamed from: f  reason: collision with root package name */
    private String f6219f = null;
    private a.InterfaceC0470a m = null;
    private int r = -1;
    private boolean s = false;
    private boolean t = true;
    private Handler u = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends Handler {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void b() {
            if (WelcomeAdsFragment.this.m != null) {
                WelcomeAdsFragment.this.m.n(1, null);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            us.pinguo.common.log.a.m("WelcomeAdsFragment", "msg.what = " + message.what, new Object[0]);
            int i2 = message.what;
            if (i2 != 1) {
                if (i2 != 3) {
                    return;
                }
                if (WelcomeAdsFragment.this.b > 0) {
                    TextView textView = WelcomeAdsFragment.this.f6223j;
                    textView.setText((WelcomeAdsFragment.this.b / 1000) + " " + BaseApplication.d().getResources().getString(R.string.guide_page_jump_text));
                    Message obtain = Message.obtain();
                    obtain.what = 3;
                    WelcomeAdsFragment.this.u.sendMessageDelayed(obtain, 1000L);
                    WelcomeAdsFragment.i0(WelcomeAdsFragment.this, 1000);
                    return;
                }
                sendEmptyMessage(1);
                return;
            }
            WelcomeAdsFragment.this.u.removeMessages(3);
            WelcomeAdsFragment.this.u.removeMessages(1);
            if (WelcomeAdsFragment.this.r != -1) {
                if (WelcomeAdsFragment.this.o.getVisibility() == 0) {
                    Bitmap bitmap = WelcomeAdsFragment.this.o.getBitmap();
                    if (bitmap != null) {
                        vStudio.Android.Camera360.activity.g.a = bitmap;
                        WelcomeAdsFragment.this.q.setImageBitmap(bitmap);
                        WelcomeAdsFragment.this.q.setVisibility(0);
                    }
                    WelcomeAdsFragment.this.C0();
                    us.pinguo.foundation.utils.f.d(new Runnable() { // from class: com.pinguo.camera360.camera.controller.r
                        @Override // java.lang.Runnable
                        public final void run() {
                            WelcomeAdsFragment.a.this.b();
                        }
                    }, 150L);
                    return;
                } else if (WelcomeAdsFragment.this.f6220g.getVisibility() == 0) {
                    vStudio.Android.Camera360.activity.g.a = ((BitmapDrawable) WelcomeAdsFragment.this.f6220g.getDrawable()).getBitmap();
                    WelcomeAdsFragment.this.C0();
                    if (WelcomeAdsFragment.this.m != null) {
                        WelcomeAdsFragment.this.m.n(1, null);
                        return;
                    }
                    return;
                }
            }
            WelcomeAdsFragment.this.C0();
            if (WelcomeAdsFragment.this.m != null) {
                WelcomeAdsFragment.this.m.n(1, null);
            }
        }
    }

    private void B0() {
        int i2 = us.pinguo.foundation.j.e().i("hairCut", 0);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f6223j.getLayoutParams();
        layoutParams.topMargin += i2;
        this.f6223j.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.p.getLayoutParams();
        layoutParams2.topMargin += i2;
        this.p.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0() {
        GuideVideoView guideVideoView = this.o;
        if (guideVideoView != null) {
            guideVideoView.y();
        }
    }

    private void D0() {
        pl.droidsonroids.gif.c cVar;
        int i2;
        m0();
        if (IADStatisticBase.VARCHAR_DEFALUT_VALUE.equals(this.a)) {
            if (us.pinguo.foundation.d.f10988g) {
                this.f6222i.setVisibility(0);
                this.f6220g.setVisibility(4);
                TextView textView = this.f6223j;
                textView.setVisibility(4);
                VdsAgent.onSetViewVisibility(textView, 4);
            } else {
                this.f6220g.setVisibility(0);
                this.f6222i.setVisibility(8);
                this.f6220g.setImageResource(R.drawable.guide_background_bitmap);
                TextView textView2 = this.f6223j;
                textView2.setVisibility(0);
                VdsAgent.onSetViewVisibility(textView2, 0);
            }
            E0();
            return;
        }
        if (this.n != null) {
            AdvItemStatistic advItemStatistic = new AdvItemStatistic(BaseApplication.d(), IADStatisticBase.PAGE_STARTUP, IADStatisticBase.POS_INTERSTITIAL, false, IADStatisticBase.UNIT_ID_SPLASH);
            advItemStatistic.setAdvItem(this.n);
            advItemStatistic.ShowStatistics();
        }
        l0();
        AdvItem advItem = this.n;
        if (advItem != null && !TextUtils.isEmpty(advItem.mVideoUrl) && !TextUtils.isEmpty(this.a)) {
            try {
                if (!this.s) {
                    us.pinguo.foundation.statistics.h.a.x0(this.f6219f, "show");
                    this.s = true;
                }
                this.o.setSilent(false);
                if (this.o.v()) {
                    this.p.setImageResource(R.drawable.guide_video_sound_close);
                } else {
                    this.p.setImageResource(R.drawable.guide_video_sound_open);
                }
                this.p.setVisibility(0);
                this.p.setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.camera.controller.t
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        WelcomeAdsFragment.this.y0(view);
                    }
                });
                GuideVideoView guideVideoView = this.o;
                guideVideoView.setVisibility(0);
                VdsAgent.onSetViewVisibility(guideVideoView, 0);
                this.f6222i.setVisibility(8);
                this.f6220g.setVisibility(4);
                TextView textView3 = this.f6223j;
                textView3.setVisibility(0);
                VdsAgent.onSetViewVisibility(textView3, 0);
                float f2 = 0.5625f;
                Point f3 = us.pinguo.foundation.t.b.a.f();
                int i3 = f3.y;
                float f4 = f3.x;
                float f5 = i3;
                float f6 = f4 / f5;
                if (Math.abs(f6 - 0.5625f) >= Math.abs(f6 - 0.46141216f)) {
                    f2 = 0.46141216f;
                }
                this.o.setRate(f2);
                this.o.setVideoURI(Uri.fromFile(new File(this.a)));
                this.o.A(0);
                this.o.setLooping(true);
                this.o.setOnStartListener(new us.pinguo.ui.widget.f() { // from class: com.pinguo.camera360.camera.controller.u
                    @Override // us.pinguo.ui.widget.f
                    public final void a() {
                        WelcomeAdsFragment.this.E0();
                    }
                });
                this.o.B();
                this.o.requestFocus();
                this.o.requestFocusFromTouch();
                if (!us.pinguo.user.util.n.i()) {
                    this.o.setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.camera.controller.y
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            WelcomeAdsFragment.this.A0(view);
                        }
                    });
                }
                if (Math.abs(f6 - f2) > 0.001f) {
                    if (f6 >= f2) {
                        i2 = (f3.y - ((int) (f4 / f2))) / 2;
                        if (r3 >= 0 || i2 < 0) {
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.o.getLayoutParams();
                            marginLayoutParams.leftMargin = r3;
                            marginLayoutParams.topMargin = i2;
                            this.o.setLayoutParams(marginLayoutParams);
                            return;
                        }
                        return;
                    }
                    r3 = (f3.x - ((int) ((f5 * f2) + 0.5f))) / 2;
                }
                i2 = 0;
                if (r3 >= 0) {
                }
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.o.getLayoutParams();
                marginLayoutParams2.leftMargin = r3;
                marginLayoutParams2.topMargin = i2;
                this.o.setLayoutParams(marginLayoutParams2);
                return;
            } catch (Exception unused) {
                this.u.sendEmptyMessage(1);
                return;
            }
        }
        us.pinguo.foundation.statistics.l.onEvent(us.pinguo.foundation.e.b(), "community_landing_page_show", "ad_id=" + this.f6219f);
        this.f6222i.setVisibility(8);
        this.f6220g.setVisibility(0);
        TextView textView4 = this.f6223j;
        textView4.setVisibility(0);
        VdsAgent.onSetViewVisibility(textView4, 0);
        if (!this.s) {
            us.pinguo.foundation.statistics.h.a.x0(this.f6219f, "show");
            this.s = true;
        }
        if (this.f6221h.getVisibility() != 0 && this.c == 2) {
            TextView textView5 = this.f6223j;
            textView5.setVisibility(8);
            VdsAgent.onSetViewVisibility(textView5, 8);
        } else {
            TextView textView6 = this.f6223j;
            textView6.setVisibility(0);
            VdsAgent.onSetViewVisibility(textView6, 0);
        }
        if (this.a.endsWith(".gif")) {
            if ((n0.g() > 1.4f ? 1 : 0) == 0) {
                this.u.sendEmptyMessage(1);
                return;
            }
            try {
                if (this.a.startsWith("assets://")) {
                    cVar = new pl.droidsonroids.gif.c(getActivity().getAssets(), this.a.substring(9));
                } else {
                    cVar = new pl.droidsonroids.gif.c(new File(this.a));
                }
                cVar.j(40);
                cVar.g().setColor(ViewCompat.MEASURED_STATE_MASK);
                E0();
                this.f6220g.setImageDrawable(cVar);
                return;
            } catch (Throwable unused2) {
                this.u.sendEmptyMessage(1);
                return;
            }
        }
        com.pinguo.camera360.k.a.a.a.b displaySize = PGDisplayUtils.getDisplaySize();
        int b = displaySize.b();
        int c = displaySize.c();
        if (b <= c) {
            b = c;
        }
        try {
            this.f6220g.setImageBitmap(us.pinguo.util.e.w(this.a, b, 1, false));
            E0();
        } catch (Throwable unused3) {
            this.u.sendEmptyMessage(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0() {
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.arg1 = this.b;
        this.u.sendMessage(obtain);
    }

    static /* synthetic */ int i0(WelcomeAdsFragment welcomeAdsFragment, int i2) {
        int i3 = welcomeAdsFragment.b - i2;
        welcomeAdsFragment.b = i3;
        return i3;
    }

    private void k0() {
        if (this.n == null) {
            return;
        }
        if (this.m != null) {
            this.u.removeMessages(3);
            this.u.removeMessages(1);
            this.t = false;
            AppGoto.getInstance().d(this.n).b(getActivity());
            this.m.n(64, this.f6217d);
        }
        a.b.f("show_detail");
        us.pinguo.foundation.statistics.l.onEvent(us.pinguo.foundation.e.b(), "community_landing_page_click", "ad_id=" + this.f6219f);
        AdvItemStatistic advItemStatistic = new AdvItemStatistic(BaseApplication.d(), IADStatisticBase.PAGE_STARTUP, IADStatisticBase.POS_INTERSTITIAL, false, IADStatisticBase.UNIT_ID_SPLASH);
        advItemStatistic.setAdvItem(this.n);
        advItemStatistic.ClickStatistics(IADStatisticBase.CLICK_TYPE_BODY);
        us.pinguo.foundation.statistics.h.a.x0(this.f6219f, "click");
    }

    private void l0() {
        if (us.pinguo.user.util.n.i()) {
            if (AdvConstants.ADV_TYPE_BRAND.equals(this.n.advType)) {
                LinearLayout linearLayout = (LinearLayout) getView().findViewById(R.id.brandCtaButton);
                linearLayout.setVisibility(0);
                VdsAgent.onSetViewVisibility(linearLayout, 0);
                linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.camera.controller.x
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        WelcomeAdsFragment.this.p0(view);
                    }
                });
            } else if (TextUtils.isEmpty(this.f6218e)) {
                this.f6221h.setVisibility(8);
            } else {
                int c = n0.c(IjkMediaCodecInfo.RANK_SECURE);
                try {
                    int j2 = us.pinguo.foundation.t.b.a.j(BaseApplication.d()) - n0.c(72);
                    Bitmap w = us.pinguo.util.e.w(this.f6218e, c, 1, false);
                    ViewGroup.LayoutParams layoutParams = this.f6221h.getLayoutParams();
                    layoutParams.height = (int) ((w.getHeight() / w.getWidth()) * j2);
                    layoutParams.width = j2;
                    this.f6221h.setLayoutParams(layoutParams);
                    this.f6221h.setImageBitmap(w);
                    this.f6221h.setVisibility(0);
                } catch (Throwable unused) {
                    this.f6221h.setVisibility(8);
                }
                this.f6221h.setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.camera.controller.w
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        WelcomeAdsFragment.this.r0(view);
                    }
                });
            }
        }
    }

    private void m0() {
        AdvItem advItem = this.n;
        if (advItem != null && AdvConstants.ADV_TYPE_BRAND.equals(advItem.advType) && this.f6225l.getParent() != null && this.n.showIcon == 1) {
            RelativeLayout relativeLayout = (RelativeLayout) this.f6225l.inflate().findViewById(R.id.logo_layout);
            this.f6224k = relativeLayout;
            relativeLayout.setOnClickListener(v.a);
            this.f6225l.setVisibility(0);
            return;
        }
        this.f6225l.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0 */
    public /* synthetic */ void p0(View view) {
        VdsAgent.lambdaOnClick(view);
        k0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0 */
    public /* synthetic */ void r0(View view) {
        VdsAgent.lambdaOnClick(view);
        k0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0 */
    public /* synthetic */ void u0(View view) {
        VdsAgent.lambdaOnClick(view);
        if (!(TextUtils.isEmpty(this.a) || IADStatisticBase.VARCHAR_DEFALUT_VALUE.equals(this.a))) {
            a.b.f("skip_wel");
        }
        if (this.u.hasMessages(1)) {
            this.u.removeMessages(1);
            this.u.sendEmptyMessage(1);
        } else {
            this.u.sendEmptyMessage(1);
        }
        us.pinguo.foundation.statistics.h.a.x0(this.f6219f, "pass");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v0 */
    public /* synthetic */ void w0(View view) {
        VdsAgent.lambdaOnClick(view);
        k0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x0 */
    public /* synthetic */ void y0(View view) {
        VdsAgent.lambdaOnClick(view);
        if (this.o.v()) {
            this.o.setSilent(false);
            this.p.setImageResource(R.drawable.guide_video_sound_open);
            return;
        }
        this.o.setSilent(true);
        this.p.setImageResource(R.drawable.guide_video_sound_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z0 */
    public /* synthetic */ void A0(View view) {
        VdsAgent.lambdaOnClick(view);
        k0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        FragmentActivity activity = getActivity();
        if (activity instanceof a.InterfaceC0470a) {
            this.m = (a.InterfaceC0470a) activity;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.r = arguments.getInt("union_adv_index", -1);
            AdvItem advItem = (AdvItem) arguments.getParcelable("mAdsItem");
            this.n = advItem;
            if (advItem != null) {
                AdvConfigManager.getInstance().addGuidDisplayCount(this.n);
                AdvItem advItem2 = this.n;
                this.a = advItem2.downloadedFilePath;
                this.f6217d = advItem2.interactionUri;
                this.f6218e = advItem2.downloadedIconPath;
                this.c = advItem2.allowIgnore;
                this.f6219f = advItem2.advId;
                this.b = (int) (advItem2.duration * 1000.0d);
            } else {
                String string = arguments.getString("mAdsImagePath");
                this.a = string;
                if (string == null) {
                    this.a = IADStatisticBase.VARCHAR_DEFALUT_VALUE;
                }
                this.f6217d = arguments.getString("mAdsClickUri");
                this.f6218e = arguments.getString("mAdsBtnImagePath");
                this.c = arguments.getInt("mAdsIgnoreSkipBtn");
                this.f6219f = arguments.getString("key_ads_id");
                this.b = arguments.getInt("mAdsDuration", ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
            }
            if (this.b > 15000) {
                this.b = 15000;
            }
            TextView textView = this.f6223j;
            textView.setText((this.b / 1000) + " " + BaseApplication.d().getResources().getString(R.string.guide_page_jump_text));
        }
        super.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.s = false;
        View inflate = layoutInflater.inflate(R.layout.layout_welcome_ad, (ViewGroup) null);
        this.f6220g = (ImageView) inflate.findViewById(R.id.welcome_ad_image_view);
        this.p = (ImageView) inflate.findViewById(R.id.guide_video_sound);
        this.o = (GuideVideoView) inflate.findViewById(R.id.guide_video_view);
        this.f6222i = (ImageView) inflate.findViewById(R.id.flash_image);
        this.q = (ImageView) inflate.findViewById(R.id.imgTransition);
        this.f6223j = (TextView) inflate.findViewById(R.id.skip);
        this.f6225l = (ViewStub) inflate.findViewById(R.id.vs_logo_layout);
        this.f6221h = (ImageView) inflate.findViewById(R.id.btn_image);
        this.f6223j.setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.camera.controller.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WelcomeAdsFragment.this.u0(view);
            }
        });
        if (!us.pinguo.user.util.n.i()) {
            this.f6220g.setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.camera.controller.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WelcomeAdsFragment.this.w0(view);
                }
            });
        }
        B0();
        return inflate;
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        this.u.removeMessages(1);
        super.onPause();
        GuideVideoView guideVideoView = this.o;
        if (guideVideoView == null || guideVideoView.getVisibility() != 0) {
            return;
        }
        this.o.x();
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        us.pinguo.common.log.a.m("WelcomeAdsFragment", "onResume", new Object[0]);
        if (this.t) {
            D0();
        }
        super.onResume();
    }
}

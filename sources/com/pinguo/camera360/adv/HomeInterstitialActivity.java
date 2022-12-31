package com.pinguo.camera360.adv;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.facebook.drawee.backends.pipeline.e;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.advconfigdata.database.AdvItem;
import us.pinguo.foundation.base.InspireBaseActivity;
import us.pinguo.foundation.interaction.AppGoto;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class HomeInterstitialActivity extends InspireBaseActivity {
    private SimpleDraweeView a;
    private SimpleDraweeView b;
    private ImageView c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f6141d;

    /* renamed from: e  reason: collision with root package name */
    private SimpleDraweeView f6142e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f6143f;

    /* renamed from: g  reason: collision with root package name */
    private LinearLayout f6144g;

    /* renamed from: h  reason: collision with root package name */
    private RelativeLayout f6145h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            HomeInterstitialActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        final /* synthetic */ AdvItem a;

        b(HomeInterstitialActivity homeInterstitialActivity, AdvItem advItem) {
            this.a = advItem;
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            AppGoto.getInstance().d(this.a).b(view.getContext());
        }
    }

    private void init() {
        this.a = (SimpleDraweeView) findViewById(R.id.iv_center_ad);
        this.b = (SimpleDraweeView) findViewById(R.id.iv_fullscreen);
        this.c = (ImageView) findViewById(R.id.iv_fullscreen_close);
        this.f6141d = (ImageView) findViewById(R.id.iv_center_close);
        this.f6144g = (LinearLayout) findViewById(R.id.center_ad_layout);
        this.f6145h = (RelativeLayout) findViewById(R.id.fullscreen_ad_layout);
    }

    private void q0(AdvItem advItem) {
        if (advItem.screenType == 1) {
            LinearLayout linearLayout = this.f6144g;
            linearLayout.setVisibility(8);
            VdsAgent.onSetViewVisibility(linearLayout, 8);
            RelativeLayout relativeLayout = this.f6145h;
            relativeLayout.setVisibility(0);
            VdsAgent.onSetViewVisibility(relativeLayout, 0);
            this.f6142e = this.b;
            this.f6143f = this.c;
            return;
        }
        LinearLayout linearLayout2 = this.f6144g;
        linearLayout2.setVisibility(0);
        VdsAgent.onSetViewVisibility(linearLayout2, 0);
        RelativeLayout relativeLayout2 = this.f6145h;
        relativeLayout2.setVisibility(8);
        VdsAgent.onSetViewVisibility(relativeLayout2, 8);
        this.f6142e = this.a;
        this.f6143f = this.f6141d;
    }

    private void r0() {
        try {
            AdvItem loadDownloadedImage = AdvConfigManager.getInstance().loadDownloadedImage(AdvConfigManager.getInstance().getItemHightPrioritys("a2708d8113ee758a5e172f8b4a8952d0"));
            if (loadDownloadedImage == null) {
                finish();
                return;
            }
            q0(loadDownloadedImage);
            String str = loadDownloadedImage.downloadedFilePath;
            if (!TextUtils.isEmpty(str)) {
                e h2 = com.facebook.drawee.backends.pipeline.c.h();
                e L = h2.L(InspirePublishFragment.FILE_HEADER + str);
                L.y(true);
                this.f6142e.setController(L.build());
            } else {
                finish();
            }
            this.f6143f.setOnClickListener(new a());
            this.f6142e.setOnClickListener(new b(this, loadDownloadedImage));
            AdvConfigManager.getInstance().addGuidDisplayCount(loadDownloadedImage);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.InspireBaseActivity, us.pinguo.foundation.base.InspireRedirectActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_home_interstitial);
        init();
        r0();
    }
}

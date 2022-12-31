package com.pinguo.camera360.adv;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.NativeAd;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.foundation.base.InspireBaseActivity;
import us.pinguo.ui.widget.ShimmerFrameLayout;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class CommonInterstitialActivity extends InspireBaseActivity implements View.OnClickListener {
    private ShimmerFrameLayout a;

    private void q0() {
        String stringExtra = getIntent().getStringExtra("unit_id");
        us.pinguo.advsdk.a.b b = InterstitialManager.getInstance().b(stringExtra);
        if (b == null) {
            finish();
            return;
        }
        this.a = (ShimmerFrameLayout) findViewById(R.id.shimmer_view_container);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.ivIcon);
        ImageView imageView = (ImageView) findViewById(R.id.tvMark);
        TextView textView = (TextView) findViewById(R.id.tvAdvTitle);
        TextView textView2 = (TextView) findViewById(R.id.tvAdvContent);
        TextView textView3 = (TextView) findViewById(R.id.btnAdvClick);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.root_res_0x7f09060e);
        ViewGroup viewGroup = (RelativeLayout) findViewById(R.id.rl_ad_container);
        View view = (RelativeLayout) findViewById(R.id.rl_ad_root);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ad_choices_container);
        ((ImageView) findViewById(R.id.close_button)).setOnClickListener(this);
        SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) findViewById(R.id.ivAdv);
        if (b.l() != 1) {
            simpleDraweeView.setImageURI(Uri.parse(b.e()));
        }
        if (!r0(b)) {
            simpleDraweeView2.setImageURI(b.g());
        }
        textView.setText(b.k());
        textView2.setText(b.c());
        if (!TextUtils.isEmpty(b.b())) {
            textView3.setText(b.b());
        }
        if (b.l() == 1) {
            imageView.setVisibility(8);
            linearLayout.addView(new AdOptionsView(this, (NativeAd) b.h(), null));
        }
        List<View> arrayList = new ArrayList<>();
        arrayList.add(simpleDraweeView2);
        arrayList.add(textView);
        arrayList.add(textView2);
        arrayList.add(simpleDraweeView);
        arrayList.add(textView3);
        b.o(view, arrayList, viewGroup);
        InterstitialManager.getInstance().f(stringExtra);
    }

    private boolean r0(us.pinguo.advsdk.a.b bVar) {
        return bVar.l() == 1 || bVar.l() == 18 || bVar.l() == 3 || bVar.l() == 2;
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.InspireBaseActivity, us.pinguo.foundation.base.InspireRedirectActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_common_interstitial);
        q0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.InspireBaseActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.a.v();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.InspireBaseActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.a.u();
    }
}

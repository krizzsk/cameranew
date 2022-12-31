package com.bytedance.sdk.openadsdk.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.CustomEventInterstitialListener;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.core.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.g.d;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.b;
import com.bytedance.sdk.openadsdk.utils.o;
import com.bytedance.sdk.openadsdk.utils.t;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.ArrayList;
import us.pinguo.androidsdk.PGImageSDK;
/* loaded from: classes.dex */
public class PangleAdInterstitialActivity extends Activity {
    public static final String INTENT_TYPE = "intent_type";
    public static final int INTENT_TYPE_IMAGE_2_3 = 2;
    public static final int INTENT_TYPE_IMAGE_3_2 = 1;
    private static CustomEventInterstitialListener n;
    private static TTNativeAd o;
    private ImageView a;
    private RelativeLayout b;
    private NiceImageView c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f1382d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f1383e;

    /* renamed from: f  reason: collision with root package name */
    private Button f1384f;

    /* renamed from: g  reason: collision with root package name */
    private TTRatingBar f1385g;

    /* renamed from: h  reason: collision with root package name */
    private Intent f1386h;

    /* renamed from: i  reason: collision with root package name */
    private ViewGroup f1387i;

    /* renamed from: j  reason: collision with root package name */
    private RelativeLayout f1388j;

    /* renamed from: k  reason: collision with root package name */
    private ViewGroup f1389k;

    /* renamed from: l  reason: collision with root package name */
    private float f1390l;
    private float m;

    /* JADX WARN: Removed duplicated region for block: B:25:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b() {
        /*
            Method dump skipped, instructions count: 352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.adapter.PangleAdInterstitialActivity.b():void");
    }

    private void c() {
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.adapter.PangleAdInterstitialActivity.3
            @Override // android.view.View.OnClickListener
            @Instrumented
            public void onClick(View view) {
                VdsAgent.onClick(this, view);
                PangleAdInterstitialActivity.this.finish();
                if (PangleAdInterstitialActivity.n != null) {
                    PangleAdInterstitialActivity.n.onInterstitialDismissed();
                }
            }
        });
    }

    private void d() {
        TTRatingBar tTRatingBar = (TTRatingBar) findViewById(t.e(this, "tt_pangle_ad_score"));
        this.f1385g = tTRatingBar;
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            this.f1385g.setStarFillNum(4);
            this.f1385g.setStarImageWidth(ac.c(getApplicationContext(), 15.0f));
            this.f1385g.setStarImageHeight(ac.c(getApplicationContext(), 14.0f));
            this.f1385g.setStarImagePadding(ac.c(getApplicationContext(), 4.0f));
            this.f1385g.a();
        }
        this.a = (ImageView) findViewById(t.e(this, "tt_pangle_ad_main_img"));
        this.b = (RelativeLayout) findViewById(t.e(this, "tt_pangle_ad_close_layout"));
        this.c = (NiceImageView) findViewById(t.e(this, "tt_pangle_ad_icon"));
        this.f1382d = (TextView) findViewById(t.e(this, "tt_pangle_ad_title"));
        this.f1383e = (TextView) findViewById(t.e(this, "tt_pangle_ad_content"));
        this.f1384f = (Button) findViewById(t.e(this, "tt_pangle_ad_btn"));
        this.f1387i = (ViewGroup) findViewById(t.e(this, "tt_pangle_ad_content_layout"));
        this.f1388j = (RelativeLayout) findViewById(t.e(this, "tt_pangle_ad_image_layout"));
        this.f1389k = (ViewGroup) findViewById(t.e(this, "tt_pangle_ad_root"));
    }

    public static void showAd(Context context, TTNativeAd tTNativeAd, int i2, CustomEventInterstitialListener customEventInterstitialListener) {
        o = tTNativeAd;
        n = customEventInterstitialListener;
        Intent intent = new Intent(context, PangleAdInterstitialActivity.class);
        intent.addFlags(PGImageSDK.SDK_STATUS_CREATE);
        intent.putExtra(INTENT_TYPE, i2);
        b.a(context, intent, new b.a() { // from class: com.bytedance.sdk.openadsdk.adapter.PangleAdInterstitialActivity.1
            @Override // com.bytedance.sdk.openadsdk.utils.b.a
            public void a() {
            }

            @Override // com.bytedance.sdk.openadsdk.utils.b.a
            public void a(Throwable th) {
                if (PangleAdInterstitialActivity.n != null) {
                    PangleAdInterstitialActivity.n.onInterstitialShowFail();
                }
            }
        });
    }

    @Override // android.app.Activity
    public void onBackPressed() {
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f1386h = getIntent();
        try {
            requestWindowFeature(1);
            getWindow().addFlags(1024);
            getWindow().addFlags(16777216);
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        o = null;
        n = null;
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f1390l = ac.c((Context) this);
        this.m = ac.d(this);
        if (this.f1386h.getIntExtra(INTENT_TYPE, 0) == 2) {
            setRequestedOrientation(1);
        } else {
            setRequestedOrientation(0);
        }
        if (this.f1386h != null) {
            b();
        }
    }

    private void a(int i2) {
        ViewGroup.LayoutParams layoutParams = this.f1388j.getLayoutParams();
        layoutParams.height = i2;
        this.f1388j.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.f1387i.getLayoutParams();
        layoutParams2.height = (int) (this.m - i2);
        this.f1387i.setLayoutParams(layoutParams2);
    }

    private void a(TTNativeAd tTNativeAd) {
        TTImage tTImage;
        if (tTNativeAd != null) {
            if (o.getImageList() != null && !o.getImageList().isEmpty() && (tTImage = o.getImageList().get(0)) != null && tTImage.isValid()) {
                d.a(this).a(tTImage.getImageUrl(), this.a);
            }
            if (o.getIcon() != null && o.getIcon().isValid() && o.getIcon().getImageUrl() != null) {
                d.a(this).a(o.getIcon().getImageUrl(), this.c);
            }
            this.f1382d.setText(o.getTitle());
            this.f1383e.setText(o.getDescription());
            this.f1384f.setText(o.getButtonText());
            c();
            b(tTNativeAd);
        }
    }

    private void b(TTNativeAd tTNativeAd) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.a);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.f1384f);
        tTNativeAd.registerViewForInteraction(this.f1389k, arrayList, arrayList2, this.b, new TTNativeAd.AdInteractionListener() { // from class: com.bytedance.sdk.openadsdk.adapter.PangleAdInterstitialActivity.2
            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdClicked(View view, TTNativeAd tTNativeAd2) {
                o.b("PangleAdInterstitial", "PangleAdInterstitialActivity-onAdClicked....");
                if (PangleAdInterstitialActivity.n != null) {
                    PangleAdInterstitialActivity.n.onInterstitialClicked();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdCreativeClick(View view, TTNativeAd tTNativeAd2) {
                o.b("PangleAdInterstitial", "PangleAdInterstitialActivity-onAdClicked....");
                if (PangleAdInterstitialActivity.n != null) {
                    PangleAdInterstitialActivity.n.onInterstitialClicked();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdShow(TTNativeAd tTNativeAd2) {
                o.b("PangleAdInterstitial", "PangleAdInterstitialActivity-onAdShow....");
                if (PangleAdInterstitialActivity.n != null) {
                    PangleAdInterstitialActivity.n.onInterstitialShown();
                }
            }
        });
    }
}

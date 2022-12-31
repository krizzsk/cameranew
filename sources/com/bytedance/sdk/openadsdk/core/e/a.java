package com.bytedance.sdk.openadsdk.core.e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.R;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.d.g;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.f.a.c;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.b;
import com.bytedance.sdk.openadsdk.utils.r;
import com.bytedance.sdk.openadsdk.utils.t;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* compiled from: TTNativeAdImpl.java */
/* loaded from: classes.dex */
public class a implements TTNativeAd {
    private int a;

    /* renamed from: g  reason: collision with root package name */
    protected final n f1625g;

    /* renamed from: h  reason: collision with root package name */
    protected final h f1626h;

    /* renamed from: i  reason: collision with root package name */
    protected final Context f1627i;

    /* renamed from: j  reason: collision with root package name */
    protected TTAdDislike f1628j;

    /* renamed from: k  reason: collision with root package name */
    protected int f1629k;

    /* renamed from: l  reason: collision with root package name */
    protected String f1630l;

    public a(@NonNull Context context, @NonNull h hVar, int i2) {
        r.a(hVar, "materialMeta can't been null");
        this.f1626h = hVar;
        this.f1627i = context;
        this.f1629k = i2;
        this.f1625g = new n(context, this, hVar, a(i2));
    }

    private String a(int i2) {
        return i2 != 1 ? i2 != 2 ? (i2 == 5 || i2 != 9) ? "embeded_ad" : "draw_ad" : "interaction" : "banner_ad";
    }

    private List<View> a(List<View> list, List<View> list2) {
        LinkedList linkedList = new LinkedList();
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                linkedList.add(list.get(i2));
            }
        }
        if (list2 != null && !list2.isEmpty()) {
            int size2 = list2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                linkedList.add(list2.get(i3));
            }
        }
        return linkedList;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public Bitmap getAdLogo() {
        return BitmapFactory.decodeResource(this.f1627i.getResources(), t.d(o.a(), "tt_ad_logo_small"));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public View getAdLogoView() {
        if (this.f1627i == null) {
            com.bytedance.sdk.openadsdk.utils.o.e("TTNativeAdImpl", "getAdLogoView mContext == null");
            return null;
        }
        ImageView imageView = new ImageView(this.f1627i);
        imageView.setImageResource(R.drawable.tt_ad_logo_small);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.e.a.2
            @Override // android.view.View.OnClickListener
            @Instrumented
            public void onClick(View view) {
                VdsAgent.onClick(this, view);
                a.this.showPrivacyActivity();
            }
        });
        return imageView;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public View getAdView() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppCommentNum() {
        if (this.f1626h.K() != null) {
            return this.f1626h.K().e();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppScore() {
        if (this.f1626h.K() != null) {
            return this.f1626h.K().d();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppSize() {
        if (this.f1626h.K() != null) {
            return this.f1626h.K().f();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getButtonText() {
        return this.f1626h.I();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getDescription() {
        if (!TextUtils.isEmpty(this.f1626h.G())) {
            return this.f1626h.G();
        }
        return this.f1626h.H();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTAdDislike getDislikeDialog(Activity activity) {
        if (this.f1628j == null) {
            a(activity);
        }
        return this.f1628j;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public List<FilterWord> getFilterWords() {
        h hVar = this.f1626h;
        if (hVar == null) {
            return null;
        }
        return hVar.O();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTImage getIcon() {
        if (this.f1626h.y() == null) {
            return null;
        }
        return g.a(this.f1626h.y());
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public List<TTImage> getImageList() {
        ArrayList arrayList = new ArrayList();
        if (this.f1626h.B() != null && !this.f1626h.B().isEmpty()) {
            for (g gVar : this.f1626h.B()) {
                arrayList.add(g.a(gVar));
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getImageMode() {
        h hVar = this.f1626h;
        if (hVar == null) {
            return -1;
        }
        return hVar.N();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getInteractionType() {
        h hVar = this.f1626h;
        if (hVar == null) {
            return -1;
        }
        return hVar.x();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public Map<String, Object> getMediaExtraInfo() {
        h hVar = this.f1626h;
        if (hVar != null) {
            return hVar.T();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getSource() {
        return this.f1626h.w();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getTitle() {
        if (this.f1626h.K() != null && !TextUtils.isEmpty(this.f1626h.K().b())) {
            return this.f1626h.K().b();
        }
        if (!TextUtils.isEmpty(getSource())) {
            return getSource();
        }
        return this.f1626h.G();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTImage getVideoCoverImage() {
        h hVar = this.f1626h;
        if (hVar == null || hVar.v() == null) {
            return null;
        }
        return new TTImage(this.f1626h.v().b(), this.f1626h.v().c(), this.f1626h.v().g());
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        r.a(viewGroup, "container can't been null");
        r.a(view, "clickView can't been null");
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(view);
        registerViewForInteraction(viewGroup, arrayList, null, adInteractionListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void showPrivacyActivity() {
        Context context = this.f1627i;
        if (context != null) {
            h hVar = this.f1626h;
            if (hVar != null) {
                d.a(context, hVar, this.f1630l, "open_policy");
            }
            if (TextUtils.isEmpty(o.h().q())) {
                return;
            }
            b.a(this.f1627i, new Intent(this.f1627i, TTWebsiteActivity.class), null);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTAdDislike getDislikeDialog(final TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        if (tTDislikeDialogAbstract != null) {
            tTDislikeDialogAbstract.setMaterialMeta(this.f1626h);
            return new TTAdDislike() { // from class: com.bytedance.sdk.openadsdk.core.e.a.1
                @Override // com.bytedance.sdk.openadsdk.TTAdDislike
                public void setDislikeInteractionCallback(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike
                public void showDislikeDialog() {
                    if ((tTDislikeDialogAbstract.getContext() instanceof Activity) && !((Activity) tTDislikeDialogAbstract.getContext()).isFinishing()) {
                        TTDislikeDialogAbstract tTDislikeDialogAbstract2 = tTDislikeDialogAbstract;
                        tTDislikeDialogAbstract2.show();
                        VdsAgent.showDialog(tTDislikeDialogAbstract2);
                    }
                }
            };
        }
        throw new IllegalArgumentException("dialog is null, please check");
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, TTNativeAd.AdInteractionListener adInteractionListener) {
        r.a(viewGroup, "container can't been null");
        r.a(list, "clickView can't been null");
        r.a(list.size() > 0, "clickViews size must been more than 1");
        registerViewForInteraction(viewGroup, list, list2, null, adInteractionListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [android.content.Context] */
    private void a(Activity activity) {
        Context context = this.f1627i;
        Activity activity2 = activity;
        if (context instanceof Activity) {
            activity2 = activity;
            if (!((Activity) context).isFinishing()) {
                activity2 = this.f1627i;
            }
        }
        this.f1628j = new com.bytedance.sdk.openadsdk.dislike.b(activity2, this.f1626h);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, @Nullable View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        r.a(viewGroup, "container can't been null");
        r.a(list, "clickView can't been null");
        r.a(list.size() > 0, "clickViews size must been more than 1");
        registerViewForInteraction(viewGroup, null, list, list2, view, adInteractionListener);
    }

    private void a(boolean z) {
        c c = c.b().a(this.f1629k).c(String.valueOf(ab.d(this.f1626h.M())));
        if (z) {
            com.bytedance.sdk.openadsdk.f.a.a().d(c);
        } else {
            com.bytedance.sdk.openadsdk.f.a.a().e(c);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull List<View> list, @NonNull List<View> list2, @Nullable List<View> list3, @Nullable View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        r.a(viewGroup, "container can't been null");
        r.a(list2, "clickView can't been null");
        boolean z = true;
        r.a(list2.size() > 0, "clickViews size must been more than 1");
        a((list3 == null || list3.size() <= 0) ? false : false);
        if (a()) {
            list3 = a(list2, list3);
        }
        this.f1625g.a(viewGroup, list, list2, list3, view, adInteractionListener);
    }

    private boolean a() {
        h hVar = this.f1626h;
        if (hVar == null || hVar.x() == 5) {
            return false;
        }
        if (this.a == 0) {
            this.a = ab.d(this.f1626h.M());
        }
        return o.h().d(this.a) == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        this.f1630l = str;
    }
}

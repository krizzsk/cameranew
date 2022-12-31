package us.pinguo.camera360.shop.details;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.ui.TitleBarLayout;
import us.pinguo.camera360.shop.data.show.ShowDetail;
import us.pinguo.camera360.shop.data.show.ShowPkg;
import us.pinguo.camera360.shop.j;
import us.pinguo.camera360.shop.view.details.DetailsInstallButton;
import us.pinguo.camera360.shop.view.details.DetailsLoadView;
import us.pinguo.camera360.shop.view.details.SlideImageView;
import us.pinguo.ui.widget.banner.CellStandoutIndicator;
import vStudio.Android.Camera360.R;
/* loaded from: classes4.dex */
public class PkgDetailsView extends TitleBarLayout implements f, us.pinguo.foundation.p.b {

    /* renamed from: i  reason: collision with root package name */
    private b f9669i;

    /* renamed from: j  reason: collision with root package name */
    private Context f9670j;

    /* renamed from: k  reason: collision with root package name */
    private Animation f9671k;

    /* renamed from: l  reason: collision with root package name */
    private Animation f9672l;
    private h m;
    private j n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends us.pinguo.foundation.ui.b {
        a() {
        }

        @Override // us.pinguo.foundation.ui.b, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            PkgDetailsView.this.setVisibility(4);
            PkgDetailsView.this.f9669i.d();
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends d implements SlideImageView.c {
        public SlideImageView a;
        public TextView b;
        public DetailsInstallButton c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f9673d;

        /* renamed from: e  reason: collision with root package name */
        public ImageView f9674e;

        /* renamed from: f  reason: collision with root package name */
        public CellStandoutIndicator f9675f;

        /* renamed from: g  reason: collision with root package name */
        public View f9676g;

        /* renamed from: h  reason: collision with root package name */
        public ShowPkg f9677h;

        /* renamed from: i  reason: collision with root package name */
        public ShowDetail f9678i;

        /* renamed from: j  reason: collision with root package name */
        public DetailsLoadView f9679j;

        /* renamed from: k  reason: collision with root package name */
        public PkgDetailsView f9680k;

        /* renamed from: l  reason: collision with root package name */
        public View f9681l;
        public View m;
        public TextView n;

        /* loaded from: classes4.dex */
        class a implements TitleBarLayout.a {
            a() {
            }

            @Override // com.pinguo.camera360.ui.TitleBarLayout.a
            public void onLeftBtnClick(View view) {
                if (b.this.f9680k.m != null) {
                    b.this.f9680k.m.t(view);
                }
            }

            @Override // com.pinguo.camera360.ui.TitleBarLayout.a
            public void onRightBtnClick(View view) {
                if (b.this.f9680k.m != null) {
                    b.this.f9680k.m.u(b.this.f9677h);
                }
            }
        }

        public b(View view) {
            super(view);
            this.f9680k = (PkgDetailsView) view;
            this.f9676g = view;
            this.f9679j = (DetailsLoadView) view.findViewById(R.id.store_details_dlv);
            this.a = (SlideImageView) view.findViewById(R.id.store_pkg_details_icon_siv);
            this.b = (TextView) view.findViewById(R.id.store_pkg_details_name_tv);
            this.c = (DetailsInstallButton) view.findViewById(R.id.store_package_details_install_bt);
            this.f9673d = (TextView) view.findViewById(R.id.store_pkg_details_description_tv);
            ImageView d2 = this.f9680k.d();
            this.f9674e = d2;
            d2.setImageResource(R.drawable.store_pkg_delete);
            this.f9675f = (CellStandoutIndicator) view.findViewById(R.id.store_pkg_details_indicator_iv);
            this.f9681l = view.findViewById(R.id.v_vip_icon);
            this.m = view.findViewById(R.id.v_free_icon);
            this.a.setOnSlideImageListener(this);
            this.n = (TextView) view.findViewById(R.id.store_pkg_details_price_tv);
            this.f9680k.setOnTitleBarClickListener(new a());
        }

        @Override // us.pinguo.camera360.shop.view.details.SlideImageView.c
        public void a(int i2, ShowDetail.a aVar) {
            this.b.setText(aVar.a());
            this.f9675f.setCurrentItem(i2);
        }

        public DetailsLoadView b() {
            return this.f9679j;
        }

        public void c() {
            this.a.o();
            this.f9680k = null;
        }

        public void d() {
            this.a.p();
            this.b.setText("");
            DetailsInstallButton detailsInstallButton = this.c;
            detailsInstallButton.setVisibility(4);
            VdsAgent.onSetViewVisibility(detailsInstallButton, 4);
            this.f9673d.setText("");
            this.f9680k.setTiTleText("");
            this.f9675f.setCurrentItem(0);
            this.f9674e.setVisibility(4);
        }
    }

    public PkgDetailsView(Context context) {
        super(context);
        this.f9670j = getContext();
        setClickable(true);
    }

    private void u() {
        this.f9671k = AnimationUtils.loadAnimation(this.f9670j, R.anim.store_details_view_from_right);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f9670j, R.anim.store_details_view_gone_right);
        this.f9672l = loadAnimation;
        loadAnimation.setAnimationListener(new a());
    }

    private void w(View view, boolean z) {
        j jVar = this.n;
        if (jVar != null) {
            jVar.q(view, z);
        }
        h hVar = this.m;
        if (hVar != null) {
            hVar.v(view, z);
        }
    }

    @Override // us.pinguo.camera360.shop.details.f
    public void a() {
        if (this.f9671k.hasStarted()) {
            this.f9671k.cancel();
        }
        setVisibility(0);
        startAnimation(this.f9671k);
    }

    @Override // us.pinguo.camera360.shop.details.f
    public d b() {
        return this.f9669i;
    }

    @Override // us.pinguo.camera360.shop.details.f
    public boolean isShowing() {
        return getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.ui.TitleBarLayout, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f9669i = new b(this);
        u();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.ui.TitleBarLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    public void setPresenter(e eVar) {
        this.m = (h) eVar;
    }

    public void setVisiableListener(j jVar) {
        this.n = jVar;
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        VdsAgent.onSetViewVisibility(this, i2);
        w(this, i2 == 0);
    }

    public void t() {
        if (this.f9672l.hasStarted()) {
            this.f9672l.cancel();
        }
        startAnimation(this.f9672l);
    }

    public void x() {
        w(this, false);
    }

    public void y() {
        w(this, isShowing());
    }

    public PkgDetailsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9670j = getContext();
        setClickable(true);
    }

    public PkgDetailsView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f9670j = getContext();
        setClickable(true);
    }
}

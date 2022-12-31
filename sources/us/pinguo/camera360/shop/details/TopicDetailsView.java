package us.pinguo.camera360.shop.details;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.ui.TitleBarLayout;
import us.pinguo.camera360.shop.j;
import us.pinguo.camera360.shop.view.details.DetailsLoadView;
import vStudio.Android.Camera360.R;
/* loaded from: classes4.dex */
public class TopicDetailsView extends TitleBarLayout implements f, us.pinguo.foundation.p.b {

    /* renamed from: i  reason: collision with root package name */
    private b f9682i;

    /* renamed from: j  reason: collision with root package name */
    private Context f9683j;

    /* renamed from: k  reason: collision with root package name */
    private Animation f9684k;

    /* renamed from: l  reason: collision with root package name */
    private Animation f9685l;
    private i m;
    private j n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends us.pinguo.foundation.ui.b {
        a() {
        }

        @Override // us.pinguo.foundation.ui.b, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            TopicDetailsView.this.setVisibility(4);
            TopicDetailsView.this.m.p();
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends d {
        private RecyclerView a;
        private TitleBarLayout b;
        private DetailsLoadView c;

        /* renamed from: d  reason: collision with root package name */
        private int f9686d;

        /* renamed from: e  reason: collision with root package name */
        private TopicDetailsView f9687e;

        /* loaded from: classes4.dex */
        class a implements TitleBarLayout.a {
            a() {
            }

            @Override // com.pinguo.camera360.ui.TitleBarLayout.a
            public void onLeftBtnClick(View view) {
                if (b.this.f9687e.m != null) {
                    b.this.f9687e.m.o(view);
                }
            }

            @Override // com.pinguo.camera360.ui.TitleBarLayout.a
            public void onRightBtnClick(View view) {
            }
        }

        /* renamed from: us.pinguo.camera360.shop.details.TopicDetailsView$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        class C0372b extends RecyclerView.ItemDecoration {
            private int a;
            private int b;

            public C0372b(b bVar, int i2, int i3) {
                this.a = i2;
                this.b = i3;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                int viewLayoutPosition = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
                if (viewLayoutPosition == 0) {
                    rect.set(0, 0, 0, this.a);
                    return;
                }
                int i2 = viewLayoutPosition % this.b;
                if (i2 == 1) {
                    int i3 = this.a;
                    rect.set(i3 * 3, i3, i3, i3);
                } else if (i2 == 0) {
                    int i4 = this.a;
                    rect.set(i4, i4, i4 * 3, i4);
                } else {
                    int i5 = this.a;
                    rect.set(i5 * 2, i5, i5 * 2, i5);
                }
            }
        }

        public b(View view) {
            super(view);
            this.f9686d = view.getContext().getResources().getDimensionPixelSize(R.dimen.store_topic_details_item_gap);
            this.f9687e = (TopicDetailsView) view;
            TitleBarLayout titleBarLayout = (TitleBarLayout) view;
            this.b = titleBarLayout;
            titleBarLayout.setLeftImageBtnRes(R.drawable.store_details_back);
            this.b.setOnTitleBarClickListener(new a());
            this.c = (DetailsLoadView) view.findViewById(R.id.store_details_dlv);
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.store_topic_details_panel_rv);
            this.a = recyclerView;
            recyclerView.setHasFixedSize(true);
        }

        public DetailsLoadView c() {
            return this.c;
        }

        public void d() {
            this.b = null;
            this.f9687e = null;
        }

        public void e(RecyclerView.Adapter adapter, GridLayoutManager gridLayoutManager) {
            this.a.setLayoutManager(gridLayoutManager);
            this.a.setAdapter(adapter);
            this.a.addItemDecoration(new C0372b(this, this.f9686d, gridLayoutManager.getSpanCount()));
        }

        public void f(String str) {
            this.b.setTiTleText(str);
        }
    }

    public TopicDetailsView(Context context) {
        super(context);
        this.f9683j = getContext();
        setClickable(true);
    }

    private void t() {
        this.f9684k = AnimationUtils.loadAnimation(this.f9683j, R.anim.store_details_view_from_right);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f9683j, R.anim.store_details_view_gone_right);
        this.f9685l = loadAnimation;
        loadAnimation.setAnimationListener(new a());
    }

    private void u(View view, boolean z) {
        j jVar = this.n;
        if (jVar == null) {
            return;
        }
        jVar.q(view, z);
    }

    @Override // us.pinguo.camera360.shop.details.f
    public void a() {
        if (this.f9684k.hasStarted()) {
            this.f9684k.cancel();
        }
        setVisibility(0);
        startAnimation(this.f9684k);
    }

    @Override // us.pinguo.camera360.shop.details.f
    public d b() {
        return this.f9682i;
    }

    @Override // us.pinguo.camera360.shop.details.f
    public boolean isShowing() {
        return getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.ui.TitleBarLayout, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f9682i = new b(this);
        t();
    }

    public void s() {
        if (this.f9685l.hasStarted()) {
            this.f9685l.cancel();
        }
        startAnimation(this.f9685l);
    }

    public void setPresenter(e eVar) {
        this.m = (i) eVar;
    }

    public void setVisiableListener(j jVar) {
        this.n = jVar;
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        VdsAgent.onSetViewVisibility(this, i2);
        u(this, i2 == 0);
    }

    public void w() {
        u(this, false);
    }

    public void x() {
        u(this, isShowing());
    }

    public TopicDetailsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9683j = getContext();
        setClickable(true);
    }

    public TopicDetailsView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f9683j = getContext();
        setClickable(true);
    }
}

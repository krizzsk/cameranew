package us.pinguo.ui.widget.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.SpinnerAdapter;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import us.pinguo.ui.R;
import us.pinguo.ui.widget.banner.ScrollGallery;
/* loaded from: classes6.dex */
public class BannerView extends RelativeLayout implements AdapterView.OnItemSelectedListener {
    private ScrollGallery a;
    private View b;
    private DrawableIndicator c;

    /* renamed from: d  reason: collision with root package name */
    private b f12248d;

    /* renamed from: e  reason: collision with root package name */
    private AdapterView.OnItemClickListener f12249e;

    /* renamed from: f  reason: collision with root package name */
    private AdapterView.OnItemSelectedListener f12250f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f12251g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f12252h;

    public BannerView(Context context) {
        this(context, null, 0);
    }

    private void a() {
        ScrollGallery scrollGallery;
        if (isInEditMode() || (scrollGallery = this.a) == null) {
            return;
        }
        scrollGallery.setOnItemSelectedListener(this);
        this.a.setAutoScroll(this.f12251g);
    }

    public void b(boolean z) {
        this.f12252h = z;
    }

    public void c() {
        this.c.setCellCount(this.f12248d.getRealCount());
        us.pinguo.common.log.a.d("bannerview", "mAdapter.getRealCount()=" + this.f12248d.getRealCount(), new Object[0]);
        if (this.f12248d.getRealCount() > 1 && this.f12252h) {
            setIndicatorVisibility(true);
        } else {
            setIndicatorVisibility(false);
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.a = (ScrollGallery) findViewById(R.id.banner_gallery);
        this.c = (DrawableIndicator) findViewById(R.id.banner_indicator);
        this.b = findViewById(R.id.banner_indicator_container);
        a();
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    @Instrumented
    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
        VdsAgent.onItemSelected(this, adapterView, view, i2, j2);
        b bVar = this.f12248d;
        if (bVar == null || bVar.getCount() <= 0) {
            return;
        }
        this.c.setCurrentItem(i2 % this.f12248d.getRealCount());
        AdapterView.OnItemSelectedListener onItemSelectedListener = this.f12250f;
        if (onItemSelectedListener != null) {
            onItemSelectedListener.onItemSelected(adapterView, view, i2, j2);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
        AdapterView.OnItemSelectedListener onItemSelectedListener = this.f12250f;
        if (onItemSelectedListener != null) {
            onItemSelectedListener.onNothingSelected(adapterView);
        }
    }

    public void setAdapter(b bVar) {
        this.f12248d = bVar;
        if (bVar != null) {
            this.c.setCellCount(bVar.getRealCount());
            this.a.setAdapter((SpinnerAdapter) this.f12248d);
            if (this.f12248d.getRealCount() > 1 && this.f12252h) {
                setIndicatorVisibility(true);
            } else {
                setIndicatorVisibility(false);
            }
        }
    }

    public void setAutoScroll(boolean z) {
        this.f12251g = z;
        ScrollGallery scrollGallery = this.a;
        if (scrollGallery != null) {
            scrollGallery.setAutoScroll(z);
        }
    }

    public void setBannerIndex(int i2) {
        int realCount;
        if (this.a == null || (realCount = this.f12248d.getRealCount()) <= 1) {
            return;
        }
        this.a.setSelection(i2 % realCount);
    }

    public void setIndicatorVisibility(boolean z) {
        if (z) {
            DrawableIndicator drawableIndicator = this.c;
            drawableIndicator.setVisibility(0);
            VdsAgent.onSetViewVisibility(drawableIndicator, 0);
            View view = this.b;
            view.setVisibility(0);
            VdsAgent.onSetViewVisibility(view, 0);
            return;
        }
        DrawableIndicator drawableIndicator2 = this.c;
        drawableIndicator2.setVisibility(8);
        VdsAgent.onSetViewVisibility(drawableIndicator2, 8);
        View view2 = this.b;
        view2.setVisibility(8);
        VdsAgent.onSetViewVisibility(view2, 8);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.f12249e = onItemClickListener;
        ScrollGallery scrollGallery = this.a;
        if (scrollGallery != null) {
            scrollGallery.setOnItemClickListener(onItemClickListener);
        }
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.f12250f = onItemSelectedListener;
    }

    public void setOnLongPressListener(ScrollGallery.c cVar) {
        this.a.setOnLongPressListener(cVar);
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BannerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12252h = true;
    }
}

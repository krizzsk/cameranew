package us.pinguo.commonui.b;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.Converters;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import us.pinguo.commonui.R;
import us.pinguo.ui.widget.LanFitTextView;
/* compiled from: ItemStyleMakeupNoneBindingImpl.java */
/* loaded from: classes4.dex */
public class f extends e {
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f10077g = null;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f10078h = null;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final LinearLayout f10079d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final LanFitTextView f10080e;

    /* renamed from: f  reason: collision with root package name */
    private long f10081f;

    public f(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f10077g, f10078h));
    }

    private boolean b(ObservableBoolean observableBoolean, int i2) {
        if (i2 == us.pinguo.commonui.a.a) {
            synchronized (this) {
                this.f10081f |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // us.pinguo.commonui.b.e
    public void a(@Nullable ObservableBoolean observableBoolean) {
        updateRegistration(0, observableBoolean);
        this.c = observableBoolean;
        synchronized (this) {
            this.f10081f |= 1;
        }
        notifyPropertyChanged(us.pinguo.commonui.a.b);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j2;
        int i2;
        int i3;
        long j3;
        long j4;
        synchronized (this) {
            j2 = this.f10081f;
            this.f10081f = 0L;
        }
        Drawable drawable = null;
        ObservableBoolean observableBoolean = this.c;
        int i4 = 0;
        int i5 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i5 != 0) {
            boolean z = observableBoolean != null ? observableBoolean.get() : false;
            if (i5 != 0) {
                if (z) {
                    j3 = j2 | 8 | 32 | 128;
                    j4 = 512;
                } else {
                    j3 = j2 | 4 | 16 | 64;
                    j4 = 256;
                }
                j2 = j3 | j4;
            }
            drawable = AppCompatResources.getDrawable(this.b.getContext(), z ? R.drawable.ic_background_white : R.drawable.ic_background_null);
            int colorFromResource = ViewDataBinding.getColorFromResource(this.f10080e, z ? R.color.white : R.color.beauty_text_color_dark);
            int colorFromResource2 = ViewDataBinding.getColorFromResource(this.a, z ? R.color.color_camera_theme_dark : R.color.beauty_text_color_dark_not_select);
            i3 = colorFromResource;
            i2 = ViewDataBinding.getColorFromResource(this.f10080e, z ? R.color.color_camera_theme_black : R.color.beauty_text_color_dark_not_select);
            i4 = colorFromResource2;
        } else {
            i2 = 0;
            i3 = 0;
        }
        if ((j2 & 3) != 0) {
            ViewBindingAdapter.setBackground(this.a, Converters.convertColorToDrawable(i4));
            ImageViewBindingAdapter.setImageDrawable(this.b, drawable);
            ViewBindingAdapter.setBackground(this.f10080e, Converters.convertColorToDrawable(i2));
            this.f10080e.setTextColor(i3);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10081f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10081f = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return b((ObservableBoolean) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (us.pinguo.commonui.a.b == i2) {
            a((ObservableBoolean) obj);
            return true;
        }
        return false;
    }

    private f(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (FrameLayout) objArr[1], (ImageView) objArr[2]);
        this.f10081f = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f10079d = linearLayout;
        linearLayout.setTag(null);
        LanFitTextView lanFitTextView = (LanFitTextView) objArr[3];
        this.f10080e = lanFitTextView;
        lanFitTextView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}

package us.pinguo.edit2020.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import us.pinguo.edit2020.widget.adjust.AdjustTextSelectView;
import us.pinguo.edit2020.widget.adjust.PaintEraserAdjustLayout2;
import us.pinguo.ui.widget.StickySeekBar;
/* compiled from: LayoutAdjustPaintStyleBinding.java */
/* loaded from: classes4.dex */
public abstract class o extends ViewDataBinding {
    @NonNull
    public final PaintEraserAdjustLayout2 a;
    @NonNull
    public final FrameLayout b;
    @NonNull
    public final ImageView c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f10502d;
    @Bindable

    /* renamed from: e  reason: collision with root package name */
    protected ObservableBoolean f10503e;
    @Bindable

    /* renamed from: f  reason: collision with root package name */
    protected ObservableBoolean f10504f;

    /* JADX INFO: Access modifiers changed from: protected */
    public o(Object obj, View view, int i2, PaintEraserAdjustLayout2 paintEraserAdjustLayout2, ConstraintLayout constraintLayout, FrameLayout frameLayout, LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, LinearLayout linearLayout2, LinearLayout linearLayout3, RecyclerView recyclerView, StickySeekBar stickySeekBar, AdjustTextSelectView adjustTextSelectView) {
        super(obj, view, i2);
        this.a = paintEraserAdjustLayout2;
        this.b = frameLayout;
        this.c = imageView3;
        this.f10502d = imageView5;
    }

    public abstract void a(@Nullable ObservableBoolean observableBoolean);

    public abstract void b(@Nullable ObservableBoolean observableBoolean);
}

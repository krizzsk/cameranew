package us.pinguo.edit2020.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import us.pinguo.edit2020.widget.adjust.PaintEraserAdjustLayout;
import us.pinguo.ui.widget.AutofitTextView;
import us.pinguo.ui.widget.StickySeekBar;
/* compiled from: LayoutAdjustPaintBinding.java */
/* loaded from: classes4.dex */
public abstract class m extends ViewDataBinding {
    @NonNull
    public final PaintEraserAdjustLayout a;
    @NonNull
    public final ImageView b;
    @NonNull
    public final ImageView c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f10494d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final View f10495e;
    @Bindable

    /* renamed from: f  reason: collision with root package name */
    protected ObservableInt f10496f;
    @Bindable

    /* renamed from: g  reason: collision with root package name */
    protected ObservableBoolean f10497g;
    @Bindable

    /* renamed from: h  reason: collision with root package name */
    protected ObservableBoolean f10498h;

    /* JADX INFO: Access modifiers changed from: protected */
    public m(Object obj, View view, int i2, PaintEraserAdjustLayout paintEraserAdjustLayout, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, RecyclerView recyclerView, StickySeekBar stickySeekBar, TextView textView, TextView textView2, AutofitTextView autofitTextView, View view2) {
        super(obj, view, i2);
        this.a = paintEraserAdjustLayout;
        this.b = imageView3;
        this.c = imageView5;
        this.f10494d = linearLayout3;
        this.f10495e = view2;
    }

    public abstract void a(@Nullable ObservableInt observableInt);
}

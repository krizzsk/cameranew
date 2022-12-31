package us.pinguo.camera2020.f;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import us.pinguo.repository2020.entity.BeautyData;
import us.pinguo.ui.widget.AutofitTextView;
import us.pinguo.ui.widget.StickySeekBar;
/* compiled from: PanelMakeupSelectorBinding.java */
/* loaded from: classes2.dex */
public abstract class g extends ViewDataBinding {
    @NonNull
    public final FrameLayout a;
    @NonNull
    public final FrameLayout b;
    @NonNull
    public final AppCompatImageView c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final AppCompatImageView f9162d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final AppCompatImageView f9163e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final AppCompatImageView f9164f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final ConstraintLayout f9165g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final StickySeekBar f9166h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final View f9167i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final TextView f9168j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final TextView f9169k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public final TextView f9170l;
    @NonNull
    public final AutofitTextView m;
    @NonNull
    public final TextView n;
    @NonNull
    public final View o;
    @NonNull
    public final View p;
    @Bindable
    protected BeautyData q;
    @Bindable
    protected ObservableInt r;
    @Bindable
    protected ObservableBoolean s;
    @Bindable
    protected ObservableBoolean t;
    @Bindable
    protected ObservableBoolean u;
    @Bindable
    protected ObservableBoolean v;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Object obj, View view, int i2, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, FrameLayout frameLayout, FrameLayout frameLayout2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, LinearLayout linearLayout, LinearLayout linearLayout2, ConstraintLayout constraintLayout3, RecyclerView recyclerView, RecyclerView recyclerView2, RecyclerView recyclerView3, RecyclerView recyclerView4, StickySeekBar stickySeekBar, View view2, TextView textView, TextView textView2, TextView textView3, AutofitTextView autofitTextView, TextView textView4, View view3, View view4) {
        super(obj, view, i2);
        this.a = frameLayout;
        this.b = frameLayout2;
        this.c = appCompatImageView;
        this.f9162d = appCompatImageView2;
        this.f9163e = appCompatImageView3;
        this.f9164f = appCompatImageView4;
        this.f9165g = constraintLayout3;
        this.f9166h = stickySeekBar;
        this.f9167i = view2;
        this.f9168j = textView;
        this.f9169k = textView2;
        this.f9170l = textView3;
        this.m = autofitTextView;
        this.n = textView4;
        this.o = view3;
        this.p = view4;
    }

    @Nullable
    public ObservableBoolean a() {
        return this.u;
    }

    public abstract void b(@Nullable ObservableInt observableInt);

    public abstract void c(@Nullable BeautyData beautyData);

    public abstract void f(@Nullable ObservableBoolean observableBoolean);

    public abstract void g(@Nullable ObservableBoolean observableBoolean);

    public abstract void h(@Nullable ObservableBoolean observableBoolean);

    public abstract void j(@Nullable ObservableBoolean observableBoolean);
}

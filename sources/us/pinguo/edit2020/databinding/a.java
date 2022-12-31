package us.pinguo.edit2020.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import us.pinguo.edit2020.view.CircleImageView;
import us.pinguo.repository2020.entity.BackgroundBlur;
import us.pinguo.ui.widget.AutofitTextView;
/* compiled from: ItemBackgroundBlurLensBinding.java */
/* loaded from: classes4.dex */
public abstract class a extends ViewDataBinding {
    @NonNull
    public final CircleImageView a;
    @NonNull
    public final AutofitTextView b;
    @NonNull
    public final AppCompatImageView c;
    @Bindable

    /* renamed from: d  reason: collision with root package name */
    protected BackgroundBlur f10455d;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Object obj, View view, int i2, CircleImageView circleImageView, AutofitTextView autofitTextView, AppCompatImageView appCompatImageView) {
        super(obj, view, i2);
        this.a = circleImageView;
        this.b = autofitTextView;
        this.c = appCompatImageView;
    }

    public abstract void a(@Nullable BackgroundBlur backgroundBlur);
}

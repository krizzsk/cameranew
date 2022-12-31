package us.pinguo.camera2020.f;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.switchmaterial.SwitchMaterial;
import us.pinguo.repository2020.entity.BeautyData;
import us.pinguo.ui.widget.AutofitTextView;
/* compiled from: ItemMakeupBinding.java */
/* loaded from: classes2.dex */
public abstract class c extends ViewDataBinding {
    @NonNull
    public final AppCompatImageView a;
    @NonNull
    public final AppCompatImageView b;
    @NonNull
    public final SwitchMaterial c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final AutofitTextView f9150d;
    @Bindable

    /* renamed from: e  reason: collision with root package name */
    protected BeautyData f9151e;
    @Bindable

    /* renamed from: f  reason: collision with root package name */
    protected ObservableBoolean f9152f;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Object obj, View view, int i2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, LinearLayout linearLayout, SwitchMaterial switchMaterial, AutofitTextView autofitTextView) {
        super(obj, view, i2);
        this.a = appCompatImageView;
        this.b = appCompatImageView2;
        this.c = switchMaterial;
        this.f9150d = autofitTextView;
    }

    public abstract void a(@Nullable BeautyData beautyData);

    public abstract void b(@Nullable ObservableBoolean observableBoolean);
}

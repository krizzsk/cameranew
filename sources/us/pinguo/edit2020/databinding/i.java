package us.pinguo.edit2020.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import us.pinguo.edit2020.widget.CollectAnimImageView;
import us.pinguo.repository2020.entity.Material;
import us.pinguo.ui.widget.AutofitTextView;
/* compiled from: ItemMaterialTemplateBinding.java */
/* loaded from: classes4.dex */
public abstract class i extends ViewDataBinding {
    @NonNull
    public final CollectAnimImageView a;
    @NonNull
    public final SimpleDraweeView b;
    @NonNull
    public final AutofitTextView c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final AppCompatImageView f10477d;
    @Bindable

    /* renamed from: e  reason: collision with root package name */
    protected Material f10478e;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(Object obj, View view, int i2, CollectAnimImageView collectAnimImageView, SimpleDraweeView simpleDraweeView, AutofitTextView autofitTextView, AppCompatImageView appCompatImageView) {
        super(obj, view, i2);
        this.a = collectAnimImageView;
        this.b = simpleDraweeView;
        this.c = autofitTextView;
        this.f10477d = appCompatImageView;
    }

    public abstract void a(@Nullable Material material);
}

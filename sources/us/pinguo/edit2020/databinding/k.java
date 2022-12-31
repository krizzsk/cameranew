package us.pinguo.edit2020.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import us.pinguo.repository2020.entity.Material;
import us.pinguo.ui.widget.AutofitTextView;
/* compiled from: ItemPaintMaterialBinding.java */
/* loaded from: classes4.dex */
public abstract class k extends ViewDataBinding {
    @NonNull
    public final SimpleDraweeView a;
    @NonNull
    public final AutofitTextView b;
    @NonNull
    public final AppCompatImageView c;
    @Bindable

    /* renamed from: d  reason: collision with root package name */
    protected Material f10486d;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(Object obj, View view, int i2, SimpleDraweeView simpleDraweeView, AutofitTextView autofitTextView, AppCompatImageView appCompatImageView) {
        super(obj, view, i2);
        this.a = simpleDraweeView;
        this.b = autofitTextView;
        this.c = appCompatImageView;
    }

    public abstract void a(@Nullable Material material);
}

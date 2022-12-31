package us.pinguo.edit2020.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import us.pinguo.repository2020.entity.Material;
/* compiled from: ItemMaterialCategoryBinding.java */
/* loaded from: classes4.dex */
public abstract class g extends ViewDataBinding {
    @NonNull
    public final SimpleDraweeView a;
    @Bindable
    protected Material b;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Object obj, View view, int i2, SimpleDraweeView simpleDraweeView) {
        super(obj, view, i2);
        this.a = simpleDraweeView;
    }

    public abstract void a(@Nullable Material material);

    public abstract void b(@Nullable Integer num);
}

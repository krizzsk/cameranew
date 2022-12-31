package us.pinguo.edit2020.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import us.pinguo.repository2020.entity.Material;
import us.pinguo.ui.widget.AutofitTextView;
/* compiled from: ItemMaterialBinding.java */
/* loaded from: classes4.dex */
public abstract class e extends ViewDataBinding {
    @NonNull
    public final SimpleDraweeView a;
    @NonNull
    public final AutofitTextView b;
    @Bindable
    protected Material c;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(Object obj, View view, int i2, SimpleDraweeView simpleDraweeView, AutofitTextView autofitTextView) {
        super(obj, view, i2);
        this.a = simpleDraweeView;
        this.b = autofitTextView;
    }

    public abstract void a(@Nullable Material material);
}

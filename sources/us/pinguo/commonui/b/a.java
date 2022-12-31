package us.pinguo.commonui.b;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import us.pinguo.repository2020.entity.SelfDefMakeupMaterial;
import us.pinguo.ui.widget.AutofitTextView;
/* compiled from: ItemSelfdefMakeupBinding.java */
/* loaded from: classes4.dex */
public abstract class a extends ViewDataBinding {
    @NonNull
    public final SimpleDraweeView a;
    @NonNull
    public final AutofitTextView b;
    @NonNull
    public final AppCompatImageView c;
    @Bindable

    /* renamed from: d  reason: collision with root package name */
    protected Boolean f10059d;
    @Bindable

    /* renamed from: e  reason: collision with root package name */
    protected SelfDefMakeupMaterial f10060e;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Object obj, View view, int i2, SimpleDraweeView simpleDraweeView, AutofitTextView autofitTextView, AppCompatImageView appCompatImageView) {
        super(obj, view, i2);
        this.a = simpleDraweeView;
        this.b = autofitTextView;
        this.c = appCompatImageView;
    }

    public abstract void a(@Nullable Boolean bool);

    public abstract void b(@Nullable SelfDefMakeupMaterial selfDefMakeupMaterial);
}

package us.pinguo.camera2020.view.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import androidx.fragment.app.DialogFragment;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.common.widget.FunctionItemAnimDraweeView;
import us.pinguo.commonui.R;
/* compiled from: HomeAdvDialog.kt */
/* loaded from: classes3.dex */
public final class HomeAdvDialog extends DialogFragment {
    private FunctionItemAnimDraweeView b;

    /* renamed from: e  reason: collision with root package name */
    private kotlin.jvm.b.a<u> f9384e;

    /* renamed from: f  reason: collision with root package name */
    private kotlin.jvm.b.a<u> f9385f;

    /* renamed from: g  reason: collision with root package name */
    private kotlin.jvm.b.a<u> f9386g;

    /* renamed from: h  reason: collision with root package name */
    private View f9387h;

    /* renamed from: i  reason: collision with root package name */
    private View f9388i;

    /* renamed from: j  reason: collision with root package name */
    private View f9389j;

    /* renamed from: k  reason: collision with root package name */
    private View f9390k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f9391l;
    public Map<Integer, View> a = new LinkedHashMap();
    private int c = -1;

    /* renamed from: d  reason: collision with root package name */
    private String f9383d = "";

    /* compiled from: HomeAdvDialog.kt */
    /* loaded from: classes3.dex */
    public static final class a extends us.pinguo.foundation.ui.b {
        a() {
        }

        @Override // us.pinguo.foundation.ui.b, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            HomeAdvDialog.this.f9391l = false;
            Dialog dialog = HomeAdvDialog.this.getDialog();
            if (dialog != null) {
                HomeAdvDialog.this.onCancel(dialog);
            }
            HomeAdvDialog.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(HomeAdvDialog this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        kotlin.jvm.b.a<u> aVar = this$0.f9384e;
        if (aVar == null) {
            return;
        }
        aVar.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(View view) {
        VdsAgent.lambdaOnClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(HomeAdvDialog this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        kotlin.jvm.b.a<u> aVar = this$0.f9385f;
        if (aVar != null) {
            aVar.invoke();
        }
        this$0.s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(HomeAdvDialog this$0, DialogInterface dialogInterface) {
        s.h(this$0, "this$0");
        kotlin.jvm.b.a<u> aVar = this$0.f9385f;
        if (aVar == null) {
            return;
        }
        aVar.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m0(HomeAdvDialog this$0, DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
        s.h(this$0, "this$0");
        if (i2 == 4) {
            this$0.s0();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(HomeAdvDialog this$0, DialogInterface dialogInterface) {
        s.h(this$0, "this$0");
        kotlin.jvm.b.a<u> aVar = this$0.f9386g;
        if (aVar == null) {
            return;
        }
        aVar.invoke();
    }

    private final void r0() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        View view = this.f9387h;
        if (view != null) {
            view.startAnimation(alphaAnimation);
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, -1.0f, 2, 0.0f);
            translateAnimation.setDuration(600L);
            translateAnimation.setInterpolator(new OvershootInterpolator());
            View view2 = this.f9389j;
            if (view2 != null) {
                view2.startAnimation(translateAnimation);
                return;
            } else {
                s.z("contentContainer");
                throw null;
            }
        }
        s.z("backView");
        throw null;
    }

    private final void s0() {
        if (this.f9391l) {
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(900L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        View view = this.f9387h;
        if (view != null) {
            view.startAnimation(alphaAnimation);
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, 1.0f);
            translateAnimation.setDuration(900L);
            translateAnimation.setInterpolator(new OvershootInterpolator());
            translateAnimation.setAnimationListener(new a());
            View view2 = this.f9389j;
            if (view2 != null) {
                view2.startAnimation(translateAnimation);
                this.f9391l = true;
                return;
            }
            s.z("contentContainer");
            throw null;
        }
        s.z("backView");
        throw null;
    }

    public void _$_clearFindViewByIdCache() {
        this.a.clear();
    }

    public final boolean b0() {
        return isAdded();
    }

    public final void o0(String imageFilePath) {
        s.h(imageFilePath, "imageFilePath");
        this.f9383d = imageFilePath;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        FunctionItemAnimDraweeView functionItemAnimDraweeView;
        Window window;
        s.h(inflater, "inflater");
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.requestWindowFeature(1);
        }
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        View inflate = inflater.inflate(R.layout.home_adv_dialog_layout, viewGroup);
        View findViewById = inflate.findViewById(R.id.backView);
        s.g(findViewById, "view.findViewById(R.id.backView)");
        this.f9387h = findViewById;
        View findViewById2 = inflate.findViewById(R.id.imageContainer);
        s.g(findViewById2, "view.findViewById(R.id.imageContainer)");
        this.f9388i = findViewById2;
        View findViewById3 = inflate.findViewById(R.id.contentContainer);
        s.g(findViewById3, "view.findViewById(R.id.contentContainer)");
        this.f9389j = findViewById3;
        this.b = (FunctionItemAnimDraweeView) inflate.findViewById(R.id.imageView);
        View findViewById4 = inflate.findViewById(R.id.exit);
        s.g(findViewById4, "view.findViewById(R.id.exit)");
        this.f9390k = findViewById4;
        if (this.f9383d.length() > 0) {
            FunctionItemAnimDraweeView functionItemAnimDraweeView2 = this.b;
            if (functionItemAnimDraweeView2 != null) {
                functionItemAnimDraweeView2.setImagePath(this.f9383d);
            }
        } else {
            int i2 = this.c;
            if (i2 != -1 && (functionItemAnimDraweeView = this.b) != null) {
                functionItemAnimDraweeView.setImagePath(Integer.valueOf(i2));
            }
        }
        FunctionItemAnimDraweeView functionItemAnimDraweeView3 = this.b;
        if (functionItemAnimDraweeView3 != null) {
            functionItemAnimDraweeView3.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera2020.view.dialog.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeAdvDialog.i0(HomeAdvDialog.this, view);
                }
            });
        }
        View view = this.f9389j;
        if (view != null) {
            view.setOnClickListener(c.a);
            View view2 = this.f9390k;
            if (view2 != null) {
                view2.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera2020.view.dialog.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        HomeAdvDialog.k0(HomeAdvDialog.this, view3);
                    }
                });
                if (dialog != null) {
                    dialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: us.pinguo.camera2020.view.dialog.f
                        @Override // android.content.DialogInterface.OnCancelListener
                        public final void onCancel(DialogInterface dialogInterface) {
                            HomeAdvDialog.l0(HomeAdvDialog.this, dialogInterface);
                        }
                    });
                    dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: us.pinguo.camera2020.view.dialog.d
                        @Override // android.content.DialogInterface.OnKeyListener
                        public final boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
                            boolean m0;
                            m0 = HomeAdvDialog.m0(HomeAdvDialog.this, dialogInterface, i3, keyEvent);
                            return m0;
                        }
                    });
                    dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: us.pinguo.camera2020.view.dialog.a
                        @Override // android.content.DialogInterface.OnDismissListener
                        public final void onDismiss(DialogInterface dialogInterface) {
                            HomeAdvDialog.n0(HomeAdvDialog.this, dialogInterface);
                        }
                    });
                }
                r0();
                return inflate;
            }
            s.z("exitView");
            throw null;
        }
        s.z("contentContainer");
        throw null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final void p0(kotlin.jvm.b.a<u> function0) {
        s.h(function0, "function0");
        this.f9385f = function0;
    }

    public final void q0(kotlin.jvm.b.a<u> function0) {
        s.h(function0, "function0");
        this.f9384e = function0;
    }
}

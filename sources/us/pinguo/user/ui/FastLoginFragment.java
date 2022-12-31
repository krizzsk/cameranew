package us.pinguo.user.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.huawei.HuaweiAgent;
import java.util.Locale;
import us.pinguo.foundation.base.SubscriptionFragment;
import us.pinguo.user.R;
import us.pinguo.user.User;
import us.pinguo.user.v0;
/* loaded from: classes6.dex */
public class FastLoginFragment extends SubscriptionFragment implements View.OnClickListener, o0 {
    private View a;
    private View b;
    private View c;

    /* renamed from: d  reason: collision with root package name */
    private View f12392d;

    /* renamed from: e  reason: collision with root package name */
    private View f12393e;

    /* renamed from: f  reason: collision with root package name */
    private n0 f12394f;

    private void switchByLocal() {
        if (us.pinguo.foundation.utils.z.b(Locale.getDefault())) {
            View view = this.c;
            view.setVisibility(8);
            VdsAgent.onSetViewVisibility(view, 8);
            View view2 = this.f12392d;
            view2.setVisibility(8);
            VdsAgent.onSetViewVisibility(view2, 8);
            View view3 = this.a;
            view3.setVisibility(0);
            VdsAgent.onSetViewVisibility(view3, 0);
            View view4 = this.b;
            view4.setVisibility(0);
            VdsAgent.onSetViewVisibility(view4, 0);
            if (HuaweiAgent.isHuaweiSupport() && HuaweiAgent.isHuaweiPhone()) {
                View view5 = this.f12393e;
                view5.setVisibility(0);
                VdsAgent.onSetViewVisibility(view5, 0);
                return;
            }
            return;
        }
        View view6 = this.a;
        view6.setVisibility(8);
        VdsAgent.onSetViewVisibility(view6, 8);
        View view7 = this.b;
        view7.setVisibility(8);
        VdsAgent.onSetViewVisibility(view7, 8);
        View view8 = this.f12393e;
        view8.setVisibility(8);
        VdsAgent.onSetViewVisibility(view8, 8);
        View view9 = this.c;
        view9.setVisibility(0);
        VdsAgent.onSetViewVisibility(view9, 0);
        View view10 = this.f12392d;
        view10.setVisibility(0);
        VdsAgent.onSetViewVisibility(view10, 0);
    }

    @Override // us.pinguo.user.ui.o0
    public void dismiss() {
    }

    @Override // androidx.fragment.app.Fragment, us.pinguo.inspire.module.comment.IFeedsInfoView
    @Nullable
    public /* bridge */ /* synthetic */ Activity getActivity() {
        return super.getActivity();
    }

    @Override // us.pinguo.user.ui.o0
    public View getDecorView() {
        return getActivity().getWindow().getDecorView();
    }

    @Override // us.pinguo.user.ui.o0
    public Fragment getFragment() {
        return this;
    }

    @Override // us.pinguo.foundation.base.BaseFragment
    protected String getPageId() {
        return "fast_login_page";
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        this.f12394f.A(i2, i3, intent);
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1006) {
            if (i3 == -1) {
                v0.i(0, 1006);
            } else {
                User.s();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        if (view.getId() == R.id.child_fast_login_wx_btn) {
            this.f12394f.G();
        } else if (view.getId() == R.id.child_fast_login_wb_btn) {
            this.f12394f.F();
        } else if (view.getId() == R.id.child_fast_login_fb_btn) {
            this.f12394f.C();
        } else if (view.getId() == R.id.child_fast_login_tw_btn) {
            this.f12394f.E();
        } else if (view.getId() == R.id.child_fast_login_c360_btn) {
            this.f12394f.B();
        } else if (view.getId() == R.id.child_fast_login_huawei_btn) {
            this.f12394f.D();
        }
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        us.pinguo.foundation.statistics.l.onEvent(getActivity(), "fast_login_page");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fast_login_fragment, viewGroup, false);
        this.a = inflate.findViewById(R.id.fast_login_wx_btn);
        this.b = inflate.findViewById(R.id.fast_login_wb_btn);
        this.c = inflate.findViewById(R.id.fast_login_fb_btn);
        this.f12392d = inflate.findViewById(R.id.fast_login_tw_btn);
        this.f12393e = inflate.findViewById(R.id.fast_login_huawei_btn);
        inflate.findViewById(R.id.fast_login_c360_btn).setOnClickListener(this);
        this.a.setOnClickListener(this);
        this.b.setOnClickListener(this);
        this.c.setOnClickListener(this);
        this.f12392d.setOnClickListener(this);
        this.f12393e.setOnClickListener(this);
        switchByLocal();
        return inflate;
    }

    @Override // us.pinguo.foundation.base.SubscriptionFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        n0 n0Var = this.f12394f;
        if (n0Var != null) {
            n0Var.detachView();
        }
    }

    @Override // us.pinguo.foundation.base.BaseFragment
    protected void onPageShow() {
        us.pinguo.foundation.statistics.l.onEvent(getActivity(), "fast_login_page", us.pinguo.util.p.e() ? "china" : us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER);
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        n0 n0Var = new n0();
        this.f12394f = n0Var;
        n0Var.attachView(this);
    }

    @Override // us.pinguo.user.ui.o0
    public void phoneBind() {
        Intent intent = new Intent();
        intent.setClassName(us.pinguo.util.v.a(), "us.pinguo.inspire.PhoneBindActivity");
        startActivityForResult(intent, 1006);
    }
}

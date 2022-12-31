package vStudio.Android.Camera360.guide;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import vStudio.Android.Camera360.R;
import vStudio.Android.Camera360.a;
/* loaded from: classes7.dex */
public class GuidePicFilmFragment extends GuideFragment implements View.OnClickListener {

    /* renamed from: d  reason: collision with root package name */
    View f12606d;

    /* renamed from: e  reason: collision with root package name */
    View f12607e;

    /* renamed from: g  reason: collision with root package name */
    private View f12609g;
    private boolean c = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f12608f = false;

    @Override // vStudio.Android.Camera360.guide.GuideFragment
    public void b0() {
        this.c = false;
        if (!this.f12608f && !this.a) {
            View view = this.f12607e;
            if (view == null || this.f12606d == null) {
                return;
            }
            view.setVisibility(0);
            VdsAgent.onSetViewVisibility(view, 0);
            View view2 = this.f12606d;
            view2.setVisibility(4);
            VdsAgent.onSetViewVisibility(view2, 4);
            return;
        }
        a.InterfaceC0470a interfaceC0470a = (a.InterfaceC0470a) this.b;
        if (interfaceC0470a == null) {
            return;
        }
        interfaceC0470a.n(2, null);
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        if (view.getId() != R.id.guide_vp_item_start_iv) {
            return;
        }
        if (this.c) {
            this.f12608f = true;
            View view2 = this.f12606d;
            view2.setVisibility(0);
            VdsAgent.onSetViewVisibility(view2, 0);
            View view3 = this.f12607e;
            view3.setVisibility(4);
            VdsAgent.onSetViewVisibility(view3, 4);
            return;
        }
        Activity activity = this.b;
        if (activity instanceof a.InterfaceC0470a) {
            ((a.InterfaceC0470a) activity).n(2, null);
        }
    }

    @Override // vStudio.Android.Camera360.guide.GuideFragment, us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = getActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.guide_vp_item_6_1, (ViewGroup) null);
        this.f12609g = inflate;
        this.f12606d = inflate.findViewById(R.id.guide_vp_item_progress);
        View findViewById = inflate.findViewById(R.id.guide_vp_item_start_iv);
        this.f12607e = findViewById;
        findViewById.setOnClickListener(this);
        return inflate;
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        getActivity().getWindow().clearFlags(128);
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getActivity().getWindow().addFlags(128);
        if (this.c) {
            View view = this.f12607e;
            view.setVisibility(4);
            VdsAgent.onSetViewVisibility(view, 4);
            View view2 = this.f12606d;
            view2.setVisibility(0);
            VdsAgent.onSetViewVisibility(view2, 0);
            return;
        }
        this.c = true;
        ((a.InterfaceC0470a) this.b).n(16, null);
        if (this.a) {
            View view3 = this.f12607e;
            view3.setVisibility(4);
            VdsAgent.onSetViewVisibility(view3, 4);
            View view4 = this.f12606d;
            view4.setVisibility(0);
            VdsAgent.onSetViewVisibility(view4, 0);
            return;
        }
        View view5 = this.f12607e;
        view5.setVisibility(0);
        VdsAgent.onSetViewVisibility(view5, 0);
        View view6 = this.f12606d;
        view6.setVisibility(4);
        VdsAgent.onSetViewVisibility(view6, 4);
    }
}

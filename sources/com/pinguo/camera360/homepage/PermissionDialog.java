package com.pinguo.camera360.homepage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.LinkedHashMap;
import java.util.Map;
import us.pinguo.ui.widget.AutofitTextView;
import vStudio.Android.Camera360.R;
/* compiled from: PermissionDialog.kt */
/* loaded from: classes3.dex */
public final class PermissionDialog extends DialogFragment {
    private AutofitTextView b;
    private AutofitTextView c;

    /* renamed from: d  reason: collision with root package name */
    private ViewGroup f6770d;

    /* renamed from: e  reason: collision with root package name */
    private ViewGroup f6771e;

    /* renamed from: f  reason: collision with root package name */
    private t0 f6772f;
    public Map<Integer, View> a = new LinkedHashMap();

    /* renamed from: g  reason: collision with root package name */
    private boolean f6773g = true;

    /* renamed from: h  reason: collision with root package name */
    private boolean f6774h = true;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(PermissionDialog this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(PermissionDialog this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        super.dismiss();
        t0 t0Var = this$0.f6772f;
        if (t0Var == null) {
            return;
        }
        t0Var.a();
    }

    public void _$_clearFindViewByIdCache() {
        this.a.clear();
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        super.dismiss();
        t0 t0Var = this.f6772f;
        if (t0Var == null) {
            return;
        }
        t0Var.b();
    }

    public final void e0(t0 t0Var) {
        this.f6772f = t0Var;
    }

    public final void f0(boolean z) {
        this.f6774h = z;
    }

    public final void g0(boolean z) {
        this.f6773g = z;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCancelable(false);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.s.h(inflater, "inflater");
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_permission, viewGroup, false);
        AutofitTextView autofitTextView = (AutofitTextView) inflate.findViewById(R.id.permission_next);
        kotlin.jvm.internal.s.g(autofitTextView, "root.permission_next");
        this.b = autofitTextView;
        AutofitTextView autofitTextView2 = (AutofitTextView) inflate.findViewById(R.id.permission_deny);
        kotlin.jvm.internal.s.g(autofitTextView2, "root.permission_deny");
        this.c = autofitTextView2;
        kotlin.jvm.internal.s.g((CheckBox) inflate.findViewById(R.id.check_camera), "root.check_camera");
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.layout_camera);
        kotlin.jvm.internal.s.g(linearLayout, "root.layout_camera");
        this.f6770d = linearLayout;
        kotlin.jvm.internal.s.g((CheckBox) inflate.findViewById(R.id.check_sdcard), "root.check_sdcard");
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.layout_sdcard);
        kotlin.jvm.internal.s.g(linearLayout2, "root.layout_sdcard");
        this.f6771e = linearLayout2;
        ViewGroup viewGroup2 = this.f6770d;
        if (viewGroup2 != null) {
            int i2 = this.f6774h ? 0 : 8;
            viewGroup2.setVisibility(i2);
            VdsAgent.onSetViewVisibility(viewGroup2, i2);
            ViewGroup viewGroup3 = this.f6771e;
            if (viewGroup3 != null) {
                int i3 = this.f6773g ? 0 : 8;
                viewGroup3.setVisibility(i3);
                VdsAgent.onSetViewVisibility(viewGroup3, i3);
                AutofitTextView autofitTextView3 = this.b;
                if (autofitTextView3 != null) {
                    autofitTextView3.setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.homepage.y
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            PermissionDialog.c0(PermissionDialog.this, view);
                        }
                    });
                    AutofitTextView autofitTextView4 = this.c;
                    if (autofitTextView4 != null) {
                        autofitTextView4.setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.homepage.z
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                PermissionDialog.d0(PermissionDialog.this, view);
                            }
                        });
                        return inflate;
                    }
                    kotlin.jvm.internal.s.z("btnDeny");
                    throw null;
                }
                kotlin.jvm.internal.s.z("btnNext");
                throw null;
            }
            kotlin.jvm.internal.s.z("storageLayout");
            throw null;
        }
        kotlin.jvm.internal.s.z("cameraLayout");
        throw null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(FragmentManager manager, String str) {
        kotlin.jvm.internal.s.h(manager, "manager");
        if (this.f6774h || this.f6773g) {
            super.show(manager, str);
            VdsAgent.showDialogFragment(this, manager, str);
        }
    }
}

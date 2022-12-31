package us.pinguo.edit2020.widget.dialog;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.channels.e;
import kotlinx.coroutines.channels.g;
import kotlinx.coroutines.flow.c;
import us.pinguo.common.widget.LoadingStatusEnum;
import us.pinguo.common.widget.ProgressLoadingStatusView;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.utils.FlowObserver;
import us.pinguo.edit2020.utils.d;
/* compiled from: CircleProgressWithResultDialog.kt */
/* loaded from: classes4.dex */
public final class CircleProgressWithResultDialog extends DialogFragment {
    private l<? super Boolean, u> b;
    private kotlin.jvm.b.a<u> c;

    /* renamed from: d  reason: collision with root package name */
    private int f10962d;

    /* renamed from: e  reason: collision with root package name */
    private ValueAnimator f10963e;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10966h;
    public Map<Integer, View> a = new LinkedHashMap();

    /* renamed from: f  reason: collision with root package name */
    private final e<Integer> f10964f = g.b(0, null, null, 7, null);

    /* renamed from: g  reason: collision with root package name */
    private final e<Boolean> f10965g = g.b(1, null, null, 6, null);

    private final void g0() {
        ValueAnimator valueAnimator = this.f10963e;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            valueAnimator.removeAllListeners();
            valueAnimator.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(CircleProgressWithResultDialog this$0, View view) {
        kotlin.jvm.b.a<u> aVar;
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        if (this$0.f10962d < 100 && (aVar = this$0.c) != null) {
            aVar.invoke();
        }
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0() {
        kotlinx.coroutines.l.d(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CircleProgressWithResultDialog$sendDismissMsg$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0() {
        this.f10966h = false;
        g0();
        ((TextView) _$_findCachedViewById(R.id.tvStatus)).setText(d.k(R.string.str_download_sticker_failed));
        ProgressLoadingStatusView progressLoadingStatusView = (ProgressLoadingStatusView) _$_findCachedViewById(R.id.loadingStatusView);
        if (progressLoadingStatusView == null) {
            return;
        }
        ProgressLoadingStatusView.r(progressLoadingStatusView, null, LoadingStatusEnum.Failed, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o0() {
        this.f10966h = true;
        g0();
        ((TextView) _$_findCachedViewById(R.id.tvStatus)).setText(d.k(R.string.str_download_sticker_succeed));
        ProgressLoadingStatusView progressLoadingStatusView = (ProgressLoadingStatusView) _$_findCachedViewById(R.id.loadingStatusView);
        if (progressLoadingStatusView == null) {
            return;
        }
        ProgressLoadingStatusView.r(progressLoadingStatusView, null, LoadingStatusEnum.Succeed, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p0(int i2) {
        if (i2 == 0) {
            return;
        }
        this.f10962d = i2;
        g0();
        ((ProgressLoadingStatusView) _$_findCachedViewById(R.id.loadingStatusView)).q(Float.valueOf(i2 / 100.0f), LoadingStatusEnum.Loading);
    }

    public void _$_clearFindViewByIdCache() {
        this.a.clear();
    }

    public View _$_findCachedViewById(int i2) {
        View findViewById;
        Map<Integer, View> map = this.a;
        View view = map.get(Integer.valueOf(i2));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i2)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    public final void j0(int i2) {
        kotlinx.coroutines.l.d(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CircleProgressWithResultDialog$publishProgress$1(this, i2, null), 3, null);
    }

    public final void l0(kotlin.jvm.b.a<u> aVar) {
        this.c = aVar;
    }

    public final void m0(l<? super Boolean, u> lVar) {
        this.b = lVar;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        s.g(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        onCreateDialog.requestWindowFeature(1);
        return onCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        s.h(inflater, "inflater");
        return inflater.inflate(R.layout.dialog_download_sticker, viewGroup, false);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        s.h(dialog, "dialog");
        super.onDismiss(dialog);
        l<? super Boolean, u> lVar = this.b;
        if (lVar == null) {
            return;
        }
        lVar.invoke(Boolean.valueOf(this.f10966h));
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Dialog dialog = getDialog();
        if (dialog == null) {
            return;
        }
        dialog.setCanceledOnTouchOutside(false);
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        window.setLayout(us.pinguo.common.widget.i.a.a(220), -2);
        window.setBackgroundDrawable(new ColorDrawable(0));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        s.h(view, "view");
        super.onViewCreated(view, bundle);
        int i2 = R.id.loadingStatusView;
        ((ProgressLoadingStatusView) _$_findCachedViewById(i2)).setOnSuccessAnimFinished(new CircleProgressWithResultDialog$onViewCreated$1(this));
        ((ProgressLoadingStatusView) _$_findCachedViewById(i2)).setOnFailedAnimFinished(new CircleProgressWithResultDialog$onViewCreated$2(this));
        c y = kotlinx.coroutines.flow.e.y(kotlinx.coroutines.flow.e.z(this.f10964f), new CircleProgressWithResultDialog$onViewCreated$3(this, null));
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        s.g(viewLifecycleOwner, "viewLifecycleOwner");
        new FlowObserver(viewLifecycleOwner, y, new CircleProgressWithResultDialog$onViewCreated$$inlined$observeInLifecycle$1(null));
        c y2 = kotlinx.coroutines.flow.e.y(kotlinx.coroutines.flow.e.z(this.f10965g), new CircleProgressWithResultDialog$onViewCreated$4(this, null));
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        s.g(viewLifecycleOwner2, "viewLifecycleOwner");
        new FlowObserver(viewLifecycleOwner2, y2, new CircleProgressWithResultDialog$onViewCreated$$inlined$observeInLifecycle$2(null));
        ((TextView) _$_findCachedViewById(R.id.tvCancel)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.widget.dialog.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CircleProgressWithResultDialog.i0(CircleProgressWithResultDialog.this, view2);
            }
        });
    }
}

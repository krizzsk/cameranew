package us.pinguo.foundation.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.R;
/* compiled from: SinglePermissionDialog.kt */
/* loaded from: classes4.dex */
public final class SinglePermissionDialog extends DialogFragment {
    private c a;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(SinglePermissionDialog this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(SinglePermissionDialog this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        super.dismiss();
        c cVar = this$0.a;
        if (cVar == null) {
            return;
        }
        cVar.a();
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        super.dismiss();
        c cVar = this.a;
        if (cVar == null) {
            return;
        }
        cVar.b();
    }

    public final void e0(c cVar) {
        this.a = cVar;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCancelable(false);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        s.h(inflater, "inflater");
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_permission_2, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.permission_next);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.foundation.dialog.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SinglePermissionDialog.c0(SinglePermissionDialog.this, view);
                }
            });
        }
        TextView textView2 = (TextView) inflate.findViewById(R.id.permission_deny);
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.foundation.dialog.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SinglePermissionDialog.d0(SinglePermissionDialog.this, view);
                }
            });
        }
        return inflate;
    }
}

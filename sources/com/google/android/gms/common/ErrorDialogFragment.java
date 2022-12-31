package com.google.android.gms.common;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public class ErrorDialogFragment extends DialogFragment {
    private Dialog a;
    private DialogInterface.OnCancelListener b;

    @NonNull
    public static ErrorDialogFragment a(Dialog dialog, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        ErrorDialogFragment errorDialogFragment = new ErrorDialogFragment();
        com.google.android.gms.common.internal.q.k(dialog, "Cannot display null dialog");
        Dialog dialog2 = dialog;
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        errorDialogFragment.a = dialog2;
        if (onCancelListener != null) {
            errorDialogFragment.b = onCancelListener;
        }
        return errorDialogFragment;
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        if (this.a == null) {
            setShowsDialog(false);
        }
        return this.a;
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, @Nullable String str) {
        super.show(fragmentManager, str);
        VdsAgent.showDialogFragment(this, fragmentManager, str);
    }
}

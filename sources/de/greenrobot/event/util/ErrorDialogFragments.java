package de.greenrobot.event.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
/* loaded from: classes3.dex */
public class ErrorDialogFragments {
    public static int a;
    public static Class<?> b;

    @TargetApi(11)
    /* loaded from: classes3.dex */
    public static class Honeycomb extends DialogFragment implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        @Instrumented
        public void onClick(DialogInterface dialogInterface, int i2) {
            VdsAgent.onClick(this, dialogInterface, i2);
            ErrorDialogFragments.b(dialogInterface, i2, getActivity(), getArguments());
        }

        @Override // android.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            return ErrorDialogFragments.a(getActivity(), getArguments(), this);
        }
    }

    /* loaded from: classes3.dex */
    public static class Support extends androidx.fragment.app.DialogFragment implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        @Instrumented
        public void onClick(DialogInterface dialogInterface, int i2) {
            VdsAgent.onClick(this, dialogInterface, i2);
            ErrorDialogFragments.b(dialogInterface, i2, getActivity(), getArguments());
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            return ErrorDialogFragments.a(getActivity(), getArguments(), this);
        }
    }

    public static Dialog a(Context context, Bundle bundle, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(bundle.getString("de.greenrobot.eventbus.errordialog.title"));
        builder.setMessage(bundle.getString("de.greenrobot.eventbus.errordialog.message"));
        int i2 = a;
        if (i2 != 0) {
            builder.setIcon(i2);
        }
        builder.setPositiveButton(17039370, onClickListener);
        return builder.create();
    }

    public static void b(DialogInterface dialogInterface, int i2, Activity activity, Bundle bundle) {
        Class<?> cls = b;
        if (cls == null) {
            if (!bundle.getBoolean("de.greenrobot.eventbus.errordialog.finish_after_dialog", false) || activity == null) {
                return;
            }
            activity.finish();
            return;
        }
        try {
            cls.newInstance();
            ErrorDialogManager.a.a.a();
            throw null;
        } catch (Exception e2) {
            throw new RuntimeException("Event cannot be constructed", e2);
        }
    }
}

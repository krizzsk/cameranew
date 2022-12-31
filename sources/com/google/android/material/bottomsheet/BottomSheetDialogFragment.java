package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
/* loaded from: classes2.dex */
public class BottomSheetDialogFragment extends AppCompatDialogFragment {
    private boolean a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends BottomSheetBehavior.g {
        private b() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void a(@NonNull View view, float f2) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void b(@NonNull View view, int i2) {
            if (i2 == 5) {
                BottomSheetDialogFragment.this.b0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0() {
        if (this.a) {
            super.dismissAllowingStateLoss();
        } else {
            super.dismiss();
        }
    }

    private void c0(@NonNull BottomSheetBehavior<?> bottomSheetBehavior, boolean z) {
        this.a = z;
        if (bottomSheetBehavior.C() == 5) {
            b0();
            return;
        }
        if (getDialog() instanceof BottomSheetDialog) {
            ((BottomSheetDialog) getDialog()).h();
        }
        bottomSheetBehavior.o(new b());
        bottomSheetBehavior.V(5);
    }

    private boolean d0(boolean z) {
        Dialog dialog = getDialog();
        if (dialog instanceof BottomSheetDialog) {
            BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) dialog;
            BottomSheetBehavior<FrameLayout> f2 = bottomSheetDialog.f();
            if (f2.F() && bottomSheetDialog.g()) {
                c0(f2, z);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        if (d0(false)) {
            return;
        }
        super.dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismissAllowingStateLoss() {
        if (d0(true)) {
            return;
        }
        super.dismissAllowingStateLoss();
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        return new BottomSheetDialog(getContext(), getTheme());
    }
}

package us.pinguo.user.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
/* compiled from: IFastLoginView.java */
/* loaded from: classes6.dex */
public interface o0 extends us.pinguo.foundation.p.b {
    void dismiss();

    Activity getActivity();

    Bundle getArguments();

    View getDecorView();

    Fragment getFragment();

    void phoneBind();
}

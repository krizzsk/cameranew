package us.pinguo.share.util;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import us.pinguo.share.R;
/* loaded from: classes6.dex */
public class InspirePublishDialog extends BaseShareDialog implements View.OnClickListener {
    private void j0() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        arguments.getString("key_bmpPath");
        arguments.getInt("key_type");
        arguments.getInt("key_entranceType");
    }

    @Override // us.pinguo.share.util.BaseShareDialog
    protected View inflateRootView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return layoutInflater.inflate(R.layout.inspire_publish_dialog_layout, viewGroup, false);
    }

    @Override // us.pinguo.share.util.BaseShareDialog, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        j0();
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }
}

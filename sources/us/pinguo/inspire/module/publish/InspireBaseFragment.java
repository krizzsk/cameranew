package us.pinguo.inspire.module.publish;

import android.content.Intent;
import us.pinguo.foundation.base.InspireRedirectActivity;
import us.pinguo.foundation.base.SubscriptionFragment;
/* loaded from: classes9.dex */
public class InspireBaseFragment extends SubscriptionFragment {
    public void startActivityForResult(Intent intent, us.pinguo.foundation.proxy.c cVar) {
        if (getActivity() instanceof InspireRedirectActivity) {
            ((InspireRedirectActivity) getActivity()).startActivityForResult(intent, cVar);
        }
    }
}

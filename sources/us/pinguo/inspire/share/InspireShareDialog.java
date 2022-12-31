package us.pinguo.inspire.share;

import android.view.View;
import java.util.LinkedHashMap;
import java.util.Map;
import us.pinguo.share.util.BaseShareDialog;
/* compiled from: InspireShareDialog.kt */
/* loaded from: classes9.dex */
public final class InspireShareDialog extends BaseShareDialog {

    /* renamed from: f  reason: collision with root package name */
    public Map<Integer, View> f11258f = new LinkedHashMap();

    public void _$_clearFindViewByIdCache() {
        this.f11258f.clear();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }
}

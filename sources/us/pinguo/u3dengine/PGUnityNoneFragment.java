package us.pinguo.u3dengine;

import android.view.View;
import java.util.LinkedHashMap;
import java.util.Map;
/* compiled from: PGUnityNoneFragment.kt */
/* loaded from: classes6.dex */
public abstract class PGUnityNoneFragment extends BaseUnityPlayerFragment {

    /* renamed from: d  reason: collision with root package name */
    public Map<Integer, View> f12088d = new LinkedHashMap();

    @Override // us.pinguo.u3dengine.BaseUnityPlayerFragment
    public void _$_clearFindViewByIdCache() {
        this.f12088d.clear();
    }

    @Override // us.pinguo.u3dengine.BaseUnityPlayerFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }
}

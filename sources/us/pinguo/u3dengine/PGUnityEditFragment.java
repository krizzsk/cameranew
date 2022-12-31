package us.pinguo.u3dengine;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import java.util.LinkedHashMap;
import java.util.Map;
import us.pinguo.u3dengine.api.EngineMode;
import us.pinguo.u3dengine.edit.UnityEditCaller;
/* compiled from: PGUnityEditFragment.kt */
/* loaded from: classes6.dex */
public abstract class PGUnityEditFragment extends BaseUnityPlayerFragment {

    /* renamed from: d  reason: collision with root package name */
    public Map<Integer, View> f12086d = new LinkedHashMap();

    /* renamed from: e  reason: collision with root package name */
    private boolean f12087e;

    @Override // us.pinguo.u3dengine.BaseUnityPlayerFragment
    public void _$_clearFindViewByIdCache() {
        this.f12086d.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c0(boolean z) {
        this.f12087e = z;
    }

    @Override // us.pinguo.u3dengine.BaseUnityPlayerFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // us.pinguo.u3dengine.BaseUnityPlayerFragment, androidx.fragment.app.Fragment
    public void onPause() {
        FragmentActivity activity = getActivity();
        if (activity != null && activity.isFinishing()) {
            us.pinguo.common.log.a.c("clean up unity edit", new Object[0]);
            UnityEditCaller.Common.cleanUp();
            if (this.f12087e) {
                UnityControlCaller.setEngineMode(EngineMode.CAMERA, Module.EDIT);
            } else {
                UnityControlCaller.setEngineMode(EngineMode.OFF, Module.EDIT);
            }
        }
        super.onPause();
    }
}

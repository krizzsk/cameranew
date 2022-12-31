package us.pinguo.u3dengine;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import us.pinguo.nativeinterface.UnityInterface;
import us.pinguo.u3dengine.api.EngineMode;
import us.pinguo.u3dengine.api.UnityCallbackApi;
import us.pinguo.u3dengine.api.UnityFilterCallbackApi;
import us.pinguo.u3dengine.api.UnityFilterMethodCallback;
import us.pinguo.u3dengine.api.UnityMethodCallback;
import us.pinguo.u3dengine.api.UnityMethodCaller;
/* compiled from: PGUnityCameraFragment.kt */
/* loaded from: classes6.dex */
public abstract class PGUnityCameraFragment extends BaseUnityPlayerFragment {

    /* renamed from: d  reason: collision with root package name */
    public Map<Integer, View> f12083d = new LinkedHashMap();

    /* renamed from: e  reason: collision with root package name */
    private UnityCallbackApi f12084e;

    /* renamed from: f  reason: collision with root package name */
    private UnityFilterCallbackApi f12085f;

    @Override // us.pinguo.u3dengine.BaseUnityPlayerFragment
    public void _$_clearFindViewByIdCache() {
        this.f12083d.clear();
    }

    public final void c0(UnityCallbackApi callback, UnityFilterCallbackApi filterCallback) {
        s.h(callback, "callback");
        s.h(filterCallback, "filterCallback");
        UnityMethodCallback.registerImpl(callback);
        UnityFilterMethodCallback.registerImpl(filterCallback);
        this.f12084e = callback;
        this.f12085f = filterCallback;
    }

    public final void d0(UnityInterface.c cVar) {
        BaseUnityPlayerFragment.b.a().setGLRender(cVar);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        BaseUnityPlayerFragment.b.a().clearGLRender(this.f12084e);
        UnityMethodCallback.unregister(this.f12084e);
        UnityFilterMethodCallback.unregister(this.f12085f);
        this.f12084e = null;
        this.f12085f = null;
        super.onDestroy();
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
            us.pinguo.common.log.a.c("clean up unity camera", new Object[0]);
            UnityMethodCaller.cleanUp();
            UnityControlCaller.setEngineMode(EngineMode.OFF, Module.CAMERA);
        }
        super.onPause();
    }
}

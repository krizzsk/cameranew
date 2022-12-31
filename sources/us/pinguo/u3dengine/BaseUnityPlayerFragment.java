package us.pinguo.u3dengine;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.nativeinterface.UnityInterface;
/* compiled from: BaseUnityPlayerFragment.kt */
@Instrumented
/* loaded from: classes6.dex */
public abstract class BaseUnityPlayerFragment extends Fragment {
    public static final a b = new a(null);
    private static final UnityInterface c;
    public Map<Integer, View> a = new LinkedHashMap();

    /* compiled from: BaseUnityPlayerFragment.kt */
    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }

        public final UnityInterface a() {
            return BaseUnityPlayerFragment.c;
        }
    }

    static {
        UnityInterface unityInterface = new UnityInterface();
        c = unityInterface;
        unityInterface.nativeInit();
    }

    public void _$_clearFindViewByIdCache() {
        this.a.clear();
    }

    public abstract ViewGroup b0();

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        ViewGroup b0;
        us.pinguo.common.log.a.c("onDestroyView", new Object[0]);
        super.onDestroyView();
        PgUnityPlayer pgUnityPlayer = PgUnityPlayer.getInstance();
        if (pgUnityPlayer != null && (b0 = b0()) != null && s.c(b0, pgUnityPlayer.getParent())) {
            us.pinguo.common.log.a.c("remove unity view", new Object[0]);
            b0.removeView(pgUnityPlayer);
        }
        _$_clearFindViewByIdCache();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        VdsAgent.onFragmentHiddenChanged(this, z);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        PgUnityPlayer pgUnityPlayer = PgUnityPlayer.getInstance();
        if (pgUnityPlayer == null) {
            return;
        }
        pgUnityPlayer.lowMemory();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        VdsAgent.onFragmentPause(this);
        us.pinguo.common.log.a.c("onPause", new Object[0]);
        super.onPause();
        PgUnityPlayer pgUnityPlayer = PgUnityPlayer.getInstance();
        if (pgUnityPlayer == null) {
            return;
        }
        pgUnityPlayer.pause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        VdsAgent.onFragmentResume(this);
        us.pinguo.common.log.a.c("onResume", new Object[0]);
        super.onResume();
        PgUnityPlayer pgUnityPlayer = PgUnityPlayer.getInstance();
        if (pgUnityPlayer == null) {
            return;
        }
        if (!s.c(pgUnityPlayer.getParent(), b0())) {
            us.pinguo.common.log.a.c("re-add UnityPlayer when resume", new Object[0]);
            ViewGroup viewGroup = (ViewGroup) pgUnityPlayer.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(pgUnityPlayer);
            }
            ViewGroup b0 = b0();
            if (b0 != null) {
                b0.addView(pgUnityPlayer, 0);
            }
        }
        pgUnityPlayer.resume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        s.h(view, "view");
        us.pinguo.common.log.a.c("onViewCreated", new Object[0]);
        PgUnityPlayer pgUnityPlayer = PgUnityPlayer.getInstance();
        if (pgUnityPlayer == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) pgUnityPlayer.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(pgUnityPlayer);
        }
        ViewGroup b0 = b0();
        if (b0 != null) {
            b0.addView(pgUnityPlayer, 0);
        }
        pgUnityPlayer.requestFocus();
        pgUnityPlayer.windowFocusChanged(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        VdsAgent.setFragmentUserVisibleHint(this, z);
    }
}

package com.google.android.gms.maps;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.maps.g.r;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.ArrayList;
import java.util.List;
@Instrumented
@TargetApi(11)
/* loaded from: classes2.dex */
public class MapFragment extends Fragment {
    private final b a = new b(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a implements com.google.android.gms.dynamic.c {
        private final Fragment a;
        private final com.google.android.gms.maps.g.c b;

        public a(Fragment fragment, com.google.android.gms.maps.g.c cVar) {
            q.j(cVar);
            this.b = cVar;
            q.j(fragment);
            this.a = fragment;
        }

        public final void a(d dVar) {
            try {
                this.b.f(new i(this, dVar));
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        @Override // com.google.android.gms.dynamic.c
        public final void d() {
            try {
                this.b.d();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        @Override // com.google.android.gms.dynamic.c
        public final void e(Activity activity, Bundle bundle, Bundle bundle2) {
            GoogleMapOptions googleMapOptions = (GoogleMapOptions) bundle.getParcelable("MapOptions");
            try {
                Bundle bundle3 = new Bundle();
                com.google.android.gms.maps.g.q.b(bundle2, bundle3);
                this.b.P(com.google.android.gms.dynamic.d.z0(activity), googleMapOptions, bundle3);
                com.google.android.gms.maps.g.q.b(bundle3, bundle2);
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        @Override // com.google.android.gms.dynamic.c
        public final View f(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                com.google.android.gms.maps.g.q.b(bundle, bundle2);
                com.google.android.gms.dynamic.b h2 = this.b.h(com.google.android.gms.dynamic.d.z0(layoutInflater), com.google.android.gms.dynamic.d.z0(viewGroup), bundle2);
                com.google.android.gms.maps.g.q.b(bundle2, bundle);
                return (View) com.google.android.gms.dynamic.d.y0(h2);
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        @Override // com.google.android.gms.dynamic.c
        public final void onCreate(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                com.google.android.gms.maps.g.q.b(bundle, bundle2);
                Bundle arguments = this.a.getArguments();
                if (arguments != null && arguments.containsKey("MapOptions")) {
                    com.google.android.gms.maps.g.q.c(bundle2, "MapOptions", arguments.getParcelable("MapOptions"));
                }
                this.b.onCreate(bundle2);
                com.google.android.gms.maps.g.q.b(bundle2, bundle);
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        @Override // com.google.android.gms.dynamic.c
        public final void onDestroy() {
            try {
                this.b.onDestroy();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        @Override // com.google.android.gms.dynamic.c
        public final void onLowMemory() {
            try {
                this.b.onLowMemory();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        @Override // com.google.android.gms.dynamic.c
        public final void onPause() {
            try {
                this.b.onPause();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        @Override // com.google.android.gms.dynamic.c
        public final void onResume() {
            try {
                this.b.onResume();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        @Override // com.google.android.gms.dynamic.c
        public final void onSaveInstanceState(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                com.google.android.gms.maps.g.q.b(bundle, bundle2);
                this.b.onSaveInstanceState(bundle2);
                com.google.android.gms.maps.g.q.b(bundle2, bundle);
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        @Override // com.google.android.gms.dynamic.c
        public final void onStart() {
            try {
                this.b.onStart();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        @Override // com.google.android.gms.dynamic.c
        public final void onStop() {
            try {
                this.b.onStop();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }
    }

    /* loaded from: classes2.dex */
    static class b extends com.google.android.gms.dynamic.a<a> {

        /* renamed from: e  reason: collision with root package name */
        private final Fragment f3720e;

        /* renamed from: f  reason: collision with root package name */
        private com.google.android.gms.dynamic.e<a> f3721f;

        /* renamed from: g  reason: collision with root package name */
        private Activity f3722g;

        /* renamed from: h  reason: collision with root package name */
        private final List<d> f3723h = new ArrayList();

        b(Fragment fragment) {
            this.f3720e = fragment;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void v(Activity activity) {
            this.f3722g = activity;
            x();
        }

        private final void x() {
            if (this.f3722g == null || this.f3721f == null || b() != null) {
                return;
            }
            try {
                c.a(this.f3722g);
                com.google.android.gms.maps.g.c zzc = r.a(this.f3722g).zzc(com.google.android.gms.dynamic.d.z0(this.f3722g));
                if (zzc == null) {
                    return;
                }
                this.f3721f.a(new a(this.f3720e, zzc));
                for (d dVar : this.f3723h) {
                    b().a(dVar);
                }
                this.f3723h.clear();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            } catch (GooglePlayServicesNotAvailableException unused) {
            }
        }

        @Override // com.google.android.gms.dynamic.a
        protected final void a(com.google.android.gms.dynamic.e<a> eVar) {
            this.f3721f = eVar;
            x();
        }
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.a.v(activity);
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a.d(bundle);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View e2 = this.a.e(layoutInflater, viewGroup, bundle);
        e2.setClickable(true);
        return e2;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        this.a.f();
        super.onDestroy();
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        this.a.g();
        super.onDestroyView();
    }

    @Override // android.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        VdsAgent.onFragmentHiddenChanged(this, z);
    }

    @Override // android.app.Fragment
    @SuppressLint({"NewApi"})
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
        try {
            super.onInflate(activity, attributeSet, bundle);
            this.a.v(activity);
            GoogleMapOptions n = GoogleMapOptions.n(activity, attributeSet);
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("MapOptions", n);
            this.a.h(activity, bundle2, bundle);
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        this.a.i();
        super.onLowMemory();
    }

    @Override // android.app.Fragment
    public void onPause() {
        VdsAgent.onFragmentPause(this);
        this.a.j();
        super.onPause();
    }

    @Override // android.app.Fragment
    public void onResume() {
        VdsAgent.onFragmentResume(this);
        super.onResume();
        this.a.k();
    }

    @Override // android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        this.a.l(bundle);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.a.m();
    }

    @Override // android.app.Fragment
    public void onStop() {
        this.a.n();
        super.onStop();
    }

    @Override // android.app.Fragment
    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }

    @Override // android.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        VdsAgent.setFragmentUserVisibleHint(this, z);
    }
}

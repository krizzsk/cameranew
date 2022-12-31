package com.facebook.appevents.codeless;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.facebook.FacebookException;
import com.facebook.appevents.codeless.a;
import com.facebook.appevents.codeless.c;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.appevents.codeless.internal.PathComponent;
import com.facebook.f;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.l;
import com.facebook.internal.p;
import com.facebook.internal.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CodelessMatcher {

    /* renamed from: f  reason: collision with root package name */
    private static final String f2265f = "com.facebook.appevents.codeless.CodelessMatcher";

    /* renamed from: g  reason: collision with root package name */
    private static CodelessMatcher f2266g;
    private final Handler a = new Handler(Looper.getMainLooper());
    private Set<Activity> b = Collections.newSetFromMap(new WeakHashMap());
    private Set<c> c = new HashSet();

    /* renamed from: d  reason: collision with root package name */
    private HashSet<String> f2267d = new HashSet<>();

    /* renamed from: e  reason: collision with root package name */
    private HashMap<Integer, HashSet<String>> f2268e = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                CodelessMatcher.a(CodelessMatcher.this);
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private WeakReference<View> a;
        private String b;

        public b(View view, String str) {
            this.a = new WeakReference<>(view);
            this.b = str;
        }

        @Nullable
        public View a() {
            WeakReference<View> weakReference = this.a;
            if (weakReference == null) {
                return null;
            }
            return weakReference.get();
        }

        public String b() {
            return this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @UiThread
    /* loaded from: classes.dex */
    public static class c implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, Runnable {
        private WeakReference<View> a;
        @Nullable
        private List<EventBinding> b;
        private final Handler c;

        /* renamed from: d  reason: collision with root package name */
        private HashSet<String> f2269d;

        /* renamed from: e  reason: collision with root package name */
        private final String f2270e;

        public c(View view, Handler handler, HashSet<String> hashSet, String str) {
            this.a = new WeakReference<>(view);
            this.c = handler;
            this.f2269d = hashSet;
            this.f2270e = str;
            handler.postDelayed(this, 200L);
        }

        private void a(b bVar, View view, EventBinding eventBinding) {
            if (eventBinding == null) {
                return;
            }
            try {
                View a = bVar.a();
                if (a == null) {
                    return;
                }
                View a2 = com.facebook.appevents.codeless.internal.d.a(a);
                if (a2 != null && com.facebook.appevents.codeless.internal.d.p(a, a2)) {
                    d(bVar, view, eventBinding);
                } else if (a.getClass().getName().startsWith("com.facebook.react")) {
                } else {
                    if (!(a instanceof AdapterView)) {
                        b(bVar, view, eventBinding);
                    } else if (a instanceof ListView) {
                        c(bVar, view, eventBinding);
                    }
                }
            } catch (Exception e2) {
                x.X(CodelessMatcher.b(), e2);
            }
        }

        private void b(b bVar, View view, EventBinding eventBinding) {
            View a = bVar.a();
            if (a == null) {
                return;
            }
            String b = bVar.b();
            View.OnClickListener g2 = com.facebook.appevents.codeless.internal.d.g(a);
            boolean z = (g2 instanceof a.b) && ((a.b) g2).a();
            if (this.f2269d.contains(b) || z) {
                return;
            }
            a.setOnClickListener(com.facebook.appevents.codeless.a.b(eventBinding, view, a));
            this.f2269d.add(b);
        }

        private void c(b bVar, View view, EventBinding eventBinding) {
            AdapterView adapterView = (AdapterView) bVar.a();
            if (adapterView == null) {
                return;
            }
            String b = bVar.b();
            AdapterView.OnItemClickListener onItemClickListener = adapterView.getOnItemClickListener();
            boolean z = (onItemClickListener instanceof a.c) && ((a.c) onItemClickListener).a();
            if (this.f2269d.contains(b) || z) {
                return;
            }
            adapterView.setOnItemClickListener(com.facebook.appevents.codeless.a.c(eventBinding, view, adapterView));
            this.f2269d.add(b);
        }

        private void d(b bVar, View view, EventBinding eventBinding) {
            View a = bVar.a();
            if (a == null) {
                return;
            }
            String b = bVar.b();
            View.OnTouchListener h2 = com.facebook.appevents.codeless.internal.d.h(a);
            boolean z = (h2 instanceof c.a) && ((c.a) h2).a();
            if (this.f2269d.contains(b) || z) {
                return;
            }
            a.setOnTouchListener(com.facebook.appevents.codeless.c.a(eventBinding, view, a));
            this.f2269d.add(b);
        }

        public static List<b> f(EventBinding eventBinding, View view, List<PathComponent> list, int i2, int i3, String str) {
            String str2 = str + "." + String.valueOf(i3);
            ArrayList arrayList = new ArrayList();
            if (view == null) {
                return arrayList;
            }
            if (i2 >= list.size()) {
                arrayList.add(new b(view, str2));
            } else {
                PathComponent pathComponent = list.get(i2);
                if (pathComponent.a.equals("..")) {
                    ViewParent parent = view.getParent();
                    if (parent instanceof ViewGroup) {
                        List<View> g2 = g((ViewGroup) parent);
                        int size = g2.size();
                        for (int i4 = 0; i4 < size; i4++) {
                            arrayList.addAll(f(eventBinding, g2.get(i4), list, i2 + 1, i4, str2));
                        }
                    }
                    return arrayList;
                } else if (pathComponent.a.equals(".")) {
                    arrayList.add(new b(view, str2));
                    return arrayList;
                } else if (!h(view, pathComponent, i3)) {
                    return arrayList;
                } else {
                    if (i2 == list.size() - 1) {
                        arrayList.add(new b(view, str2));
                    }
                }
            }
            if (view instanceof ViewGroup) {
                List<View> g3 = g((ViewGroup) view);
                int size2 = g3.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    arrayList.addAll(f(eventBinding, g3.get(i5), list, i2 + 1, i5, str2));
                }
            }
            return arrayList;
        }

        private static List<View> g(ViewGroup viewGroup) {
            ArrayList arrayList = new ArrayList();
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt.getVisibility() == 0) {
                    arrayList.add(childAt);
                }
            }
            return arrayList;
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x003f, code lost:
            if (r5.getClass().getSimpleName().equals(r7[r7.length - 1]) == false) goto L14;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static boolean h(android.view.View r5, com.facebook.appevents.codeless.internal.PathComponent r6, int r7) {
            /*
                Method dump skipped, instructions count: 265
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.CodelessMatcher.c.h(android.view.View, com.facebook.appevents.codeless.internal.PathComponent, int):boolean");
        }

        private void i() {
            if (this.b == null || this.a.get() == null) {
                return;
            }
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                e(this.b.get(i2), this.a.get());
            }
        }

        public void e(EventBinding eventBinding, View view) {
            if (eventBinding == null || view == null) {
                return;
            }
            if (TextUtils.isEmpty(eventBinding.a()) || eventBinding.a().equals(this.f2270e)) {
                List<PathComponent> e2 = eventBinding.e();
                if (e2.size() > 25) {
                    return;
                }
                for (b bVar : f(eventBinding, view, e2, 0, -1, this.f2270e)) {
                    a(bVar, view, eventBinding);
                }
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            i();
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            i();
        }

        @Override // java.lang.Runnable
        public void run() {
            View view;
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                l j2 = FetchedAppSettingsManager.j(f.g());
                if (j2 != null && j2.b()) {
                    List<EventBinding> f2 = EventBinding.f(j2.f());
                    this.b = f2;
                    if (f2 == null || (view = this.a.get()) == null) {
                        return;
                    }
                    ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                    if (viewTreeObserver.isAlive()) {
                        viewTreeObserver.addOnGlobalLayoutListener(this);
                        viewTreeObserver.addOnScrollChangedListener(this);
                    }
                    i();
                }
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    private CodelessMatcher() {
    }

    static /* synthetic */ void a(CodelessMatcher codelessMatcher) {
        if (com.facebook.internal.instrument.e.a.c(CodelessMatcher.class)) {
            return;
        }
        try {
            codelessMatcher.f();
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, CodelessMatcher.class);
        }
    }

    static /* synthetic */ String b() {
        if (com.facebook.internal.instrument.e.a.c(CodelessMatcher.class)) {
            return null;
        }
        try {
            return f2265f;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, CodelessMatcher.class);
            return null;
        }
    }

    @UiThread
    public static Bundle e(EventBinding eventBinding, View view, View view2) {
        List<com.facebook.appevents.codeless.internal.a> d2;
        List<b> f2;
        if (com.facebook.internal.instrument.e.a.c(CodelessMatcher.class)) {
            return null;
        }
        try {
            Bundle bundle = new Bundle();
            if (eventBinding != null && (d2 = eventBinding.d()) != null) {
                for (com.facebook.appevents.codeless.internal.a aVar : d2) {
                    String str = aVar.b;
                    if (str != null && str.length() > 0) {
                        bundle.putString(aVar.a, aVar.b);
                    } else if (aVar.c.size() > 0) {
                        if (aVar.f2290d.equals("relative")) {
                            f2 = c.f(eventBinding, view2, aVar.c, 0, -1, view2.getClass().getSimpleName());
                        } else {
                            f2 = c.f(eventBinding, view, aVar.c, 0, -1, view.getClass().getSimpleName());
                        }
                        Iterator<b> it = f2.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                b next = it.next();
                                if (next.a() != null) {
                                    String k2 = com.facebook.appevents.codeless.internal.d.k(next.a());
                                    if (k2.length() > 0) {
                                        bundle.putString(aVar.a, k2);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return bundle;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, CodelessMatcher.class);
            return null;
        }
    }

    private void f() {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            for (Activity activity : this.b) {
                if (activity != null) {
                    this.c.add(new c(com.facebook.appevents.internal.b.e(activity), this.a, this.f2267d, activity.getClass().getSimpleName()));
                }
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    public static synchronized CodelessMatcher getInstance() {
        synchronized (CodelessMatcher.class) {
            if (com.facebook.internal.instrument.e.a.c(CodelessMatcher.class)) {
                return null;
            }
            if (f2266g == null) {
                f2266g = new CodelessMatcher();
            }
            return f2266g;
        }
    }

    private void h() {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                f();
            } else {
                this.a.post(new a());
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    @UiThread
    public void c(Activity activity) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            if (p.b()) {
                return;
            }
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                this.b.add(activity);
                this.f2267d.clear();
                if (this.f2268e.containsKey(Integer.valueOf(activity.hashCode()))) {
                    this.f2267d = this.f2268e.get(Integer.valueOf(activity.hashCode()));
                }
                h();
                return;
            }
            throw new FacebookException("Can't add activity to CodelessMatcher on non-UI thread");
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    @UiThread
    public void d(Activity activity) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            this.f2268e.remove(Integer.valueOf(activity.hashCode()));
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    @UiThread
    public void g(Activity activity) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            if (p.b()) {
                return;
            }
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                this.b.remove(activity);
                this.c.clear();
                this.f2268e.put(Integer.valueOf(activity.hashCode()), (HashSet) this.f2267d.clone());
                this.f2267d.clear();
                return;
            }
            throw new FacebookException("Can't remove activity from CodelessMatcher on non-UI thread");
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }
}

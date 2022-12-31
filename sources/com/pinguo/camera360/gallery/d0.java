package com.pinguo.camera360.gallery;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import com.pinguo.camera360.gallery.ActivityState;
import com.tapjoy.TJAdUnitConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;
/* compiled from: StateManager.java */
/* loaded from: classes3.dex */
public class d0 {
    private RootActivity b;

    /* renamed from: d  reason: collision with root package name */
    private ActivityState.c f6330d;
    private boolean a = false;
    private Stack<a> c = new Stack<>();

    /* renamed from: e  reason: collision with root package name */
    private Map<Integer, a> f6331e = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: StateManager.java */
    /* loaded from: classes3.dex */
    public static class a {
        public Bundle a;
        public ActivityState b;

        public a(Bundle bundle, ActivityState activityState) {
            this.a = bundle;
            this.b = activityState;
        }
    }

    public d0(RootActivity rootActivity) {
        this.b = rootActivity;
    }

    private a f() {
        if (this.c.isEmpty()) {
            return null;
        }
        return this.c.peek();
    }

    public boolean a(Menu menu) {
        if (this.c.isEmpty()) {
            return false;
        }
        return e().H(menu);
    }

    public void b() {
        us.pinguo.common.log.a.q("destroy", new Object[0]);
        while (!this.c.isEmpty()) {
            this.c.pop().b.I();
        }
        this.c.clear();
        for (a aVar : this.f6331e.values()) {
            ActivityState activityState = aVar.b;
            if (activityState != null) {
                activityState.I();
            }
        }
        this.f6331e.clear();
    }

    public void c(Class cls) {
        us.pinguo.common.log.a.q("destroyTopIfMatch", new Object[0]);
        a peek = !this.c.isEmpty() ? this.c.peek() : null;
        if (peek == null || !peek.b.getClass().getSimpleName().equals(cls.getSimpleName())) {
            return;
        }
        if (this.a) {
            peek.b.J();
        }
        peek.b.I();
        this.c.remove(peek);
    }

    public void d(ActivityState activityState) {
        if (this.c.size() == 1) {
            RootActivity rootActivity = this.b;
            rootActivity.a();
            RootActivity rootActivity2 = rootActivity;
            ActivityState.c cVar = this.f6330d;
            if (cVar != null) {
                rootActivity2.setResult(cVar.b, cVar.c);
            }
            rootActivity2.finish();
            if (!rootActivity2.isFinishing()) {
                us.pinguo.common.log.a.s("finish is rejected, keep the last state", new Object[0]);
                return;
            }
            us.pinguo.common.log.a.q("no more state, finish activity", new Object[0]);
        }
        us.pinguo.common.log.a.q("finishState " + activityState, new Object[0]);
        if (!this.c.isEmpty()) {
            if (activityState != this.c.peek().b) {
                if (activityState.B()) {
                    us.pinguo.common.log.a.c("The state is already destroyed", new Object[0]);
                    return;
                }
                throw new IllegalArgumentException("The stateview to be finished is not at the top of the stack: " + activityState + ", " + this.c.peek().b);
            }
            this.c.pop();
        }
        activityState.f6294i = true;
        if (this.a) {
            activityState.J();
        }
        this.b.E().setContentPane(null);
        activityState.I();
        if (this.c.isEmpty()) {
            return;
        }
        ActivityState activityState2 = this.c.peek().b;
        if (this.a) {
            activityState2.P();
        }
    }

    public ActivityState e() {
        if (this.c.isEmpty()) {
            return null;
        }
        return this.c.peek().b;
    }

    public void g(int i2, int i3, Intent intent) {
        if (this.c.isEmpty()) {
            return;
        }
        e().O(i2, i3, intent);
    }

    public void h() {
        if (this.c.isEmpty()) {
            return;
        }
        e().E();
    }

    public void i(Configuration configuration) {
        Iterator<a> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().b.F(configuration);
        }
    }

    public void j() {
        if (this.a) {
            this.a = false;
            if (this.c.isEmpty()) {
                return;
            }
            e().J();
        }
    }

    public void k(Bundle bundle) {
        if (this.c.isEmpty()) {
            return;
        }
        ActivityState e2 = e();
        e2.f6294i = true;
        if (this.a) {
            e2.J();
        }
        this.b.E().setContentPane(null);
        e2.I();
        this.c.pop();
        try {
            ActivityState activityState = (ActivityState) e2.getClass().newInstance();
            activityState.A(this.b, bundle);
            this.c.push(new a(bundle, activityState));
            activityState.G(bundle, null);
            if (this.a) {
                activityState.P();
            }
        } catch (Exception e3) {
            throw new AssertionError(e3);
        }
    }

    public void l(Bundle bundle) {
        us.pinguo.common.log.a.q("restoreFromState", new Object[0]);
        for (Parcelable parcelable : bundle.getParcelableArray("activity-state")) {
            Bundle bundle2 = (Bundle) parcelable;
            Class cls = (Class) bundle2.getSerializable("class");
            Bundle bundle3 = bundle2.getBundle("data");
            Bundle bundle4 = bundle2.getBundle(TJAdUnitConstants.String.BUNDLE);
            try {
                us.pinguo.common.log.a.q("restoreFromState " + cls, new Object[0]);
                ActivityState activityState = (ActivityState) cls.newInstance();
                activityState.A(this.b, bundle3);
                activityState.G(bundle3, bundle4);
                this.c.push(new a(bundle3, activityState));
            } catch (Exception e2) {
                throw new AssertionError(e2);
            }
        }
    }

    public void m() {
        if (this.a) {
            return;
        }
        this.a = true;
        if (this.c.isEmpty()) {
            return;
        }
        e().P();
    }

    public void n(Bundle bundle) {
        us.pinguo.common.log.a.q("saveState", new Object[0]);
        Parcelable[] parcelableArr = new Parcelable[this.c.size()];
        Iterator<a> it = this.c.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            a next = it.next();
            Bundle bundle2 = new Bundle();
            bundle2.putSerializable("class", next.b.getClass());
            bundle2.putBundle("data", next.a);
            Bundle bundle3 = new Bundle();
            next.b.N(bundle3);
            bundle2.putBundle(TJAdUnitConstants.String.BUNDLE, bundle3);
            us.pinguo.common.log.a.q("saveState " + next.b.getClass(), new Object[0]);
            parcelableArr[i2] = bundle2;
            i2++;
        }
        bundle.putParcelableArray("activity-state", parcelableArr);
    }

    public void o(Class<? extends ActivityState> cls, Bundle bundle) {
        us.pinguo.common.log.a.q("startState " + cls, new Object[0]);
        try {
            ActivityState newInstance = cls.newInstance();
            if (!this.c.isEmpty()) {
                ActivityState e2 = e();
                if (this.a) {
                    e2.J();
                }
            }
            newInstance.A(this.b, bundle);
            this.c.push(new a(bundle, newInstance));
            newInstance.G(bundle, null);
            if (this.a) {
                newInstance.P();
            }
        } catch (Exception e3) {
            throw new AssertionError(e3);
        }
    }

    public void p(Class<? extends ActivityState> cls, Bundle bundle) {
        a aVar;
        us.pinguo.common.log.a.q("startState " + cls, new Object[0]);
        try {
            ActivityState newInstance = cls.newInstance();
            if (this.c.isEmpty()) {
                aVar = null;
            } else {
                aVar = f();
                if (this.a) {
                    aVar.b.J();
                }
            }
            newInstance.A(this.b, bundle);
            this.c.push(new a(bundle, newInstance));
            newInstance.G(bundle, null);
            if (this.a) {
                newInstance.P();
            }
            if (aVar != null) {
                aVar.b.I();
                this.c.remove(aVar);
            }
        } catch (Exception e2) {
            throw new AssertionError(e2);
        }
    }

    public void q(Class<? extends ActivityState> cls, Bundle bundle) {
        us.pinguo.common.log.a.q("startState " + cls, new Object[0]);
        int i2 = -1;
        for (int i3 = 0; i3 < this.c.size(); i3++) {
            if (this.c.get(i3).b.getClass().getSimpleName().equals(cls.getSimpleName())) {
                i2 = i3;
            }
        }
        if (i2 != -1) {
            for (int i4 = i2; i4 < this.c.size(); i4++) {
                a pop = this.c.pop();
                pop.b.J();
                pop.b.I();
            }
            this.c.get(i2).b.P();
            return;
        }
        try {
            ActivityState newInstance = cls.newInstance();
            newInstance.A(this.b, bundle);
            this.c.push(new a(bundle, newInstance));
            newInstance.G(bundle, null);
            if (this.a) {
                newInstance.P();
            }
        } catch (Exception e2) {
            throw new AssertionError(e2);
        }
    }

    public void r(Class<? extends ActivityState> cls, int i2, Bundle bundle) {
        us.pinguo.common.log.a.q("startStateForResult " + cls + ", " + i2, new Object[0]);
        try {
            ActivityState newInstance = cls.newInstance();
            newInstance.A(this.b, bundle);
            ActivityState.c cVar = new ActivityState.c();
            newInstance.f6290e = cVar;
            cVar.a = i2;
            if (!this.c.isEmpty()) {
                ActivityState e2 = e();
                e2.f6289d = newInstance.f6290e;
                if (this.a) {
                    e2.J();
                }
            } else {
                this.f6330d = newInstance.f6290e;
            }
            this.c.push(new a(bundle, newInstance));
            newInstance.G(bundle, null);
            if (this.a) {
                newInstance.P();
            }
        } catch (Exception e3) {
            throw new AssertionError(e3);
        }
    }

    public void s(ActivityState activityState, Class<? extends ActivityState> cls, Bundle bundle) {
        ActivityState activityState2;
        Bundle bundle2;
        ActivityState activityState3;
        us.pinguo.common.log.a.q("switchState " + activityState + ", " + cls, new Object[0]);
        if (this.c.isEmpty() || activityState == this.c.peek().b) {
            if (!this.c.isEmpty() && activityState != null) {
                a pop = this.c.pop();
                if (this.a) {
                    activityState.J();
                }
                if (activityState.w() >= 0) {
                    a aVar = this.f6331e.get(Integer.valueOf(activityState.w()));
                    if (aVar != pop) {
                        if (aVar != null && (activityState3 = aVar.b) != null) {
                            activityState3.I();
                        }
                        this.f6331e.put(Integer.valueOf(activityState.w()), pop);
                    }
                } else {
                    activityState.I();
                }
            }
            Iterator<Integer> it = this.f6331e.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    activityState2 = null;
                    break;
                }
                a aVar2 = this.f6331e.get(Integer.valueOf(it.next().intValue()));
                ActivityState activityState4 = aVar2.b;
                if (activityState4 != null && activityState4.getClass() == cls) {
                    this.c.push(aVar2);
                    activityState2 = aVar2.b;
                    it.remove();
                    break;
                }
            }
            if (activityState2 == null) {
                try {
                    activityState2 = cls.newInstance();
                    if (activityState != null && (bundle2 = activityState.b) != null && bundle2.containsKey("bundle_key_goto")) {
                        bundle.putParcelable("bundle_key_goto", activityState.b.getParcelable("bundle_key_goto"));
                        bundle.putInt("photo_page_come_from", activityState.b.getInt("photo_page_come_from", 0));
                    }
                    activityState2.A(this.b, bundle);
                    this.c.push(new a(bundle, activityState2));
                    activityState2.G(bundle, null);
                } catch (Exception e2) {
                    throw new AssertionError(e2);
                }
            }
            if (this.a) {
                activityState2.P();
            }
        }
    }
}

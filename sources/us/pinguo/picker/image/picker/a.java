package us.pinguo.picker.image.picker;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.o;
/* compiled from: ImagePicker.kt */
/* loaded from: classes5.dex */
public final class a {
    public static final C0431a c = new C0431a(null);
    private final WeakReference<Activity> a;
    private final WeakReference<Fragment> b;

    /* compiled from: ImagePicker.kt */
    /* renamed from: us.pinguo.picker.image.picker.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0431a {
        private C0431a() {
        }

        public /* synthetic */ C0431a(o oVar) {
            this();
        }

        public final a a(Fragment fragment) {
            return new a(null, fragment, 1, null);
        }
    }

    public a(Activity activity, Fragment fragment) {
        this.a = new WeakReference<>(activity);
        this.b = new WeakReference<>(fragment);
    }

    public final b a() {
        return new b(this);
    }

    public final Activity b() {
        Activity activity = this.a.get();
        if (activity == null) {
            Fragment fragment = this.b.get();
            if (fragment == null) {
                return null;
            }
            return fragment.getActivity();
        }
        return activity;
    }

    public final Fragment c() {
        return this.b.get();
    }

    public /* synthetic */ a(Activity activity, Fragment fragment, int i2, o oVar) {
        this((i2 & 1) != 0 ? null : activity, (i2 & 2) != 0 ? null : fragment);
    }
}

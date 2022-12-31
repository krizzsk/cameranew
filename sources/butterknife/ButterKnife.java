package butterknife;

import android.app.Activity;
import android.app.Dialog;
import android.util.Log;
import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.VisibleForTesting;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class ButterKnife {
    @VisibleForTesting
    static final Map<Class<?>, Constructor<? extends Unbinder>> BINDINGS = new LinkedHashMap();
    private static final String TAG = "ButterKnife";
    private static boolean debug = false;

    private ButterKnife() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @UiThread
    public static Unbinder bind(@NonNull Activity activity) {
        return bind(activity, activity.getWindow().getDecorView());
    }

    @Nullable
    @CheckResult
    @UiThread
    private static Constructor<? extends Unbinder> findBindingConstructorForClass(Class<?> cls) {
        Constructor<? extends Unbinder> findBindingConstructorForClass;
        Map<Class<?>, Constructor<? extends Unbinder>> map = BINDINGS;
        Constructor<? extends Unbinder> constructor = map.get(cls);
        if (constructor == null && !map.containsKey(cls)) {
            String name = cls.getName();
            if (!name.startsWith("android.") && !name.startsWith("java.") && !name.startsWith("androidx.")) {
                try {
                    ClassLoader classLoader = cls.getClassLoader();
                    findBindingConstructorForClass = classLoader.loadClass(name + "_ViewBinding").getConstructor(cls, View.class);
                    if (debug) {
                        Log.d(TAG, "HIT: Loaded binding class and constructor.");
                    }
                } catch (ClassNotFoundException unused) {
                    if (debug) {
                        Log.d(TAG, "Not found. Trying superclass " + cls.getSuperclass().getName());
                    }
                    findBindingConstructorForClass = findBindingConstructorForClass(cls.getSuperclass());
                } catch (NoSuchMethodException e2) {
                    throw new RuntimeException("Unable to find binding constructor for " + name, e2);
                }
                BINDINGS.put(cls, findBindingConstructorForClass);
                return findBindingConstructorForClass;
            } else if (debug) {
                Log.d(TAG, "MISS: Reached framework class. Abandoning search.");
                return null;
            } else {
                return null;
            }
        }
        if (debug) {
            Log.d(TAG, "HIT: Cached in binding map.");
        }
        return constructor;
    }

    public static void setDebug(boolean z) {
        debug = z;
    }

    @NonNull
    @UiThread
    public static Unbinder bind(@NonNull View view) {
        return bind(view, view);
    }

    @NonNull
    @UiThread
    public static Unbinder bind(@NonNull Dialog dialog) {
        return bind(dialog, dialog.getWindow().getDecorView());
    }

    @NonNull
    @UiThread
    public static Unbinder bind(@NonNull Object obj, @NonNull Activity activity) {
        return bind(obj, activity.getWindow().getDecorView());
    }

    @NonNull
    @UiThread
    public static Unbinder bind(@NonNull Object obj, @NonNull Dialog dialog) {
        return bind(obj, dialog.getWindow().getDecorView());
    }

    @NonNull
    @UiThread
    public static Unbinder bind(@NonNull Object obj, @NonNull View view) {
        Class<?> cls = obj.getClass();
        if (debug) {
            Log.d(TAG, "Looking up binding for " + cls.getName());
        }
        Constructor<? extends Unbinder> findBindingConstructorForClass = findBindingConstructorForClass(cls);
        if (findBindingConstructorForClass == null) {
            return Unbinder.a;
        }
        try {
            return findBindingConstructorForClass.newInstance(obj, view);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Unable to invoke " + findBindingConstructorForClass, e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException("Unable to invoke " + findBindingConstructorForClass, e3);
        } catch (InvocationTargetException e4) {
            Throwable cause = e4.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Unable to create binding instance.", cause);
            }
            throw ((RuntimeException) cause);
        }
    }
}

package com.tencent.matrix;

import android.app.Application;
import com.tencent.matrix.plugin.DefaultPluginListener;
import com.tencent.matrix.plugin.Plugin;
import com.tencent.matrix.plugin.PluginListener;
import com.tencent.matrix.util.MatrixLog;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class Matrix {
    private static final String TAG = "Matrix.Matrix";
    private static volatile Matrix sInstance;
    private final Application application;
    private final PluginListener pluginListener;
    private final HashSet<Plugin> plugins;

    /* loaded from: classes3.dex */
    public static class Builder {
        private final Application application;
        private PluginListener pluginListener;
        private HashSet<Plugin> plugins = new HashSet<>();

        public Builder(Application application) {
            if (application != null) {
                this.application = application;
                return;
            }
            throw new RuntimeException("matrix init, application is null");
        }

        public Matrix build() {
            if (this.pluginListener == null) {
                this.pluginListener = new DefaultPluginListener(this.application);
            }
            return new Matrix(this.application, this.pluginListener, this.plugins);
        }

        public Builder plugin(Plugin plugin) {
            String tag = plugin.getTag();
            Iterator<Plugin> it = this.plugins.iterator();
            while (it.hasNext()) {
                if (tag.equals(it.next().getTag())) {
                    throw new RuntimeException(String.format("plugin with tag %s is already exist", tag));
                }
            }
            this.plugins.add(plugin);
            return this;
        }

        public Builder pluginListener(PluginListener pluginListener) {
            this.pluginListener = pluginListener;
            return this;
        }
    }

    public static Matrix init(Matrix matrix) {
        if (matrix != null) {
            synchronized (Matrix.class) {
                if (sInstance == null) {
                    sInstance = matrix;
                } else {
                    MatrixLog.e(TAG, "Matrix instance is already set. this invoking will be ignored", new Object[0]);
                }
            }
            return sInstance;
        }
        throw new RuntimeException("Matrix init, Matrix should not be null.");
    }

    public static boolean isInstalled() {
        return sInstance != null;
    }

    public static void setLogIml(MatrixLog.MatrixLogImp matrixLogImp) {
        MatrixLog.setMatrixLogImp(matrixLogImp);
    }

    public static Matrix with() {
        if (sInstance != null) {
            return sInstance;
        }
        throw new RuntimeException("you must init Matrix sdk first");
    }

    public void destroyAllPlugins() {
        Iterator<Plugin> it = this.plugins.iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
    }

    public Application getApplication() {
        return this.application;
    }

    public <T extends Plugin> T getPluginByClass(Class<T> cls) {
        String name = cls.getName();
        Iterator<Plugin> it = this.plugins.iterator();
        while (it.hasNext()) {
            T t = (T) it.next();
            if (t.getClass().getName().equals(name)) {
                return t;
            }
        }
        return null;
    }

    public Plugin getPluginByTag(String str) {
        Iterator<Plugin> it = this.plugins.iterator();
        while (it.hasNext()) {
            Plugin next = it.next();
            if (next.getTag().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public HashSet<Plugin> getPlugins() {
        return this.plugins;
    }

    public void startAllPlugins() {
        Iterator<Plugin> it = this.plugins.iterator();
        while (it.hasNext()) {
            it.next().start();
        }
    }

    public void stopAllPlugins() {
        Iterator<Plugin> it = this.plugins.iterator();
        while (it.hasNext()) {
            it.next().stop();
        }
    }

    private Matrix(Application application, PluginListener pluginListener, HashSet<Plugin> hashSet) {
        this.application = application;
        this.pluginListener = pluginListener;
        this.plugins = hashSet;
        AppActiveMatrixDelegate.INSTANCE.init(application);
        Iterator<Plugin> it = hashSet.iterator();
        while (it.hasNext()) {
            Plugin next = it.next();
            next.init(this.application, this.pluginListener);
            this.pluginListener.onInit(next);
        }
    }
}

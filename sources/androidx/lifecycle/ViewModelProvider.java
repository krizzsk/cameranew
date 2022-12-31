package androidx.lifecycle;

import android.app.Application;
import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
/* compiled from: ViewModelProvider.kt */
/* loaded from: classes.dex */
public class ViewModelProvider {
    private final Factory factory;
    private final ViewModelStore store;

    /* compiled from: ViewModelProvider.kt */
    /* loaded from: classes.dex */
    public static class AndroidViewModelFactory extends NewInstanceFactory {
        public static final Companion Companion = new Companion(null);
        public static final String DEFAULT_KEY = "androidx.lifecycle.ViewModelProvider.DefaultKey";
        private static AndroidViewModelFactory sInstance;
        private final Application application;

        /* compiled from: ViewModelProvider.kt */
        /* loaded from: classes.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(o oVar) {
                this();
            }

            public final Factory defaultFactory$lifecycle_viewmodel_release(ViewModelStoreOwner owner) {
                s.h(owner, "owner");
                if (owner instanceof HasDefaultViewModelProviderFactory) {
                    Factory defaultViewModelProviderFactory = ((HasDefaultViewModelProviderFactory) owner).getDefaultViewModelProviderFactory();
                    s.g(defaultViewModelProviderFactory, "owner.defaultViewModelProviderFactory");
                    return defaultViewModelProviderFactory;
                }
                return NewInstanceFactory.Companion.getInstance();
            }

            public final AndroidViewModelFactory getInstance(Application application) {
                s.h(application, "application");
                if (AndroidViewModelFactory.sInstance == null) {
                    AndroidViewModelFactory.sInstance = new AndroidViewModelFactory(application);
                }
                AndroidViewModelFactory androidViewModelFactory = AndroidViewModelFactory.sInstance;
                s.e(androidViewModelFactory);
                return androidViewModelFactory;
            }
        }

        public AndroidViewModelFactory(Application application) {
            s.h(application, "application");
            this.application = application;
        }

        public static final AndroidViewModelFactory getInstance(Application application) {
            return Companion.getInstance(application);
        }

        @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> modelClass) {
            s.h(modelClass, "modelClass");
            if (AndroidViewModel.class.isAssignableFrom(modelClass)) {
                try {
                    T newInstance = modelClass.getConstructor(Application.class).newInstance(this.application);
                    s.g(newInstance, "{\n                try {\n…          }\n            }");
                    return newInstance;
                } catch (IllegalAccessException e2) {
                    throw new RuntimeException(s.q("Cannot create an instance of ", modelClass), e2);
                } catch (InstantiationException e3) {
                    throw new RuntimeException(s.q("Cannot create an instance of ", modelClass), e3);
                } catch (NoSuchMethodException e4) {
                    throw new RuntimeException(s.q("Cannot create an instance of ", modelClass), e4);
                } catch (InvocationTargetException e5) {
                    throw new RuntimeException(s.q("Cannot create an instance of ", modelClass), e5);
                }
            }
            return (T) super.create(modelClass);
        }
    }

    /* compiled from: ViewModelProvider.kt */
    /* loaded from: classes.dex */
    public interface Factory {
        <T extends ViewModel> T create(Class<T> cls);
    }

    /* compiled from: ViewModelProvider.kt */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes.dex */
    public static abstract class KeyedFactory extends OnRequeryFactory implements Factory {
        public <T extends ViewModel> T create(Class<T> modelClass) {
            s.h(modelClass, "modelClass");
            throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementations of KeyedFactory");
        }

        public abstract <T extends ViewModel> T create(String str, Class<T> cls);
    }

    /* compiled from: ViewModelProvider.kt */
    /* loaded from: classes.dex */
    public static class NewInstanceFactory implements Factory {
        public static final Companion Companion = new Companion(null);
        private static NewInstanceFactory sInstance;

        /* compiled from: ViewModelProvider.kt */
        /* loaded from: classes.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(o oVar) {
                this();
            }

            public static /* synthetic */ void getInstance$annotations() {
            }

            @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
            public final NewInstanceFactory getInstance() {
                if (NewInstanceFactory.sInstance == null) {
                    NewInstanceFactory.sInstance = new NewInstanceFactory();
                }
                NewInstanceFactory newInstanceFactory = NewInstanceFactory.sInstance;
                s.e(newInstanceFactory);
                return newInstanceFactory;
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final NewInstanceFactory getInstance() {
            return Companion.getInstance();
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> modelClass) {
            s.h(modelClass, "modelClass");
            try {
                T newInstance = modelClass.newInstance();
                s.g(newInstance, "{\n                modelC…wInstance()\n            }");
                return newInstance;
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(s.q("Cannot create an instance of ", modelClass), e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException(s.q("Cannot create an instance of ", modelClass), e3);
            }
        }
    }

    /* compiled from: ViewModelProvider.kt */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes.dex */
    public static class OnRequeryFactory {
        public void onRequery(ViewModel viewModel) {
            s.h(viewModel, "viewModel");
        }
    }

    public ViewModelProvider(ViewModelStore store, Factory factory) {
        s.h(store, "store");
        s.h(factory, "factory");
        this.store = store;
        this.factory = factory;
    }

    @MainThread
    public <T extends ViewModel> T get(Class<T> modelClass) {
        s.h(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName != null) {
            return (T) get(s.q("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName), modelClass);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ViewModelProvider(androidx.lifecycle.ViewModelStoreOwner r3) {
        /*
            r2 = this;
            java.lang.String r0 = "owner"
            kotlin.jvm.internal.s.h(r3, r0)
            androidx.lifecycle.ViewModelStore r0 = r3.getViewModelStore()
            java.lang.String r1 = "owner.viewModelStore"
            kotlin.jvm.internal.s.g(r0, r1)
            androidx.lifecycle.ViewModelProvider$AndroidViewModelFactory$Companion r1 = androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion
            androidx.lifecycle.ViewModelProvider$Factory r3 = r1.defaultFactory$lifecycle_viewmodel_release(r3)
            r2.<init>(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.ViewModelProvider.<init>(androidx.lifecycle.ViewModelStoreOwner):void");
    }

    @MainThread
    public <T extends ViewModel> T get(String key, Class<T> modelClass) {
        T viewModel;
        s.h(key, "key");
        s.h(modelClass, "modelClass");
        T viewModel2 = (T) this.store.get(key);
        if (modelClass.isInstance(viewModel2)) {
            Factory factory = this.factory;
            OnRequeryFactory onRequeryFactory = factory instanceof OnRequeryFactory ? (OnRequeryFactory) factory : null;
            if (onRequeryFactory != null) {
                s.g(viewModel2, "viewModel");
                onRequeryFactory.onRequery(viewModel2);
            }
            Objects.requireNonNull(viewModel2, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
            return viewModel2;
        }
        Factory factory2 = this.factory;
        if (factory2 instanceof KeyedFactory) {
            viewModel = (T) ((KeyedFactory) factory2).create(key, modelClass);
        } else {
            viewModel = (T) factory2.create(modelClass);
        }
        this.store.put(key, viewModel);
        s.g(viewModel, "viewModel");
        return viewModel;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ViewModelProvider(androidx.lifecycle.ViewModelStoreOwner r2, androidx.lifecycle.ViewModelProvider.Factory r3) {
        /*
            r1 = this;
            java.lang.String r0 = "owner"
            kotlin.jvm.internal.s.h(r2, r0)
            java.lang.String r0 = "factory"
            kotlin.jvm.internal.s.h(r3, r0)
            androidx.lifecycle.ViewModelStore r2 = r2.getViewModelStore()
            java.lang.String r0 = "owner.viewModelStore"
            kotlin.jvm.internal.s.g(r2, r0)
            r1.<init>(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.ViewModelProvider.<init>(androidx.lifecycle.ViewModelStoreOwner, androidx.lifecycle.ViewModelProvider$Factory):void");
    }
}

package us.pinguo.camera2020.viewmodel;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: CameraViewModelFactory.kt */
/* loaded from: classes3.dex */
public final class CameraViewModelFactory implements ViewModelProvider.Factory, NoProguard {
    private final Application app;
    private final boolean facing;

    public CameraViewModelFactory(Application app, boolean z) {
        s.h(app, "app");
        this.app = app;
        this.facing = z;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <CameraViewModel extends ViewModel> CameraViewModel create(Class<CameraViewModel> modelClass) {
        s.h(modelClass, "modelClass");
        CameraViewModel newInstance = modelClass.getDeclaredConstructor(Application.class, Boolean.TYPE).newInstance(this.app, Boolean.valueOf(this.facing));
        s.g(newInstance, "constructor.newInstance(app, facing)");
        return newInstance;
    }
}

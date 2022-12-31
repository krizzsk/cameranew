package us.pinguo.repository2020.manager;

import androidx.databinding.ObservableField;
import com.pinguo.lib.GsonUtilKt;
import java.io.File;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.g2;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.z0;
import us.pinguo.repository2020.database.paint.PaintMaterialTable;
import us.pinguo.repository2020.entity.MaterialConfig;
import us.pinguo.repository2020.entity.MaterialInstallState;
import us.pinguo.repository2020.entity.PaintMaterial;
import us.pinguo.repository2020.utils.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MaterialInstallManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.manager.MaterialInstallManager$installMaterial$1", f = "MaterialInstallManager.kt", i = {0}, l = {41, 43, 95, 100}, m = "invokeSuspend", n = {"materialResourcePath"}, s = {"L$0"})
/* loaded from: classes6.dex */
public final class MaterialInstallManager$installMaterial$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ q<Boolean, PaintMaterial, String, u> $installAction;
    final /* synthetic */ PaintMaterial $material;
    final /* synthetic */ String $msg;
    final /* synthetic */ String $pid;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MaterialInstallManager.kt */
    @DebugMetadata(c = "us.pinguo.repository2020.manager.MaterialInstallManager$installMaterial$1$1", f = "MaterialInstallManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.repository2020.manager.MaterialInstallManager$installMaterial$1$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
        final /* synthetic */ q<Boolean, PaintMaterial, String, u> $installAction;
        final /* synthetic */ PaintMaterial $material;
        final /* synthetic */ String $msg;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(q<? super Boolean, ? super PaintMaterial, ? super String, u> qVar, PaintMaterial paintMaterial, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$installAction = qVar;
            this.$material = paintMaterial;
            this.$msg = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$installAction, this.$material, this.$msg, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                kotlin.j.b(obj);
                q<Boolean, PaintMaterial, String, u> qVar = this.$installAction;
                if (qVar == null) {
                    return null;
                }
                qVar.invoke(Boxing.boxBoolean(false), this.$material, this.$msg);
                return u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MaterialInstallManager.kt */
    @DebugMetadata(c = "us.pinguo.repository2020.manager.MaterialInstallManager$installMaterial$1$3", f = "MaterialInstallManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.repository2020.manager.MaterialInstallManager$installMaterial$1$3  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
        final /* synthetic */ q<Boolean, PaintMaterial, String, u> $installAction;
        final /* synthetic */ PaintMaterial $material;
        final /* synthetic */ String $msg;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(q<? super Boolean, ? super PaintMaterial, ? super String, u> qVar, PaintMaterial paintMaterial, String str, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$installAction = qVar;
            this.$material = paintMaterial;
            this.$msg = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$installAction, this.$material, this.$msg, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
            return ((AnonymousClass3) create(m0Var, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                kotlin.j.b(obj);
                q<Boolean, PaintMaterial, String, u> qVar = this.$installAction;
                if (qVar != null) {
                    qVar.invoke(Boxing.boxBoolean(false), this.$material, this.$msg);
                }
                return u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MaterialInstallManager.kt */
    @DebugMetadata(c = "us.pinguo.repository2020.manager.MaterialInstallManager$installMaterial$1$4", f = "MaterialInstallManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.repository2020.manager.MaterialInstallManager$installMaterial$1$4  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass4 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
        final /* synthetic */ q<Boolean, PaintMaterial, String, u> $installAction;
        final /* synthetic */ PaintMaterial $material;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass4(q<? super Boolean, ? super PaintMaterial, ? super String, u> qVar, PaintMaterial paintMaterial, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$installAction = qVar;
            this.$material = paintMaterial;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass4(this.$installAction, this.$material, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
            return ((AnonymousClass4) create(m0Var, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                kotlin.j.b(obj);
                q<Boolean, PaintMaterial, String, u> qVar = this.$installAction;
                if (qVar != null) {
                    qVar.invoke(Boxing.boxBoolean(true), this.$material, "");
                }
                return u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MaterialInstallManager$installMaterial$1(String str, PaintMaterial paintMaterial, q<? super Boolean, ? super PaintMaterial, ? super String, u> qVar, String str2, Continuation<? super MaterialInstallManager$installMaterial$1> continuation) {
        super(2, continuation);
        this.$pid = str;
        this.$material = paintMaterial;
        this.$installAction = qVar;
        this.$msg = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new MaterialInstallManager$installMaterial$1(this.$pid, this.$material, this.$installAction, this.$msg, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((MaterialInstallManager$installMaterial$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        String str;
        Object d2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
            g2 c = z0.c();
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$installAction, this.$material, this.$msg, null);
            this.L$0 = null;
            this.label = 3;
            if (kotlinx.coroutines.j.g(c, anonymousClass3, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (i2 == 0) {
            kotlin.j.b(obj);
            String f2 = n.a.f(this.$pid);
            str = f2 + "resources" + ((Object) File.separator);
            String q = s.q(f2, "config.json");
            MaterialInstallManager materialInstallManager = MaterialInstallManager.a;
            this.L$0 = str;
            this.label = 1;
            d2 = materialInstallManager.d(q, this);
            if (d2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            if (i2 == 2) {
                kotlin.j.b(obj);
                return u.a;
            } else if (i2 == 3) {
                kotlin.j.b(obj);
                return u.a;
            } else if (i2 != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                kotlin.j.b(obj);
                return u.a;
            }
        } else {
            String str2 = (String) this.L$0;
            kotlin.j.b(obj);
            str = str2;
            d2 = obj;
        }
        MaterialConfig materialConfig = (MaterialConfig) d2;
        if (materialConfig == null) {
            g2 c2 = z0.c();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$installAction, this.$material, this.$msg, null);
            this.L$0 = null;
            this.label = 2;
            if (kotlinx.coroutines.j.g(c2, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return u.a;
        }
        this.$material.setBrushSizeCalculateMode(materialConfig.getBrushSizeCalculateMode());
        this.$material.setBrushSourceType(materialConfig.getBrushSourceType());
        this.$material.setPaintIntervalRatio(materialConfig.getPaintIntervalRatio());
        this.$material.setBrushDefaultEffectIntensity(materialConfig.getBrushDefaultEffectIntensity());
        this.$material.setAutoAdjustPaintInterval(materialConfig.getAutoAdjustPaintInterval());
        this.$material.setEnableRandomSpriteIndex(materialConfig.getEnableRandomSpriteIndex());
        this.$material.setEnableRotate(materialConfig.getEnableRotate());
        this.$material.setBrushSizeRatio(materialConfig.getBrushSizeRatio());
        this.$material.setBrushEffectIntensity(materialConfig.getBrushEffectIntensity());
        this.$material.setResourceFolderPath(str);
        this.$material.setResourceChildPath(materialConfig.getResourceChildPath());
        this.$material.setResourceChildBlendMode(materialConfig.getResourceChildBlendMode());
        this.$material.setBrushColor(materialConfig.getBrushColor());
        this.$material.setSupportChangeColor(materialConfig.getSupportChangeColor());
        this.$material.setEnableFlow(materialConfig.getEnableFlow());
        this.$material.setBrushBlendMode(materialConfig.getBrushBlendMode());
        this.$material.setBrushDisplaySizeRatio(materialConfig.getBrushDisplaySizeRatio());
        PaintMaterial paintMaterial = this.$material;
        us.pinguo.repository2020.database.a.a().B().b(new PaintMaterialTable(this.$pid, paintMaterial.getIcon(), paintMaterial.getResourceFolderPath(), GsonUtilKt.getCachedGson().s(paintMaterial.getResourceChildPath()), GsonUtilKt.getCachedGson().s(paintMaterial.getResourceChildBlendMode()), paintMaterial.getAutoAdjustPaintInterval(), paintMaterial.getBrushSizeCalculateMode(), paintMaterial.getBrushSourceType(), paintMaterial.getEnableRandomSpriteIndex(), paintMaterial.getEnableRotate(), paintMaterial.getPaintIntervalRatio(), paintMaterial.getBrushDefaultEffectIntensity(), paintMaterial.getBrushEffectIntensity(), paintMaterial.getBrushSizeRatio(), paintMaterial.getBrushDisplaySizeRatio(), paintMaterial.getBrushColor(), paintMaterial.getEnableFlow(), paintMaterial.getBrushBlendMode(), paintMaterial.getSupportChangeColor()));
        if (this.$material.getInstallState() == null) {
            this.$material.setInstallState(new ObservableField<>(MaterialInstallState.STATE_INSTALLED));
        } else {
            ObservableField<MaterialInstallState> installState = this.$material.getInstallState();
            if (installState != null) {
                installState.set(MaterialInstallState.STATE_INSTALLED);
            }
        }
        g2 c3 = z0.c();
        AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.$installAction, this.$material, null);
        this.L$0 = null;
        this.label = 4;
        if (kotlinx.coroutines.j.g(c3, anonymousClass4, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return u.a;
    }
}

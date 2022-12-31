package com.googlecode.mp4parser;

import org.aspectj.lang.NoAspectBoundException;
import org.aspectj.lang.a;
/* loaded from: classes2.dex */
public class RequiresParseDetailAspect {
    private static /* synthetic */ Throwable ajc$initFailureCause;
    public static final /* synthetic */ RequiresParseDetailAspect ajc$perSingletonInstance = null;

    static {
        try {
            ajc$postClinit();
        } catch (Throwable th) {
            ajc$initFailureCause = th;
        }
    }

    private static /* synthetic */ void ajc$postClinit() {
        ajc$perSingletonInstance = new RequiresParseDetailAspect();
    }

    public static RequiresParseDetailAspect aspectOf() {
        RequiresParseDetailAspect requiresParseDetailAspect = ajc$perSingletonInstance;
        if (requiresParseDetailAspect != null) {
            return requiresParseDetailAspect;
        }
        throw new NoAspectBoundException("com.googlecode.mp4parser.RequiresParseDetailAspect", ajc$initFailureCause);
    }

    public static boolean hasAspect() {
        return ajc$perSingletonInstance != null;
    }

    public void before(a aVar) {
        if (aVar.a() instanceof AbstractBox) {
            if (((AbstractBox) aVar.a()).isParsed()) {
                return;
            }
            ((AbstractBox) aVar.a()).parseDetails();
            return;
        }
        throw new RuntimeException("Only methods in subclasses of " + AbstractBox.class.getName() + " can  be annotated with ParseDetail");
    }
}

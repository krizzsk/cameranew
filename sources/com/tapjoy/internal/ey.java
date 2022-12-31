package com.tapjoy.internal;
/* loaded from: classes3.dex */
public enum ey implements em {
    APP(0),
    CAMPAIGN(1),
    CUSTOM(2),
    USAGES(3);
    
    public static final ej ADAPTER = new ef() { // from class: com.tapjoy.internal.ey.a
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tapjoy.internal.ef
        public final /* bridge */ /* synthetic */ em a(int i2) {
            return ey.a(i2);
        }
    };
    private final int a;

    ey(int i2) {
        this.a = i2;
    }

    public static ey a(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return null;
                    }
                    return USAGES;
                }
                return CUSTOM;
            }
            return CAMPAIGN;
        }
        return APP;
    }

    @Override // com.tapjoy.internal.em
    public final int a() {
        return this.a;
    }
}

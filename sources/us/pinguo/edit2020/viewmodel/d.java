package us.pinguo.edit2020.viewmodel;

import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.repository2020.database.staticsticker.StaticStickerCategory;
/* compiled from: StaticStickerStoreViewModel.kt */
/* loaded from: classes4.dex */
public abstract class d {

    /* compiled from: StaticStickerStoreViewModel.kt */
    /* loaded from: classes4.dex */
    public static final class a extends d {
        public a(boolean z) {
            super(null);
        }
    }

    /* compiled from: StaticStickerStoreViewModel.kt */
    /* loaded from: classes4.dex */
    public static final class b extends d {
        private final StaticStickerCategory a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(StaticStickerCategory stickerCategory) {
            super(null);
            s.h(stickerCategory, "stickerCategory");
            this.a = stickerCategory;
        }

        public final StaticStickerCategory a() {
            return this.a;
        }
    }

    /* compiled from: StaticStickerStoreViewModel.kt */
    /* loaded from: classes4.dex */
    public static final class c extends d {
        public c() {
            super(null);
        }
    }

    private d() {
    }

    public /* synthetic */ d(o oVar) {
        this();
    }
}

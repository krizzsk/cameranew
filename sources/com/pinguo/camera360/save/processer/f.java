package com.pinguo.camera360.save.processer;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import com.pinguo.camera360.effect.model.entity.Effect;
import com.pinguo.lib.PGDisplayUtils;
import us.pinguo.camera360.shop.data.FilterType;
import us.pinguo.camera360.shop.data.g;
import us.pinguo.camera360.shop.data.i;
import us.pinguo.loc.EffectLocManager;
import us.pinguo.poker.l;
import us.pinguo.poker.n;
import us.pinguo.poker.o;
import us.pinguo.poker.s;
import us.pinguo.repository2020.utils.k;
import us.pinguo.util.v;
import vStudio.Android.Camera360.R;
/* compiled from: ProcessorOldProxy.kt */
/* loaded from: classes3.dex */
public final class f implements us.pinguo.processor.k.c {
    private us.pinguo.processor.k.d a;

    /* compiled from: ProcessorOldProxy.kt */
    /* loaded from: classes3.dex */
    public static final class a implements n {
        final /* synthetic */ us.pinguo.processor.k.d b;

        a(us.pinguo.processor.k.d dVar) {
            this.b = dVar;
        }

        @Override // us.pinguo.poker.n
        public void a(byte[] bArr, String str) {
            f.this.a = null;
            if (bArr == null) {
                this.b.a(null, v.f(R.string.network_error));
                return;
            }
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 1;
                options.inJustDecodeBounds = false;
                options.inDither = false;
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                this.b.a(BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options), null);
            } catch (Throwable unused) {
                this.b.a(null, v.f(R.string.network_error));
            }
        }

        @Override // us.pinguo.poker.n
        public void b(int i2, String str) {
            f.this.a = null;
            this.b.a(null, v.f(R.string.network_error));
        }

        @Override // us.pinguo.poker.n
        public void c(s sVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(f this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        us.pinguo.processor.k.d dVar = this$0.a;
        if (dVar != null) {
            dVar.a(null, v.f(R.string.poker_cancel));
        }
        this$0.a = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(us.pinguo.processor.k.d callback, com.pinguo.camera360.m.b bVar, Bitmap bitmap, Bitmap bitmap2, Throwable th) {
        kotlin.jvm.internal.s.h(callback, "$callback");
        callback.a(bitmap, th == null ? null : th.getMessage());
        if (bitmap == null) {
            us.pinguo.common.log.a.g("Frisky", "做图失败", new Object[0]);
        } else {
            us.pinguo.common.log.a.g("Frisky", "做图成功", new Object[0]);
        }
    }

    @Override // us.pinguo.processor.k.c
    public boolean a(us.pinguo.processor.d makeInfo) {
        kotlin.jvm.internal.s.h(makeInfo, "makeInfo");
        g j2 = i.e().j(makeInfo.a());
        Effect effect = j2 instanceof Effect ? (Effect) j2 : null;
        return effect != null && effect.isOnLineEffect(Effect.Version.latest);
    }

    @Override // us.pinguo.processor.k.c
    public void b() {
        EffectLocManager.getInstance().n(false);
    }

    @Override // us.pinguo.processor.k.c
    public boolean c(String key) {
        kotlin.jvm.internal.s.h(key, "key");
        g j2 = i.e().j(key);
        if (j2 != null && (j2 instanceof Effect)) {
            Effect effect = (Effect) j2;
            return effect.isOnLineEffect(Effect.Version.latest) || effect.getFliterType() == FilterType.Loc;
        }
        return false;
    }

    @Override // us.pinguo.processor.k.c
    public void d(byte[] jpg, us.pinguo.processor.d makeInfo, final us.pinguo.processor.k.d callback) {
        kotlin.jvm.internal.s.h(jpg, "jpg");
        kotlin.jvm.internal.s.h(makeInfo, "makeInfo");
        kotlin.jvm.internal.s.h(callback, "callback");
        this.a = null;
        com.pinguo.camera360.m.b bVar = new com.pinguo.camera360.m.b();
        bVar.y(0);
        bVar.n(makeInfo.a());
        bVar.B(0);
        bVar.D(System.currentTimeMillis());
        bVar.z(PGDisplayUtils.getPreviewLength());
        Point m = us.pinguo.util.e.m(jpg);
        bVar.x(new com.pinguo.camera360.k.a.a.a.b(m.x, m.y));
        g j2 = i.e().j(makeInfo.a());
        if (j2 == null) {
            callback.a(null, v.f(R.string.not_exist_filter));
        } else if (!(j2 instanceof Effect)) {
            callback.a(null, v.f(R.string.not_exist_filter));
        } else {
            Effect effect = (Effect) j2;
            if (effect.isOnLineEffect(Effect.Version.latest)) {
                this.a = callback;
                d.d(jpg, bVar, new a(callback));
            } else if (effect.getFliterType() == FilterType.Loc) {
                k.a.b();
                d.c(jpg, bVar, new com.pinguo.camera360.m.c.a() { // from class: com.pinguo.camera360.save.processer.c
                    @Override // com.pinguo.camera360.m.c.a
                    public final void a(com.pinguo.camera360.m.b bVar2, Bitmap bitmap, Bitmap bitmap2, Throwable th) {
                        f.j(us.pinguo.processor.k.d.this, bVar2, bitmap, bitmap2, th);
                    }
                });
            } else {
                callback.a(null, "not support");
            }
        }
    }

    @Override // us.pinguo.processor.k.c
    public boolean e() {
        if (this.a != null) {
            o.e().b(new l() { // from class: com.pinguo.camera360.save.processer.b
                @Override // us.pinguo.poker.l
                public final void a() {
                    f.g(f.this);
                }
            });
        } else {
            EffectLocManager.getInstance().n(true);
        }
        return true;
    }
}

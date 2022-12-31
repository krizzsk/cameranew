package us.pinguo.common.filter.util;

import com.pinguo.camera360.effect.model.entity.Effect;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import kotlin.text.t;
import us.pinguo.foundation.utils.NoProguard;
import us.pinguo.processor.d;
import us.pinguo.repository2020.database.filter.FilterParamsTable;
import us.pinguo.repository2020.entity.BaseFilter;
/* compiled from: FilterParamsHelper.kt */
/* loaded from: classes4.dex */
public final class FilterParamsHelper {
    public static final a c = new a(null);
    private final FilterParamsTable a;
    private final BaseFilter b;

    /* compiled from: FilterParamsHelper.kt */
    /* loaded from: classes4.dex */
    public static final class Texture implements NoProguard {
        private final ArrayList<TextureItem> items;
        private final Integer rule;

        public Texture(Integer num, ArrayList<TextureItem> arrayList) {
            this.rule = num;
            this.items = arrayList;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Texture copy$default(Texture texture, Integer num, ArrayList arrayList, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                num = texture.rule;
            }
            if ((i2 & 2) != 0) {
                arrayList = texture.items;
            }
            return texture.copy(num, arrayList);
        }

        public final Integer component1() {
            return this.rule;
        }

        public final ArrayList<TextureItem> component2() {
            return this.items;
        }

        public final Texture copy(Integer num, ArrayList<TextureItem> arrayList) {
            return new Texture(num, arrayList);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Texture) {
                Texture texture = (Texture) obj;
                return s.c(this.rule, texture.rule) && s.c(this.items, texture.items);
            }
            return false;
        }

        public final ArrayList<TextureItem> getItems() {
            return this.items;
        }

        public final Integer getRule() {
            return this.rule;
        }

        public int hashCode() {
            Integer num = this.rule;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            ArrayList<TextureItem> arrayList = this.items;
            return hashCode + (arrayList != null ? arrayList.hashCode() : 0);
        }

        public String toString() {
            return "Texture(rule=" + this.rule + ", items=" + this.items + ')';
        }
    }

    /* compiled from: FilterParamsHelper.kt */
    /* loaded from: classes4.dex */
    public static final class TextureItem implements NoProguard {
        private final int enableRotation;
        private final int index;
        private final String name;
        private final Integer type;

        public TextureItem(int i2, String str, Integer num, int i3) {
            this.enableRotation = i2;
            this.name = str;
            this.type = num;
            this.index = i3;
        }

        public static /* synthetic */ TextureItem copy$default(TextureItem textureItem, int i2, String str, Integer num, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i2 = textureItem.enableRotation;
            }
            if ((i4 & 2) != 0) {
                str = textureItem.name;
            }
            if ((i4 & 4) != 0) {
                num = textureItem.type;
            }
            if ((i4 & 8) != 0) {
                i3 = textureItem.index;
            }
            return textureItem.copy(i2, str, num, i3);
        }

        public final int component1() {
            return this.enableRotation;
        }

        public final String component2() {
            return this.name;
        }

        public final Integer component3() {
            return this.type;
        }

        public final int component4() {
            return this.index;
        }

        public final TextureItem copy(int i2, String str, Integer num, int i3) {
            return new TextureItem(i2, str, num, i3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TextureItem) {
                TextureItem textureItem = (TextureItem) obj;
                return this.enableRotation == textureItem.enableRotation && s.c(this.name, textureItem.name) && s.c(this.type, textureItem.type) && this.index == textureItem.index;
            }
            return false;
        }

        public final int getEnableRotation() {
            return this.enableRotation;
        }

        public final int getIndex() {
            return this.index;
        }

        public final String getName() {
            return this.name;
        }

        public final Integer getType() {
            return this.type;
        }

        public int hashCode() {
            int i2 = this.enableRotation * 31;
            String str = this.name;
            int hashCode = (i2 + (str == null ? 0 : str.hashCode())) * 31;
            Integer num = this.type;
            return ((hashCode + (num != null ? num.hashCode() : 0)) * 31) + this.index;
        }

        public String toString() {
            return "TextureItem(enableRotation=" + this.enableRotation + ", name=" + ((Object) this.name) + ", type=" + this.type + ", index=" + this.index + ')';
        }

        public /* synthetic */ TextureItem(int i2, String str, Integer num, int i3, int i4, o oVar) {
            this((i4 & 1) != 0 ? 0 : i2, str, num, (i4 & 8) != 0 ? 0 : i3);
        }
    }

    /* compiled from: FilterParamsHelper.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }

        public final d a() {
            List h2;
            h2 = u.h();
            return new d(Effect.EFFECT_FILTER_NONE_KEY, "Effect=Normal", h2, false, 8, null);
        }
    }

    public FilterParamsHelper(FilterParamsTable paramsTable, BaseFilter filter) {
        s.h(paramsTable, "paramsTable");
        s.h(filter, "filter");
        this.a = paramsTable;
        this.b = filter;
    }

    public final String a() {
        return this.a.getId();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0086 A[Catch: Exception -> 0x0103, TryCatch #0 {Exception -> 0x0103, blocks: (B:5:0x000a, B:13:0x002b, B:14:0x0038, B:16:0x003e, B:18:0x0056, B:20:0x007a, B:26:0x0086, B:28:0x0097, B:35:0x00ae, B:38:0x00b7, B:42:0x00d2, B:41:0x00c6, B:31:0x009f, B:34:0x00a8, B:8:0x0020), top: B:48:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<us.pinguo.processor.f> b() {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.common.filter.util.FilterParamsHelper.b():java.util.List");
    }

    public final String c(boolean z) {
        String gpuCmd;
        boolean x;
        if (z) {
            gpuCmd = this.a.getPreCmd();
            if (gpuCmd == null) {
                gpuCmd = "Effect=NONE_PREVIEW";
            }
        } else if (s.c(this.b.getFilterId(), "59aa2c6dc17fb05e3b95eda2")) {
            gpuCmd = "Portrait_AutoLevel|Effect=SkinSoft2;Curve0=<A>10=0,127=150</A>;whiteLevel=0.4;guassFrame=<PyramidLevel>4</PyramidLevel><StandLength>400</StandLength><StandAmount>5</StandAmount>";
        } else {
            gpuCmd = this.a.getGpuCmd();
            if (gpuCmd == null) {
                gpuCmd = "Effect=Normal";
            }
        }
        x = t.x(gpuCmd, Effect.PREFIX, false, 2, null);
        return !x ? s.q(Effect.PREFIX, gpuCmd) : gpuCmd;
    }
}

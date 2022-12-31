package us.pinguo.repository2020;

import com.pinguo.camera360.effect.model.entity.Effect;
import com.tapjoy.TapjoyConstants;
import com.tencent.matrix.trace.config.SharePluginInfo;
import java.util.ArrayList;
import us.pinguo.repository2020.entity.FilterEntry;
import us.pinguo.repository2020.entity.FilterItem;
import us.pinguo.repository2020.entity.PackageItem;
/* compiled from: FilterConstants.kt */
/* loaded from: classes6.dex */
public final class FilterConstants {
    public static final FilterConstants a = new FilterConstants();
    private static final PackageItem b = new PackageItem("my", Effect.EFFECT_FILTER_AUTO_KEY, "", "", false, 0, 1, false, false, 0, 0, 0, 0, 896, null);
    private static final PackageItem c = new PackageItem("my", Effect.EFFECT_FILTER_NONE_KEY, "", "", false, 0, 1, false, false, 0, 0, 0, 0, 896, null);

    /* renamed from: d  reason: collision with root package name */
    private static final FilterItem f11799d = new FilterItem("package_none_and_auto", Effect.EFFECT_FILTER_NONE_KEY, "", "", false, false, 0, 1, 0, 0, 0, 0);

    /* renamed from: e  reason: collision with root package name */
    private static final FilterItem f11800e = new FilterItem("package_none_and_auto", Effect.EFFECT_FILTER_AUTO_KEY, "", "", false, false, 0, 1, 0, 0, 0, 0);

    /* renamed from: f  reason: collision with root package name */
    private static final FilterEntry f11801f = new FilterEntry("", "5db94be6f34b85ce4cfe2b50", "5dc0edaa9ac5306379b9bd81");

    /* renamed from: g  reason: collision with root package name */
    private static final FilterEntry f11802g = new FilterEntry("", "5836bbbdb773028b3d368c98", "596ef84dd17f2f860a157809");

    /* renamed from: h  reason: collision with root package name */
    private static final FilterEntry f11803h = new FilterEntry("my", "package_none_and_auto", Effect.EFFECT_FILTER_NONE_KEY);

    /* renamed from: i  reason: collision with root package name */
    private static final FilterEntry f11804i = new FilterEntry("my", "package_none_and_auto", Effect.EFFECT_FILTER_AUTO_KEY);

    /* renamed from: j  reason: collision with root package name */
    private static final ArrayList<String> f11805j;

    /* renamed from: k  reason: collision with root package name */
    private static final ArrayList<String> f11806k;

    /* renamed from: l  reason: collision with root package name */
    private static final ArrayList<String> f11807l;

    /* compiled from: FilterConstants.kt */
    /* loaded from: classes6.dex */
    public enum FilterCellType {
        DEVIDE,
        NONE_OR_AUTO,
        FILTER
    }

    /* compiled from: FilterConstants.kt */
    /* loaded from: classes6.dex */
    public enum FilterType {
        Effect("effect", "ft"),
        Sticker(TapjoyConstants.TJC_PLUGIN_UNITY, "ut"),
        Scene(SharePluginInfo.ISSUE_SCENE, "stp"),
        Combin("combin", "cn"),
        AEffect("aeffect", "ae"),
        Loc("loc", "loc");
        
        public static final a Companion = new a(null);
        private final String subt;
        private final String type;

        /* compiled from: FilterConstants.kt */
        /* loaded from: classes6.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
                this();
            }

            public final FilterType a(String str) {
                FilterType filterType = FilterType.Effect;
                if (kotlin.jvm.internal.s.c(str, filterType.getType())) {
                    return filterType;
                }
                FilterType filterType2 = FilterType.Sticker;
                if (!kotlin.jvm.internal.s.c(str, filterType2.getType())) {
                    filterType2 = FilterType.Scene;
                    if (!kotlin.jvm.internal.s.c(str, filterType2.getType())) {
                        filterType2 = FilterType.Combin;
                        if (!kotlin.jvm.internal.s.c(str, filterType2.getType())) {
                            filterType2 = FilterType.AEffect;
                            if (!kotlin.jvm.internal.s.c(str, filterType2.getType())) {
                                filterType2 = FilterType.Loc;
                                if (!kotlin.jvm.internal.s.c(str, filterType2.getType())) {
                                    return filterType;
                                }
                            }
                        }
                    }
                }
                return filterType2;
            }

            public final FilterType b(String subt) {
                kotlin.jvm.internal.s.h(subt, "subt");
                FilterType filterType = FilterType.Effect;
                if (kotlin.jvm.internal.s.c(subt, filterType.getSubt())) {
                    return filterType;
                }
                FilterType filterType2 = FilterType.Sticker;
                if (kotlin.jvm.internal.s.c(subt, filterType2.getSubt())) {
                    return filterType2;
                }
                FilterType filterType3 = FilterType.Scene;
                if (kotlin.jvm.internal.s.c(subt, filterType3.getSubt())) {
                    return filterType3;
                }
                FilterType filterType4 = FilterType.Combin;
                if (kotlin.jvm.internal.s.c(subt, filterType4.getSubt())) {
                    return filterType4;
                }
                FilterType filterType5 = FilterType.AEffect;
                if (kotlin.jvm.internal.s.c(subt, filterType5.getSubt())) {
                    return filterType5;
                }
                FilterType filterType6 = FilterType.Loc;
                if (kotlin.jvm.internal.s.c(subt, filterType6.getSubt())) {
                    return filterType6;
                }
                return null;
            }

            public final boolean c(String str) {
                return kotlin.jvm.internal.s.c(str, FilterType.Effect.getSubt()) || kotlin.jvm.internal.s.c(str, FilterType.Loc.getSubt());
            }
        }

        FilterType(String str, String str2) {
            this.type = str;
            this.subt = str2;
        }

        public final String getSubt() {
            return this.subt;
        }

        public final String getType() {
            return this.type;
        }
    }

    static {
        ArrayList<String> f2;
        ArrayList<String> f3;
        ArrayList<String> f4;
        f2 = kotlin.collections.u.f("58369d3f4b58d53e4df91938", "5836bbc2b773028b3d368cb0", "5836bbc3b773028b3d368cb3", "5836bbc8b773028b3d368cc5", "5fcdfe374085d3b610dcebb0", "5fcdfc2a3e85d3240cfff7fd", "5fcdf000451816fd2cdbd013", "5fcded374085d38610dcebbb", "5dd49cbcecf8c3402fa743a6", "5dd49a349ac5305506b9b3bd", "6000072bc28b15906c6a2c57", "600002897d85d3860a9b1160", "5ffff46b7b85d3a50f01c053", "5ffff699e3ff142a618d8bbb", "60e7c63f451816f951dbcff8", "60d1c5ba6c1744492b1062c6", "5dba53d5ecf8c3627da73d92", "5c99e84c7464002a082f1193", "5e69a0bdf34b85f930fe4617", "5e69a0a0f34b852164fe260a");
        f11805j = f2;
        f3 = kotlin.collections.u.f("6318a806871744557c23a538", "6318a81f871744c67923a534", "6318a83b8617441a7e6690fb", "6318a8486d1744890e8236ab", "6318a855a717443d0f08112d", "6318a864861744657f6690fc", "6318a878a81744560f59db7f", "6318a883e3ff140d1f8d8bb0", "6318a88da81744430f59db7f", "6318a8998f1744570ff88e73", "6318a8a3451816156adbcfff", "6318a8aec28b15227f6a2c4d", "6318a8b8a81744540f59db7f", "6318a8c26e17443d7fb4a1ce", "6318a8cc8f1744430ff88e6f", "6318a8d66e17440b7fb4a1d0", "6318a8e2a81744540f59db80", "6318a8f66d1744cf0e8236a6", "6318a9056d17443e108236a8", "6318a91c6e17447902b4a1c9", "6318a9288f1744440ff88e76", "6318a931a71744470f08112c", "6318a93be3ff14141f8d8bb4", "6318a9458f1744460ff88e73", "6318a9a4451816fa69dbcffd", "6318a9b06e1744d67fb4a1cc", "6318aa06a71744330f08112e", "6318aa386c17443a4dd967cc", "6318aa426e1744a27db4a1cd", "6318aa536e1744c702b4a1ce", "6318aa5c451816f669dbcfff", "6318aa65c28b15387f6a2c4c", "6318aa6fe3ff140d1f8d8bb1", "6318aa7e861744657f6690fd", "6318aa888e17444b0fd116f3", "6318aa926c1744244cd967d1", "6318ab386c17445c4ad967d1", "6318ab418f17444e0ff88e71", "6318ab4da71744390f08112e", "6318ab588f17444d0ff88e71", "6318ab61871744b67a23a52c", "6318ab6c6d1744770d8236a3", "6318ab76871744987823a531", "6318ab7f861744ed7f6690f5", "6318ab88a717444a0f08112f", "6318ab91871744197923a530", "6318acaa8e1744400fd116f0", "6318acb48e1744560fd116f1", "6318acbda81744580f59db7f", "6318acc78e17444a0fd116f0", "6318acd0451816fa69dbcffe", "6318acda6e1744247fb4a1ca", "6318ace4a717443f0f08112f", "6318aced861744c07f6690fd", "6318acf78e17445d0fd116f4", "6318ad016c17449c4ed967cb", "6318ad0ee3ff141c1f8d8bb1", "6318ad1be3ff14241f8d8bb0", "6318ad248f1744430ff88e70", "6318ad2d4518160c6adbcffc", "6318ad368e17444a0fd116f1", "6318ad40a717442f0f08112e", "6318ad49a817443d0f59db80", "6318ad52e3ff140e1f8d8bb0", "6318ad5c6e1744027fb4a1ca", "6318ad65a71744490f08112d", "6318ad716c1744244cd967d2", "6318ad7a451816026adbd000", "6318ad8c6d17448b0e8236a8", "6318ad988f1744480ff88e71", "6318ae858e17445d0fd116f5", "6318ae8f451816f769dbd009", "6318ae9b6c1744334dd967d0", "6318aea48f1744410ff88e73", "6318aeb96e17447601b4a1cc", "6318aec56d17440a0e8236a7", "6318af6fc28b15387f6a2c4e", "6318af796e1744e101b4a1c9", "6318af846c1744a24bd967d2", "6318b01be3ff141e1f8d8baf", "6318b0a18e17443f0fd116f4", "6318b0ab6c17442f4bd967d0", "6318b0b9a81744450f59db81", "6318b0c4a71744470f08112e", "6318b0cd871744c67923a536", "6318b0d76d1744890e8236ac", "6318b0e1e3ff14271f8d8bb3", "6318b0eb6e17442f01b4a1cc", "6318b0f48e1744580fd116f2", "6318b0fda81744430f59db82", "6318b107c28b15257f6a2c4b", "6318b110451816026adbd001", "6318b11aa71744440f08112c", "6318b124e3ff140f1f8d8bb1", "6318b138e3ff14151f8d8bb4", "6318b1428e1744440fd116f2", "6318b14f871744127923a531", "6318b15da81744520f59db81", "6318b166e3ff14141f8d8bb7", "6318b175c28b15207f6a2c53", "59aa2bac4293301a09553bd3", "5dc0ed8efb27041d5cd69201", "611b4dad861744667874787e", "611b4da64518162a6edbcff8", "611b4d9e6a1744fc4ce0b0a7", "611b4d934518161b6edbcff9", "611b4d8b6a1744324ce0b0a5", "611b4d82228063f50e14567f", "611b4d7c6a1744ad4ce0b0a4", "611b4d74e3ff14f13f8d8bab", "611b4d6e451816346edbcffa", "611b4d676e1744397485423b", "611b4d5f228063f40e145680", "611b4d56228063f30e14567f", "611b4d4fe3ff14f23f8d8bac", "611b4d48228063f40e14567f", "611b4d41e3ff14e33f8d8bad", "611b4d39451816306edbcff6", "611b4d328617444277747887", "611b4d2b8f1744fc0ef2c115", "611b4d248617449077747885", "611b4d1ae3ff14fa3f8d8bad", "611b4d12e3ff14e73f8d8ba9", "611b4d08e3ff14e83f8d8ba8", "61cbfc79261744120f2a8f44", "61cbfc812417446e71235ecc", "61cbfc89c28b15dd716a2c48", "61cbfc90c28b15ed716a2c49", "61cbfc97291744f90e278414", "61cbfc9f261744050f2a8f49", "61cbfca7e3ff1474758d8baa", "61cbfcaf271744ee0ef4958c", "61cbfcb8271744f50ef4959a", "61cbfcc0291744e40e278413", "61cbfcc9451816e954dbcffa", "61cbfcd0c28b15d6716a2c48", "61cbfcd8291744f90e278415", "61cbfcdf451816e954dbcffc", "61cbfce6271744040ff4958a", "61cbfcee251744e772cd2b34", "61cbfcf5281744e70ea9c425", "61cbfcfce3ff146f758d8bab", "61cbfd0be3ff1477758d8baa", "61cbfd13e3ff146a758d8ba8", "61e11643c28b15f3566a2c4e", "61e1164ba81744150f86c937", "61e11652a71744f70e3eeda1", "61e1165be3ff1464038d8bae", "61e1165be3ff1464038d8bae", "61e11673a71744fa0e3eed9e", "61e1167bc28b1515576a2c47", "61e11683a81744030f86c937", "61e1168b451816123cdbcff8", "61e11694a71744fa0e3eed9f", "61e1169e4518160f3cdbcffc", "61e116a7a81744fb0e86c937", "61e116b6c28b15ff566a2c46", "61e116bf8f1744f70ee36497", "61e116c7c28b1501576a2c4a", "61e116cf8e1744f30ec5ec51", "61e116dae3ff147e038d8bb0", "61e116e38f1744ec0ee36492", "61e116ec8e1744010fc5ec4f", "61e116f4c28b1504576a2c4c", "61e116fdc28b15f5566a2c48", "61e117058d1744070f00b19e", "61e1170ea817440b0f86c937", "61e117178f1744f10ee36496", "61e1171fc28b1505576a2c47", "61e11727a71744ec0e3eed9d", "61e1172f8f1744f90ee3648f", "61e11737a717440d0f3eed9f", "61e11741a71744eb0e3eed9d", "61e1174b8e1744ec0ec5ec60", "61e117558f1744e50ee3649a", "61e1175d8f1744030fe36495", "61e117654518161a3cdbcff7", "61e1176dc28b1503576a2c4d", "61e11775c28b15f9566a2c48", "61e1177de3ff145b038d8bad", "61e11785a81744040f86c937", "61e1178da81744f90e86c939", "61e117958d1744000f00b19e", "61e1179d8d1744f10e00b199", "61e117a5a717440d0f3eeda0", "61e117ada71744fd0e3eeda1", "61e117b68d17440e0f00b1a2", "61e117bea81744150f86c938", "61e117c68d1744040f00b19b", "61e117cd451816333cdbcff7", "61e117d5a81744fd0e86c937", "61e117dd8e1744f10ec5ec53", "61e117e5c28b15fc566a2c4c", "61e117ee8d1744040f00b19c");
        f11806k = f3;
        f4 = kotlin.collections.u.f("60e7c63f451816f951dbcff8", "60d1c5ba6c1744492b1062c6");
        f11807l = f4;
    }

    private FilterConstants() {
    }

    public static final FilterEntry c() {
        return f11804i;
    }

    public static final FilterEntry d() {
        return f11802g;
    }

    public static final FilterEntry e() {
        return f11801f;
    }

    public static final FilterEntry f() {
        return f11803h;
    }

    public final FilterItem a() {
        return f11800e;
    }

    public final FilterItem b() {
        return f11799d;
    }

    public final ArrayList<String> g() {
        return f11806k;
    }

    public final ArrayList<String> h() {
        return f11805j;
    }

    public final ArrayList<String> i() {
        return f11807l;
    }

    public final PackageItem j() {
        return b;
    }

    public final PackageItem k() {
        return c;
    }
}

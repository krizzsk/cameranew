package us.pinguo.blockbuster.lib.domain;

import com.google.gson.e;
import com.google.gson.m;
import java.util.List;
import us.pinguo.blockbuster.lib.domain.struct.AutoBeautyStruct;
import us.pinguo.blockbuster.lib.domain.struct.BoundrayLightStruct;
import us.pinguo.blockbuster.lib.domain.struct.ColorShadingStruct;
import us.pinguo.blockbuster.lib.domain.struct.EdgeStruct;
import us.pinguo.blockbuster.lib.domain.struct.HandleAlphaStruct;
import us.pinguo.blockbuster.lib.domain.struct.ReplaceAlphaStruct;
import us.pinguo.blockbuster.lib.domain.struct.Struct;
import us.pinguo.blockbuster.lib.domain.struct.filter.FilterStruct;
import us.pinguo.blockbuster.lib.domain.struct.hair.HairStruct;
import us.pinguo.blockbuster.lib.domain.struct.makeup.MakeupStruct;
import us.pinguo.blockbuster.lib.domain.struct.mix.MixStruct;
import us.pinguo.blockbuster.lib.domain.struct.shiftedmaskeffect.ShiftedMaskEffectStruct;
/* loaded from: classes3.dex */
public class Node {
    public List<Input> input;
    private Struct mStruct;
    public int nodeId;
    public Output output;
    private m struct;

    private Struct parseStruct(m mVar) {
        int a = mVar.k("paramType").a();
        if (a == 2) {
            return (Struct) new e().j(mVar.toString(), MakeupStruct.class);
        }
        if (a == 4) {
            return (Struct) new e().j(mVar.toString(), HairStruct.class);
        }
        if (a == 0) {
            return (Struct) new e().j(mVar.toString(), FilterStruct.class);
        }
        if (a == 5) {
            return (Struct) new e().j(mVar.toString(), ReplaceAlphaStruct.class);
        }
        if (a == 1) {
            return (Struct) new e().j(mVar.toString(), MixStruct.class);
        }
        if (a == 8) {
            return (Struct) new e().j(mVar.toString(), AutoBeautyStruct.class);
        }
        if (a == 6) {
            return (Struct) new e().j(mVar.toString(), ShiftedMaskEffectStruct.class);
        }
        if (a == 7) {
            return (Struct) new e().j(mVar.toString(), EdgeStruct.class);
        }
        if (a == 3) {
            return (Struct) new e().j(mVar.toString(), BoundrayLightStruct.class);
        }
        if (a == 9) {
            return (Struct) new e().j(mVar.toString(), ColorShadingStruct.class);
        }
        if (a == 10) {
            return (Struct) new e().j(mVar.toString(), HandleAlphaStruct.class);
        }
        return null;
    }

    public Struct getStruct() {
        if (this.mStruct == null) {
            this.mStruct = parseStruct(this.struct);
        }
        return this.mStruct;
    }

    public void setStruct(m mVar) {
        this.struct = mVar;
    }
}

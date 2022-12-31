package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.coremedia.iso.Hex;
import com.growingio.android.sdk.monitor.BuildConfig;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Logger;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
@Descriptor(tags = {19, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, InspirePublishFragment.MAX_DESC_COUNT, 141, 142, 143, IjkMediaMeta.FF_PROFILE_H264_HIGH_444, BuildConfig.VERSION_CODE, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, BaseBlurEffect.ROTATION_180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243, IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, 245, 246, 247, 248, 249, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 251, 252, 253})
/* loaded from: classes2.dex */
public class ExtensionDescriptor extends BaseDescriptor {
    private static Logger log = Logger.getLogger(ExtensionDescriptor.class.getName());
    byte[] bytes;

    static int[] allTags() {
        int[] iArr = new int[148];
        for (int i2 = 106; i2 < 254; i2++) {
            int i3 = i2 - 106;
            log.finest("pos:" + i3);
            iArr[i3] = i2;
        }
        return iArr;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor
    public void parseDetail(ByteBuffer byteBuffer) throws IOException {
        if (getSize() > 0) {
            byte[] bArr = new byte[this.sizeOfInstance];
            this.bytes = bArr;
            byteBuffer.get(bArr);
        }
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ExtensionDescriptor");
        sb.append("{bytes=");
        byte[] bArr = this.bytes;
        sb.append(bArr == null ? "null" : Hex.encodeHex(bArr));
        sb.append('}');
        return sb.toString();
    }
}

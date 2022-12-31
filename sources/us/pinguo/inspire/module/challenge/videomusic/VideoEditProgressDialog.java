package us.pinguo.inspire.module.challenge.videomusic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.zhy.android.percent.support.PercentLayoutHelper;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class VideoEditProgressDialog {
    public static void setProgress(AlertDialog alertDialog, float f2) {
        ((TextView) alertDialog.findViewById(R.id.video_edit_progress_txt)).setText(((int) (f2 * 100.0f)) + PercentLayoutHelper.PercentLayoutInfo.BASEMODE.PERCENT);
    }

    public static AlertDialog showProgressDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.VideoEditProgressDialog);
        View inflate = LayoutInflater.from(context).inflate(R.layout.video_edit_progress_layout, (ViewGroup) null);
        builder.setCancelable(false);
        builder.setView(inflate);
        AlertDialog create = builder.create();
        create.getWindow().setBackgroundDrawableResource(R.drawable.video_edit_progress_shape);
        create.show();
        return create;
    }
}

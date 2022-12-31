package us.pinguo.inspire.module.guide;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.balysv.materialripple.MaterialRippleLayout;
import com.facebook.drawee.backends.pipeline.c;
import com.facebook.drawee.backends.pipeline.e;
import com.google.android.material.timepicker.TimeModel;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import kotlin.collections.c0;
import kotlin.collections.u;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.x;
import kotlin.text.Regex;
import us.pinguo.foundation.base.SubscriptionDialog;
import us.pinguo.foundation.statistics.f;
import us.pinguo.foundation.statistics.h;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.model.StickerWorks;
import us.pinguo.inspire.widget.fresco.PhotoDraweeView;
import us.pinguo.ui.uilview.CircleImageView;
import us.pinguo.ui.uilview.PhotoImageView;
import vStudio.Android.Camera360.R;
/* compiled from: ChallengeGuideDialog.kt */
/* loaded from: classes9.dex */
public abstract class ChallengeGuideDialog extends SubscriptionDialog implements View.OnClickListener {
    private String taskId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChallengeGuideDialog(Context context) {
        super(context, R.style.ChallengeGuideDialog);
        s.h(context, "context");
        this.taskId = "";
    }

    private final CharSequence getParticipantStr(int i2) {
        List h2;
        boolean z;
        String string = getContext().getResources().getString(R.string.num_challengers);
        s.g(string, "context.resources.getStr…R.string.num_challengers)");
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getContext().getResources().getColor(us.pinguo.ui.R.color.yellow));
        List<String> split = new Regex(TimeModel.NUMBER_FORMAT).split(string, 0);
        if (!split.isEmpty()) {
            ListIterator<String> listIterator = split.listIterator(split.size());
            while (listIterator.hasPrevious()) {
                if (listIterator.previous().length() == 0) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (!z) {
                    h2 = c0.S(split, listIterator.nextIndex() + 1);
                    break;
                }
            }
        }
        h2 = u.h();
        Object[] array = h2.toArray(new String[0]);
        s.f(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        int length = ((String[]) array)[0].length();
        x xVar = x.a;
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i2)}, 1));
        s.g(format, "format(format, *args)");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(format);
        spannableStringBuilder.setSpan(foregroundColorSpan, length, String.valueOf(i2).length() + length, 33);
        return spannableStringBuilder;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        f.b("challenge_intro_page", true);
    }

    public abstract void gotoCamera();

    public abstract void gotoChallenge();

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        s.h(v, "v");
        int id = v.getId();
        if (id == R.id.challengeGuideCloseBtn) {
            gotoCamera();
        } else if (id != R.id.challenge_guide_goto_challenge_child) {
        } else {
            gotoChallenge();
            h.a.B0("have_a_look", "click");
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.challenge_guide_layout);
        ((MaterialRippleLayout) findViewById(us.pinguo.inspire.R.id.challenge_guide_goto_challenge)).setOnClickListener(this);
        ((ImageView) findViewById(us.pinguo.inspire.R.id.challengeGuideCloseBtn)).setOnClickListener(this);
    }

    public final void setWorks(StickerWorks s) {
        List j2;
        s.h(s, "s");
        String str = s.getTaskInfo().taskId;
        s.g(str, "s.taskInfo.taskId");
        this.taskId = str;
        j2 = u.j((PhotoDraweeView) findViewById(us.pinguo.inspire.R.id.challenge_guild_work_img0), (PhotoDraweeView) findViewById(us.pinguo.inspire.R.id.challenge_guild_work_img1), (PhotoDraweeView) findViewById(us.pinguo.inspire.R.id.challenge_guild_work_img2), (PhotoDraweeView) findViewById(us.pinguo.inspire.R.id.challenge_guild_work_img3), (PhotoDraweeView) findViewById(us.pinguo.inspire.R.id.challenge_guild_work_img4), (PhotoDraweeView) findViewById(us.pinguo.inspire.R.id.challenge_guild_work_img5));
        int i2 = 0;
        for (Object obj : s.getItems()) {
            int i3 = i2 + 1;
            if (i2 >= 0) {
                InspireWork inspireWork = (InspireWork) obj;
                if (inspireWork.workType == 2) {
                    if (!TextUtils.isEmpty(inspireWork.webpUrl)) {
                        e L = c.h().L(inspireWork.webpUrl);
                        L.y(true);
                        ((PhotoDraweeView) j2.get(i2)).setController(L.build());
                    } else {
                        ((PhotoDraweeView) j2.get(i2)).setImageURI(PhotoImageView.addQiNiuSuffix(inspireWork.workUrl, 0, 0, true));
                    }
                } else {
                    ((PhotoDraweeView) j2.get(i2)).setImageURI(inspireWork.workUrl);
                }
                i2 = i3;
            } else {
                kotlin.collections.s.n();
                throw null;
            }
        }
        ((CircleImageView) findViewById(us.pinguo.inspire.R.id.challengeGuideIconView)).setImageUri(s.getTaskInfo().icon);
        ((TextView) findViewById(us.pinguo.inspire.R.id.challengeNameView)).setText(s.getTaskInfo().taskName);
        ((TextView) findViewById(us.pinguo.inspire.R.id.numChallengers)).setText(getParticipantStr(s.getPicSum()));
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        f.c("challenge_intro_page");
    }
}

package us.pinguo.inspire.util.emoticon;

import android.graphics.Paint;
import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.rockerhieu.emoji.model.Emoticon;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
import us.pinguo.ui.uilview.GifImageView;
/* compiled from: EmoticonUtils.java */
/* loaded from: classes9.dex */
public class i {
    private static void a(SpannableString spannableString, Pattern pattern, int i2, int i3) throws Exception {
        Emoticon e2;
        Matcher matcher = pattern.matcher(spannableString);
        while (matcher.find()) {
            String group = matcher.group();
            if (matcher.start() >= i2 && (e2 = EmoticonManager.getInstance().e(group)) != null && !TextUtils.isEmpty(e2.pic)) {
                ImageLoader imageLoader = ImageLoader.getInstance();
                us.pinguo.foundation.t.a.g gVar = new us.pinguo.foundation.t.a.g(imageLoader.u(InspirePublishFragment.FILE_HEADER + e2.pic), 0, i3 / 10);
                gVar.setBounds(0, 0, i3, i3);
                com.rockerhieu.emoji.a aVar = new com.rockerhieu.emoji.a(gVar, 0);
                int start = matcher.start() + group.length();
                spannableString.setSpan(aVar, matcher.start(), start, 17);
                if (start < spannableString.length()) {
                    a(spannableString, pattern, start, i3);
                    return;
                }
            }
        }
    }

    public static SpannableString b(TextView textView, String str) {
        Paint.FontMetrics fontMetrics = textView.getPaint().getFontMetrics();
        return c(str, (int) ((fontMetrics.bottom - fontMetrics.top) * 1.2d));
    }

    public static SpannableString c(String str, int i2) {
        Emoticon e2 = EmoticonManager.getInstance().e(str);
        if (e2 == null) {
            return null;
        }
        ImageLoader imageLoader = ImageLoader.getInstance();
        us.pinguo.foundation.t.a.g gVar = new us.pinguo.foundation.t.a.g(imageLoader.u(InspirePublishFragment.FILE_HEADER + e2.pic), 0, i2 / 10);
        gVar.setBounds(0, 0, i2, i2);
        com.rockerhieu.emoji.a aVar = new com.rockerhieu.emoji.a(gVar, 0);
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(aVar, 0, str.length(), 33);
        return spannableString;
    }

    public static void d(GifImageView gifImageView, Emoticon emoticon) {
        if (f(gifImageView, emoticon.emoticonId)) {
            return;
        }
        if (Emoticon.TYPE_GIF.equals(emoticon.type)) {
            gifImageView.setGifImageUrl(emoticon.picUrl);
            return;
        }
        gifImageView.setBackgroundDrawable(null);
        gifImageView.setImageURI(emoticon.picUrl);
    }

    public static SpannableString e(CharSequence charSequence, int i2) {
        SpannableString spannableString = new SpannableString(charSequence);
        try {
            a(spannableString, Pattern.compile("\\[[^\\]]+\\]", 2), 0, i2);
        } catch (Exception e2) {
            Inspire.f(e2);
        }
        return spannableString;
    }

    private static boolean f(GifImageView gifImageView, String str) {
        Emoticon d2 = EmoticonManager.getInstance().d(str);
        if (d2 != null && !TextUtils.isEmpty(d2.pic)) {
            if (Emoticon.TYPE_GIF.equals(d2.type)) {
                gifImageView.setGifImageUrl(InspirePublishFragment.FILE_HEADER + d2.pic);
            } else {
                gifImageView.setBackgroundDrawable(null);
                gifImageView.setImageURI(InspirePublishFragment.FILE_HEADER + d2.pic);
            }
        }
        return d2 != null;
    }
}

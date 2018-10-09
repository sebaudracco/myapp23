package gooodev.myapplication_23;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class RoundedImageView extends ImageView
{
    public RoundedImageView(Context paramContext)
    {
        super(paramContext);
    }

    public RoundedImageView(Context paramContext, AttributeSet paramAttributeSet)
    {
        super(paramContext, paramAttributeSet);
    }

    public RoundedImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
        super(paramContext, paramAttributeSet, paramInt);
    }

    public static Bitmap getCroppedBitmap(Bitmap paramBitmap, int paramInt)
    {
        float f;
        if ((paramBitmap.getWidth() != paramInt) || (paramBitmap.getHeight() != paramInt))
            f = Math.min(paramBitmap.getWidth(), paramBitmap.getHeight()) / paramInt;
        for (Bitmap localBitmap1 = Bitmap.createScaledBitmap(paramBitmap, (int)(paramBitmap.getWidth() / f), (int)(paramBitmap.getHeight() / f), false); ; localBitmap1 = paramBitmap)
        {
            Bitmap localBitmap2 = Bitmap.createBitmap(paramInt, paramInt, Bitmap.Config.ARGB_8888);
            Canvas localCanvas = new Canvas(localBitmap2);
            Paint localPaint = new Paint();
            Rect localRect = new Rect(0, 0, paramInt + 5, paramInt + 5);
            localPaint.setAntiAlias(true);
            localPaint.setFilterBitmap(true);
            localPaint.setDither(true);
            localCanvas.drawARGB(0, 0, 0, 0);
            localPaint.setColor(Color.parseColor("#BAB399"));
            localCanvas.drawCircle(paramInt / 2, paramInt / 2, paramInt / 2, localPaint);
            localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            localCanvas.drawBitmap(localBitmap1, localRect, localRect, localPaint);
            return localBitmap2;
        }
    }

    protected void onDraw(Canvas paramCanvas)
    {
        Drawable localDrawable = getDrawable();
        if (localDrawable == null);
        while ((getWidth() == 0) || (getHeight() == 0))
            return;
        Bitmap localBitmap1 = ((BitmapDrawable)localDrawable).getBitmap();
        if (localBitmap1 != null);
        for (Bitmap localBitmap2 = localBitmap1.copy(Bitmap.Config.ARGB_8888, true); ; localBitmap2 = ((BitmapDrawable)getResources().getDrawable(2130837619)).getBitmap())
        {
            int i = getWidth();
            getHeight();
            paramCanvas.drawBitmap(getCroppedBitmap(localBitmap2, i), 0.0F, 0.0F, null);
            return;
        }
    }
}
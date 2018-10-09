package gooodev.myapplication_23;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Environment;
import android.text.Editable;
import android.widget.EditText;
import android.widget.Toast;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Utils
{
    public static final int ACTION_CAPTURE_IMAGE = 1325;
    public static final int ACTION_PICK_IMAGE = 1326;
    public static final String LOCAL_RESOURCE_PATH = Environment.getExternalStorageDirectory() + "/ffb/";
    public static final String PROFILE_THUMBNAIL_PATH = LOCAL_RESOURCE_PATH + ".profile/";
    public static final String THUMBNAIL_PATH = LOCAL_RESOURCE_PATH + ".thumbnails/";

    public static Intent captureImage(String paramString, Context paramContext)
    {
        File localFile = new File(LOCAL_RESOURCE_PATH);
        String str = LOCAL_RESOURCE_PATH + paramString;
        if (!localFile.exists())
            localFile.mkdirs();
        Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
        Uri localUri = Uri.fromFile(new File(str));
        try
        {
            localIntent.putExtra("output", localUri);
            return localIntent;
        }
        catch (Exception localException)
        {
            localException.printStackTrace();
        }
        return localIntent;
    }

    public static boolean createLocalResourceDirectory(Context paramContext)
    {
        try
        {
            File localFile = new File(Environment.getExternalStorageDirectory() + "/ffb");
            if (!localFile.exists())
            {
                if (!localFile.mkdir())
                {
                    Toast.makeText(paramContext, "Please ensure External Storage on your device!", 0).show();
                    return false;
                }
                return true;
            }
            return true;
        }
        catch (Exception localException)
        {
            localException.printStackTrace();
        }
        return false;
    }

    public static boolean createProfileImageDirectory(Context paramContext)
    {
        try
        {
            File localFile = new File(Environment.getExternalStorageDirectory() + "/.ffb/.profile");
            if (!localFile.exists())
            {
                if (!localFile.mkdir())
                {
                    Toast.makeText(paramContext, "Please ensure External Storage on your device!", 0).show();
                    return false;
                }
                return true;
            }
            return true;
        }
        catch (Exception localException)
        {
            localException.printStackTrace();
        }
        return false;
    }

    public static boolean createThumbNailDirectory(Context paramContext)
    {
        try
        {
            File localFile = new File(Environment.getExternalStorageDirectory() + "/.ffb/.thumbnails");
            if (!localFile.exists())
            {
                if (!localFile.mkdir())
                {
                    Toast.makeText(paramContext, "Please ensure External Storage on your device!", 0).show();
                    return false;
                }
                return true;
            }
            return true;
        }
        catch (Exception localException)
        {
            localException.printStackTrace();
        }
        return false;
    }

    public static Bitmap getImage(String paramString)
    {
        try
        {
            Bitmap localBitmap = BitmapFactory.decodeFile(new File(paramString).getAbsolutePath());
            return localBitmap;
        }
        catch (Exception localException)
        {
            localException.printStackTrace();
        }
        return null;
    }

    public static String getRealPathFromURI(Context paramContext, Uri paramUri)
    {
        Object localObject1 = "";
        Cursor localCursor = null;
        try
        {
            localCursor = paramContext.getContentResolver().query(paramUri, null, null, null, null);
            if (localCursor == null)
            {
                String str = paramUri.getPath();
                localObject1 = str;
            }
            while (true)
            {
                return localObject1;
                localCursor.moveToFirst();
                localObject1 = localCursor.getString(localCursor.getColumnIndex("_data"));
                localCursor.close();
            }
        }
        catch (Exception localException)
        {
            if (localCursor != null)
                localCursor.close();
            localException.printStackTrace();
            return localObject1;
        }
        finally
        {
            if (localCursor != null)
                localCursor.close();
        }
    }

    public static Intent pickImage()
    {
        Intent localIntent = new Intent("android.intent.action.GET_CONTENT");
        localIntent.setType("image/*");
        return localIntent;
    }

    public static Bitmap reduceImage(String paramString)
    {
        BitmapFactory.Options localOptions1 = new BitmapFactory.Options();
        localOptions1.inJustDecodeBounds = true;
        localOptions1.inPurgeable = true;
        localOptions1.inInputShareable = true;
        BitmapFactory.decodeFile(paramString, localOptions1);
        int i = localOptions1.outWidth;
        int j = localOptions1.outHeight;
        int k = 1;
        while (true)
        {
            if ((i / 2 < 320) || (j / 2 < 320))
            {
                BitmapFactory.Options localOptions2 = new BitmapFactory.Options();
                localOptions2.inPurgeable = true;
                localOptions2.inInputShareable = true;
                localOptions2.inSampleSize = k;
                return BitmapFactory.decodeFile(paramString, localOptions2);
            }
            i /= 2;
            j /= 2;
            k *= 2;
        }
    }

    public static boolean saveImage(Bitmap paramBitmap, String paramString)
    {
        try
        {
            FileOutputStream localFileOutputStream1 = new FileOutputStream(new File(LOCAL_RESOURCE_PATH + paramString));
            paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localFileOutputStream1);
            localFileOutputStream1.flush();
            localFileOutputStream1.close();
            FileOutputStream localFileOutputStream2 = new FileOutputStream(new File(PROFILE_THUMBNAIL_PATH + paramString));
            Bitmap.createScaledBitmap(paramBitmap, 400, 400, true).compress(Bitmap.CompressFormat.JPEG, 100, localFileOutputStream2);
            localFileOutputStream2.flush();
            localFileOutputStream2.close();
            FileOutputStream localFileOutputStream3 = new FileOutputStream(new File(THUMBNAIL_PATH + paramString));
            Bitmap.createScaledBitmap(paramBitmap, 200, 200, true).compress(Bitmap.CompressFormat.JPEG, 100, localFileOutputStream3);
            localFileOutputStream3.flush();
            localFileOutputStream3.close();
            return false;
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
            while (true)
                localFileNotFoundException.printStackTrace();
        }
        catch (IOException localIOException)
        {
            while (true)
                localIOException.printStackTrace();
        }
    }

    public static boolean saveImage(String paramString1, String paramString2)
    {
        try
        {
            Bitmap localBitmap = reduceImage(paramString1);
            if (localBitmap != null)
            {
                FileOutputStream localFileOutputStream1 = new FileOutputStream(new File(LOCAL_RESOURCE_PATH + paramString2));
                localBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localFileOutputStream1);
                localFileOutputStream1.flush();
                localFileOutputStream1.close();
                FileOutputStream localFileOutputStream2 = new FileOutputStream(new File(PROFILE_THUMBNAIL_PATH + paramString2));
                Bitmap.createScaledBitmap(localBitmap, 400, 400, true).compress(Bitmap.CompressFormat.JPEG, 100, localFileOutputStream2);
                localFileOutputStream2.flush();
                localFileOutputStream2.close();
                FileOutputStream localFileOutputStream3 = new FileOutputStream(new File(THUMBNAIL_PATH + paramString2));
                Bitmap.createScaledBitmap(localBitmap, 200, 200, true).compress(Bitmap.CompressFormat.JPEG, 100, localFileOutputStream3);
                localFileOutputStream3.flush();
                localFileOutputStream3.close();
            }
            return false;
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
            while (true)
                localFileNotFoundException.printStackTrace();
        }
        catch (IOException localIOException)
        {
            while (true)
                localIOException.printStackTrace();
        }
    }

    public static boolean saveThumbnail(Bitmap paramBitmap, String paramString)
    {
        try
        {
            FileOutputStream localFileOutputStream = new FileOutputStream(new File(paramString));
            Bitmap.createScaledBitmap(paramBitmap, 30, 30, true).compress(Bitmap.CompressFormat.JPEG, 90, localFileOutputStream);
            localFileOutputStream.flush();
            localFileOutputStream.close();
            return false;
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
            while (true)
                localFileNotFoundException.printStackTrace();
        }
        catch (IOException localIOException)
        {
            while (true)
                localIOException.printStackTrace();
        }
    }

    public static boolean validateFields(EditText paramEditText)
    {
        if (paramEditText.getText().toString().length() == 0)
        {
            paramEditText.setError("Required");
            return false;
        }
        return true;
    }
}
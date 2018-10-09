package gooodev.myapplication_23;


import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnCloseListener;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.Spinner;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mobilemerit.com.contactmanagement.adapter.ContactListAdapter;

public class ContactList extends ActionBarActivity
{
    ContactListAdapter adapter;
    Cursor cursor;
    private String[] fields;
    private String fileLocation;
    ImageView image;
    public InterstitialAd interstitial;
    private ListView listView;
    private Toolbar mToolbar;
    private ArrayList<HashMap<String, Object>> mapArrayList;
    private SearchView searchView;
    private Spinner spinner;

    static
    {
        if (!ContactList.class.desiredAssertionStatus());
        for (boolean bool = true; ; bool = false)
        {
            $assertionsDisabled = bool;
            return;
        }
    }

    private void excelFileSavedLocationDialog()
    {
        this.fileLocation = fileLocation();
        File localFile1 = new File(this.fileLocation);
        localFile1.mkdirs();
        final File localFile2 = new File(localFile1, "Contacts_File.xls");
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
        localBuilder.setTitle("Excel file saved in");
        localBuilder.setMessage(localFile2.toString());
        localBuilder.setCancelable(true);
        localBuilder.setNegativeButton("OK", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
                ContactList.this.exportExcel(localFile2);
                paramAnonymousDialogInterface.dismiss();
            }
        });
        localBuilder.create().show();
    }

    private String fileLocation()
    {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + "/export_contact";
    }

    private Bitmap getImage(String paramString)
    {
        File localFile = new File(Utils.LOCAL_RESOURCE_PATH + paramString);
        Log.d("name is", paramString);
        try
        {
            FileInputStream localFileInputStream1 = new FileInputStream(localFile);
            localFileInputStream2 = localFileInputStream1;
            Bitmap localBitmap = null;
            if (localFileInputStream2 != null)
            {
                localBitmap = BitmapFactory.decodeStream(localFileInputStream2);
                Bitmap.createScaledBitmap(localBitmap, 100, 100, true);
            }
            return localBitmap;
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
            while (true)
            {
                localFileNotFoundException.printStackTrace();
                FileInputStream localFileInputStream2 = null;
            }
        }
    }

    // ERROR //
    public void exportExcel(File paramFile)
    {
        // Byte code:
        //   0: new 181	jxl/WorkbookSettings
        //   3: dup
        //   4: invokespecial 182	jxl/WorkbookSettings:<init>	()V
        //   7: astore_2
        //   8: aload_2
        //   9: new 184	java/util/Locale
        //   12: dup
        //   13: ldc 186
        //   15: ldc 188
        //   17: invokespecial 191	java/util/Locale:<init>	(Ljava/lang/String;Ljava/lang/String;)V
        //   20: invokevirtual 195	jxl/WorkbookSettings:setLocale	(Ljava/util/Locale;)V
        //   23: aload_1
        //   24: aload_2
        //   25: invokestatic 201	jxl/Workbook:createWorkbook	(Ljava/io/File;Ljxl/WorkbookSettings;)Ljxl/write/WritableWorkbook;
        //   28: astore 4
        //   30: aload 4
        //   32: ldc 203
        //   34: iconst_0
        //   35: invokevirtual 209	jxl/write/WritableWorkbook:createSheet	(Ljava/lang/String;I)Ljxl/write/WritableSheet;
        //   38: astore 5
        //   40: new 211	jxl/write/Label
        //   43: dup
        //   44: iconst_0
        //   45: iconst_0
        //   46: ldc 213
        //   48: invokespecial 216	jxl/write/Label:<init>	(IILjava/lang/String;)V
        //   51: astore 6
        //   53: new 211	jxl/write/Label
        //   56: dup
        //   57: iconst_1
        //   58: iconst_0
        //   59: ldc 218
        //   61: invokespecial 216	jxl/write/Label:<init>	(IILjava/lang/String;)V
        //   64: astore 7
        //   66: new 211	jxl/write/Label
        //   69: dup
        //   70: iconst_2
        //   71: iconst_0
        //   72: ldc 220
        //   74: invokespecial 216	jxl/write/Label:<init>	(IILjava/lang/String;)V
        //   77: astore 8
        //   79: new 211	jxl/write/Label
        //   82: dup
        //   83: iconst_3
        //   84: iconst_0
        //   85: ldc 222
        //   87: invokespecial 216	jxl/write/Label:<init>	(IILjava/lang/String;)V
        //   90: astore 9
        //   92: new 211	jxl/write/Label
        //   95: dup
        //   96: iconst_4
        //   97: iconst_0
        //   98: ldc 224
        //   100: invokespecial 216	jxl/write/Label:<init>	(IILjava/lang/String;)V
        //   103: astore 10
        //   105: new 211	jxl/write/Label
        //   108: dup
        //   109: iconst_5
        //   110: iconst_0
        //   111: ldc 226
        //   113: invokespecial 216	jxl/write/Label:<init>	(IILjava/lang/String;)V
        //   116: astore 11
        //   118: new 211	jxl/write/Label
        //   121: dup
        //   122: bipush 6
        //   124: iconst_0
        //   125: ldc 228
        //   127: invokespecial 216	jxl/write/Label:<init>	(IILjava/lang/String;)V
        //   130: astore 12
        //   132: new 211	jxl/write/Label
        //   135: dup
        //   136: bipush 7
        //   138: iconst_0
        //   139: ldc 230
        //   141: invokespecial 216	jxl/write/Label:<init>	(IILjava/lang/String;)V
        //   144: astore 13
        //   146: new 211	jxl/write/Label
        //   149: dup
        //   150: bipush 8
        //   152: iconst_0
        //   153: ldc 232
        //   155: invokespecial 216	jxl/write/Label:<init>	(IILjava/lang/String;)V
        //   158: astore 14
        //   160: new 211	jxl/write/Label
        //   163: dup
        //   164: bipush 9
        //   166: iconst_0
        //   167: ldc 234
        //   169: invokespecial 216	jxl/write/Label:<init>	(IILjava/lang/String;)V
        //   172: astore 15
        //   174: new 211	jxl/write/Label
        //   177: dup
        //   178: bipush 10
        //   180: iconst_0
        //   181: ldc 236
        //   183: invokespecial 216	jxl/write/Label:<init>	(IILjava/lang/String;)V
        //   186: astore 16
        //   188: new 211	jxl/write/Label
        //   191: dup
        //   192: bipush 11
        //   194: iconst_0
        //   195: ldc 238
        //   197: invokespecial 216	jxl/write/Label:<init>	(IILjava/lang/String;)V
        //   200: astore 17
        //   202: aload 5
        //   204: aload 6
        //   206: invokeinterface 244 2 0
        //   211: aload 5
        //   213: aload 7
        //   215: invokeinterface 244 2 0
        //   220: aload 5
        //   222: aload 8
        //   224: invokeinterface 244 2 0
        //   229: aload 5
        //   231: aload 9
        //   233: invokeinterface 244 2 0
        //   238: aload 5
        //   240: aload 10
        //   242: invokeinterface 244 2 0
        //   247: aload 5
        //   249: aload 11
        //   251: invokeinterface 244 2 0
        //   256: aload 5
        //   258: aload 12
        //   260: invokeinterface 244 2 0
        //   265: aload 5
        //   267: aload 13
        //   269: invokeinterface 244 2 0
        //   274: aload 5
        //   276: aload 14
        //   278: invokeinterface 244 2 0
        //   283: aload 5
        //   285: aload 15
        //   287: invokeinterface 244 2 0
        //   292: aload 5
        //   294: aload 16
        //   296: invokeinterface 244 2 0
        //   301: aload 5
        //   303: aload 17
        //   305: invokeinterface 244 2 0
        //   310: aload_0
        //   311: getfield 246	mobilemerit/com/contactmanagement/ContactList:mapArrayList	Ljava/util/ArrayList;
        //   314: invokevirtual 252	java/util/ArrayList:iterator	()Ljava/util/Iterator;
        //   317: astore 19
        //   319: iconst_1
        //   320: istore 20
        //   322: iconst_1
        //   323: istore 21
        //   325: iconst_1
        //   326: istore 22
        //   328: iconst_1
        //   329: istore 23
        //   331: iconst_1
        //   332: istore 24
        //   334: iconst_1
        //   335: istore 25
        //   337: iconst_1
        //   338: istore 26
        //   340: iconst_1
        //   341: istore 27
        //   343: iconst_1
        //   344: istore 28
        //   346: iconst_1
        //   347: istore 29
        //   349: iconst_1
        //   350: istore 30
        //   352: iconst_1
        //   353: istore 31
        //   355: aload 19
        //   357: invokeinterface 257 1 0
        //   362: ifne +40 -> 402
        //   365: aload 4
        //   367: invokevirtual 260	jxl/write/WritableWorkbook:write	()V
        //   370: aload 4
        //   372: invokevirtual 263	jxl/write/WritableWorkbook:close	()V
        //   375: return
        //   376: astore 75
        //   378: aload 75
        //   380: invokevirtual 264	jxl/write/biff/RowsExceededException:printStackTrace	()V
        //   383: goto -73 -> 310
        //   386: astore_3
        //   387: aload_3
        //   388: invokevirtual 265	java/io/IOException:printStackTrace	()V
        //   391: return
        //   392: astore 18
        //   394: aload 18
        //   396: invokevirtual 266	jxl/write/WriteException:printStackTrace	()V
        //   399: goto -89 -> 310
        //   402: aload 19
        //   404: invokeinterface 270 1 0
        //   409: checkcast 272	java/util/Map
        //   412: astore 32
        //   414: iload 31
        //   416: iconst_1
        //   417: iadd
        //   418: istore 33
        //   420: aload 32
        //   422: aload_0
        //   423: getfield 274	mobilemerit/com/contactmanagement/ContactList:fields	[Ljava/lang/String;
        //   426: iconst_1
        //   427: aaload
        //   428: invokeinterface 278 2 0
        //   433: invokevirtual 281	java/lang/Object:toString	()Ljava/lang/String;
        //   436: astore 34
        //   438: new 211	jxl/write/Label
        //   441: dup
        //   442: iconst_0
        //   443: iload 31
        //   445: aload 34
        //   447: invokespecial 216	jxl/write/Label:<init>	(IILjava/lang/String;)V
        //   450: astore 35
        //   452: iload 30
        //   454: iconst_1
        //   455: iadd
        //   456: istore 36
        //   458: aload 32
        //   460: aload_0
        //   461: getfield 274	mobilemerit/com/contactmanagement/ContactList:fields	[Ljava/lang/String;
        //   464: iconst_2
        //   465: aaload
        //   466: invokeinterface 278 2 0
        //   471: invokevirtual 281	java/lang/Object:toString	()Ljava/lang/String;
        //   474: astore 37
        //   476: new 211	jxl/write/Label
        //   479: dup
        //   480: iconst_1
        //   481: iload 30
        //   483: aload 37
        //   485: invokespecial 216	jxl/write/Label:<init>	(IILjava/lang/String;)V
        //   488: astore 38
        //   490: iload 29
        //   492: iconst_1
        //   493: iadd
        //   494: istore 39
        //   496: aload 32
        //   498: aload_0
        //   499: getfield 274	mobilemerit/com/contactmanagement/ContactList:fields	[Ljava/lang/String;
        //   502: iconst_3
        //   503: aaload
        //   504: invokeinterface 278 2 0
        //   509: invokevirtual 281	java/lang/Object:toString	()Ljava/lang/String;
        //   512: astore 40
        //   514: new 211	jxl/write/Label
        //   517: dup
        //   518: iconst_2
        //   519: iload 29
        //   521: aload 40
        //   523: invokespecial 216	jxl/write/Label:<init>	(IILjava/lang/String;)V
        //   526: astore 41
        //   528: iload 28
        //   530: iconst_1
        //   531: iadd
        //   532: istore 42
        //   534: aload 32
        //   536: aload_0
        //   537: getfield 274	mobilemerit/com/contactmanagement/ContactList:fields	[Ljava/lang/String;
        //   540: iconst_4
        //   541: aaload
        //   542: invokeinterface 278 2 0
        //   547: invokevirtual 281	java/lang/Object:toString	()Ljava/lang/String;
        //   550: astore 43
        //   552: new 211	jxl/write/Label
        //   555: dup
        //   556: iconst_3
        //   557: iload 28
        //   559: aload 43
        //   561: invokespecial 216	jxl/write/Label:<init>	(IILjava/lang/String;)V
        //   564: astore 44
        //   566: iload 27
        //   568: iconst_1
        //   569: iadd
        //   570: istore 45
        //   572: aload 32
        //   574: aload_0
        //   575: getfield 274	mobilemerit/com/contactmanagement/ContactList:fields	[Ljava/lang/String;
        //   578: iconst_5
        //   579: aaload
        //   580: invokeinterface 278 2 0
        //   585: invokevirtual 281	java/lang/Object:toString	()Ljava/lang/String;
        //   588: astore 46
        //   590: new 211	jxl/write/Label
        //   593: dup
        //   594: iconst_4
        //   595: iload 27
        //   597: aload 46
        //   599: invokespecial 216	jxl/write/Label:<init>	(IILjava/lang/String;)V
        //   602: astore 47
        //   604: iload 26
        //   606: iconst_1
        //   607: iadd
        //   608: istore 48
        //   610: aload 32
        //   612: aload_0
        //   613: getfield 274	mobilemerit/com/contactmanagement/ContactList:fields	[Ljava/lang/String;
        //   616: bipush 6
        //   618: aaload
        //   619: invokeinterface 278 2 0
        //   624: invokevirtual 281	java/lang/Object:toString	()Ljava/lang/String;
        //   627: astore 49
        //   629: new 211	jxl/write/Label
        //   632: dup
        //   633: iconst_5
        //   634: iload 26
        //   636: aload 49
        //   638: invokespecial 216	jxl/write/Label:<init>	(IILjava/lang/String;)V
        //   641: astore 50
        //   643: iload 25
        //   645: iconst_1
        //   646: iadd
        //   647: istore 51
        //   649: aload 32
        //   651: aload_0
        //   652: getfield 274	mobilemerit/com/contactmanagement/ContactList:fields	[Ljava/lang/String;
        //   655: bipush 7
        //   657: aaload
        //   658: invokeinterface 278 2 0
        //   663: invokevirtual 281	java/lang/Object:toString	()Ljava/lang/String;
        //   666: astore 52
        //   668: new 211	jxl/write/Label
        //   671: dup
        //   672: bipush 6
        //   674: iload 25
        //   676: aload 52
        //   678: invokespecial 216	jxl/write/Label:<init>	(IILjava/lang/String;)V
        //   681: astore 53
        //   683: iload 24
        //   685: iconst_1
        //   686: iadd
        //   687: istore 54
        //   689: aload 32
        //   691: aload_0
        //   692: getfield 274	mobilemerit/com/contactmanagement/ContactList:fields	[Ljava/lang/String;
        //   695: bipush 8
        //   697: aaload
        //   698: invokeinterface 278 2 0
        //   703: invokevirtual 281	java/lang/Object:toString	()Ljava/lang/String;
        //   706: astore 55
        //   708: new 211	jxl/write/Label
        //   711: dup
        //   712: bipush 7
        //   714: iload 24
        //   716: aload 55
        //   718: invokespecial 216	jxl/write/Label:<init>	(IILjava/lang/String;)V
        //   721: astore 56
        //   723: iload 23
        //   725: iconst_1
        //   726: iadd
        //   727: istore 57
        //   729: aload 32
        //   731: aload_0
        //   732: getfield 274	mobilemerit/com/contactmanagement/ContactList:fields	[Ljava/lang/String;
        //   735: bipush 9
        //   737: aaload
        //   738: invokeinterface 278 2 0
        //   743: invokevirtual 281	java/lang/Object:toString	()Ljava/lang/String;
        //   746: astore 58
        //   748: new 211	jxl/write/Label
        //   751: dup
        //   752: bipush 8
        //   754: iload 23
        //   756: aload 58
        //   758: invokespecial 216	jxl/write/Label:<init>	(IILjava/lang/String;)V
        //   761: astore 59
        //   763: iload 22
        //   765: iconst_1
        //   766: iadd
        //   767: istore 60
        //   769: aload 32
        //   771: aload_0
        //   772: getfield 274	mobilemerit/com/contactmanagement/ContactList:fields	[Ljava/lang/String;
        //   775: bipush 10
        //   777: aaload
        //   778: invokeinterface 278 2 0
        //   783: invokevirtual 281	java/lang/Object:toString	()Ljava/lang/String;
        //   786: astore 61
        //   788: new 211	jxl/write/Label
        //   791: dup
        //   792: bipush 9
        //   794: iload 22
        //   796: aload 61
        //   798: invokespecial 216	jxl/write/Label:<init>	(IILjava/lang/String;)V
        //   801: astore 62
        //   803: iload 21
        //   805: iconst_1
        //   806: iadd
        //   807: istore 63
        //   809: aload 32
        //   811: aload_0
        //   812: getfield 274	mobilemerit/com/contactmanagement/ContactList:fields	[Ljava/lang/String;
        //   815: bipush 11
        //   817: aaload
        //   818: invokeinterface 278 2 0
        //   823: invokevirtual 281	java/lang/Object:toString	()Ljava/lang/String;
        //   826: astore 64
        //   828: new 211	jxl/write/Label
        //   831: dup
        //   832: bipush 10
        //   834: iload 21
        //   836: aload 64
        //   838: invokespecial 216	jxl/write/Label:<init>	(IILjava/lang/String;)V
        //   841: astore 65
        //   843: aload 5
        //   845: aload 35
        //   847: invokeinterface 244 2 0
        //   852: aload 5
        //   854: aload 38
        //   856: invokeinterface 244 2 0
        //   861: aload 5
        //   863: aload 41
        //   865: invokeinterface 244 2 0
        //   870: aload 5
        //   872: aload 44
        //   874: invokeinterface 244 2 0
        //   879: aload 5
        //   881: aload 47
        //   883: invokeinterface 244 2 0
        //   888: aload 5
        //   890: aload 50
        //   892: invokeinterface 244 2 0
        //   897: aload 5
        //   899: aload 53
        //   901: invokeinterface 244 2 0
        //   906: aload 5
        //   908: aload 56
        //   910: invokeinterface 244 2 0
        //   915: aload 5
        //   917: aload 59
        //   919: invokeinterface 244 2 0
        //   924: aload 5
        //   926: aload 62
        //   928: invokeinterface 244 2 0
        //   933: aload 5
        //   935: aload 65
        //   937: invokeinterface 244 2 0
        //   942: new 112	java/lang/StringBuilder
        //   945: dup
        //   946: getstatic 144	mobilemerit/com/contactmanagement/Utils:LOCAL_RESOURCE_PATH	Ljava/lang/String;
        //   949: invokestatic 127	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   952: invokespecial 128	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   955: aload 32
        //   957: ldc_w 282
        //   960: invokeinterface 278 2 0
        //   965: invokevirtual 281	java/lang/Object:toString	()Ljava/lang/String;
        //   968: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   971: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   974: astore 67
        //   976: ldc_w 284
        //   979: new 112	java/lang/StringBuilder
        //   982: dup
        //   983: invokespecial 285	java/lang/StringBuilder:<init>	()V
        //   986: aload 67
        //   988: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   991: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   994: invokestatic 288	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
        //   997: pop
        //   998: aload 67
        //   1000: ifnull +220 -> 1220
        //   1003: new 112	java/lang/StringBuilder
        //   1006: dup
        //   1007: getstatic 144	mobilemerit/com/contactmanagement/Utils:LOCAL_RESOURCE_PATH	Ljava/lang/String;
        //   1010: invokestatic 127	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   1013: invokespecial 128	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   1016: aload 32
        //   1018: ldc_w 282
        //   1021: invokeinterface 278 2 0
        //   1026: invokevirtual 281	java/lang/Object:toString	()Ljava/lang/String;
        //   1029: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1032: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   1035: invokestatic 291	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
        //   1038: astore 69
        //   1040: aload 69
        //   1042: ifnull +131 -> 1173
        //   1045: new 293	java/io/ByteArrayOutputStream
        //   1048: dup
        //   1049: invokespecial 294	java/io/ByteArrayOutputStream:<init>	()V
        //   1052: astore 70
        //   1054: aload 69
        //   1056: getstatic 300	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
        //   1059: bipush 100
        //   1061: aload 70
        //   1063: invokevirtual 304	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
        //   1066: pop
        //   1067: aload 70
        //   1069: invokevirtual 308	java/io/ByteArrayOutputStream:toByteArray	()[B
        //   1072: astore 72
        //   1074: iload 20
        //   1076: iconst_1
        //   1077: iadd
        //   1078: istore 73
        //   1080: aload 5
        //   1082: new 310	jxl/write/WritableImage
        //   1085: dup
        //   1086: ldc2_w 311
        //   1089: iload 20
        //   1091: i2d
        //   1092: dconst_1
        //   1093: dconst_1
        //   1094: aload 72
        //   1096: invokespecial 315	jxl/write/WritableImage:<init>	(DDDD[B)V
        //   1099: invokeinterface 319 2 0
        //   1104: iload 73
        //   1106: istore 20
        //   1108: iload 63
        //   1110: istore 21
        //   1112: iload 60
        //   1114: istore 22
        //   1116: iload 57
        //   1118: istore 23
        //   1120: iload 54
        //   1122: istore 24
        //   1124: iload 51
        //   1126: istore 25
        //   1128: iload 48
        //   1130: istore 26
        //   1132: iload 45
        //   1134: istore 27
        //   1136: iload 42
        //   1138: istore 28
        //   1140: iload 39
        //   1142: istore 29
        //   1144: iload 36
        //   1146: istore 30
        //   1148: iload 33
        //   1150: istore 31
        //   1152: goto -797 -> 355
        //   1155: astore 66
        //   1157: aload 66
        //   1159: invokevirtual 266	jxl/write/WriteException:printStackTrace	()V
        //   1162: goto -220 -> 942
        //   1165: astore 74
        //   1167: aload 74
        //   1169: invokevirtual 266	jxl/write/WriteException:printStackTrace	()V
        //   1172: return
        //   1173: iload 63
        //   1175: istore 21
        //   1177: iload 60
        //   1179: istore 22
        //   1181: iload 57
        //   1183: istore 23
        //   1185: iload 54
        //   1187: istore 24
        //   1189: iload 51
        //   1191: istore 25
        //   1193: iload 48
        //   1195: istore 26
        //   1197: iload 45
        //   1199: istore 27
        //   1201: iload 42
        //   1203: istore 28
        //   1205: iload 39
        //   1207: istore 29
        //   1209: iload 36
        //   1211: istore 30
        //   1213: iload 33
        //   1215: istore 31
        //   1217: goto -862 -> 355
        //   1220: iinc 20 1
        //   1223: iload 63
        //   1225: istore 21
        //   1227: iload 60
        //   1229: istore 22
        //   1231: iload 57
        //   1233: istore 23
        //   1235: iload 54
        //   1237: istore 24
        //   1239: iload 51
        //   1241: istore 25
        //   1243: iload 48
        //   1245: istore 26
        //   1247: iload 45
        //   1249: istore 27
        //   1251: iload 42
        //   1253: istore 28
        //   1255: iload 39
        //   1257: istore 29
        //   1259: iload 36
        //   1261: istore 30
        //   1263: iload 33
        //   1265: istore 31
        //   1267: goto -912 -> 355
        //
        // Exception table:
        //   from	to	target	type
        //   202	310	376	jxl/write/biff/RowsExceededException
        //   23	202	386	java/io/IOException
        //   202	310	386	java/io/IOException
        //   310	319	386	java/io/IOException
        //   355	370	386	java/io/IOException
        //   370	375	386	java/io/IOException
        //   378	383	386	java/io/IOException
        //   394	399	386	java/io/IOException
        //   402	414	386	java/io/IOException
        //   420	452	386	java/io/IOException
        //   458	490	386	java/io/IOException
        //   496	528	386	java/io/IOException
        //   534	566	386	java/io/IOException
        //   572	604	386	java/io/IOException
        //   610	643	386	java/io/IOException
        //   649	683	386	java/io/IOException
        //   689	723	386	java/io/IOException
        //   729	763	386	java/io/IOException
        //   769	803	386	java/io/IOException
        //   809	843	386	java/io/IOException
        //   843	942	386	java/io/IOException
        //   942	998	386	java/io/IOException
        //   1003	1040	386	java/io/IOException
        //   1045	1074	386	java/io/IOException
        //   1080	1104	386	java/io/IOException
        //   1157	1162	386	java/io/IOException
        //   1167	1172	386	java/io/IOException
        //   202	310	392	jxl/write/WriteException
        //   843	942	1155	jxl/write/WriteException
        //   370	375	1165	jxl/write/WriteException
    }

    // ERROR //
    public void getDetailList()
    {
        // Byte code:
        //   0: aload_0
        //   1: new 248	java/util/ArrayList
        //   4: dup
        //   5: invokespecial 323	java/util/ArrayList:<init>	()V
        //   8: putfield 246	mobilemerit/com/contactmanagement/ContactList:mapArrayList	Ljava/util/ArrayList;
        //   11: aconst_null
        //   12: astore_1
        //   13: new 325	mobilemerit/com/contactmanagement/database/DataBaseHelper
        //   16: dup
        //   17: aload_0
        //   18: invokespecial 326	mobilemerit/com/contactmanagement/database/DataBaseHelper:<init>	(Landroid/content/Context;)V
        //   21: astore_2
        //   22: aload_0
        //   23: aload_2
        //   24: invokevirtual 330	mobilemerit/com/contactmanagement/database/DataBaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
        //   27: ldc_w 332
        //   30: aconst_null
        //   31: invokevirtual 338	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
        //   34: putfield 340	mobilemerit/com/contactmanagement/ContactList:cursor	Landroid/database/Cursor;
        //   37: aload_0
        //   38: getfield 340	mobilemerit/com/contactmanagement/ContactList:cursor	Landroid/database/Cursor;
        //   41: invokeinterface 345 1 0
        //   46: ifne +30 -> 76
        //   49: aload_0
        //   50: getfield 340	mobilemerit/com/contactmanagement/ContactList:cursor	Landroid/database/Cursor;
        //   53: invokeinterface 346 1 0
        //   58: getstatic 39	mobilemerit/com/contactmanagement/ContactList:$assertionsDisabled	Z
        //   61: ifne +559 -> 620
        //   64: aload_2
        //   65: ifnonnull +555 -> 620
        //   68: new 348	java/lang/AssertionError
        //   71: dup
        //   72: invokespecial 349	java/lang/AssertionError:<init>	()V
        //   75: athrow
        //   76: new 351	java/util/HashMap
        //   79: dup
        //   80: invokespecial 352	java/util/HashMap:<init>	()V
        //   83: astore 5
        //   85: aload 5
        //   87: ldc_w 354
        //   90: aload_0
        //   91: getfield 340	mobilemerit/com/contactmanagement/ContactList:cursor	Landroid/database/Cursor;
        //   94: aload_0
        //   95: getfield 340	mobilemerit/com/contactmanagement/ContactList:cursor	Landroid/database/Cursor;
        //   98: ldc_w 354
        //   101: invokeinterface 358 2 0
        //   106: invokeinterface 362 2 0
        //   111: invokevirtual 366	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   114: pop
        //   115: aload 5
        //   117: aload_0
        //   118: getfield 274	mobilemerit/com/contactmanagement/ContactList:fields	[Ljava/lang/String;
        //   121: iconst_1
        //   122: aaload
        //   123: aload_0
        //   124: getfield 340	mobilemerit/com/contactmanagement/ContactList:cursor	Landroid/database/Cursor;
        //   127: aload_0
        //   128: getfield 340	mobilemerit/com/contactmanagement/ContactList:cursor	Landroid/database/Cursor;
        //   131: ldc_w 368
        //   134: invokeinterface 358 2 0
        //   139: invokeinterface 362 2 0
        //   144: invokevirtual 366	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   147: pop
        //   148: aload 5
        //   150: aload_0
        //   151: getfield 274	mobilemerit/com/contactmanagement/ContactList:fields	[Ljava/lang/String;
        //   154: iconst_2
        //   155: aaload
        //   156: aload_0
        //   157: getfield 340	mobilemerit/com/contactmanagement/ContactList:cursor	Landroid/database/Cursor;
        //   160: aload_0
        //   161: getfield 340	mobilemerit/com/contactmanagement/ContactList:cursor	Landroid/database/Cursor;
        //   164: ldc_w 370
        //   167: invokeinterface 358 2 0
        //   172: invokeinterface 362 2 0
        //   177: invokevirtual 366	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   180: pop
        //   181: aload 5
        //   183: aload_0
        //   184: getfield 274	mobilemerit/com/contactmanagement/ContactList:fields	[Ljava/lang/String;
        //   187: iconst_3
        //   188: aaload
        //   189: aload_0
        //   190: getfield 340	mobilemerit/com/contactmanagement/ContactList:cursor	Landroid/database/Cursor;
        //   193: aload_0
        //   194: getfield 340	mobilemerit/com/contactmanagement/ContactList:cursor	Landroid/database/Cursor;
        //   197: ldc_w 372
        //   200: invokeinterface 358 2 0
        //   205: invokeinterface 362 2 0
        //   210: invokevirtual 366	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   213: pop
        //   214: aload 5
        //   216: aload_0
        //   217: getfield 274	mobilemerit/com/contactmanagement/ContactList:fields	[Ljava/lang/String;
        //   220: iconst_4
        //   221: aaload
        //   222: aload_0
        //   223: getfield 340	mobilemerit/com/contactmanagement/ContactList:cursor	Landroid/database/Cursor;
        //   226: aload_0
        //   227: getfield 340	mobilemerit/com/contactmanagement/ContactList:cursor	Landroid/database/Cursor;
        //   230: ldc_w 374
        //   233: invokeinterface 358 2 0
        //   238: invokeinterface 362 2 0
        //   243: invokevirtual 366	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   246: pop
        //   247: aload 5
        //   249: aload_0
        //   250: getfield 274	mobilemerit/com/contactmanagement/ContactList:fields	[Ljava/lang/String;
        //   253: iconst_5
        //   254: aaload
        //   255: aload_0
        //   256: getfield 340	mobilemerit/com/contactmanagement/ContactList:cursor	Landroid/database/Cursor;
        //   259: aload_0
        //   260: getfield 340	mobilemerit/com/contactmanagement/ContactList:cursor	Landroid/database/Cursor;
        //   263: ldc_w 376
        //   266: invokeinterface 358 2 0
        //   271: invokeinterface 362 2 0
        //   276: invokevirtual 366	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   279: pop
        //   280: aload 5
        //   282: aload_0
        //   283: getfield 274	mobilemerit/com/contactmanagement/ContactList:fields	[Ljava/lang/String;
        //   286: bipush 6
        //   288: aaload
        //   289: aload_0
        //   290: getfield 340	mobilemerit/com/contactmanagement/ContactList:cursor	Landroid/database/Cursor;
        //   293: aload_0
        //   294: getfield 340	mobilemerit/com/contactmanagement/ContactList:cursor	Landroid/database/Cursor;
        //   297: ldc_w 378
        //   300: invokeinterface 358 2 0
        //   305: invokeinterface 362 2 0
        //   310: invokevirtual 366	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   313: pop
        //   314: aload 5
        //   316: aload_0
        //   317: getfield 274	mobilemerit/com/contactmanagement/ContactList:fields	[Ljava/lang/String;
        //   320: bipush 7
        //   322: aaload
        //   323: aload_0
        //   324: getfield 340	mobilemerit/com/contactmanagement/ContactList:cursor	Landroid/database/Cursor;
        //   327: aload_0
        //   328: getfield 340	mobilemerit/com/contactmanagement/ContactList:cursor	Landroid/database/Cursor;
        //   331: ldc_w 380
        //   334: invokeinterface 358 2 0
        //   339: invokeinterface 362 2 0
        //   344: invokevirtual 366	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   347: pop
        //   348: aload 5
        //   350: aload_0
        //   351: getfield 274	mobilemerit/com/contactmanagement/ContactList:fields	[Ljava/lang/String;
        //   354: bipush 8
        //   356: aaload
        //   357: aload_0
        //   358: getfield 340	mobilemerit/com/contactmanagement/ContactList:cursor	Landroid/database/Cursor;
        //   361: aload_0
        //   362: getfield 340	mobilemerit/com/contactmanagement/ContactList:cursor	Landroid/database/Cursor;
        //   365: ldc_w 382
        //   368: invokeinterface 358 2 0
        //   373: invokeinterface 362 2 0
        //   378: invokevirtual 366	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   381: pop
        //   382: aload 5
        //   384: aload_0
        //   385: getfield 274	mobilemerit/com/contactmanagement/ContactList:fields	[Ljava/lang/String;
        //   388: bipush 9
        //   390: aaload
        //   391: aload_0
        //   392: getfield 340	mobilemerit/com/contactmanagement/ContactList:cursor	Landroid/database/Cursor;
        //   395: aload_0
        //   396: getfield 340	mobilemerit/com/contactmanagement/ContactList:cursor	Landroid/database/Cursor;
        //   399: ldc_w 384
        //   402: invokeinterface 358 2 0
        //   407: invokeinterface 362 2 0
        //   412: invokevirtual 366	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   415: pop
        //   416: aload 5
        //   418: aload_0
        //   419: getfield 274	mobilemerit/com/contactmanagement/ContactList:fields	[Ljava/lang/String;
        //   422: bipush 10
        //   424: aaload
        //   425: aload_0
        //   426: getfield 340	mobilemerit/com/contactmanagement/ContactList:cursor	Landroid/database/Cursor;
        //   429: aload_0
        //   430: getfield 340	mobilemerit/com/contactmanagement/ContactList:cursor	Landroid/database/Cursor;
        //   433: ldc_w 386
        //   436: invokeinterface 358 2 0
        //   441: invokeinterface 362 2 0
        //   446: invokevirtual 366	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   449: pop
        //   450: aload 5
        //   452: aload_0
        //   453: getfield 274	mobilemerit/com/contactmanagement/ContactList:fields	[Ljava/lang/String;
        //   456: bipush 11
        //   458: aaload
        //   459: aload_0
        //   460: getfield 340	mobilemerit/com/contactmanagement/ContactList:cursor	Landroid/database/Cursor;
        //   463: aload_0
        //   464: getfield 340	mobilemerit/com/contactmanagement/ContactList:cursor	Landroid/database/Cursor;
        //   467: ldc_w 388
        //   470: invokeinterface 358 2 0
        //   475: invokeinterface 362 2 0
        //   480: invokevirtual 366	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   483: pop
        //   484: aload 5
        //   486: ldc_w 282
        //   489: aload_0
        //   490: getfield 340	mobilemerit/com/contactmanagement/ContactList:cursor	Landroid/database/Cursor;
        //   493: aload_0
        //   494: getfield 340	mobilemerit/com/contactmanagement/ContactList:cursor	Landroid/database/Cursor;
        //   497: ldc_w 390
        //   500: invokeinterface 358 2 0
        //   505: invokeinterface 362 2 0
        //   510: invokevirtual 366	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   513: pop
        //   514: aload_0
        //   515: getfield 246	mobilemerit/com/contactmanagement/ContactList:mapArrayList	Ljava/util/ArrayList;
        //   518: aload 5
        //   520: invokevirtual 394	java/util/ArrayList:add	(Ljava/lang/Object;)Z
        //   523: pop
        //   524: goto -487 -> 37
        //   527: astore 4
        //   529: aload_2
        //   530: astore_1
        //   531: aload 4
        //   533: invokevirtual 395	java/lang/Exception:printStackTrace	()V
        //   536: getstatic 39	mobilemerit/com/contactmanagement/ContactList:$assertionsDisabled	Z
        //   539: ifne +15 -> 554
        //   542: aload_1
        //   543: ifnonnull +11 -> 554
        //   546: new 348	java/lang/AssertionError
        //   549: dup
        //   550: invokespecial 349	java/lang/AssertionError:<init>	()V
        //   553: athrow
        //   554: aload_1
        //   555: invokevirtual 396	mobilemerit/com/contactmanagement/database/DataBaseHelper:close	()V
        //   558: aload_0
        //   559: new 398	mobilemerit/com/contactmanagement/adapter/ContactListAdapter
        //   562: dup
        //   563: aload_0
        //   564: ldc_w 399
        //   567: ldc_w 400
        //   570: ldc_w 401
        //   573: aload_0
        //   574: getfield 246	mobilemerit/com/contactmanagement/ContactList:mapArrayList	Ljava/util/ArrayList;
        //   577: invokespecial 404	mobilemerit/com/contactmanagement/adapter/ContactListAdapter:<init>	(Landroid/content/Context;IIILjava/util/ArrayList;)V
        //   580: putfield 406	mobilemerit/com/contactmanagement/ContactList:adapter	Lmobilemerit/com/contactmanagement/adapter/ContactListAdapter;
        //   583: aload_0
        //   584: getfield 408	mobilemerit/com/contactmanagement/ContactList:listView	Landroid/widget/ListView;
        //   587: aload_0
        //   588: getfield 406	mobilemerit/com/contactmanagement/ContactList:adapter	Lmobilemerit/com/contactmanagement/adapter/ContactListAdapter;
        //   591: invokevirtual 414	android/widget/ListView:setAdapter	(Landroid/widget/ListAdapter;)V
        //   594: return
        //   595: astore_3
        //   596: getstatic 39	mobilemerit/com/contactmanagement/ContactList:$assertionsDisabled	Z
        //   599: ifne +15 -> 614
        //   602: aload_1
        //   603: ifnonnull +11 -> 614
        //   606: new 348	java/lang/AssertionError
        //   609: dup
        //   610: invokespecial 349	java/lang/AssertionError:<init>	()V
        //   613: athrow
        //   614: aload_1
        //   615: invokevirtual 396	mobilemerit/com/contactmanagement/database/DataBaseHelper:close	()V
        //   618: aload_3
        //   619: athrow
        //   620: aload_2
        //   621: invokevirtual 396	mobilemerit/com/contactmanagement/database/DataBaseHelper:close	()V
        //   624: goto -66 -> 558
        //   627: astore_3
        //   628: aload_2
        //   629: astore_1
        //   630: goto -34 -> 596
        //   633: astore 4
        //   635: aconst_null
        //   636: astore_1
        //   637: goto -106 -> 531
        //
        // Exception table:
        //   from	to	target	type
        //   22	37	527	java/lang/Exception
        //   37	58	527	java/lang/Exception
        //   76	524	527	java/lang/Exception
        //   13	22	595	finally
        //   531	536	595	finally
        //   22	37	627	finally
        //   37	58	627	finally
        //   76	524	627	finally
        //   13	22	633	java/lang/Exception
    }

    public void onBackPressed()
    {
        if (this.interstitial.isLoaded())
            this.interstitial.show();
        super.onBackPressed();
    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(2130903068);
        this.mToolbar = ((Toolbar)findViewById(2131492965));
        setSupportActionBar(this.mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        AdView localAdView = (AdView)findViewById(2131493015);
        AdRequest localAdRequest = new AdRequest.Builder().build();
        localAdView.loadAd(localAdRequest);
        this.interstitial = new InterstitialAd(getBaseContext());
        this.interstitial.setAdUnitId(getResources().getString(2131165243));
        this.interstitial.loadAd(localAdRequest);
        this.fields = getResources().getStringArray(2131558402);
        this.listView = ((ListView)findViewById(2131493012));
        this.spinner = ((Spinner)findViewById(2131493011));
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
                Intent localIntent = new Intent(ContactList.this, ViewDetails.class);
                localIntent.putExtra("_id", ((Map)((Adapter)paramAnonymousAdapterView.getAdapter()).getItem(paramAnonymousInt)).get("_id").toString());
                ContactList.this.startActivity(localIntent);
            }
        });
        getDetailList();
        this.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
            }

            public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView)
            {
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu paramMenu)
    {
        getMenuInflater().inflate(2131623939, paramMenu);
        this.searchView = ((SearchView)MenuItemCompat.getActionView(paramMenu.findItem(2131493026)));
        this.searchView.setMaxWidth(250);
        this.searchView.setOnSearchClickListener(new View.OnClickListener()
        {
            public void onClick(View paramAnonymousView)
            {
                ContactList.this.spinner.setVisibility(0);
            }
        });
        this.searchView.setOnCloseListener(new SearchView.OnCloseListener()
        {
            public boolean onClose()
            {
                ContactList.this.spinner.setVisibility(8);
                return false;
            }
        });
        this.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener()
        {
            public boolean onQueryTextChange(String paramAnonymousString)
            {
                ContactList.this.setSearchContactList(paramAnonymousString);
                return true;
            }

            public boolean onQueryTextSubmit(String paramAnonymousString)
            {
                return false;
            }
        });
        return super.onCreateOptionsMenu(paramMenu);
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem)
    {
        int i = paramMenuItem.getItemId();
        if (i == 2131493024)
        {
            startActivity(new Intent(this, AddContact.class));
            return true;
        }
        if (i == 2131493025)
            excelFileSavedLocationDialog();
        return super.onOptionsItemSelected(paramMenuItem);
    }

    protected void onResume()
    {
        super.onResume();
        this.mapArrayList.clear();
        getDetailList();
        this.adapter.notifyDataSetChanged();
    }

    public void setSearchContactList(String paramString)
    {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.mapArrayList.iterator();
        while (true)
        {
            if (!localIterator.hasNext())
            {
                this.adapter = new ContactListAdapter(this, 2130903071, 2131493016, 2131493018, localArrayList);
                this.listView.setAdapter(this.adapter);
                return;
            }
            HashMap localHashMap = (HashMap)localIterator.next();
            if (this.spinner.getSelectedItemPosition() != 0)
            {
                if (localHashMap.get(this.spinner.getSelectedItem().toString()).toString().toLowerCase().contains(paramString.toLowerCase()))
                    localArrayList.add(localHashMap);
            }
            else if (localHashMap.get("name").toString().toLowerCase().contains(paramString.toLowerCase()))
                localArrayList.add(localHashMap);
        }
    }
}

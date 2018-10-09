package gooodev.myapplication_23;

import android.app.AlertDialog.Builder;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mobilemerit.com.contactmanagement.database.DataBaseHelper;

public class EditActivity extends ActionBarActivity
{
    private EditText address;
    private Spinner categoryList;
    private EditText city;
    private EditText company_name;
    Cursor cursor;
    private EditText email;
    private ImageView image;
    private String imageName;
    public InterstitialAd interstitial;
    private EditText landline;
    private ArrayList<HashMap<String, Object>> list;
    private ArrayList<HashMap<String, Object>> list1;
    private Toolbar mToolbar;
    private ArrayList<Map<String, Object>> mapArrayList;
    private EditText mobile;
    private EditText name;
    private Spinner spinnerList;
    private EditText state;
    TextView tvAddress;
    TextView tvCategoryList;
    TextView tvCity;
    TextView tvCompanyName;
    TextView tvCountryList;
    TextView tvEmail;
    TextView tvLandline;
    TextView tvMobile;
    TextView tvState;
    TextView tvWebsite;
    long updateid;
    private String view_id;
    private EditText website;

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

    public void getCatgeoryList()
    {
        this.list1 = new ArrayList();
        try
        {
            DataBaseHelper localDataBaseHelper = new DataBaseHelper(this);
            while (true)
            {
                try
                {
                    Cursor localCursor = localDataBaseHelper.getReadableDatabase().rawQuery("select * from category_type", null);
                    if (!localCursor.moveToNext())
                    {
                        localCursor.close();
                        localDataBaseHelper.close();
                        SimpleAdapter localSimpleAdapter = new SimpleAdapter(this, this.list1, 2130903072, new String[] { "category" }, new int[] { 16908308 });
                        this.categoryList.setAdapter(localSimpleAdapter);
                        return;
                    }
                    HashMap localHashMap = new HashMap();
                    localHashMap.put("_id", localCursor.getString(localCursor.getColumnIndex("cat_id")));
                    localHashMap.put("category", localCursor.getString(localCursor.getColumnIndex("category_type")));
                    this.list1.add(localHashMap);
                    continue;
                }
                catch (Exception localException1)
                {
                }
                label165: localException1.printStackTrace();
            }
        }
        catch (Exception localException2)
        {
            break label165;
        }
    }

    public void getCountryList()
    {
        this.list = new ArrayList();
        try
        {
            DataBaseHelper localDataBaseHelper = new DataBaseHelper(this);
            while (true)
            {
                try
                {
                    Cursor localCursor = localDataBaseHelper.getReadableDatabase().rawQuery("select * from country", null);
                    if (!localCursor.moveToNext())
                    {
                        localCursor.close();
                        localDataBaseHelper.close();
                        SimpleAdapter localSimpleAdapter = new SimpleAdapter(this, this.list, 2130903072, new String[] { "c_name" }, new int[] { 16908308 });
                        this.spinnerList.setAdapter(localSimpleAdapter);
                        return;
                    }
                    HashMap localHashMap = new HashMap();
                    localHashMap.put("id", localCursor.getString(localCursor.getColumnIndex("country_id")));
                    localHashMap.put("c_name", localCursor.getString(localCursor.getColumnIndex("country_name")));
                    this.list.add(localHashMap);
                    continue;
                }
                catch (Exception localException1)
                {
                }
                label165: localException1.printStackTrace();
            }
        }
        catch (Exception localException2)
        {
            break label165;
        }
    }

    // ERROR //
    public void loadView()
    {
        // Byte code:
        //   0: new 124	mobilemerit/com/contactmanagement/database/DataBaseHelper
        //   3: dup
        //   4: aload_0
        //   5: invokespecial 127	mobilemerit/com/contactmanagement/database/DataBaseHelper:<init>	(Landroid/content/Context;)V
        //   8: astore_1
        //   9: aload_1
        //   10: invokevirtual 131	mobilemerit/com/contactmanagement/database/DataBaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
        //   13: astore_3
        //   14: aload_0
        //   15: aload_3
        //   16: new 63	java/lang/StringBuilder
        //   19: dup
        //   20: ldc 210
        //   22: invokespecial 77	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   25: aload_0
        //   26: getfield 212	mobilemerit/com/contactmanagement/EditActivity:view_id	Ljava/lang/String;
        //   29: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   32: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   35: aconst_null
        //   36: invokevirtual 139	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
        //   39: putfield 214	mobilemerit/com/contactmanagement/EditActivity:cursor	Landroid/database/Cursor;
        //   42: aload_0
        //   43: getfield 214	mobilemerit/com/contactmanagement/EditActivity:cursor	Landroid/database/Cursor;
        //   46: invokeinterface 217 1 0
        //   51: ifeq +479 -> 530
        //   54: aload_0
        //   55: aload_0
        //   56: getfield 214	mobilemerit/com/contactmanagement/EditActivity:cursor	Landroid/database/Cursor;
        //   59: aload_0
        //   60: getfield 214	mobilemerit/com/contactmanagement/EditActivity:cursor	Landroid/database/Cursor;
        //   63: ldc 219
        //   65: invokeinterface 177 2 0
        //   70: invokeinterface 181 2 0
        //   75: putfield 55	mobilemerit/com/contactmanagement/EditActivity:imageName	Ljava/lang/String;
        //   78: aload_0
        //   79: getfield 221	mobilemerit/com/contactmanagement/EditActivity:image	Landroid/widget/ImageView;
        //   82: aload_0
        //   83: aload_0
        //   84: getfield 214	mobilemerit/com/contactmanagement/EditActivity:cursor	Landroid/database/Cursor;
        //   87: aload_0
        //   88: getfield 214	mobilemerit/com/contactmanagement/EditActivity:cursor	Landroid/database/Cursor;
        //   91: ldc 219
        //   93: invokeinterface 177 2 0
        //   98: invokeinterface 181 2 0
        //   103: invokespecial 223	mobilemerit/com/contactmanagement/EditActivity:getImage	(Ljava/lang/String;)Landroid/graphics/Bitmap;
        //   106: invokevirtual 229	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
        //   109: aload_0
        //   110: getfield 231	mobilemerit/com/contactmanagement/EditActivity:name	Landroid/widget/EditText;
        //   113: aload_0
        //   114: getfield 214	mobilemerit/com/contactmanagement/EditActivity:cursor	Landroid/database/Cursor;
        //   117: aload_0
        //   118: getfield 214	mobilemerit/com/contactmanagement/EditActivity:cursor	Landroid/database/Cursor;
        //   121: ldc 232
        //   123: invokeinterface 177 2 0
        //   128: invokeinterface 181 2 0
        //   133: invokevirtual 238	android/widget/EditText:setText	(Ljava/lang/CharSequence;)V
        //   136: aload_0
        //   137: getfield 240	mobilemerit/com/contactmanagement/EditActivity:mobile	Landroid/widget/EditText;
        //   140: aload_0
        //   141: getfield 214	mobilemerit/com/contactmanagement/EditActivity:cursor	Landroid/database/Cursor;
        //   144: aload_0
        //   145: getfield 214	mobilemerit/com/contactmanagement/EditActivity:cursor	Landroid/database/Cursor;
        //   148: ldc 241
        //   150: invokeinterface 177 2 0
        //   155: invokeinterface 181 2 0
        //   160: invokevirtual 238	android/widget/EditText:setText	(Ljava/lang/CharSequence;)V
        //   163: aload_0
        //   164: getfield 243	mobilemerit/com/contactmanagement/EditActivity:landline	Landroid/widget/EditText;
        //   167: aload_0
        //   168: getfield 214	mobilemerit/com/contactmanagement/EditActivity:cursor	Landroid/database/Cursor;
        //   171: aload_0
        //   172: getfield 214	mobilemerit/com/contactmanagement/EditActivity:cursor	Landroid/database/Cursor;
        //   175: ldc 244
        //   177: invokeinterface 177 2 0
        //   182: invokeinterface 181 2 0
        //   187: invokevirtual 238	android/widget/EditText:setText	(Ljava/lang/CharSequence;)V
        //   190: aload_0
        //   191: getfield 246	mobilemerit/com/contactmanagement/EditActivity:email	Landroid/widget/EditText;
        //   194: aload_0
        //   195: getfield 214	mobilemerit/com/contactmanagement/EditActivity:cursor	Landroid/database/Cursor;
        //   198: aload_0
        //   199: getfield 214	mobilemerit/com/contactmanagement/EditActivity:cursor	Landroid/database/Cursor;
        //   202: ldc 247
        //   204: invokeinterface 177 2 0
        //   209: invokeinterface 181 2 0
        //   214: invokevirtual 238	android/widget/EditText:setText	(Ljava/lang/CharSequence;)V
        //   217: aload_0
        //   218: getfield 249	mobilemerit/com/contactmanagement/EditActivity:address	Landroid/widget/EditText;
        //   221: aload_0
        //   222: getfield 214	mobilemerit/com/contactmanagement/EditActivity:cursor	Landroid/database/Cursor;
        //   225: aload_0
        //   226: getfield 214	mobilemerit/com/contactmanagement/EditActivity:cursor	Landroid/database/Cursor;
        //   229: ldc 250
        //   231: invokeinterface 177 2 0
        //   236: invokeinterface 181 2 0
        //   241: invokevirtual 238	android/widget/EditText:setText	(Ljava/lang/CharSequence;)V
        //   244: aload_0
        //   245: getfield 252	mobilemerit/com/contactmanagement/EditActivity:state	Landroid/widget/EditText;
        //   248: aload_0
        //   249: getfield 214	mobilemerit/com/contactmanagement/EditActivity:cursor	Landroid/database/Cursor;
        //   252: aload_0
        //   253: getfield 214	mobilemerit/com/contactmanagement/EditActivity:cursor	Landroid/database/Cursor;
        //   256: ldc 253
        //   258: invokeinterface 177 2 0
        //   263: invokeinterface 181 2 0
        //   268: invokevirtual 238	android/widget/EditText:setText	(Ljava/lang/CharSequence;)V
        //   271: aload_0
        //   272: getfield 255	mobilemerit/com/contactmanagement/EditActivity:city	Landroid/widget/EditText;
        //   275: aload_0
        //   276: getfield 214	mobilemerit/com/contactmanagement/EditActivity:cursor	Landroid/database/Cursor;
        //   279: aload_0
        //   280: getfield 214	mobilemerit/com/contactmanagement/EditActivity:cursor	Landroid/database/Cursor;
        //   283: ldc_w 256
        //   286: invokeinterface 177 2 0
        //   291: invokeinterface 181 2 0
        //   296: invokevirtual 238	android/widget/EditText:setText	(Ljava/lang/CharSequence;)V
        //   299: aload_0
        //   300: getfield 258	mobilemerit/com/contactmanagement/EditActivity:company_name	Landroid/widget/EditText;
        //   303: aload_0
        //   304: getfield 214	mobilemerit/com/contactmanagement/EditActivity:cursor	Landroid/database/Cursor;
        //   307: aload_0
        //   308: getfield 214	mobilemerit/com/contactmanagement/EditActivity:cursor	Landroid/database/Cursor;
        //   311: ldc_w 259
        //   314: invokeinterface 177 2 0
        //   319: invokeinterface 181 2 0
        //   324: invokevirtual 238	android/widget/EditText:setText	(Ljava/lang/CharSequence;)V
        //   327: aload_0
        //   328: getfield 261	mobilemerit/com/contactmanagement/EditActivity:website	Landroid/widget/EditText;
        //   331: aload_0
        //   332: getfield 214	mobilemerit/com/contactmanagement/EditActivity:cursor	Landroid/database/Cursor;
        //   335: aload_0
        //   336: getfield 214	mobilemerit/com/contactmanagement/EditActivity:cursor	Landroid/database/Cursor;
        //   339: ldc_w 262
        //   342: invokeinterface 177 2 0
        //   347: invokeinterface 181 2 0
        //   352: invokevirtual 238	android/widget/EditText:setText	(Ljava/lang/CharSequence;)V
        //   355: new 168	java/util/HashMap
        //   358: dup
        //   359: invokespecial 169	java/util/HashMap:<init>	()V
        //   362: astore 4
        //   364: aload 4
        //   366: ldc 203
        //   368: aload_0
        //   369: getfield 214	mobilemerit/com/contactmanagement/EditActivity:cursor	Landroid/database/Cursor;
        //   372: aload_0
        //   373: getfield 214	mobilemerit/com/contactmanagement/EditActivity:cursor	Landroid/database/Cursor;
        //   376: ldc 205
        //   378: invokeinterface 177 2 0
        //   383: invokeinterface 181 2 0
        //   388: invokevirtual 185	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   391: pop
        //   392: aload 4
        //   394: ldc 199
        //   396: aload_0
        //   397: getfield 214	mobilemerit/com/contactmanagement/EditActivity:cursor	Landroid/database/Cursor;
        //   400: aload_0
        //   401: getfield 214	mobilemerit/com/contactmanagement/EditActivity:cursor	Landroid/database/Cursor;
        //   404: ldc 207
        //   406: invokeinterface 177 2 0
        //   411: invokeinterface 181 2 0
        //   416: invokevirtual 185	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   419: pop
        //   420: aload_0
        //   421: getfield 201	mobilemerit/com/contactmanagement/EditActivity:spinnerList	Landroid/widget/Spinner;
        //   424: aload_0
        //   425: getfield 195	mobilemerit/com/contactmanagement/EditActivity:list	Ljava/util/ArrayList;
        //   428: aload 4
        //   430: invokevirtual 266	java/util/ArrayList:indexOf	(Ljava/lang/Object;)I
        //   433: invokevirtual 270	android/widget/Spinner:setSelection	(I)V
        //   436: new 168	java/util/HashMap
        //   439: dup
        //   440: invokespecial 169	java/util/HashMap:<init>	()V
        //   443: astore 7
        //   445: aload 7
        //   447: ldc 171
        //   449: aload_0
        //   450: getfield 214	mobilemerit/com/contactmanagement/EditActivity:cursor	Landroid/database/Cursor;
        //   453: aload_0
        //   454: getfield 214	mobilemerit/com/contactmanagement/EditActivity:cursor	Landroid/database/Cursor;
        //   457: ldc 173
        //   459: invokeinterface 177 2 0
        //   464: invokeinterface 181 2 0
        //   469: invokevirtual 185	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   472: pop
        //   473: aload 7
        //   475: ldc 154
        //   477: aload_0
        //   478: getfield 214	mobilemerit/com/contactmanagement/EditActivity:cursor	Landroid/database/Cursor;
        //   481: aload_0
        //   482: getfield 214	mobilemerit/com/contactmanagement/EditActivity:cursor	Landroid/database/Cursor;
        //   485: ldc 187
        //   487: invokeinterface 177 2 0
        //   492: invokeinterface 181 2 0
        //   497: invokevirtual 185	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   500: pop
        //   501: aload_0
        //   502: getfield 160	mobilemerit/com/contactmanagement/EditActivity:categoryList	Landroid/widget/Spinner;
        //   505: aload_0
        //   506: getfield 122	mobilemerit/com/contactmanagement/EditActivity:list1	Ljava/util/ArrayList;
        //   509: aload 7
        //   511: invokevirtual 266	java/util/ArrayList:indexOf	(Ljava/lang/Object;)I
        //   514: invokevirtual 270	android/widget/Spinner:setSelection	(I)V
        //   517: aload_0
        //   518: getfield 214	mobilemerit/com/contactmanagement/EditActivity:cursor	Landroid/database/Cursor;
        //   521: invokeinterface 148 1 0
        //   526: aload_3
        //   527: invokevirtual 271	android/database/sqlite/SQLiteDatabase:close	()V
        //   530: return
        //   531: astore_2
        //   532: aload_2
        //   533: invokevirtual 192	java/lang/Exception:printStackTrace	()V
        //   536: return
        //   537: astore_2
        //   538: goto -6 -> 532
        //
        // Exception table:
        //   from	to	target	type
        //   0	9	531	java/lang/Exception
        //   9	530	537	java/lang/Exception
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        switch (paramInt1)
        {
            default:
            case 123:
            case 1325:
            case 1326:
        }
        do
        {
            do
            {
                do
                    return;
                while (paramInt2 != -1);
                try
                {
                    this.mapArrayList.addAll((ArrayList)paramIntent.getSerializableExtra("data"));
                    Log.d("map is", this.mapArrayList.toString());
                    return;
                }
                catch (Exception localException2)
                {
                    localException2.printStackTrace();
                    return;
                }
            }
            while (paramInt2 != -1);
            Utils.saveImage(Utils.LOCAL_RESOURCE_PATH + this.imageName, this.imageName);
            this.image.setImageBitmap(BitmapFactory.decodeFile(Utils.LOCAL_RESOURCE_PATH + this.imageName));
            return;
        }
        while (paramInt2 != -1);
        Uri localUri = paramIntent.getData();
        Log.d("", "imageUri = " + Utils.getRealPathFromURI(this, paramIntent.getData()));
        try
        {
            Utils.saveImage(Utils.getRealPathFromURI(this, localUri), this.imageName);
            this.image.setImageBitmap(BitmapFactory.decodeFile(Utils.LOCAL_RESOURCE_PATH + this.imageName));
            return;
        }
        catch (Exception localException1)
        {
            localException1.printStackTrace();
        }
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
        setContentView(2130903067);
        this.mToolbar = ((Toolbar)findViewById(2131492965));
        setSupportActionBar(this.mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        AdView localAdView = (AdView)findViewById(2131493015);
        AdRequest localAdRequest = new AdRequest.Builder().build();
        localAdView.loadAd(localAdRequest);
        this.interstitial = new InterstitialAd(getBaseContext());
        this.interstitial.setAdUnitId(getResources().getString(2131165243));
        this.interstitial.loadAd(localAdRequest);
        setReference();
        Utils.createLocalResourceDirectory(this);
        Typeface localTypeface = Typeface.createFromAsset(getAssets(), "font/Roboto-Regular.ttf");
        this.tvMobile.setTypeface(localTypeface);
        this.tvLandline.setTypeface(localTypeface);
        this.tvEmail.setTypeface(localTypeface);
        this.tvCountryList.setTypeface(localTypeface);
        this.tvState.setTypeface(localTypeface);
        this.tvCity.setTypeface(localTypeface);
        this.tvCompanyName.setTypeface(localTypeface);
        this.tvWebsite.setTypeface(localTypeface);
        this.tvCategoryList.setTypeface(localTypeface);
        this.tvAddress.setTypeface(localTypeface);
        this.name.setTypeface(localTypeface);
        this.mobile.setTypeface(localTypeface);
        this.landline.setTypeface(localTypeface);
        this.email.setTypeface(localTypeface);
        this.address.setTypeface(localTypeface);
        this.state.setTypeface(localTypeface);
        this.city.setTypeface(localTypeface);
        this.company_name.setTypeface(localTypeface);
        this.website.setTypeface(localTypeface);
        this.view_id = getIntent().getStringExtra("view_id");
        getCountryList();
        getCatgeoryList();
        loadView();
    }

    public boolean onCreateOptionsMenu(Menu paramMenu)
    {
        getMenuInflater().inflate(2131623938, paramMenu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem)
    {
        if (paramMenuItem.getItemId() == 2131493023)
        {
            if ((Utils.validateFields(this.name)) && (Utils.validateFields(this.mobile)))
            {
                updateContactDetails();
                finish();
            }
            return true;
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }

    public void setReference()
    {
        this.image = ((ImageView)findViewById(2131492966));
        this.name = ((EditText)findViewById(2131492967));
        this.mobile = ((EditText)findViewById(2131492970));
        this.landline = ((EditText)findViewById(2131492973));
        this.email = ((EditText)findViewById(2131492976));
        this.address = ((EditText)findViewById(2131492979));
        this.state = ((EditText)findViewById(2131492985));
        this.city = ((EditText)findViewById(2131492988));
        this.company_name = ((EditText)findViewById(2131492991));
        this.website = ((EditText)findViewById(2131492994));
        this.spinnerList = ((Spinner)findViewById(2131492982));
        this.categoryList = ((Spinner)findViewById(2131492997));
        this.tvMobile = ((TextView)findViewById(2131492969));
        this.tvLandline = ((TextView)findViewById(2131492972));
        this.tvEmail = ((TextView)findViewById(2131492975));
        this.tvAddress = ((TextView)findViewById(2131492978));
        this.tvCountryList = ((TextView)findViewById(2131492981));
        this.tvState = ((TextView)findViewById(2131492984));
        this.tvCity = ((TextView)findViewById(2131492987));
        this.tvCompanyName = ((TextView)findViewById(2131492990));
        this.tvWebsite = ((TextView)findViewById(2131492993));
        this.tvCategoryList = ((TextView)findViewById(2131492996));
        this.image.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramAnonymousView)
            {
                EditActivity.this.showImageUploadOption();
            }
        });
    }

    public void showImageUploadOption()
    {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
        localBuilder.setTitle("Select Image");
        ArrayAdapter localArrayAdapter = new ArrayAdapter(this, 17367057);
        localArrayAdapter.add("Choose From Gallery");
        localArrayAdapter.add("Capture From Camera");
        localBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
                paramAnonymousDialogInterface.dismiss();
            }
        });
        localBuilder.setAdapter(localArrayAdapter, new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
                switch (paramAnonymousInt)
                {
                    default:
                        return;
                    case 0:
                        EditActivity.this.startActivityForResult(Utils.pickImage(), 1326);
                        return;
                    case 1:
                }
                EditActivity.this.startActivityForResult(Utils.captureImage(EditActivity.this.imageName, EditActivity.this), 1325);
            }
        });
        localBuilder.show();
    }

    public void updateContactDetails()
    {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("photo_url", this.imageName);
        localContentValues.put("name", this.name.getText().toString());
        localContentValues.put("mobile", this.mobile.getText().toString());
        localContentValues.put("landline", this.landline.getText().toString());
        localContentValues.put("email", this.email.getText().toString());
        localContentValues.put("address", this.address.getText().toString());
        localContentValues.put("state", this.state.getText().toString());
        localContentValues.put("city", this.city.getText().toString());
        localContentValues.put("company_name", this.company_name.getText().toString());
        localContentValues.put("website", this.website.getText().toString());
        localContentValues.put("country", ((Map)this.spinnerList.getSelectedItem()).get("id").toString());
        localContentValues.put("category_type", ((Map)this.categoryList.getSelectedItem()).get("_id").toString());
        this.updateid = new DataBaseHelper(this).update(this, "contact_details", localContentValues, this.view_id);
        Log.d("Details", "inserted in to details" + this.updateid);
    }
}
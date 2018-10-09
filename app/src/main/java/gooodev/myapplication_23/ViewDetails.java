package gooodev.myapplication_23;

import android.app.AlertDialog.Builder;
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
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import mobilemerit.com.contactmanagement.database.DataBaseHelper;

public class ViewDetails extends ActionBarActivity
        implements View.OnClickListener
{
    private String _id;
    private EditText address;
    private EditText category;
    private EditText city;
    private EditText company_name;
    private EditText country;
    Cursor cursor;
    private EditText email;
    String emailAddress;
    private ImageView image;
    private String imageName;
    public InterstitialAd interstitial;
    private EditText landline;
    String landlineNo;
    private Toolbar mToolbar;
    private EditText mobile;
    String mobileNo;
    String name;
    String sCategory;
    String sCity;
    String sCompany;
    String sCountry;
    String sState;
    String sWebsite;
    String s_address;
    private EditText state;
    TableRow trAddress;
    TableRow trCategory;
    TableRow trCity;
    TableRow trCompany_name;
    TableRow trCountry;
    TableRow trEmail;
    TableRow trLandline;
    TableRow trMobile;
    TableRow trState;
    TableRow trWebsite;
    TextView tvAddress;
    TextView tvCategoryList;
    TextView tvCity;
    TextView tvCompanyName;
    TextView tvCountryList;
    TextView tvEmail;
    TextView tvLandline;
    TextView tvMobile;
    TextView tvName;
    TextView tvState;
    TextView tvWebsite;
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

    private void share()
    {
        String str = "";
        if (!this.name.equalsIgnoreCase(""))
            str = str + "\nName: " + this.name;
        if (!this.mobileNo.equalsIgnoreCase(""))
            str = str + "\nMobile: " + this.mobileNo;
        if (!this.landlineNo.equalsIgnoreCase(""))
            str = str + "\nLandLine:  " + this.landlineNo;
        if (!this.emailAddress.equalsIgnoreCase(""))
            str = str + "\nEmail :  " + this.emailAddress;
        if (!this.s_address.equalsIgnoreCase(""))
            str = str + "\nAddress :  " + this.s_address;
        if (!this.sCountry.equalsIgnoreCase(""))
            str = str + "\nCountry :  " + this.sCountry;
        if (!this.sState.equalsIgnoreCase(""))
            str = str + "\nState :  " + this.sState;
        if (!this.sCity.equalsIgnoreCase(""))
            str = str + "\nCity :  " + this.sCity;
        if (!this.sCompany.equalsIgnoreCase(""))
            str = str + "\nCompany Name :  " + this.sCompany;
        if (!this.sWebsite.equalsIgnoreCase(""))
            str = str + "\nWebsite :  " + this.sWebsite;
        if (!this.sCategory.equalsIgnoreCase(""))
            str = str + "\nCategory :  " + this.sCategory;
        Uri localUri = Uri.parse(Utils.LOCAL_RESOURCE_PATH + this.imageName);
        Intent localIntent = new Intent("android.intent.action.SEND");
        localIntent.setType("image/jpeg");
        localIntent.putExtra("android.intent.extra.SUBJECT", this.tvName.getText().toString() + " contact details ");
        localIntent.putExtra("android.intent.extra.STREAM", localUri);
        localIntent.putExtra("android.intent.extra.TEXT", str);
        startActivity(Intent.createChooser(localIntent, "Share"));
    }

    public void composeEmail()
    {
        Intent localIntent = new Intent("android.intent.action.SENDTO");
        localIntent.setData(Uri.parse("mailto:"));
        String[] arrayOfString = new String[1];
        arrayOfString[0] = this.emailAddress;
        localIntent.putExtra("android.intent.extra.EMAIL", arrayOfString);
        if (localIntent.resolveActivity(getPackageManager()) != null)
            startActivity(localIntent);
    }

    public void dialPhoneNumber(String paramString)
    {
        Intent localIntent = new Intent("android.intent.action.DIAL");
        localIntent.setData(Uri.parse("tel:" + paramString));
        if (localIntent.resolveActivity(getPackageManager()) != null)
            startActivity(localIntent);
    }

    public void loadView()
    {
        try
        {
            DataBaseHelper localDataBaseHelper = new DataBaseHelper(this);
            while (true)
            {
                try
                {
                    SQLiteDatabase localSQLiteDatabase = localDataBaseHelper.getReadableDatabase();
                    this.cursor = localSQLiteDatabase.rawQuery("select * from contact_details ct , country co ,category_type ca where ct.country = co.country_id and  ct.category_type = ca.cat_id and ct._id = " + this._id, null);
                    if (!this.cursor.moveToFirst())
                        break;
                    this.imageName = this.cursor.getString(this.cursor.getColumnIndex("photo_url"));
                    this.image.setImageBitmap(getImage(this.cursor.getString(this.cursor.getColumnIndex("photo_url"))));
                    this.tvName.setText(this.cursor.getString(this.cursor.getColumnIndex("name")));
                    this.name = this.cursor.getString(this.cursor.getColumnIndex("name"));
                    this.mobileNo = this.cursor.getString(this.cursor.getColumnIndex("mobile"));
                    if ((this.mobileNo != null) && (!this.mobileNo.equalsIgnoreCase("")))
                    {
                        this.mobile.setText(this.mobileNo);
                        this.trMobile.setVisibility(0);
                        this.landlineNo = this.cursor.getString(this.cursor.getColumnIndex("landline"));
                        if ((this.landlineNo != null) && (!this.landlineNo.equalsIgnoreCase("")))
                        {
                            this.landline.setText(this.landlineNo);
                            this.trLandline.setVisibility(0);
                            this.emailAddress = this.cursor.getString(this.cursor.getColumnIndex("email"));
                            if ((this.emailAddress == null) || (this.emailAddress.equalsIgnoreCase("")))
                                break label839;
                            this.email.setText(this.emailAddress);
                            this.trEmail.setVisibility(0);
                            this.sCountry = this.cursor.getString(this.cursor.getColumnIndex("country_name"));
                            if ((this.sCountry == null) || (this.sCountry.equalsIgnoreCase("")))
                                break label851;
                            this.country.setText(this.sCountry);
                            this.trCountry.setVisibility(0);
                            this.s_address = this.cursor.getString(this.cursor.getColumnIndex("address"));
                            if ((this.s_address == null) || (this.s_address.equalsIgnoreCase("")))
                                break label863;
                            this.address.setText(this.s_address);
                            this.trAddress.setVisibility(0);
                            this.sCity = this.cursor.getString(this.cursor.getColumnIndex("city"));
                            if ((this.sCity == null) || (this.sCity.equalsIgnoreCase("")))
                                break label875;
                            this.city.setText(this.sCity);
                            this.trCity.setVisibility(0);
                            this.sState = this.cursor.getString(this.cursor.getColumnIndex("state"));
                            if ((this.sState == null) || (this.sState.equalsIgnoreCase("")))
                                break label887;
                            this.state.setText(this.sState);
                            this.trState.setVisibility(0);
                            this.sCompany = this.cursor.getString(this.cursor.getColumnIndex("company_name"));
                            if ((this.sCompany == null) || (this.sCompany.equalsIgnoreCase("")))
                                break label899;
                            this.company_name.setText(this.sCompany);
                            this.trCompany_name.setVisibility(0);
                            this.sWebsite = this.cursor.getString(this.cursor.getColumnIndex("website"));
                            if ((this.sWebsite == null) || (this.sWebsite.equalsIgnoreCase("")))
                                break label911;
                            this.website.setText(this.sWebsite);
                            this.trWebsite.setVisibility(0);
                            this.sCategory = this.cursor.getString(this.cursor.getColumnIndex("category_type"));
                            if ((this.sCategory == null) || (this.sCategory.equalsIgnoreCase("")))
                                break label923;
                            this.category.setText(this.sCategory);
                            this.trCategory.setVisibility(0);
                            this.cursor.close();
                            localSQLiteDatabase.close();
                        }
                    }
                    else
                    {
                        this.trMobile.setVisibility(8);
                        continue;
                    }
                }
                catch (Exception localException1)
                {
                    label822: localException1.printStackTrace();
                    return;
                }
                this.trLandline.setVisibility(8);
                continue;
                label839: this.trEmail.setVisibility(8);
                continue;
                label851: this.trCountry.setVisibility(8);
                continue;
                label863: this.trAddress.setVisibility(8);
                continue;
                label875: this.trCity.setVisibility(8);
                continue;
                label887: this.trState.setVisibility(8);
                continue;
                label899: this.trCompany_name.setVisibility(8);
                continue;
                label911: this.trWebsite.setVisibility(8);
                continue;
                label923: this.trCategory.setVisibility(8);
            }
        }
        catch (Exception localException2)
        {
            break label822;
        }
    }

    public void onBackPressed()
    {
        if (this.interstitial.isLoaded())
            this.interstitial.show();
        super.onBackPressed();
    }

    public void onClick(View paramView)
    {
        switch (paramView.getId())
        {
            default:
                return;
            case 2131492970:
                dialPhoneNumber(this.mobileNo);
                return;
            case 2131492973:
                dialPhoneNumber(this.landlineNo);
                return;
            case 2131492976:
        }
        composeEmail();
    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(2130903066);
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
        Typeface localTypeface = Typeface.createFromAsset(getAssets(), "font/Roboto-Regular.ttf");
        this.tvName.setTypeface(localTypeface);
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
        this.mobile.setTypeface(localTypeface);
        this.landline.setTypeface(localTypeface);
        this.email.setTypeface(localTypeface);
        this.address.setTypeface(localTypeface);
        this.state.setTypeface(localTypeface);
        this.city.setTypeface(localTypeface);
        this.company_name.setTypeface(localTypeface);
        this.website.setTypeface(localTypeface);
        this.category.setTypeface(localTypeface);
        this.country.setTypeface(localTypeface);
        this._id = getIntent().getStringExtra("_id");
        loadView();
        this.mobile.setOnClickListener(this);
        this.landline.setOnClickListener(this);
        this.email.setOnClickListener(this);
        Utils.createLocalResourceDirectory(this);
    }

    public boolean onCreateOptionsMenu(Menu paramMenu)
    {
        getMenuInflater().inflate(2131623937, paramMenu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem)
    {
        switch (paramMenuItem.getItemId())
        {
            default:
            case 2131493022:
            case 2131493021:
            case 2131493020:
        }
        while (true)
        {
            return super.onOptionsItemSelected(paramMenuItem);
            Intent localIntent = new Intent(this, EditActivity.class);
            localIntent.putExtra("view_id", this._id);
            startActivity(localIntent);
            continue;
            showDeleteAlert();
            continue;
            share();
        }
    }

    protected void onStart()
    {
        super.onStart();
        loadView();
    }

    // ERROR //
    public void removeContactList()
    {
        // Byte code:
        //   0: aconst_null
        //   1: astore_1
        //   2: aconst_null
        //   3: astore_2
        //   4: new 263	mobilemerit/com/contactmanagement/database/DataBaseHelper
        //   7: dup
        //   8: aload_0
        //   9: invokespecial 266	mobilemerit/com/contactmanagement/database/DataBaseHelper:<init>	(Landroid/content/Context;)V
        //   12: astore_3
        //   13: aload_3
        //   14: invokevirtual 568	mobilemerit/com/contactmanagement/database/DataBaseHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
        //   17: astore_2
        //   18: aload_2
        //   19: new 74	java/lang/StringBuilder
        //   22: dup
        //   23: ldc_w 570
        //   26: invokespecial 88	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   29: aload_0
        //   30: getfield 274	mobilemerit/com/contactmanagement/ViewDetails:_id	Ljava/lang/String;
        //   33: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   36: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   39: invokevirtual 573	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
        //   42: aload_3
        //   43: ifnull +7 -> 50
        //   46: aload_3
        //   47: invokevirtual 574	mobilemerit/com/contactmanagement/database/DataBaseHelper:close	()V
        //   50: aload_2
        //   51: ifnull +7 -> 58
        //   54: aload_2
        //   55: invokevirtual 378	android/database/sqlite/SQLiteDatabase:close	()V
        //   58: return
        //   59: astore 4
        //   61: aload 4
        //   63: invokevirtual 575	android/database/SQLException:printStackTrace	()V
        //   66: aload_1
        //   67: ifnull +7 -> 74
        //   70: aload_1
        //   71: invokevirtual 574	mobilemerit/com/contactmanagement/database/DataBaseHelper:close	()V
        //   74: aload_2
        //   75: ifnull +7 -> 82
        //   78: aload_2
        //   79: invokevirtual 378	android/database/sqlite/SQLiteDatabase:close	()V
        //   82: aload_1
        //   83: ifnull +7 -> 90
        //   86: aload_1
        //   87: invokevirtual 574	mobilemerit/com/contactmanagement/database/DataBaseHelper:close	()V
        //   90: aload_2
        //   91: ifnull -33 -> 58
        //   94: aload_2
        //   95: invokevirtual 378	android/database/sqlite/SQLiteDatabase:close	()V
        //   98: return
        //   99: astore 5
        //   101: aload_1
        //   102: ifnull +7 -> 109
        //   105: aload_1
        //   106: invokevirtual 574	mobilemerit/com/contactmanagement/database/DataBaseHelper:close	()V
        //   109: aload_2
        //   110: ifnull +7 -> 117
        //   113: aload_2
        //   114: invokevirtual 378	android/database/sqlite/SQLiteDatabase:close	()V
        //   117: aload 5
        //   119: athrow
        //   120: astore 5
        //   122: aload_3
        //   123: astore_1
        //   124: goto -23 -> 101
        //   127: astore 4
        //   129: aload_3
        //   130: astore_1
        //   131: goto -70 -> 61
        //
        // Exception table:
        //   from	to	target	type
        //   4	13	59	android/database/SQLException
        //   4	13	99	finally
        //   61	66	99	finally
        //   70	74	99	finally
        //   78	82	99	finally
        //   13	42	120	finally
        //   13	42	127	android/database/SQLException
    }

    public void setReference()
    {
        this.image = ((ImageView)findViewById(2131492966));
        this.tvName = ((TextView)findViewById(2131492998));
        this.mobile = ((EditText)findViewById(2131492970));
        this.landline = ((EditText)findViewById(2131492973));
        this.email = ((EditText)findViewById(2131492976));
        this.address = ((EditText)findViewById(2131492979));
        this.country = ((EditText)findViewById(2131493004));
        this.state = ((EditText)findViewById(2131492985));
        this.city = ((EditText)findViewById(2131492988));
        this.company_name = ((EditText)findViewById(2131492991));
        this.website = ((EditText)findViewById(2131492994));
        this.category = ((EditText)findViewById(2131493010));
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
        this.trMobile = ((TableRow)findViewById(2131492999));
        this.trLandline = ((TableRow)findViewById(2131493000));
        this.trEmail = ((TableRow)findViewById(2131493001));
        this.trAddress = ((TableRow)findViewById(2131493002));
        this.trCountry = ((TableRow)findViewById(2131493003));
        this.trState = ((TableRow)findViewById(2131493005));
        this.trCity = ((TableRow)findViewById(2131493006));
        this.trCompany_name = ((TableRow)findViewById(2131493007));
        this.trWebsite = ((TableRow)findViewById(2131493008));
        this.trCategory = ((TableRow)findViewById(2131493009));
    }

    void showDeleteAlert()
    {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
        localBuilder.setIcon(17301543);
        localBuilder.setTitle("Delete Contact?");
        localBuilder.setMessage("This contact will be deleted");
        localBuilder.setPositiveButton("Delete", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
                ViewDetails.this.removeContactList();
                ViewDetails.this.finish();
            }
        });
        localBuilder.setNegativeButton("Cancel", null);
        localBuilder.show();
    }
}
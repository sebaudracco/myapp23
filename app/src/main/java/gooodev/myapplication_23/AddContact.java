package gooodev.myapplication_23;

import android.content.Intent;
import android.database.Cursor;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import gooodev.myapplication_23.database.DataBaseHelper;

public class AddContact extends ActionBarActivity
{
    static ArrayList<HashMap<String, Object>> list;
    static ArrayList<HashMap<String, Object>> list1;
    private EditText address;
    private Spinner categoryList;
    private EditText city;
    private EditText company_name;
    private Spinner countryList;
    private EditText email;
    private ImageView image;
    private String imageName;
    public InterstitialAd interstitial;
    private EditText landline;
    private Toolbar mToolbar;
    private ArrayList<Map<String, Object>> mapArrayList;
    private EditText mobile;
    private EditText name;
    long rowid;
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
    private EditText website;

    public void getCatgeoryList()
    {
        list1 = new ArrayList();
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
                        SimpleAdapter localSimpleAdapter = new SimpleAdapter(this, list1, 2130903072, new String[] { "category" }, new int[] { 16908308 });
                        this.categoryList.setAdapter(localSimpleAdapter);
                        return;
                    }
                    HashMap localHashMap = new HashMap();
                    localHashMap.put("_id", localCursor.getString(localCursor.getColumnIndex("cat_id")));
                    localHashMap.put("category", localCursor.getString(localCursor.getColumnIndex("category_type")));
                    list1.add(localHashMap);
                    continue;
                }
                catch (Exception localException1)
                {
                }
                label162: localException1.printStackTrace();
            }
        }
        catch (Exception localException2)
        {
            break label162;
        }
    }

    public void getCountryList()
    {
        list = new ArrayList();
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
                        SimpleAdapter localSimpleAdapter = new SimpleAdapter(this, list, 2130903072, new String[] { "c_name" }, new int[] { 16908308 });
                        this.countryList.setAdapter(localSimpleAdapter);
                        return;
                    }
                    HashMap localHashMap = new HashMap();
                    localHashMap.put("id", localCursor.getString(localCursor.getColumnIndex("country_id")));
                    localHashMap.put("c_name", localCursor.getString(localCursor.getColumnIndex("country_name")));
                    list.add(localHashMap);
                    continue;
                }
                catch (Exception localException1)
                {
                }
                label162: localException1.printStackTrace();
            }
        }
        catch (Exception localException2)
        {
            break label162;
        }
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
        File localFile = new File(Utils.LOCAL_RESOURCE_PATH, this.imageName);
        if (localFile.exists())
            localFile.delete();
        if (this.interstitial.isLoaded())
            this.interstitial.show();
        super.onBackPressed();
    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(2130903065);
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
        this.imageName = (new Date().getTime() + ".JPG");
        Utils.createLocalResourceDirectory(this);
        getCountryList();
        getCatgeoryList();
    }

    public boolean onCreateOptionsMenu(Menu paramMenu)
    {
        getMenuInflater().inflate(2131623936, paramMenu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem)
    {
        if (paramMenuItem.getItemId() == 2131493019)
        {
            if ((Utils.validateFields(this.name)) && (Utils.validateFields(this.mobile)))
            {
                long l = saveContactDetails();
                finish();
                if (l > 0L)
                {
                    Intent localIntent = new Intent(this, ViewDetails.class);
                    localIntent.putExtra("_id", l);
                    startActivity(localIntent);
                }
            }
            return true;
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }

    public long saveContactDetails()
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
        localContentValues.put("country", ((Map)this.countryList.getSelectedItem()).get("id").toString());
        localContentValues.put("category_type", ((Map)this.categoryList.getSelectedItem()).get("_id").toString());
        this.rowid = new DataBaseHelper(this).insert(this, "contact_details", localContentValues);
        Log.d("Details", "inserted in to details" + this.rowid);
        return this.rowid;
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
        this.countryList = ((Spinner)findViewById(2131492982));
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
                AddContact.this.showImageUploadOption();
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
                        AddContact.this.startActivityForResult(Utils.pickImage(), 1326);
                        return;
                    case 1:
                }
                AddContact.this.startActivityForResult(Utils.captureImage(AddContact.this.imageName, AddContact.this), 1325);
            }
        });
        localBuilder.show();
    }
}
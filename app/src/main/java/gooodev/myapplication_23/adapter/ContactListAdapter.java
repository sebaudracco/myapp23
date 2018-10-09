package gooodev.myapplication_23.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import mobilemerit.com.contactmanagement.Utils;

public class ContactListAdapter extends ArrayAdapter<HashMap<String, Object>>
{
    private Context context;
    private int imageViewResourceId;
    private ArrayList<HashMap<String, Object>> mapArrayList;
    private int rowResourceId;
    private int textViewResourceId;

    public ContactListAdapter(Context paramContext, int paramInt1, int paramInt2, int paramInt3, ArrayList<HashMap<String, Object>> paramArrayList)
    {
        super(paramContext, paramInt1, paramArrayList);
        this.context = paramContext;
        this.rowResourceId = paramInt1;
        this.imageViewResourceId = paramInt2;
        this.textViewResourceId = paramInt3;
        this.mapArrayList = paramArrayList;
    }

    public HashMap<String, Object> getItem(int paramInt)
    {
        return (HashMap)this.mapArrayList.get(paramInt);
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
        View localView = ((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(this.rowResourceId, null);
        Holder localHolder;
        if (localView != null)
        {
            localHolder = new Holder(null);
            ImageView localImageView = (ImageView)localView.findViewById(this.imageViewResourceId);
            TextView localTextView = (TextView)localView.findViewById(this.textViewResourceId);
            localTextView.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "font/Roboto-Regular.ttf"));
            localHolder.imageView = localImageView;
            localHolder.textView = localTextView;
            localView.setTag(localHolder);
        }
        while (true)
        {
            HashMap localHashMap = (HashMap)this.mapArrayList.get(paramInt);
            localHolder.textView.setText(localHashMap.get("name").toString());
            try
            {
                localHolder.imageView.setImageBitmap(BitmapFactory.decodeFile(Utils.LOCAL_RESOURCE_PATH + localHashMap.get("image").toString()));
                return localView;
                localHolder = (Holder)localView.getTag();
            }
            catch (Exception localException)
            {
                localException.printStackTrace();
            }
        }
        return localView;
    }

    private class Holder
    {
        ImageView imageView;
        TextView textView;

        private Holder()
        {
        }
    }
}

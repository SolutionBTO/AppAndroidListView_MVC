package br.solutionbto.control;

import java.util.List;

import br.solutionbto.model.Country;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Adapter "is model of Listview"
 * @author Roberto Silva
 *
 */
public class MainListViewAdapter extends BaseAdapter {
	

	private int[] mIds;
    private int[] mLayouts;
    private LayoutInflater mInflater;
    private List<Country> mContent;
	
	public MainListViewAdapter(Context context, int[] itemLayouts, int[] itemIDs, List<Country> content) {
    	init(context,itemLayouts,itemIDs, content);
    }

	/**
	 * inicialize all components of class
	 * @param context
	 * @param layouts
	 * @param ids
	 * @param content
	 */
    private void init(Context context, int[] layouts, int[] ids, List<Country> content) {
    	// Cache the LayoutInflate to avoid asking for a new one each time.
    	mInflater = LayoutInflater.from(context);
    	mIds = ids;
    	mLayouts = layouts;
    	mContent = content;
    }

	@Override
	public int getCount() {
		return mContent.size();
	}

	@Override
	public Object getItem(int position) {
		return mContent.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	 public View getView(int position, View convertView, ViewGroup parent) {
        // A ViewHolder keeps references to children views to avoid unneccessary calls to findViewById() on each row.
        ViewHolder holder;

        // When convertView is not null, we can reuse it directly, there is no need
        // to reinflate it. We only inflate a new View when the convertView supplied
        // by ListView is null.
        if (convertView == null) {
            convertView = mInflater.inflate(mLayouts[0], null);
            
            // Creates a ViewHolder and store references to the two children views we want to bind data to.
            holder = new ViewHolder();
            holder.text=new TextView[mIds.length];
            
            for(int i=0;i<holder.text.length;i++){
               holder.text[i] = (TextView) convertView.findViewById(mIds[i]);
            }
            
            convertView.setTag(holder);
        } else {
            // Get the ViewHolder back to get fast access to the TextView
            holder = (ViewHolder) convertView.getTag();
        }

        // Bind the data efficiently with the holder.
        holder.text[0].setText(mContent.get(position).getCode());
        holder.text[1].setText(mContent.get(position).getCountry());
        holder.text[2].setText(mContent.get(position).getLanguage());
        
        return convertView;
    }

	static class ViewHolder {
        TextView text[];
    }
	
}

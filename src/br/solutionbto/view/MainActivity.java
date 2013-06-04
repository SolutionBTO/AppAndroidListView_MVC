package br.solutionbto.view;

import java.util.List;

import br.solutionbto.control.CountryData;
import br.solutionbto.control.MainListViewAdapter;
import br.solutionbto.model.Country;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Example of Activity with Listview
 * ListView with Adapter and layout itens
 * @author Roberto Silva
 *
 */
public class MainActivity extends Activity {
	
	private ListView listView;
	private List<Country> countries;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView=(ListView)findViewById(R.id.main_listview);
				
		CountryData obj = new CountryData();
		countries=obj.getListOfCountries();
		
		//criando o adapter do ListView/create the adapter of ListView
		MainListViewAdapter listViewAdapter=
				new MainListViewAdapter(
						this,
						new int[]{R.layout.main_listview_itens},
						new int[]{
								R.id.listview_item_textView1,
								R.id.listview_item_textView2,
								R.id.listview_item_textView3},
								countries);
		
		//setando adapter/set adapter
		listView.setAdapter(listViewAdapter);
		
		//evento do ListView/Event of ListView
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				//exibe CountryBean/display CountryBean
				Toast.makeText(MainActivity.this, countries.get(position).toString(), Toast.LENGTH_LONG).show();
			}
			
		});
	}
}

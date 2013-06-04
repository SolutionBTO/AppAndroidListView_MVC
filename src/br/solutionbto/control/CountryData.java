package br.solutionbto.control;

//Fonte: http://www.mkyong.com/java/display-a-list-of-countries-in-java/
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import br.solutionbto.model.Country;

public class CountryData {
	private Map<String, String> languagesMap = new TreeMap<String, String>();
	
	public CountryData() {
		initLanguageMap();
	}

	public List<Country> getListOfCountries() {
		List<Country> countryList=new ArrayList<Country>();
		String[] countries = Locale.getISOCountries();
		Country country=null;
		
		for (String countryCode : countries) {
			Locale obj = null;
			country=new Country();
			
			if (languagesMap.get(countryCode) == null) {
				obj = new Locale("", countryCode);
			} else {
				//create a Locale with own country's languages
				obj = new Locale(languagesMap.get(countryCode), countryCode);
			}
			
			country.setCode(obj.getCountry()); 
			country.setCountry(obj.getDisplayCountry());
			country.setLanguage(obj.getDisplayLanguage());
			
			countryList.add(country);
		}
		return countryList;
	}

	// create Map with country code and languages
	public void initLanguageMap() {
		Locale[] locales = Locale.getAvailableLocales();
		for (Locale obj : locales) {
			if ((obj.getDisplayCountry() != null) && (!"".equals(obj.getDisplayCountry()))) {
				languagesMap.put(obj.getCountry(), obj.getLanguage());
			}
		}
	}
}

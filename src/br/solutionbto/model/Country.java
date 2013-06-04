package br.solutionbto.model;

/**
 * class type Bean Java
 * @author Roberto Silva
 *
 */
public class Country {
  private String code;
  private String country;
  private String language;
/**
 * @return the code
 */
public String getCode() {
	return code;
}
/**
 * @param code the code to set
 */
public void setCode(String code) {
	this.code = code;
}
/**
 * @return the country
 */
public String getCountry() {
	return country;
}
/**
 * @param country the country to set
 */
public void setCountry(String country) {
	this.country = country;
}
/**
 * @return the language
 */
public String getLanguage() {
	return language;
}
/**
 * @param language the language to set
 */
public void setLanguage(String language) {
	this.language = language;
}
  /**
   * display datas
   */
@Override
	public String toString() {
		return "Code:"+code+"\nCountry:"+country+"\nLanguage:"+language;
	}
  
}

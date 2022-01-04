
package fahmi.penerbangan.libs;

import java.util.prefs.Preferences;

public class Pref {
    
    
    public void reset(){
        Preferences pref = Preferences.userNodeForPackage(Pref.class);
        pref.put("user", "");
        pref.put("level", "");
    }
    
    public void save(String username, String level){
        Preferences pref = Preferences.userNodeForPackage(Pref.class);
        pref.put("user", username);
        pref.put("level", level);
    }
    
    public String getUser(){
        Preferences pref = Preferences.userNodeForPackage(Pref.class);
        return pref.get("user", "");
    }
    
    public String getLevel(){
        Preferences pref = Preferences.userNodeForPackage(Pref.class);
        return pref.get("level", "");
    }
}

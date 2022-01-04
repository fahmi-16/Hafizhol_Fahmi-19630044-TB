package fahmi.penerbangan;

import fahmi.penerbangan.db.MyConnection;
import fahmi.penerbangan.form.BerangkatForm;
import fahmi.penerbangan.form.CariPenerbanganForm;
import fahmi.penerbangan.form.LoginForm;
import fahmi.penerbangan.form.MenuForm;
import fahmi.penerbangan.form.PenerbanganForm;
import fahmi.penerbangan.form.PesawatForm;
import fahmi.penerbangan.libs.Pref;

public class Main {
    public static void main(String[] args) {
//        coba Koneksi
        MyConnection mc = new MyConnection();
        mc.getConnection();
        
//        COBA PANGGIL FORM PESAWAT
//        new PesawatForm().setVisible(true);
        
//        COBA PANGGIL FORM PENERBANGAN
//        new PenerbanganForm().setVisible(true);

//        COBA PANGGIL FORM Berangkat
//        new BerangkatForm().setVisible(true);
        
//        COBA PANGGIL FORM CARI PENERBANGAN
//        new CariPenerbanganForm().setVisible(true);

//        COBA PANGGIL LOGIN
//        new LoginForm().setVisible(true);
        
//        Coba Pakai Perf
        Pref pref = new Pref();
        String username = pref.getUser();
        if(username.equals("")){
            LoginForm loginform = new LoginForm();
            loginform.setVisible(true);
        } else {
            MenuForm menuform =  new MenuForm();
            menuform.setLevel(pref.getLevel());
            menuform.setUser(pref.getUser());
            menuform.setVisible(true);
        }
    }
}

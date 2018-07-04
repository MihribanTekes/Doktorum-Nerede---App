package com.mihribantekes.navigationapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity
        implements AcilTipFragment.OnFragmentInteractionListener, NavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView = null;
    Toolbar toolbar = null;

    public void onFragmentInteraction(Uri uri)
    {

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // actvity main layout başladığında istenilen fragment çağırma
        MainFragment fragment = new MainFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction =
                getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,fragment);
        fragmentTransaction.commit();
        fragment.getFragmentManager();


        //NAV. Drawer ın otomatik oluşturulan kodları

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView  = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        //menu deki baslangıç ikonuna tıklanırsa açılacak fragment çağrımı
        if (id == R.id.baslangic) {

            MainFragment fragment = new MainFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();

        } else if (id == R.id.hastane_bilgileri) { //menu deki Hastane Bilgileri butonuna tıklanırsa açılacak fragment çağrımı

            HastaneFragment fragment = new HastaneFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();

        } else if (id == R.id.acil_tip) { //menu deki Acil Tıp ikonuna tıklanırsa açılacak fragment çağrımı

            AcilTipFragment fragment = new AcilTipFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();



        } else if (id == R.id.anestezi) { //menu deki Anestezi ikonuna tıklanırsa açılacak fragment çağrımı
            AnesteziFragment fragment = new AnesteziFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();

        } else if (id == R.id.beyin_cerrahi) { //menu deki Beyin Cerrahi ikonuna tıklanırsa açılacak fragment çağrımı
            BeyinCerrahiFragment fragment = new BeyinCerrahiFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();


        } else if (id == R.id.biyokimya) { ////menu deki biyokimya ikonuna tıklanırsa açılacak fragment çağrımı
            BiyokimyaFragment fragment = new BiyokimyaFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();

        } else if (id == R.id.cildiye) { //menu deki Cildiye ikonuna tıklanırsa açılacak fragment çağrımı
            CildiyeFragment fragment = new CildiyeFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();

        } else if(id == R.id.dahiliye) {//menu deki Dahiliye ikonuna tıklanırsa açılacak fragment çağrımı

            DahiliyeFragment fragment = new DahiliyeFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();

        }else if (id == R.id.cocuk_cerrahi) {//menu deki Çocuk Cerrahi ikonuna tıklanırsa açılacak fragment çağrımı
            CocukCerrahiFragment fragment = new CocukCerrahiFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();

        }else if (id == R.id.cocuk_hastaliklari) { //menu deki Çocuk Hastalıları ikonuna tıklanırsa açılacak fragment çağrımı
            CocukHastaliklariFragment fragment = new CocukHastaliklariFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();

        }else if (id == R.id.cocuk_psikoloji) { //menu deki Çocuk Psikolojisi ikonuna tıklanırsa açılacak fragment çağrımı
            CocukPsikolojisiFragment fragment = new CocukPsikolojisiFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();

        }else if (id == R.id.endokrin) { //menu deki Endokrin ikonuna tıklanırsa açılacak fragment çağrımı
            EndokrinFragment fragment = new EndokrinFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();

        }else if (id == R.id.enfeksiyon) { //menu deki Enfeksiyon ikonuna tıklanırsa açılacak fragment çağrımı
            EnfeksiyonFragment fragment = new EnfeksiyonFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();

        }else if (id == R.id.ftr) { //menu deki Ftr ikonuna tıklanırsa açılacak fragment çağrımı
            FtrFragment fragment = new FtrFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();

        }else if (id == R.id.gastroloji) { //menu deki Gastroloji ikonuna tıklanırsa açılacak fragment çağrımı
            GastrolojiFragment fragment = new GastrolojiFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();

        }else if (id == R.id.genel_cerrahi) { //menu deki Genel Cerrahi ikonuna tıklanırsa açılacak fragment çağrımı
            GenelCerrahiFragment fragment = new GenelCerrahiFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();

        }else if (id == R.id.gogus_cerrahi) { //menu deki Göğüs Cerrahi ikonuna tıklanırsa açılacak fragment çağrımı
            GogusCerrahiFragment fragment = new GogusCerrahiFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();

        }else if (id == R.id.gogus_hastaliklari) { //menu deki Göğüs Hastalıkları ikonuna tıklanırsa açılacak fragment çağrımı
            GogusHastaliklariFragment fragment = new GogusHastaliklariFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();

        }else if (id == R.id.goz_hastaliklari) { //menu deki Göz Hastalıkları ikonuna tıklanırsa açılacak fragment çağrımı
            GozHastaliklariFragment fragment = new GozHastaliklariFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();

        }else if (id == R.id.hematoloji) { //menu deki Hematoloji ikonuna tıklanırsa açılacak fragment çağrımı
            HematolojiFragment fragment = new HematolojiFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();

        }else if (id == R.id.kadin_dogum) {//menu deki Kadın Doğum ikonuna tıklanırsa açılacak fragment çağrımı
            KadinDogumFragment fragment = new KadinDogumFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();


        }else if (id == R.id.kalp_damar_cerrahi) { //menu deki Kalp Damar Cerrahi ikonuna tıklanırsa açılacak fragment çağrımı
            KalpDamarCerrahiFragment fragment = new KalpDamarCerrahiFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();

        }else if (id == R.id.kardiyoloji) { //menu deki Kardiyoloji ikonuna tıklanırsa açılacak fragment çağrımı
            KardiyolojiFragment fragment = new KardiyolojiFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();


        }else if (id == R.id.kbb) { //menu deki KBB ikonuna tıklanırsa açılacak fragment çağrımı
            KbbFragment fragment = new KbbFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();

        }else if (id == R.id.mikrobiyoloji) {//menu deki mikrobiyoloji ikonuna tıklanırsa açılacak fragment çağrımı
            MikrobiyolojiFragment fragment = new MikrobiyolojiFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();

        }else if (id == R.id.nefroloji) { //menu deki Nefroloji ikonuna tıklanırsa açılacak fragment çağrımı
            NefrolojiFragment fragment = new NefrolojiFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();

        }else if (id == R.id.noroloji) { //menu deki Noroloji ikonuna tıklanırsa açılacak fragment çağrımı
            NorolojiFragment fragment = new NorolojiFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();

        }else if (id == R.id.nukleer_tip) { //menu deki Nukleer Tıp ikonuna tıklanırsa açılacak fragment çağrımı
            NukleerTipFragment fragment = new NukleerTipFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();

        }else if (id == R.id.onkoloji) {//menu deki onkoloji ikonuna tıklanırsa açılacak fragment çağrımı
            OnkolojiFragment fragment = new OnkolojiFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();

        }else if (id == R.id.ortopedi) { //menu deki ortopedi ikonuna tıklanırsa açılacak fragment çağrımı
            OrtopediFragment fragment = new OrtopediFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();

        }else if (id == R.id.patoloji) { //menu deki patoloji ikonuna tıklanırsa açılacak fragment çağrımı
            PatolojiFragment fragment = new PatolojiFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();

        }else if (id == R.id.plastik_cerrahi) { //menu deki Plastik cerrahi ikonuna tıklanırsa açılacak fragment çağrımı
            PlastikCerrahiFragment fragment = new PlastikCerrahiFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();

        }else if (id == R.id.pratisyen) { //menu deki pratisyen ikonuna tıklanırsa açılacak fragment çağrımı
            PratisyenFragment fragment = new PratisyenFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();

        }else if (id == R.id.psikiyatri) { //menu deki psikiyatri ikonuna tıklanırsa açılacak fragment çağrımı
            PsikiyatriFragment fragment = new PsikiyatriFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();

        }else if (id == R.id.radyoloji) { //menu deki radyoloji ikonuna tıklanırsa açılacak fragment çağrımı
            RadyolojiFragment fragment = new RadyolojiFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();

        }else if (id == R.id.uroloji) { //menu deki uroloji ikonuna tıklanırsa açılacak fragment çağrımı
            UrolojiFragment fragment = new UrolojiFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();


        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
